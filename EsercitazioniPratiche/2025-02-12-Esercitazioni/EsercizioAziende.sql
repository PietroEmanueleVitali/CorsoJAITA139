--  creare un database che mette in relazione delle aziende con dei dipendenti.
CREATE DATABASE cluster_aziende;
USE cluster_aziende;

-- La tabella Aziende dovrÃ avere:
--  un id primary key auto_increment,
--  ragionesociale varchar(),
--  piva varchar(),
--  sede varchar(),
--  settore varchar()
-- Inserite qualche azienda

CREATE TABLE aziende(
	azienda_id INT AUTO_INCREMENT,
    ragione_sociale VARCHAR(20),
    p_iva VARCHAR(20),
    sede VARCHAR(20),
    settore VARCHAR(20),
    PRIMARY KEY(azienda_id)
);

INSERT INTO aziende 
(ragione_sociale, p_iva, sede, settore) 
VALUES
('Company generica', '1039303202', 'brescia', 'ecommerce'),
('Companies gen', '104342303202', 'roma', 'ecommerce'),
('azienda generica', '2039303202', 'milano', 'ecommerce'),
('azienda generica', '2039303202', 'torino', 'ecommerce'),
('aziendona generica', '2034303202', 'torino', 'ecommerce'),
('palombello bello', '143129303202', 'venezia', 'ecommerce');

-- Poi dovrete creare una seconda tabella, quella dei DIPENDENTI:
--  id int primary key auto_increment, e una foreign key
--  nome 
--  cognome 
--  mansione 
--  ddn date,
--  stipendio ,
--  idazienda int,
-- );
CREATE TABLE dipendenti(
	dipendente_id INT AUTO_INCREMENT,
    nome VARCHAR(20),
    cognome VARCHAR(20),
    mansione VARCHAR(20),
    data_nascita DATE,
    stipendio DECIMAL(10,2),
    id_azienda INT,
    PRIMARY KEY(dipendente_id),
    FOREIGN KEY(id_azienda) REFERENCES aziende(azienda_id) ON DELETE CASCADE ON UPDATE CASCADE
);



-- Anche qua inserite qualche dipendente 

-- Ricordate che abbiamo due tabelle, Aziende e Dipendenti

-- Provate ad AGGIUNGERE anche una colonna 'residenza' nella tabella Dipendenti
-- settando due residenze possibili
ALTER TABLE dipendenti 
ADD COLUMN residenza VARCHAR(30) CONSTRAINT residenza CHECK (residenza = 'Milano' OR residenza = 'torino');

INSERT INTO dipendenti 
(nome, cognome, mansione, data_nascita, stipendio, id_azienda, residenza)
VALUES
('luigi', 'pirandello', 'macellaio', '1999-02-21', 2000.50, 1, 'milano'),
('francesco', 'palombello', 'infermiere', '1997-02-21', 2500.50, 4, 'torino'),
('cristina', 'pirato', 'carettio', '1987-02-21', 1000.50, 3, 'milano'),
('fabrizio', 'papuzzi', 'casio', '1996-02-21', 2500.50, 4, 'torino'),
('certosino', 'pirincino', 'carrellante', '1992-02-21', 3000.50, 5, 'milano');

-- -1) trovare tutti i dipendenti che lavorano in un'azienda di torino
SELECT dipendenti.nome, dipendenti.cognome, aziende.ragione_sociale, aziende.sede
FROM dipendenti LEFT JOIN aziende ON dipendenti.id_azienda = aziende.azienda_id
WHERE sede = 'torino';

-- 2) trovare tutti i dipendenti nati prima del 2000 e che lavorano in un'azienda di milano
CREATE VIEW aziende_dipendenti AS 
SELECT *
FROM dipendenti LEFT JOIN aziende ON dipendenti.id_azienda = aziende.azienda_id;

DROP VIEW aziende_dipendenti;

SELECT nome, cognome, data_nascita
FROM  aziende_dipendenti
WHERE YEAR(data_nascita) < 2000 AND sede = 'milano';

-- 3) trovare lo stipendio medio dei dipendenti che lavorano in un'azienda di torino
SELECT ragione_sociale, AVG(stipendio)
FROM aziende_dipendenti
WHERE sede = 'TORINO'
GROUP BY ragione_sociale;

-- 4) contare quanti dipendenti nati dopo il 1990 sono residenti a Milano
SELECT nome, cognome
FROM aziende_dipendenti
WHERE YEAR(data_nascita) > 1990 AND residenza = 'milano';

-- 5) contare quanti dipendenti lavorano in un'azienda che ha la sede differente rispetta alla sua residenza
SELECT ragione_sociale, COUNT(*)
FROM aziende_dipendenti
WHERE residenza != sede
GROUP BY ragione_sociale;

-- 6) trovare lo stipendio medio raggrupato per aziende
SELECT ragione_sociale, AVG(stipendio)
FROM aziende_dipendenti
GROUP BY ragione_sociale;

-- 7) trovare lo stipendio medio raggruppando per sede di lavoro
SELECT sede, AVG(stipendio)
FROM aziende_dipendenti
GROUP BY sede;

-- 8) trovare lo stipendio medio raggruppando sia per sede di lavoro che per residenza
SELECT sede, residenza, AVG(stipendio)
FROM aziende_dipendenti
GROUP BY sede, residenza;

-- settare delle valutazioni con nome
DELIMITER //
CREATE FUNCTION calcola_apprezzamento(voto INT)
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN 
	DECLARE apprezzamento VARCHAR(10);
    IF voto > 70 THEN
		SET apprezzamento = 'ottimo';
	ELSEIF voto < 50 THEN
		SET apprezzamento = 'pessimo';
	ELSE 
		SET apprezzamento = 'normale';
	END IF;
    RETURN apprezzamento;
END
//
DELIMITER ;

UPDATE dipendenti SET voto = 100 WHERE dipendente_id = 1; 
UPDATE dipendenti SET voto = 60 WHERE dipendente_id = 2; 
UPDATE dipendenti SET voto = 70 WHERE dipendente_id = 3; 
UPDATE dipendenti SET voto = 30 WHERE dipendente_id = 4; 

SELECT dipendenti.nome, dipendenti.cognome, calcola_apprezzamento(voto)
FROM aziende_dipendenti JOIN dipendenti ON aziende_dipendenti.dipendente_id = dipendenti.dipendente_id;

DELIMITER //

CREATE TRIGGER controlla_voto
BEFORE INSERT ON dipendenti
FOR EACH ROW
BEGIN
	IF NEW.voto > 100 THEN
		BEGIN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'numero fuori dai valori massimi.';
		END;
	END IF;
END
//
delimiter ;

DROP TRIGGER controlla_voto;

INSERT INTO dipendenti
(nome, cognome, mansione, data_nascita, stipendio, id_azienda, residenza, voto)
VALUES 
('francesco', 'rizzoli', 'crisantere', '1987-01-22', 2005.50, 3, 'torino', 120),
('francesco', 'rizzoli', 'crisantere', '1987-01-22', 2005.50, 3, 'torino', 120);

DELETE FROM dipendenti WHERE voto > 100 AND dipendente_id > 4;

SELECT voto
FROM dipendenti;

DELIMITER //
CREATE PROCEDURE trovavoti(voti INT)
BEGIN
	SELECT * 
    FROM dipendenti
    WHERE voti > dipendenti.voto;
END
//

DELIMITER ;
call trovavoti(80);

DELIMITER //
CREATE TRIGGER non_si_tocca_pirandello
BEFORE DELETE ON dipendenti
FOR EACH ROW
	BEGIN
		IF OLD.cognome = 'pirandello' AND OLD.nome = 'luigi' THEN
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'NON TOCCARE PIRANDELLO, MARCONDIRONDIRONDELLO';
			END IF;
	END
//

DELIMITER ;

DELETE FROM dipendenti WHERE dipendenti.dipendente_id = 1;

