package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.EquipeDto;
import com.arthur.fr.rugbyvitre.mapper.EquipeMapper;
import com.arthur.fr.rugbyvitre.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/equipes")
public class EquipeApi {
    @Autowired
    private final EquipeService equipeService;
    @Autowired
    private final EquipeMapper equipeMapper;
    @Autowired
    public EquipeApi(EquipeService equipeService, EquipeMapper equipeMapper) {
        this.equipeService = equipeService;
        this.equipeMapper = equipeMapper;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EquipeDto>> getAll() {
        return ResponseEntity.ok(
                this.equipeService.getAll().stream()
                        .map(this.equipeMapper::mapToDto)
                        .toList());

    }

    @GetMapping(path = "/equipevisibility/{visibility}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EquipeDto>> getEquipesByVisibilityIs(@PathVariable("visibility") Boolean visibility){
        return ResponseEntity.ok(
                this.equipeService.getEquipesByVisibilityIs(visibility)
                        .stream()
                        .map(this.equipeMapper::mapToDto)
                        .toList());
    };

    @GetMapping(path = "/equipe/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EquipeDto>> getEquipeById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(
                this.equipeService.getEquipeById(id)
                        .stream()
                        .map(this.equipeMapper::mapToDto)
                        .toList());
    }
}
