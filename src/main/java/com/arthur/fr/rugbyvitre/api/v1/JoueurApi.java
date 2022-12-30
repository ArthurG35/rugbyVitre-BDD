package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.mapper.JoueurMapper;
import com.arthur.fr.rugbyvitre.model.Joueur;
import com.arthur.fr.rugbyvitre.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/byequipe/{equipeId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JoueurDto>> getJoueursByEquipeName(@PathVariable("equipeId") Integer equipeId) {
        return ResponseEntity.ok(
                this.joueurService.getJoueursByEquipeId(equipeId).stream().sorted(Comparator.comparingInt(Joueur::getPlacement))
                        .map(this.joueurMapper::mapToDto)
                        .toList());
    }

}
