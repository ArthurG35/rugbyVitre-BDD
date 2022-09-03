package com.arthur.fr.rugbyvitre.api.dto;

import com.arthur.fr.rugbyvitre.enumeration.Poste;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoueurDto {
    private Integer id;
    private Integer age;
    private String prenom;
    private String nom;
    private Poste poste;
}
