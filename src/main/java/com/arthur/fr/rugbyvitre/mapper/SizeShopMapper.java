package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.SizeShopDto;
import com.arthur.fr.rugbyvitre.model.Article;
import com.arthur.fr.rugbyvitre.model.SizeShop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SizeShopMapper {

    @Mapping(target = "articleIds", expression = "java(getArticlesIds(sizeShop))")
    @Mapping(target = "id", source = "id")
    SizeShopDto mapToDto(SizeShop sizeShop);

    default List<Integer> getArticlesIds(SizeShop sizeShop){
        List<Integer> articleIds = new ArrayList<>();
        if(sizeShop.getArticles() != null){
            articleIds = sizeShop.getArticles().stream().map(Article::getId).toList();
        }
        return articleIds;
    }


    @Mapping(target = "id", source = "id")
    SizeShop mapToModel(SizeShopDto sizeShopDto);
}
