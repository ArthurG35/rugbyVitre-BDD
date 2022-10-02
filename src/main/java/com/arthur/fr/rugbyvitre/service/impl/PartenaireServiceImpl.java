package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.model.Partenaire;
import com.arthur.fr.rugbyvitre.repository.PartenaireRepository;
import com.arthur.fr.rugbyvitre.service.PartenaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartenaireServiceImpl implements PartenaireService {
    private final PartenaireRepository partenaireRepository;

    public PartenaireServiceImpl(PartenaireRepository partenaireRepository) {
        this.partenaireRepository = partenaireRepository;
    }

    @Override
    public List<Partenaire> getAll()  {
        return partenaireRepository.findAll();
    }

    @Override
    public Partenaire getById(Integer id) {
        return null;
    }

    @Override
    public Partenaire createPartenaire(Partenaire partenaire) {
        return null;
    }

    @Override
    public Partenaire updatePartenaire(Partenaire partenaire) {
        return null;
    }

    @Override
    public void deletePartenaire(Integer id) {

    }
}
