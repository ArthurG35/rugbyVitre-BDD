package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {

    @Query(value = "select j from Joueur j where j.equipe = ?1")
    List<Joueur> findByEquipe(Integer equipeId);
}
