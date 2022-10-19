package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.ArticleDto;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.mapper.ArticleMapper;
import com.arthur.fr.rugbyvitre.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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


}
