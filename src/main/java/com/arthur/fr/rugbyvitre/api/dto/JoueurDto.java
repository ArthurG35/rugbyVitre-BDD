package com.arthur.fr.rugbyvitre.api.dto;

import com.arthur.fr.rugbyvitre.enumeration.Poste;
import com.arthur.fr.rugbyvitre.model.Equipe;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoueurDto {
    private Integer id;
    private Integer age;
    private String prenom;
    private String nom;
    private Integer placement;
    private Poste poste;
    private Equipe equipeId;
}
