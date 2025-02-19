-- Creare un database per gestire un numero di dipendenti che possono avere un certo numero di certificati,
-- e un certicato pùo essere posseduto da più dipendeti.
-- si tratta di una relazione N A N
CREATE DATABASE udemy;
Use udemy;
-- Dovrete creare una tabella relazionale, che permetta di collegare i dipendeti alle certificazioni.
-- La tabella certificati dovra avere oltre all'id int primary key auto_increment, un nome, durata del corso e costo.
CREATE TABLE certificazioni(
	certificazione_id INT AUTO_INCREMENT,
    nome VARCHAR(20),
    durata_corso TIME,
    costo DECIMAL,
    PRIMARY KEY(certificazione_id)
);
INSERT	INTO certificazioni(nome, durata_corso, costo) VALUES 
('Java developer', '10:00:00', 20.20),
('C# developer', '01:00:00', 30.20),
('Python developer', '10:00:00', 40.20),
('Developerone', '10:00:00', 10.20);
-- La tabella dipendete dovrà avere l'id primary auto_increment, nome, cognome, residenza ed eta.
CREATE TABLE dipendenti(
	dipendente_id INT AUTO_INCREMENT,
    nome VARCHAR(10),
    cognome VARCHAR(10),
    residenza VARCHAR(15),
    eta INT,
    PRIMARY KEY(dipendente_id)
);
INSERT INTO dipendenti 
(nome, cognome, residenza, eta) 
VALUES
('gigi', 'proietti', 'busto asizio', 12),
('domenico', 'riccone', 'custo asizio', 21),
('gaetano', 'posologo', 'busto di latto', 23),
('luigi', 'cortolo', 'curimma asizio', 43);
-- La tabella registro_Certificati avrà anch'essa un id int primary key auto increment, con data_conseguimento, id-certificato

CREATE TABLE certificazioni_dipendenti(
	registro_id INT AUTO_INCREMENT,
    data_conseguimento DATE,
	certificazione_id INT NOT NULL,
    dipendente_id INT NOT NULL,
    PRIMARY KEY (registro_id),
    FOREIGN KEY(certificazione_id) REFERENCES certificazioni(certificazione_id),
    FOREIGN KEY(dipendente_id) REFERENCES dipendenti(dipendente_id)
);
INSERT INTO certificazioni_dipendenti 
(data_conseguimento, certificazione_id, dipendente_id)
VALUES 
('2022-01-22', 1, 3),
('2023-05-24', 2, 4),
('2021-02-25', 3, 2),
('2023-11-25', 4, 4);

-- fate delle left join, costo totale dei certificati, costo medio ti tutti i certificati in un determinato anno, costo totale di
-- tutti i certificati
SELECT * from dipendenti as d LEFT JOIN  certificazioni_dipendenti as cd ON cd.dipendente_id = d.dipendente_id
LEFT JOIN certificazioni as c  ON c.certificazione_id = cd.certificazione_id;

SELECT SUM(costo) as prezzo_totale FROM certificazioni;

SELECT AVG(costo) as prezzo_medio FROM certificazioni as c JOIN certificazioni_dipendenti as cd ON cd.certificazione_id = c.certificazione_id
WHERE YEAR(data_conseguimento) = 2023;

SELECT SUM(costo) as spesa_certificazioni FROM certificazioni as c LEFT JOIN certificazioni_dipendenti as cd ON cd.certificazione_id = c.certificazione_id;