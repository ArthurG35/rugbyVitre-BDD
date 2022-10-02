package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.PartenaireDto;
import com.arthur.fr.rugbyvitre.model.Partenaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PartenaireMapper {

    @Mapping(target = "id", source = "id")
    PartenaireDto mapToDto(Partenaire partenaire);

    @Mapping(target = "id", source = "id")
    Partenaire mapToModel(PartenaireDto partenaireDto);
}
