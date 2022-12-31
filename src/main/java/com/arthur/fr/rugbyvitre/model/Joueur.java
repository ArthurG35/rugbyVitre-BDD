package com.arthur.fr.rugbyvitre.model;

import com.arthur.fr.rugbyvitre.enumeration.Poste;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "joueurs")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    private Integer placement;

    @Enumerated(EnumType.STRING)
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @Override
    public String toString() {
        return "Joueurs{" + "id=" + id + ", age='" + age + '\'' + ", prenom='" + prenom + '\'' + ", nom='" + nom + '\'' + ", placement='" + placement + '\'' + ", poste='" + poste + '\'' + ", equipe='" + equipe + '}';
    }
}
