package com.arthur.fr.rugbyvitre.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private String key;
}
