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
    private Integer id;
    private String name;
}

