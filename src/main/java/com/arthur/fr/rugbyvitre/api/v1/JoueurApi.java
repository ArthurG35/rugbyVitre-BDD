package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToCreateException;
import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToDeleteException;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.mapper.JoueurMapper;
import com.arthur.fr.rugbyvitre.model.Joueur;
import com.arthur.fr.rugbyvitre.service.JoueurService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/v1/joueurs")
public class JoueurApi {


    @Autowired
    private final JoueurService joueurService;
    @Autowired
    private final JoueurMapper joueurMapper;

    @Autowired
    public JoueurApi(JoueurService joueurService, JoueurMapper joueurMapper) {
        this.joueurService = joueurService;
        this.joueurMapper = joueurMapper;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JoueurDto>> getAll() {
        return ResponseEntity.ok(
                this.joueurService.getAll().stream()
                        .map(this.joueurMapper::mapToDto)
                        .toList());
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JoueurDto> getById(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(this.joueurMapper
                    .mapToDto(this.joueurService.getById(id)));
        } catch (UnknownRessourceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path = "/byequipe/{equipeId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JoueurDto>> getJoueursByEquipeName(@PathVariable("equipeId") Integer equipeId) {
        return ResponseEntity.ok(
                this.joueurService.getJoueursByEquipeId(equipeId).stream().sorted(Comparator.comparingInt(Joueur::getPlacement))
                        .map(this.joueurMapper::mapToDto)
                        .toList());
    }
    @PutMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE} )
    @Operation(summary = "updateJoueur")
    public ResponseEntity<JoueurDto> updateJoueur(@RequestBody JoueurDto joueur, @PathVariable Integer id){
        try{
            joueur.setId(id);
            JoueurDto joueurDto= joueurMapper.mapToDto(joueurService.updateJoueur(joueurMapper.mapToModel(joueur)));
            return ResponseEntity.ok(joueurDto);
        }catch (NotAllowedToCreateException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
    )
    public ResponseEntity<JoueurDto> createUser(@RequestBody final JoueurDto joueurDto) {

        JoueurDto joueurDtoResponse =
                this.joueurMapper.mapToDto(
                        this.joueurService.createJoueur(
                                this.joueurMapper.mapToModel(joueurDto)
                        ));

        return ResponseEntity
                .created(URI.create("/v1/joueurs/" + joueurDtoResponse.getId()))
                .body(joueurDtoResponse);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable final Integer id) {
        try {
            this.joueurService.deleteJoueur(id);
            return ResponseEntity.noContent().build();
        } catch (UnknownRessourceException ure) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ure.getMessage());
        } catch (NotAllowedToDeleteException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
    }


}
