-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 07, 2025 alle 18:49
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
-- Database: `terminal_marittimi`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `autista`
--

CREATE TABLE `autista` (
  `ID` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `buono`
--

CREATE TABLE `buono` (
  `ID` int(11) NOT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `id_polizza` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` char(20) NOT NULL,
  `id_autista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `nome` varchar(128) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `ID` int(11) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `giorni_gratis` int(11) DEFAULT NULL,
  `tariffa` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `ID` int(11) NOT NULL,
  `nome` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `polizza`
--

CREATE TABLE `polizza` (
  `ID` int(11) NOT NULL,
  `tipo_merce` varchar(64) DEFAULT NULL,
  `peso_tot` decimal(10,2) DEFAULT NULL,
  `id_fornitore` int(11) DEFAULT NULL,
  `id_viaggio` int(11) DEFAULT NULL,
  `porto_carico` int(11) DEFAULT NULL,
  `porto_destinazione` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `ID` int(11) NOT NULL,
  `nome` varchar(128) DEFAULT NULL,
  `nazione` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `ritiro`
--

CREATE TABLE `ritiro` (
  `ID` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `id_buono` int(11) DEFAULT NULL,
  `targa_camion` char(20) DEFAULT NULL,
  `id_autista` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `staff`
--

CREATE TABLE `staff` (
  `ID` int(11) NOT NULL,
  `nome` varchar(128) NOT NULL,
  `ruolo` enum('Operatore Logistica','Manutentore','Coordinatore','Carrellista','Addetto alla Documentazione','Addetto Ufficio Merci','Tecnico delle Spedizioni','Tecnico dei Trasporti') NOT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `nome` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `ruolo` enum('ADMIN','USER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `ID` int(11) NOT NULL,
  `data_partenza` date DEFAULT NULL,
  `data_allibramento` date DEFAULT NULL,
  `linea` varchar(256) DEFAULT NULL,
  `porto_partenza` int(11) DEFAULT NULL,
  `porto_arrivo` int(11) DEFAULT NULL,
  `id_nave` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autista`
--
ALTER TABLE `autista`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_user` (`id_user`);

--
-- Indici per le tabelle `buono`
--
ALTER TABLE `buono`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`),
  ADD KEY `id_autista` (`id_autista`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_user` (`id_user`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `polizza`
--
ALTER TABLE `polizza`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_fornitore` (`id_fornitore`),
  ADD KEY `id_viaggio` (`id_viaggio`),
  ADD KEY `porto_carico` (`porto_carico`),
  ADD KEY `porto_destinazione` (`porto_destinazione`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `ritiro`
--
ALTER TABLE `ritiro`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_buono` (`id_buono`),
  ADD KEY `targa_camion` (`targa_camion`),
  ADD KEY `id_autista` (`id_autista`);

--
-- Indici per le tabelle `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_user` (`id_user`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`),
  ADD KEY `id_nave` (`id_nave`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `staff`
--
ALTER TABLE `staff`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `autista`
--
ALTER TABLE `autista`
  ADD CONSTRAINT `autista_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`ID`);

--
-- Limiti per la tabella `buono`
--
ALTER TABLE `buono`
  ADD CONSTRAINT `buono_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizza` (`ID`),
  ADD CONSTRAINT `buono_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`);

--
-- Limiti per la tabella `camion`
--
ALTER TABLE `camion`
  ADD CONSTRAINT `camion_ibfk_1` FOREIGN KEY (`id_autista`) REFERENCES `autista` (`ID`) ON UPDATE CASCADE;

--
-- Limiti per la tabella `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`ID`);

--
-- Limiti per la tabella `polizza`
--
ALTER TABLE `polizza`
  ADD CONSTRAINT `polizza_ibfk_1` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`ID`),
  ADD CONSTRAINT `polizza_ibfk_2` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`ID`),
  ADD CONSTRAINT `polizza_ibfk_3` FOREIGN KEY (`porto_carico`) REFERENCES `porto` (`ID`),
  ADD CONSTRAINT `polizza_ibfk_4` FOREIGN KEY (`porto_destinazione`) REFERENCES `porto` (`ID`);

--
-- Limiti per la tabella `ritiro`
--
ALTER TABLE `ritiro`
  ADD CONSTRAINT `ritiro_ibfk_1` FOREIGN KEY (`id_buono`) REFERENCES `buono` (`ID`),
  ADD CONSTRAINT `ritiro_ibfk_2` FOREIGN KEY (`targa_camion`) REFERENCES `camion` (`targa`),
  ADD CONSTRAINT `ritiro_ibfk_3` FOREIGN KEY (`id_autista`) REFERENCES `autista` (`ID`);

--
-- Limiti per la tabella `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`ID`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`ID`),
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`ID`),
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`id_nave`) REFERENCES `nave` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
