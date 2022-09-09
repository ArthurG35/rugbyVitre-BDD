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

    @Mapping(target = "joueursIds",  expression = "java(getJoueursIds(joueur))")
    @Mapping(target = "id", source = "id")
    EquipeDto mapToDto(Equipe equipe);

    default List<Integer> getJoueursIds(Equipe equipe) {
        List<Integer> joueurIds = new ArrayList<>();
        if(equipe.getJoueurs() != null) {
            joueurIds = equipe.getOrders().stream()
                    .map(Joueur::getId)
                    .toList();
        }
        return joueurIds;
    }

    default Set<Equipe> getJoueurs(EquipeDto equipeDto) {
        Set<Joueur> joueurs = new HashSet<>();
        if (equipeDto.getOrdersIds() != null) {
            equipeDto.getOrdersIds().stream()
                    .map(order -> orders.add(new Joueur(joueurs)));
        }
        return joueurs;
    }

    @Mapping(target = "id", source = "id")
    Equipe mapToModel(EquipeDto equipeDto);
}
