package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.model.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface JoueurMapper {

    @Mapping(target = "id", source = "id")
    JoueurDto mapToDto(Joueur joueur);
    @Mapping(target = "id", source = "id")
    Joueur mapToModel(JoueurDto joueurDto);


}
