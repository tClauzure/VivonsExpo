-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 02 Avril 2021 à 16:23
-- Version du serveur :  10.1.26-MariaDB-0+deb9u1
-- Version de PHP :  7.0.19-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tclauzure_VivonsExpo`
--

-- --------------------------------------------------------

--
-- Structure de la table `ALLEE`
--

CREATE TABLE `ALLEE` (
  `numH` varchar(1) NOT NULL,
  `codeA` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `ALLEE`
--

INSERT INTO `ALLEE` (`numH`, `codeA`) VALUES
('1', 'A'),
('1', 'B'),
('1', 'C'),
('1', 'D');

-- --------------------------------------------------------

--
-- Structure de la table `DEMANDE`
--

CREATE TABLE `DEMANDE` (
  `numD` varchar(4) NOT NULL,
  `dateD` date DEFAULT NULL,
  `motif` varchar(40) DEFAULT NULL,
  `login` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `HALL`
--

CREATE TABLE `HALL` (
  `numH` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `HALL`
--

INSERT INTO `HALL` (`numH`) VALUES
('1'),
('2'),
('3'),
('4');

-- --------------------------------------------------------

--
-- Structure de la table `SECTEUR`
--

CREATE TABLE `SECTEUR` (
  `codeS` varchar(2) NOT NULL,
  `libelleS` varchar(25) DEFAULT NULL,
  `codeU` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `SECTEUR`
--

INSERT INTO `SECTEUR` (`codeS`, `libelleS`, `codeU`) VALUES
('1', 'amélioration habitat', '2'),
('10', 'presse', '2'),
('11', 'vivons bois', '2'),
('12', 'équipements sportifs', '1'),
('13', 'ligues et comités', '1'),
('14', 'neige', '1'),
('15', 'cadeaux', '3'),
('16', 'créateurs', '3'),
('17', 'épicerie fine', '3'),
('18', 'producteurs', '3'),
('19', 'vins et spiritueux', '3'),
('2', 'ameublement', '2'),
('20', 'auto', '4'),
('21', 'roulez loisirs', '4'),
('22', 'camping cars', '5'),
('23', 'organisme de financement', '5'),
('24', 'véhicules occasions', '5'),
('3', 'cheminées', '2'),
('4', 'cuisines', '2'),
('5', 'décoration', '2'),
('6', 'equipement ménager', '2'),
('7', 'immobilier', '2'),
('8', 'paysagiste', '2'),
('9', 'piscines', '2');

-- --------------------------------------------------------

--
-- Structure de la table `STAND`
--

CREATE TABLE `STAND` (
  `numH_HALL_ALLEE` varchar(1) NOT NULL,
  `codeA` varchar(2) NOT NULL,
  `numH_HALL_TRAVEE` varchar(1) NOT NULL,
  `numT` varchar(2) NOT NULL,
  `numS` varchar(3) NOT NULL,
  `login` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `STAND`
--

INSERT INTO `STAND` (`numH_HALL_ALLEE`, `codeA`, `numH_HALL_TRAVEE`, `numT`, `numS`, `login`) VALUES
('1', 'B', '1', '17', '1', 'sanaejones');

-- --------------------------------------------------------

--
-- Structure de la table `TRAVEE`
--

CREATE TABLE `TRAVEE` (
  `numH` varchar(1) NOT NULL,
  `numT` varchar(2) NOT NULL,
  `codeS` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `TRAVEE`
--

INSERT INTO `TRAVEE` (`numH`, `numT`, `codeS`) VALUES
('1', '15', '10'),
('1', '8', '10'),
('1', '30', '12'),
('1', '31', '12'),
('1', '32', '13'),
('1', '33', '13'),
('1', '34', '14'),
('1', '35', '14'),
('1', '16', '15'),
('1', '17', '16'),
('1', '18', '18'),
('1', '10', '2'),
('1', '14', '2'),
('1', '1', '20'),
('1', '2', '20'),
('1', '3', '20'),
('1', '4', '21'),
('1', '5', '21'),
('1', '6', '21'),
('1', '7', '21'),
('1', '9', '5'),
('1', '12', '8'),
('1', '13', '8'),
('1', '11', '9');

-- --------------------------------------------------------

--
-- Structure de la table `UNIVERS`
--

CREATE TABLE `UNIVERS` (
  `codeU` varchar(3) NOT NULL,
  `libelleU` varchar(25) DEFAULT NULL,
  `numH` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `UNIVERS`
--

INSERT INTO `UNIVERS` (`codeU`, `libelleU`, `numH`) VALUES
('1', 'Sport', '1'),
('2', 'Maison', '1'),
('3', 'Fetes', '1'),
('4', 'Auto', '1'),
('5', 'Evasions', '3');

-- --------------------------------------------------------

--
-- Structure de la table `UTILISATEUR`
--

CREATE TABLE `UTILISATEUR` (
  `login` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `telephone` varchar(14) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `typeUtilisateur` varchar(20) NOT NULL,
  `raisonSociale` varchar(40) DEFAULT NULL,
  `activite` varchar(25) DEFAULT NULL,
  `anneeInscription` int(11) DEFAULT NULL,
  `siteInternet` varchar(14) NOT NULL,
  `exposer` tinyint(1) NOT NULL,
  `codeS` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `UTILISATEUR`
--

INSERT INTO `UTILISATEUR` (`login`, `mdp`, `nom`, `prenom`, `telephone`, `mail`, `typeUtilisateur`, `raisonSociale`, `activite`, `anneeInscription`, `siteInternet`, `exposer`, `codeS`) VALUES
('loulou', 'loulou', 'lou', 'lou', '0625245178', 'loulou@outlook.fr', 'staff', NULL, NULL, NULL, '', 0, '1'),
('sanaejones', 'sanaejones', 'Jones', 'Sanae', '0699117838', 'sanaejones@gmail.com', 'exposant', 'Morpho Bleu', 'librairie', 2021, 'morphobleu.com', 1, '16');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ALLEE`
--
ALTER TABLE `ALLEE`
  ADD PRIMARY KEY (`numH`,`codeA`);

--
-- Index pour la table `DEMANDE`
--
ALTER TABLE `DEMANDE`
  ADD PRIMARY KEY (`numD`),
  ADD KEY `DEMANDE_UTILISATEUR_FK` (`login`);

--
-- Index pour la table `HALL`
--
ALTER TABLE `HALL`
  ADD PRIMARY KEY (`numH`);

--
-- Index pour la table `SECTEUR`
--
ALTER TABLE `SECTEUR`
  ADD PRIMARY KEY (`codeS`),
  ADD KEY `SECTEUR_UNIVERS_FK` (`codeU`);

--
-- Index pour la table `STAND`
--
ALTER TABLE `STAND`
  ADD PRIMARY KEY (`numH_HALL_ALLEE`,`codeA`,`numH_HALL_TRAVEE`,`numT`,`numS`),
  ADD KEY `STAND_TRAVEE_FK` (`numH_HALL_TRAVEE`,`numT`),
  ADD KEY `STAND_UTILISATEUR_FK` (`login`);

--
-- Index pour la table `TRAVEE`
--
ALTER TABLE `TRAVEE`
  ADD PRIMARY KEY (`numH`,`numT`),
  ADD KEY `TRAVEE_SECTEUR0_FK` (`codeS`);

--
-- Index pour la table `UNIVERS`
--
ALTER TABLE `UNIVERS`
  ADD PRIMARY KEY (`codeU`),
  ADD KEY `UNIVERS_HALL_FK` (`numH`);

--
-- Index pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  ADD PRIMARY KEY (`login`),
  ADD KEY `UTILISATEUR_SECTEUR0_FK` (`codeS`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ALLEE`
--
ALTER TABLE `ALLEE`
  ADD CONSTRAINT `ALLEE_HALL_FK` FOREIGN KEY (`numH`) REFERENCES `HALL` (`numH`);

--
-- Contraintes pour la table `DEMANDE`
--
ALTER TABLE `DEMANDE`
  ADD CONSTRAINT `DEMANDE_UTILISATEUR_FK` FOREIGN KEY (`login`) REFERENCES `UTILISATEUR` (`login`);

--
-- Contraintes pour la table `SECTEUR`
--
ALTER TABLE `SECTEUR`
  ADD CONSTRAINT `SECTEUR_UNIVERS_FK` FOREIGN KEY (`codeU`) REFERENCES `UNIVERS` (`codeU`);

--
-- Contraintes pour la table `STAND`
--
ALTER TABLE `STAND`
  ADD CONSTRAINT `STAND_ALLEE_FK` FOREIGN KEY (`numH_HALL_ALLEE`,`codeA`) REFERENCES `ALLEE` (`numH`, `codeA`),
  ADD CONSTRAINT `STAND_TRAVEE_FK` FOREIGN KEY (`numH_HALL_TRAVEE`,`numT`) REFERENCES `TRAVEE` (`numH`, `numT`),
  ADD CONSTRAINT `STAND_UTILISATEUR_FK` FOREIGN KEY (`login`) REFERENCES `UTILISATEUR` (`login`);

--
-- Contraintes pour la table `TRAVEE`
--
ALTER TABLE `TRAVEE`
  ADD CONSTRAINT `TRAVEE_HALL_FK` FOREIGN KEY (`numH`) REFERENCES `HALL` (`numH`),
  ADD CONSTRAINT `TRAVEE_SECTEUR0_FK` FOREIGN KEY (`codeS`) REFERENCES `SECTEUR` (`codeS`);

--
-- Contraintes pour la table `UNIVERS`
--
ALTER TABLE `UNIVERS`
  ADD CONSTRAINT `UNIVERS_HALL_FK` FOREIGN KEY (`numH`) REFERENCES `HALL` (`numH`);

--
-- Contraintes pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  ADD CONSTRAINT `UTILISATEUR_SECTEUR0_FK` FOREIGN KEY (`codeS`) REFERENCES `SECTEUR` (`codeS`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
