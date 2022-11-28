package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.ArticleDto;
import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToDeleteException;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.mapper.ArticleMapper;
import com.arthur.fr.rugbyvitre.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/v1/articles")
public class ArticleApi {

    private final ArticleService articleService;

    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleApi(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ArticleDto>> getAll() {
        return ResponseEntity.ok(
                this.articleService.getAll().stream()
                        .map(this.articleMapper::mapToDto)
                        .toList());
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleDto> getById(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(this.articleMapper
                    .mapToDto(this.articleService.getById(id)));
        } catch (UnknownRessourceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
    )
    public ResponseEntity<ArticleDto> createArticle(@RequestBody final ArticleDto articleDto) throws NoSuchAlgorithmException {
        ArticleDto articleDtoResponce =
                this.articleMapper.mapToDto(
                        this.articleService.createArticle(
                                this.articleMapper.mapToModel(articleDto)
                        ));

        return ResponseEntity
                .created(URI.create("/v1/articles/" + articleDtoResponce.getId()))
                .body(articleDtoResponce);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable final Integer id) {
        try {
            this.articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
        } catch (UnknownRessourceException ure) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ure.getMessage());
        } catch (NotAllowedToDeleteException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
    }

}
