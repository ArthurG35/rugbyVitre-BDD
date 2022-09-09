package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.model.Joueur;
import com.arthur.fr.rugbyvitre.repository.JoueurRepository;
import com.arthur.fr.rugbyvitre.service.JoueurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;

    public JoueurServiceImpl(JoueurRepository joueurRepository){
        this.joueurRepository = joueurRepository;
    }
    @Override
    public List<Joueur> getAll() {
        return joueurRepository.findAll();
    }

    @Override
    public List<Joueur> getJoueurByEquipe(Integer equipeId) {
        return joueurRepository.findByEquipe(equipeId);
    }

    @Override
    public Joueur getById(Integer id) {
        return null;
    }

    @Override
    public Joueur createJoueur(Joueur joueur) {
        return null;
    }

    @Override
    public Joueur updateJoueur(Joueur joueur) {
        return null;
    }

    @Override
    public void deleteJoueur(Integer id) {

    }
}
