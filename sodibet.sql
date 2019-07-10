-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 10 juil. 2019 à 05:09
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sodibet`
--
CREATE DATABASE IF NOT EXISTS `sodibet` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sodibet`;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` char(56) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
('AD01', 'Admin', 'RZUddvKKwHqSW1igAT6QvxRyc2EvIo8n7e8Oy/K4ocTcw0qG+HjUkQ==');

-- --------------------------------------------------------

--
-- Structure de la table `continue_jumelle`
--

DROP TABLE IF EXISTS `continue_jumelle`;
CREATE TABLE IF NOT EXISTS `continue_jumelle` (
  `id_continue_jumelle` int(11) NOT NULL AUTO_INCREMENT,
  `epaisseurX` int(11) NOT NULL,
  `epaisseurY` int(11) NOT NULL,
  `charge_150` decimal(4,2) NOT NULL,
  `charge_250` decimal(4,2) NOT NULL,
  `charge_400` decimal(4,2) NOT NULL,
  `charge_500` decimal(4,2) NOT NULL,
  `charge_150T` decimal(4,2) NOT NULL,
  `charge_100T` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_continue_jumelle`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `continue_jumelle`
--

INSERT INTO `continue_jumelle` (`id_continue_jumelle`, `epaisseurX`, `epaisseurY`, `charge_150`, `charge_250`, `charge_400`, `charge_500`, `charge_150T`, `charge_100T`) VALUES
(1, 12, 4, '5.52', '5.25', '5.02', '4.85', '5.38', '5.50'),
(2, 16, 4, '6.50', '6.22', '5.89', '5.72', '6.34', '6.49'),
(3, 16, 5, '6.68', '6.40', '6.07', '5.88', '6.53', '6.68'),
(4, 16, 6, '6.93', '6.64', '6.30', '6.11', '6.77', '6.93'),
(5, 20, 5, '7.59', '7.27', '6.90', '6.69', '7.43', '7.60'),
(6, 20, 6, '7.84', '7.51', '7.12', '6.91', '7.67', '7.85'),
(7, 20, 7, '8.07', '7.74', '7.34', '7.12', '7.90', '8.08'),
(8, 25, 5, '8.43', '8.08', '7.65', '7.43', '8.26', '8.45'),
(9, 25, 6, '8.68', '8.32', '7.88', '7.65', '8.51', '8.70'),
(10, 25, 7, '8.90', '8.54', '8.09', '7.85', '8.74', '8.94'),
(11, 25, 8, '9.11', '8.74', '8.28', '8.04', '8.95', '9.15'),
(12, 30, 5, '9.36', '8.98', '8.52', '8.27', '9.19', '9.39'),
(13, 30, 6, '9.60', '9.22', '8.74', '8.49', '9.43', '9.64'),
(14, 30, 7, '9.82', '9.43', '8.95', '8.69', '9.66', '9.87'),
(15, 30, 8, '10.04', '9.63', '9.15', '8.88', '9.87', '10.07'),
(16, 30, 10, '10.42', '10.00', '9.52', '9.24', '10.24', '10.45');

-- --------------------------------------------------------

--
-- Structure de la table `continue_simple`
--

DROP TABLE IF EXISTS `continue_simple`;
CREATE TABLE IF NOT EXISTS `continue_simple` (
  `id_continue_simple` int(11) NOT NULL AUTO_INCREMENT,
  `epaisseurX` int(11) NOT NULL,
  `epaisseurY` int(11) NOT NULL,
  `charge_150` decimal(4,2) NOT NULL,
  `charge_250` decimal(4,2) NOT NULL,
  `charge_400` decimal(4,2) NOT NULL,
  `charge_500` decimal(4,2) NOT NULL,
  `charge_150T` decimal(4,2) NOT NULL,
  `charge_100T` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_continue_simple`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `continue_simple`
--

INSERT INTO `continue_simple` (`id_continue_simple`, `epaisseurX`, `epaisseurY`, `charge_150`, `charge_250`, `charge_400`, `charge_500`, `charge_150T`, `charge_100T`) VALUES
(1, 12, 4, '5.16', '4.91', '4.62', '4.44', '5.03', '5.15'),
(2, 16, 4, '6.05', '5.78', '5.46', '5.28', '5.91', '6.06'),
(3, 16, 5, '6.21', '5.93', '5.60', '5.42', '6.07', '6.22'),
(4, 16, 6, '6.42', '6.13', '5.79', '5.61', '6.28', '6.44'),
(5, 20, 5, '7.05', '6.73', '6.35', '6.15', '6.90', '7.06'),
(6, 20, 6, '7.26', '6.93', '6.55', '6.34', '7.12', '7.29'),
(7, 20, 7, '7.46', '7.12', '6.73', '6.52', '7.32', '7.49'),
(8, 25, 5, '7.81', '7.45', '7.03', '6.81', '7.66', '7.86'),
(9, 25, 6, '8.02', '7.66', '7.23', '6.99', '7.88', '8.07'),
(10, 25, 7, '8.22', '7.85', '7.41', '7.17', '8.08', '8.27'),
(11, 25, 8, '8.40', '8.02', '7.57', '7.33', '8.25', '8.45'),
(12, 30, 5, '8.67', '8.28', '7.82', '7.57', '8.52', '8.73'),
(13, 30, 6, '8.89', '8.49', '8.01', '7.77', '8.74', '8.95'),
(14, 30, 7, '9.09', '8.68', '8.21', '7.95', '8.94', '9.15'),
(15, 30, 8, '9.26', '8.86', '8.38', '8.11', '9.12', '9.34'),
(16, 30, 10, '9.59', '9.17', '8.68', '8.41', '9.44', '9.67');

-- --------------------------------------------------------

--
-- Structure de la table `isostatique_jumelle`
--

DROP TABLE IF EXISTS `isostatique_jumelle`;
CREATE TABLE IF NOT EXISTS `isostatique_jumelle` (
  `id_isostatique_jumelle` int(11) NOT NULL AUTO_INCREMENT,
  `epaisseurX` int(11) NOT NULL,
  `epaisseurY` int(11) NOT NULL,
  `charge_150` decimal(4,2) NOT NULL,
  `charge_250` decimal(4,2) NOT NULL,
  `charge_400` decimal(4,2) NOT NULL,
  `charge_500` decimal(4,2) NOT NULL,
  `charge_150T` decimal(4,2) NOT NULL,
  `charge_100T` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_isostatique_jumelle`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `isostatique_jumelle`
--

INSERT INTO `isostatique_jumelle` (`id_isostatique_jumelle`, `epaisseurX`, `epaisseurY`, `charge_150`, `charge_250`, `charge_400`, `charge_500`, `charge_150T`, `charge_100T`) VALUES
(1, 12, 4, '5.16', '5.03', '4.80', '4.66', '5.02', '5.10'),
(2, 16, 4, '6.03', '5.86', '5.62', '5.49', '5.87', '5.97'),
(3, 16, 5, '6.13', '5.95', '5.71', '5.57', '5.97', '6.06'),
(4, 16, 6, '6.36', '6.16', '5.92', '5.77', '6.19', '6.29'),
(5, 20, 5, '7.02', '6.81', '6.53', '6.38', '6.86', '6.96'),
(6, 20, 6, '7.17', '6.95', '6.67', '6.51', '7.00', '7.11'),
(7, 20, 7, '7.37', '7.15', '6.86', '6.70', '7.20', '7.31'),
(8, 25, 5, '7.76', '7.52', '7.21', '7.03', '7.59', '7.70'),
(9, 25, 6, '7.99', '7.74', '7.43', '7.25', '7.81', '7.94'),
(10, 25, 7, '8.13', '7.87', '7.55', '7.37', '7.95', '8.07'),
(11, 25, 8, '8.30', '8.05', '7.73', '7.54', '8.13', '8.26'),
(12, 30, 5, '8.66', '8.38', '7.99', '7.80', '8.47', '8.60'),
(13, 30, 6, '8.86', '8.59', '8.25', '8.05', '8.68', '8.82'),
(14, 30, 7, '9.00', '8.72', '8.37', '8.17', '8.81', '8.95'),
(15, 30, 8, '9.18', '8.90', '8.55', '8.34', '9.00', '9.14'),
(16, 30, 10, '9.55', '9.26', '8.89', '8.68', '9.37', '9.52');

-- --------------------------------------------------------

--
-- Structure de la table `isostatique_simple`
--

DROP TABLE IF EXISTS `isostatique_simple`;
CREATE TABLE IF NOT EXISTS `isostatique_simple` (
  `id_isostatique_simple` int(11) NOT NULL AUTO_INCREMENT,
  `epaisseurX` int(11) NOT NULL,
  `epaisseurY` int(11) NOT NULL,
  `charge_150` decimal(4,2) NOT NULL,
  `charge_250` decimal(4,2) NOT NULL,
  `charge_400` decimal(4,2) NOT NULL,
  `charge_500` decimal(4,2) NOT NULL,
  `charge_150T` decimal(4,2) NOT NULL,
  `charge_100T` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_isostatique_simple`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `isostatique_simple`
--

INSERT INTO `isostatique_simple` (`id_isostatique_simple`, `epaisseurX`, `epaisseurY`, `charge_150`, `charge_250`, `charge_400`, `charge_500`, `charge_150T`, `charge_100T`) VALUES
(1, 12, 4, '4.75', '4.57', '4.35', '4.22', '4.58', '4.66'),
(2, 16, 4, '5.60', '5.42', '5.22', '5.09', '5.48', '5.57'),
(3, 16, 5, '5.73', '5.55', '5.31', '5.18', '5.59', '5.68'),
(4, 16, 6, '5.93', '5.73', '5.49', '5.36', '5.78', '5.88'),
(5, 20, 5, '6.46', '6.25', '5.98', '5.82', '6.30', '6.41'),
(6, 20, 6, '6.69', '6.47', '6.19', '6.04', '6.53', '6.64'),
(7, 20, 7, '6.86', '6.64', '6.35', '6.20', '6.71', '6.82'),
(8, 25, 5, '7.15', '6.91', '6.60', '6.44', '7.00', '7.11'),
(9, 25, 6, '7.37', '7.13', '6.82', '6.64', '7.22', '7.34'),
(10, 25, 7, '7.54', '7.29', '6.98', '6.80', '7.39', '7.52'),
(11, 25, 8, '7.70', '7.45', '7.12', '6.94', '7.55', '7.67'),
(12, 30, 5, '7.88', '7.62', '7.30', '7.10', '7.72', '7.85'),
(13, 30, 6, '8.07', '7.81', '7.47', '7.28', '7.91', '8.05'),
(14, 30, 7, '8.24', '7.97', '7.63', '7.44', '8.08', '8.23'),
(15, 30, 8, '8.40', '8.13', '7.78', '7.58', '8.24', '8.39'),
(16, 30, 10, '8.69', '8.40', '8.04', '7.85', '8.53', '8.68');

-- --------------------------------------------------------

--
-- Structure de la table `litrage`
--

DROP TABLE IF EXISTS `litrage`;
CREATE TABLE IF NOT EXISTS `litrage` (
  `id_litrage` int(11) NOT NULL AUTO_INCREMENT,
  `epaisseurX` int(11) NOT NULL,
  `epaisseurY` int(11) NOT NULL,
  `consommation` decimal(4,1) NOT NULL,
  PRIMARY KEY (`id_litrage`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `litrage`
--

INSERT INTO `litrage` (`id_litrage`, `epaisseurX`, `epaisseurY`, `consommation`) VALUES
(1, 12, 4, '52.2'),
(2, 12, 5, '62.2'),
(3, 12, 6, '72.2'),
(4, 12, 7, '82.2'),
(5, 12, 8, '92.2'),
(6, 12, 9, '102.2'),
(7, 12, 10, '112.2'),
(8, 16, 4, '61.0'),
(9, 16, 5, '71.0'),
(10, 16, 6, '81.0'),
(11, 16, 7, '91.0'),
(12, 16, 8, '101.0'),
(13, 16, 9, '111.0'),
(14, 16, 10, '121.0'),
(15, 20, 5, '92.5'),
(16, 20, 6, '102.5'),
(17, 20, 7, '112.5'),
(18, 20, 8, '122.5'),
(19, 20, 9, '132.5'),
(20, 20, 10, '142.5'),
(21, 25, 5, '94.0'),
(22, 25, 6, '104.0'),
(23, 25, 7, '114.0'),
(24, 25, 8, '124.0'),
(25, 25, 9, '134.0'),
(26, 25, 10, '144.0'),
(27, 30, 5, '106.0'),
(28, 30, 6, '116.0'),
(29, 30, 7, '126.0'),
(30, 30, 8, '136.0'),
(31, 30, 9, '146.0'),
(32, 30, 10, '156.0');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `mot_de_passe` char(56) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `sous_categorie` varchar(255) NOT NULL,
  `valide` int(11) NOT NULL DEFAULT '0',
  `portee_1` int(11) NOT NULL DEFAULT '0',
  `portee_2` int(11) NOT NULL DEFAULT '0',
  `portee_3` int(11) NOT NULL DEFAULT '0',
  `portee_4` int(11) NOT NULL DEFAULT '0',
  `date_inscription` date NOT NULL,
  `valide_hash` char(56) NOT NULL,
  `date_connexion` date DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `prenom`, `nom`, `date_naissance`, `email`, `ville`, `mot_de_passe`, `categorie`, `sous_categorie`, `valide`, `portee_1`, `portee_2`, `portee_3`, `portee_4`, `date_inscription`, `valide_hash`, `date_connexion`) VALUES
(22, 'jilali', 'sqkdjjsf', '2019-12-16', 'sdf@gmail.com', 'casablanca', 'RZUddvKKwHqSW1igAT6QvxRyc2EvIo8n7e8Oy/K4ocTcw0qG+HjUkQ==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-04-02', 'RZUddvKKwHqZ3TOXLy7iGsmeC6PESeSCiVwzN0Svj0qJAm4ZHKh4pA==', NULL),
(50, 'zakaria', 'mahzouli', '2019-06-12', 'sparrowpirate69@gmail.com', 'casa', 'XbJ1eP/hq/I+L0jByo1VWYi240x+OBfnOOZkHclrj5ylWQW/ND0W3g==', 'architecte', 'Agence et bureaux d\'architectures', 1, 0, 0, 0, 0, '2019-06-25', 'ExpckJL5ovv6h2HCnNnfDSngHaqj1i5EFEQnw++6oPGf3jKviAic6w==', '2019-06-25'),
(25, 'Mohamed', 'El hentour', '1997-01-22', 'elhentour.mohamed@gmail.com', 'Casablanca', '8BYS+puAgEAUMyqUBvFe/o3r1Pn9IkszigNAeqW1N0kTsQB4nPySxw==', 'ingenieur', 'Eleves ingénieurs', 1, 1, 1, 1, 1, '2019-04-08', 'eS/F/fTQrL1FJw97WKElsGSZOIatzkiMPQBevVaB9bLxcGXQLswXyA==', '2019-07-10'),
(12, 'amal', 'rakan', '2019-03-18', 'narinarijari@gmail.com', 'Casablanca', 'Xl32JKprt/d3qVT70di4/HTqD+4lOcQqH8fA5SZP5/Ygr6Og/MGdAQ==', 'architecte', 'Eleve architecte', 0, 0, 0, 0, 0, '2019-03-03', 'a819l62gjx7Daa2YycWRG8PbWcbgIBVJHt1TK9Q6GG6WEA/o82XbRw==', NULL),
(20, 'sdfsdf', 'sdfsdf', '2019-03-25', 'sdfsdfsd@sdf.com', 'sdfsdfsdf', '1XA/Mmv2NbYhyOrNGtFWU27Za8dMUHxUX/h8eD8K9JQxwV5Jw0MRnw==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-03-19', '1XA/Mmv2NbZzwSkyEezld0awRrGQR2MwofLeWSFwo6J7ewtw0vN4Vw==', NULL),
(38, 'ayman', 'mansour', '1994-05-09', 'ayoubtouzani15@gmail.com', 'casa', 'wDaxRzquPMveuzYBNNqdgo4m89YdQ5H+j1CZywZrpUEanrk8qYa5FA==', 'ingenieur', 'Entreprise de construction', 1, 0, 0, 0, 0, '2019-05-22', 'oYwNUj99tapVXl10u9IPpeXV9bxBqT920MRTk3q6XYLQhrs3+IPqbg==', '2019-05-22'),
(27, 'dflkj', 'lkj', '0541-05-11', 'lkj@df.o', 'lkj', 'XlBFnernXZwD7mbNqL8Ld8XZHsk2urWJThvdKwwrSHvhcCsIG/VoSw==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-01', '42NIdU0yYiI0h1III1xZv7WvtjgGX6kZCsx8wW+b17Tk314B1Zj4Jg==', NULL),
(28, 'qsd', 'qsd', '2019-05-11', 'qsd@gmail.com', 'qsd', '/oeurd5b/ftB2b38zfbWwImtLbVPiBceEcwha7CPtxnMRMHU9nrQgA==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-01', 'QKHX406Vg6fydVBszz6N3Z5nXgMxdOFJGnZNL9cc08yXQeVMwzkzMg==', NULL),
(29, 'd', 'd', '2019-05-10', 'sqd@sqd.com', 'd', 'iZc165sC0AfYUxMqc+bJec4eYZnrh2c86NcNghj375XGaGimr6dVIQ==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-02', 'W/DilrGojgBLO0kWUnE22S7ChI+25XQ3rIclOy0ebkpmxlUKQjFX5g==', NULL),
(30, 'd', 'd', '2019-05-17', 'd@gmail.com', 'c', 'GUoo+O96cUT3c3wqZH/VRU3FeCAtDmTanwdzv9vW8J225HEEE1zVSw==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-02', 'Lo0mDvtmTsgcV0H7NWLa413VWbouK8qIHNoSMlIXR5wlt18NOBUO4Q==', NULL),
(31, 'd', 'd', '2019-05-08', 'aze@gmail.com', 'd', 'qiTtTbd2vRzXZnH2sIxf+xOJpJtbMt0u/Icf882uBYoyzJyr3J/ZOQ==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-02', 'SNMBBWG6ITDXtzp6P7R022BmURNIwHjdYDnJKCUm3D8kAgGPLjdN1w==', NULL),
(32, 'd', 'd', '2019-05-10', 'e@gmail.com', 'd', 'zp6O2xh3iP/HKSnvcB1badWuVsJQxZoJ9fsRb4hOb1x22uE3S3WYdw==', 'architecte', 'Agence et bureaux d\'architectures', 0, 0, 0, 0, 0, '2019-05-02', 'm8V3DgtSvJuhknmfLo8gEdh+8OI6+rcZyKfuEjLLLCRh5aclwx0Qzg==', NULL),
(34, 'Ayoub', 'Touzani', '2001-02-02', 'ab.ettouzani@gmail.com', 'casablanca', 'AqXS0zoSPIP83fRJ+M/PliaV0NbZta/7m/6wQsOepRRWJWv2LYY4AQ==', 'architecte', 'Agence et bureaux d\'architectures', 1, 1, 0, 0, 0, '2019-05-02', 'E0w0ibWZjDgnCAstGypjbB0bKUPj0DiSB3gq2l+uSWwo2Mj5XqiGvg==', '2019-06-28'),
(48, 'Aicha', 'Qarmiche', '1998-03-15', 'Qarmicheaicha400@gmail.com', 'Casablanca', 'enEcX0G+QWKLPx5QItfayjaf3WglNMYnzfMj9AMwJM5XE68KaAQ3VA==', 'ingenieur', 'Eleves ingénieurs', 1, 0, 0, 0, 0, '2019-06-23', 'jLy15iPzEuZj5dN/ALF781eldXz7VYzlsY+9yKn7xT3zmzuLh0fcpQ==', '2019-06-23'),
(39, 'test', 'test', '2019-05-22', 'amine.maachi@sodibet.com', 'temara', 'biAajtZlQMhxwfbIDQ/nJTBzIWvPdjA65QAelQCKBH+KkB/qNeflBg==', 'ingenieur', 'Bureaux d\'étude', 1, 1, 1, 1, 1, '2019-05-22', 'OYnYryic40xyFel17RcTkSKBZj3lmUP4zmuMknnl+gtcXTU1kFnrqA==', '2019-05-23'),
(47, 'Mehdi', 'Sebbata', '1998-01-07', 'sebbatamehdi07@gmail.com', 'Rabat', '8XZok6JmLO2Y/v0WiWOro3hIYzMf2RD3zUXoqq1zLOMmTbaJwEA6Lg==', 'ingenieur', 'Eleves ingénieurs', 1, 0, 1, 0, 0, '2019-06-23', '/pEf2T1jkz3XTs6qddugWtUX0twiX/XZeD+s4uce4d8VNahg9/zb6w==', '2019-06-23'),
(54, 'test', 'test', NULL, 'nerffye@gmail.com', 'Casalbnaca', 'R1d/uHggLyDQsZeZKgmFR0bdegvToep3iJmfJBlshIsGId/r7pp6zg==', 'ingénieur', 'Bureaux de contrôle', 1, 0, 0, 0, 0, '2019-07-10', 'HCyxNLxaYek6hOFylQuqerEDilIxi3kBIQMwc5tmANjOLrS/0/fYrg==', '2019-07-10'),
(49, 'test', 'test', '1995-01-30', 'ghama9837@gmail.com', 'casa', 'vjEf6y1AavAf/E7F/lvuoxCTrkvQPWJCBeYS5yaB79ZE2WcBui4S1g==', 'architecte', 'Eleve architecte', 1, 1, 1, 0, 1, '2019-06-23', '5j0rLtGd2W5WikCnZTGXmmwtVTzcHvHBLx4W2HG5WWast61tc89mfw==', '2019-06-23');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
