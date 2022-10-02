package com.arthur.fr.rugbyvitre.model;

import com.arthur.fr.rugbyvitre.enumeration.Importance;
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
@Table(name = "partenaires")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Importance importance;

    @Override
    public String toString() {
        return "Partenaires{" + "id=" + id + ", name='" + name + '\'' + ", path='" + path + '\'' + ", Importance='" + importance + '}';
    }

}
