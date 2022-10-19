package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.SizeShopDto;
import com.arthur.fr.rugbyvitre.mapper.SizeShopMapper;
import com.arthur.fr.rugbyvitre.service.SizeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/sizeshop")
public class SizeShopApi {

    private final SizeShopService sizeShopService;

    private final SizeShopMapper sizeShopMapper;

    @Autowired
    public SizeShopApi(SizeShopService sizeShopService, SizeShopMapper sizeShopMapper) {
        this.sizeShopService = sizeShopService;
        this.sizeShopMapper = sizeShopMapper;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SizeShopDto>> getAll() {
        return ResponseEntity.ok(
                this.sizeShopService.getAll().stream()
                        .map(this.sizeShopMapper::mapToDto)
                        .toList());
    }

    @GetMapping(value = "/{sizeId}")
    public ResponseEntity<SizeShopDto> getById(@PathVariable final Integer sizeId) {
        return ResponseEntity.ok(
                this.sizeShopMapper.mapToDto(
                        this.sizeShopService.getById(sizeId)));

    }

}
