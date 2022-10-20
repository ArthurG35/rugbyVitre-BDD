package com.arthur.fr.rugbyvitre.api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDto {
    private Integer id;
    private String name;
    private byte[] image;
    private Double prix;
    private List<Integer> sizeShopIds;

}
