package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.Equipe;

import java.util.List;

public interface EquipeService {

    List<Equipe> getAll();

    Equipe getById(Integer id);

    Equipe createEquipe(Equipe equipe);

    Equipe updateEquipe(Equipe equipe);

    void deleteEquipe(Integer id);
}
