
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
