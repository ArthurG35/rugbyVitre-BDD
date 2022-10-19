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
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private Double prix;

    @ManyToMany
    @JoinTable(name = "Article_Size_Association",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<SizeShop> sizeShops;

    @Override
    public String toString() {
        return "articles{" + "id=" + id + ", name='" + name + ", path='" + path + ", prix='" + prix + ", sizeShops='" + sizeShops + '}';
    }


}
