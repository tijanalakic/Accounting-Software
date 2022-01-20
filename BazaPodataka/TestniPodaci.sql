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
-- Dumping data for table `banka`
--

LOCK TABLES `banka` WRITE;
/*!40000 ALTER TABLE `banka` DISABLE KEYS */;
INSERT INTO `banka` VALUES ('551','Unicredit Bank'),('555','Nova banka'),('562','NLB Razvojna banka'),('567','Sberbank a.d. Banja Luka');
/*!40000 ALTER TABLE `banka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budzetska_organizacija`
--

LOCK TABLES `budzetska_organizacija` WRITE;
/*!40000 ALTER TABLE `budzetska_organizacija` DISABLE KEYS */;
/*!40000 ALTER TABLE `budzetska_organizacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `isplata`
--

LOCK TABLES `isplata` WRITE;
/*!40000 ALTER TABLE `isplata` DISABLE KEYS */;
INSERT INTO `isplata` VALUES (16,'4508007006001','4508007006007','2020-06-13',10,'Faktura 10/20',117.00,'izvod 01/20','562',4),(17,'4508007006001','4508007006013','2020-06-30',14,'Faktura  20/20',1170.00,'izvod 03/20','562',4),(18,'4508007006001','4508007006003','2020-06-30',15,'Rn br 125/20',1170.00,'izvod 03/20','562',4),(20,'4508007006001','4508007006009','2020-06-13',11,'Faktura 10/20',585.00,'izvod 03/20','562',4),(21,'4508007006001','4508007006011','2020-06-13',12,'Faktura 10/20',585.00,'izvod 03/20','562',4),(22,'4508007006001','4508007006013','2020-06-13',13,'Faktura  15/20',585.00,'izvod 03/20','562',4);
/*!40000 ALTER TABLE `isplata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `izlazna_faktura`
--

LOCK TABLES `izlazna_faktura` WRITE;
/*!40000 ALTER TABLE `izlazna_faktura` DISABLE KEYS */;
INSERT INTO `izlazna_faktura` VALUES (8,'4508007006001','Faktura 01/2020','2020-05-31','4508007006002',117.00,0.00,0.00,0.00,100.00,17.00,4),(9,'4508007006001','Faktura 02/2020','2020-06-01','4508007006002',234.00,0.00,0.00,0.00,200.00,34.00,4),(10,'4508007006001','Faktura 02/2020','2020-06-02','4508007006004',351.00,0.00,0.00,0.00,300.00,51.00,5),(11,'4508007006001','Faktura 04/2020','2020-06-03','4508007006006',351.00,0.00,0.00,0.00,300.00,51.00,5),(12,'4508007006001','Faktura 05/2020','2020-06-04','4508007006008',585.00,0.00,0.00,0.00,500.00,85.00,6),(13,'4508007006001','Faktura 06/2020','2020-06-05','4508007006010',585.00,0.00,0.00,0.00,500.00,85.00,6),(14,'4508007006001','Faktura 07/2020','2020-06-06','4508007006014',585.00,0.00,585.00,0.00,500.00,85.00,5);
/*!40000 ALTER TABLE `izlazna_faktura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `komitent`
--

LOCK TABLES `komitent` WRITE;
/*!40000 ALTER TABLE `komitent` DISABLE KEYS */;
INSERT INTO `komitent` VALUES ('4508007006002','Delta s.p. Tanja Lakić',1,'Nadežde Petrović 58','78400'),('4508007006003','Bravo d.o.o.',0,'Francuska 15','78000'),('4508007006004','Robot s.p. Ivan Ivanović',1,'Vidovdanska bb','78000'),('4508007006005','Tropic d.o.o.',1,'Ive Andrića 14','70260'),('4508007006006','B.E.P. s.p. Ana Dakić',0,'Patre 70','78000'),('4508007006007','Elastic s.p. Ana Savić',1,'Vidovdanska 20','78400'),('4508007006008','Robot d.o.o.',1,'Cerska 6','78220'),('4508007006009','Spring d.o.o.',1,'Vidovdanska 9','78220'),('4508007006010','PropelMedia d.o.o.',0,'Kralja Alfonsa XIII 1','70260'),('4508007006011','Docker d.o.o.',1,'Aleja Svetog Save 2','78000'),('4508007006012','Media d.o.o.',1,'Beogradska 13','79240'),('4508007006013','Mongo d.o.o.',0,'Majke Jugovića 1','78000'),('4508007006014','Bravo d.o.o.',1,'Francuska 20','78000'),('4508007006015','L Systems d.o.o.',0,'Ravnogorska 17','79240');
/*!40000 ALTER TABLE `komitent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mjesto`
--

LOCK TABLES `mjesto` WRITE;
/*!40000 ALTER TABLE `mjesto` DISABLE KEYS */;
INSERT INTO `mjesto` VALUES ('70260','Mrkonjić Grad'),('78000','Banja Luka'),('78220','Kotor Varoš'),('78400','Gradiška'),('79240','Kozarska Dubica');
/*!40000 ALTER TABLE `mjesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `opstina`
--

LOCK TABLES `opstina` WRITE;
/*!40000 ALTER TABLE `opstina` DISABLE KEYS */;
INSERT INTO `opstina` VALUES ('002','Banja Luka'),('007','Kozarska Dubica'),('008','Gradiška'),('053','Kotor Varoš'),('067','Mrkonjić Grad');
/*!40000 ALTER TABLE `opstina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `plata_obracun`
--

LOCK TABLES `plata_obracun` WRITE;
/*!40000 ALTER TABLE `plata_obracun` DISABLE KEYS */;
/*!40000 ALTER TABLE `plata_obracun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `radnik`
--

LOCK TABLES `radnik` WRITE;
/*!40000 ALTER TABLE `radnik` DISABLE KEYS */;
/*!40000 ALTER TABLE `radnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `radno_mjesto`
--

LOCK TABLES `radno_mjesto` WRITE;
/*!40000 ALTER TABLE `radno_mjesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `radno_mjesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `samostalni_preduzetnik`
--

LOCK TABLES `samostalni_preduzetnik` WRITE;
/*!40000 ALTER TABLE `samostalni_preduzetnik` DISABLE KEYS */;
INSERT INTO `samostalni_preduzetnik` VALUES ('4508007006001','Urban Shop  s.p. Petar Petrović','Petra Pecije bb Gradiška','47.91','Trgovina na malo preko pošte ili interneta','0101991106000','Petar','Petrović','Vidovdanska 1','78400');
/*!40000 ALTER TABLE `samostalni_preduzetnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `samostalni_preduzetnik_ima_komitent`
--

LOCK TABLES `samostalni_preduzetnik_ima_komitent` WRITE;
/*!40000 ALTER TABLE `samostalni_preduzetnik_ima_komitent` DISABLE KEYS */;
INSERT INTO `samostalni_preduzetnik_ima_komitent` VALUES (1,'4508007006001','4508007006003'),(1,'4508007006001','4508007006005'),(1,'4508007006001','4508007006007'),(1,'4508007006001','4508007006009'),(1,'4508007006001','4508007006011'),(1,'4508007006001','4508007006013'),(1,'4508007006001','4508007006015'),(2,'4508007006001','4508007006002'),(2,'4508007006001','4508007006004'),(2,'4508007006001','4508007006006'),(2,'4508007006001','4508007006008'),(2,'4508007006001','4508007006010'),(2,'4508007006001','4508007006012'),(2,'4508007006001','4508007006014');
/*!40000 ALTER TABLE `samostalni_preduzetnik_ima_komitent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stanje_komitenta`
--

LOCK TABLES `stanje_komitenta` WRITE;
/*!40000 ALTER TABLE `stanje_komitenta` DISABLE KEYS */;
INSERT INTO `stanje_komitenta` VALUES ('4508007006001','4508007006002',351.00,234.00,117.00),('4508007006001','4508007006003',1170.00,1170.00,0.00),('4508007006001','4508007006004',351.00,351.00,0.00),('4508007006001','4508007006005',0.00,0.00,0.00),('4508007006001','4508007006006',351.00,351.00,0.00),('4508007006001','4508007006007',234.00,117.00,117.00),('4508007006001','4508007006008',585.00,585.00,0.00),('4508007006001','4508007006009',585.00,585.00,0.00),('4508007006001','4508007006010',585.00,585.00,0.00),('4508007006001','4508007006011',585.00,585.00,0.00),('4508007006001','4508007006012',0.00,0.00,0.00),('4508007006001','4508007006013',1755.00,1755.00,0.00),('4508007006001','4508007006014',585.00,585.00,0.00),('4508007006001','4508007006015',0.00,0.00,0.00);
/*!40000 ALTER TABLE `stanje_komitenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `status_ugovora`
--

LOCK TABLES `status_ugovora` WRITE;
/*!40000 ALTER TABLE `status_ugovora` DISABLE KEYS */;
/*!40000 ALTER TABLE `status_ugovora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `strucna_sprema`
--

LOCK TABLES `strucna_sprema` WRITE;
/*!40000 ALTER TABLE `strucna_sprema` DISABLE KEYS */;
/*!40000 ALTER TABLE `strucna_sprema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `telefon_komitenta`
--

LOCK TABLES `telefon_komitenta` WRITE;
/*!40000 ALTER TABLE `telefon_komitenta` DISABLE KEYS */;
INSERT INTO `telefon_komitenta` VALUES ('0038766010203','4508007006002'),('0038766010003','4508007006003'),('0038766010204','4508007006004'),('0038766010005','4508007006005'),('0038766010206','4508007006006'),('0038766010007','4508007006007'),('0038766010208','4508007006008'),('0038766010009','4508007006009'),('0038766010210','4508007006010'),('0038766010011','4508007006011'),('0038766010212','4508007006012'),('0038766010013','4508007006013'),('0038766010214','4508007006014'),('0038766010015','4508007006015');
/*!40000 ALTER TABLE `telefon_komitenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `telefon_radnika`
--

LOCK TABLES `telefon_radnika` WRITE;
/*!40000 ALTER TABLE `telefon_radnika` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefon_radnika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `telefon_sp`
--

LOCK TABLES `telefon_sp` WRITE;
/*!40000 ALTER TABLE `telefon_sp` DISABLE KEYS */;
INSERT INTO `telefon_sp` VALUES ('0038765100200','4508007006001');
/*!40000 ALTER TABLE `telefon_sp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tip_komitenta`
--

LOCK TABLES `tip_komitenta` WRITE;
/*!40000 ALTER TABLE `tip_komitenta` DISABLE KEYS */;
INSERT INTO `tip_komitenta` VALUES (1,'Dobavljač'),(2,'Kupac');
/*!40000 ALTER TABLE `tip_komitenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tip_prihoda`
--

LOCK TABLES `tip_prihoda` WRITE;
/*!40000 ALTER TABLE `tip_prihoda` DISABLE KEYS */;
INSERT INTO `tip_prihoda` VALUES (4,'Proizvodi i materijali'),(5,'Roba'),(6,'Usluge'),(7,'Prihod od finansiranja'),(8,'Vanredni prihod');
/*!40000 ALTER TABLE `tip_prihoda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tip_troska`
--

LOCK TABLES `tip_troska` WRITE;
/*!40000 ALTER TABLE `tip_troska` DISABLE KEYS */;
INSERT INTO `tip_troska` VALUES (4,'Materijalni trošak'),(5,'Bruto primanja zaposlenih'),(6,'Usluge'),(7,'Gorivo i energija'),(8,'Nematerijalni troškovi'),(9,'Finansijski rashodi'),(10,'Ostali rashodi'),(11,'Sponzorstvo'),(12,'Amortizacija');
/*!40000 ALTER TABLE `tip_troska` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ugovor_o_radu`
--

LOCK TABLES `ugovor_o_radu` WRITE;
/*!40000 ALTER TABLE `ugovor_o_radu` DISABLE KEYS */;
/*!40000 ALTER TABLE `ugovor_o_radu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ulazna_faktura`
--

LOCK TABLES `ulazna_faktura` WRITE;
/*!40000 ALTER TABLE `ulazna_faktura` DISABLE KEYS */;
INSERT INTO `ulazna_faktura` VALUES (10,'4508007006001','Faktura 10/20','2020-06-11','4508007006007',100.00,117.00,0.00,0.00,17.00,0.00,4,0,0),(11,'4508007006001','Faktura 10/20','2020-06-12','4508007006009',500.00,585.00,0.00,85.00,85.00,0.00,4,1,0),(12,'4508007006001','Faktura 10/20','2020-06-12','4508007006011',500.00,585.00,0.00,85.00,85.00,0.00,4,0,0),(13,'4508007006001','Faktura  15/20','2020-06-12','4508007006013',500.00,585.00,0.00,85.00,85.00,0.00,4,1,0),(14,'4508007006001','Faktura  20/20','2020-06-21','4508007006013',1000.00,1170.00,0.00,170.00,170.00,0.00,4,1,0),(15,'4508007006001','Rn br 125/20','2020-06-29','4508007006003',1000.00,1170.00,0.00,170.00,170.00,0.00,4,0,0);
/*!40000 ALTER TABLE `ulazna_faktura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `uplata`
--

LOCK TABLES `uplata` WRITE;
/*!40000 ALTER TABLE `uplata` DISABLE KEYS */;
INSERT INTO `uplata` VALUES (30,'4508007006001','4508007006002','2020-06-06',9,'Faktura 02/2020',234.00,'izvod 32/20','551',4),(31,'4508007006001','4508007006004','2020-06-06',10,'Faktura 02/2020',351.00,'izvod 32/20','555',5),(32,'4508007006001','4508007006006','2020-06-06',11,'Faktura 04/2020',351.00,'izvod 32/20','567',5),(33,'4508007006001','4508007006008','2020-06-06',12,'Faktura 05/2020',585.00,'izvod 32/20','567',6),(34,'4508007006001','4508007006010','2020-06-06',13,'Faktura 06/2020',585.00,'izvod 32/20','551',6),(35,'4508007006001','4508007006014','2020-06-06',14,'Faktura 07/2020',585.00,'izvod 32/20','551',5);
/*!40000 ALTER TABLE `uplata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `uplatnica`
--

LOCK TABLES `uplatnica` WRITE;
/*!40000 ALTER TABLE `uplatnica` DISABLE KEYS */;
/*!40000 ALTER TABLE `uplatnica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `uplatnica_ima_ziro_racun`
--

LOCK TABLES `uplatnica_ima_ziro_racun` WRITE;
/*!40000 ALTER TABLE `uplatnica_ima_ziro_racun` DISABLE KEYS */;
/*!40000 ALTER TABLE `uplatnica_ima_ziro_racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vrsta_prihoda`
--

LOCK TABLES `vrsta_prihoda` WRITE;
/*!40000 ALTER TABLE `vrsta_prihoda` DISABLE KEYS */;
INSERT INTO `vrsta_prihoda` VALUES ('711211','Porez na dobit'),('712113','Doprinosi za penzijsko osiguranje'),('712172','Poseban doprinos za solidarnost'),('712199','Doprinosi na lična primanja'),('713112','Porez na prihod paušalni'),('713113','Porez na lična primanja'),('722111','Republičke administrativne takse'),('722312','Komunalna taksa na firmu');
/*!40000 ALTER TABLE `vrsta_prihoda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ziro_racun`
--

LOCK TABLES `ziro_racun` WRITE;
/*!40000 ALTER TABLE `ziro_racun` DISABLE KEYS */;
INSERT INTO `ziro_racun` VALUES ('5510108108209201','551'),('5510108108209202','551'),('5510108108209204','551'),('5510108108209206','551'),('5550108108209201','555'),('5550108108209203','555'),('5550108108209205','555'),('5550108108209207','555'),('5620108108209201','562'),('5620108108209209','562'),('5620108108209211','562'),('5620108108209213','562'),('5670108108209201','567'),('5670108108209202','567'),('5670108108209215','567');
/*!40000 ALTER TABLE `ziro_racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ziro_racun_komitenta`
--

LOCK TABLES `ziro_racun_komitenta` WRITE;
/*!40000 ALTER TABLE `ziro_racun_komitenta` DISABLE KEYS */;
INSERT INTO `ziro_racun_komitenta` VALUES ('5510108108209201','4508007006002'),('5550108108209203','4508007006003'),('5550108108209201','4508007006004'),('5550108108209205','4508007006005'),('5670108108209201','4508007006006'),('5550108108209207','4508007006007'),('5670108108209202','4508007006008'),('5620108108209209','4508007006009'),('5510108108209202','4508007006010'),('5620108108209211','4508007006011'),('5510108108209204','4508007006012'),('5620108108209213','4508007006013'),('5510108108209206','4508007006014'),('5670108108209215','4508007006015');
/*!40000 ALTER TABLE `ziro_racun_komitenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ziro_racun_radnika`
--

LOCK TABLES `ziro_racun_radnika` WRITE;
/*!40000 ALTER TABLE `ziro_racun_radnika` DISABLE KEYS */;
/*!40000 ALTER TABLE `ziro_racun_radnika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ziro_racun_sp`
--

LOCK TABLES `ziro_racun_sp` WRITE;
/*!40000 ALTER TABLE `ziro_racun_sp` DISABLE KEYS */;
INSERT INTO `ziro_racun_sp` VALUES ('5620108108209201','4508007006001');
/*!40000 ALTER TABLE `ziro_racun_sp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 11:19:17
