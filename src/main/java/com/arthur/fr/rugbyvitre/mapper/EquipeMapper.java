package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.EquipeDto;
import com.arthur.fr.rugbyvitre.model.Equipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EquipeMapper {

    @Mapping(target = "id", source = "id")
    EquipeDto mapToDto(Equipe equipe);

    @Mapping(target = "id", source = "id")
    Equipe mapToModel(EquipeDto equipeDto);
}
