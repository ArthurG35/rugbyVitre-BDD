package com.arthur.fr.rugbyvitre.api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeShopDto {
    private Integer id;
    private String sizeExiste;
    private List<Integer> articleIds;
}
