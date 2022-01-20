CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banka`
--

DROP TABLE IF EXISTS `banka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `banka` (
  `SifraBanke` char(3) NOT NULL,
  `NazivBanke` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SifraBanke`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `budzetska_organizacija`
--

DROP TABLE IF EXISTS `budzetska_organizacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `budzetska_organizacija` (
  `Sifra` char(7) NOT NULL,
  PRIMARY KEY (`Sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `isplata`
--

DROP TABLE IF EXISTS `isplata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `isplata` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  `Datum` date NOT NULL,
  `UlaznaFakturaId` int(11) NOT NULL,
  `BrojDokumenta` varchar(45) DEFAULT NULL,
  `Iznos` decimal(10,2) NOT NULL DEFAULT '0.00',
  `Opis` varchar(45) DEFAULT NULL,
  `SifraBanke` char(3) NOT NULL,
  `IdTipaTroska` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_KNJIGA_RASHODA_TIP_TROSKA1_idx` (`IdTipaTroska`),
  KEY `fk_KNJIGA_RASHODA_KUF1_idx` (`UlaznaFakturaId`),
  KEY `fk_ISPLATA_SAMOSTALNI_PREDUZETNIK1_idx` (`SamostalniPreduzetnikJIB`),
  KEY `fk_ISPLATA_KOMITENT1_idx` (`KomitentJIB`),
  KEY `fk_ISPLATA_BANKA1_idx` (`SifraBanke`),
  CONSTRAINT `fk_ISPLATA_BANKA1` FOREIGN KEY (`SifraBanke`) REFERENCES `banka` (`sifrabanke`),
  CONSTRAINT `fk_ISPLATA_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`),
  CONSTRAINT `fk_ISPLATA_SAMOSTALNI_PREDUZETNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_KNJIGA_RASHODA_KUF1` FOREIGN KEY (`UlaznaFakturaId`) REFERENCES `ulazna_faktura` (`id`),
  CONSTRAINT `fk_KNJIGA_RASHODA_TIP_TROSKA1` FOREIGN KEY (`IdTipaTroska`) REFERENCES `tip_troska` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `izlazna_faktura`
--

DROP TABLE IF EXISTS `izlazna_faktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `izlazna_faktura` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `NazivFakture` varchar(45) NOT NULL,
  `Datum` date NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  `IznosFakture` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IznosVanposlovneSvrhe` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IznosIzvoza` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IznosOstalo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `OsnovicaZaPDV` decimal(10,2) NOT NULL DEFAULT '0.00',
  `UkupniPDV` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IdTipaPrihoda` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_KIF_SAMOSTALNI_PREDUZETNIK1_idx` (`SamostalniPreduzetnikJIB`),
  KEY `fk_KIF_TIP_PRIHODA1_idx` (`IdTipaPrihoda`),
  KEY `fk_IZLAZNA_FAKTURA_KOMITENT1_idx` (`KomitentJIB`),
  CONSTRAINT `fk_IZLAZNA_FAKTURA_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`),
  CONSTRAINT `fk_KIF_PORESKI_OBVEZNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_KIF_TIP_PRIHODA1` FOREIGN KEY (`IdTipaPrihoda`) REFERENCES `tip_prihoda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `izlazna_faktura_view`
--

DROP TABLE IF EXISTS `izlazna_faktura_view`;
/*!50001 DROP VIEW IF EXISTS `izlazna_faktura_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `izlazna_faktura_view` AS SELECT 
 1 AS `id`,
 1 AS `SamostalniPreduzetnikJIB`,
 1 AS `nazivsp`,
 1 AS `nazivfakture`,
 1 AS `datum`,
 1 AS `nazivk`,
 1 AS `KomitentJIB`,
 1 AS `IznosFakture`,
 1 AS `IznosVanposlovneSvrhe`,
 1 AS `IznosIzvoza`,
 1 AS `OsnovicaZaPDV`,
 1 AS `UkupniPDV`,
 1 AS `IdTipaPrihoda`,
 1 AS `nazivt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `komitent`
--

DROP TABLE IF EXISTS `komitent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `komitent` (
  `JIB` char(13) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  `PDVsistem` tinyint(4) DEFAULT NULL,
  `Adresa` varchar(45) DEFAULT NULL,
  `PostanskiBroj` char(5) NOT NULL,
  PRIMARY KEY (`JIB`),
  KEY `fk_KOMITENT_MJESTO1_idx` (`PostanskiBroj`),
  CONSTRAINT `fk_KOMITENT_MJESTO1` FOREIGN KEY (`PostanskiBroj`) REFERENCES `mjesto` (`postanskibroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `komitent_view`
--

DROP TABLE IF EXISTS `komitent_view`;
/*!50001 DROP VIEW IF EXISTS `komitent_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `komitent_view` AS SELECT 
 1 AS `jib`,
 1 AS `nazivKomitenta`,
 1 AS `PDVsistem`,
 1 AS `Adresa`,
 1 AS `Mjesto`,
 1 AS `PostanskiBroj`,
 1 AS `BrojTelefona`,
 1 AS `BrojRacunaKomitenta`,
 1 AS `SifraBankeKomitenta`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `mjesto`
--

DROP TABLE IF EXISTS `mjesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mjesto` (
  `PostanskiBroj` char(5) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PostanskiBroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `opstina`
--

DROP TABLE IF EXISTS `opstina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `opstina` (
  `Sifra` char(3) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `plata_obracun`
--

DROP TABLE IF EXISTS `plata_obracun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plata_obracun` (
  `IdPlata` int(11) NOT NULL,
  `JMB` char(13) NOT NULL,
  `PeriodOd` date DEFAULT NULL,
  `PeriodDo` date DEFAULT NULL,
  `NetoPlata` decimal(10,2) DEFAULT NULL,
  `Doprinosi` decimal(10,2) DEFAULT NULL,
  `BrutoPlata` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`IdPlata`),
  KEY `fk_PLATA_OBRACUN_RADNIK1_idx` (`JMB`),
  CONSTRAINT `fk_PLATA_OBRACUN_RADNIK1` FOREIGN KEY (`JMB`) REFERENCES `radnik` (`jmb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `radnik` (
  `JMB` char(13) NOT NULL,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  `Adresa` varchar(45) DEFAULT NULL,
  `PostanskiBroj` char(5) NOT NULL,
  `IdStrucneSpreme` int(11) NOT NULL,
  PRIMARY KEY (`JMB`),
  KEY `fk_ZAPOSLENIK_MJESTO1_idx` (`PostanskiBroj`),
  KEY `fk_RADNIK_STRUCNA_SPREMA1_idx` (`IdStrucneSpreme`),
  CONSTRAINT `fk_RADNIK_STRUCNA_SPREMA1` FOREIGN KEY (`IdStrucneSpreme`) REFERENCES `strucna_sprema` (`idstrucnespreme`),
  CONSTRAINT `fk_ZAPOSLENIK_MJESTO1` FOREIGN KEY (`PostanskiBroj`) REFERENCES `mjesto` (`postanskibroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `radno_mjesto`
--

DROP TABLE IF EXISTS `radno_mjesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `radno_mjesto` (
  `IdRadnogMjesta` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdRadnogMjesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `samostalni_preduzetnik`
--

DROP TABLE IF EXISTS `samostalni_preduzetnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `samostalni_preduzetnik` (
  `JIB` char(13) NOT NULL,
  `Naziv` varchar(45) NOT NULL,
  `SjedisteFirme` varchar(45) DEFAULT NULL,
  `SifraDjelatnosti` varchar(45) DEFAULT NULL,
  `NazivDjelatnosti` varchar(45) DEFAULT NULL,
  `JMB` char(13) NOT NULL,
  `Ime` varchar(45) DEFAULT NULL,
  `Prezime` varchar(45) DEFAULT NULL,
  `Adresa` varchar(45) DEFAULT NULL,
  `PostanskiBroj` char(5) NOT NULL,
  PRIMARY KEY (`JIB`),
  KEY `fk_SAMOSTALNI_PREDUZETNIK_MJESTO1_idx` (`PostanskiBroj`),
  CONSTRAINT `fk_SAMOSTALNI_PREDUZETNIK_MJESTO1` FOREIGN KEY (`PostanskiBroj`) REFERENCES `mjesto` (`postanskibroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `samostalni_preduzetnik_ima_komitent`
--

DROP TABLE IF EXISTS `samostalni_preduzetnik_ima_komitent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `samostalni_preduzetnik_ima_komitent` (
  `IdTipa` int(11) NOT NULL,
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  PRIMARY KEY (`SamostalniPreduzetnikJIB`,`KomitentJIB`,`IdTipa`),
  KEY `fk_PORESKI_OBVEZNIK_has_KOMITENT_TIP_KOMITENTA1_idx` (`IdTipa`),
  KEY `fk_SAMOSTALNI_PREDUZETNIK_ima_KOMITENT_KOMITENT1_idx` (`KomitentJIB`),
  CONSTRAINT `fk_PORESKI_OBVEZNIK_has_KOMITENT_TIP_KOMITENTA1` FOREIGN KEY (`IdTipa`) REFERENCES `tip_komitenta` (`idtipa`),
  CONSTRAINT `fk_SAMOSTALNI_PREDUZETNIK_ima_KOMITENT_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`),
  CONSTRAINT `fk_SAMOSTALNNI_PREDUZETNIK_ima_KOMITENT_SAMOSTALNI_PREDUZETNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `sp`
--

DROP TABLE IF EXISTS `sp`;
/*!50001 DROP VIEW IF EXISTS `sp`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `sp` AS SELECT 
 1 AS `jib`,
 1 AS `naziv`,
 1 AS `sjedisteFirme`,
 1 AS `sifraDjelatnosti`,
 1 AS `nazivDjelatnosti`,
 1 AS `jmb`,
 1 AS `ime`,
 1 AS `prezime`,
 1 AS `adresa`,
 1 AS `postanskiBroj`,
 1 AS `brojRacuna`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `sp_komitent_view`
--

DROP TABLE IF EXISTS `sp_komitent_view`;
/*!50001 DROP VIEW IF EXISTS `sp_komitent_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `sp_komitent_view` AS SELECT 
 1 AS `JIBSamostalnogPreduzetnika`,
 1 AS `NazivSP`,
 1 AS `NazivTipaKomitenta`,
 1 AS `JIBkomitenta`,
 1 AS `NazivKomitenta`,
 1 AS `PDVsistem`,
 1 AS `Adresa`,
 1 AS `Mjesto`,
 1 AS `brojTelefona`,
 1 AS `BrojRacuna`,
 1 AS `SifraBanke`,
 1 AS `Saldo`,
 1 AS `Potrazuje`,
 1 AS `Duguje`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `sp_view`
--

DROP TABLE IF EXISTS `sp_view`;
/*!50001 DROP VIEW IF EXISTS `sp_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `sp_view` AS SELECT 
 1 AS `jib`,
 1 AS `naziv`,
 1 AS `sjedisteFirme`,
 1 AS `sifraDjelatnosti`,
 1 AS `nazivDjelatnosti`,
 1 AS `jmb`,
 1 AS `ime`,
 1 AS `prezime`,
 1 AS `adresa`,
 1 AS `postanskiBroj`,
 1 AS `brojRacuna`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `stanje_komitenta`
--

DROP TABLE IF EXISTS `stanje_komitenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stanje_komitenta` (
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  `Duguje` decimal(10,2) NOT NULL DEFAULT '0.00',
  `Potrazuje` decimal(10,2) NOT NULL DEFAULT '0.00',
  `Saldo` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`SamostalniPreduzetnikJIB`,`KomitentJIB`),
  KEY `fk_STANJE_KOMITENTA_SAMOSTALNI_PREDUZETNIK1_idx` (`SamostalniPreduzetnikJIB`),
  KEY `fk_STANJE_KOMITENTA_KOMITENT1_idx` (`KomitentJIB`),
  CONSTRAINT `fk_STANJE_KOMITENTA_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`),
  CONSTRAINT `fk_STANJE_KOMITENTA_SAMOSTALNI_PREDUZETNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status_ugovora`
--

DROP TABLE IF EXISTS `status_ugovora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status_ugovora` (
  `IdStatusa` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdStatusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `strucna_sprema`
--

DROP TABLE IF EXISTS `strucna_sprema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `strucna_sprema` (
  `IdStrucneSpreme` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdStrucneSpreme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefon_komitenta`
--

DROP TABLE IF EXISTS `telefon_komitenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `telefon_komitenta` (
  `BrojTelefona` char(13) NOT NULL,
  `JIB` char(13) NOT NULL,
  PRIMARY KEY (`BrojTelefona`),
  KEY `fk_TELEFON_KOMITENTA_KOMITENT1_idx` (`JIB`),
  CONSTRAINT `fk_TELEFON_KOMITENTA_KOMITENT1` FOREIGN KEY (`JIB`) REFERENCES `komitent` (`jib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefon_radnika`
--

DROP TABLE IF EXISTS `telefon_radnika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `telefon_radnika` (
  `BrojTelefona` char(13) NOT NULL,
  `JMB` char(13) NOT NULL,
  PRIMARY KEY (`BrojTelefona`),
  KEY `fk_TELEFON_RADNIKA_RADNIK1_idx` (`JMB`),
  CONSTRAINT `fk_TELEFON_RADNIKA_RADNIK1` FOREIGN KEY (`JMB`) REFERENCES `radnik` (`jmb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefon_sp`
--

DROP TABLE IF EXISTS `telefon_sp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `telefon_sp` (
  `BrojTelefona` char(13) NOT NULL,
  `JIB` char(13) NOT NULL,
  PRIMARY KEY (`BrojTelefona`),
  KEY `fk_TELEFON_SAMOSTALNI_PREDUZETNIK1_idx` (`JIB`),
  CONSTRAINT `fk_TELEFON_SAMOSTALNI_PREDUZETNIK1` FOREIGN KEY (`JIB`) REFERENCES `samostalni_preduzetnik` (`jib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tip_komitenta`
--

DROP TABLE IF EXISTS `tip_komitenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tip_komitenta` (
  `IdTipa` int(11) NOT NULL AUTO_INCREMENT,
  `NazivTipa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdTipa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tip_prihoda`
--

DROP TABLE IF EXISTS `tip_prihoda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tip_prihoda` (
  `Id` int(11) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tip_troska`
--

DROP TABLE IF EXISTS `tip_troska`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tip_troska` (
  `Id` int(11) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ugovor_o_radu`
--

DROP TABLE IF EXISTS `ugovor_o_radu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ugovor_o_radu` (
  `BrojUgovora` varchar(10) NOT NULL,
  `JIB` char(13) NOT NULL,
  `JMB` char(13) NOT NULL,
  `DatumSkapanjaUgovora` date NOT NULL,
  `VrstaUgovora` varchar(45) NOT NULL,
  `PeriodOd` date NOT NULL,
  `PeriodDo` date DEFAULT NULL,
  `RadnoVrijeme` decimal(10,2) NOT NULL,
  `Plata` decimal(10,2) NOT NULL,
  `IdRadnogMjesta` int(11) NOT NULL,
  `IdStatusa` int(11) NOT NULL,
  PRIMARY KEY (`BrojUgovora`,`JIB`),
  KEY `fk_UGOVOR_O_RADU_RADNIK1_idx` (`JMB`),
  KEY `fk_UGOVOR_O_RADU_PORESKI_OBVEZNIK1_idx` (`JIB`),
  KEY `fk_UGOVOR_O_RADU_RADNO_MJESTO1_idx` (`IdRadnogMjesta`),
  KEY `fk_UGOVOR_O_RADU_STATUS_UGOVORA1_idx` (`IdStatusa`),
  CONSTRAINT `fk_UGOVOR_O_RADU_PORESKI_OBVEZNIK1` FOREIGN KEY (`JIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_UGOVOR_O_RADU_RADNIK1` FOREIGN KEY (`JMB`) REFERENCES `radnik` (`jmb`),
  CONSTRAINT `fk_UGOVOR_O_RADU_RADNO_MJESTO1` FOREIGN KEY (`IdRadnogMjesta`) REFERENCES `radno_mjesto` (`idradnogmjesta`),
  CONSTRAINT `fk_UGOVOR_O_RADU_STATUS_UGOVORA1` FOREIGN KEY (`IdStatusa`) REFERENCES `status_ugovora` (`idstatusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ulazna_faktura`
--

DROP TABLE IF EXISTS `ulazna_faktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ulazna_faktura` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `NazivFakture` varchar(45) DEFAULT NULL,
  `Datum` date NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  `IznosBezPDV` decimal(10,2) NOT NULL DEFAULT '0.00',
  `UkupnoSaPDV` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IznosPausalneNaknade` decimal(10,2) NOT NULL DEFAULT '0.00',
  `UkupanUlazniPorez` decimal(10,2) NOT NULL DEFAULT '0.00',
  `UlazniPorezOdbitni` decimal(10,2) NOT NULL DEFAULT '0.00',
  `UlazniPorezNeodbitni` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IdTipaTroska` int(11) NOT NULL,
  `Uvoz` tinyint(4) DEFAULT NULL,
  `Gotovina` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_KUF_TIP_TROSKA1_idx` (`IdTipaTroska`),
  KEY `fk_KUF_PORESKI_OBVEZNIK1_idx` (`SamostalniPreduzetnikJIB`),
  KEY `fk_ULAZNA_FAKTURA_KOMITENT1_idx` (`KomitentJIB`),
  CONSTRAINT `fk_KUF_PORESKI_OBVEZNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_KUF_TIP_TROSKA1` FOREIGN KEY (`IdTipaTroska`) REFERENCES `tip_troska` (`id`),
  CONSTRAINT `fk_ULAZNA_FAKTURA_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `ulazna_faktura_view`
--

DROP TABLE IF EXISTS `ulazna_faktura_view`;
/*!50001 DROP VIEW IF EXISTS `ulazna_faktura_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `ulazna_faktura_view` AS SELECT 
 1 AS `id`,
 1 AS `SamostalniPreduzetnikJIB`,
 1 AS `nazivsp`,
 1 AS `nazivfakture`,
 1 AS `datum`,
 1 AS `nazivk`,
 1 AS `KomitentJIB`,
 1 AS `iznosbezpdv`,
 1 AS `ukupnosapdv`,
 1 AS `iznospausalnenaknade`,
 1 AS `ukupanulazniporez`,
 1 AS `ulazniporezodbitni`,
 1 AS `ulazniporezneodbitni`,
 1 AS `idtipatroska`,
 1 AS `naziv`,
 1 AS `uvoz`,
 1 AS `gotovina`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `uplata`
--

DROP TABLE IF EXISTS `uplata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `uplata` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SamostalniPreduzetnikJIB` char(13) NOT NULL,
  `KomitentJIB` char(13) NOT NULL,
  `Datum` date DEFAULT NULL,
  `IzlaznaFakturaId` int(11) NOT NULL,
  `BrojDokumenta` varchar(45) DEFAULT NULL,
  `Iznos` decimal(10,2) NOT NULL DEFAULT '0.00',
  `Opis` varchar(45) DEFAULT NULL,
  `SifraBanke` char(3) NOT NULL,
  `IdTipaPrihoda` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_KNJIGA_PRIHODA_TIP_PRIHODA1_idx` (`IdTipaPrihoda`),
  KEY `fk_KNJIGA_PRIHODA_PORESKI_OBVEZNIK1_idx` (`SamostalniPreduzetnikJIB`),
  KEY `fk_KNJIGA_PRIHODA_KIF1_idx` (`IzlaznaFakturaId`),
  KEY `fk_UPLATA_KOMITENT1_idx` (`KomitentJIB`),
  KEY `fk_UPLATA_BANKA1_idx` (`SifraBanke`),
  CONSTRAINT `fk_KNJIGA_PRIHODA_KIF1` FOREIGN KEY (`IzlaznaFakturaId`) REFERENCES `izlazna_faktura` (`id`),
  CONSTRAINT `fk_KNJIGA_PRIHODA_PORESKI_OBVEZNIK1` FOREIGN KEY (`SamostalniPreduzetnikJIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_KNJIGA_PRIHODA_TIP_PRIHODA1` FOREIGN KEY (`IdTipaPrihoda`) REFERENCES `tip_prihoda` (`id`),
  CONSTRAINT `fk_UPLATA_BANKA1` FOREIGN KEY (`SifraBanke`) REFERENCES `banka` (`sifrabanke`),
  CONSTRAINT `fk_UPLATA_KOMITENT1` FOREIGN KEY (`KomitentJIB`) REFERENCES `komitent` (`jib`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `uplatnica`
--

DROP TABLE IF EXISTS `uplatnica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `uplatnica` (
  `IdUplatnice` int(11) NOT NULL AUTO_INCREMENT,
  `Primalac` varchar(45) DEFAULT NULL,
  `SvrhaDoznake` varchar(45) DEFAULT NULL,
  `DatumUplate` date DEFAULT NULL,
  `PostanskiBroj` char(5) NOT NULL,
  `IznosUplate` decimal(10,2) DEFAULT NULL,
  `Hitno` tinyint(4) DEFAULT NULL,
  `VrstaUplate` char(1) DEFAULT NULL,
  `PeriodOd` date DEFAULT NULL,
  `PeriodDo` date DEFAULT NULL,
  `SifraVrstePrihoda` char(6) NOT NULL,
  `SifraOpstine` char(3) NOT NULL,
  `SifraBudzetskeOrganizacije` char(7) NOT NULL,
  `PozivNaBroj` char(10) DEFAULT NULL,
  PRIMARY KEY (`IdUplatnice`),
  KEY `fk_UPLATA_VRSTA_PRIHODA1_idx` (`SifraVrstePrihoda`),
  KEY `fk_UPLATA_OPSTINA1_idx` (`SifraOpstine`),
  KEY `fk_UPLATA_BUDZETSKA_ORGANIZACIJA1_idx` (`SifraBudzetskeOrganizacije`),
  KEY `fk_UPLATA_MJESTO1_idx` (`PostanskiBroj`),
  CONSTRAINT `fk_UPLATA_BUDZETSKA_ORGANIZACIJA1` FOREIGN KEY (`SifraBudzetskeOrganizacije`) REFERENCES `budzetska_organizacija` (`sifra`),
  CONSTRAINT `fk_UPLATA_MJESTO1` FOREIGN KEY (`PostanskiBroj`) REFERENCES `mjesto` (`postanskibroj`),
  CONSTRAINT `fk_UPLATA_OPSTINA1` FOREIGN KEY (`SifraOpstine`) REFERENCES `opstina` (`sifra`),
  CONSTRAINT `fk_UPLATA_VRSTA_PRIHODA1` FOREIGN KEY (`SifraVrstePrihoda`) REFERENCES `vrsta_prihoda` (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `uplatnica_ima_ziro_racun`
--

DROP TABLE IF EXISTS `uplatnica_ima_ziro_racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `uplatnica_ima_ziro_racun` (
  `IdUplatnice` int(11) NOT NULL,
  `BrojRacuna` char(16) NOT NULL,
  `Uloga` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdUplatnice`,`BrojRacuna`),
  KEY `fk_UPLATNICA_has_ZIRO_RACUN_ZIRO_RACUN1_idx` (`BrojRacuna`),
  KEY `fk_UPLATNICA_has_ZIRO_RACUN_UPLATNICA1_idx` (`IdUplatnice`),
  CONSTRAINT `fk_UPLATNICA_has_ZIRO_RACUN_UPLATNICA1` FOREIGN KEY (`IdUplatnice`) REFERENCES `uplatnica` (`iduplatnice`),
  CONSTRAINT `fk_UPLATNICA_has_ZIRO_RACUN_ZIRO_RACUN1` FOREIGN KEY (`BrojRacuna`) REFERENCES `ziro_racun` (`brojracuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vrsta_prihoda`
--

DROP TABLE IF EXISTS `vrsta_prihoda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vrsta_prihoda` (
  `Sifra` char(6) NOT NULL,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ziro_racun`
--

DROP TABLE IF EXISTS `ziro_racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ziro_racun` (
  `BrojRacuna` char(16) NOT NULL,
  `SifraBanke` char(3) NOT NULL,
  PRIMARY KEY (`BrojRacuna`),
  KEY `fk_ZIRO_RACUN_BANKA1_idx` (`SifraBanke`),
  CONSTRAINT `fk_ZIRO_RACUN_BANKA1` FOREIGN KEY (`SifraBanke`) REFERENCES `banka` (`sifrabanke`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ziro_racun_komitenta`
--

DROP TABLE IF EXISTS `ziro_racun_komitenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ziro_racun_komitenta` (
  `BrojRacuna` char(16) NOT NULL,
  `JIB` char(13) NOT NULL,
  PRIMARY KEY (`BrojRacuna`),
  KEY `fk_ZIRO_RACUN_KOMITENTA_KOMITENT1_idx` (`JIB`),
  CONSTRAINT `fk_ZIRO_RACUN_KOMITENTA_KOMITENT1` FOREIGN KEY (`JIB`) REFERENCES `komitent` (`jib`),
  CONSTRAINT `fk_ZIRO_RACUN_KOMITENTA_ZIRO_RACUN1` FOREIGN KEY (`BrojRacuna`) REFERENCES `ziro_racun` (`brojracuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ziro_racun_radnika`
--

DROP TABLE IF EXISTS `ziro_racun_radnika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ziro_racun_radnika` (
  `BrojRacuna` char(16) NOT NULL,
  `JMB` char(13) NOT NULL,
  PRIMARY KEY (`BrojRacuna`),
  KEY `fk_ZIRO_RACUN_RADNIKA_RADNIK1_idx` (`JMB`),
  CONSTRAINT `fk_ZIRO_RACUN_RADNIKA_RADNIK1` FOREIGN KEY (`JMB`) REFERENCES `radnik` (`jmb`),
  CONSTRAINT `fk_ZIRO_RACUN_RADNIKA_ZIRO_RACUN1` FOREIGN KEY (`BrojRacuna`) REFERENCES `ziro_racun` (`brojracuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ziro_racun_sp`
--

DROP TABLE IF EXISTS `ziro_racun_sp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ziro_racun_sp` (
  `BrojRacuna` char(16) NOT NULL,
  `JIB` char(13) NOT NULL,
  PRIMARY KEY (`BrojRacuna`),
  KEY `fk_ZIRO_RACUN_SAMOSTALNI_PREDUZETNIK1_idx` (`JIB`),
  CONSTRAINT `fk_ZIRO_RACUN_SAMOSTALNI_PREDUZETNIK1` FOREIGN KEY (`JIB`) REFERENCES `samostalni_preduzetnik` (`jib`),
  CONSTRAINT `fk_ZIRO_RACUN_SP_ZIRO_RACUN1` FOREIGN KEY (`BrojRacuna`) REFERENCES `ziro_racun` (`brojracuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Final view structure for view `izlazna_faktura_view`
--

/*!50001 DROP VIEW IF EXISTS `izlazna_faktura_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `izlazna_faktura_view` AS select `i`.`Id` AS `id`,`i`.`SamostalniPreduzetnikJIB` AS `SamostalniPreduzetnikJIB`,`s`.`Naziv` AS `nazivsp`,`i`.`NazivFakture` AS `nazivfakture`,`i`.`Datum` AS `datum`,`k`.`Naziv` AS `nazivk`,`i`.`KomitentJIB` AS `KomitentJIB`,`i`.`IznosFakture` AS `IznosFakture`,`i`.`IznosVanposlovneSvrhe` AS `IznosVanposlovneSvrhe`,`i`.`IznosIzvoza` AS `IznosIzvoza`,`i`.`OsnovicaZaPDV` AS `OsnovicaZaPDV`,`i`.`UkupniPDV` AS `UkupniPDV`,`i`.`IdTipaPrihoda` AS `IdTipaPrihoda`,`t`.`Naziv` AS `nazivt` from (((`izlazna_faktura` `i` join `komitent` `k` on((`i`.`KomitentJIB` = `k`.`JIB`))) join `samostalni_preduzetnik` `s` on((`s`.`JIB` = `i`.`SamostalniPreduzetnikJIB`))) join `tip_prihoda` `t` on((`i`.`IdTipaPrihoda` = `t`.`Id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `komitent_view`
--

/*!50001 DROP VIEW IF EXISTS `komitent_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `komitent_view` AS select `k`.`JIB` AS `jib`,`k`.`Naziv` AS `nazivKomitenta`,`k`.`PDVsistem` AS `PDVsistem`,`k`.`Adresa` AS `Adresa`,`m`.`Naziv` AS `Mjesto`,`m`.`PostanskiBroj` AS `PostanskiBroj`,`t`.`BrojTelefona` AS `BrojTelefona`,`z`.`BrojRacuna` AS `BrojRacunaKomitenta`,`b`.`SifraBanke` AS `SifraBankeKomitenta` from (((((`komitent` `k` join `mjesto` `m` on((`m`.`PostanskiBroj` = `k`.`PostanskiBroj`))) left join `telefon_komitenta` `t` on((`t`.`JIB` = `k`.`JIB`))) left join `ziro_racun_komitenta` `z` on((`z`.`JIB` = `k`.`JIB`))) left join `ziro_racun` `zr` on((`zr`.`BrojRacuna` = `z`.`BrojRacuna`))) left join `banka` `b` on((`b`.`SifraBanke` = `zr`.`SifraBanke`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sp`
--

/*!50001 DROP VIEW IF EXISTS `sp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sp` AS select `s`.`JIB` AS `jib`,`s`.`Naziv` AS `naziv`,`s`.`SjedisteFirme` AS `sjedisteFirme`,`s`.`SifraDjelatnosti` AS `sifraDjelatnosti`,`s`.`NazivDjelatnosti` AS `nazivDjelatnosti`,`s`.`JMB` AS `jmb`,`s`.`Ime` AS `ime`,`s`.`Prezime` AS `prezime`,`s`.`Adresa` AS `adresa`,`s`.`PostanskiBroj` AS `postanskiBroj`,`z`.`BrojRacuna` AS `brojRacuna` from (`samostalni_preduzetnik` `s` join `ziro_racun_sp` `z` on((`s`.`JIB` = `z`.`JIB`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sp_komitent_view`
--

/*!50001 DROP VIEW IF EXISTS `sp_komitent_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sp_komitent_view` AS select `s`.`JIB` AS `JIBSamostalnogPreduzetnika`,`s`.`Naziv` AS `NazivSP`,`tip`.`NazivTipa` AS `NazivTipaKomitenta`,`k_v`.`jib` AS `JIBkomitenta`,`k_v`.`nazivKomitenta` AS `NazivKomitenta`,`k_v`.`PDVsistem` AS `PDVsistem`,`k_v`.`Adresa` AS `Adresa`,`k_v`.`Mjesto` AS `Mjesto`,`k_v`.`BrojTelefona` AS `brojTelefona`,`k_v`.`BrojRacunaKomitenta` AS `BrojRacuna`,`k_v`.`SifraBankeKomitenta` AS `SifraBanke`,`stanje`.`Saldo` AS `Saldo`,`stanje`.`Potrazuje` AS `Potrazuje`,`stanje`.`Duguje` AS `Duguje` from ((((`samostalni_preduzetnik` `s` join `samostalni_preduzetnik_ima_komitent` `s_k` on((`s`.`JIB` = `s_k`.`SamostalniPreduzetnikJIB`))) join `tip_komitenta` `tip` on((`tip`.`IdTipa` = `s_k`.`IdTipa`))) join `komitent_view` `k_v` on((`k_v`.`jib` = `s_k`.`KomitentJIB`))) left join `stanje_komitenta` `stanje` on(((`stanje`.`SamostalniPreduzetnikJIB` = `s`.`JIB`) and (`stanje`.`KomitentJIB` = `k_v`.`jib`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sp_view`
--

/*!50001 DROP VIEW IF EXISTS `sp_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sp_view` AS select `s`.`JIB` AS `jib`,`s`.`Naziv` AS `naziv`,`s`.`SjedisteFirme` AS `sjedisteFirme`,`s`.`SifraDjelatnosti` AS `sifraDjelatnosti`,`s`.`NazivDjelatnosti` AS `nazivDjelatnosti`,`s`.`JMB` AS `jmb`,`s`.`Ime` AS `ime`,`s`.`Prezime` AS `prezime`,`s`.`Adresa` AS `adresa`,`s`.`PostanskiBroj` AS `postanskiBroj`,`z`.`BrojRacuna` AS `brojRacuna` from (`samostalni_preduzetnik` `s` join `ziro_racun_sp` `z` on((`s`.`JIB` = `z`.`JIB`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ulazna_faktura_view`
--

/*!50001 DROP VIEW IF EXISTS `ulazna_faktura_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ulazna_faktura_view` AS select `u`.`Id` AS `id`,`u`.`SamostalniPreduzetnikJIB` AS `SamostalniPreduzetnikJIB`,`s`.`Naziv` AS `nazivsp`,`u`.`NazivFakture` AS `nazivfakture`,`u`.`Datum` AS `datum`,`k`.`Naziv` AS `nazivk`,`u`.`KomitentJIB` AS `KomitentJIB`,`u`.`IznosBezPDV` AS `iznosbezpdv`,`u`.`UkupnoSaPDV` AS `ukupnosapdv`,`u`.`IznosPausalneNaknade` AS `iznospausalnenaknade`,`u`.`UkupanUlazniPorez` AS `ukupanulazniporez`,`u`.`UlazniPorezOdbitni` AS `ulazniporezodbitni`,`u`.`UlazniPorezNeodbitni` AS `ulazniporezneodbitni`,`u`.`IdTipaTroska` AS `idtipatroska`,`t`.`Naziv` AS `naziv`,`u`.`Uvoz` AS `uvoz`,`u`.`Gotovina` AS `gotovina` from (((`ulazna_faktura` `u` join `komitent` `k` on((`u`.`KomitentJIB` = `k`.`JIB`))) join `samostalni_preduzetnik` `s` on((`s`.`JIB` = `u`.`SamostalniPreduzetnikJIB`))) join `tip_troska` `t` on((`u`.`IdTipaTroska` = `t`.`Id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25  1:26:23
