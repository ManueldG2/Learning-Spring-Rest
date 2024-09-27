
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
(22, 'risme carta per fotocopie Buffetti Superior', 'Carta multifunzione, utilizzabile in base alle proprie necessità (stampe, fotocopie, fax,...). . Prodotta con cellulosa ECF e in conformità con la norma ISO 9706 (Long Life). Certificata PEFC™', 'Buffetti A4 bianco Peso g/mq 80 Punto di bianco: CIE 144 Grammatura: 80 g Nr. fogli / risma: 500 Unità di vendita: conf. da 5 risme', 4, 5, 'risme', '004906CNF', 22.75, 2),
(82, 'prova', 'prova', 'prova', 4, 10, 'Pz', 'xxxx', 23.00, 2),
(84, 'prova', 'prova', 'prova', 4, 10, 'Pz', 'xxxx', 23.00, 2);
