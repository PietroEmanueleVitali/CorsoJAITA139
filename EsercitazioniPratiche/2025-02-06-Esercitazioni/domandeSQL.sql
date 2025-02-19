-- 1. visualizzare se ci siano filiali che non hanno dipendenti
SELECT dipartimenti.nome
FROM dipartimenti LEFT JOIN dipendenti ON dipartimenti.id = dipendenti.iddipartimento
WHERE dipendenti.nome IS NULL;
-- 2. visualizzare se ci siano dipendenti che non sono stati assegnati ancora ad alcuna filiale, se non ce ne sono aggiungere
-- un dipendente che non abbia ancora una filiale assegnata 
SELECT dipendenti.nome
FROM dipendenti
WHERE dipendenti.iddipartimento IS NULL;
-- 3. visualizzare il numero di dipendenti per genere
SELECT dipendenti.genere, COUNT(*) as numero_dipendenti
FROM dipendenti	
GROUP BY dipendenti.genere;
-- 4. visualizzare le categorie dei dipartimenti senza ripetizioni
SELECT DISTINCT dipartimenti.nome
FROM dipartimenti;
-- 6. visualizzare il numero di filiali che ha un numero di donne superiore alla media totale delle donne
SELECT contatore_donne.dn
FROM
(	SELECT dipartimenti.nome as dn, COUNT(dipendenti.genere) as numero_donne 
	FROM dipartimenti LEFT JOIN dipendenti ON dipartimenti.id = dipendenti.iddipartimento
	WHERE dipendenti.genere = 'F' 
	GROUP BY dn) 
    as contatore_donne Join
(	SELECT dipartimenti.nome, AVG(counter.numero_donne) as media_donne
FROM 
	(	SELECT dipartimenti.nome as dn, dipendenti.genere, COUNT(*) as numero_donne 
		FROM dipartimenti LEFT JOIN dipendenti ON dipartimenti.id = dipendenti.iddipartimento
		WHERE dipendenti.genere = 'F' 
		GROUP BY dipartimenti.nome) 
		as counter, dipartimenti
		GROUP BY dipartimenti.nome) as calcolatore_media ON calcolatore_media.nome = contatore_donne.dn
WHERE calcolatore_media.media_donne < contatore_donne.numero_donne
GROUP BY contatore_donne.dn;

-- 7. elenco di mansioni per sede della filiale
SELECT DISTINCT sede, ruolo
FROM dipendenti dip,dipartimenti d
WHERE dip.iddipartimento = d.id
ORDER BY sede;

-- 8. elenco dei dipendenti che lavorano nel dipartimento con il maggior numero di dipendenti (ci sono 6 uffici con questo numero di dipendenti).
CREATE VIEW dipendenti_per_dipartimento AS 
	SELECT dipartimenti.nome, COUNT(dipendenti.nome) as numero_dipendenti
	FROM dipartimenti INNER JOIN dipendenti ON dipartimenti.id = dipendenti.iddipartimento
	GROUP BY dipartimenti.nome
	ORDER BY dipartimenti.nome;

CREATE VIEW max_dipendenti AS SELECT MAX(numero_dipendenti) as numero_massimo
FROM dipendenti_per_dipartimento;

DROP VIEW max_dipendenti;

CREATE VIEW trova_uffici_max AS
SELECT dipartimenti.nome
FROM dipartimenti, dipendenti_per_dipartimento, max_dipendenti
WHERE dipartimenti.nome = dipendenti_per_dipartimento.nome AND dipendenti_per_dipartimento.numero_dipendenti = max_dipendenti.numero_massimo;

SELECT dipendenti.nome, dipartimenti.nome
FROM dipendenti JOIN dipartimenti ON dipendenti.iddipartimento = dipartimenti.id, trova_uffici_max
WHERE dipartimenti.nome = trova_uffici_max.nome;

-- 9. elenco completo di tutti i dipendenti e certificati, inclusi i dipendenti senza certificati e i certificati che non ancora assegnati a un dipendente
SELECT dipendenti.nome, certificati.nome
FROM registro_certificati 
RIGHT JOIN certificati ON registro_certificati.id_certificato = certificati.id 
RIGHT JOIN dipendenti on dipendenti.id=registro_certificati.id_dipendente;

-- 10. elenco completo dei dipendenti con i loro dipartimenti e certificati, anche di quei dipendenti che non hanno certificati
SELECT dipendenti.nome, certificati.nome, dipartimenti.nome
FROM dipendenti 
LEFT JOIN  registro_certificati  ON dipendenti.id=registro_certificati.id_dipendente
LEFT JOIN certificati ON registro_certificati.id_certificato = certificati.id
LEFT JOIN dipartimenti ON dipartimenti.id = dipendenti.iddipartimento;

-- 11. elenco dei soli dipendenti che non hanno ancora acquisito certificati e dei soli certificati che non sono ancora stati conseguiti da alcun dipendente  
SELECT dipendenti.nome, certificati.nome
FROM dipendenti LEFT JOIN  registro_certificati  ON dipendenti.id=registro_certificati.id_dipendente
LEFT JOIN certificati ON registro_certificati.id_certificato = certificati.id
WHERE certificati.nome IS NULL; -- ci voleva una UNION con l'altro risultato, sono proprio due query differenti

-- 12. numeri di dipendenti per certificato
SELECT certificati.nome, COUNT(dipendenti.nome)
FROM certificati LEFT JOIN registro_certificati ON registro_certificati.id_certificato = certificati.id
LEFT JOIN dipendenti ON dipendenti.id = registro_certificati.id_dipendente
GROUP BY certificati.nome;


