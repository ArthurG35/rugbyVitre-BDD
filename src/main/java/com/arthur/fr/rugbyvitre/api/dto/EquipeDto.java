package com.arthur.fr.rugbyvitre.api.dto;

import com.arthur.fr.rugbyvitre.model.Joueur;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipeDto {
    private int id;
    private String name;
    private List<Integer> joueursIds;
}
