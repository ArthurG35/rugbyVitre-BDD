package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.PartenaireDto;
import com.arthur.fr.rugbyvitre.mapper.PartenaireMapper;
import com.arthur.fr.rugbyvitre.service.PartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/partenaires")
public class PartenaireApi {
    @Autowired
    private final PartenaireService partenaireService;
    @Autowired
    private final PartenaireMapper partenaireMapper;

    @Autowired
    public PartenaireApi(PartenaireService partenaireService, PartenaireMapper partenaireMapper) {
        this.partenaireService = partenaireService;
        this.partenaireMapper = partenaireMapper;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PartenaireDto>> getAll() {
        return ResponseEntity.ok(
                this.partenaireService.getAll().stream()
                        .map(this.partenaireMapper::mapToDto)
                        .toList());

    }
}
