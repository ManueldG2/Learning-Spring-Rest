-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 10, 2024 alle 16:25
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cartoleria`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articolo` (
  `id` bigint(20) NOT NULL,
  `titolo` varchar(60) NOT NULL,
  `descrizione` text NOT NULL,
  `caratteristiche` text NOT NULL,
  `categoria` bigint(20) DEFAULT NULL,
  `quantita` int(11) NOT NULL,
  `unita` varchar(60) NOT NULL,
  `codice` varchar(40) NOT NULL,
  `prezzo` float(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `articolo`
--

INSERT INTO `articolo` (`id`, `titolo`, `descrizione`, `caratteristiche`, `categoria`, `quantita`, `unita`, `codice`, `prezzo`) VALUES
(4, 'Matitone Jumbo Graph HB', 'Matita jumbo in formato ergonomico triangolare. Ottime per scrivere, disegnare, realizzare schizzi su carta; ideale per i primi esercizi di scrittura e disegno. Alta qualità del fusto in legno nero con mina solidamente incollata al legno.', 'Brand\r\n	Buffetti\r\nMateriale\r\n	legno e grafite\r\nGradazione\r\n	HB\r\nCaratteristiche\r\n	senza gommino\r\nSezione\r\n	triangolare\r\nUnità di vendita\r\n	pz.', 2, 12, 'Pz', ' Codice: 003801JHB ', 1.50),
(7, 'prova1', 'prova2', 'dfasdfs', 2, 10, 'Pz', 'h501', 1.50),
(8, 'prova1', 'prova2', 'dfasdfs', 2, 10, 'Pz', 'h501', 1.50);

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`id`, `nome`) VALUES
(2, 'matite'),
(3, 'penne');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `articolo_categorie` (`categoria`);

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `articolo`
--
ALTER TABLE `articolo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `articolo`
--
ALTER TABLE `articolo`
  ADD CONSTRAINT `articolo_categorie` FOREIGN KEY (`categoria`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
