package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.model.Equipe;
import com.arthur.fr.rugbyvitre.repository.EquipeRepository;
import com.arthur.fr.rugbyvitre.service.EquipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {
    private final EquipeRepository equipeRepository;

    public EquipeServiceImpl(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public List<Equipe> getAll() {
        return equipeRepository.findAll();
    }

    @Override
    public List<Equipe> getEquipesByVisibilityIs(boolean visibility) {
        return equipeRepository.getEquipesByVisibilityIs(visibility);
    }

    @Override
    public List<Equipe> getEquipeById(Integer id) {
        return equipeRepository.getEquipeById(id);
    }

    @Override
    public Equipe getById(Integer id) {
        return null;
    }

    @Override
    public Equipe createEquipe(Equipe equipe) {
        return null;
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return null;
    }

    @Override
    public void deleteEquipe(Integer id) {

    }

}
