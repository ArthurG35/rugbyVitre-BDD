package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

    List<Equipe> getEquipesByVisibilityIs(boolean visibility);

    List<Equipe> getEquipeById(Integer id);

}
