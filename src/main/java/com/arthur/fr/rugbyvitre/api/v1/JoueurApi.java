package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.mapper.JoueurMapper;
import com.arthur.fr.rugbyvitre.service.JoueurService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/joueurs")
public class JoueurApi {



    private final JoueurService joueurService;
    private final JoueurMapper joueurMapper;

    public JoueurApi(JoueurService joueurService, JoueurMapper joueurMapper) {
        this.joueurService = joueurService;
        this.joueurMapper = joueurMapper;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Return all players")
    public ResponseEntity<List<JoueurDto>> getAll(){
        return ResponseEntity.ok(
                this.joueurService.getAll().stream().map(this.joueurMapper::mapToDto).toList());

    }
}
