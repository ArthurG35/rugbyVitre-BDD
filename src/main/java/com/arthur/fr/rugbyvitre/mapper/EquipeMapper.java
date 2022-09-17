package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.EquipeDto;
import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.model.Equipe;
import com.arthur.fr.rugbyvitre.model.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(componentModel = "spring")
public interface EquipeMapper {

    @Mapping(target = "id", source = "id")
    EquipeDto mapToDto(Equipe equipe);

    @Mapping(target = "id", source = "id")
    Equipe mapToModel(EquipeDto equipeDto);
}
