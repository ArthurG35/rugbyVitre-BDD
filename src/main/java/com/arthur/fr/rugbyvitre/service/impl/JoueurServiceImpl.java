package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.model.Joueur;
import com.arthur.fr.rugbyvitre.repository.JoueurRepository;
import com.arthur.fr.rugbyvitre.service.JoueurService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Joueur> getJoueursByEquipeId(Integer equipeId) {
        return joueurRepository.getJoueursByEquipeId(equipeId);
    }

    @Override
    public Joueur getById(Integer id) {
        return joueurRepository.findById(id).orElseThrow(() -> new UnknownRessourceException("No Joueur with this ID"));
    }

    @Override
    public Joueur createJoueur(Joueur joueur) {
        return this.joueurRepository.save(joueur);
    }

    @Override
    public Joueur updateJoueur(Joueur joueur) {
        Joueur joueurToUpdate = this.getById(joueur.getId());
        joueurToUpdate.setAge(joueur.getAge());
        joueurToUpdate.setNom(joueur.getNom());
        joueurToUpdate.setPoste(joueur.getPoste());
        joueurToUpdate.setEquipe(joueur.getEquipe());
        joueurToUpdate.setPlacement(joueur.getPlacement());
        joueurToUpdate.setPrenom(joueur.getPrenom());
        return this.joueurRepository.save(joueurToUpdate);
    }

    @Override
    public void deleteJoueur(Integer id) {
        Joueur joueurToDelete = this.getById(id);
        this.joueurRepository.delete(joueurToDelete);
    }
}
