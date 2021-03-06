drop table Vinieta;
drop table Serie;

create table Serie (
id integer not null generated always as identity,
nombre varchar (50) not null, 
puntuacion integer default 0,
autor varchar (50) not null,
CONSTRAINT Serie_pk PRIMARY KEY (id)
);

create table Vinieta (
idserie integer not null,
id integer not null generated always as identity (START WITH 1, INCREMENT BY 1),
nombre varchar(50) not null,
fecha date default CURRENT_DATE,
puntuacion integer default 0,
CONSTRAINT Vinieta_pk PRIMARY KEY (id),
FOREIGN KEY (idserie) REFERENCES Serie(id) ON DELETE CASCADE
);

INSERT INTO Serie (nombre, puntuacion, autor)VALUES ('La familia Trapisonda', 5, 'Ibañez');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-0', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '1.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-1', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '2.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-2', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '3.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-3', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '4.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-4', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '5.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-5', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='La familia Trapisonda'), '6.10.1980');

INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Mortadelo y Filemon', 9, 'Ibañez');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-1', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '7.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-2', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '8.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-3', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '9.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-4', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '10.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-5', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '11.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-6', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '12.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-7', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '13.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-8', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '14.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-9', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '15.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-10', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '16.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-11', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '17.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-12', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '18.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-13', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '19.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-14', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '20.10.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Especial navidad', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Mortadelo y Filemon'), '21.10.1980');

INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Rompetechos', 6, 'Ibañez');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-6', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.01.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-9', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.02.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-12', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.03.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-15', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.04.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-18', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.05.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Entrega-21', (SELECT id FROM Serie WHERE AUTOR = 'Ibañez'AND NOMBRE ='Rompetechos'), '1.06.1990');

INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Los cuatro fantasticos', 6, 'Marvel');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-0', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.06.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-1', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.07.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-2', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.08.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-3', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.09.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-4', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.10.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No-5', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Los cuatro fantasticos'), '1.11.2004');


INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('El asombroso Spiderman', 10, 'Marvel');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-1', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1980');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-2', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1981');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-3', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1982');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-4', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1983');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-5', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1984');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-6', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1985');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-7', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1986');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-8', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1987');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('#-9', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El asombroso Spiderman'), '01.12.1988');

INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('El espectacular Spiderman', 8, 'Marvel');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.10', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1989');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.11', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1990');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.12', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1991');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.13', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1992');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.14', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1993');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.15', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1994');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.16', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1995');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.17', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1996');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.18', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1997');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.19', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1998');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.20', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El espectacular Spiderman'), '01.12.1999');


INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Civil War', 6, 'Marvel');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Edicion original', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Civil War'), '01.02.1985');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Edicion remasterizada', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Civil War'), '01.02.2014');
/* Current date */
INSERT INTO Vinieta (nombre, idserie) VALUES ('Edicion coleccionista', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='Civil War'));

INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('El Spiderman que parece no dormir nunca', 3, 'Marvel');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.20', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2003');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.21', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2004');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.22', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2005');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.23', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2006');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.24', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2007');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.25', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2008');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.26', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2009');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.27', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2010');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.28', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2011');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('No.29', (SELECT id FROM Serie WHERE AUTOR = 'Marvel'AND NOMBRE ='El Spiderman que parece no dormir nunca'), '13.05.2012');


INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Fiestas alrededor del mundo', 5, 'Sabias que');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Navidad', (SELECT id FROM Serie WHERE AUTOR = 'Sabias que' AND NOMBRE ='Fiestas alrededor del mundo'), '27.4.2015');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Pascua', (SELECT id FROM Serie WHERE AUTOR = 'Sabias que' AND NOMBRE ='Fiestas alrededor del mundo'), '27.4.2016');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Hanuka', (SELECT id FROM Serie WHERE AUTOR = 'Sabias que' AND NOMBRE ='Fiestas alrededor del mundo'), '27.4.2017');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Kwanzaa', (SELECT id FROM Serie WHERE AUTOR = 'Sabias que' AND NOMBRE ='Fiestas alrededor del mundo'), '27.4.2018');


/**/
INSERT INTO  Serie (nombre, puntuacion, autor) VALUES ('Harry Potter, el manga', 5, 'J.K. Rowling');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y la Piedra Filosofal', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2013');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y la Camara Secreta', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2014');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y el prisionero de Azkaban', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2015');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y el caliz de fuego', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2016');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y la Orden del Fenix', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2017');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y el misterio dl principe', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2018');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Harry Potter y las reliquias de la muerte', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2019');
INSERT INTO Vinieta (nombre, idserie, fecha) VALUES ('Animales fantasticos y donde encontrarlos', (SELECT id FROM Serie WHERE AUTOR = 'J.K. Rowling' AND NOMBRE ='Harry Potter, el manga'), '01.09.2020');

INSERT INTO Serie (nombre, puntuacion, autor) VALUES ('The Slim Shady Show', 6, 'Dr.DRE.');
INSERT INTO Vinieta (nombre, idserie, fecha, puntuacion) VALUES ('Slim Shady', (SELECT id FROM Serie WHERE AUTOR = 'Dr.DRE.' AND NOMBRE ='The Slim Shady Show'), '01.1.2018', 10);
INSERT INTO Vinieta (nombre, idserie, fecha, puntuacion) VALUES ('Eminem', (SELECT id FROM Serie WHERE AUTOR = 'Dr.DRE.' AND NOMBRE ='The Slim Shady Show'), '01.2.2018', 8);
INSERT INTO Vinieta (nombre, idserie, fecha, puntuacion) VALUES ('Demminem', (SELECT id FROM Serie WHERE AUTOR = 'Dr.DRE.' AND NOMBRE ='The Slim Shady Show'), '01.3.2018', 3);
INSERT INTO Vinieta (nombre, idserie, fecha, puntuacion) VALUES ('SumUP', (SELECT id FROM Serie WHERE AUTOR = 'Dr.DRE.' AND NOMBRE ='The Slim Shady Show'), '01.4.2018', 1);
