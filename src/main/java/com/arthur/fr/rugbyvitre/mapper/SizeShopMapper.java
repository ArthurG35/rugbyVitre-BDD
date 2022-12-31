package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.SizeShopDto;
import com.arthur.fr.rugbyvitre.model.Article;
import com.arthur.fr.rugbyvitre.model.SizeShop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public interface SizeShopMapper {

    @Mapping(target = "articleIds", expression = "java(getArticlesIds(sizeShop))")
    @Mapping(target = "id", source = "id")
    SizeShopDto mapToDto(SizeShop sizeShop);

    default List<Integer> getArticlesIds(SizeShop sizeShop){
        return sizeShop.getArticles() != null ? sizeShop.getArticles().stream().map(Article::getId).collect(Collectors.toList()) : Collections.emptyList();
    }

    default List<Article> getArticles(SizeShopDto sizeShopDto){
        return sizeShopDto.getArticleIds() != null ? sizeShopDto.getArticleIds().stream().map(Article::new).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Mapping(target = "articles", expression = "java(getArticles(sizeShopDto))")
    @Mapping(target = "id", source = "id")
    SizeShop mapToModel(SizeShopDto sizeShopDto);
}
