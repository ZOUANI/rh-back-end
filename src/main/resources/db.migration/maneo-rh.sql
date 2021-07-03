-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 03 juil. 2021 à 17:18
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `maneo-rh`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `chef_agence` bigint(20) DEFAULT NULL,
  `etat_agence` bigint(20) DEFAULT NULL,
  `ville` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKibofbu1deqtpbx5itnax34r01` (`chef_agence`),
  KEY `FKa5igot73hpshflkvphedyj6eh` (`etat_agence`),
  KEY `FKefm80v4ydiuiq2v11j2uco7pr` (`ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `code`, `libelle`, `chef_agence`, `etat_agence`, `ville`) VALUES
(4, '2020Mara', 'Marrakech-Geuliz', 4, 1, 280502),
(3, '2003Oua', 'Ouaouizeght', 8, 1, 2805);

-- --------------------------------------------------------

--
-- Structure de la table `budget`
--

DROP TABLE IF EXISTS `budget`;
CREATE TABLE IF NOT EXISTS `budget` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_demmande` date DEFAULT NULL,
  `date_reponse` date DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `message_demmande` varchar(255) DEFAULT NULL,
  `message_reponse` varchar(255) DEFAULT NULL,
  `montant` decimal(19,2) DEFAULT NULL,
  `agence` bigint(20) DEFAULT NULL,
  `etat_budget` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71go0up4rcyr8eyessm72rxd2` (`agence`),
  KEY `FK2cc9tax764jayc4pvjemd5bvq` (`etat_budget`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `budget`
--

INSERT INTO `budget` (`id`, `code`, `date_demmande`, `date_reponse`, `libelle`, `message_demmande`, `message_reponse`, `montant`, `agence`, `etat_budget`) VALUES
(20, 'Marrakech-Geuliz112', NULL, '2021-04-06', NULL, NULL, NULL, '10000.00', 4, 2030),
(19, 'Marrakech-Geuliz042', NULL, '2021-06-15', NULL, NULL, NULL, '10000000.00', 4, NULL),
(15, 'Marrakech-Geuliz2033', NULL, '2021-06-06', NULL, NULL, NULL, '200.00', 4, 2018),
(16, 'Marrakech-Geuliz021', NULL, '2021-06-01', NULL, NULL, NULL, '10000.00', 4, 2018),
(17, 'Marrakech-Geuliz022', NULL, '2021-06-02', NULL, NULL, NULL, '7500.00', 4, 2032),
(18, 'Ouaouizeght029', NULL, '2021-06-16', NULL, NULL, NULL, '230000.00', 3, 2018);

-- --------------------------------------------------------

--
-- Structure de la table `calendrier_jour_feries`
--

DROP TABLE IF EXISTS `calendrier_jour_feries`;
CREATE TABLE IF NOT EXISTS `calendrier_jour_feries` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_depart` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `pays` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjlyxt0itkxpd8ar0pe1yac45q` (`pays`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie_collaborateur`
--

DROP TABLE IF EXISTS `categorie_collaborateur`;
CREATE TABLE IF NOT EXISTS `categorie_collaborateur` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie_groupe_tache`
--

DROP TABLE IF EXISTS `categorie_groupe_tache`;
CREATE TABLE IF NOT EXISTS `categorie_groupe_tache` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie_groupe_tache`
--

INSERT INTO `categorie_groupe_tache` (`id`, `code`, `description`, `libelle`) VALUES
(851, '851', '', 'RBAL'),
(1001, '1001', '', 'Calcul de Charge COMAC'),
(1402, '1402', '', 'Aiguillage'),
(1407, '1407', '', 'Field wire'),
(1412, '1412', '', 'Plan GC'),
(1422, '1422', '', 'NETGEO'),
(1423, '1423', NULL, 'PA'),
(1424, '1424', NULL, 'PP'),
(1425, '1425', NULL, 'RAC'),
(1426, '1426', NULL, 'PT'),
(1427, '1427', NULL, 'QPE'),
(1428, '1428', NULL, 'TFX'),
(1429, '1429', NULL, 'APD GC'),
(1430, '1430', NULL, 'DOE CDD'),
(1431, '1431', NULL, 'DOE IMM'),
(1432, '1432', NULL, 'DOE NETGEO'),
(1433, '1433', '', 'APS TR'),
(1434, '1434', '', 'APD TR'),
(1435, '1435', '', 'DOE TR'),
(1436, '1436', '', 'APS Dis'),
(1437, '1437', '', 'APD Dis'),
(1438, '1438', '', 'DOE Dis'),
(1751, '1751', '', 'Classeur'),
(1851, '1851', '', 'Autres'),
(1918, '1918', '', 'DTI'),
(1919, '1919', '', 'PGC'),
(1920, '1920', '', 'CONVENTION'),
(1921, '1921', '', 'PV DU RECEPTION'),
(2101, '2101', '', 'Orange'),
(2102, '2102', '', 'Fiche Préco'),
(2103, '2103', '', 'Formation'),
(2104, '2104', '', 'Distribution'),
(2105, '2105', '', 'DOE GC'),
(2106, '2106', '', 'FAC');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_tache`
--

DROP TABLE IF EXISTS `categorie_tache`;
CREATE TABLE IF NOT EXISTS `categorie_tache` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `categorie_groupe_tache` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdmwi45ov1nja7fmuyvt78m7kf` (`categorie_groupe_tache`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie_tache`
--

INSERT INTO `categorie_tache` (`id`, `code`, `description`, `libelle`, `categorie_groupe_tache`) VALUES
(916, '916', '', 'Préparation des données d\'entrée', 851),
(917, '917', '', 'Vérification des retour terrain', 851),
(953, '953', '', 'Préparation et classification des CR Mairie', 851),
(954, '954', '', 'Réalisation RBAL', 851),
(956, '956', '', 'Control RBAL', 851),
(957, '957', '', 'Reprise RBAL', 851),
(958, '958', '', 'Préparation des DE', 1001),
(959, '959', '', 'Suivi des Relevé+control', 1001),
(960, '960', '', 'Calcul COMAC ', 1001),
(961, '961', '', 'Plan Autocad', 1001),
(962, '962', '', 'APDGC Poteaux', 1001),
(963, '963', '', 'DOE', 1001),
(1403, '1403', '', 'Préparation des données d\'entrée et Intégration Fibees', 1402),
(1404, '1404', '', 'Vérification Retour terrain', 1402),
(1405, '1405', '', 'Réalisation des FOA ', 1402),
(1408, '1408', '', 'Intégration FW', 1407),
(1409, '1409', '', 'Contrôl d\'intégration', 1407),
(1410, '1410', '', 'Réalisation des FOA ', 1407),
(1411, '1411', '', 'Téléchargement des Retours', 1407),
(1413, '1413', '', 'APS GC', 1412),
(1414, '1414', '', 'DT/DICT', 1412),
(1415, '1415', '', 'Fiche preco +Dossier d\'Implantation', 1412),
(1416, '1416', '', 'APD GC + Poteaux', 1412),
(1417, '1417', '', 'Plan Rec GC', 1412),
(1423, '1423', '', 'Vérification des DE', 1422),
(1424, '1424', '', 'Intégration point technique', 1422),
(1425, '1425', '', 'Intégration Support', 1422),
(1426, '1426', '', 'Intégration boîtes optique', 1422),
(1427, '1427', '', 'NDS/NDI', 1422),
(1428, '1428', '', 'Intégration Immeuble', 1422),
(1429, '1429', '', 'Contrôle', 1422),
(1430, '1430', '', 'Reprise', 1422),
(1431, '1431', NULL, 'Vérification des DE', 1423),
(1432, '1432', NULL, 'Réalisation PA', 1423),
(1433, '1433', NULL, 'Vérification du PA +dépose', 1423),
(1434, '1434', NULL, 'Reprise du PA', 1423),
(1435, '1435', NULL, 'Vérification des DE', 1424),
(1436, '1436', NULL, 'Réalisation PP', 1424),
(1437, '1437', NULL, 'Vérification du PP +Dépose', 1424),
(1438, '1438', NULL, 'Reprise du PP', 1424),
(1439, '1439', NULL, 'Intégration sur fibees', 1424),
(1440, '1440', NULL, 'Vérification(Photo FOA +PIT+Relevé Poteaux fibees)', 1425),
(1441, '1441', NULL, 'CDC=C6+C7+fiche Appris', 1425),
(1442, '1442', NULL, 'C3A', 1425),
(1443, '1443', NULL, 'Vérification +dépose', 1425),
(1444, '1444', NULL, 'Reprise', 1425),
(1445, '1445', NULL, 'Vérification des DE', 1426),
(1446, '1446', NULL, 'Réalisation du PT', 1426),
(1447, '1447', NULL, 'Vérification du PT +Dépôse', 1426),
(1448, '1448', NULL, 'Reprise', 1426),
(1449, '1449', NULL, 'Vérification des DE', 1427),
(1450, '1450', NULL, 'Réponse au questionnaire', 1427),
(1451, '1451', NULL, 'Vérification(Photo FOA +PIT+C3B si complexe)', 1428),
(1452, '1452', NULL, 'Réalisation C3A si simple', 1428),
(1453, '1453', NULL, 'Réalisation shp', 1428),
(1454, '1454', NULL, 'Réalisation FOA', 1428),
(1455, '1455', NULL, 'Contôle et dépose', 1428),
(1456, '1456', NULL, 'Vérification des Prérequis', 1429),
(1457, '1457', NULL, 'Réalisation', 1429),
(1458, '1458', NULL, 'Vérification +dépose', 1429),
(1459, '1459', NULL, 'Vérification des Prérequis', 1430),
(1460, '1460', NULL, 'Réalisation', 1430),
(1461, '1461', '', 'Vérification', 1430),
(1462, '1462', NULL, 'Vérification des Prérequis', 1431),
(1463, '1463', NULL, 'Réalisation', 1431),
(1464, '1464', '', 'Vérification', 1431),
(1465, '1465', NULL, 'Vérification des DE', 1432),
(1466, '1466', NULL, 'Réalisation Synoptique', 1432),
(1467, '1467', NULL, 'Réalisation DOE', 1432),
(1468, '1468', NULL, 'Réalisationn Plan de boîte', 1432),
(1469, '1469', NULL, 'Réalisation shapes', 1432),
(1470, '1470', NULL, 'Réalisation KML', 1432),
(1471, '1471', '', 'Vérification', 1432),
(1472, '1472', NULL, 'Reprise', 1432),
(1473, '1473', 'NULL', 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal)', 1433),
(1474, '1474', 'NULL', 'Redécoupage Zasro', 1433),
(1475, '1475', 'NULL', 'Conception Transport Point Technique', 1433),
(1476, '1476', 'NULL', 'Conception Transport Support', 1433),
(1477, '1477', 'NULL', 'Conception Transport Boîte', 1433),
(1478, '1478', 'NULL', 'Conception Transport Câble', 1433),
(1479, '1479', 'NULL', 'Contrôle SIO Niv 2', 1433),
(1480, '1480', 'NULL', 'Reprise', 1433),
(1481, '1481', 'NULL', 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal,Aiguillage)', 1434),
(1482, '1482', 'NULL', 'Redécoupage Zasro', 1434),
(1483, '1483', 'NULL', 'Conception Transport Point Technique', 1434),
(1484, '1484', 'NULL', 'Conception Transport Support', 1434),
(1485, '1485', 'NULL', 'Conception Transport Boîte', 1434),
(1486, '1486', 'NULL', 'Conception Transport Câble', 1434),
(1487, '1487', 'NULL', 'Contrôle SIO Niv 2+Dépose', 1434),
(1488, '1488', 'NULL', 'Vérification des Retour Terrain', 1435),
(1489, '1489', 'NULL', 'Vérification des Fichiers dépisseure+DME+Plan de baie', 1435),
(1490, '1490', 'NULL', 'Réalisation SIOREC', 1435),
(1491, '1491', 'NULL', 'Vérification', 1435),
(1492, '1492', 'NULL', 'Reprise', 1435),
(1493, '1493', 'NULL', 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal+APS TR)', 1436),
(1494, '1494', 'NULL', 'Conception Point Technique', 1436),
(1495, '1495', 'NULL', 'Conception des Supports', 1436),
(1496, '1496', 'NULL', 'Conception des boîtes', 1436),
(1497, '1497', 'NULL', 'Conception des câbles', 1436),
(1498, '1498', 'NULL', 'Contrôle SIO Niv 2', 1436),
(1499, '1499', 'NULL', 'Reprise', 1436),
(1500, '1500', 'NULL', 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal+APS TR+APD TR)', 1437),
(1501, '1501', 'NULL', 'Conception Point Technique', 1437),
(1502, '1502', 'NULL', 'Conception des Supports', 1437),
(1503, '1503', 'NULL', 'Conception des boîtes', 1437),
(1504, '1504', 'NULL', 'Conception des câbles', 1437),
(1505, '1505', 'NULL', 'Ajout Resultat CDC+aiguillage', 1437),
(1506, '1506', 'NULL', 'Ajout Resultat+Dépose', 1437),
(1507, '1507', 'NULL', 'Contrôle SIO Niv2', 1437),
(1508, '1508', 'NULL', 'Reprise', 1437),
(1509, '1509', 'NULL', 'Vérification des Retour Terrain', 1438),
(1510, '1510', 'NULL', 'Vérification des Fichiers dépisseure+DME+Plan de baie', 1438),
(1511, '1511', 'NULL', 'Réalisation SIOREC', 1438),
(1512, '1512', 'NULL', 'Vérification', 1438),
(1513, '1513', 'NULL', 'Reprise', 1438),
(1514, '1514', NULL, 'Vérification des DE(Distribution)', 1751),
(1515, '1515', NULL, 'PDS', 1751),
(1516, '1516', NULL, 'Synoptique', 1751),
(1517, '1517', NULL, 'Etiquettes', 1751),
(1518, '1518', NULL, 'Plan de tirage', 1751),
(1519, '1519', NULL, 'APD GC', 1751),
(1520, '1520', NULL, 'Shape des poteaux à implenter/remplacer', 1751),
(1521, '1521', NULL, 'Shape des blocages', 1751),
(1522, '1522', NULL, 'Contrôle', 1751),
(1523, '1523', NULL, 'Reprise', 1751),
(1524, '1524', NULL, 'Epp', 1751),
(1525, '1525', NULL, 'Plan de Baie SRO-NRO', 1751),
(1526, '1526', '', 'Formation', 1851),
(1527, '1527', '', 'Consultation', 1851),
(1528, '1528', '', 'Congé', 1851),
(1529, '1529', '', 'Maladie', 1851),
(1530, '1530', '', 'Jours fériés', 1851),
(1531, '1531', '', 'Récupe', 1851),
(1532, '1532', '', 'Dépose', 1430),
(1533, '1533', '', 'Dépose', 1431),
(1534, '1534', '', 'Dépose', 1432),
(1535, '1535', '', 'Dépose', 1438),
(1536, '1536', '', 'Dépose', 1435),
(1537, '1537', '', 'Contrôl Retour Terrain', 1918),
(1538, '1538', '', 'Réalisation de dossier', 1918),
(1539, '1539', '', 'Extraction des immeubles du SID', 1918),
(1540, '1540', '', 'Avancement', 1918),
(1541, '1541', '', 'Suivi d\'intégrations immeubles', 1918),
(1542, '1542', '', 'Création et Réalisation du dossier', 1919),
(1543, '1543', '', 'Création et Réalisation du dossier', 1920),
(1544, '1544', '', 'Création et Réalisation du dossier', 1921),
(1545, '1545', '', 'Réunion', 1851),
(1546, '1546', '', 'Préparation des SHAPES', 1422),
(1547, '1547', '', 'Reprise Etude', 1001),
(1548, '1548', '', 'Contrôle Etude', 1001),
(1549, '1549', '', 'Préparation des DE', 2101),
(1550, '1550', '', 'Suivi des Relevé + Contrôle', 2101),
(1551, '1551', '', 'Réalisation du C6', 2101),
(1552, '1552', '', 'Calcul CAPFT', 2101),
(1553, '1553', '', 'Réalisation des C3A', 2101),
(1554, '1554', '', 'Réalisation des DFT', 2101),
(1555, '1555', '', 'Reprise C6', 2101),
(1556, '1556', '', 'Contrôle C6', 2101),
(1557, '1557', '', 'Contrôle Calcul', 2101),
(1558, '1558', '', 'Reprise Calcul', 2101),
(1559, '1559', '', 'Contrôle C3A', 2101),
(1560, '1560', '', 'Reprise C3A', 2101),
(1561, '1561', '', 'Contrôle DFT', 2101),
(1562, '1562', '', 'Reprise DFT', 2101),
(1563, '1563', '', 'Intégration des sites', 1422),
(1564, '1564', '', 'Intégration câbles optiques', 1422),
(1565, '1565', '', 'Fiche préco ', 2102),
(1566, '1566', '', 'Conception des adductions', 1436),
(1567, '1567', '', 'Conception des adductions', 1437),
(1568, '1568', '', 'Conception des adductions', 1438),
(1569, '1569', '', 'Formation Personnelle', 2103),
(1570, '1570', '', 'Reprise', 2104),
(1571, '1571', '', 'Vérification des DE', 2104),
(1572, '1572', '', 'Conception Point Technique', 2104),
(1573, '1573', '', 'Conception des Supports', 2104),
(1574, '1574', '', 'Conception des boîtes', 2104),
(1575, '1575', '', 'Conception des câbles', 2104),
(1576, '1576', '', 'Contrôle SIO Niv 2', 2104),
(1577, '1577', '', 'Reprise', 2104),
(1578, '1578', '', 'Conception des adductions', 2104),
(1579, '1579', '', 'Vérification DICT', 2105),
(1580, '1580', '', 'Réalisation ', 2105),
(1581, '1581', '', 'Vérification +Depose', 2105),
(1582, '1582', '', 'Réalisation de fichier FAC', 2106),
(1583, '1583', '', 'E-plan', 1001),
(1584, '1584', '', 'Reprise DOE', 1001),
(1585, '1585', '', 'Contrôle DOE', 1001),
(1586, '1586', '', 'Dépôt', 2101),
(1587, '1587', '', 'Vérification des APD Poteaux', 1001),
(1588, '1588', '', 'Routage optique', 1751),
(1589, '1589', '', 'Modification de dossier ', 1412),
(1590, '1590', '', 'Modification de dossier', 1919);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `entreprise` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs7r3h2d5a1mf99x04k0w4mhmp` (`entreprise`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `code`, `description`, `libelle`, `entreprise`) VALUES
(918, '51', '', 'Losange 51', 1378),
(917, 'PACA', '', 'Free PACA', 1384),
(916, '31', '', 'Fibre 31', 1380),
(915, '21', '', 'Fibre 21', 1381),
(919, '85', '', 'Vendee', 1383),
(920, '89', '', 'Yconick', 1382),
(1001, '08', '', 'Losange 08', 1379),
(1435, 'IDF', '', 'Free IDF', 1384),
(124, 'CL 1', NULL, '?CL 11111', 123);

-- --------------------------------------------------------

--
-- Structure de la table `demande_conge`
--

DROP TABLE IF EXISTS `demande_conge`;
CREATE TABLE IF NOT EXISTS `demande_conge` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire_validateur` varchar(255) DEFAULT NULL,
  `date_depart` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `message_collaborateur` varchar(255) DEFAULT NULL,
  `collaborateur` bigint(20) DEFAULT NULL,
  `etat_demande_conge` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpeswm751uijs1obcydsc89j5t` (`collaborateur`),
  KEY `FKrida2t93mxdcqar9d3rdgqqx0` (`etat_demande_conge`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entite_administrative`
--

DROP TABLE IF EXISTS `entite_administrative`;
CREATE TABLE IF NOT EXISTS `entite_administrative` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `chef` bigint(20) DEFAULT NULL,
  `entite_administrative_superieure` bigint(20) DEFAULT NULL,
  `pole` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl3tk8e4lrqjb6igscblyd61wj` (`chef`),
  KEY `FK7u9qp5h95qrgp2xh2xvs3h0ad` (`entite_administrative_superieure`),
  KEY `FKm3v8khp2m5lcp2v8deu6y3nc9` (`pole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

DROP TABLE IF EXISTS `entreprise`;
CREATE TABLE IF NOT EXISTS `entreprise` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`id`, `code`, `description`, `libelle`) VALUES
(1378, '08', '', 'LOSANGE'),
(1379, '51', '', 'LOSANGE'),
(1380, '31', '', 'FIBRE 31'),
(1381, '21', '', 'FIBRE 21'),
(1382, '89', '', 'YCONICK'),
(1383, '85', '', 'VENDEE'),
(1384, '00', '', 'FREE'),
(123, 'ENT', 'ENTR ANA ENTR ANA', 'ENTR ANA');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `agence` bigint(20) DEFAULT NULL,
  `etat_equipe` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq0g5extl8km40qfen2rjjwj5y` (`agence`),
  KEY `FKcr6fdruhvd76gkfyi7ix4bxb7` (`etat_equipe`),
  KEY `FKj8vi1yn6r7h2nwak5ytqkfahe` (`responsable`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `code`, `description`, `libelle`, `agence`, `etat_equipe`, `responsable`) VALUES
(560, '560', '', 'Corai+Yconik', 4, 401, 909),
(561, '561', '', 'Losange', 4, 401, 910),
(562, '562', '', 'Free', 4, 401, 912),
(563, '563', '', 'Orange', 4, 401, 520),
(564, '564', '', 'Enedis', 4, 401, 546),
(581, '581', '', 'DOE-DTI', 4, 401, 527),
(583, '583', '', 'RBAL+ APD GC', 4, 401, 521),
(585, '585', '', 'Equipe TIRAGE', 4, 401, 523),
(586, '586', '', 'Aiguillage', 4, 401, 526),
(600, '600', '', 'Controle', 4, 401, 913),
(603, '603', '', 'Classeur Travaux', 4, 401, 524),
(403, 'Dontdelete', 'matms3ach', 'Dontdelete', 4, 401, 3000),
(700, '700', NULL, 'Equipe A', 4, 401, 520),
(701, '701', NULL, 'Equipe B', 4, 401, 520),
(702, '702', NULL, 'Equipe C', 4, 401, 520),
(703, '703', NULL, 'Equipe D', 4, 401, 520),
(119, 'ANA', '', 'ANA', 4, 401, 519);

-- --------------------------------------------------------

--
-- Structure de la table `etat_agence`
--

DROP TABLE IF EXISTS `etat_agence`;
CREATE TABLE IF NOT EXISTS `etat_agence` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_agence`
--

INSERT INTO `etat_agence` (`id`, `code`, `description`, `libelle`) VALUES
(1, '1957good', 'en service', 'en service'),
(2, '1958fermer', 'en fermer', 'en fermer'),
(3, '1959prepa', 'en preparation', 'en preparation');

-- --------------------------------------------------------

--
-- Structure de la table `etat_budget`
--

DROP TABLE IF EXISTS `etat_budget`;
CREATE TABLE IF NOT EXISTS `etat_budget` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_budget`
--

INSERT INTO `etat_budget` (`id`, `code`, `libelle`) VALUES
(2017, 'en_traitement', 'En traitement'),
(2018, 'demmande', 'Demmande'),
(2030, '2330refuse', 'Demande rejetée'),
(2032, '2032accepter', 'Demmande Acceptée');

-- --------------------------------------------------------

--
-- Structure de la table `etat_demande_conge`
--

DROP TABLE IF EXISTS `etat_demande_conge`;
CREATE TABLE IF NOT EXISTS `etat_demande_conge` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_demande_conge`
--

INSERT INTO `etat_demande_conge` (`id`, `code`, `libelle`) VALUES
(29, 'e1', 'en cours de traitement'),
(30, 'e2', 'acceptée'),
(31, 'e3', 'refusée');

-- --------------------------------------------------------

--
-- Structure de la table `etat_equipe`
--

DROP TABLE IF EXISTS `etat_equipe`;
CREATE TABLE IF NOT EXISTS `etat_equipe` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_equipe`
--

INSERT INTO `etat_equipe` (`id`, `code`, `description`, `libelle`) VALUES
(401, 'en cours', '', 'En cours'),
(402, 'archivé', '', 'Archivé');

-- --------------------------------------------------------

--
-- Structure de la table `etat_facture`
--

DROP TABLE IF EXISTS `etat_facture`;
CREATE TABLE IF NOT EXISTS `etat_facture` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_facture`
--

INSERT INTO `etat_facture` (`id`, `code`, `description`, `libelle`) VALUES
(1, 'Initialisé3', NULL, 'Initialisé'),
(2, 'En cours4', NULL, 'En cours'),
(3, 'Validé5', NULL, 'Validé'),
(5, 'Terminé7', NULL, 'Terminé');

-- --------------------------------------------------------

--
-- Structure de la table `etat_groupe_tache`
--

DROP TABLE IF EXISTS `etat_groupe_tache`;
CREATE TABLE IF NOT EXISTS `etat_groupe_tache` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_groupe_tache`
--

INSERT INTO `etat_groupe_tache` (`id`, `code`, `description`, `libelle`) VALUES
(1, 'Initialisé3', NULL, 'Initialisé'),
(2, 'En cours4', NULL, 'En cours'),
(3, 'Validé5', NULL, 'Validé'),
(5, 'Terminé7', NULL, 'Terminé');

-- --------------------------------------------------------

--
-- Structure de la table `etat_lot`
--

DROP TABLE IF EXISTS `etat_lot`;
CREATE TABLE IF NOT EXISTS `etat_lot` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_lot`
--

INSERT INTO `etat_lot` (`id`, `code`, `description`, `libelle`) VALUES
(64, 'Initialisation', '', 'Initialisation'),
(65, 'en cours', '', 'En Cours'),
(358, 'en validation', '', 'En validation');

-- --------------------------------------------------------

--
-- Structure de la table `etat_message`
--

DROP TABLE IF EXISTS `etat_message`;
CREATE TABLE IF NOT EXISTS `etat_message` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etat_paiement`
--

DROP TABLE IF EXISTS `etat_paiement`;
CREATE TABLE IF NOT EXISTS `etat_paiement` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_paiement`
--

INSERT INTO `etat_paiement` (`id`, `code`, `description`, `libelle`) VALUES
(1, '1', 'Initialisé', 'Initialisé'),
(2, '2', 'En Cours', 'En Cours'),
(3, '3', 'Validé', 'Validé'),
(4, '4', 'Rejeté', 'Rejeté');

-- --------------------------------------------------------

--
-- Structure de la table `etat_projet`
--

DROP TABLE IF EXISTS `etat_projet`;
CREATE TABLE IF NOT EXISTS `etat_projet` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_projet`
--

INSERT INTO `etat_projet` (`id`, `code`, `description`, `libelle`) VALUES
(56, 'initialisation', '', 'Initialisation'),
(58, 'En cours', '', 'En cours'),
(59, 'en test', '', 'En test'),
(310, 'en validation', '', 'En validation'),
(311, 'accepté', '', 'Accepté'),
(312, 'rejeté', '', 'Rejeté');

-- --------------------------------------------------------

--
-- Structure de la table `etat_tache`
--

DROP TABLE IF EXISTS `etat_tache`;
CREATE TABLE IF NOT EXISTS `etat_tache` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat_tache`
--

INSERT INTO `etat_tache` (`id`, `code`, `description`, `libelle`) VALUES
(62, 'validé', '', 'Validé'),
(653, 'rejeté', '', 'Rejeté'),
(60, 'initialisé', '', 'Initialisé'),
(61, 'en cours', '', 'En Cours');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_facture` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant_calcule` decimal(19,2) DEFAULT NULL,
  `montant_facture` decimal(19,2) DEFAULT NULL,
  `total_heurs_calcules` decimal(19,2) DEFAULT NULL,
  `total_heurs_factures` decimal(19,2) DEFAULT NULL,
  `agence` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  `etat_facture` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrui9r0v4gf30os0yr966wdiry` (`agence`),
  KEY `FKn8j0l6u5blg7tuao1x52as0i9` (`client`),
  KEY `FKkr3ksts74gennv8v3sftugtj8` (`etat_facture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id`, `code`, `date_facture`, `description`, `libelle`, `montant_calcule`, `montant_facture`, `total_heurs_calcules`, `total_heurs_factures`, `agence`, `client`, `etat_facture`) VALUES
(62, 'f7', '2021-01-21', NULL, 'Facture 1', '136.00', '140.00', '598.40', '600.00', 4, 919, 2),
(61, 'f6', '2020-12-17', NULL, 'F 6', '334.00', '400.00', '1469.60', '1500.00', 4, 916, 1),
(60, 'f4', '2020-11-24', NULL, 'Facture 2', '342.00', '400.00', '1504.80', '1600.00', 3, 915, 2),
(59, 'F3', '2020-10-15', NULL, 'F 3', '154.00', '160.00', '677.60', '700.00', 4, 918, 5),
(58, 'f2', '2020-09-24', NULL, 'F 2', '3.00', '17.00', '13.20', '14.00', 4, 917, 3),
(57, 'F1', '2020-08-21', 'F1', 'Facture 3', '154.00', '160.00', '677.60', '700.00', 4, 918, 2),
(74, 'gs', '2021-06-19', 'dfghjk', 'fact n', '136.00', '140.00', '598.40', '600.00', 4, 919, 3),
(75, 'ersr bv', '2021-06-17', 'fghjk', 'fact D', '342.00', '380.00', '1504.80', '1600.00', 4, 915, 2),
(81, 'testest', '2021-06-22', 'test', 'testest', '342.00', '400.00', '1504.80', '1600.00', 4, 915, 3),
(83, 'fghjkl', '2021-06-22', 'lkjj', 'llkj', '342.00', '360.00', '1504.80', '1600.00', 4, 915, 5);

-- --------------------------------------------------------

--
-- Structure de la table `groupe_tache`
--

DROP TABLE IF EXISTS `groupe_tache`;
CREATE TABLE IF NOT EXISTS `groupe_tache` (
  `id` bigint(20) NOT NULL,
  `avancement` double NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_demarrage_effective` date DEFAULT NULL,
  `date_demarrage_prevu` date DEFAULT NULL,
  `date_fin_effective` date DEFAULT NULL,
  `date_fin_prevu` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nombre_joure_homme_effectif` double NOT NULL,
  `nombre_joure_homme_prevu` double NOT NULL,
  `nombre_joure_homme_retard` double NOT NULL,
  `poids` double NOT NULL,
  `categorie_groupe_tache` bigint(20) DEFAULT NULL,
  `equipe` bigint(20) DEFAULT NULL,
  `etat_groupe_tache` bigint(20) DEFAULT NULL,
  `lot` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgvwnlmguh0x67asxt9iccoffm` (`categorie_groupe_tache`),
  KEY `FKmigsdxoknudwfomyiswvtq85q` (`equipe`),
  KEY `FKssykfjw7po8jqt65r0yd2iqv3` (`etat_groupe_tache`),
  KEY `FKb4q5hah1jgqkimbwddlx4th1k` (`lot`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe_tache`
--

INSERT INTO `groupe_tache` (`id`, `avancement`, `code`, `date_demarrage_effective`, `date_demarrage_prevu`, `date_fin_effective`, `date_fin_prevu`, `description`, `libelle`, `nombre_joure_homme_effectif`, `nombre_joure_homme_prevu`, `nombre_joure_homme_retard`, `poids`, `categorie_groupe_tache`, `equipe`, `etat_groupe_tache`, `lot`) VALUES
(2422, 0, '2422', '2021-06-02', NULL, NULL, NULL, NULL, 'GT Yconick-018-037', 0, 0, 0, 0, 1422, 563, NULL, 1120),
(2421, 0, '2421', '2021-06-16', NULL, NULL, NULL, NULL, 'GT Yconick-018-027', 0, 0, 0, 0, 851, 702, 2, 1100),
(2420, 0, '2420', '2021-06-23', NULL, NULL, NULL, NULL, 'GT Yconick-018-024', 0, 0, 0, 0, 851, 560, NULL, 1113),
(2419, 0, '2419', '2021-06-15', NULL, NULL, NULL, NULL, 'GT Vendee-081-929', 0, 0, 0, 0, 1425, 701, 1, 1108),
(2418, 0, '2418', '2021-06-09', NULL, NULL, NULL, NULL, 'GT Vendee-081-857', 0, 0, 0, 0, 1422, 563, NULL, 1119),
(2417, 0, '2417', '2021-06-23', NULL, NULL, NULL, NULL, 'GT Vendee-081-856', 0, 0, 0, 0, 1412, 702, NULL, 1033),
(2416, 0, '2416', '2021-06-22', NULL, NULL, NULL, NULL, 'GT Vendee-081-855', 0, 0, 0, 0, 1422, 700, 2, 1108),
(2415, 0, '2415', '2021-06-04', NULL, NULL, NULL, NULL, 'GT Vendee-081-854', 0, 0, 0, 0, 1412, 701, 2, 1109),
(2414, 0, '2414', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-076-818', 0, 0, 0, 0, NULL, NULL, NULL, 1107),
(2413, 0, '2413', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-076-817', 0, 0, 0, 0, NULL, NULL, NULL, 1106),
(2412, 0, '2412', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-076-816', 0, 0, 0, 0, NULL, NULL, NULL, 1105),
(2411, 0, '2411', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-076-815', 0, 0, 0, 0, NULL, NULL, NULL, 1104),
(2410, 0, '2410', '2021-06-17', NULL, NULL, NULL, NULL, 'GT Vendee-076-814', 0, 0, 0, 0, 1412, 560, 2, 1118),
(2409, 0, '2409', '2021-06-19', NULL, NULL, NULL, NULL, 'GT Vendee-076-813', 0, 0, 0, 0, 1402, 561, 2, 1096),
(2408, 0, '2408', '2021-06-18', NULL, NULL, NULL, NULL, 'GT Vendee-076-812', 0, 0, 0, 0, 1424, 560, NULL, 1095),
(2407, 0, '2407', '2021-06-17', NULL, NULL, NULL, NULL, 'GT Vendee-076-811', 0, 0, 0, 0, 1407, 703, 2, 1101),
(2406, 0, '2406', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-793', 0, 0, 0, 0, NULL, NULL, NULL, 1099),
(2405, 0, '2405', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-790', 0, 0, 0, 0, NULL, NULL, NULL, 1098),
(2404, 0, '2404', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-794', 0, 0, 0, 0, NULL, NULL, NULL, 1097),
(2403, 0, '2403', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-792', 0, 0, 0, 0, NULL, NULL, NULL, 1096),
(2402, 0, '2402', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-791', 0, 0, 0, 0, NULL, NULL, NULL, 1095),
(2401, 0, '2401', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-066-747', 0, 0, 0, 0, NULL, NULL, NULL, 1094),
(2400, 0, '2400', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-056-671', 0, 0, 0, 0, NULL, NULL, NULL, 1093),
(2399, 0, '2399', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-053-606', 0, 0, 0, 0, NULL, NULL, NULL, 1092),
(2398, 0, '2398', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-055-930', 0, 0, 0, 0, NULL, NULL, NULL, 1091),
(2397, 0, '2397', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-055-662', 0, 0, 0, 0, NULL, NULL, NULL, 1090),
(2396, 0, '2396', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-055-658', 0, 0, 0, 0, NULL, NULL, NULL, 1089),
(2395, 0, '2395', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-571', 0, 0, 0, 0, NULL, NULL, NULL, 1088),
(2394, 0, '2394', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-570', 0, 0, 0, 0, NULL, NULL, NULL, 1087),
(2393, 0, '2393', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-569', 0, 0, 0, 0, NULL, NULL, NULL, 1086),
(2392, 0, '2392', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-568', 0, 0, 0, 0, NULL, NULL, NULL, 1085),
(2391, 0, '2391', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-567', 0, 0, 0, 0, NULL, NULL, NULL, 1084),
(2390, 0, '2390', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-566', 0, 0, 0, 0, NULL, NULL, NULL, 1083),
(2383, 0, '2383', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-110', 0, 0, 0, 0, NULL, NULL, NULL, 1076),
(2382, 0, '2382', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-100', 0, 0, 0, 0, 1402, 560, NULL, 1075),
(2381, 0, '2381', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-099', 0, 0, 0, 0, NULL, NULL, NULL, 1074),
(2380, 0, '2380', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-098', 0, 0, 0, 0, NULL, NULL, NULL, 1073),
(2379, 0, '2379', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-097', 0, 0, 0, 0, NULL, NULL, NULL, 1072),
(2378, 0, '2378', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-096', 0, 0, 0, 0, NULL, NULL, NULL, 1071),
(2377, 0, '2377', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-017-104', 0, 0, 0, 0, NULL, NULL, NULL, 1070),
(2376, 0, '2376', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-017-103', 0, 0, 0, 0, NULL, NULL, NULL, 1069),
(2375, 0, '2375', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-017-102', 0, 0, 0, 0, NULL, NULL, NULL, 1068),
(2374, 0, '2374', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-017-101', 0, 0, 0, 0, NULL, NULL, NULL, 1067),
(2373, 0, '2373', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-080', 0, 0, 0, 0, NULL, NULL, NULL, 1066),
(2372, 0, '2372', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-079', 0, 0, 0, 0, NULL, NULL, NULL, 1065),
(2371, 0, '2371', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-078', 0, 0, 0, 0, NULL, NULL, NULL, 1064),
(2370, 0, '2370', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-077', 0, 0, 0, 0, 1001, 560, NULL, 1063),
(2369, 0, '2369', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-076', 0, 0, 0, 0, 851, 560, NULL, 1062),
(2368, 0, '2368', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-075', 0, 0, 0, 0, 1402, 560, NULL, 1061),
(2367, 0, '2367', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-074', 0, 0, 0, 0, NULL, NULL, NULL, 1060),
(2366, 0, '2366', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-073', 0, 0, 0, 0, NULL, NULL, NULL, 1059),
(2365, 0, '2365', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-072', 0, 0, 0, 0, NULL, NULL, NULL, 1058),
(2364, 0, '2364', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-071', 0, 0, 0, 0, NULL, NULL, NULL, 1057),
(2363, 0, '2363', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-070', 0, 0, 0, 0, NULL, NULL, NULL, 1056),
(2362, 0, '2362', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-069', 0, 0, 0, 0, NULL, NULL, NULL, 1055),
(2361, 0, '2361', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-068', 0, 0, 0, 0, NULL, NULL, NULL, 1054),
(2360, 0, '2360', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-067', 0, 0, 0, 0, 1001, 560, NULL, 1053),
(2359, 0, '2359', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-308', 0, 0, 0, 0, NULL, NULL, NULL, 1052),
(2358, 0, '2358', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-026', 0, 0, 0, 0, NULL, NULL, NULL, 1051),
(2357, 0, '2357', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-025', 0, 0, 0, 0, NULL, NULL, NULL, 1050),
(2356, 0, '2356', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-024', 0, 0, 0, 0, NULL, NULL, NULL, 1049),
(2355, 0, '2355', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-023', 0, 0, 0, 0, NULL, NULL, NULL, 1048),
(2354, 0, '2354', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-022', 0, 0, 0, 0, NULL, NULL, NULL, 1047),
(2353, 0, '2353', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-021', 0, 0, 0, 0, NULL, NULL, NULL, 1046),
(2352, 0, '2352', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-019', 0, 0, 0, 0, NULL, NULL, NULL, 1045),
(2351, 0, '2351', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-018', 0, 0, 0, 0, NULL, NULL, NULL, 1044),
(2436, 0, '2436', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78455_007_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2349, 0, '2349', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-295', 0, 0, 0, 0, NULL, NULL, NULL, 1042),
(2348, 0, '2348', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-294', 0, 0, 0, 0, NULL, NULL, NULL, 1041),
(2347, 0, '2347', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-293', 0, 0, 0, 0, NULL, NULL, NULL, 1040),
(2346, 0, '2346', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-330', 0, 0, 0, 0, NULL, NULL, NULL, 1039),
(2345, 0, '2345', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-328', 0, 0, 0, 0, NULL, NULL, NULL, 1038),
(2344, 0, '2344', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-327', 0, 0, 0, 0, NULL, NULL, NULL, 1037),
(2343, 0, '2343', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-326', 0, 0, 0, 0, NULL, NULL, NULL, 1036),
(2342, 0, '2342', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-329', 0, 0, 0, 0, NULL, NULL, NULL, 1035),
(2341, 0, '2341', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-170', 0, 0, 0, 0, NULL, NULL, NULL, 1034),
(2340, 0, '2340', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-012', 0, 0, 0, 0, NULL, NULL, NULL, 1033),
(2339, 0, '2339', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-051', 0, 0, 0, 0, NULL, NULL, NULL, 1032),
(2338, 0, '2338', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-316', 0, 0, 0, 0, NULL, NULL, NULL, 1031),
(2337, 0, '2337', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-031', 0, 0, 0, 0, NULL, NULL, NULL, 1030),
(2336, 0, '2336', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-030', 0, 0, 0, 0, NULL, NULL, NULL, 1029),
(2335, 0, '2335', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-029', 0, 0, 0, 0, NULL, NULL, NULL, 1028),
(2334, 0, '2334', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-028', 0, 0, 0, 0, NULL, NULL, NULL, 1027),
(2333, 0, '2333', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-027', 0, 0, 0, 0, NULL, NULL, NULL, 1026),
(2332, 0, '2332', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-011', 0, 0, 0, 0, NULL, NULL, NULL, 1025),
(2331, 0, '2331', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-010', 0, 0, 0, 0, NULL, NULL, NULL, 1024),
(2330, 0, '2330', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-032', 0, 0, 0, 0, NULL, NULL, NULL, 1023),
(2329, 0, '2329', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-335', 0, 0, 0, 0, NULL, NULL, NULL, 1022),
(2328, 0, '2328', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-334', 0, 0, 0, 0, NULL, NULL, NULL, 1021),
(2327, 0, '2327', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-227', 0, 0, 0, 0, NULL, NULL, NULL, 1020),
(2326, 0, '2326', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-226', 0, 0, 0, 0, NULL, NULL, NULL, 1019),
(2325, 0, '2325', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-225', 0, 0, 0, 0, NULL, NULL, NULL, 1018),
(2324, 0, '2324', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-017', 0, 0, 0, 0, NULL, NULL, NULL, 1001),
(2323, 0, '2323', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84054_007_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2322, 0, '2322', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84147_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2321, 0, '2321', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84070_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2320, 0, '2320', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84069_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2319, 0, '2319', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84047_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2318, 0, '2318', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84031_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2317, 0, '2317', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84031_007_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2316, 0, '2316', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84008_001_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2315, 0, '2315', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-PET84-TDA84', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2314, 0, '2314', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-ALATA', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2423, 0, '2423', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78015_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2312, 0, '2312', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2311, 0, '2311', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2310, 0, '2310', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-018-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2309, 0, '2309', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2308, 0, '2308', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2307, 0, '2307', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-081-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2306, 0, '2306', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-null-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2305, 0, '2305', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-076-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2304, 0, '2304', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-072-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2303, 0, '2303', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-066-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2302, 0, '2302', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-056-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2301, 0, '2301', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-055-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2300, 0, '2300', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-053-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2299, 0, '2299', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-048-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2298, 0, '2298', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2297, 0, '2297', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-055-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2296, 0, '2296', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2295, 0, '2295', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2294, 0, '2294', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-030-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2293, 0, '2293', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-001-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2292, 0, '2292', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2291, 0, '2291', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2290, 0, '2290', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2289, 0, '2289', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2288, 0, '2288', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2287, 0, '2287', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2286, 0, '2286', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2285, 0, '2285', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2284, 0, '2284', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2283, 0, '2283', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2282, 0, '2282', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2281, 0, '2281', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2528, 0, '2528', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-POP_MARSEILLE-SAN13', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2279, 0, '2279', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 31-206-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2278, 0, '2278', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-017-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2277, 0, '2277', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-016-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2276, 0, '2276', NULL, NULL, NULL, NULL, NULL, 'GT Fibre 21-011-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2275, 0, '2275', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05059_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2274, 0, '2274', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05119_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2273, 0, '2273', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05061_013_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2272, 0, '2272', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83149_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2271, 0, '2271', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83137_032_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2270, 0, '2270', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-040', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2269, 0, '2269', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83137_009_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2268, 0, '2268', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83119_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2267, 0, '2267', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83115_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2266, 0, '2266', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83115_013_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2265, 0, '2265', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83108_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2264, 0, '2264', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83070_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2263, 0, '2263', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83069_028_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2262, 0, '2262', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83047_011_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2261, 0, '2261', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83047_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2260, 0, '2260', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83034_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2259, 0, '2259', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83009_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2258, 0, '2258', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83061_016_08', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2257, 0, '2257', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83047_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2256, 0, '2256', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83103_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2255, 0, '2255', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06105_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2254, 0, '2254', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-LLA83-CVE83', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2253, 0, '2253', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-FLA83_P9U83', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2252, 0, '2252', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-055-056', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2249, 0, '2249', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-262', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2248, 0, '2248', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-261', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2247, 0, '2247', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-260', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2246, 0, '2246', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-259', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2440, 0, '2440', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78640_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2245, 0, '2245', NULL, NULL, NULL, NULL, NULL, 'GT Vendee-018-258', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2431, 0, '2431', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78418_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2430, 0, '2430', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78291_002_12', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2425, 0, '2425', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78043_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2426, 0, '2426', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78107_002_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2427, 0, '2427', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78164_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2428, 0, '2428', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78172_001_26', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2429, 0, '2429', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78242_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2229, 0, '2229', NULL, NULL, NULL, NULL, NULL, 'GT null-null-', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2434, 0, '2434', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78423_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2432, 0, '2432', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78423_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2424, 0, '2424', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78118_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2220, 0, '2220', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04200_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2437, 0, '2437', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78490_010', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2438, 0, '2438', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78490_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2439, 0, '2439', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78624_003_11', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2433, 0, '2433', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78423_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2435, 0, '2435', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78423_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2213, 0, '2213', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-288', 0, 0, 0, 0, NULL, NULL, NULL, 1140),
(2212, 0, '2212', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-163', 0, 0, 0, 0, NULL, NULL, NULL, 1139),
(2211, 0, '2211', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-152', 0, 0, 0, 0, NULL, NULL, NULL, 1138),
(2210, 0, '2210', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-151', 0, 0, 0, 0, NULL, NULL, NULL, 1137),
(2209, 0, '2209', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-015-145', 0, 0, 0, 0, NULL, NULL, NULL, 1136),
(2208, 0, '2208', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-036', 0, 0, 0, 0, NULL, NULL, NULL, 1135),
(2207, 0, '2207', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-035', 0, 0, 0, 0, NULL, NULL, NULL, 1134),
(2206, 0, '2206', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-034', 0, 0, 0, 0, NULL, NULL, NULL, 1133),
(2205, 0, '2205', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-033', 0, 0, 0, 0, NULL, NULL, NULL, 1132),
(2204, 0, '2204', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-144', 0, 0, 0, 0, NULL, NULL, NULL, 1131),
(2203, 0, '2203', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-053', 0, 0, 0, 0, NULL, NULL, NULL, 1130),
(2202, 0, '2202', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-158', 0, 0, 0, 0, NULL, NULL, NULL, 1129),
(2201, 0, '2201', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-023', 0, 0, 0, 0, NULL, NULL, NULL, 1128),
(2200, 0, '2200', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-022', 0, 0, 0, 0, NULL, NULL, NULL, 1127),
(2199, 0, '2199', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-013-021', 0, 0, 0, 0, NULL, NULL, NULL, 1126),
(2196, 0, '2196', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83137_011_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2197, 0, '2197', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-041', 0, 0, 0, 0, NULL, NULL, NULL, 1124),
(2198, 0, '2198', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-042', 0, 0, 0, 0, NULL, NULL, NULL, 1125),
(2195, 0, '2195', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-039', 0, 0, 0, 0, NULL, NULL, NULL, 1122),
(2194, 0, '2194', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-031', 0, 0, 0, 0, NULL, NULL, NULL, 1121),
(2193, 0, '2193', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-042-030', 0, 0, 0, 0, NULL, NULL, NULL, 1120),
(2192, 0, '2192', '2021-06-15', NULL, NULL, NULL, NULL, 'GT Yconick-042-029', 0, 0, 0, 0, NULL, 703, NULL, 1032),
(2191, 0, '2191', '2021-06-10', NULL, NULL, NULL, NULL, 'GT Yconick-042-009', 0, 0, 0, 0, 851, 700, NULL, 1118),
(2190, 0, '2190', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-018-118', 0, 0, 0, 0, NULL, NULL, NULL, 1117),
(2189, 0, '2189', NULL, NULL, NULL, NULL, NULL, 'GT Yconick-018-110', 0, 0, 0, 0, 851, 560, NULL, 1116),
(2441, 0, '2441', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78642_002_08', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2442, 0, '2442', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94021_015_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2443, 0, '2443', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94028_027_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2444, 0, '2444', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94033_021_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2445, 0, '2445', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94034_008_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2446, 0, '2446', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94044_001_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2447, 0, '2447', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94054_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2448, 0, '2448', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94065_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2449, 0, '2449', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94067_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2450, 0, '2450', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_024_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2451, 0, '2451', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_025_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2452, 0, '2452', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94069_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2453, 0, '2453', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94071_007_27', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2454, 0, '2454', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94073_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2455, 0, '2455', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94073_014_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2456, 0, '2456', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94073_016_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2457, 0, '2457', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94076_018_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2458, 0, '2458', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94079_002_10', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2459, 0, '2459', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95052_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2460, 0, '2460', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95078_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2461, 0, '2461', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95166_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2462, 0, '2462', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95199_007_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2463, 0, '2463', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95218_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2464, 0, '2464', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95277_008_11', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2465, 0, '2465', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95328_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2466, 0, '2466', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95436_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2467, 0, '2467', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95459_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2468, 0, '2468', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95487_005_10', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2469, 0, '2469', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95500_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2470, 0, '2470', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95504_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2471, 0, '2471', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-CLE95', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2472, 0, '2472', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-HAZ95-BSY95', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2473, 0, '2473', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-NEU95', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2474, 0, '2474', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06006_004_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2475, 0, '2475', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06023_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2476, 0, '2476', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06023_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2477, 0, '2477', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06023_003_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2478, 0, '2478', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06029_044_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2479, 0, '2479', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06041_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2480, 0, '2480', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06064_005_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2481, 0, '2481', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06067_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2482, 0, '2482', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_007_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2483, 0, '2483', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_010_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2484, 0, '2484', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_020_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2485, 0, '2485', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06079_005_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2486, 0, '2486', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06083_015_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2487, 0, '2487', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06085_015_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2488, 0, '2488', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_010_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2489, 0, '2489', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_020_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2490, 0, '2490', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06079_005_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2491, 0, '2491', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06083_015_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2492, 0, '2492', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06085_015_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2493, 0, '2493', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2494, 0, '2494', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_126_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2495, 0, '2495', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_146_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2496, 0, '2496', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_150_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2497, 0, '2497', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06089_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2498, 0, '2498', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06104_002_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2499, 0, '2499', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06105_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2500, 0, '2500', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06112_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2501, 0, '2501', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06120_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2502, 0, '2502', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06149_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2503, 0, '2503', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06151_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2504, 0, '2504', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06155_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2505, 0, '2505', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06155_006_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2506, 0, '2506', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06159_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2507, 0, '2507', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A004_005_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2508, 0, '2508', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A004_024_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2509, 0, '2509', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A006_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2510, 0, '2510', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A085_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2511, 0, '2511', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A130_003_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2512, 0, '2512', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A247_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2513, 0, '2513', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A247_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2514, 0, '2514', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A269_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2523, 0, '2523', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-NRO-83-LE BEAUSSET', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2516, 0, '2516', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2B033_013_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2517, 0, '2517', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2B043_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2518, 0, '2518', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2B050_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2519, 0, '2519', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2B148_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2520, 0, '2520', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2B223_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2521, 0, '2521', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04102_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2522, 0, '2522', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77491_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2524, 0, '2524', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-NRO-83-Roquebrune sur Argens', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2525, 0, '2525', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-NRO-83-CUERS', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2526, 0, '2526', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77069_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2527, 0, '2527', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-MEU77-CHA77', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2529, 0, '2529', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-POP_MARSEILLE-GAR13', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2530, 0, '2530', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-POP_MARSEILLE-SJU13', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2531, 0, '2531', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77096_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2532, 0, '2532', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05061_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2533, 0, '2533', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-SF-ST-BLER0001', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2534, 0, '2534', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05124_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2535, 0, '2535', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-Salernes', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2536, 0, '2536', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78171_003_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2537, 0, '2537', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83103_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2538, 0, '2538', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_150_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2539, 0, '2539', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13111_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2540, 0, '2540', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04019_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2541, 0, '2541', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04039_007_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2542, 0, '2542', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04102_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2543, 0, '2543', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04173_002_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2544, 0, '2544', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04200_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2545, 0, '2545', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04205_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2546, 0, '2546', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04226_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2547, 0, '2547', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-04-04230_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2548, 0, '2548', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05023_004_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2549, 0, '2549', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05046_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2550, 0, '2550', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05058_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2551, 0, '2551', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05061_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2552, 0, '2552', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05121_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2553, 0, '2553', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-05162_001_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2554, 0, '2554', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06029_002_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2555, 0, '2555', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06032_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2556, 0, '2556', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06062_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2557, 0, '2557', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06069_015_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2558, 0, '2558', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06084_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2559, 0, '2559', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2560, 0, '2560', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_021_10', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2561, 0, '2561', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_043_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2562, 0, '2562', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_070_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2563, 0, '2563', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06088_096_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2564, 0, '2564', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06095_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2565, 0, '2565', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06138_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2566, 0, '2566', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06149_002_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2567, 0, '2567', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06149_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2568, 0, '2568', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-06-06159_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2569, 0, '2569', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13005_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2570, 0, '2570', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13009_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2571, 0, '2571', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13015_006_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2572, 0, '2572', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13032_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2573, 0, '2573', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13050_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2574, 0, '2574', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13076_002_08', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2575, 0, '2575', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13080_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2576, 0, '2576', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13080_003_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2577, 0, '2577', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13086_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2578, 0, '2578', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13091_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2579, 0, '2579', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13091_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2580, 0, '2580', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13201_011_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2581, 0, '2581', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13201_016_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2582, 0, '2582', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13201_018_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2583, 0, '2583', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13202_002_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2584, 0, '2584', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13202_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2585, 0, '2585', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13202_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2586, 0, '2586', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13202_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2587, 0, '2587', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13206_017_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2588, 0, '2588', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13207_016_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2589, 0, '2589', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13209_016_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2590, 0, '2590', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13209_024_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2591, 0, '2591', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13210_021_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2592, 0, '2592', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13211_001_08', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2593, 0, '2593', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13211_006_07', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2594, 0, '2594', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-13-13212_023_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2595, 0, '2595', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A004_003_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2596, 0, '2596', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A004_021_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2597, 0, '2597', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A006_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2598, 0, '2598', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A040_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2599, 0, '2599', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A041_007_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2600, 0, '2600', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A114_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2601, 0, '2601', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A127_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2602, 0, '2602', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2A-2A247_013_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2603, 0, '2603', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B033_006_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2604, 0, '2604', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B033_019_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2605, 0, '2605', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B034_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2606, 0, '2606', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B037_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2607, 0, '2607', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B074_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2608, 0, '2608', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B152_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2609, 0, '2609', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B298_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2610, 0, '2610', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-2B-2B342_004_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2611, 0, '2611', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77201_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2612, 0, '2612', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77305_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2613, 0, '2613', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77394_001_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2614, 0, '2614', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-77-77491_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2615, 0, '2615', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78043_007_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2616, 0, '2616', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78133_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2617, 0, '2617', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-78-78172_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2618, 0, '2618', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83018_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2619, 0, '2619', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83023_005_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2620, 0, '2620', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83025_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2621, 0, '2621', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83033_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2622, 0, '2622', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83034_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2623, 0, '2623', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83048_006_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2624, 0, '2624', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83050_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2625, 0, '2625', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83053_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2626, 0, '2626', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83062_002_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2627, 0, '2627', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83062_004_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2628, 0, '2628', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83069_009_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2629, 0, '2629', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83069_025_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2630, 0, '2630', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83081_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2631, 0, '2631', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83082_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2632, 0, '2632', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83101_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2633, 0, '2633', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83107_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2634, 0, '2634', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83107_014_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2635, 0, '2635', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83112_010_03', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2636, 0, '2636', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83115_002_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2637, 0, '2637', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83115_016_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2638, 0, '2638', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83124_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2639, 0, '2639', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83129_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2640, 0, '2640', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83129_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2641, 0, '2641', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83129_008_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2642, 0, '2642', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83131_002_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2643, 0, '2643', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-83-83144_013_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2644, 0, '2644', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84020_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2645, 0, '2645', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-84089_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2646, 0, '2646', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94003_002_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2647, 0, '2647', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94003_007_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2648, 0, '2648', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94003_008_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2649, 0, '2649', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94004_008_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2650, 0, '2650', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94017_024_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2651, 0, '2651', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94018_002_13', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2652, 0, '2652', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94018_012_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2653, 0, '2653', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94019_007_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2654, 0, '2654', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94028_024_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2655, 0, '2655', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94034_004_06', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2656, 0, '2656', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94037_004_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2657, 0, '2657', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94042_003_08', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2658, 0, '2658', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94042_004_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2659, 0, '2659', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94043_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2660, 0, '2660', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94052_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2661, 0, '2661', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94059_003_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2662, 0, '2662', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_013_12', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2663, 0, '2663', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_014_05', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2664, 0, '2664', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_015_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2665, 0, '2665', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94068_020_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2666, 0, '2666', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94073_010_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2667, 0, '2667', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94073_011_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2668, 0, '2668', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94075_005_10', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2669, 0, '2669', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94078_010_02', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2670, 0, '2670', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94079_009_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2671, 0, '2671', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-94-94080_014_26', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2672, 0, '2672', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95370_001_01', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2673, 0, '2673', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-95-95428_007_04', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(2902, 0, '2902', NULL, NULL, NULL, NULL, NULL, 'GT Free IDF-000-000', 0, 0, 0, 0, NULL, NULL, NULL, NULL);
INSERT INTO `groupe_tache` (`id`, `avancement`, `code`, `date_demarrage_effective`, `date_demarrage_prevu`, `date_fin_effective`, `date_fin_prevu`, `description`, `libelle`, `nombre_joure_homme_effectif`, `nombre_joure_homme_prevu`, `nombre_joure_homme_retard`, `poids`, `categorie_groupe_tache`, `equipe`, `etat_groupe_tache`, `lot`) VALUES
(3082, 0, '3082', NULL, NULL, NULL, NULL, NULL, 'GT Losange 51-032-012', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(3083, 0, '3083', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-05-CDD NEFFES ', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(3084, 0, '3084', NULL, NULL, NULL, NULL, NULL, 'GT Free PACA-84-CAV84_VIG84', 0, 0, 0, 0, NULL, NULL, NULL, NULL),
(1, 0, 'testMahdiDate', '2021-06-14', NULL, '2021-06-17', NULL, NULL, 'testMahdiDate', 0, 0, 0, 0, 1402, 560, 2, 1118),
(4, 0, 'grpChefEq1', '2021-06-14', NULL, '2021-06-24', NULL, NULL, 'grp CE 1', 0, 0, 0, 0, 1402, 700, 2, 1118),
(5, 0, 'grpChefEq2', '2021-06-09', NULL, '2021-06-11', NULL, NULL, 'grp CE 2', 0, 0, 0, 0, 1428, 701, 3, 1108),
(6, 0, 'grpChefEq3', '2021-06-14', NULL, '2021-06-16', NULL, NULL, 'grp CE 3', 0, 0, 0, 0, 1402, 702, 5, 1119),
(106, 0, 'lwq', '2021-06-23', NULL, NULL, NULL, NULL, 'conception', 0, 0, 0, 0, 851, 700, 5, 1110),
(107, 0, 'lqo', '2021-06-30', NULL, NULL, NULL, NULL, 'sdad', 0, 0, 0, 0, 1402, 700, 3, 1109),
(115, 0, 'grpm1', '2021-06-29', '2021-06-23', '2021-06-30', '2021-06-24', 'grp1mm1', 'Grp m1', 0, 0, 0, 0, 1402, 703, 2, 1032),
(127, 0, 'gr1', '2021-07-06', NULL, '2021-07-15', NULL, NULL, 'groupe 1', 0, 0, 0, 0, 1001, 563, 2, 1118);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(129),
(129);

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

DROP TABLE IF EXISTS `lot`;
CREATE TABLE IF NOT EXISTS `lot` (
  `id` bigint(20) NOT NULL,
  `avancement` double NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_demarrage_effective` date DEFAULT NULL,
  `date_demarrage_prevu` date DEFAULT NULL,
  `date_fin_effective` date DEFAULT NULL,
  `date_fin_prevu` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nombre_joure_homme_effectif` bigint(20) NOT NULL,
  `nombre_joure_homme_prevu` bigint(20) NOT NULL,
  `nombre_joure_homme_retard` bigint(20) NOT NULL,
  `sro` varchar(255) DEFAULT NULL,
  `etat_lot` bigint(20) DEFAULT NULL,
  `projet` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg588ghkb95xampxow58t9kdgj` (`etat_lot`),
  KEY `FK2vubc9p5n4mdk3xndjr83lm2r` (`projet`),
  KEY `FKst6h18m0nkrlaxfu3gh2cg8v2` (`responsable`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lot`
--

INSERT INTO `lot` (`id`, `avancement`, `code`, `date_demarrage_effective`, `date_demarrage_prevu`, `date_fin_effective`, `date_fin_prevu`, `description`, `libelle`, `nombre_joure_homme_effectif`, `nombre_joure_homme_prevu`, `nombre_joure_homme_retard`, `sro`, `etat_lot`, `projet`, `responsable`) VALUES
(1001, 14, '1', '2019-08-01', NULL, '2019-08-10', NULL, '', 'Etude de SRO 017 du projet los', 10, 0, 2, '772', 65, 839, 840),
(1018, 10, '18', NULL, NULL, NULL, NULL, '', 'Etude de SRO 225 du projet los', 0, 0, 0, '784', 64, 852, 840),
(1019, 20, '19', NULL, NULL, NULL, NULL, '', 'Etude de SRO 226 du projet los', 0, 0, 0, '785', 64, 852, 840),
(1020, 0, '20', NULL, NULL, NULL, NULL, '', 'Etude de SRO 227 du projet los', 0, 0, 0, '786', 64, 852, 840),
(1021, 0, '21', NULL, NULL, NULL, NULL, '', 'Etude de SRO 334 du projet los', 0, 0, 0, '787', 64, 852, 840),
(1022, 0, '22', NULL, NULL, NULL, NULL, '', 'Etude de SRO 335 du projet los', 0, 0, 0, '788', 64, 852, 840),
(1023, 0, '23', NULL, NULL, NULL, NULL, '', 'Etude de SRO 032 du projet los', 0, 0, 0, '790', 64, 853, 840),
(1024, 0, '24', NULL, NULL, NULL, NULL, '', 'Etude de SRO 010 du projet los', 0, 0, 0, '791', 64, 853, 840),
(1025, 0, '25', NULL, NULL, NULL, NULL, '', 'Etude de SRO 011 du projet los', 0, 0, 0, '792', 64, 853, 840),
(1026, 0, '26', NULL, NULL, NULL, NULL, '', 'Etude de SRO 027 du projet los', 0, 0, 0, '793', 64, 853, 840),
(1027, 0, '27', NULL, NULL, NULL, NULL, '', 'Etude du SRO 028 du projet los', 0, 0, 0, '794', 64, 853, 840),
(1028, 0, '28', NULL, NULL, NULL, NULL, '', 'Etude du SRO 029 du projet los', 0, 0, 0, '795', 64, 853, 840),
(1029, 0, '29', NULL, NULL, NULL, NULL, '', 'Etude du SRO 030 du projet los', 0, 0, 0, '796', 64, 853, 840),
(1030, 0, '30', NULL, NULL, NULL, NULL, '', 'Etude du SRO 031 du projet los', 0, 0, 0, '797', 64, 853, 840),
(1031, 0, '31', NULL, NULL, NULL, NULL, '', 'Etude du SRO 316 du projet los', 0, 0, 0, '798', 64, 853, 840),
(1032, 0, '32', NULL, NULL, NULL, NULL, '', 'Etude de SRO 051 du projet los', 0, 0, 0, '800', 64, 1051, 840),
(1033, 0, '33', NULL, NULL, NULL, NULL, '', 'Etude de SRO 012 du projet los', 0, 0, 0, '801', 64, 1051, 840),
(1034, 0, '34', NULL, NULL, NULL, NULL, '', 'Etude de SRO 170 du projet los', 0, 0, 0, '802', 64, 1051, 840),
(1035, 0, '35', NULL, NULL, NULL, NULL, '', 'Etude de SRO 329 du projet 31', 0, 0, 0, '759', 64, 858, 840),
(1036, 0, '36', NULL, NULL, NULL, NULL, '', 'Etude de SRO 326 du projet 31', 0, 0, 0, '760', 64, 858, 840),
(1037, 0, '37', NULL, NULL, NULL, NULL, '', 'Etude de SRO 327 du projet 31', 0, 0, 0, '761', 64, 858, 840),
(1038, 0, '38', NULL, NULL, NULL, NULL, '', 'Etude de SRO 328 du projet 31', 0, 0, 0, '762', 64, 858, 908),
(1039, 0, '39', NULL, NULL, NULL, NULL, '', 'Etude de SRO 330 du projet 31', 0, 0, 0, '763', 64, 858, 908),
(1040, 0, '40', NULL, NULL, NULL, NULL, '', 'Etude de SRO 293 du projet 31', 0, 0, 0, '764', 64, 858, 908),
(1041, 0, '41', NULL, NULL, NULL, NULL, '', 'Etude de SRO 294 du projet 31', 0, 0, 0, '765', 64, 858, 908),
(1042, 0, '42', NULL, NULL, NULL, NULL, '', 'Etude de SRO 295 du projet 31', 0, 0, 0, '767', 64, 858, 908),
(1043, 0, '43', NULL, NULL, NULL, NULL, '', 'Département 001 ', 0, 0, 0, '769', 64, 914, 912),
(1044, 15, '44', '2019-08-14', NULL, '2019-08-24', NULL, '', 'Etude de SRO 018 du projet los', 0, 0, 0, '773', 358, 839, 840),
(1045, 20, '45', '2019-08-04', NULL, '2019-08-20', NULL, '', 'Etude de SRO 019 du projet los', 0, 0, 0, '774', 358, 839, 840),
(1046, 25, '46', NULL, NULL, NULL, NULL, '', 'Etude de SRO 021 du projet los', 0, 0, 0, '775', 64, 839, 840),
(1047, 30, '47', NULL, NULL, NULL, NULL, '', 'Etude de SRO 022 du projet los', 0, 0, 0, '776', 64, 839, 840),
(1048, 15, '48', NULL, NULL, NULL, NULL, '', 'Etude de SRO 023 du projet los', 0, 0, 0, '777', 64, 839, 840),
(1049, 18, '49', NULL, NULL, NULL, NULL, '', 'Etude de SRO 024 du projet los', 0, 0, 0, '778', 64, 839, 840),
(1050, 30, '50', NULL, NULL, NULL, NULL, '', 'Etude de SRO 025 du projet los', 0, 0, 0, '780', 64, 839, 840),
(1051, 25, '51', NULL, NULL, NULL, NULL, '', 'Etude de SRO 026 du projet los', 0, 0, 0, '781', 64, 839, 840),
(1052, 17, '52', NULL, NULL, NULL, NULL, '', 'Etude de SRO 308 du projet los', 0, 0, 0, '782', 64, 839, 840),
(1053, 42, '53', NULL, NULL, NULL, NULL, '', 'Etude de SRO 067 du projet 21', 0, 0, 0, '701', 64, 855, 909),
(1054, 30, '54', NULL, NULL, NULL, NULL, '', 'Etude de SRO 068 du projet los', 0, 0, 0, '702', 64, 855, 909),
(1055, 45, '55', NULL, NULL, NULL, NULL, '', 'Etude de SRO 069 du projet los', 0, 0, 0, '703', 64, 855, 909),
(1056, 0, '56', NULL, NULL, NULL, NULL, '', 'Etude de SRO 070 du projet los', 35, 0, 0, '705', 64, 855, 909),
(1057, 45, '57', NULL, NULL, NULL, NULL, '', 'Etude de SRO 071du projet los', 0, 0, 0, '706', 64, 855, 909),
(1058, 60, '58', NULL, NULL, NULL, NULL, '', 'Etude de SRO 072 du projet los', 0, 0, 0, '707', 64, 855, 909),
(1059, 0, '59', NULL, NULL, NULL, NULL, '', 'Etude de SRO 073 du projet los', 0, 0, 0, '708', 64, 855, 909),
(1060, 0, '60', NULL, NULL, NULL, NULL, '', 'Etude de SRO 074 du projet los', 0, 0, 0, '709', 64, 855, 909),
(1061, 25, '61', NULL, NULL, NULL, NULL, '', 'Etude de SRO 075 du projet 21', 0, 0, 0, '710', 64, 855, 909),
(1062, 0, '62', NULL, NULL, NULL, NULL, '', 'Etude de SRO 076 du projet 21', 0, 0, 0, '711', 64, 855, 909),
(1063, 0, '63', NULL, NULL, NULL, NULL, '', 'Etude de SRO 077 du projet 21', 0, 0, 0, '712', 64, 855, 909),
(1064, 30, '64', NULL, NULL, NULL, NULL, '', 'Etude de SRO 078 du projet 21', 0, 0, 0, '713', 64, 855, 909),
(1065, 0, '65', NULL, NULL, NULL, NULL, '', 'Etude de SRO 079 du projet 079', 0, 0, 0, '714', 64, 855, 909),
(1066, 35, '66', NULL, NULL, NULL, NULL, '', 'Etude de SRO 080 du projet 21', 0, 0, 0, '715', 64, 855, 909),
(1067, 0, '67', NULL, NULL, NULL, NULL, '', 'Etude de SRO 101 du projet 21', 0, 0, 0, '717', 64, 856, 909),
(1068, 0, '68', NULL, NULL, NULL, NULL, '', 'Etude de SRO 102 du projet 21', 0, 0, 0, '718', 64, 856, 909),
(1069, 55, '69', NULL, NULL, NULL, NULL, '', 'Etude de SRO 103 du projet 21', 0, 0, 0, '720', 64, 856, 909),
(1070, 0, '70', NULL, NULL, NULL, NULL, '', 'Etude de SRO 104 du projet 21', 0, 0, 0, '721', 64, 856, 909),
(1071, 0, '71', NULL, NULL, NULL, NULL, '', 'Etude de SRO 096 du projet 21', 0, 0, 0, '752', 64, 857, 909),
(1072, 0, '72', NULL, NULL, NULL, NULL, '', 'Etude de SRO 097 du projet 21', 0, 0, 0, '753', 64, 857, 909),
(1073, 0, '73', NULL, NULL, NULL, NULL, '', 'Etude de SRO 098 du projet 21', 0, 0, 0, '754', 64, 857, 909),
(1074, 5, '74', NULL, NULL, NULL, NULL, '', 'Etude de SRO 099 du projet 21', 0, 0, 0, '755', 64, 857, 909),
(1075, 0, '75', NULL, NULL, NULL, NULL, '', 'Etude de SRO 100 du projet 21', 0, 0, 0, '756', 64, 857, 909),
(1076, 0, '76', NULL, NULL, NULL, NULL, '', 'Etude de SRO 110 du projet 21', 0, 0, 0, '807', 64, 857, 909),
(1077, 0, '77', NULL, NULL, NULL, NULL, '', 'Etude de SRO 258 du projet 85', 0, 0, 0, '1', 64, 859, 906),
(1078, 0, '78', NULL, NULL, NULL, NULL, '', 'Etude de SRO 259 du projet 85', 0, 0, 0, '2', 64, 859, 906),
(1079, 0, '79', NULL, NULL, NULL, NULL, '', 'Etude de SRO 260 du projet 85', 0, 0, 0, '1101', 64, 859, 906),
(1080, 0, '80', NULL, NULL, NULL, NULL, '', 'Etude de SRO 261 du projet 85', 0, 0, 0, '4', 64, 859, 906),
(1081, 0, '81', NULL, NULL, NULL, NULL, '', 'Etude de SRO 262 du projet 85', 0, 0, 0, '5', 64, 859, 906),
(1082, 0, '82', NULL, NULL, NULL, NULL, '', 'Etude de SRO 813 du projet 85', 0, 0, 0, '1102', 64, 859, 906),
(1083, 0, '83', NULL, NULL, NULL, NULL, '', 'Etude de SRO 566 du projet 85', 0, 0, 0, '7', 64, 860, 906),
(1084, 0, '84', NULL, NULL, NULL, NULL, '', 'Etude de SRO 567 du projet 85', 0, 0, 0, '8', 64, 860, 906),
(1085, 0, '85', NULL, NULL, NULL, NULL, '', 'Etude de SRO 568 du projet 85', 0, 0, 0, '9', 64, 860, 906),
(1086, 0, '86', NULL, NULL, NULL, NULL, '', 'Etude de SRO 569 du projet 85', 0, 0, 0, '10', 64, 860, 906),
(1087, 0, '87', NULL, NULL, NULL, NULL, '', 'Etude de SRO 570 du projet 85', 0, 0, 0, '11', 64, 860, 906),
(1088, 0, '88', NULL, NULL, NULL, NULL, '', 'Etude de SRO 571 du projet 85', 0, 0, 0, '12', 64, 860, 906),
(1089, 0, '89', NULL, NULL, NULL, NULL, '', 'Etude de SRO 658 du projet 85', 0, 0, 0, '13', 64, 861, 906),
(1090, 0, '90', NULL, NULL, NULL, NULL, '', 'Etude de SRO 662 du projet 85', 0, 0, 0, '14', 64, 861, 906),
(1091, 0, '91', NULL, NULL, NULL, NULL, '', 'Etude de SRO 930 du projet 85', 0, 0, 0, '15', 64, 861, 906),
(1092, 0, '92', NULL, NULL, NULL, NULL, '', 'Etude de SRO 606 du projet 85', 0, 0, 0, '16', 64, 862, 906),
(1093, 0, '93', NULL, NULL, NULL, NULL, '', 'Etude de SRO 671 du projet 85', 0, 0, 0, '17', 64, 863, 906),
(1094, 0, '94', NULL, NULL, NULL, NULL, '', 'Etude de SRO 747 du projet 85', 0, 0, 0, '18', 64, 864, 906),
(1095, 0, '95', NULL, NULL, NULL, NULL, '', 'Etude de SRO 791 du projet 85', 0, 0, 0, '19', 64, 865, 906),
(1096, 0, '96', NULL, NULL, NULL, NULL, '', 'Etude de SRO 792 du projet 85', 0, 0, 0, '20', 64, 865, 906),
(1097, 0, '97', NULL, NULL, NULL, NULL, '', 'Etude de SRO 794 du projet 85', 0, 0, 0, '21', 64, 865, 906),
(1098, 0, '98', NULL, NULL, NULL, NULL, '', 'Etude de SRO 790 du projet 85', 0, 0, 0, '22', 64, 865, 906),
(1099, 0, '99', NULL, NULL, NULL, NULL, '', 'Etude de SRO 793 du projet 85', 0, 0, 0, '23', 64, 865, 906),
(1100, 0, '100', NULL, NULL, NULL, NULL, '', 'Etude de SRO 811 du projet 85', 0, 0, 0, '24', 64, 866, 906),
(1101, 0, '101', NULL, NULL, NULL, NULL, '', 'Etude de SRO 812 du projet 85', 0, 0, 0, '25', 64, 866, 906),
(1102, 0, '102', NULL, NULL, NULL, NULL, '', 'Etude de SRO 813 du projet 85', 0, 0, 0, '1102', 64, 866, 906),
(1103, 0, '103', NULL, NULL, NULL, NULL, '', 'Etude de SRO 814 du projet 85', 0, 0, 0, '1103', 64, 866, 906),
(1104, 0, '104', NULL, NULL, NULL, NULL, '', 'Etude de SRO 815 du projet 85', 0, 0, 0, '1104', 64, 866, 906),
(1105, 0, '105', NULL, NULL, NULL, NULL, '', 'Etude de SRO 816 du projet 85', 0, 0, 0, '1105', 64, 866, 906),
(1106, 0, '106', NULL, NULL, NULL, NULL, '', 'Etude de SRO 817 du projet 85', 0, 0, 0, '1106', 64, 866, 906),
(1107, 0, '107', NULL, NULL, NULL, NULL, '', 'Etude de SRO 818 du projet 85', 0, 0, 0, '1107', 64, 866, 906),
(1108, 0, '108', NULL, NULL, NULL, NULL, '', 'Etude de SRO 854 du projet 85', 0, 0, 0, '1152', 64, 1157, 906),
(1109, 0, '109', NULL, NULL, NULL, NULL, '', 'Etude de SRO 855 du projet 85', 0, 0, 0, '1153', 64, 1157, 906),
(1110, 0, '110', NULL, NULL, NULL, NULL, '', 'Etude de SRO 856 du projet 85', 0, 0, 0, '1154', 64, 1157, 906),
(1111, 0, '111', NULL, NULL, NULL, NULL, '', 'Etude de SRO 857 du projet 85', 0, 0, 0, '1155', 64, 1157, 906),
(1112, 0, '112', NULL, NULL, NULL, NULL, '', 'Etude de SRO 929 du projet 85', 0, 0, 0, '1156', 64, 1157, 906),
(1113, 0, '113', NULL, NULL, NULL, NULL, '', 'Etude de SRO 024 du projet 89', 0, 0, 0, '778', 64, 951, 909),
(1114, 0, '114', NULL, NULL, NULL, NULL, '', 'Etude de SRO 027 du projet 89', 0, 0, 0, '793', 64, 951, 909),
(1115, 0, '115', NULL, NULL, NULL, NULL, '', 'Etude de SRO 037 du projet 89', 0, 0, 0, '806', 64, 951, 909),
(1116, 0, '116', NULL, NULL, NULL, NULL, '', 'Etude de SRO 110 du projet 89', 0, 0, 0, '807', 64, 951, 909),
(1117, 0, '117', NULL, NULL, NULL, NULL, '', 'Etude de SRO 118 du projet 89', 0, 0, 0, '808', 64, 951, 909),
(1118, 0, '118', NULL, NULL, NULL, NULL, '', 'Etude de SRO 009 du projet 89', 0, 0, 0, '810', 64, 1201, 909),
(1119, 0, '119', NULL, NULL, NULL, NULL, '', 'Etude de SRO 029 du projet 89', 0, 0, 0, '795', 64, 1201, 909),
(1120, 0, '120', NULL, NULL, NULL, NULL, '', 'Etude de SRO 030 du projet 89', 0, 0, 0, '796', 64, 1201, 909),
(1121, 0, '121', NULL, NULL, NULL, NULL, '', 'Etude de SRO 031 du projet 89', 0, 0, 0, '797', 64, 1201, 909),
(1122, 0, '122', NULL, NULL, NULL, NULL, '', 'Etude de SRO 039 du projet 89', 0, 0, 0, '814', 64, 1201, 909),
(1123, 0, '123', NULL, NULL, NULL, NULL, '', 'Etude de SRO 040 du projet 89', 0, 0, 0, '815', 64, 1201, 909),
(1124, 0, '124', NULL, NULL, NULL, NULL, '', 'Etude de SRO 041 du projet 89', 0, 0, 0, '816', 64, 1201, 909),
(1125, 0, '125', NULL, NULL, NULL, NULL, '', 'Etude de SRO 042 du projet 89', 0, 0, 0, '817', 64, 1201, 909),
(1126, 0, '126', NULL, NULL, NULL, NULL, '', 'Etude de SRO 021 du projet 89', 0, 0, 0, '775', 64, 1202, 909),
(1127, 0, '127', NULL, NULL, NULL, NULL, '', 'Etude de SRO 022 du projet 89', 0, 0, 0, '776', 64, 1202, 909),
(1128, 0, '128', NULL, NULL, NULL, NULL, '', 'Etude de SRO 023 du projet 89', 0, 0, 0, '777', 64, 1202, 909),
(1129, 0, '129', NULL, NULL, NULL, NULL, '', 'Etude de SRO 158 du projet 89', 0, 0, 0, '822', 64, 1202, 909),
(1130, 0, '130', NULL, NULL, NULL, NULL, '', 'Etude de SRO 053 du projet 89', 0, 0, 0, '823', 64, 1202, 909),
(1131, 0, '131', NULL, NULL, NULL, NULL, '', 'Etude de SRO 144 du projet 89', 0, 0, 0, '824', 64, 1202, 909),
(1132, 0, '132', NULL, NULL, NULL, NULL, '', 'Etude de SRO 033 du projet 89', 0, 0, 0, '826', 64, 1251, 909),
(1133, 0, '133', NULL, NULL, NULL, NULL, '', 'Etude de SRO 034 du projet 89', 0, 0, 0, '827', 64, 1251, 909),
(1134, 0, '134', NULL, NULL, NULL, NULL, '', 'Etude de SRO 035 du projet 89', 0, 0, 0, '828', 64, 1251, 909),
(1135, 0, '135', NULL, NULL, NULL, NULL, '', 'Etude de SRO 036 du projet 89', 0, 0, 0, '829', 64, 1251, 909),
(1136, 0, '136', NULL, NULL, NULL, NULL, '', 'Etude de SRO 145 du projet 89', 0, 0, 0, '831', 64, 1252, 909),
(1137, 0, '137', NULL, NULL, NULL, NULL, '', 'Etude de SRO 151 du projet 89', 0, 0, 0, '832', 64, 1252, 909),
(1138, 0, '138', NULL, NULL, NULL, NULL, '', 'Etude de SRO 152 du projet 89', 0, 0, 0, '833', 64, 1252, 909),
(1139, 0, '139', NULL, NULL, NULL, NULL, '', 'Etude de SRO 163 du projet 89', 0, 0, 0, '834', 64, 1252, 909),
(1140, 0, '140', NULL, NULL, NULL, NULL, '', 'Etude de SRO 288 du projet 89', 0, 0, 0, '835', 64, 1252, 909),
(1141, 0, '141', NULL, NULL, NULL, NULL, '', 'Département 002 ', 0, 0, 0, '6', 64, 914, 912),
(126, 3, 'L1', '2021-07-16', '2021-07-23', '2021-07-24', '2021-07-30', '', 'lot wa7idoine', 22, 66, 1, NULL, 65, 125, 452);

-- --------------------------------------------------------

--
-- Structure de la table `membre_equipe`
--

DROP TABLE IF EXISTS `membre_equipe`;
CREATE TABLE IF NOT EXISTS `membre_equipe` (
  `id` bigint(20) NOT NULL,
  `collaborateur` bigint(20) DEFAULT NULL,
  `equipe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKksqjsq2jg04g37c2ha69wj2dp` (`collaborateur`),
  KEY `FK5p3qb1jegvkt44fnmpue39ahb` (`equipe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre_equipe`
--

INSERT INTO `membre_equipe` (`id`, `collaborateur`, `equipe`) VALUES
(565, 533, 562),
(566, 546, 564),
(567, 536, 563),
(568, 537, 563),
(569, 538, 563),
(570, 539, 563),
(571, 540, 564),
(572, 541, 563),
(573, 542, 563),
(574, 543, 564),
(575, 544, 564),
(576, 545, 564),
(577, 547, 564),
(578, 548, 564),
(582, 527, 581),
(587, 535, 562),
(588, 534, 562),
(589, 912, 562),
(590, 549, 564),
(591, 521, 583),
(593, 524, 603),
(594, 526, 586),
(595, 523, 585),
(596, 528, 581),
(597, 529, 560),
(598, 531, 560),
(599, 532, 560),
(601, 913, 600),
(21, 529, 403),
(22, 908, 403),
(7, 520, 700),
(8, 519, 700),
(9, 521, 700),
(10, 520, 701),
(11, 524, 701),
(12, 523, 701),
(13, 527, 700),
(85, 914, 702),
(86, 526, 702),
(87, 532, 702),
(88, 522, 703),
(89, 535, 703),
(120, 519, 119),
(121, 521, 119),
(122, 523, 119);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id` bigint(20) NOT NULL,
  `corps` varchar(255) DEFAULT NULL,
  `date_envoi` date DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `etat_message` bigint(20) DEFAULT NULL,
  `source` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmnkvt5v8vfe5j6ep64bx0alxo` (`etat_message`),
  KEY `FK2uyh1m7karse90yvkbbafw6ys` (`source`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message_detail`
--

DROP TABLE IF EXISTS `message_detail`;
CREATE TABLE IF NOT EXISTS `message_detail` (
  `id` bigint(20) NOT NULL,
  `date_lecture` date DEFAULT NULL,
  `destinataire` bigint(20) DEFAULT NULL,
  `etat_message` bigint(20) DEFAULT NULL,
  `message` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcolbuqqdedp4ggbov1li9sbk` (`destinataire`),
  KEY `FKiko8jiqcna4okkgbygju90pn6` (`etat_message`),
  KEY `FKnn1a22t39qplr7ygsxstc41j3` (`message`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE IF NOT EXISTS `paiement` (
  `id` bigint(20) NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` decimal(19,2) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `etat_paiement` bigint(20) DEFAULT NULL,
  `facture` bigint(20) DEFAULT NULL,
  `type_paiement` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiolw9g4a6fgbdti3f44celgk2` (`etat_paiement`),
  KEY `FKqnf7tguw1468nvt99bmo0khel` (`facture`),
  KEY `FKb6dek7rj0i9jpsli941ti12a5` (`type_paiement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`id`, `date_paiement`, `description`, `libelle`, `montant`, `reference`, `etat_paiement`, `facture`, `type_paiement`) VALUES
(68, '2021-06-09', '23456789', 'paiement 1', '50.00', 'p1', 3, 62, 4),
(69, '2021-06-14', '345678', 'paiement 2', '30.00', 'p2', 2, 62, 2),
(71, '2021-06-17', 'dfghjkl\n', 'ppppp0', '12.00', 'pp0', 3, 60, 3),
(72, '2021-06-10', 'sfghjkl', '345678', '70.00', '345678', 3, 60, 2),
(73, '2021-06-19', 'dfghj', 'achat 1', '120.00', '45678', 3, 57, 3),
(76, '2021-06-24', 'dfghjk', '456789', '35.00', '09876', 3, 57, 2),
(77, '2021-06-09', 'yhgyj', '456789', '118.00', '8756', 3, 60, 3),
(78, '2021-06-09', 'jbjnj', 'jjjkjk', '56.00', 'jjijiij', 2, 60, 3),
(79, '2021-06-16', 'jkjhj', '11', '200.00', '11', 3, 75, 3),
(111, '2021-06-30', 'DS', 'P1', '34.00', 'PQ1', 3, 74, 2),
(112, '2021-06-15', 'das', 'wqswd', '100.00', 'wdq', 2, 75, 1),
(114, '2021-06-16', 'dfghj', 'tyuio', '70.00', 'rtyui', 1, 75, 2),
(118, '2021-06-29', 'test', 'paiement3 ', '40.00', 'pp3', 3, 62, 3);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`id`, `code`, `libelle`) VALUES
(2001, 'Maroc', 'Maroc');

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

DROP TABLE IF EXISTS `periode`;
CREATE TABLE IF NOT EXISTS `periode` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `periode`
--

INSERT INTO `periode` (`id`, `code`, `description`, `libelle`) VALUES
(1, 'mt', '', 'Matin'),
(2, 'am', '', 'Aprés Midi'),
(3, 'sr', '', 'Soir');

-- --------------------------------------------------------

--
-- Structure de la table `pole`
--

DROP TABLE IF EXISTS `pole`;
CREATE TABLE IF NOT EXISTS `pole` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `pays` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4twfbibah0eh43mb79ij0pjvv` (`pays`),
  KEY `FKeo8tfh03lhgvjlf099mysj1aw` (`responsable`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pressence`
--

DROP TABLE IF EXISTS `pressence`;
CREATE TABLE IF NOT EXISTS `pressence` (
  `id` bigint(20) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `date_entree` datetime DEFAULT NULL,
  `date_sortie` datetime DEFAULT NULL,
  `heure_retard` int(11) DEFAULT NULL,
  `minute_retard` int(11) DEFAULT NULL,
  `mois` int(11) DEFAULT NULL,
  `nombre_heure_travail` int(11) DEFAULT NULL,
  `semaine` int(11) DEFAULT NULL,
  `collaborateur` bigint(20) DEFAULT NULL,
  `entite_administrative` bigint(20) DEFAULT NULL,
  `periode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahitqugv38ww96ikc8ceaqhqc` (`collaborateur`),
  KEY `FKg60m64ol52aam66prk22a4xew` (`entite_administrative`),
  KEY `FKrh4rvm6hcq8u0frcr1qc4g3y9` (`periode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `id` bigint(20) NOT NULL,
  `avancement` double NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_demarrage_effective` date DEFAULT NULL,
  `date_demarrage_prevu` date DEFAULT NULL,
  `date_fin_effective` date DEFAULT NULL,
  `date_fin_prevu` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nombre_joure_homme_effectif` bigint(20) NOT NULL,
  `nombre_joure_homme_prevu` bigint(20) NOT NULL,
  `nombre_joure_homme_retard` bigint(20) NOT NULL,
  `nro` varchar(255) DEFAULT NULL,
  `agence` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  `etat_projet` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8yjwr5b2yhls1lks67l08g05q` (`agence`),
  KEY `FKrxu4i8mqovfdheo33io97sy83` (`client`),
  KEY `FKbt8ckk11mq0rwhe961wvs5q0q` (`etat_projet`),
  KEY `FKesspunjt4459af7darpf9l5t9` (`responsable`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id`, `avancement`, `code`, `date_demarrage_effective`, `date_demarrage_prevu`, `date_fin_effective`, `date_fin_prevu`, `description`, `libelle`, `nombre_joure_homme_effectif`, `nombre_joure_homme_prevu`, `nombre_joure_homme_retard`, `nro`, `agence`, `client`, `etat_projet`, `responsable`) VALUES
(1201, 0, 'projet1201', NULL, NULL, NULL, NULL, '', 'Yconick 042', 0, 0, 0, '799', 3, 918, 58, 909),
(1157, 10, 'projet1157', NULL, NULL, NULL, NULL, '', 'Vendee 081', 0, 0, 0, '1151', 4, 918, 58, 906),
(1051, 0, 'projet1051', NULL, NULL, NULL, NULL, '', 'Losange 042', 0, 0, 0, '799', 3, 917, 56, 840),
(951, 15, 'projet951', '2021-04-13', NULL, '2021-05-13', NULL, '', 'Yconick 018', 4, 0, 2, '803', 3, 920, 56, 909),
(866, 40, 'projet866', '2021-03-18', NULL, '2021-04-25', NULL, '', 'Vendee 076', 7, 0, 0, '8', 4, 919, 56, 906),
(865, 0, 'projet865', '2021-05-17', NULL, '2021-06-30', NULL, '', 'Vendee 072', 5, 0, 1, '7', 4, 919, 56, 906),
(864, 0, 'projet864', '2021-03-28', NULL, '2021-05-27', NULL, '', 'Vendee 066', 7, 0, 3, '6', 4, 919, 56, 906),
(863, 0, 'projet863', '2021-02-17', NULL, '2021-04-19', NULL, '', 'Vendee 056', 8, 0, 3, '5', 4, 919, 56, 906),
(862, 35, 'projet862', '2021-01-26', NULL, '2021-04-22', NULL, '', 'Vendee 053', 18, 0, 4, '4', 4, 919, 56, 906),
(861, 12, 'projet861', '2021-02-24', NULL, '2021-06-24', NULL, '', 'Vendee 055', 9, 0, 4, '3', 4, 919, 56, 906),
(860, 25, 'projet860', '2021-05-14', NULL, '2021-07-15', NULL, '', 'Vendee 048', 8, 0, 4, '2', 4, 919, 56, 906),
(1801, 0, 'projet1801', NULL, NULL, NULL, NULL, '', 'Vendee 018', 0, 0, 0, '1', 4, 919, 56, 906),
(858, 10, 'projet858', '2021-04-20', NULL, '2021-06-21', NULL, '', 'Fibre 31-206', 20, 0, 4, '758', 4, 916, 56, 908),
(857, 25, 'projet857', '2021-02-16', NULL, '2021-03-25', NULL, '', 'Fibre 21-016', 6, 0, 4, '751', 4, 915, 56, 909),
(856, 30, 'projet856', '2021-05-19', NULL, '2021-07-19', NULL, '', 'Fibre 21-017', 10, 0, 4, '716', 4, 915, 56, 909),
(855, 20, 'projet855', '2021-04-14', NULL, '2021-05-26', NULL, '', 'Fibre 21-011', 8, 0, 2, '651', 4, 915, 56, 909),
(853, 30, 'projet853', '2021-03-17', NULL, '2021-05-05', NULL, '', 'losange 032', 6, 0, 2, '789', 4, 918, 56, 840),
(852, 10, 'projet852', '2021-05-11', NULL, '2021-05-19', NULL, '', 'losange 001', 5, 0, 5, '783', 4, 918, 56, 840),
(839, 10, 'projet839', '2021-01-26', NULL, '2021-02-10', NULL, '', 'losange 030', 2, 0, 2, '771', 4, 918, 56, 840),
(1202, 0, 'projet1202', NULL, NULL, NULL, NULL, '', 'Yconick 013', 0, 0, 0, '818', 4, 920, 56, 909),
(1251, 0, 'projet1251', NULL, NULL, NULL, NULL, '', 'Yconick 032', 0, 0, 0, '789', 4, 920, 56, 909),
(1252, 0, 'projet1252', NULL, NULL, NULL, NULL, '', 'Yconick 015', 0, 0, 0, '830', 4, 920, 56, 909),
(1431, 0, 'projet1431', NULL, NULL, NULL, NULL, '', 'PACA 04', 0, 0, 0, '768', 4, 917, 56, 912),
(1432, 0, 'projet1432', NULL, NULL, NULL, NULL, '', 'PACA 05', 0, 0, 0, '1469', 4, 917, 56, NULL),
(1433, 0, 'projet1433', NULL, NULL, NULL, NULL, '', 'IDF 78', 0, 0, 0, '1470', 4, 1435, 56, NULL),
(98, 32, 'tqsg', '2021-06-15', '2021-06-16', '2021-06-15', '2021-06-14', 'hdw', 'w', 23, 0, 32, NULL, 4, 916, 310, 522),
(125, 33, 'Pr', '2021-07-10', '2021-07-17', '2021-07-16', '2021-07-21', NULL, 'PROJET FACHILE', 22, 0, 45, NULL, 4, 917, 58, 452);

-- --------------------------------------------------------

--
-- Structure de la table `projet_equipe`
--

DROP TABLE IF EXISTS `projet_equipe`;
CREATE TABLE IF NOT EXISTS `projet_equipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipe` bigint(20) DEFAULT NULL,
  `projet` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKojk8u7ps8of6ftmy23t1ki28v` (`equipe`),
  KEY `FKcxpqwx8bu6xm4hh3tpsmvfssa` (`projet`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projet_equipe`
--

INSERT INTO `projet_equipe` (`id`, `equipe`, `projet`) VALUES
(17, 560, 1201),
(2, 563, 1201),
(3, 700, 1157),
(4, 701, 1157),
(5, 702, 1051),
(6, 703, 1051),
(7, 702, 866),
(8, 703, 866),
(9, 560, 865),
(10, 561, 865),
(13, 562, 98),
(14, 563, 98),
(18, 560, 125),
(19, 564, 125),
(20, 119, 125);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_COLLABORATEUR'),
(3, 'ROLE_CHEF_AGENCE'),
(9, 'ROLE_CHEF_EQUIPE');

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `id` bigint(20) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_demarrage_effective` date DEFAULT NULL,
  `date_fin_effective` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `mois` int(11) DEFAULT NULL,
  `semaine` int(11) DEFAULT NULL,
  `categorie_tache` bigint(20) DEFAULT NULL,
  `etat_tache` bigint(20) DEFAULT NULL,
  `groupe_tache` bigint(20) DEFAULT NULL,
  `membre_equipe` bigint(20) DEFAULT NULL,
  `periode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4s39r5e1jrb0273lyfjhrxs1i` (`categorie_tache`),
  KEY `FKqgtasyonpsk42hl5m6ai25g3u` (`etat_tache`),
  KEY `FK80pyfav4t7r3wfgeextkexgue` (`groupe_tache`),
  KEY `FKkrmx2occfn9jv7ykyod1ng1kt` (`membre_equipe`),
  KEY `FKtm2hs6706t035hyq6yk1l80g7` (`periode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `annee`, `code`, `date_demarrage_effective`, `date_fin_effective`, `description`, `libelle`, `mois`, `semaine`, `categorie_tache`, `etat_tache`, `groupe_tache`, `membre_equipe`, `periode`) VALUES
(3149, 2021, '3149', '2021-04-26', NULL, NULL, 'Réalisation FOA', 3, 17, 1454, NULL, 2522, 588, 2),
(2376, 2021, '2376', '2021-04-12', NULL, NULL, 'Conception Point Technique', 3, 15, 1494, NULL, 2420, 599, 2),
(3142, 2021, '3142', '2021-04-29', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2361, 569, 2),
(3143, 2021, '3143', '2021-04-30', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2361, 569, 1),
(2402, 2021, '2402', '2021-04-19', '2021-06-16 00:00:00', NULL, 'Reprise', 3, 16, 954, 62, 2369, 599, 3),
(2405, 2021, '2405', '2021-04-19', NULL, NULL, 'Reprise', 3, 16, 1508, NULL, 2369, 599, 2),
(3238, 2021, '3238', '2021-04-29', NULL, NULL, 'Contrôle', 3, 17, 1522, NULL, 2366, 593, 1),
(3239, 2021, '3239', '2021-04-29', NULL, '', 'Contrôle', 3, 17, 1522, NULL, 2366, 593, 2),
(2408, 2021, '2408', '2021-04-20', NULL, NULL, 'Reprise', 3, 16, 1508, NULL, 2370, 599, 1),
(2411, 2021, '2411', '2021-04-20', NULL, NULL, 'Reprise', 3, 16, 1508, NULL, 2370, 599, 2),
(3240, 2021, '3240', '2021-04-30', NULL, NULL, 'Contrôle', 3, 17, 1522, NULL, 2366, 593, 1),
(2399, 2021, '2399', '2021-04-16', NULL, NULL, 'Reprise', 3, 15, 1508, NULL, 2368, 599, 2),
(2397, 2021, '2397', '2021-04-16', NULL, NULL, 'Reprise', 3, 15, 1508, NULL, 2368, 599, 1),
(2392, 2021, '2392', '2021-04-15', NULL, NULL, 'Conception des boîtes', 3, 15, 1496, NULL, 2420, 599, 1),
(2394, 2021, '2394', '2021-04-15', NULL, NULL, 'Conception des boîtes', 3, 15, 1496, NULL, 2420, 599, 2),
(3241, 2021, '3241', '2021-04-30', NULL, NULL, 'Contrôle', 3, 17, 1522, NULL, 2366, 593, 2),
(2386, 2021, '2386', '2021-04-14', NULL, NULL, 'Conception des Supports', 3, 15, 1495, NULL, 2420, 599, 2),
(2385, 2021, '2385', '2021-04-14', NULL, NULL, 'Reprise', 3, 15, 1508, NULL, 2360, 599, 1),
(2384, 2021, '2384', '2021-04-13', NULL, NULL, 'Reprise', 3, 15, 1508, NULL, 2360, 599, 2),
(2380, 2021, '2380', '2021-04-13', NULL, NULL, 'Conception Point Technique', 3, 15, 1494, NULL, 2420, 599, 1),
(2359, 2021, '2359', '2021-04-02', NULL, NULL, 'Reprise', 3, 13, 1508, NULL, 2189, 599, 2),
(3135, 2021, '3135', '2021-04-28', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2362, 569, 1),
(2361, 2021, '2361', '2021-04-05', NULL, NULL, 'Reprise', 3, 14, 1508, NULL, 2189, 599, 1),
(3131, 2021, '3131', '2021-04-26', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2367, 569, 1),
(2364, 2021, '2364', '2021-04-05', NULL, NULL, 'Reprise', 3, 14, 1508, NULL, 2189, 599, 2),
(2366, 2021, '2366', '2021-04-06', NULL, NULL, 'Reprise', 3, 14, 1508, NULL, 2189, 599, 1),
(2368, 2021, '2368', '2021-04-06', NULL, NULL, 'Reprise', 3, 14, 1508, NULL, 2189, 599, 2),
(2369, 2021, '2369', '2021-04-05', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2337, 596, 1),
(2370, 2021, '2370', '2021-04-08', NULL, NULL, 'Reprise', 3, 14, 1508, NULL, 2189, 599, 1),
(2714, 2021, '2714', '2021-04-01', NULL, NULL, 'Conception des Supports', 3, 13, 1495, NULL, 2379, 598, 1),
(2372, 2021, '2372', '2021-04-05', NULL, '', 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 2),
(2375, 2021, '2375', '2021-04-12', NULL, NULL, 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal+APS TR)', 3, 15, 1493, NULL, 2420, 599, 1),
(2716, 2021, '2716', '2021-04-01', NULL, NULL, 'Conception Point Technique', 3, 13, 1494, NULL, 2379, 598, 2),
(3136, 2021, '3136', '2021-04-28', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2362, 569, 2),
(27, 2021, '27', '2021-04-02', NULL, '', 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2327, 582, 2),
(26, 2021, '26', '2021-04-02', NULL, NULL, 'Contrôle SIO Niv 2', 3, 13, 1498, NULL, 2249, 601, 1),
(18, 2021, '18', '2021-04-02', NULL, NULL, 'Avancement', 3, 13, 1540, NULL, 2349, 596, 1),
(13, 2021, '13', '2021-04-01', NULL, NULL, 'Avancement', 3, 13, 1540, NULL, 2330, 596, 1),
(2567, 2021, '2567', '2021-04-07', NULL, '', 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 1),
(20, 2021, '20', '2021-04-01', NULL, NULL, 'Contrôle SIO Niv 2', 3, 13, 1498, NULL, 2245, 601, 1),
(24, 2021, '24', '2021-04-02', NULL, '', 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2327, 582, 1),
(3072, 2021, '3072', '2021-04-19', NULL, NULL, 'APD GC + Poteaux', 3, 16, 1416, NULL, 2299, 601, 1),
(21, 2021, '21', '2021-04-02', NULL, NULL, 'Réalisation de dossier', 3, 13, 1538, NULL, 2337, 596, 2),
(22, 2021, '22', '2021-04-01', NULL, NULL, 'Contrôle SIO Niv 2', 3, 13, 1498, NULL, 2248, 601, 2),
(2373, 2021, '2373', '2021-04-09', NULL, NULL, 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal+APS TR)', 3, 14, 1493, NULL, 2420, 599, 2),
(16, 2021, '16', '2021-04-01', NULL, '', 'Contrôl Retour Terrain', 3, 16, 1537, NULL, 2342, NULL, 1),
(3147, 2021, '3147', '2021-04-26', NULL, NULL, 'Vérification +Depose', 3, 17, 1581, NULL, 2459, 589, 1),
(3154, 2021, '3154', '2021-04-09', NULL, NULL, 'Vérification(Photo FOA +PIT+C3B si complexe)', 3, 14, 1451, NULL, 2496, 589, 1),
(2467, 2021, '2467', '2021-04-02', NULL, '', 'Réalisation shp', 3, 13, 1453, NULL, 2261, 589, 2),
(3159, 2021, '3159', '2021-04-29', NULL, NULL, 'Reprise du PA', 3, 17, 1434, NULL, 2272, 588, 1),
(2490, 2021, '2490', '2021-04-02', NULL, NULL, 'Vérification du PA +dépose', 3, 13, 1433, NULL, 2323, 589, 1),
(2494, 2021, '2494', '2021-04-22', NULL, NULL, 'Contrôle', 3, 16, 1429, NULL, 2253, 589, 1),
(3141, 2021, '3141', '2021-04-29', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2361, 569, 1),
(3144, 2021, '3144', '2021-04-30', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2361, 569, 2),
(2511, 2021, '2511', '2021-04-06', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 1),
(2514, 2021, '2514', '2021-04-06', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 2),
(3134, 2021, '3134', '2021-04-27', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2362, 569, 2),
(3145, 2021, '3145', '2021-04-26', NULL, NULL, 'Vérification', 3, 17, 1471, NULL, 2531, 589, 3),
(3155, 2021, '3155', '2021-04-28', NULL, NULL, 'Réalisation shp', 3, 17, 1453, NULL, 2613, 588, 1),
(3153, 2021, '3153', '2021-04-27', NULL, NULL, 'Reprise', 3, 17, 1430, NULL, 2257, 588, 2),
(3157, 2021, '3157', '2021-04-28', NULL, NULL, 'Réalisation C3A si simple', 3, 17, 1452, NULL, 2613, 588, 2),
(3156, 2021, '3156', '2021-04-09', NULL, NULL, 'Contôle et dépose', 3, 14, 1455, NULL, 2461, 589, 3),
(3133, 2021, '3133', '2021-04-27', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2362, 569, 1),
(3132, 2021, '3132', '2021-04-26', NULL, NULL, 'PDS', 3, 17, 1515, NULL, 2367, 569, 2),
(2641, 2021, '2641', '2021-04-23', NULL, '', 'Vérification ', 3, 16, 1511, NULL, 2374, 598, 1),
(3124, 2021, '3124', '2021-04-01', NULL, NULL, 'Contrôl Retour Terrain', 3, 13, 1537, NULL, 2343, 582, 2),
(3125, 2021, '3125', '2021-04-08', NULL, NULL, 'Extraction des immeubles du SID', 3, 14, 1539, NULL, 2361, 582, 1),
(2566, 2021, '2566', '2021-04-01', NULL, NULL, 'Réalisation de dossier', 3, 13, 1538, NULL, 2334, 596, 2),
(2568, 2021, '2568', '2021-04-07', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 2),
(2569, 2021, '2569', '2021-04-08', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 1),
(2570, 2021, '2570', '2021-04-08', NULL, NULL, 'Extraction des immeubles du SID', 3, 14, 1539, NULL, 2370, 596, 2),
(2571, 2021, '2571', '2021-04-09', NULL, NULL, 'Réalisation de dossier', 3, 14, 1538, NULL, 2335, 596, 1),
(2572, 2021, '2572', '2021-04-09', NULL, NULL, 'Avancement', 3, 14, 1540, NULL, 2376, 596, 2),
(3126, 2021, '3126', '2021-04-08', NULL, NULL, 'Extraction des immeubles du SID', 3, 14, 1539, NULL, 2374, 582, 2),
(2575, 2021, '2575', '2021-04-12', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2337, 596, 1),
(2576, 2021, '2576', '2021-04-12', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2335, 596, 2),
(2577, 2021, '2577', '2021-04-13', NULL, NULL, 'Avancement', 3, 15, 1540, NULL, 2335, 596, 1),
(2578, 2021, '2578', '2021-04-13', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2332, 596, 2),
(2579, 2021, '2579', '2021-04-14', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2343, 596, 1),
(2580, 2021, '2580', '2021-04-14', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2344, 596, 2),
(2581, 2021, '2581', '2021-04-15', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2342, 596, 1),
(2582, 2021, '2582', '2021-04-15', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2349, 596, 2),
(2583, 2021, '2583', '2021-04-16', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2348, 596, 1),
(2584, 2021, '2584', '2021-04-16', NULL, NULL, 'Réalisation de dossier', 3, 15, 1538, NULL, 2330, 596, 2),
(2585, 2021, '2585', '2021-04-19', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2333, 596, 1),
(2586, 2021, '2586', '2021-04-19', NULL, NULL, 'Avancement', 3, 16, 1540, NULL, 2348, 596, 2),
(2587, 2021, '2587', '2021-04-20', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2349, 596, 1),
(2588, 2021, '2588', '2021-04-20', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2347, 596, 2),
(2589, 2021, '2589', '2021-04-21', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2334, 596, 1),
(2590, 2021, '2590', '2021-04-21', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2346, 596, 2),
(2591, 2021, '2591', '2021-04-22', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2330, 596, 1),
(2592, 2021, '2592', '2021-04-22', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2349, 596, 2),
(2595, 2021, '2595', '2021-04-23', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2349, 596, 1),
(2600, 2021, '2600', '2021-04-23', NULL, NULL, 'Réalisation de dossier', 3, 16, 1538, NULL, 2349, 596, 2),
(2604, 2021, '2604', '2021-04-26', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2343, 596, 1),
(2609, 2021, '2609', '2021-04-26', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2328, 596, 2),
(2611, 2021, '2611', '2021-04-27', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2328, 596, 1),
(2615, 2021, '2615', '2021-04-28', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2333, 596, 1),
(2613, 2021, '2613', '2021-04-27', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2328, 596, 2),
(2616, 2021, '2616', '2021-04-28', NULL, '', 'Réalisation de dossier', 3, 17, 1538, NULL, 2349, 596, 1),
(2621, 2021, '2621', '2021-04-29', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2342, 596, 1),
(2622, 2021, '2622', '2021-04-29', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2344, 596, 2),
(2624, 2021, '2624', '2021-04-30', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2326, 596, 1),
(2633, 2021, '2633', '2021-04-30', NULL, NULL, 'Avancement', 3, 17, 1540, NULL, 2331, 596, 2),
(2650, 2021, '2650', '2021-04-23', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2367, 569, 1),
(2952, 2021, '2952', '2021-04-23', NULL, NULL, 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2325, 582, 1),
(3148, 2021, '3148', '2021-04-26', NULL, NULL, 'Réalisation C3A si simple', 3, 17, 1452, NULL, 2522, 588, 1),
(2953, 2021, '2953', '2021-04-23', NULL, NULL, 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2325, 582, 2),
(3025, 2021, '3025', '2021-04-08', NULL, '', 'Vérification', 3, 14, 1512, NULL, 2246, 601, 1),
(2677, 2021, '2677', '2021-04-22', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2367, 569, 1),
(2678, 2021, '2678', '2021-04-22', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2367, 569, 2),
(2683, 2021, '2683', '2021-04-21', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2246, 569, 1),
(2684, 2021, '2684', '2021-04-21', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2367, 569, 2),
(2685, 2021, '2685', '2021-04-20', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2366, 569, 1),
(2686, 2021, '2686', '2021-04-20', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2366, 569, 2),
(2687, 2021, '2687', '2021-04-19', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2365, 569, 1),
(2688, 2021, '2688', '2021-04-19', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2366, 569, 2),
(2692, 2021, '2692', '2021-04-15', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2365, 569, 2),
(2689, 2021, '2689', '2021-04-16', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2365, 569, 1),
(2690, 2021, '2690', '2021-04-16', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2365, 569, 2),
(2691, 2021, '2691', '2021-04-15', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2365, 569, 1),
(2693, 2021, '2693', '2021-04-14', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2372, 569, 1),
(2694, 2021, '2694', '2021-04-14', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2372, 569, 2),
(2695, 2021, '2695', '2021-04-13', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2402, 569, 1),
(2696, 2021, '2696', '2021-04-13', NULL, NULL, 'PDS', 3, 15, 1515, NULL, 2402, 569, 2),
(2697, 2021, '2697', '2021-04-14', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1543, NULL, 2324, 582, 1),
(2698, 2021, '2698', '2021-04-14', NULL, '', 'Création et Réalisation du dossier', 3, 15, 1543, NULL, 2353, 582, 1),
(2699, 2021, '2699', '2021-04-01', NULL, NULL, 'Contrôl Retour Terrain', 3, 13, 1537, NULL, 2346, 582, 1),
(2701, 2021, '2701', '2021-04-05', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1543, NULL, 2352, 582, 1),
(2702, 2021, '2702', '2021-04-05', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1543, NULL, 2351, 582, 2),
(2721, 2021, '2721', '2021-04-02', NULL, NULL, 'Conception des boîtes', 3, 13, 1496, NULL, 2379, 598, 1),
(2723, 2021, '2723', '2021-04-02', NULL, NULL, 'Conception des boîtes', 3, 13, 1496, NULL, 2379, 598, 2),
(2724, 2021, '2724', '2021-04-05', NULL, NULL, 'Conception des adductions', 3, 14, 1566, NULL, 2379, 598, 1),
(2725, 2021, '2725', '2021-04-05', NULL, NULL, 'Conception des Supports', 3, 14, 1495, NULL, 2360, 598, 2),
(2727, 2021, '2727', '2021-04-06', NULL, NULL, 'Conception Point Technique', 3, 14, 1494, NULL, 2360, 598, 1),
(2732, 2021, '2732', '2021-04-06', NULL, NULL, 'Réalisation SIOREC', 3, 14, 1511, NULL, 2374, 598, 2),
(2735, 2021, '2735', '2021-04-07', NULL, NULL, 'Conception des boîtes', 3, 14, 1496, NULL, 2360, 598, 1),
(2737, 2021, '2737', '2021-04-07', NULL, NULL, 'Réalisation SIOREC', 3, 14, 1511, NULL, 2374, 598, 2),
(2739, 2021, '2739', '2021-04-08', NULL, NULL, 'Conception des adductions', 3, 14, 1566, NULL, 2360, 598, 1),
(2741, 2021, '2741', '2021-04-08', NULL, NULL, 'Conception des câbles', 3, 14, 1497, NULL, 2360, 598, 2),
(2745, 2021, '2745', '2021-04-09', NULL, NULL, 'Conception des câbles', 3, 14, 1497, NULL, 2360, 598, 1),
(2746, 2021, '2746', '2021-04-09', NULL, NULL, 'Réalisation SIOREC', 3, 14, 1511, NULL, 2374, 598, 2),
(2747, 2021, '2747', '2021-04-12', NULL, NULL, 'Réalisation SIOREC', 3, 15, 1511, NULL, 2374, 598, 1),
(2749, 2021, '2749', '2021-04-12', NULL, NULL, 'Réalisation SIOREC', 3, 15, 1511, NULL, 2374, 598, 2),
(2751, 2021, '2751', '2021-04-13', NULL, NULL, 'Réalisation SIOREC', 3, 15, 1511, NULL, 2374, 598, 1),
(2752, 2021, '2752', '2021-04-13', NULL, NULL, 'Réalisation SIOREC', 3, 15, 1511, NULL, 2374, 598, 2),
(2755, 2021, '2755', '2021-04-14', NULL, NULL, 'Conception Point Technique', 3, 15, 1494, NULL, 2381, 598, 1),
(2756, 2021, '2756', '2021-04-14', NULL, NULL, 'Conception Point Technique', 3, 15, 1494, NULL, 2381, 598, 2),
(2759, 2021, '2759', '2021-04-23', NULL, NULL, 'Conception des boîtes', 3, 16, 1496, NULL, 2420, 599, 2),
(2761, 2021, '2761', '2021-04-26', '2021-04-26 00:00:00', NULL, 'Conception des adductions', 3, 17, 954, 62, 2420, 599, 1),
(2762, 2021, '2762', '2021-04-26', NULL, NULL, 'Conception des adductions', 3, 17, 1566, NULL, 2420, 599, 2),
(2763, 2021, '2763', '2021-04-27', '2021-04-27 00:00:00', NULL, 'Conception des câbles', 3, 17, 1497, 653, 2420, 599, 1),
(2764, 2021, '2764', '2021-04-27', NULL, NULL, 'Conception des câbles', 3, 17, 1497, NULL, 2420, 599, 2),
(2765, 2021, '2765', '2021-04-28', '2021-04-28 00:00:00', NULL, 'Conception des câbles', 3, 17, 1497, 62, 2420, 599, 2),
(2766, 2021, '2766', '2021-04-15', NULL, NULL, 'Conception des câbles', 3, 15, 1575, NULL, 2369, 598, 1),
(2767, 2021, '2767', '2021-04-28', NULL, NULL, 'Conception des câbles', 3, 17, 1497, NULL, 2420, 599, 2),
(2768, 2021, '2768', '2021-04-15', NULL, NULL, 'Conception des câbles', 3, 15, 1575, NULL, 2369, 598, 2),
(2769, 2021, '2769', '2021-04-29', NULL, NULL, 'Contrôle SIO Niv 2', 3, 17, 1498, NULL, 2420, 599, 1),
(2770, 2021, '2770', '2021-04-16', NULL, NULL, 'Conception des câbles', 3, 15, 1575, NULL, 2363, 598, 1),
(2771, 2021, '2771', '2021-04-29', NULL, '', 'Contrôle SIO Niv 2', 3, 16, 1498, NULL, 2420, 599, 2),
(2772, 2021, '2772', '2021-04-16', NULL, NULL, 'Conception des câbles', 3, 15, 1575, NULL, 2363, 598, 2),
(2773, 2021, '2773', '2021-04-30', NULL, NULL, 'Contrôle SIO Niv 2', 3, 17, 1498, NULL, 2420, 599, 1),
(2774, 2021, '2774', '2021-04-30', NULL, NULL, 'Contrôle SIO Niv 2', 3, 17, 1498, NULL, 2420, 599, 2),
(2775, 2021, '2775', '2021-04-19', NULL, NULL, 'Conception des Supports', 3, 16, 1495, NULL, 2381, 598, 1),
(2776, 2021, '2776', '2021-04-19', NULL, NULL, 'Conception des câbles', 3, 16, 1497, NULL, 2360, 598, 2),
(2778, 2021, '2778', '2021-04-20', NULL, NULL, 'Conception des Supports', 3, 16, 1495, NULL, 2381, 598, 2),
(2779, 2021, '2779', '2021-04-20', NULL, NULL, 'Conception des boîtes', 3, 16, 1574, NULL, 2377, 598, 1),
(2786, 2021, '2786', '2021-04-21', NULL, NULL, 'Réalisation SIOREC', 3, 16, 1490, NULL, 2377, 598, 1),
(2788, 2021, '2788', '2021-04-23', NULL, NULL, 'Réalisation SIOREC', 3, 16, 1490, NULL, 2377, 598, 2),
(2792, 2021, '2792', '2021-04-22', NULL, NULL, 'Vérification', 3, 16, 1512, NULL, 2374, 598, 1),
(2794, 2021, '2794', '2021-04-22', NULL, NULL, 'Contrôle SIO Niv 2', 3, 16, 1498, NULL, 2360, 598, 2),
(2799, 2021, '2799', '2021-04-26', NULL, '', 'Reprise', 3, 17, 1513, NULL, 2374, 598, 1),
(2800, 2021, '2800', '2021-04-26', NULL, NULL, 'Reprise', 3, 17, 1513, NULL, 2374, 598, 1),
(2810, 2021, '2810', '2021-04-28', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2375, 598, 1),
(2804, 2021, '2804', '2021-04-27', NULL, NULL, 'Reprise', 3, 17, 1513, NULL, 2374, 598, 1),
(2805, 2021, '2805', '2021-04-27', NULL, NULL, 'Reprise', 3, 17, 1513, NULL, 2374, 598, 2),
(2815, 2021, '2815', '2021-04-30', NULL, NULL, 'Vérification des Retour Terrain', 3, 17, 1509, NULL, 2377, 598, 1),
(2816, 2021, '2816', '2021-04-30', NULL, NULL, 'Vérification des Retour Terrain', 3, 17, 1509, NULL, 2377, 598, 2),
(2811, 2021, '2811', '2021-04-28', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2375, 598, 2),
(2813, 2021, '2813', '2021-04-29', NULL, NULL, 'Vérification des Retour Terrain', 3, 17, 1509, NULL, 2376, 598, 1),
(2814, 2021, '2814', '2021-04-29', NULL, NULL, 'Vérification des Retour Terrain', 3, 17, 1509, NULL, 2376, 598, 2),
(2838, 2021, '2838', '2021-04-06', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1543, NULL, 2359, 582, 1),
(2839, 2021, '2839', '2021-04-06', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1543, NULL, 2357, 582, 2),
(3146, 2021, '3146', '2021-04-26', NULL, NULL, 'Réalisation shp', 3, 17, 1453, NULL, 2522, 588, 1),
(2843, 2021, '2843', '2021-04-07', NULL, NULL, 'Réunion', 3, 14, 1545, NULL, 2279, 582, 1),
(2845, 2021, '2845', '2021-04-07', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1542, NULL, 2327, 582, 2),
(2847, 2021, '2847', '2021-04-01', NULL, NULL, 'Calcul CAPFT', 3, 13, 1552, NULL, 2475, 569, 1),
(2848, 2021, '2848', '2021-04-01', NULL, NULL, 'Calcul CAPFT', 3, 13, 1552, NULL, 2475, 569, 2),
(2849, 2021, '2849', '2021-04-23', NULL, NULL, 'Extraction des immeubles du SID', 3, 16, 1539, NULL, 2374, 582, 1),
(2850, 2021, '2850', '2021-04-23', NULL, NULL, 'Extraction des immeubles du SID', 3, 16, 1539, NULL, 2370, 582, 2),
(2852, 2021, '2852', '2021-04-12', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2430, 569, 1),
(2853, 2021, '2853', '2021-04-12', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2430, 569, 2),
(2857, 2021, '2857', '2021-04-09', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1543, NULL, 2354, 582, 1),
(2863, 2021, '2863', '2021-04-09', NULL, NULL, 'Création et Réalisation du dossier', 3, 14, 1542, NULL, 2326, 582, 2),
(2865, 2021, '2865', '2021-04-12', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1542, NULL, 2326, 582, 1),
(2866, 2021, '2866', '2021-04-12', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1542, NULL, 2326, 582, 2),
(2867, 2021, '2867', '2021-04-23', NULL, NULL, 'PDS', 3, 16, 1515, NULL, 2367, 569, 2),
(2870, 2021, '2870', '2021-04-13', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1542, NULL, 2328, 582, 1),
(2873, 2021, '2873', '2021-04-13', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1542, NULL, 2328, 582, 2),
(2884, 2021, '2884', '2021-04-16', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1543, NULL, 2339, 582, 1),
(2885, 2021, '2885', '2021-04-22', NULL, NULL, 'Dépose', 3, 16, 1534, NULL, 2258, 589, 1),
(2886, 2021, '2886', '2021-04-16', NULL, NULL, 'Création et Réalisation du dossier', 3, 15, 1543, NULL, 2340, 582, 2),
(2894, 2021, '2894', '2021-04-19', NULL, NULL, 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2329, 582, 1),
(3178, 2021, '3178', '2021-04-16', NULL, NULL, 'Contôle et dépose', 3, 15, 1455, NULL, 2496, 589, 3),
(2896, 2021, '2896', '2021-04-19', NULL, NULL, 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2329, 582, 2),
(2901, 2021, '2901', '2021-04-20', NULL, NULL, 'Création et Réalisation du dossier', 3, 16, 1542, NULL, 2329, 582, 1),
(2904, 2021, '2904', '2021-04-01', NULL, NULL, 'Réalisation PA', 3, 13, 1432, NULL, 2255, 588, 1),
(2905, 2021, '2905', '2021-04-23', NULL, NULL, 'Vérification +dépose', 3, 16, 1443, NULL, 2521, 589, 2),
(2907, 2021, '2907', '2021-04-20', NULL, '', 'Contrôl Retour Terrain', 3, 16, 1537, NULL, 2343, 582, 1),
(2910, 2021, '2910', '2021-04-21', NULL, NULL, 'Réalisation shapes', 3, 16, 1469, NULL, 2258, 589, 2),
(2915, 2021, '2915', '2021-04-21', NULL, NULL, 'Vérification +dépose', 3, 16, 1443, NULL, 2423, 589, 1),
(2922, 2021, '2922', '2021-04-01', NULL, NULL, 'Préparation des SHAPES', 3, 13, 1546, NULL, 2253, 588, 1),
(2925, 2021, '2925', '2021-04-22', NULL, '', 'Avancement', 3, 16, 1540, NULL, 2343, 582, 1),
(2926, 2021, '2926', '2021-04-20', NULL, NULL, 'C3A', 3, 16, 1442, NULL, 2439, 589, 1),
(2935, 2021, '2935', '2021-04-01', NULL, NULL, 'Préparation des SHAPES', 3, 13, 1546, NULL, 2288, 588, 2),
(2939, 2021, '2939', '2021-04-20', NULL, NULL, 'Vérification +Depose', 3, 16, 1581, NULL, 2465, 589, 1),
(2941, 2021, '2941', '2021-04-02', NULL, NULL, 'Réalisation', 3, 13, 1457, NULL, 2273, 588, 1),
(2944, 2021, '2944', '2021-04-23', NULL, NULL, 'Réalisation ', 3, 16, 1580, NULL, 2459, 588, 2),
(2947, 2021, '2947', '2021-04-22', NULL, NULL, 'Réalisation de fichier FAC', 3, 16, 1582, NULL, 2374, 582, 1),
(2962, 2021, '2962', '2021-04-15', NULL, NULL, 'Réalisation shp', 3, 15, 1453, NULL, 2495, NULL, 1),
(2951, 2021, '2951', '2021-04-05', NULL, '', 'Reprise', 3, 13, 1430, NULL, 2521, 588, 2),
(2956, 2021, '2956', '2021-04-19', NULL, NULL, 'Vérification +Depose', 3, 16, 1581, NULL, 2430, 589, 1),
(2957, 2021, '2957', '2021-04-26', NULL, NULL, 'Création et Réalisation du dossier', 3, 17, 1542, NULL, 2325, 582, 1),
(2960, 2021, '2960', '2021-04-26', NULL, NULL, 'Création et Réalisation du dossier', 3, 17, 1542, NULL, 2325, 582, 2),
(2961, 2021, '2961', '2021-04-05', NULL, NULL, 'Réalisation ', 3, 14, 1580, NULL, 2314, 588, 1),
(2964, 2021, '2964', '2021-04-15', NULL, NULL, 'Réalisation shp', 3, 15, 1453, NULL, 2428, NULL, 2),
(2966, 2021, '2966', '2021-04-16', NULL, NULL, 'Réalisation shp', 3, 15, 1453, NULL, 2424, NULL, 1),
(2967, 2021, '2967', '2021-04-27', NULL, NULL, 'Réalisation de dossier', 3, 17, 1538, NULL, 2349, 582, 1),
(2968, 2021, '2968', '2021-04-19', NULL, NULL, 'Réalisation Synoptique', 3, 16, 1466, NULL, 2487, NULL, 2),
(2969, 2021, '2969', '2021-04-06', NULL, NULL, 'Réalisation ', 3, 14, 1580, NULL, 2259, 588, 1),
(2970, 2021, '2970', '2021-04-16', NULL, NULL, 'Réalisation C3A si simple', 3, 15, 1452, NULL, 2424, NULL, 2),
(2971, 2021, '2971', '2021-04-06', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2273, 588, 1),
(2972, 2021, '2972', '2021-04-14', NULL, NULL, 'Réalisation DOE', 3, 15, 1467, NULL, 2258, NULL, 1),
(2973, 2021, '2973', '2021-04-11', NULL, NULL, 'Réalisationn Plan de boîte', 3, 14, 1468, NULL, 2263, NULL, 1),
(2974, 2021, '2974', '2021-04-06', NULL, NULL, 'Réalisation PA', 3, 14, 1432, NULL, 2461, 588, 2),
(2975, 2021, '2975', '2021-04-27', NULL, '', 'Réalisation de dossier', 3, 16, 1538, NULL, 2349, 582, 2),
(2976, 2021, '2976', '2021-04-07', NULL, NULL, 'Intégration point technique', 3, 14, 1424, NULL, 2254, 588, 1),
(2977, 2021, '2977', '2021-04-07', NULL, NULL, 'Intégration Support', 3, 14, 1425, NULL, 2254, 588, 1),
(2978, 2021, '2978', '2021-04-28', NULL, NULL, 'Contrôl Retour Terrain', 3, 17, 1537, NULL, 2328, 582, 1),
(2979, 2021, '2979', '2021-04-23', NULL, NULL, 'Intégration boîtes optique', 3, 16, 1426, NULL, 2254, 588, 2),
(2980, 2021, '2980', '2021-04-28', NULL, '', 'Réalisation de dossier', 3, 16, 1538, NULL, 2328, 582, 1),
(2981, 2021, '2981', '2021-04-08', NULL, '', 'Intégration Support', 3, 14, 1546, NULL, 2254, 588, 1),
(2982, 2021, '2982', '2021-04-19', NULL, NULL, 'Vérification du PT +Dépôse', 3, 16, 1447, NULL, 2522, NULL, 1),
(2983, 2021, '2983', '2021-04-29', NULL, NULL, 'Contrôl Retour Terrain', 3, 17, 1537, NULL, 2335, 582, 1),
(2984, 2021, '2984', '2021-04-19', NULL, NULL, 'Réalisation du PT', 3, 16, 1446, NULL, 2522, NULL, 1),
(2987, 2021, '2987', '2021-04-08', NULL, NULL, 'Préparation des SHAPES', 3, 14, 1546, NULL, 2254, 588, 2),
(2989, 2021, '2989', '2021-04-02', NULL, NULL, 'Réalisation FOA', 3, 13, 1454, NULL, 2465, NULL, 1),
(2990, 2021, '2990', '2021-04-08', NULL, NULL, 'Réalisation PP', 3, 14, 1436, NULL, 2428, 588, 2),
(2991, 2021, '2991', '2021-04-29', NULL, '', 'Contrôl Retour Terrain', 3, 16, 1537, NULL, 2326, 582, 2),
(2992, 2021, '2992', '2021-04-30', NULL, '', 'Avancement', 3, 16, 1540, NULL, 2332, 582, 1),
(2994, 2021, '2994', '2021-04-09', NULL, NULL, 'Réalisation PA', 3, 14, 1432, NULL, 2428, 588, 1),
(2995, 2021, '2995', '2021-04-23', NULL, NULL, 'Réalisation PA', 3, 16, 1432, NULL, 2428, 588, 1),
(2996, 2021, '2996', '2021-04-12', NULL, NULL, 'Réalisation PA', 3, 15, 1432, NULL, 2316, 588, 1),
(2999, 2021, '2999', '2021-04-30', NULL, NULL, 'Avancement', 3, 17, 1540, NULL, 2342, 582, 2),
(3000, 2021, '3000', '2021-04-02', NULL, NULL, 'Contrôle SIO Niv 2', 3, 13, 1498, NULL, 2391, 601, 2),
(3001, 2021, '3001', '2021-04-13', NULL, '', 'Realisation PA', 3, 16, 1431, NULL, 2286, 588, 1),
(3002, 2021, '3002', '2021-04-05', NULL, NULL, 'Contrôle SIO Niv2', 3, 14, 1507, NULL, 2246, 601, 1),
(3003, 2021, '3003', '2021-04-13', NULL, NULL, 'Réalisation PP', 3, 15, 1436, NULL, 2286, 588, 2),
(3011, 2021, '3011', '2021-04-15', NULL, NULL, 'Réalisation PA', 3, 15, 1432, NULL, 2272, 588, 1),
(3006, 2021, '3006', '2021-04-14', NULL, '', 'Reprise du PA', 3, 16, 1434, NULL, 2256, 588, 1),
(3008, 2021, '3008', '2021-04-14', NULL, NULL, 'Réalisation PP', 3, 15, 1436, NULL, 2256, 588, 2),
(3014, 2021, '3014', '2021-04-05', NULL, NULL, 'Contrôle SIO Niv 2', 3, 14, 1498, NULL, 2189, 601, 2),
(3015, 2021, '3015', '2021-04-15', NULL, NULL, 'Reprise du PA', 3, 15, 1434, NULL, 2291, 588, 2),
(3016, 2021, '3016', '2021-04-06', NULL, NULL, 'Contrôle SIO Niv2', 3, 14, 1507, NULL, 2401, 601, 1),
(3017, 2021, '3017', '2021-04-06', NULL, NULL, 'APD GC + Poteaux', 3, 14, 1416, NULL, 2404, 601, 2),
(3022, 2021, '3022', '2021-04-07', NULL, NULL, 'Vérification', 3, 14, 1512, NULL, 2407, 601, 1),
(3024, 2021, '3024', '2021-04-07', NULL, NULL, 'Vérification', 3, 14, 1512, NULL, 2412, 601, 2),
(3026, 2021, '3026', '2021-04-01', NULL, NULL, 'Réalisation C3A si simple', 3, 13, 1452, NULL, 2257, 589, 1),
(3031, 2021, '3031', '2021-04-08', NULL, NULL, 'Vérification', 3, 14, 1512, NULL, 2402, 601, 2),
(3032, 2021, '3032', '2021-04-05', NULL, NULL, 'Vérification +Depose', 3, 14, 1581, NULL, 2314, 589, 3),
(3034, 2021, '3034', '2021-04-09', NULL, NULL, 'Vérification', 3, 14, 1512, NULL, 2246, 601, 1),
(3037, 2021, '3037', '2021-04-19', NULL, NULL, 'Réalisation ', 3, 16, 1580, NULL, 2465, 588, 1),
(3039, 2021, '3039', '2021-04-09', NULL, NULL, 'APD GC + Poteaux', 3, 14, 1416, NULL, 2404, 601, 2),
(3040, 2021, '3040', '2021-04-12', NULL, NULL, 'Contrôle SIO Niv2', 3, 15, 1507, NULL, 2402, 601, 1),
(3044, 2021, '3044', '2021-04-12', NULL, NULL, 'Contrôle SIO Niv 2', 3, 15, 1498, NULL, 2415, 601, 2),
(3051, 2021, '3051', '2021-04-21', NULL, NULL, 'Réalisation ', 3, 16, 1580, NULL, 2443, 588, 1),
(3047, 2021, '3047', '2021-04-20', NULL, NULL, 'Reprise', 3, 16, 1430, NULL, 2254, 588, 1),
(3048, 2021, '3048', '2021-04-20', NULL, NULL, 'Reprise', 3, 16, 1430, NULL, 2254, 588, 1),
(3049, 2021, '3049', '2021-04-13', NULL, NULL, 'Vérification', 3, 15, 1512, NULL, 2402, 601, 1),
(3052, 2021, '3052', '2021-04-13', NULL, NULL, 'Vérification', 3, 15, 1512, NULL, 2246, 601, 2),
(3056, 2021, '3056', '2021-04-14', NULL, NULL, 'Contrôle SIO Niv2', 3, 15, 1507, NULL, 2402, 601, 1),
(3058, 2021, '3058', '2021-04-21', NULL, NULL, 'Réalisation ', 3, 16, 1580, NULL, 2430, 588, 1),
(3061, 2021, '3061', '2021-04-14', NULL, NULL, 'Vérification des Retour Terrain', 3, 15, 1509, NULL, 2344, 601, 2),
(3062, 2021, '3062', '2021-04-07', NULL, NULL, 'Vérification du PA +dépose', 3, 14, 1433, NULL, 2220, 589, 1),
(3063, 2021, '3063', '2021-04-15', NULL, NULL, 'APD GC + Poteaux', 3, 15, 1416, NULL, 2390, 601, 1),
(3066, 2021, '3066', '2021-04-16', NULL, NULL, 'APD GC + Poteaux', 3, 15, 1416, NULL, 2411, 601, 1),
(3067, 2021, '3067', '2021-04-08', NULL, NULL, 'Vérification du PA +dépose', 3, 14, 1433, NULL, 2275, 589, 1),
(3068, 2021, '3068', '2021-04-16', NULL, NULL, 'APD GC + Poteaux', 3, 15, 1416, NULL, 2411, 601, 2),
(3071, 2021, '3071', '2021-04-19', NULL, '', 'Vérification', 3, 16, 1472, NULL, 2527, 588, 2),
(3073, 2021, '3073', '2021-04-07', NULL, NULL, 'Vérification +dépose', 3, 14, 1458, NULL, 2273, 589, 1),
(3074, 2021, '3074', '2021-04-19', NULL, NULL, 'Contrôle SIO Niv 2', 3, 16, 1498, NULL, 2393, 601, 2),
(3075, 2021, '3075', '2021-04-16', NULL, NULL, 'Reprise', 3, 15, 1430, NULL, 2531, 588, 2),
(3076, 2021, '3076', '2021-04-20', NULL, NULL, 'APD GC + Poteaux', 3, 16, 1416, NULL, 2390, 601, 1),
(3077, 2021, '3077', '2021-04-20', NULL, NULL, 'APD GC + Poteaux', 3, 16, 1416, NULL, 2392, 601, 2),
(3078, 2021, '3078', '2021-04-01', NULL, NULL, 'Vérification +dépose', 3, 13, 1443, NULL, 2475, 589, 3),
(3079, 2021, '3079', '2021-04-21', NULL, NULL, 'Dépose', 3, 16, 1535, NULL, 2407, 601, 1),
(3150, 2021, '3150', '2021-04-27', NULL, NULL, 'Réalisation du PT', 3, 17, 1446, NULL, 2425, 588, 1),
(3081, 2021, '3081', '2021-04-21', NULL, NULL, 'Dépose', 3, 16, 1535, NULL, 2412, 601, 2),
(3082, 2021, '3082', '2021-04-22', NULL, NULL, 'Réalisation ', 3, 16, 1580, NULL, 2269, 588, 1),
(3084, 2021, '3084', '2021-04-22', NULL, NULL, 'Réunion', 3, 16, 1545, NULL, 2393, 601, 1),
(3085, 2021, '3085', '2021-04-22', NULL, NULL, 'Reprise', 3, 16, 1499, NULL, 2393, 601, 2),
(3086, 2021, '3086', '2021-04-06', NULL, NULL, 'Vérification', 3, 14, 1471, NULL, 2254, 589, 1),
(3087, 2021, '3087', '2021-04-23', NULL, NULL, 'Reprise', 3, 16, 1499, NULL, 2393, 601, 1),
(3088, 2021, '3088', '2021-04-23', NULL, NULL, 'Reprise', 3, 16, 1499, NULL, 2393, 601, 2),
(3090, 2021, '3090', '2021-04-06', NULL, NULL, 'Vérification du PA +dépose', 3, 14, 1433, NULL, 2534, 589, 1),
(3091, 2021, '3091', '2021-04-26', NULL, NULL, 'Reprise', 3, 17, 1499, NULL, 2393, 601, 1),
(3092, 2021, '3092', '2021-04-26', NULL, NULL, 'Contrôle SIO Niv 2', 3, 17, 1498, NULL, 2393, 601, 2),
(3093, 2021, '3093', '2021-04-27', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2402, 601, 1),
(3094, 2021, '3094', '2021-04-27', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2402, 601, 2),
(3095, 2021, '3095', '2021-04-05', NULL, NULL, 'Vérification +dépose', 3, 14, 1458, NULL, 2273, 589, 1),
(3096, 2021, '3096', '2021-04-28', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2246, 601, 1),
(3097, 2021, '3097', '2021-04-28', NULL, NULL, 'Préparation des données d\'entrée', 3, 17, 916, NULL, 2246, 601, 2),
(3098, 2021, '3098', '2021-04-29', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2347, 601, 1),
(3099, 2021, '3099', '2021-04-29', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2347, 601, 2),
(3100, 2021, '3100', '2021-04-30', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2343, 601, 1),
(3101, 2021, '3101', '2021-04-30', NULL, NULL, 'Vérification', 3, 17, 1512, NULL, 2343, 601, 2),
(3102, 2021, '3102', '2021-04-15', NULL, NULL, 'APD GC + Poteaux', 3, 15, 1416, NULL, 2390, 601, 2),
(3103, 2021, '3103', '2021-04-08', NULL, NULL, 'Vérification des Prérequis', 3, 14, 1456, NULL, 2535, 589, 3),
(3108, 2021, '3108', '2021-04-13', NULL, NULL, 'Vérification des Prérequis', 3, 15, 1456, NULL, 2536, 589, 1),
(3105, 2021, '3105', '2021-04-12', NULL, NULL, 'Vérification(Photo FOA +PIT+C3B si complexe)', 3, 15, 1451, NULL, 2538, 589, 1),
(3106, 2021, '3106', '2021-04-12', NULL, NULL, 'Vérification des DE', 3, 15, 1431, NULL, 2537, 589, 2),
(3110, 2021, '3110', '2021-04-13', NULL, NULL, 'Vérification du PA +dépose', 3, 15, 1433, NULL, 2532, 589, 3),
(3113, 2021, '3113', '2021-04-14', NULL, NULL, 'Vérification +dépose', 3, 15, 1458, NULL, 2536, 589, 3),
(3114, 2021, '3114', '2021-04-14', NULL, NULL, 'Contôle et dépose', 3, 15, 1455, NULL, 2260, 589, 1),
(3185, 2021, '3185', '2021-04-29', NULL, NULL, 'Réalisation shp', 3, 17, 1453, NULL, 2539, 589, 3),
(3116, 2021, '3116', '2021-04-23', NULL, NULL, 'Vérification +dépose', 3, 16, 1443, NULL, 2539, 589, 1),
(3184, 2021, '3184', '2021-04-29', NULL, NULL, 'Réalisation FOA', 3, 17, 1454, NULL, 2260, 589, 1),
(3118, 2021, '3118', '2021-04-15', NULL, NULL, 'Vérification des DE', 3, 15, 1465, NULL, 2459, 589, 1),
(3183, 2021, '3183', '2021-04-28', NULL, NULL, 'Réalisation Synoptique', 3, 17, 1466, NULL, 2459, 589, 3),
(3129, 2021, '3129', '2021-04-21', NULL, NULL, 'Réalisation SIOREC', 3, 16, 1490, NULL, 2377, 598, 2),
(3163, 2021, '3163', '2021-04-29', NULL, NULL, 'Reprise', 3, 17, 1430, NULL, 2268, 588, 2),
(3168, 2021, '3168', '2021-04-30', NULL, NULL, 'Reprise', 3, 17, 1430, NULL, 2520, 588, 1),
(3169, 2021, '3169', '2021-04-15', NULL, NULL, 'Reprise', 3, 15, 1444, NULL, 2539, 589, 1),
(3170, 2021, '3170', '2021-04-30', NULL, NULL, 'Reprise', 3, 17, 1430, NULL, 2520, 588, 2),
(3179, 2021, '3179', '2021-04-19', NULL, NULL, 'Vérification du PT +Dépôse', 3, 16, 1447, NULL, 2522, 589, 1),
(3180, 2021, '3180', '2021-04-27', NULL, NULL, 'Vérification', 3, 17, 1471, NULL, 2533, 589, 1),
(3181, 2021, '3181', '2021-04-27', NULL, NULL, 'Vérification', 3, 17, 1471, NULL, 2527, 589, 3),
(3182, 2021, '3182', '2021-04-28', NULL, NULL, 'Vérification +dépose', 3, 17, 1443, NULL, 2441, 589, 1),
(3186, 2021, '3186', '2021-04-30', NULL, NULL, 'Vérification +dépose', 3, 17, 1443, NULL, 2482, 589, 1),
(3187, 2021, '3187', '2021-04-01', '2021-04-01 00:00:00', '', 'Reprise', 3, 16, 1523, NULL, 2332, 593, 1),
(3188, 2021, '3188', '2021-04-01', NULL, NULL, 'Reprise', 3, 13, 1523, NULL, 2332, 593, 2),
(3189, 2021, '3189', '2021-04-02', NULL, NULL, 'Reprise', 3, 13, 1523, NULL, 2343, 593, 1),
(3190, 2021, '3190', '2021-04-02', NULL, NULL, 'Reprise', 3, 13, 1523, NULL, 2343, 593, 2),
(3191, 2021, '3191', '2021-04-05', NULL, NULL, 'Reprise', 3, 14, 1523, NULL, 2334, 593, 1),
(3192, 2021, '3192', '2021-04-05', NULL, NULL, 'Reprise', 3, 14, 1523, NULL, 2334, 593, 2),
(3193, 2021, '3193', '2021-04-06', NULL, NULL, 'Reprise', 3, 14, 1523, NULL, 2334, 593, 1),
(3194, 2021, '3194', '2021-04-06', NULL, NULL, 'Contrôle', 3, 14, 1522, NULL, 2370, 593, 2),
(3195, 2021, '3195', '2021-04-07', NULL, NULL, 'Contrôle', 3, 14, 1522, NULL, 2370, 593, 1),
(3196, 2021, '3196', '2021-04-07', NULL, NULL, 'PDS', 3, 14, 1515, NULL, 2338, 593, 2),
(3197, 2021, '3197', '2021-04-08', NULL, NULL, 'PDS', 3, 14, 1515, NULL, 2338, 593, 1),
(3198, 2021, '3198', '2021-04-08', NULL, NULL, 'Contrôle', 3, 14, 1522, NULL, 2369, 593, 2),
(3199, 2021, '3199', '2021-04-09', NULL, NULL, 'Reprise', 3, 14, 1523, NULL, 2348, 593, 1),
(3200, 2021, '3200', '2021-04-09', NULL, '', 'Reprise Epp', 3, 14, 1524, NULL, 2246, 593, 1),
(3201, 2021, '3201', '2021-04-12', NULL, '', 'reprise PDS', 3, 15, 1515, NULL, 2374, 593, 1),
(3202, 2021, '3202', '2021-04-12', NULL, '', 'Reprise PDS', 3, 15, 1523, NULL, 2374, 593, 2),
(3203, 2021, '3203', '2021-04-13', NULL, '', 'REPRISE Epp', 3, 15, 1524, NULL, 2246, 593, 1),
(3204, 2021, '3204', '2021-04-13', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2371, 593, 2),
(3205, 2021, '3205', '2021-04-14', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2371, 593, 1),
(3206, 2021, '3206', '2021-04-14', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2371, 593, 2),
(3207, 2021, '3207', '2021-04-15', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2372, 593, 1),
(3208, 2021, '3208', '2021-04-15', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2372, 593, 2),
(3209, 2021, '3209', '2021-04-16', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2363, 593, 1),
(3210, 2021, '3210', '2021-04-16', NULL, '', 'Contrôle classeur', 3, 15, 1522, NULL, 2363, 593, 2),
(3211, 2021, '3211', '2021-04-22', NULL, '', 'Contrôle classeur', 3, 16, 1522, NULL, 2365, 593, 1),
(3212, 2021, '3212', '2021-04-22', NULL, '', 'Contrôle classeur', 3, 16, 1522, NULL, 2365, 593, 2),
(3213, 2021, '3213', '2021-04-23', NULL, NULL, 'Reprise', 3, 16, 1523, NULL, 2347, 593, 1),
(3214, 2021, '3214', '2021-04-23', NULL, '', 'Reprise Epp', 3, 16, 1524, NULL, 2407, 593, 2),
(3217, 2021, '3217', '2021-04-16', NULL, NULL, 'Réunion', 3, 15, 1545, NULL, 2902, 589, 1),
(3218, 2021, '3218', '2021-04-30', NULL, NULL, 'Réunion', 3, 17, 1545, NULL, 2902, 589, 1),
(3225, 2021, '3225', '2021-04-19', NULL, NULL, 'Contrôle', 3, 16, 1522, NULL, 2363, 593, 1),
(3227, 2021, '3227', '2021-04-19', NULL, NULL, 'Contrôle', 3, 16, 1522, NULL, 2363, 593, 2),
(3228, 2021, '3228', '2021-04-26', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2412, 593, 1),
(3229, 2021, '3229', '2021-04-26', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2412, 593, 1),
(3230, 2021, '3230', '2021-04-27', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2407, 593, 1),
(3231, 2021, '3231', '2021-04-27', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2407, 593, 2),
(3234, 2021, '3234', '2021-04-28', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2246, 593, 1),
(3235, 2021, '3235', '2021-04-28', NULL, '', 'Reprise Epp', 3, 17, 1524, NULL, 2246, 593, 2),
(3875, 2021, '3875', '2021-04-26', NULL, NULL, 'Réalisation', 3, 17, 1457, NULL, 2348, 575, 2),
(3252, 2021, '3252', '2021-04-27', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2373, 576, 1),
(3253, 2021, '3253', '2021-04-27', NULL, '', 'Calcul COMAC', 3, 17, 961, NULL, 2373, 576, 2),
(3254, 2021, '3254', '2021-04-01', NULL, NULL, 'Contrôle', 3, 13, 1548, NULL, 2361, 574, 1),
(3255, 2021, '3255', '2021-04-01', NULL, NULL, 'Contrôle', 3, 13, 1548, NULL, 2361, 574, 2),
(3256, 2021, '3256', '2021-04-02', NULL, NULL, 'Contrôle', 3, 13, 1548, NULL, 2361, 574, 1),
(3257, 2021, '3257', '2021-04-02', NULL, NULL, 'Contrôle', 3, 13, 1548, NULL, 2361, 574, 2),
(3498, 2021, '3498', '2021-04-27', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, 578, 1),
(3260, 2021, '3260', '2021-04-01', NULL, '', 'Contrôle', 3, 13, 1548, NULL, 2361, 577, 1),
(3261, 2021, '3261', '2021-04-01', NULL, '', 'Contrôle', 3, 13, 1548, NULL, 2361, 577, 2),
(3424, 2021, '3424', '2021-04-15', NULL, NULL, 'E-plan', 3, 15, 1583, NULL, 2372, 574, 1),
(3577, 2021, '3577', '2021-04-26', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, NULL, 1),
(3264, 2021, '3264', '2021-04-05', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2361, 577, 1),
(3265, 2021, '3265', '2021-04-05', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2361, 577, 2),
(3266, 2021, '3266', '2021-04-06', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2361, 577, 1),
(3267, 2021, '3267', '2021-04-06', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2361, 577, 2),
(3268, 2021, '3268', '2021-04-07', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 1),
(3269, 2021, '3269', '2021-04-07', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 2),
(3270, 2021, '3270', '2021-04-08', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 1),
(3271, 2021, '3271', '2021-04-08', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 2),
(3272, 2021, '3272', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 1),
(3273, 2021, '3273', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 1),
(3274, 2021, '3274', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 577, 2),
(3275, 2021, '3275', '2021-04-05', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2361, 574, 2),
(3587, 2021, '3587', '2021-04-09', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2334, 572, 1),
(3278, 2021, '3278', '2021-04-06', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2361, 574, 1),
(3279, 2021, '3279', '2021-04-06', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2361, 574, 2),
(3590, 2021, '3590', '2021-04-01', NULL, NULL, 'Contrôle C3A', 3, 13, 1559, NULL, 2359, 567, 2),
(3281, 2021, '3281', '2021-04-12', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2346, 577, 1),
(3282, 2021, '3282', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 577, 2),
(3591, 2021, '3591', '2021-04-22', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, 578, 1),
(3284, 2021, '3284', '2021-04-13', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2346, 577, 1),
(3286, 2021, '3286', '2021-04-13', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 577, 2),
(3287, 2021, '3287', '2021-04-07', NULL, NULL, 'E-plan', 3, 14, 1583, NULL, 2361, 574, 1),
(3634, 2021, '3634', '2021-04-06', NULL, NULL, 'Calcul COMAC ', 3, 14, 960, NULL, 2401, 571, 2),
(3289, 2021, '3289', '2021-04-07', NULL, NULL, 'E-plan', 3, 14, 1583, NULL, 2361, 574, 2),
(3555, 2021, '3555', '2021-04-30', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2360, 576, 1),
(3291, 2021, '3291', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2370, 577, 1),
(3292, 2021, '3292', '2021-04-08', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2361, 574, 1),
(3552, 2021, '3552', '2021-04-21', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, NULL, 2),
(3294, 2021, '3294', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2370, 577, 2),
(3296, 2021, '3296', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2373, 577, 1),
(3297, 2021, '3297', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2346, 566, 1),
(3298, 2021, '3298', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2364, 577, 2),
(3299, 2021, '3299', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2346, 566, 2),
(3300, 2021, '3300', '2021-04-16', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2365, 577, 1),
(3306, 2021, '3306', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 577, 2),
(3303, 2021, '3303', '2021-04-05', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2361, 574, 1),
(3497, 2021, '3497', '2021-04-19', '2021-04-19 00:00:00', NULL, 'Plan Autocad', 3, 16, 961, NULL, 2415, 9, 2),
(3307, 2021, '3307', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 1),
(3308, 2021, '3308', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 2),
(3309, 2021, '3309', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 1),
(3310, 2021, '3310', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 2),
(3311, 2021, '3311', '2021-04-01', NULL, NULL, 'Réalisation des C3A', 3, 13, 1553, NULL, 2374, 573, 1),
(3312, 2021, '3312', '2021-04-21', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2372, 577, 1),
(3313, 2021, '3313', '2021-04-21', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2372, 577, 2),
(3314, 2021, '3314', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, NULL, 1),
(3318, 2021, '3318', '2021-04-01', NULL, NULL, 'Réalisation des C3A', 3, 13, 1553, NULL, 2375, 573, 2),
(3316, 2021, '3316', '2021-04-22', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 1),
(3317, 2021, '3317', '2021-04-22', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 577, 2),
(3319, 2021, '3319', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, NULL, 2),
(3320, 2021, '3320', '2021-04-23', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2360, 577, 1),
(3322, 2021, '3322', '2021-04-02', NULL, NULL, 'Réalisation des C3A', 3, 13, 1553, NULL, 2376, 573, 1),
(3323, 2021, '3323', '2021-04-02', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, NULL, 1),
(3325, 2021, '3325', '2021-04-23', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2360, 577, 2),
(3326, 2021, '3326', '2021-04-02', NULL, NULL, 'Réalisation des C3A', 3, 13, 1553, NULL, 2377, 573, 2),
(3633, 2021, '3633', '2021-04-23', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2361, 573, 1),
(3593, 2021, '3593', '2021-04-22', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, 578, 2),
(3584, 2021, '3584', '2021-04-27', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 2),
(3582, 2021, '3582', '2021-04-19', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2373, 573, 1),
(3333, 2021, '3333', '2021-04-08', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 574, 2),
(3583, 2021, '3583', '2021-04-19', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2373, 573, 2),
(3336, 2021, '3336', '2021-04-02', NULL, NULL, 'Plan Autocad', 3, 13, 961, NULL, 2345, NULL, 2),
(3338, 2021, '3338', '2021-04-05', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2345, NULL, 1),
(3339, 2021, '3339', '2021-04-01', NULL, NULL, 'Contrôle Etude', 3, 13, 1548, NULL, 2361, 576, 1),
(3340, 2021, '3340', '2021-04-05', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2345, NULL, 2),
(3344, 2021, '3344', '2021-04-02', NULL, NULL, 'Reprise Etude', 3, 13, 1547, NULL, 2392, 576, 1),
(3343, 2021, '3343', '2021-04-01', NULL, NULL, 'Contrôle Etude', 3, 13, 1548, NULL, 2361, 576, 2),
(3345, 2021, '3345', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 574, 1),
(3346, 2021, '3346', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 574, 2),
(3347, 2021, '3347', '2021-04-02', NULL, NULL, 'Reprise Etude', 3, 13, 1547, NULL, 2392, 576, 2),
(3349, 2021, '3349', '2021-04-05', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2392, 576, 1),
(3350, 2021, '3350', '2021-04-06', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2345, NULL, 1),
(3351, 2021, '3351', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2366, 577, 1),
(3352, 2021, '3352', '2021-04-05', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2392, 576, 2),
(3353, 2021, '3353', '2021-04-06', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2345, NULL, 2),
(3362, 2021, '3362', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2367, 577, 2),
(3355, 2021, '3355', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 578, 1),
(3356, 2021, '3356', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2366, 577, 2),
(3363, 2021, '3363', '2021-04-06', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 576, 2),
(3358, 2021, '3358', '2021-04-07', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 1),
(3359, 2021, '3359', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 578, 2),
(3360, 2021, '3360', '2021-04-06', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 576, 1),
(3361, 2021, '3361', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2367, 577, 1),
(3364, 2021, '3364', '2021-04-15', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 1),
(3366, 2021, '3366', '2021-04-07', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 576, 1),
(3367, 2021, '3367', '2021-04-15', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 2),
(3368, 2021, '3368', '2021-04-07', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 576, 2),
(3369, 2021, '3369', '2021-04-08', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 576, 1),
(3370, 2021, '3370', '2021-04-05', NULL, NULL, 'Dépôt', 3, 14, 1586, NULL, 2373, 573, 1),
(3371, 2021, '3371', '2021-04-07', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 2),
(3372, 2021, '3372', '2021-04-14', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 1),
(3373, 2021, '3373', '2021-04-05', NULL, NULL, 'Dépôt', 3, 14, 1586, NULL, 2366, 573, 2),
(3374, 2021, '3374', '2021-04-14', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 2),
(3375, 2021, '3375', '2021-04-08', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 1),
(3376, 2021, '3376', '2021-04-08', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 2),
(3377, 2021, '3377', '2021-04-08', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 576, 2),
(3378, 2021, '3378', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 574, 1),
(3379, 2021, '3379', '2021-04-13', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 1),
(3380, 2021, '3380', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 576, 1),
(3381, 2021, '3381', '2021-04-09', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 1),
(3382, 2021, '3382', '2021-04-13', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 2),
(3383, 2021, '3383', '2021-04-06', NULL, NULL, 'Dépôt', 3, 14, 1586, NULL, 2363, 573, 1),
(3384, 2021, '3384', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 574, 2),
(3385, 2021, '3385', '2021-04-13', NULL, NULL, 'E-plan', 3, 15, 1583, NULL, 2346, 574, 1),
(3388, 2021, '3388', '2021-04-09', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, NULL, 2),
(3387, 2021, '3387', '2021-04-06', NULL, NULL, 'Dépôt', 3, 14, 1586, NULL, 2370, 573, 2),
(3389, 2021, '3389', '2021-04-12', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 1),
(3390, 2021, '3390', '2021-04-12', NULL, NULL, 'APDGC Poteaux', 3, 15, 962, NULL, 2342, NULL, 1),
(3391, 2021, '3391', '2021-04-12', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, 578, 2),
(3392, 2021, '3392', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 576, 2),
(3393, 2021, '3393', '2021-04-07', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2371, 573, 1),
(3404, 2021, '3404', '2021-04-13', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2362, 576, 2),
(3395, 2021, '3395', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 576, 1),
(3396, 2021, '3396', '2021-04-07', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2371, 573, 2),
(3397, 2021, '3397', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 576, 2);
INSERT INTO `tache` (`id`, `annee`, `code`, `date_demarrage_effective`, `date_fin_effective`, `description`, `libelle`, `mois`, `semaine`, `categorie_tache`, `etat_tache`, `groupe_tache`, `membre_equipe`, `periode`) VALUES
(3407, 2021, '3407', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 1),
(3408, 2021, '3408', '2021-04-14', NULL, NULL, 'E-plan', 3, 15, 1583, NULL, 2363, 574, 1),
(3400, 2021, '3400', '2021-04-13', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2346, 576, 1),
(3401, 2021, '3401', '2021-04-08', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2364, 573, 1),
(3405, 2021, '3405', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2362, 576, 1),
(3403, 2021, '3403', '2021-04-08', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2364, 573, 2),
(3406, 2021, '3406', '2021-04-13', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2363, 574, 2),
(3409, 2021, '3409', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 2),
(3410, 2021, '3410', '2021-04-12', NULL, NULL, 'APDGC Poteaux', 3, 15, 962, NULL, 2346, NULL, 2),
(3411, 2021, '3411', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2370, 576, 2),
(3412, 2021, '3412', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 1),
(3413, 2021, '3413', '2021-04-01', NULL, NULL, 'Contrôle C3A', 3, 13, 1559, NULL, 2415, 568, 1),
(3414, 2021, '3414', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 2),
(3415, 2021, '3415', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2372, 574, 2),
(3416, 2021, '3416', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 1),
(3417, 2021, '3417', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2373, 576, 1),
(3579, 2021, '3579', '2021-04-27', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, NULL, 1),
(3419, 2021, '3419', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 577, 2),
(3420, 2021, '3420', '2021-04-13', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2338, NULL, 1),
(3422, 2021, '3422', '2021-04-13', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2338, NULL, 2),
(3426, 2021, '3426', '2021-04-15', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 574, 2),
(3619, 2021, '3619', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 1),
(3476, 2021, '3476', '2021-04-01', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2343, 572, 1),
(3429, 2021, '3429', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 574, 1),
(3477, 2021, '3477', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 576, 1),
(3431, 2021, '3431', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 574, 2),
(3432, 2021, '3432', '2021-04-01', NULL, NULL, 'Calcul CAPFT', 3, 13, 1552, NULL, 2346, 568, 2),
(3433, 2021, '3433', '2021-04-02', NULL, NULL, 'Calcul CAPFT', 3, 13, 1552, NULL, 2346, 568, 1),
(3434, 2021, '3434', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 574, 1),
(3479, 2021, '3479', '2021-04-01', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2348, 572, 2),
(3480, 2021, '3480', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 576, 2),
(3468, 2021, '3468', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, NULL, 1),
(3439, 2021, '3439', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 574, 2),
(3481, 2021, '3481', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2342, NULL, 1),
(3475, 2021, '3475', '2021-04-22', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2360, 574, 1),
(3442, 2021, '3442', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 574, 1),
(3443, 2021, '3443', '2021-04-14', NULL, NULL, 'APDGC Poteaux', 3, 15, 962, NULL, 2348, NULL, 1),
(3444, 2021, '3444', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2364, 576, 2),
(3560, 2021, '3560', '2021-04-07', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2331, 572, 2),
(3563, 2021, '3563', '2021-04-02', NULL, NULL, 'Calcul COMAC ', 3, 13, 960, NULL, 2390, 571, 1),
(3562, 2021, '3562', '2021-04-08', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2332, 572, 1),
(3448, 2021, '3448', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 574, 2),
(3564, 2021, '3564', '2021-04-08', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2332, 572, 2),
(3454, 2021, '3454', '2021-04-09', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2365, 573, 1),
(3453, 2021, '3453', '2021-04-14', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2342, NULL, 2),
(3455, 2021, '3455', '2021-04-16', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2365, 576, 1),
(3456, 2021, '3456', '2021-04-09', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2365, 573, 2),
(3483, 2021, '3483', '2021-04-22', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 576, 1),
(3460, 2021, '3460', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, 576, 2),
(3461, 2021, '3461', '2021-04-12', NULL, NULL, 'Dépôt', 3, 15, 1586, NULL, 2362, 573, 1),
(3462, 2021, '3462', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 574, 1),
(3463, 2021, '3463', '2021-04-15', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, NULL, 1),
(3464, 2021, '3464', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 576, 1),
(3465, 2021, '3465', '2021-04-15', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2361, NULL, 2),
(3469, 2021, '3469', '2021-04-21', NULL, NULL, 'E-plan', 3, 16, 1583, NULL, 2346, 574, 2),
(3471, 2021, '3471', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 576, 2),
(3472, 2021, '3472', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 576, 1),
(3473, 2021, '3473', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2360, NULL, 2),
(3474, 2021, '3474', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2360, 576, 2),
(3484, 2021, '3484', '2021-04-02', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2349, 572, 1),
(3486, 2021, '3486', '2021-04-02', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2347, 572, 2),
(3487, 2021, '3487', '2021-04-01', NULL, NULL, 'Calcul COMAC ', 3, 13, 960, NULL, 2415, 571, 1),
(3488, 2021, '3488', '2021-04-22', NULL, '', 'Reprise Etude', 3, 16, 1547, NULL, 2362, 576, 2),
(3490, 2021, '3490', '2021-04-01', NULL, NULL, 'Plan Autocad', 3, 13, 961, NULL, 2415, 571, 2),
(3491, 2021, '3491', '2021-04-05', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2344, 572, 1),
(3529, 2021, '3529', '2021-04-29', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2360, 574, 1),
(3505, 2021, '3505', '2021-04-23', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2373, 576, 2),
(3495, 2021, '3495', '2021-04-22', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2361, 574, 2),
(3496, 2021, '3496', '2021-04-12', NULL, NULL, 'Réalisation du C6', 3, 15, 1551, NULL, 2360, 573, 2),
(3499, 2021, '3499', '2021-04-13', NULL, NULL, 'Réalisation du C6', 3, 15, 1551, NULL, 2360, 573, 1),
(3500, 2021, '3500', '2021-04-23', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2361, 574, 1),
(3546, 2021, '3546', '2021-04-15', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2369, 573, 2),
(3502, 2021, '3502', '2021-04-23', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2373, 576, 1),
(3503, 2021, '3503', '2021-04-13', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2360, 573, 2),
(3504, 2021, '3504', '2021-04-23', NULL, NULL, 'E-plan', 3, 16, 1583, NULL, 2361, 574, 2),
(3507, 2021, '3507', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2373, 576, 1),
(3508, 2021, '3508', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2361, 574, 1),
(3511, 2021, '3511', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2373, 576, 2),
(3513, 2021, '3513', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2373, 574, 2),
(3514, 2021, '3514', '2021-04-27', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, 578, 2),
(3515, 2021, '3515', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2369, 574, 1),
(3516, 2021, '3516', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2369, 574, 2),
(3517, 2021, '3517', '2021-04-26', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, 578, 1),
(3518, 2021, '3518', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2342, NULL, 1),
(3519, 2021, '3519', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2342, NULL, 2),
(3520, 2021, '3520', '2021-04-26', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, 578, 2),
(3919, 2021, '3919', '2021-04-12', NULL, NULL, 'Formation Personnelle', 3, 15, 1569, NULL, 2430, 572, 2),
(3522, 2021, '3522', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 574, 1),
(3523, 2021, '3523', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 574, 2),
(3525, 2021, '3525', '2021-04-06', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2338, 572, 1),
(3526, 2021, '3526', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2342, NULL, 1),
(3528, 2021, '3528', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 576, 1),
(3530, 2021, '3530', '2021-04-14', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2368, 573, 1),
(3531, 2021, '3531', '2021-04-06', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2338, 572, 2),
(3532, 2021, '3532', '2021-04-29', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2360, 574, 2),
(3533, 2021, '3533', '2021-04-28', NULL, '', 'Plan Autocad', 3, 17, 961, NULL, 2360, 576, 2),
(3589, 2021, '3589', '2021-04-09', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2335, 572, 2),
(3535, 2021, '3535', '2021-04-14', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2368, 573, 2),
(3537, 2021, '3537', '2021-04-30', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2360, 574, 1),
(3581, 2021, '3581', '2021-04-14', NULL, NULL, 'Contrôle C6', 3, 15, 1556, NULL, 2439, 572, 1),
(3539, 2021, '3539', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 576, 1),
(3617, 2021, '3617', '2021-04-02', NULL, NULL, 'Réalisation', 3, 13, 1457, NULL, 2349, 575, 1),
(3542, 2021, '3542', '2021-04-30', NULL, NULL, 'E-plan', 3, 17, 1583, NULL, 2360, 574, 2),
(3544, 2021, '3544', '2021-04-15', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2369, 573, 1),
(3599, 2021, '3599', '2021-04-05', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2390, 590, 1),
(3554, 2021, '3554', '2021-04-07', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2331, 572, 1),
(3578, 2021, '3578', '2021-04-26', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2348, NULL, 2),
(3550, 2021, '3550', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2360, 576, 2),
(3551, 2021, '3551', '2021-04-05', NULL, NULL, 'Reprise C3A', 3, 14, 1560, NULL, 2338, 572, 2),
(3616, 2021, '3616', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 2),
(3594, 2021, '3594', '2021-04-23', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, 578, 1),
(3558, 2021, '3558', '2021-04-30', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2360, 576, 2),
(3949, 2021, '3949', '2021-04-23', NULL, NULL, 'Contrôle C3A', 3, 16, 1559, NULL, 2427, NULL, 2),
(3565, 2021, '3565', '2021-04-22', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, NULL, 1),
(3567, 2021, '3567', '2021-04-22', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, NULL, 1),
(3571, 2021, '3571', '2021-04-16', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2373, 573, 1),
(3570, 2021, '3570', '2021-04-23', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, NULL, 1),
(3572, 2021, '3572', '2021-04-23', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, NULL, 2),
(3573, 2021, '3573', '2021-04-01', NULL, NULL, 'Reprise C6', 3, 13, 1555, NULL, 2342, 567, 1),
(3574, 2021, '3574', '2021-04-02', NULL, NULL, 'E-plan', 3, 13, 1583, NULL, 2390, 571, 2),
(3575, 2021, '3575', '2021-04-16', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2373, 573, 2),
(3595, 2021, '3595', '2021-04-23', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2346, 578, 2),
(3596, 2021, '3596', '2021-04-13', NULL, NULL, 'Reprise C3A', 3, 15, 1560, NULL, 2335, 572, 1),
(3597, 2021, '3597', '2021-04-13', NULL, NULL, 'Reprise C3A', 3, 15, 1560, NULL, 2335, 572, 2),
(3598, 2021, '3598', '2021-04-02', NULL, NULL, 'Dépôt', 3, 13, 1586, NULL, 2359, 567, 1),
(3600, 2021, '3600', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 1),
(3601, 2021, '3601', '2021-04-02', NULL, NULL, 'Contrôle C3A', 3, 13, 1559, NULL, 2326, 567, 2),
(3602, 2021, '3602', '2021-04-14', NULL, NULL, 'Contrôle C6', 3, 15, 1556, NULL, 2439, 572, 2),
(3603, 2021, '3603', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 2),
(3604, 2021, '3604', '2021-04-04', NULL, NULL, 'Contrôle Etude', 3, 13, 1548, NULL, 2415, 571, 1),
(3605, 2021, '3605', '2021-04-04', NULL, NULL, 'Plan Autocad', 3, 13, 961, NULL, 2415, 571, 2),
(3606, 2021, '3606', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 1),
(3609, 2021, '3609', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 1),
(3608, 2021, '3608', '2021-04-01', NULL, NULL, 'Réalisation', 3, 13, 1457, NULL, 2347, 575, 2),
(3610, 2021, '3610', '2021-04-05', NULL, '', 'Reprise Etude', 3, 14, 1547, NULL, 2246, 571, 1),
(3611, 2021, '3611', '2021-04-15', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2439, 572, 1),
(3612, 2021, '3612', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 2),
(3613, 2021, '3613', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 2),
(3615, 2021, '3615', '2021-04-20', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 1),
(3625, 2021, '3625', '2021-04-15', NULL, NULL, 'Réalisation du C6', 3, 15, 1551, NULL, 2439, 572, 2),
(3643, 2021, '3643', '2021-04-08', NULL, NULL, 'Calcul COMAC ', 3, 14, 960, NULL, 2401, 571, 1),
(3621, 2021, '3621', '2021-04-02', NULL, NULL, 'Contrôle C6', 3, 13, 1556, NULL, 2326, 568, 2),
(3622, 2021, '3622', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, NULL, 2),
(3626, 2021, '3626', '2021-04-05', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2326, 568, 1),
(3624, 2021, '3624', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 1),
(3627, 2021, '3627', '2021-04-21', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 578, 2),
(3628, 2021, '3628', '2021-04-05', NULL, NULL, 'Réalisation des C3A', 3, 14, 1553, NULL, 2326, 568, 2),
(3629, 2021, '3629', '2021-04-02', NULL, '', 'Réalisation', 3, 17, 1457, NULL, 2349, 575, 2),
(3630, 2021, '3630', '2021-04-06', NULL, NULL, 'Contrôle C3A', 3, 14, 1559, NULL, 2326, 568, 1),
(3956, 2021, '3956', '2021-04-21', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2346, 568, 2),
(3632, 2021, '3632', '2021-04-06', NULL, '', 'Calcul COMAC ', 3, 14, 960, NULL, 2401, 571, 1),
(3635, 2021, '3635', '2021-04-23', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2361, 573, 2),
(3636, 2021, '3636', '2021-04-22', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2362, 573, 1),
(3637, 2021, '3637', '2021-04-07', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2401, 571, 1),
(3638, 2021, '3638', '2021-04-06', NULL, NULL, 'Contrôle C6', 3, 14, 1556, NULL, 2347, 568, 2),
(3639, 2021, '3639', '2021-04-22', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2362, 573, 2),
(3640, 2021, '3640', '2021-04-07', NULL, NULL, 'E-plan', 3, 14, 1583, NULL, 2401, 571, 2),
(3641, 2021, '3641', '2021-04-07', NULL, NULL, 'Contrôle Calcul', 3, 14, 1557, NULL, 2347, 568, 1),
(3642, 2021, '3642', '2021-04-07', NULL, NULL, 'Contrôle C3A', 3, 14, 1559, NULL, 2347, 568, 2),
(3645, 2021, '3645', '2021-04-21', NULL, NULL, 'Vérification des Prérequis', 3, 16, 1456, NULL, 2361, 573, 1),
(3646, 2021, '3646', '2021-04-21', NULL, NULL, 'Vérification des Prérequis', 3, 16, 1456, NULL, 2373, 573, 2),
(3664, 2021, '3664', '2021-04-06', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 2),
(3649, 2021, '3649', '2021-04-08', NULL, NULL, 'E-plan', 3, 14, 1583, NULL, 2401, 571, 2),
(3658, 2021, '3658', '2021-04-27', NULL, NULL, 'Dépôt', 3, 17, 1586, NULL, 2372, 573, 1),
(3653, 2021, '3653', '2021-04-05', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2343, 575, 1),
(3654, 2021, '3654', '2021-04-07', NULL, NULL, 'Calcul COMAC ', 3, 14, 960, NULL, 2401, 590, 1),
(3680, 2021, '3680', '2021-04-28', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2366, 573, 1),
(3656, 2021, '3656', '2021-04-26', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2363, 573, 1),
(3657, 2021, '3657', '2021-04-26', NULL, NULL, 'Dépôt', 3, 17, 1586, NULL, 2360, 573, 2),
(3659, 2021, '3659', '2021-04-05', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 1),
(3660, 2021, '3660', '2021-04-05', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 2),
(3661, 2021, '3661', '2021-04-27', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2363, 573, 2),
(3662, 2021, '3662', '2021-04-06', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 1),
(3663, 2021, '3663', '2021-04-08', NULL, NULL, 'Calcul CAPFT', 3, 14, 1552, NULL, 2346, 568, 1),
(3665, 2021, '3665', '2021-04-08', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2394, 590, 1),
(3666, 2021, '3666', '2021-04-07', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 1),
(3667, 2021, '3667', '2021-04-08', NULL, NULL, 'Contrôle Calcul', 3, 14, 1557, NULL, 2346, 568, 2),
(3668, 2021, '3668', '2021-04-16', NULL, NULL, 'Préparation des DE', 3, 15, 1549, NULL, 2272, 572, 1),
(3669, 2021, '3669', '2021-04-09', NULL, NULL, 'Calcul COMAC ', 3, 14, 960, NULL, 2401, 571, 1),
(3670, 2021, '3670', '2021-04-07', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 2),
(3671, 2021, '3671', '2021-04-08', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 1),
(3672, 2021, '3672', '2021-04-09', NULL, NULL, 'Calcul CAPFT', 3, 14, 1552, NULL, 2346, 568, 1),
(3673, 2021, '3673', '2021-04-09', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2246, 590, 1),
(3675, 2021, '3675', '2021-04-08', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 2),
(3676, 2021, '3676', '2021-04-05', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2343, 575, 2),
(3678, 2021, '3678', '2021-04-09', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 1),
(3679, 2021, '3679', '2021-04-09', NULL, NULL, 'Contrôle Calcul', 3, 14, 1557, NULL, 2346, 568, 2),
(3681, 2021, '3681', '2021-04-09', NULL, NULL, 'APDGC Poteaux', 3, 14, 962, NULL, 2342, 578, 2),
(3683, 2021, '3683', '2021-04-28', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2366, 573, 2),
(3929, 2021, '3929', '2021-04-30', NULL, NULL, 'E-plan', 3, 17, 1583, NULL, 2390, 571, 2),
(3686, 2021, '3686', '2021-04-05', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 1),
(3687, 2021, '3687', '2021-04-12', NULL, '', 'Calcul CAPFT', 3, 14, 1552, NULL, 2346, 568, 1),
(3690, 2021, '3690', '2021-04-05', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 2),
(3691, 2021, '3691', '2021-04-20', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2367, 573, 1),
(3692, 2021, '3692', '2021-04-06', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 1),
(3694, 2021, '3694', '2021-04-20', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2367, 573, 2),
(3697, 2021, '3697', '2021-04-06', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 2),
(3698, 2021, '3698', '2021-04-06', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2343, 575, 1),
(3699, 2021, '3699', '2021-04-28', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, 578, 1),
(3701, 2021, '3701', '2021-04-07', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 1),
(3702, 2021, '3702', '2021-04-12', NULL, '', 'Réalisation des C3A', 3, 14, 1553, NULL, 2346, 568, 2),
(3703, 2021, '3703', '2021-04-13', NULL, '', 'Réalisation des C3A', 3, 14, 1553, NULL, 2346, 568, 1),
(3705, 2021, '3705', '2021-04-12', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2346, 590, 1),
(3706, 2021, '3706', '2021-04-28', NULL, NULL, 'APDGC Poteaux', 3, 17, 962, NULL, 2342, 578, 1),
(3707, 2021, '3707', '2021-04-06', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 2),
(3708, 2021, '3708', '2021-04-29', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2370, 573, 1),
(3709, 2021, '3709', '2021-04-13', NULL, '', 'Contrôle C6', 3, 14, 1556, NULL, 2346, 568, 2),
(3711, 2021, '3711', '2021-04-29', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2370, 573, 2),
(3712, 2021, '3712', '2021-04-14', NULL, '', 'Calcul CAPFT', 3, 15, 1552, NULL, 2346, 568, 1),
(3713, 2021, '3713', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, 578, 1),
(3714, 2021, '3714', '2021-04-30', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2372, 573, 1),
(3715, 2021, '3715', '2021-04-29', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, 578, 2),
(3716, 2021, '3716', '2021-04-30', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2372, 573, 2),
(3758, 2021, '3758', '2021-04-14', NULL, NULL, 'Contrôle Calcul', 3, 15, 1557, NULL, 2346, 568, 2),
(3718, 2021, '3718', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, 578, 1),
(3719, 2021, '3719', '2021-04-13', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2346, 590, 1),
(3720, 2021, '3720', '2021-04-07', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 1),
(3722, 2021, '3722', '2021-04-30', NULL, NULL, 'Calcul COMAC ', 3, 17, 960, NULL, 2342, 578, 2),
(3723, 2021, '3723', '2021-04-09', NULL, NULL, 'E-plan', 3, 14, 1583, NULL, 2401, 571, 2),
(3724, 2021, '3724', '2021-04-07', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 2),
(3727, 2021, '3727', '2021-04-08', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 1),
(3728, 2021, '3728', '2021-04-16', NULL, NULL, 'Reprise C3A', 3, 15, 1560, NULL, 2536, 572, 2),
(3730, 2021, '3730', '2021-04-07', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 2),
(3731, 2021, '3731', '2021-04-14', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2348, 590, 1),
(3732, 2021, '3732', '2021-04-02', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, 578, 1),
(3733, 2021, '3733', '2021-04-19', NULL, NULL, 'Calcul CAPFT', 3, 16, 1552, NULL, 2423, 572, 1),
(3735, 2021, '3735', '2021-04-08', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 2),
(3736, 2021, '3736', '2021-04-19', NULL, NULL, 'Reprise C3A', 3, 16, 1560, NULL, 2423, 572, 2),
(3737, 2021, '3737', '2021-04-02', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, 578, 2),
(3740, 2021, '3740', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, 578, 1),
(3741, 2021, '3741', '2021-04-16', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2536, 572, 1),
(3742, 2021, '3742', '2021-04-01', NULL, NULL, 'APDGC Poteaux', 3, 13, 962, NULL, 2345, 578, 2),
(3744, 2021, '3744', '2021-04-09', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 1),
(3746, 2021, '3746', '2021-04-09', NULL, NULL, 'Réalisation', 3, 14, 1457, NULL, 2345, 575, 2),
(3747, 2021, '3747', '2021-04-20', NULL, NULL, 'Reprise C3A', 3, 16, 1560, NULL, 2439, 572, 1),
(3749, 2021, '3749', '2021-04-12', NULL, '', 'Contrôle Etude', 3, 14, 1548, NULL, 2394, 571, 1),
(3760, 2021, '3760', '2021-04-15', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2346, 568, 1),
(3762, 2021, '3762', '2021-04-20', NULL, NULL, 'Contrôle C3A', 3, 16, 1559, NULL, 2439, 572, 2),
(3764, 2021, '3764', '2021-04-12', NULL, NULL, 'Réalisation', 3, 15, 1457, NULL, 2342, 575, 1),
(3765, 2021, '3765', '2021-04-12', NULL, '', 'E-plan', 3, 14, 1583, NULL, 2392, 571, 2),
(3767, 2021, '3767', '2021-04-12', NULL, NULL, 'Réalisation', 3, 15, 1457, NULL, 2342, 575, 2),
(3768, 2021, '3768', '2021-04-13', NULL, '', 'Reprise Etude', 3, 15, 1547, NULL, 2392, 571, 1),
(3770, 2021, '3770', '2021-04-13', NULL, NULL, 'Réalisation', 3, 15, 1457, NULL, 2342, 575, 1),
(3771, 2021, '3771', '2021-04-13', NULL, NULL, 'Réalisation', 3, 15, 1457, NULL, 2342, 575, 2),
(3772, 2021, '3772', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2392, 590, 1),
(3774, 2021, '3774', '2021-04-21', NULL, NULL, 'Reprise C6', 3, 16, 1555, NULL, 2427, 572, 1),
(3775, 2021, '3775', '2021-04-13', NULL, NULL, 'E-plan', 3, 15, 1583, NULL, 2392, 571, 2),
(3776, 2021, '3776', '2021-04-21', NULL, NULL, 'Contrôle C6', 3, 16, 1556, NULL, 2427, 572, 2),
(3779, 2021, '3779', '2021-04-16', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2401, 590, 1),
(3778, 2021, '3778', '2021-04-08', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2342, 567, 1),
(3780, 2021, '3780', '2021-04-14', NULL, NULL, 'Réalisation', 3, 15, 1457, NULL, 2342, 575, 1),
(3781, 2021, '3781', '2021-04-23', NULL, NULL, 'Calcul CAPFT', 3, 16, 1552, NULL, 2427, 572, 1),
(3782, 2021, '3782', '2021-04-14', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2394, 571, 1),
(3784, 2021, '3784', '2021-04-23', NULL, NULL, 'Reprise C3A', 3, 16, 1560, NULL, 2427, 572, 2),
(3785, 2021, '3785', '2021-04-14', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2394, 571, 1),
(3786, 2021, '3786', '2021-04-08', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2342, 567, 2),
(3788, 2021, '3788', '2021-04-09', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2342, 567, 1),
(3789, 2021, '3789', '2021-04-19', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2415, 590, 1),
(3790, 2021, '3790', '2021-04-09', NULL, NULL, 'Reprise C6', 3, 14, 1555, NULL, 2342, 567, 2),
(3791, 2021, '3791', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2390, 571, 1),
(3792, 2021, '3792', '2021-04-12', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 1),
(3806, 2021, '3806', '2021-04-16', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2330, 575, 2),
(3796, 2021, '3796', '2021-04-15', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2392, 571, 2),
(3797, 2021, '3797', '2021-04-20', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2394, 590, 1),
(3798, 2021, '3798', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2330, 575, 2),
(3799, 2021, '3799', '2021-04-22', NULL, NULL, 'Reprise Calcul', 3, 16, 1558, NULL, 2542, 572, 1),
(3800, 2021, '3800', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2330, 575, 1),
(3801, 2021, '3801', '2021-04-16', NULL, NULL, 'Calcul COMAC ', 3, 15, 960, NULL, 2415, 571, 1),
(3802, 2021, '3802', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2330, 575, 2),
(3803, 2021, '3803', '2021-04-16', NULL, NULL, 'E-plan', 3, 15, 1583, NULL, 2415, 571, 2),
(3804, 2021, '3804', '2021-04-22', NULL, NULL, 'Reprise Calcul', 3, 16, 1558, NULL, 2501, 572, 2),
(3805, 2021, '3805', '2021-04-16', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2330, 575, 1),
(3820, 2021, '3820', '2021-04-20', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2338, 575, 1),
(3809, 2021, '3809', '2021-04-19', NULL, NULL, 'E-plan', 3, 16, 1583, NULL, 2394, 571, 1),
(3818, 2021, '3818', '2021-04-22', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2392, 590, 1),
(3811, 2021, '3811', '2021-04-21', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2401, 590, 1),
(3812, 2021, '3812', '2021-04-19', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2338, 575, 1),
(3813, 2021, '3813', '2021-04-12', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 2),
(3814, 2021, '3814', '2021-04-19', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2338, 575, 2),
(3815, 2021, '3815', '2021-04-13', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 1),
(3819, 2021, '3819', '2021-04-26', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2441, 572, 1),
(3822, 2021, '3822', '2021-04-26', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2441, 572, 2),
(3823, 2021, '3823', '2021-04-27', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2257, 572, 1),
(3824, 2021, '3824', '2021-04-13', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 2),
(3825, 2021, '3825', '2021-04-27', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2257, 572, 2),
(4042, 2021, '4042', '2021-04-16', NULL, NULL, 'Suivi des Relevé+control', 3, 15, 959, NULL, 2346, 566, 1),
(3827, 2021, '3827', '2021-04-14', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 1),
(3828, 2021, '3828', '2021-04-20', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2338, 575, 2),
(3829, 2021, '3829', '2021-04-14', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2342, 567, 2),
(3830, 2021, '3830', '2021-04-23', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2401, 590, 1),
(3831, 2021, '3831', '2021-04-28', NULL, NULL, 'Calcul CAPFT', 3, 17, 1552, NULL, 2257, 572, 1),
(3832, 2021, '3832', '2021-04-19', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2392, 571, 2),
(3833, 2021, '3833', '2021-04-21', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2338, 575, 1),
(3834, 2021, '3834', '2021-04-15', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2346, 567, 1),
(3835, 2021, '3835', '2021-04-20', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2392, 571, 1),
(3837, 2021, '3837', '2021-04-28', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2639, 572, 2),
(3838, 2021, '3838', '2021-04-15', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2346, 567, 2),
(3839, 2021, '3839', '2021-04-15', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2346, 568, 2),
(3840, 2021, '3840', '2021-04-20', NULL, NULL, 'E-plan', 3, 16, 1583, NULL, 2392, 571, 2),
(3841, 2021, '3841', '2021-04-29', NULL, NULL, 'Calcul CAPFT', 3, 17, 1552, NULL, 2639, 572, 1),
(3842, 2021, '3842', '2021-04-16', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2346, 567, 1),
(3843, 2021, '3843', '2021-04-16', NULL, NULL, 'Contrôle C6', 3, 15, 1556, NULL, 2346, 568, 1),
(3844, 2021, '3844', '2021-04-30', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2482, 572, 1),
(3845, 2021, '3845', '2021-04-16', NULL, NULL, 'Reprise Calcul', 3, 15, 1558, NULL, 2346, 567, 2),
(3846, 2021, '3846', '2021-04-26', NULL, NULL, 'Conception Point Technique', 3, 17, 1494, NULL, 2393, 590, 1),
(3847, 2021, '3847', '2021-04-16', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2346, 568, 2),
(3848, 2021, '3848', '2021-04-30', NULL, NULL, 'Calcul CAPFT', 3, 17, 1552, NULL, 2482, 572, 2),
(3849, 2021, '3849', '2021-04-21', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 575, 2),
(3850, 2021, '3850', '2021-04-19', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 568, 1),
(3852, 2021, '3852', '2021-04-22', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 575, 1),
(3853, 2021, '3853', '2021-04-21', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2394, 571, 1),
(3854, 2021, '3854', '2021-04-22', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 575, 2),
(3855, 2021, '3855', '2021-04-21', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2394, 571, 2),
(3857, 2021, '3857', '2021-04-28', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 1),
(3858, 2021, '3858', '2021-04-22', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2394, 571, 1),
(3860, 2021, '3860', '2021-04-22', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2392, 571, 2),
(3861, 2021, '3861', '2021-04-19', NULL, NULL, 'Reprise Calcul', 3, 16, 1558, NULL, 2346, 567, 1),
(3862, 2021, '3862', '2021-04-19', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 567, 2),
(3863, 2021, '3863', '2021-04-29', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 1),
(3864, 2021, '3864', '2021-04-19', NULL, NULL, 'Reprise Calcul', 3, 16, 1558, NULL, 2346, 568, 2),
(3898, 2021, '3898', '2021-04-22', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 567, 1),
(3867, 2021, '3867', '2021-04-20', NULL, '', 'Contrôle C6', 3, 16, 1556, NULL, 2346, 568, 1),
(3869, 2021, '3869', '2021-04-23', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2347, 575, 2),
(3871, 2021, '3871', '2021-04-30', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 1),
(3874, 2021, '3874', '2021-04-20', NULL, '', 'Calcul CAPFT', 3, 16, 1552, NULL, 2346, 568, 2),
(3873, 2021, '3873', '2021-04-26', NULL, NULL, 'Réalisation', 3, 17, 1457, NULL, 2348, 575, 1),
(3877, 2021, '3877', '2021-04-21', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 568, 1),
(3878, 2021, '3878', '2021-04-20', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 567, 1),
(3879, 2021, '3879', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2364, 575, 1),
(3880, 2021, '3880', '2021-04-23', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2415, 571, 1),
(3882, 2021, '3882', '2021-04-23', NULL, NULL, 'E-plan', 3, 16, 1583, NULL, 2415, 571, 2),
(3884, 2021, '3884', '2021-04-27', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2364, 575, 2),
(3886, 2021, '3886', '2021-04-06', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2364, 566, 1),
(3889, 2021, '3889', '2021-04-20', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 567, 2),
(3890, 2021, '3890', '2021-04-06', NULL, NULL, 'Calcul COMAC ', 3, 14, 960, NULL, 2332, 566, 2),
(3891, 2021, '3891', '2021-04-26', NULL, '', 'Reprise Etude', 3, 17, 1547, NULL, 2401, 571, 1),
(3893, 2021, '3893', '2021-04-26', NULL, '', 'E-plan', 3, 17, 1583, NULL, 2401, 571, 2),
(3897, 2021, '3897', '2021-04-21', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 567, 2),
(3899, 2021, '3899', '2021-04-22', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 567, 2),
(3958, 2021, '3958', '2021-04-26', NULL, NULL, 'Contrôle C3A', 3, 17, 1559, NULL, 2441, NULL, 2),
(3901, 2021, '3901', '2021-04-27', NULL, NULL, 'Contrôle Etude', 3, 17, 1548, NULL, 2401, 571, 1),
(3902, 2021, '3902', '2021-04-01', NULL, NULL, 'Plan Autocad', 3, 13, 961, NULL, 2401, 590, 2),
(3905, 2021, '3905', '2021-04-23', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2347, 575, 1),
(3907, 2021, '3907', '2021-04-21', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 567, 1),
(3909, 2021, '3909', '2021-04-02', NULL, NULL, 'Plan Autocad', 3, 13, 961, NULL, 2392, 590, 2),
(3910, 2021, '3910', '2021-04-07', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2346, 566, 1),
(3916, 2021, '3916', '2021-04-23', NULL, NULL, 'Réalisation', 3, 16, 1457, NULL, 2346, 567, 1),
(3955, 2021, '3955', '2021-04-07', NULL, NULL, 'Reprise DOE', 3, 14, 1584, NULL, 2346, 566, 2),
(3915, 2021, '3915', '2021-04-28', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2392, 571, 1),
(3917, 2021, '3917', '2021-04-12', NULL, NULL, 'Formation Personnelle', 3, 15, 1569, NULL, 2430, 572, 1),
(3918, 2021, '3918', '2021-04-28', NULL, NULL, 'E-plan', 3, 17, 1583, NULL, 2392, 571, 2),
(3920, 2021, '3920', '2021-04-01', NULL, NULL, 'Réalisation', 3, 13, 1457, NULL, 2347, 575, 1),
(3921, 2021, '3921', '2021-04-29', NULL, NULL, 'Contrôle Etude', 3, 17, 1548, NULL, 2390, 571, 1),
(3922, 2021, '3922', '2021-04-05', NULL, NULL, 'DOE', 3, 14, 963, NULL, 2329, 566, 1),
(3923, 2021, '3923', '2021-04-23', NULL, NULL, 'Contrôle C6', 3, 16, 1556, NULL, 2347, 567, 2),
(3924, 2021, '3924', '2021-04-29', NULL, NULL, 'E-plan', 3, 17, 1583, NULL, 2390, 571, 2),
(3925, 2021, '3925', '2021-04-30', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2390, 571, 1),
(3926, 2021, '3926', '2021-04-21', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, NULL, 1),
(3927, 2021, '3927', '2021-04-05', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2390, 590, 2),
(3928, 2021, '3928', '2021-04-21', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, NULL, 2),
(3930, 2021, '3930', '2021-04-26', NULL, NULL, 'Formation Personnelle', 3, 17, 1569, NULL, 2347, 567, 1),
(3932, 2021, '3932', '2021-04-05', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2330, 566, 2),
(3947, 2021, '3947', '2021-04-23', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2427, NULL, 1),
(3934, 2021, '3934', '2021-04-26', NULL, NULL, 'Reprise C3A', 3, 17, 1560, NULL, 2346, 567, 2),
(3935, 2021, '3935', '2021-04-27', NULL, NULL, 'Reprise C3A', 3, 17, 1560, NULL, 2346, 567, 1),
(3936, 2021, '3936', '2021-04-27', NULL, NULL, 'Reprise C6', 3, 17, 1555, NULL, 2347, 567, 2),
(3937, 2021, '3937', '2021-04-22', NULL, NULL, 'Contrôle C3A', 3, 16, 1559, NULL, 2542, NULL, 1),
(3938, 2021, '3938', '2021-04-06', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 590, 1),
(3939, 2021, '3939', '2021-04-28', NULL, NULL, 'Reprise C6', 3, 17, 1555, NULL, 2347, 567, 1),
(3940, 2021, '3940', '2021-04-28', NULL, NULL, 'Reprise C6', 3, 17, 1555, NULL, 2347, 567, 2),
(3960, 2021, '3960', '2021-04-27', NULL, NULL, 'Dépôt', 3, 17, 1586, NULL, 2346, NULL, 2),
(3942, 2021, '3942', '2021-04-29', NULL, NULL, 'Reprise Calcul', 3, 17, 1558, NULL, 2347, 567, 1),
(3943, 2021, '3943', '2021-04-22', NULL, NULL, 'Contrôle C3A', 3, 16, 1559, NULL, 2501, NULL, 2),
(3944, 2021, '3944', '2021-04-29', NULL, NULL, 'Reprise Calcul', 3, 17, 1558, NULL, 2347, 567, 2),
(3945, 2021, '3945', '2021-04-07', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2394, 590, 2),
(3954, 2021, '3954', '2021-04-26', NULL, NULL, 'Contrôle Calcul', 3, 17, 1557, NULL, 2441, NULL, 1),
(3950, 2021, '3950', '2021-04-30', NULL, NULL, 'Contrôle Calcul', 3, 17, 1557, NULL, 2347, 567, 1),
(3959, 2021, '3959', '2021-04-06', NULL, NULL, 'Plan Autocad', 3, 14, 961, NULL, 2392, 590, 2),
(3952, 2021, '3952', '2021-04-30', NULL, NULL, 'Contrôle Calcul', 3, 17, 1557, NULL, 2347, 567, 2),
(3965, 2021, '3965', '2021-04-22', NULL, NULL, 'Contrôle Calcul', 3, 16, 1557, NULL, 2346, 568, 1),
(3968, 2021, '3968', '2021-04-22', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2346, 568, 2),
(3970, 2021, '3970', '2021-04-08', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2401, 590, 2),
(3971, 2021, '3971', '2021-04-23', NULL, NULL, 'Contrôle C6', 3, 16, 1556, NULL, 2346, 568, 1),
(3975, 2021, '3975', '2021-04-08', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2346, 566, 1),
(3976, 2021, '3976', '2021-04-23', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2346, 568, 2),
(3978, 2021, '3978', '2021-04-08', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2346, 566, 2),
(3980, 2021, '3980', '2021-04-26', NULL, NULL, 'Suivi des Relevé + Contrôle', 3, 17, 1550, NULL, 2393, 568, 1),
(3982, 2021, '3982', '2021-04-09', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2394, 590, 2),
(3983, 2021, '3983', '2021-04-26', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2346, 568, 2),
(3984, 2021, '3984', '2021-04-09', NULL, NULL, 'Reprise Etude', 3, 14, 1547, NULL, 2346, 566, 1),
(3985, 2021, '3985', '2021-04-12', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2346, 590, 2),
(3986, 2021, '3986', '2021-04-09', NULL, NULL, 'Contrôle Etude', 3, 14, 1548, NULL, 2346, 566, 2),
(3989, 2021, '3989', '2021-04-13', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2346, 590, 2),
(3994, 2021, '3994', '2021-04-27', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2346, 568, 1),
(3997, 2021, '3997', '2021-04-14', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2348, 590, 2),
(3998, 2021, '3998', '2021-04-27', NULL, NULL, 'Contrôle C3A', 3, 17, 1559, NULL, 2346, 568, 2),
(4001, 2021, '4001', '2021-04-28', NULL, NULL, 'Réalisation des C3A', 3, 17, 1553, NULL, 2346, 568, 1),
(4003, 2021, '4003', '2021-04-28', NULL, NULL, 'Contrôle C3A', 3, 17, 1559, NULL, 2346, 568, 2),
(4004, 2021, '4004', '2021-04-16', NULL, NULL, 'Plan Autocad', 3, 15, 961, NULL, 2401, 590, 2),
(4010, 2021, '4010', '2021-04-29', NULL, NULL, 'Calcul CAPFT', 3, 17, 1552, NULL, 2347, 568, 1),
(4011, 2021, '4011', '2021-04-29', NULL, NULL, 'Contrôle Calcul', 3, 17, 1557, NULL, 2347, 568, 2),
(4013, 2021, '4013', '2021-04-30', NULL, NULL, 'Calcul CAPFT', 3, 17, 1552, NULL, 2347, 568, 1),
(4015, 2021, '4015', '2021-04-30', NULL, NULL, 'Contrôle C6', 3, 17, 1556, NULL, 2347, 568, 2),
(4017, 2021, '4017', '2021-04-15', NULL, NULL, 'Reprise Etude', 3, 15, 1547, NULL, 2390, 590, 2),
(4020, 2021, '4020', '2021-04-19', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2401, 590, 2),
(4021, 2021, '4021', '2021-04-20', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2415, 590, 2),
(4022, 2021, '4022', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2331, 566, 1),
(4023, 2021, '4023', '2021-04-12', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2338, 566, 2),
(4024, 2021, '4024', '2021-04-13', NULL, NULL, 'APDGC Poteaux', 3, 15, 962, NULL, 2330, 566, 1),
(4025, 2021, '4025', '2021-04-13', NULL, NULL, 'DOE', 3, 15, 963, NULL, 2329, 566, 2),
(4026, 2021, '4026', '2021-04-21', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2390, 590, 2),
(4027, 2021, '4027', '2021-04-22', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2415, 590, 2),
(4037, 2021, '4037', '2021-04-28', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2401, 590, 2),
(4029, 2021, '4029', '2021-04-23', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2401, 590, 2),
(4038, 2021, '4038', '2021-04-29', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 2),
(4031, 2021, '4031', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2401, 590, 2),
(4032, 2021, '4032', '2021-04-14', NULL, NULL, 'Contrôle Etude', 3, 15, 1548, NULL, 2366, 566, 1),
(4033, 2021, '4033', '2021-04-14', NULL, NULL, 'Préparation des DE', 3, 15, 958, NULL, 2366, 566, 2),
(4043, 2021, '4043', '2021-04-02', NULL, NULL, 'Reprise Etude', 3, 13, 1547, NULL, 2401, 590, 1),
(4035, 2021, '4035', '2021-04-15', NULL, NULL, 'Vérification des APD Poteaux', 3, 15, 1587, NULL, 2338, 566, 2),
(4036, 2021, '4036', '2021-04-27', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2401, 590, 2),
(4041, 2021, '4041', '2021-04-15', NULL, NULL, 'Vérification des APD Poteaux', 3, 15, 1587, NULL, 2332, 566, 1),
(4040, 2021, '4040', '2021-04-30', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2401, 590, 2),
(4044, 2021, '4044', '2021-04-16', NULL, NULL, 'Vérification des APD Poteaux', 3, 15, 1587, NULL, 2330, 566, 2),
(4045, 2021, '4045', '2021-04-01', NULL, NULL, 'Reprise Etude', 3, 13, 1547, NULL, 2390, 590, 1),
(4046, 2021, '4046', '2021-04-19', NULL, NULL, 'Calcul COMAC ', 3, 16, 960, NULL, 2346, 566, 1),
(4047, 2021, '4047', '2021-04-19', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2346, 566, 2),
(4048, 2021, '4048', '2021-04-20', NULL, NULL, 'Plan Autocad', 3, 16, 961, NULL, 2346, 566, 1),
(4049, 2021, '4049', '2021-04-20', NULL, NULL, 'Reprise Etude', 3, 16, 1547, NULL, 2348, 566, 2),
(4072, 2021, '4072', '2021-04-21', NULL, NULL, 'Formation Personnelle', 3, 16, 1569, NULL, 2346, 566, 1),
(4051, 2021, '4051', '2021-04-01', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2359, 570, 1),
(4095, 2021, '4095', '2021-04-09', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2332, 570, 1),
(4053, 2021, '4053', '2021-04-01', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2326, 570, 2),
(4061, 2021, '4061', '2021-04-06', NULL, NULL, 'Contrôle C6', 3, 14, 1556, NULL, 2338, 570, 1),
(4058, 2021, '4058', '2021-04-02', NULL, NULL, 'Reprise C3A', 3, 13, 1560, NULL, 2347, 570, 2),
(4056, 2021, '4056', '2021-04-02', NULL, NULL, 'Calcul CAPFT', 3, 13, 1552, NULL, 2347, 570, 1),
(4059, 2021, '4059', '2021-04-05', NULL, NULL, 'Calcul CAPFT', 3, 14, 1552, NULL, 2331, 570, 1),
(4060, 2021, '4060', '2021-04-05', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2331, 570, 2),
(4063, 2021, '4063', '2021-04-22', NULL, NULL, 'Contrôle Etude', 3, 16, 1548, NULL, 2372, 566, 2),
(4064, 2021, '4064', '2021-04-06', NULL, NULL, 'Calcul CAPFT', 3, 14, 1552, NULL, 2338, 570, 2),
(4065, 2021, '4065', '2021-04-07', NULL, NULL, 'Contrôle C3A', 3, 14, 1559, NULL, 2338, 570, 1),
(4066, 2021, '4066', '2021-04-07', NULL, NULL, 'Contrôle C3A', 3, 14, 1559, NULL, 2347, 570, 2),
(4076, 2021, '4076', '2021-04-23', NULL, NULL, 'Vérification des APD Poteaux', 3, 16, 1587, NULL, 2346, 566, 1),
(4068, 2021, '4068', '2021-04-08', NULL, NULL, 'Contrôle C6', 3, 14, 1556, NULL, 2334, 570, 1),
(4069, 2021, '4069', '2021-04-23', NULL, NULL, 'APDGC Poteaux', 3, 16, 962, NULL, 2348, 566, 2),
(4070, 2021, '4070', '2021-04-08', NULL, NULL, 'Calcul CAPFT', 3, 14, 1552, NULL, 2334, 570, 2),
(4073, 2021, '4073', '2021-04-21', NULL, NULL, 'Formation Personnelle', 3, 16, 1569, NULL, 2346, 566, 2),
(4075, 2021, '4075', '2021-04-22', NULL, NULL, 'Contrôle DOE', 3, 16, 1585, NULL, 2371, 566, 1),
(4077, 2021, '4077', '2021-04-12', NULL, NULL, 'Contrôle C6', 3, 15, 1556, NULL, 2347, 570, 1),
(4078, 2021, '4078', '2021-04-12', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2347, 570, 2),
(4079, 2021, '4079', '2021-04-13', NULL, NULL, 'Réalisation des C3A', 3, 15, 1553, NULL, 2347, 570, 1),
(4080, 2021, '4080', '2021-04-13', NULL, NULL, 'Contrôle C3A', 3, 15, 1559, NULL, 2347, 570, 2),
(4081, 2021, '4081', '2021-04-14', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2346, 570, 1),
(4082, 2021, '4082', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2348, 566, 1),
(4085, 2021, '4085', '2021-04-15', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2346, 570, 1),
(4084, 2021, '4084', '2021-04-14', NULL, NULL, 'Contrôle C6', 3, 15, 1556, NULL, 2346, 570, 2),
(4086, 2021, '4086', '2021-04-26', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2332, 566, 2),
(4087, 2021, '4087', '2021-04-15', NULL, '', 'Contrôle C6', 3, 17, 1556, NULL, 2346, 570, 2),
(4088, 2021, '4088', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2347, 566, 1),
(4089, 2021, '4089', '2021-04-27', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2347, 566, 2),
(4090, 2021, '4090', '2021-04-16', NULL, NULL, 'Calcul CAPFT', 3, 15, 1552, NULL, 2346, 570, 1),
(4094, 2021, '4094', '2021-04-28', NULL, NULL, 'Contrôle Etude', 3, 17, 1548, NULL, 2338, 566, 1),
(4092, 2021, '4092', '2021-04-16', NULL, NULL, 'Contrôle Calcul', 3, 15, 1557, NULL, 2346, 570, 2),
(4093, 2021, '4093', '2021-04-28', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2348, 566, 1),
(4098, 2021, '4098', '2021-04-20', NULL, NULL, 'Calcul CAPFT', 3, 16, 1552, NULL, 2346, 570, 1),
(4097, 2021, '4097', '2021-04-09', NULL, NULL, 'Réalisation du C6', 3, 14, 1551, NULL, 2332, 570, 2),
(4099, 2021, '4099', '2021-04-29', NULL, NULL, 'Contrôle Etude', 3, 17, 1548, NULL, 2373, 566, 1),
(4100, 2021, '4100', '2021-04-29', NULL, NULL, 'Contrôle Etude', 3, 17, 1548, NULL, 2373, 566, 2),
(4101, 2021, '4101', '2021-04-30', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2347, 566, 1),
(4102, 2021, '4102', '2021-04-30', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2347, 566, 2),
(4103, 2021, '4103', '2021-04-20', NULL, NULL, 'Contrôle C6', 3, 16, 1556, NULL, 2347, 570, 2),
(4104, 2021, '4104', '2021-04-28', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2364, 575, 1),
(4106, 2021, '4106', '2021-04-28', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2364, 575, 2),
(4107, 2021, '4107', '2021-04-21', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2348, 570, 1),
(4109, 2021, '4109', '2021-04-21', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2348, 570, 2),
(4110, 2021, '4110', '2021-04-29', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2364, 575, 1),
(4111, 2021, '4111', '2021-04-29', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2364, 575, 2),
(4113, 2021, '4113', '2021-04-22', NULL, NULL, 'Réalisation du C6', 3, 16, 1551, NULL, 2335, 570, 1),
(4115, 2021, '4115', '2021-04-30', NULL, NULL, 'Reprise Etude', 3, 17, 1547, NULL, 2364, 575, 1),
(4116, 2021, '4116', '2021-04-22', NULL, NULL, 'Réalisation du C6', 3, 16, 1551, NULL, 2335, 570, 2),
(4117, 2021, '4117', '2021-04-30', NULL, NULL, 'Plan Autocad', 3, 17, 961, NULL, 2364, 575, 2),
(4118, 2021, '4118', '2021-04-23', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2348, 570, 1),
(4119, 2021, '4119', '2021-04-23', NULL, NULL, 'Réalisation des C3A', 3, 16, 1553, NULL, 2348, 570, 2),
(4122, 2021, '4122', '2021-04-19', NULL, NULL, 'Réalisation du C6', 3, 16, 1551, NULL, 3082, 570, 1),
(4123, 2021, '4123', '2021-04-19', NULL, NULL, 'Réalisation du C6', 3, 16, 1551, NULL, 3082, 570, 2),
(4124, 2021, '4124', '2021-04-28', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2333, 570, 1),
(4125, 2021, '4125', '2021-04-28', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2333, 570, 2),
(4128, 2021, '4128', '2021-04-29', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2336, 570, 1),
(4130, 2021, '4130', '2021-04-29', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2336, 570, 2),
(4132, 2021, '4132', '2021-04-30', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2337, 570, 1),
(4133, 2021, '4133', '2021-04-30', NULL, NULL, 'Réalisation du C6', 3, 17, 1551, NULL, 2337, 570, 2),
(4158, 2021, '4158', '2021-05-03', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 1),
(4145, 2021, '4145', '2021-05-03', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2348, 566, 1),
(4146, 2021, '4146', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2338, 566, 2),
(4147, 2021, '4147', '2021-05-03', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 567, 1),
(4148, 2021, '4148', '2021-05-03', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 567, 2),
(4149, 2021, '4149', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 574, 1),
(4150, 2021, '4150', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 574, 2),
(4151, 2021, '4151', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2392, 571, 1),
(4152, 2021, '4152', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2401, 590, 1),
(4167, 2021, '4167', '2021-05-03', NULL, NULL, 'Reprise Calcul', 4, 18, 1558, NULL, 2579, 572, 1),
(4168, 2021, '4168', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2401, 571, 2),
(4155, 2021, '4155', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 575, 1),
(4156, 2021, '4156', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 575, 2),
(4157, 2021, '4157', '2021-05-03', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 2),
(4159, 2021, '4159', '2021-05-03', NULL, NULL, 'Réalisation des C3A', 4, 18, 1553, NULL, 2370, 573, 1),
(4160, 2021, '4160', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 577, 1),
(4161, 2021, '4161', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 577, 2),
(4164, 2021, '4164', '2021-05-03', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2342, 578, 1),
(4165, 2021, '4165', '2021-05-03', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2342, 578, 2),
(4169, 2021, '4169', '2021-05-03', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2570, 572, 2),
(4171, 2021, '4171', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 576, 1),
(4172, 2021, '4172', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 576, 2),
(4173, 2021, '4173', '2021-05-03', NULL, NULL, 'Suivi des Relevé + Contrôle', 4, 18, 1550, NULL, 2378, 573, 2),
(4174, 2021, '4174', '2021-05-03', NULL, NULL, 'Réalisation des C3A', 4, 18, 1553, NULL, 2346, 568, 1),
(4175, 2021, '4175', '2021-05-03', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 2),
(4178, 2021, '4178', '2021-05-03', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2401, 590, 2),
(4180, 2021, '4180', '2021-05-03', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2349, 596, 1);
INSERT INTO `tache` (`id`, `annee`, `code`, `date_demarrage_effective`, `date_fin_effective`, `description`, `libelle`, `mois`, `semaine`, `categorie_tache`, `etat_tache`, `groupe_tache`, `membre_equipe`, `periode`) VALUES
(4182, 2021, '4182', '2021-05-03', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2349, 596, 2),
(4183, 2021, '4183', '2021-05-03', NULL, NULL, 'Réalisation SIOREC', 4, 18, 1511, NULL, 2377, 598, 1),
(4185, 2021, '4185', '2021-05-03', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2374, 598, 2),
(4189, 2021, '4189', '2021-05-03', NULL, NULL, 'Vérification', 4, 18, 1471, NULL, 2466, 589, 2),
(4190, 2021, '4190', '2021-05-03', NULL, NULL, 'Formation', 4, 18, 1526, NULL, 2578, 589, 1),
(4196, 2021, '4196', '2021-05-03', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2247, 601, 1),
(4197, 2021, '4197', '2021-05-03', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2247, 601, 2),
(4199, 2021, '4199', '2021-05-03', NULL, NULL, 'Intégration point technique', 4, 18, 1424, NULL, 2466, 588, 1),
(4201, 2021, '4201', '2021-05-03', NULL, NULL, 'Préparation des SHAPES', 4, 18, 1546, NULL, 2466, 588, 2),
(4259, 2021, '4259', '2021-05-04', NULL, NULL, 'Reprise', 4, 18, 1430, NULL, 2464, 588, 1),
(4203, 2021, '4203', '2021-05-03', NULL, NULL, 'Epp', 4, 18, 1524, NULL, 2377, 593, 1),
(4204, 2021, '4204', '2021-05-03', NULL, NULL, 'Epp', 4, 18, 1524, NULL, 2407, 593, 2),
(4205, 2021, '4205', '2021-05-03', NULL, NULL, 'Avancement', 4, 18, 1540, NULL, 2343, 582, 1),
(4206, 2021, '4206', '2021-05-03', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2374, 582, 2),
(4207, 2021, '4207', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 567, 1),
(4208, 2021, '4208', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2390, 590, 1),
(4209, 2021, '4209', '2021-05-04', NULL, NULL, 'Suivi des Relevé+control', 4, 18, 959, NULL, 2378, 574, 1),
(4210, 2021, '4210', '2021-05-04', NULL, NULL, 'Suivi des Relevé+control', 4, 18, 959, NULL, 2189, 574, 2),
(4211, 2021, '4211', '2021-05-04', NULL, NULL, 'Contrôle Etude', 4, 18, 1548, NULL, 2401, 571, 1),
(4212, 2021, '4212', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 1),
(4213, 2021, '4213', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 2),
(4214, 2021, '4214', '2021-05-04', NULL, NULL, 'E-plan', 4, 18, 1583, NULL, 2401, 571, 2),
(4215, 2021, '4215', '2021-05-04', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2570, 572, 1),
(4216, 2021, '4216', '2021-05-04', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2570, 572, 2),
(4217, 2021, '4217', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 575, 1),
(4218, 2021, '4218', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 576, 1),
(4219, 2021, '4219', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 575, 2),
(4220, 2021, '4220', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2366, 576, 2),
(4223, 2021, '4223', '2021-05-04', NULL, NULL, 'Suivi des Relevé+control', 4, 18, 959, NULL, 2421, 577, 1),
(4224, 2021, '4224', '2021-05-04', NULL, NULL, 'Suivi des Relevé+control', 4, 18, 959, NULL, 2421, 577, 2),
(4225, 2021, '4225', '2021-05-04', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 1),
(4226, 2021, '4226', '2021-05-04', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 2),
(4227, 2021, '4227', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 567, 2),
(4228, 2021, '4228', '2021-05-04', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2390, 590, 2),
(4231, 2021, '4231', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 1),
(4232, 2021, '4232', '2021-05-04', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 2),
(4233, 2021, '4233', '2021-05-04', NULL, NULL, 'Suivi des Relevé + Contrôle', 4, 18, 1550, NULL, 2421, 573, 1),
(4234, 2021, '4234', '2021-05-04', NULL, NULL, 'Réalisation du C6', 4, 18, 1551, NULL, 2378, 573, 2),
(4235, 2021, '4235', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2338, 566, 1),
(4236, 2021, '4236', '2021-05-04', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2338, 566, 2),
(4240, 2021, '4240', '2021-05-04', NULL, NULL, 'Dépose', 4, 18, 1534, NULL, 2196, 589, 1),
(4243, 2021, '4243', '2021-05-04', NULL, NULL, 'Reprise', 4, 18, 1472, NULL, 2531, 589, 3),
(4242, 2021, '4242', '2021-05-04', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2377, 598, 1),
(4244, 2021, '4244', '2021-05-04', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2349, 596, 1),
(4246, 2021, '4246', '2021-05-04', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2364, 596, 2),
(4252, 2021, '4252', '2021-05-04', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2374, 582, 1),
(4253, 2021, '4253', '2021-05-04', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2374, 582, 2),
(4260, 2021, '4260', '2021-05-04', NULL, NULL, 'Formation', 4, 18, 1526, NULL, 2461, 588, 2),
(4261, 2021, '4261', '2021-05-04', NULL, NULL, 'Formation Personnelle', 4, 18, 1569, NULL, 2377, 598, 2),
(4262, 2021, '4262', '2021-05-04', NULL, NULL, 'Epp', 4, 18, 1524, NULL, 2377, 593, 1),
(4263, 2021, '4263', '2021-05-04', NULL, NULL, 'PDS', 4, 18, 1515, NULL, 2377, 593, 2),
(4264, 2021, '4264', '2021-05-01', NULL, NULL, 'Epp', 4, 17, 1524, NULL, 2377, 593, 1),
(4265, 2021, '4265', '2021-05-01', NULL, NULL, 'Epp', 4, 17, 1524, NULL, 2377, 593, 2),
(4266, 2021, '4266', '2021-05-02', NULL, NULL, 'Epp', 4, 17, 1524, NULL, 2377, 593, 1),
(4267, 2021, '4267', '2021-05-02', NULL, NULL, 'Epp', 4, 17, 1524, NULL, 2377, 593, 2),
(4268, 2021, '4268', '2021-05-05', NULL, NULL, 'Epp', 4, 18, 1524, NULL, 2374, 593, 1),
(4269, 2021, '4269', '2021-05-05', NULL, NULL, 'Epp', 4, 18, 1524, NULL, 2374, 593, 2),
(4270, 2021, '4270', '2021-05-04', NULL, NULL, 'Vérification des Retour Terrain', 4, 18, 1509, NULL, 2246, 601, 1),
(4271, 2021, '4271', '2021-05-04', NULL, NULL, 'Vérification des Retour Terrain', 4, 18, 1509, NULL, 2246, 601, 2),
(4273, 2021, '4273', '2021-05-05', NULL, NULL, 'APD GC + Poteaux', 4, 18, 1416, NULL, 2404, 601, 1),
(4275, 2021, '4275', '2021-05-05', NULL, NULL, 'Reprise', 4, 18, 1513, NULL, 2377, 598, 1),
(4279, 2021, '4279', '2021-05-05', NULL, NULL, 'Reprise', 4, 18, 1499, NULL, 2393, 601, 2),
(4280, 2021, '4280', '2021-05-05', NULL, NULL, 'Vérification +dépose', 4, 18, 1443, NULL, 2579, 589, 1),
(4281, 2021, '4281', '2021-05-05', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2330, 596, 1),
(4284, 2021, '4284', '2021-05-05', NULL, NULL, 'Réalisation', 4, 18, 1457, NULL, 3083, 589, 3),
(4285, 2021, '4285', '2021-05-05', NULL, NULL, 'Vérification des Retour Terrain', 4, 18, 1509, NULL, 2375, 598, 2),
(4286, 2021, '4286', '2021-05-05', NULL, NULL, 'Conception des câbles', 4, 18, 1497, NULL, 2420, 599, 2),
(4296, 2021, '4296', '2021-05-05', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2377, 596, 2),
(4297, 2021, '4297', '2021-05-05', NULL, NULL, 'Formation', 4, 18, 1526, NULL, 2461, 588, 1),
(4300, 2021, '4300', '2021-05-05', NULL, NULL, 'Réalisation shp', 4, 18, 1453, NULL, 3084, 588, 2),
(4303, 2021, '4303', '2021-05-05', NULL, NULL, 'Modification de dossier', 4, 18, 1590, NULL, 2356, 582, 1),
(4304, 2021, '4304', '2021-05-05', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2377, 582, 2),
(4305, 2021, '4305', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2347, 566, 1),
(4306, 2021, '4306', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2347, 566, 2),
(4307, 2021, '4307', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2378, 577, 1),
(4308, 2021, '4308', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2378, 577, 2),
(4309, 2021, '4309', '2021-05-05', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2545, 572, 1),
(4310, 2021, '4310', '2021-05-05', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2545, 572, 2),
(4313, 2021, '4313', '2021-05-05', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 1),
(4314, 2021, '4314', '2021-05-05', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 2),
(4315, 2021, '4315', '2021-05-05', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2378, 573, 1),
(4316, 2021, '4316', '2021-05-05', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2378, 573, 2),
(4317, 2021, '4317', '2021-05-05', NULL, NULL, 'Contrôle Etude', 4, 18, 1548, NULL, 2390, 571, 1),
(4318, 2021, '4318', '2021-05-05', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2347, 567, 1),
(4319, 2021, '4319', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2392, 571, 2),
(4320, 2021, '4320', '2021-05-05', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2347, 567, 2),
(4321, 2021, '4321', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2415, 590, 1),
(4322, 2021, '4322', '2021-05-05', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2415, 590, 2),
(4323, 2021, '4323', '2021-05-05', NULL, NULL, 'APDGC Poteaux', 4, 18, 962, NULL, 2346, 567, 1),
(4324, 2021, '4324', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2346, 567, 2),
(4327, 2021, '4327', '2021-05-06', NULL, NULL, 'Vérification +dépose', 4, 18, 1443, NULL, 2545, 589, 1),
(4328, 2021, '4328', '2021-05-06', NULL, NULL, 'Contôle et dépose', 4, 18, 1455, NULL, 2267, 589, 3),
(4334, 2021, '4334', '2021-05-06', NULL, NULL, 'Réalisation SIOREC', 4, 18, 1511, NULL, 2376, 598, 1),
(4335, 2021, '4335', '2021-05-06', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2378, 573, 1),
(4336, 2021, '4336', '2021-05-06', NULL, NULL, 'Réalisation des C3A', 4, 18, 1553, NULL, 2374, 573, 2),
(4337, 2021, '4337', '2021-05-06', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2347, 567, 1),
(4338, 2021, '4338', '2021-05-06', NULL, NULL, 'Contrôle DFT', 4, 18, 1561, NULL, 2341, 567, 2),
(4342, 2021, '4342', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2367, 577, 1),
(4343, 2021, '4343', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2346, 577, 2),
(4379, 2021, '4379', '2021-05-06', NULL, NULL, 'Préparation des SHAPES', 4, 18, 1546, NULL, 2513, 588, 2),
(4345, 2021, '4345', '2021-05-05', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 1),
(4346, 2021, '4346', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2390, 590, 1),
(4347, 2021, '4347', '2021-05-05', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 570, 2),
(4348, 2021, '4348', '2021-05-06', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2475, 572, 1),
(4349, 2021, '4349', '2021-05-06', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2390, 590, 2),
(4350, 2021, '4350', '2021-05-06', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2347, 570, 1),
(4351, 2021, '4351', '2021-05-06', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2475, 572, 2),
(4352, 2021, '4352', '2021-05-06', NULL, NULL, 'Contrôle C6', 4, 18, 1556, NULL, 2347, 570, 2),
(4353, 2021, '4353', '2021-05-05', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 1),
(4354, 2021, '4354', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2394, 571, 1),
(4355, 2021, '4355', '2021-05-06', NULL, NULL, 'E-plan', 4, 18, 1583, NULL, 2394, 571, 2),
(4356, 2021, '4356', '2021-05-05', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 2),
(4357, 2021, '4357', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2378, 576, 1),
(4358, 2021, '4358', '2021-05-06', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 1),
(4359, 2021, '4359', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2378, 576, 2),
(4360, 2021, '4360', '2021-05-06', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 1),
(4361, 2021, '4361', '2021-05-06', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2360, 578, 2),
(4363, 2021, '4363', '2021-05-06', NULL, NULL, 'Reprise C6', 4, 18, 1555, NULL, 2347, 568, 2),
(4364, 2021, '4364', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2345, 576, 1),
(4365, 2021, '4365', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2345, 576, 2),
(4371, 2021, '4371', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2367, 575, 2),
(4370, 2021, '4370', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2367, 575, 1),
(4372, 2021, '4372', '2021-05-05', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2378, 574, 2),
(4373, 2021, '4373', '2021-05-05', NULL, NULL, 'Suivi des Relevé+control', 4, 18, 959, NULL, 2189, 574, 1),
(4374, 2021, '4374', '2021-05-06', NULL, NULL, 'Contrôle Etude', 4, 18, 1548, NULL, 2360, 574, 1),
(4375, 2021, '4375', '2021-05-06', NULL, NULL, 'Calcul COMAC ', 4, 18, 960, NULL, 2345, 575, 1),
(4376, 2021, '4376', '2021-05-06', NULL, NULL, 'Contrôle Etude', 4, 18, 1548, NULL, 2345, 574, 2),
(4377, 2021, '4377', '2021-05-06', NULL, NULL, 'Plan Autocad', 4, 18, 961, NULL, 2345, 575, 2),
(4378, 2021, '4378', '2021-05-06', NULL, NULL, 'Réalisation C3A si simple', 4, 18, 1452, NULL, 2513, 588, 1),
(4380, 2021, '4380', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2347, 566, 1),
(4381, 2021, '4381', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2345, 566, 2),
(4382, 2021, '4382', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2401, NULL, 1),
(4383, 2021, '4383', '2021-05-03', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2415, NULL, 2),
(4384, 2021, '4384', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2392, NULL, 1),
(4385, 2021, '4385', '2021-05-04', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2401, NULL, 2),
(4386, 2021, '4386', '2021-05-06', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2367, NULL, 1),
(4387, 2021, '4387', '2021-05-05', NULL, NULL, 'Reprise Etude', 4, 18, 1547, NULL, 2367, NULL, 2),
(4397, 2021, '4397', '2021-05-06', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2377, 596, 1),
(4398, 2021, '4398', '2021-05-06', NULL, NULL, 'Avancement', 4, 18, 1540, NULL, 2335, 582, 2),
(4399, 2021, '4399', '2021-05-06', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2338, 596, 1),
(4400, 2021, '4400', '2021-05-06', NULL, NULL, 'Contrôle', 4, 18, 1522, NULL, 2366, 593, 1),
(4401, 2021, '4401', '2021-05-06', NULL, NULL, 'Contrôle', 4, 18, 1522, NULL, 2366, 593, 2),
(4406, 2021, '4406', '2021-05-06', NULL, NULL, 'Réalisation SIOREC', 4, 18, 1511, NULL, 2376, 598, 2),
(4407, 2021, '4407', '2021-05-06', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2246, 601, 1),
(4408, 2021, '4408', '2021-05-06', NULL, NULL, 'Vérification', 4, 18, 1512, NULL, 2402, 601, 2),
(4411, 2021, '4411', '2021-05-06', '2021-05-06 00:00:00', NULL, 'Conception des câbles', 4, 18, 1497, 653, 2420, 599, 1),
(4412, 2021, '4412', '2021-05-06', NULL, NULL, 'Conception des câbles', 4, 18, 1497, NULL, 2420, 599, 2),
(4416, 2021, '4416', '2021-05-07', NULL, NULL, 'Réalisation de dossier', 4, 18, 1538, NULL, 2328, 596, 1),
(4417, 2021, '4417', '2021-05-07', NULL, NULL, 'Réalisation de fichier FAC', 4, 18, 1582, NULL, 2377, 596, 2),
(4420, 2021, '4420', '2021-05-07', '2021-05-07 00:00:00', 'cablage', 'Conception des câbles', 4, 18, 1405, 62, 2420, 599, 1),
(4421, 2021, '4421', '2021-05-07', '2021-05-07 00:00:00', NULL, 'Vérification des DE(PIT,Gespot,Enedis,Fiche preco,Rbal+APS TR)', 4, 18, 1493, 61, 2382, 599, 2),
(4424, 2021, '4424', '2021-05-07', NULL, NULL, 'Réalisation des C3A', 4, 18, 1553, NULL, 2377, 573, 1),
(4425, 2021, '4425', '2021-05-07', NULL, NULL, 'Calcul CAPFT', 4, 18, 1552, NULL, 2189, 573, 2),
(4426, 2021, '4426', '2021-05-07', NULL, NULL, 'Vérification des Retour Terrain', 4, 18, 1509, NULL, 2411, 601, 1),
(4427, 2021, '4427', '2021-05-07', NULL, NULL, 'Vérification des Retour Terrain', 4, 18, 1509, NULL, 2411, 601, 2),
(4428, 2021, '4428', '2021-05-07', NULL, NULL, 'Réalisation SIOREC', 4, 18, 1511, NULL, 2376, 598, 1),
(4433, 2021, '4433', '2021-05-07', NULL, NULL, 'Conception des Supports', 4, 18, 1495, NULL, 2381, 598, 2),
(2, NULL, '2', '2021-06-14', '2021-06-23 00:00:00', 'testCollabCreateTache', 'testCollabCreateTache', NULL, NULL, 960, 61, 2370, NULL, 2),
(3, NULL, '3', '2021-06-14', '2021-06-24 00:00:00', 'testCollabCreateTache success', 'Tache collaborateur', NULL, NULL, 1405, 60, 2382, 599, 2),
(14, NULL, '14', '2021-06-08', '2021-06-23 00:00:00', 'tache CE1 1', 'tache CE1 1', NULL, NULL, 1405, 60, 4, 9, 2),
(15, NULL, '15', '2021-06-09', '2021-06-23 00:00:00', 'tache CE1 2', 'tache CE1 2', NULL, NULL, 1404, 61, 4, 13, 2),
(33, 2021, '33', '2021-06-10', '2021-06-10 00:00:00', 'tacheAdmin1', 'integration', 3, 4, 1424, 653, 2422, 570, 1),
(36, NULL, 'testAdminP', '2021-06-03', '2021-06-03 00:00:00', 'new', 'nouveau', NULL, NULL, 954, 60, 2191, 7, 1),
(37, NULL, 'po090', '2021-06-10', '2021-06-10 00:00:00', 'test', 'test', NULL, NULL, 1423, 60, 2422, 572, 1),
(53, NULL, 'orororppp', '2021-06-21', '2021-06-21 00:00:00', 'orororppp', 'nouvelle', NULL, NULL, 1425, 61, 2422, 569, 1),
(91, 2021, 'tt1', '2021-06-23', '2021-06-23 00:00:00', 'tt1', 'tt1', 6, 7, 1426, NULL, 2416, 13, 2),
(92, 77, 'analyse1', '2021-06-28', '2021-06-28 00:00:00', 'analyse 1', 'Analyse', 99, 99, 1442, 62, 2419, 10, 2),
(128, 12, 't1', '2021-07-16', '2021-07-16 00:00:00', NULL, 'tache 1', 1, 4, 960, 62, 127, 567, 1);

-- --------------------------------------------------------

--
-- Structure de la table `type_paiement`
--

DROP TABLE IF EXISTS `type_paiement`;
CREATE TABLE IF NOT EXISTS `type_paiement` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_paiement`
--

INSERT INTO `type_paiement` (`id`, `code`, `libelle`, `reference`) VALUES
(1, '1', 'Virement', '1'),
(2, '2', 'Carte bancaire', '2'),
(3, '3', 'Chèque', '3'),
(4, '4', 'Paypal', '4');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `blocked` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `must_change_password` bit(1) NOT NULL,
  `nbr_cnx` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `propritie` varchar(255) DEFAULT NULL,
  `agence` bigint(20) DEFAULT NULL,
  `categorie_collaborateur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpj611k2w0vu0pcapt36r5w3pb` (`agence`),
  KEY `FK2svxucqo2b1bj2216g5tp0gqu` (`categorie_collaborateur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`dtype`, `id`, `blocked`, `code`, `email`, `login`, `must_change_password`, `nbr_cnx`, `nom`, `password`, `phone`, `prenom`, `propritie`, `agence`, `categorie_collaborateur`) VALUES
('admin', 3, b'0', '3', 'aymane.malih.pro@gmail.com', 'admin', b'1', 3, 'Zouani', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '0628902181', 'Youness', NULL, NULL, NULL),
('collaborateur', 452, b'0', '452', '', 'malhabi@maneo.com', b'1', 3, 'Malhabi', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Houria', NULL, 4, NULL),
('collaborateur', 519, b'0', '519', '', 'mssiliq@maneo.com', b'1', 3, 'MSSILIQ', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Chaima', NULL, 4, NULL),
('collaborateur', 520, b'0', '520', '', 'anzid@maneo.com', b'1', 3, 'ANZid', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Yassir', NULL, 4, NULL),
('collaborateur', 521, b'0', '521', '', 'sayout@maneo.com', b'1', 3, 'SAYOUT', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Mohamed', NULL, 4, NULL),
('collaborateur', 522, b'0', '522', '', 'edderrabi@maneo.com', b'1', 3, 'EDDERRABI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Mohamed', NULL, 4, NULL),
('collaborateur', 523, b'0', '523', '', 'el ouahabi@maneo.com', b'1', 3, 'EL OUAHABI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Zakaria', NULL, 4, NULL),
('collaborateur', 524, b'0', '524', '', 'lahbil@maneo.com', b'1', 3, 'LAHBIL', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Houda', NULL, 4, NULL),
('collaborateur', 525, b'0', '525', '', 'nimali@maneo.com', b'1', 3, 'NIMALI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Oumaima', NULL, 4, NULL),
('collaborateur', 526, b'0', '526', '', 'tour kmani@maneo.com', b'1', 3, 'TOUR KMANI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Abdellah', NULL, 4, NULL),
('collaborateur', 527, b'0', '527', '', 'akabli@maneo.com', b'1', 3, 'AKABLI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Chaima', NULL, 4, NULL),
('collaborateur', 528, b'0', '528', '', 'kharroubi@maneo.com', b'1', 3, 'KHARROUBI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Hassna', NULL, 4, NULL),
('collaborateur', 529, b'0', '529', 'saha@maneo.com', 'saha@maneo.com', b'1', 3, 'SAHA', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Omar', NULL, 4, NULL),
('collaborateur', 530, b'0', '530', '', 'ouaddah@maneo.com', b'1', 3, 'OUADDAH', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Badr', NULL, 4, NULL),
('collaborateur', 531, b'0', '531', '', 'haddi@maneo.com', b'1', 3, 'HADDI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Soumia', NULL, 4, NULL),
('collaborateur', 532, b'0', '532', '', 'ait sghir@maneo.com', b'1', 3, 'AIT SGHIR', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Soufiane', NULL, 4, NULL),
('collaborateur', 533, b'0', '533', '', 'aabida@maneo.com', b'1', 3, 'AABidA', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Nezha', NULL, 4, NULL),
('collaborateur', 534, b'0', '534', '', 'bakoye@maneo.com', b'1', 3, 'BAKOYE', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Bachir', NULL, 4, NULL),
('collaborateur', 535, b'0', '535', '', 'laghrini@maneo.com', b'1', 3, 'LAGHRINI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Brahim', NULL, 4, NULL),
('collaborateur', 536, b'0', '536', '', 'benkhye@maneo.com', b'1', 3, 'BENKHYE', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Mohamed Ali', NULL, 4, NULL),
('collaborateur', 537, b'0', '537', '', 'boudhar@maneo.com', b'1', 3, 'BOUDHAR', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Soukayna', NULL, 4, NULL),
('collaborateur', 538, b'0', '538', '', 'boukdir@maneo.com', b'1', 3, 'BOUKDIR', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Touriya', NULL, 4, NULL),
('collaborateur', 539, b'0', '539', '', 'tahiri@maneo.com', b'1', 3, 'TAHIRI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Fatima Ezzahra', NULL, 4, NULL),
('collaborateur', 540, b'0', '540', '', 'ouhsain@maneo.com', b'1', 3, 'OUHSAIN', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Asma', NULL, 4, NULL),
('collaborateur', 541, b'0', '541', '', 'sisti@maneo.com', b'1', 3, 'SISTI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Najoua', NULL, 4, NULL),
('collaborateur', 542, b'0', '542', '', 'ouchene@maneo.com', b'1', 3, 'OUCHENE', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Imane', NULL, 4, NULL),
('collaborateur', 543, b'0', '543', '', 'louiza@maneo.com', b'1', 3, 'LOUIZA', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Imane', NULL, 4, NULL),
('collaborateur', 544, b'0', '544', '', 'soukarabi@maneo.com', b'1', 3, 'SOUKARABI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Mamouden', NULL, 4, NULL),
('collaborateur', 545, b'0', '545', '', 'ajakane@maneo.com', b'1', 3, 'AJAKANE', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Ibtissam', NULL, 4, NULL),
('collaborateur', 546, b'0', '546', '', 'aboumalk@maneo.com', b'1', 3, 'ABOUMALK', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Sara', NULL, 4, NULL),
('collaborateur', 547, b'0', '547', '', 'baba@maneo.com', b'1', 3, 'BABA', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Chaima', NULL, 4, NULL),
('collaborateur', 548, b'0', '548', '', 'laassilia@maneo.com', b'1', 3, 'LAASSILIA', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Zaynab', NULL, 4, NULL),
('collaborateur', 549, b'0', '549', '', 'ngakoutou assalbaye@maneo.com', b'1', 3, 'NGAKOUTOU ASSALBAYE', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Adelphe', NULL, 4, NULL),
('collaborateur', 602, b'0', '602', '', 'ghanou@maneo.com', b'1', 3, 'GHANOU', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Yassine', NULL, 4, NULL),
('collaborateur', 840, b'0', '840', '', 'coustheur @maneo.com', b'1', 0, 'COUSTHEUR ', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Stéphane', NULL, 4, NULL),
('collaborateur', 905, b'0', '905', '', 'sandouk@maneo.com', b'1', 0, 'SANDOUK', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', NULL, 'Mohamed', NULL, 4, NULL),
('collaborateur', 906, b'1', '906', '', 'halouali@maneo.com', b'1', 0, 'HALOUALI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'fatima zahra', NULL, 4, NULL),
('collaborateur', 908, b'0', '908', '', 'zbiri@maneo.com', b'1', 0, 'ZBIRI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Oumaima', NULL, 4, NULL),
('collaborateur', 909, b'1', '909', '', 'amnabhi@maneo.com', b'1', 0, 'AMNABHI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Imane', NULL, 4, NULL),
('collaborateur', 910, b'0', '910', '', 'el houdzi@maneo.com', b'1', 0, 'EL HOUDZI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'aya', NULL, 4, NULL),
('collaborateur', 912, b'0', '912', '', 'el riahi@maneo.com', b'1', 0, 'El RIAHI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Hind', NULL, 4, NULL),
('collaborateur', 913, b'0', '913', '', 'gharnati@maneo.com', b'1', 0, 'GHARNATI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'Nouhaila', NULL, 4, NULL),
('collaborateur', 914, b'0', '914', '', 'yassine', b'0', 3, 'ghanou', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '', 'yassine', NULL, 4, NULL),
('collaborateur', 3000, b'0', 'aymane13:01', 'aymane.malih.pro@gmail.com', 'aymane', b'0', 0, 'aymane', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '0628902181', 'malih', NULL, 4, NULL),
('chef-agence', 4, b'0', '4', 'zouani@gmail.com', 'prof', b'1', 3, 'ZOUANI', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '0628902181', 'Youness', NULL, NULL, NULL),
('chef-agence', 8, b'0', '8', 'aymane.malih@edu.uca.ma', 'chef', b'1', 3, 'MALIH', '$2a$10$xkmc9SGM7IUxVY2P1pG6MOyP58ehPpgyhToGN1wzGBYFpqpfMq/.e', '0628902181', 'Aziz', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(3, 1),
(4, 3),
(5, 1),
(6, 1),
(7, 1),
(452, 2),
(519, 2),
(520, 2),
(520, 9),
(521, 2),
(521, 9),
(522, 2),
(523, 2),
(523, 9),
(524, 2),
(524, 9),
(525, 2),
(526, 2),
(526, 9),
(527, 2),
(527, 9),
(528, 2),
(529, 2),
(530, 2),
(531, 2),
(532, 2),
(533, 2),
(534, 2),
(535, 2),
(536, 2),
(537, 2),
(538, 2),
(539, 2),
(540, 2),
(541, 2),
(542, 2),
(543, 2),
(544, 2),
(545, 2),
(546, 2),
(546, 9),
(547, 2),
(548, 2),
(549, 2),
(602, 2),
(840, 2),
(905, 2),
(906, 2),
(908, 2),
(909, 2),
(909, 9),
(910, 2),
(910, 9),
(912, 2),
(912, 9),
(913, 2),
(913, 9),
(914, 2),
(3000, 2),
(3000, 9);

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `pays` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKak9ie48cys2iu74xk09k7mi23` (`pays`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`id`, `code`, `libelle`, `pays`) VALUES
(2805, '22402', 'Ouaouizeght', 2001),
(280502, '40000', 'Marrakech', 2001);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
