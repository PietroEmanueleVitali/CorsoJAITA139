Select *
From Libri
WHERE autore = "Luca Verdi";

Select *
From Libri
WHERE autore = "Luca Verdi" AND genere = "fiction";

SELECT * 
FROM libri
WHERE nPagine >= 150 AND nPagine <= 300;

Select titolo, year(dataPubblicazione) anno_pubblicazione
FROM libri
WHERE anno_pubblicazione > 2017 AND anno_pubblicazione < 2020;

ALTER TABLE libri 
ADD COLUMN casaEditrice VARCHAR(20) AFTER genere;

UPDATE Libri SET casaEditrice = "Mondadori" WHERE autore = "Luca Verdi";

SELECT * FROM libri WHERE genere IN ("Science Fiction","Biography,Historical","Fiction");

Select * FROM libri
WHERE titolo LIKE "%kill%";

Select * FROM libri
WHERE autore LIKE "L%";

SELECT * FROM libri WHERE genere IN ("Fantasy", "Fiction") AND prezzo < 15;

SELECT * FROM libri WHERE genere NOT IN ("Romance", "Fantasy", "Mystery");

