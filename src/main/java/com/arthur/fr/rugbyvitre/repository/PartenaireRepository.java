package com.arthur.fr.rugbyvitre.repository;

import com.arthur.fr.rugbyvitre.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
}
