package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.JoueurDto;
import com.arthur.fr.rugbyvitre.model.Equipe;
import com.arthur.fr.rugbyvitre.model.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface JoueurMapper {

    @Mapping(target = "equipeId", expression = "java(getEquipeId(joueur))")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "poste", source = "poste")
    JoueurDto mapToDto(Joueur joueur);


    default Integer getEquipeId(Joueur joueur) {
        return joueur.getEquipe() != null ? joueur.getEquipe().getId() : null;
    }

    default Equipe getEquipe(JoueurDto joueurDto) {
        return joueurDto.getEquipeId() != null ? new Equipe(joueurDto.getEquipeId()) : null;
    }

    @Mapping(target = "equipe", expression = "java(getEquipe(joueurDto))")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "poste", source = "poste")
    Joueur mapToModel(JoueurDto joueurDto);


}
