package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.model.Article;
import com.arthur.fr.rugbyvitre.repository.ArticleRepository;
import com.arthur.fr.rugbyvitre.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public  Article getById(Integer id) {
        return articleRepository.findById(id).orElseThrow(() -> new UnknownRessourceException("No Article was found for this ID"));
    }

    @Override
    public Article createArticle(Article article) {
        return this.articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        Article articleToDelete = this.getById(id);
        this.articleRepository.delete(articleToDelete);
    }

}
