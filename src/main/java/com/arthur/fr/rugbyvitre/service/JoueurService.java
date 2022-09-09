package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.Joueur;

import java.util.List;

public interface JoueurService {

    List<Joueur> getAll();

    List<Joueur> getJoueurByEquipe(Integer i);

    Joueur getById(Integer id);

    Joueur createJoueur(Joueur joueur);

    Joueur updateJoueur(Joueur joueur);

    void deleteJoueur(Integer id);
}
