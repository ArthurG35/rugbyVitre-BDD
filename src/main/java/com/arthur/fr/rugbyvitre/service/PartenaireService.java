package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.Partenaire;

import java.util.List;

public interface PartenaireService {
    List<Partenaire> getAll();

    Partenaire getById(Integer id);

    Partenaire createPartenaire(Partenaire partenaire);

    Partenaire updatePartenaire(Partenaire partenaire);

    void deletePartenaire(Integer id);
}
