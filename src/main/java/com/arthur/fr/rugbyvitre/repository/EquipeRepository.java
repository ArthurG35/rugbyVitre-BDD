package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {


}
