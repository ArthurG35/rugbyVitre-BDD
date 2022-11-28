package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.ArticleDto;
import com.arthur.fr.rugbyvitre.model.Article;
import com.arthur.fr.rugbyvitre.model.SizeShop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "sizeShopIds", expression = "java(getSizeIds(article))")
    @Mapping(target = "id", source = "id")
    ArticleDto mapToDto(Article article);

    default List<Integer> getSizeIds(Article article){
        List<Integer> sizes = new ArrayList<>();
        if(article.getSizeShops() != null){
            sizes = article.getSizeShops().stream().map(SizeShop::getId).toList();
        }
        return sizes;
    }

    default List<SizeShop> getArticle(ArticleDto articleDto){
        List<SizeShop> sizeShops = new ArrayList<>();
        if(articleDto.getSizeShopIds() != null){
            sizeShops = articleDto.getSizeShopIds().stream().map(SizeShop::new).toList();
        }
        return sizeShops;
    }

    @Mapping(target = "sizeShops", expression = "java(getArticle(articleDto))")
    @Mapping(target = "id", source = "id")
    Article mapToModel(ArticleDto articleDto);
}