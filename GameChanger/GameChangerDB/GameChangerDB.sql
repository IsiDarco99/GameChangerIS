drop database if exists GameChanger;
create database GameChanger;
use gamechanger;

drop user if exists 'admin'@'localhost';
create user 'admin'@'localhost' identified by 'admin';
grant all on gamechanger.* to 'admin'@'localhost';

CREATE TABLE utente (
  username VARCHAR(22) NOT NULL,
  email_pers VARCHAR(70) NOT NULL,
  email_paypal VARCHAR(70),
  num_tel INT,
  indirizzo VARCHAR(70),
  password VARCHAR(22) NOT NULL,
  nome VARCHAR(30) NOT NULL,
  cognome VARCHAR(30) NOT NULL,
  data_nascita DATE NOT NULL,
  codfiscale VARCHAR(17),
  PRIMARY KEY (username)
);

CREATE TABLE amministratore (
  id_amministratore INT NOT NULL,
  nome VARCHAR(30) NOT NULL,
  cognome VARCHAR(30) NOT NULL,
  password VARCHAR(22) NOT NULL,
  email VARCHAR(70) NOT NULL,
  PRIMARY KEY (id_amministratore)
);

CREATE TABLE prodotto (
  codice INT NOT NULL,
  prezzo FLOAT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  descrizione VARCHAR(200) NOT NULL,
  data_usc DATE NOT NULL,
  PRIMARY KEY (codice)
);

CREATE TABLE videogame (
  codice INT NOT NULL,
  pegi ENUM('3', '7', '12', '16', '18') NOT NULL,
  sviluppatore VARCHAR(50) NOT NULL,
  genere VARCHAR(50) NOT NULL,
  PRIMARY KEY (codice),
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE accessorio (
  codice INT NOT NULL,
  tipo VARCHAR(20),
  PRIMARY KEY (codice),
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE computer (
  codice INT NOT NULL,
  casa ENUM('y', 'n'),
  ufficio ENUM('y', 'n'),
  gaming ENUM('y', 'n'),
  PRIMARY KEY (codice),
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE console (
  codice INT NOT NULL,
  generazione TINYINT NOT NULL,
  PRIMARY KEY (codice),
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE carrello (
  id_carrello INT NOT NULL,
  username VARCHAR(22) NOT NULL,
  codice INT NOT NULL,
  quant_prod TINYINT NOT NULL,
  PRIMARY KEY (id_carrello),
  FOREIGN KEY (username) REFERENCES utente (username) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ordine (
  id_ordine INT NOT NULL,
  username VARCHAR(22) NOT NULL,
  codice INT NOT NULL,
  quant_prod TINYINT NOT NULL,
  prezzo FLOAT NOT NULL,
  stato_ord VARCHAR(50) NOT NULL,
  data_ord DATE,
  PRIMARY KEY (id_ordine),
  FOREIGN KEY (username) REFERENCES utente (username) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (codice) REFERENCES prodotto (codice) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Creazione utenti
INSERT INTO utente (username, email_pers, email_paypal, num_tel, indirizzo, password, nome, cognome, data_nascita, codfiscale)
VALUES
    ('user1', 'user1@example.com', 'user1.paypal@example.com', 0234567890, 'Via Roma 1', 'password1', 'Mario', 'Rossi', '1990-01-01', 'RSSMRA90A01H501A'),
    ('user2', 'user2@example.com', 'user2.paypal@example.com', 0345678901, 'Via Milano 2', 'password2', 'Luca', 'Bianchi', '1991-02-02', 'BNCLCU91B02H502B'),
    ('user3', 'user3@example.com', 'user3.paypal@example.com', 0456789012, 'Via Venezia 3', 'password3', 'Giulia', 'Verdi', '1992-03-03', 'VRDGLI92C03H503C'),
    ('user4', 'user4@example.com', 'user4.paypal@example.com', 0567890123, 'Via Firenze 4', 'password4', 'Laura', 'Neri', '1993-04-04', 'NRILRA93D04H504D'),
    ('user5', 'user5@example.com', 'user5.paypal@example.com', 0678901234, 'Via Napoli 5', 'password5', 'Francesco', 'Russo', '1994-05-05', 'RSSFNC94E05H505E'),
    ('user6', 'user6@example.com', 'user6.paypal@example.com', 0789012345, 'Via Palermo 6', 'password6', 'Simona', 'Gallo', '1995-06-06', 'GLLSMN95F06H506F'),
    ('user7', 'user7@example.com', 'user7.paypal@example.com', 0890123456, 'Via Genova 7', 'password7', 'Alessandro', 'Conti', '1996-07-07', 'CNTLSND96G07H507G'),
    ('user8', 'user8@example.com', 'user8.paypal@example.com', 0901234567, 'Via Torino 8', 'password8', 'Valentina', 'Esposito', '1997-08-08', 'ESPVLT97H08H508H'),
    ('user9', 'user9@example.com', 'user9.paypal@example.com', 0012345678, 'Via Bologna 9', 'password9', 'Stefano', 'Marchetti', '1998-09-09', 'MRCHFN98I09H509I'),
    ('user10', 'user10@example.com', 'user10.paypal@example.com', 0234567809, 'Via Verona 10', 'password10', 'Chiara', 'Barbieri', '1999-10-10', 'BRBCHR99L10H510L'),
    ('user11', 'user11@example.com', 'user11.paypal@example.com', 0345678910, 'Via Trieste 11', 'password11', 'Roberto', 'Ferrari', '2000-11-11', 'FRRRBR00M11H511M'),
    ('user12', 'user12@example.com', 'user12.paypal@example.com', 0456789123, 'Via Padova 12', 'password12', 'Elisa', 'Rinaldi', '2001-12-12', 'RNLDSA01N12H512N'),
    ('user13', 'user13@example.com', 'user13.paypal@example.com', 0567890234, 'Via Parma 13', 'password13', 'Giovanni', 'Mancini', '2002-01-13', 'MCNGVN02O13H513O'),
    ('user14', 'user14@example.com', 'user14.paypal@example.com', 0678901345, 'Via Modena 14', 'password14', 'Serena', 'Gatti', '2003-02-14', 'GTTSRN03P14H514P'),
    ('user15', 'user15@example.com', 'user15.paypal@example.com', 0789012456, 'Via Pisa 15', 'password15', 'Marco', 'Lombardi', '2004-03-15', 'LMBMRC04Q15H515Q'),
    ('user16', 'user16@example.com', 'user16.paypal@example.com', 0890123567, 'Via Livorno 16', 'password16', 'Cristina', 'Moretti', '2005-04-16', 'MRTCRS05R16H516R'),
    ('user17', 'user17@example.com', 'user17.paypal@example.com', 0901234678, 'Via Siena 17', 'password17', 'Davide', 'Fontana', '2006-05-17', 'FNTDVD06S17H517S'),
    ('user18', 'user18@example.com', 'user18.paypal@example.com', 0012345789, 'Via Lucca 18', 'password18', 'Sara', 'Villa', '2007-06-18', 'VLLSRA07T18H518T'),
    ('user19', 'user19@example.com', 'user19.paypal@example.com', 0234567890, 'Via Arezzo 19', 'password19', 'Fabio', 'Rizzo', '2008-07-19', 'RZZFBA08U19H519U'),
    ('user20', 'user20@example.com', 'user20.paypal@example.com', 0345678901, 'Via Grosseto 20', 'password20', 'Alessia', 'Greco', '2009-08-20', 'GRCSSA09V20H520V');

-- Inserimento prodotti di categoria Videogame
INSERT INTO prodotto (codice, prezzo, nome, marca, descrizione, data_usc)
VALUES
    (1, 59.99, 'The Legend of Zelda: Breath of the Wild', 'Nintendo', 'Esplora il vasto regno di Hyrule', '2017-03-03'),
    (2, 49.99, 'God of War', 'Sony', "Un'avventura epica nel mondo della mitologia", '2018-04-20'),
    (3, 39.99, 'Grand Theft Auto V', 'Rockstar Games', 'Esplora la vasta città di Los Santos', '2013-09-17'),
    (4, 29.99, 'Minecraft', 'Mojang Studios', 'Costruisci e esplora un mondo infinito', '2011-11-18'),
    (5, 54.99, 'Red Dead Redemption 2', 'Rockstar Games', "Vivi l'epopea del selvaggio West", '2018-10-26');

-- Inserimento prodotti di categoria Computer
INSERT INTO prodotto (codice, prezzo, nome, marca, descrizione, data_usc)
VALUES
    (6, 999.99, 'MacBook Pro', 'Apple', 'Potente laptop per professionisti', '2020-11-10'),
    (7, 799.99, 'Dell XPS 13', 'Dell', 'Laptop sottile e potente', '2021-02-15'),
    (8, 699.99, 'HP Spectre x360', 'HP', 'Laptop convertibile elegante', '2021-03-20'),
    (9, 1499.99, 'Lenovo ThinkPad X1 Carbon', 'Lenovo', 'Notebook leggero e resistente', '2020-09-01'),
    (10, 1299.99, 'Asus ROG Zephyrus G14', 'Asus', 'Laptop gaming potente e portatile', '2020-03-30');

-- Inserimento prodotti di categoria Accessorio
INSERT INTO prodotto (codice, prezzo, nome, marca, descrizione, data_usc)
VALUES
    (11, 39.99, 'Logitech G502 HERO', 'Logitech', 'Mouse gaming ad alte prestazioni', '2018-05-01'),
    (12, 149.99, 'Razer BlackWidow Elite', 'Razer', 'Tastiera meccanica gaming con illuminazione RGB', '2019-07-15'),
    (13, 79.99, 'SteelSeries Arctis 7', 'SteelSeries', 'Cuffie wireless per gaming con audio surround', '2020-02-20'),
    (14, 29.99, 'Corsair MM800 RGB Polaris', 'Corsair', 'Tappetino mouse gaming con illuminazione personalizzabile', '2017-09-05'),
    (15, 199.99, 'Elgato Stream Deck', 'Elgato', 'Controller per streaming e produzione multimediale', '2017-05-15');

-- Inserimento prodotti di categoria Console
INSERT INTO prodotto (codice, prezzo, nome, marca, descrizione, data_usc)
VALUES
    (16, 399.99, 'PlayStation 5', 'Sony', 'La nuova generazione di console di Sony', '2020-11-12'),
    (17, 499.99, 'Xbox Series X', 'Microsoft', 'La potente console di nuova generazione di Microsoft', '2020-11-10'),
    (18, 299.99, 'Nintendo Switch', 'Nintendo', 'Console ibrida per giocare ovunque', '2017-03-03'),
    (19, 199.99, 'PlayStation 4', 'Sony', 'La console di gioco di successo di Sony', '2013-11-15'),
    (20, 299.99, 'Xbox One X', 'Microsoft', 'Console di gioco ad alte prestazioni di Microsoft', '2017-11-07');

-- Inserimento prodotti di categoria Videogame nella tabella Videogame
INSERT INTO videogame (codice, pegi, sviluppatore, genere)
VALUES
    (1, '12', 'Nintendo', 'Avventura'),
    (2, '18', 'Santa Monica Studio', 'Azione'),
    (3, '18', 'Rockstar North', 'Azione'),
    (4, '7', 'Mojang Studios', 'Sandbox'),
    (5, '18', 'Rockstar Games', 'Azione');

-- Inserimento prodotti di categoria Computer nella tabella Computer
INSERT INTO computer (codice, casa, ufficio, gaming)
VALUES
    (6, 'n', 'y', 'n'),
    (7, 'n', 'y', 'n'),
    (8, 'n', 'y', 'n'),
    (9, 'n', 'y', 'n'),
    (10, 'n', 'n', 'y');

-- Inserimento prodotti di categoria Accessorio nella tabella Accessorio
INSERT INTO accessorio (codice, tipo)
VALUES
    (11, 'Mouse'),
    (12, 'Tastiera'),
    (13, 'Cuffie'),
    (14, 'Tappetino Mouse'),
    (15, 'Controller');

-- Inserimento prodotti di categoria Console nella tabella Console
INSERT INTO console (codice, generazione)
VALUES
    (16, 9),
    (17, 9),
    (18, 8),
    (19, 8),
    (20, 8);

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (1, 'user1', 1, 2, 119.98, 'Consegnato', '2023-05-15');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (2, 'user2', 3, 1, 39.99, 'In transito', '2023-05-16');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (3, 'user3', 2, 1, 49.99, 'Spedito', '2023-05-17');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (4, 'user4', 4, 3, 89.97, 'Consegnato', '2023-05-18');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (5, 'user5', 5, 2, 109.98, 'In transito', '2023-05-19');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (6, 'user6', 10, 1, 129.99, 'Spedito', '2023-05-20');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (7, 'user7', 18, 2, 599.98, 'Consegnato', '2023-05-21');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (8, 'user8', 15, 1, 199.99, 'In transito', '2023-05-22');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (9, 'user9', 6, 1, 999.99, 'Spedito', '2023-05-23');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (10, 'user10', 11, 2, 79.98, 'Consegnato', '2023-05-24');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (11, 'user11', 17, 1, 499.99, 'In transito', '2023-05-25');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (12, 'user12', 7, 1, 1499.99, 'Spedito', '2023-05-26');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (13, 'user13', 9, 2, 59.98, 'Consegnato', '2023-05-27');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (14, 'user14', 8, 1, 799.99, 'In transito', '2023-05-28');

INSERT INTO ordine (id_ordine, username, codice, quant_prod, prezzo, stato_ord, data_ord)
VALUES (15, 'user15', 12, 1, 499.99, 'Spedito', '2023-05-29');



