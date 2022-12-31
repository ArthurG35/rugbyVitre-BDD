package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.ArticleDto;
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
public interface ArticleMapper {

    @Mapping(target = "sizeShopIds", expression = "java(getSizeIds(article))")
    @Mapping(target = "id", source = "id")
    ArticleDto mapToDto(Article article);

    default List<Integer> getSizeIds(Article article) {
        return article.getSizeShops() != null ? article.getSizeShops().stream().map(SizeShop::getId).collect(Collectors.toList()) : Collections.emptyList();
    }

    default List<SizeShop> getArticle(ArticleDto articleDto) {
        return articleDto.getSizeShopIds() != null ? articleDto.getSizeShopIds().stream().map(SizeShop::new).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Mapping(target = "sizeShops", expression = "java(getArticle(articleDto))")
    @Mapping(target = "id", source = "id")
    Article mapToModel(ArticleDto articleDto);
}