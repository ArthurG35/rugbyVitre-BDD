package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {

}
