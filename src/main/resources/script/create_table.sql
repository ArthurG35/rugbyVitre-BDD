DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS societies;
DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS users;



create table joueurs
(
    id   serial
        primary key,
    name varchar(255) not null,
    age  varchar(10)  not null
);
