package com.arthur.fr.rugbyvitre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sizeshop")
public class SizeShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String sizeExiste;

    @ManyToMany(mappedBy = "sizeShops")
    private List<Article> articles;

    public SizeShop(Integer id) {
        this.id = id;
    }
}
