package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    Article getById(Integer id);
}
