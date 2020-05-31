-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 28 mai 2020 à 18:14
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
-- Base de données :  `eceplanning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom` (`Nom`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `Nom`) VALUES
(1, 'Java'),
(2, 'Mathématiques'),
(3, 'Thermodynamique');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  UNIQUE KEY `ID_Utilisateur` (`ID_Utilisateur`,`ID_Cours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES
(3, 1),
(8, 1),
(9, 2),
(10, 3);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `Numero` int(11) DEFAULT NULL,
  `ID_Groupe` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  UNIQUE KEY `ID_Utilisateur` (`ID_Utilisateur`),
  UNIQUE KEY `Numero` (`Numero`,`ID_Groupe`),
  KEY `etudiant_ibfk_2` (`ID_Groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(5, NULL, 1),
(6, NULL, 2),
(7, NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `ID_Promotion` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom` (`Nom`,`ID_Promotion`),
  KEY `ID_Promotion` (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `Nom`, `ID_Promotion`) VALUES
(1, 'Gr01', 1),
(2, 'Gr02', 2);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom` (`Nom`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `Nom`) VALUES
(1, 'Ing1'),
(2, 'Ing2'),
(3, 'Ing3');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacite` int(11) DEFAULT NULL,
  `ID_Site` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Site` (`ID_Site`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `Nom`, `Capacite`, `ID_Site`) VALUES
(1, 'E1 - Salle 1', NULL, 1),
(2, 'E1 - Salle 2', NULL, 1),
(3, 'E2 - Salle 1', NULL, 2),
(4, 'E2 - Salle 2', NULL, 2),
(5, 'E3 - Salle 1', NULL, 3),
(6, 'E2 - Salle 2', NULL, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Heure_Debut` time DEFAULT NULL,
  `Heure_Fin` time DEFAULT NULL,
  `Etat` int(11) DEFAULT NULL,
  `ID_Cours` int(11) NOT NULL,
  `ID_Type` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Cours` (`ID_Cours`),
  KEY `ID_Type` (`ID_Type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),
  KEY `ID_Enseignant` (`ID_Enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Groupe`),
  KEY `ID_Groupe` (`ID_Groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  KEY `ID_Salle` (`ID_Salle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom` (`Nom`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `Nom`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom` (`Nom`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `Nom`) VALUES
(1, 'Cours interactif'),
(2, 'Cours magistral'),
(5, 'Projet'),
(6, 'Soutien'),
(3, 'TD'),
(4, 'TP');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Passwd` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES
(1, 'administrateur@edu.ece.fr', 'mdpA', 'nomA', 'prenomA', 1),
(2, 'referentpedagogique@edu.ece.fr', 'mdpRP', 'nomRP', 'prenomRP', 2),
(3, 'enseignant@edu.ece.fr', 'mdpE', 'nomE', 'prenomE', 3),
(4, 'etudiant@edu.ece.fr', 'mdpEt', 'nomEt', 'prenomEt', 4),
(5, 'kevin.koy@edu.ece.fr', 'looool', 'Koy', 'Kevin', 4),
(6, 'alice.cabane@edu.ece.fr', 'grosse', 'Cabane', 'Alice', 4),
(7, 'sylvain.louche@edu.ece.fr', 'sl', 'Louche', 'Sylvain', 4),
(8, 'enseignant1@edu.ece.fr', 'mdpE1', 'nomE1', 'prenomE1', 3),
(9, 'enseignant2@edu.ece.fr', 'mdpE2', 'nomE2', 'prenomE2', 3),
(10, 'enseignant3@edu.ece.fr', 'mdpE3', 'nomE3', 'prenomE3', 3),
(22, 'tester@gmail.com', 'tester_mdp', 'tester_nom', 'tester_prenom', 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`ID_Promotion`) REFERENCES `promotion` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_Site`) REFERENCES `site` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_Type`) REFERENCES `type_cours` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`ID_Enseignant`) REFERENCES `enseignant` (`ID_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_enseignants_ibfk_3` FOREIGN KEY (`ID_Enseignant`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `seance_groupes_ibfk_1` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_groupes_ibfk_2` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`ID_Salle`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
