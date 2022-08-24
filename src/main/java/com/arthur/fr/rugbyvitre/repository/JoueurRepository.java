package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {

    @Override
    List<Joueur> findAllById(Iterable<Integer> integers);
}
