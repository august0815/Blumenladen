-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 05. Jul 2014 um 11:48
-- Server Version: 5.5.37-0ubuntu0.14.04.1
-- PHP-Version: 5.5.9-1ubuntu4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `artikel`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `artikel`
--

CREATE TABLE IF NOT EXISTS `artikel` (
  `NUMMER` int(11) NOT NULL,
  `PREIS` double DEFAULT NULL,
  `BESCHREIBUNG` varchar(20) DEFAULT NULL,
  `MWST` double DEFAULT NULL,
  PRIMARY KEY (`NUMMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `artikel`
--

INSERT INTO `artikel` (`NUMMER`, `PREIS`, `BESCHREIBUNG`, `MWST`) VALUES
(123, 10, 'Topf', 0.19),
(124, 20, 'Erde', 0.19),
(125, 30, 'Set', 0.19),
(126, 1, 'Blume', 0.7);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
