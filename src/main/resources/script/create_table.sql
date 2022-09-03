DROP TABLE IF EXISTS joueurs CASCADE;



create table joueurs (
    id  serial not null,
     age int4 not null,
    nom varchar(100) not null,
    poste varchar(255) not null,
    prenom varchar(100) not null,
     primary key (id)
);


INSERT INTO joueurs (id, age, prenom, nom, poste) VALUES (1, 21, 'prenom', 'nom', 'PREMIERELIGNE');