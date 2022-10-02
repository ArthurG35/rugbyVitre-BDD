package com.arthur.fr.rugbyvitre.api.dto;

import com.arthur.fr.rugbyvitre.enumeration.Importance;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartenaireDto {
    private Integer id;
    private String name;
    private String path;
    private Importance importance;
}
