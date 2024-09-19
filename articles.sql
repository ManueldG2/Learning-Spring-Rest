-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 19, 2024 alle 12:12
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
-- Database: `articles`
--

DELIMITER $$
--
-- Procedure
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `article-all` ()  NO SQL SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `article-id` (IN `getid` INT)   SELECT article.title, article.description, article.characteristic, category.name as category, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  
FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id
AND article.id=getid$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `warehouse-all` ()  NO SQL SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `warehouse-id` (IN `getid` INT)   SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id AND warehouse.id = getid$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `article`
--

CREATE TABLE `article` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `characteristic` varchar(255) DEFAULT NULL,
  `category` bigint(20) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `unity` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `price` float(7,2) NOT NULL,
  `warehouse_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `article`
--

INSERT INTO `article` (`id`, `title`, `description`, `characteristic`, `category`, `quantity`, `unity`, `code`, `price`, `warehouse_id`) VALUES
(19, 'Matite', 'confezione da 10 ', 'HB\r\nsenza gommino', 2, 10, 'Pz', '003801JHB', 0.60, 2),
(20, 'Penna a sfera Cristal® Medium Conf. 50pz', 'appuccio e tappino del colore dell\'inchiostro, fusto esagonale trasparente per il controllo dell\'inchiostro. Cappuccio anti soffocamento. La Cristal® Medium ha ottenuto la certificazione “NF Environment” e SGS rispettivamente per 3000 metri di scrittura.', 'Brand Bic Colore blu Punta 1 mm Tipo punta Medium Classic Caratteristiche con cappuccio Unità di vendita conf. da 50 penne', 3, 50, 'Pz', '031070D00', 19.75, 2),
(22, 'risme carta per fotocopie Buffetti Superior', 'Carta multifunzione, utilizzabile in base alle proprie necessità (stampe, fotocopie, fax,...). . Prodotta con cellulosa ECF e in conformità con la norma ISO 9706 (Long Life). Certificata PEFC™', 'Buffetti A4 bianco Peso g/mq 80 Punto di bianco: CIE 144 Grammatura: 80 g Nr. fogli / risma: 500 Unità di vendita: conf. da 5 risme', 4, 5, 'risme', '004906CNF', 22.75, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'matite'),
(3, 'penne'),
(4, 'carta');

-- --------------------------------------------------------

--
-- Struttura della tabella `warehouse`
--

CREATE TABLE `warehouse` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `warehouse`
--

INSERT INTO `warehouse` (`id`, `amount`, `position`) VALUES
(2, 100, 'scaffale 5');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article_category` (`category`),
  ADD KEY `article_warehouse` (`warehouse_id`);

--
-- Indici per le tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `article`
--
ALTER TABLE `article`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT per la tabella `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `article_warehouse` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
