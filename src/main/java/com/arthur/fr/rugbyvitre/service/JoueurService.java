package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.Joueur;

import java.util.Collection;
import java.util.List;

public interface JoueurService {

    List<Joueur> getAll();

    List<Joueur> getJoueursByEquipeId(Integer equipeId);

    Joueur getById(Integer id);

    Joueur createJoueur(Joueur joueur);

    Joueur updateJoueur(Joueur joueur);

    void deleteJoueur(Integer id);

}
