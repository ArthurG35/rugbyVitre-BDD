package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
