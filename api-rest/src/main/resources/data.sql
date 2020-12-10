create database usuarios;

CREATE TABLE `usuarios`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

use usuarios;

insert into usuarios(nombre,apellido) values ("Juan", "Perez");
insert into usuarios(nombre,apellido) values ("Hector", "Gomez");
insert into usuarios(nombre,apellido) values ("Luis", "Rodriguez");
insert into usuarios(nombre,apellido) values ("Maria", "Planchart");
