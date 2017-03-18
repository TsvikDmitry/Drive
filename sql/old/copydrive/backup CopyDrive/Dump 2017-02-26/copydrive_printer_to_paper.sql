-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 178.151.241.202    Database: copydrive
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `printer_to_paper`
--

DROP TABLE IF EXISTS `printer_to_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `printer_to_paper` (
  `idPrinterToPrice` int(11) NOT NULL AUTO_INCREMENT,
  `IdPrinter` int(11) DEFAULT NULL,
  `idPaperPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPrinterToPrice`),
  KEY `Fk_ptp_printer_idx` (`IdPrinter`),
  KEY `Fk_ptp_paper_idx` (`idPaperPrice`),
  CONSTRAINT `fk_ptp_pappric` FOREIGN KEY (`idPaperPrice`) REFERENCES `paper_price` (`idPaperPrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ptp_print` FOREIGN KEY (`IdPrinter`) REFERENCES `printer` (`idPrinter`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printer_to_paper`
--

LOCK TABLES `printer_to_paper` WRITE;
/*!40000 ALTER TABLE `printer_to_paper` DISABLE KEYS */;
INSERT INTO `printer_to_paper` VALUES (102,1,1),(103,1,2),(104,1,3),(105,1,4),(106,1,5),(107,1,6),(108,1,7),(109,1,8),(110,1,9),(111,1,10),(112,1,11),(113,1,12),(114,1,13),(115,1,14),(116,1,15),(117,1,16),(118,1,17),(119,1,18),(120,1,19),(121,1,20),(122,1,21),(123,1,22),(124,1,23),(125,1,24),(126,1,25),(127,1,26),(128,2,1),(129,2,2),(130,2,3),(131,2,4),(132,2,5),(133,2,6),(134,2,7),(135,2,8),(136,2,9),(137,2,10),(138,2,11),(139,2,12),(140,2,13),(141,2,14),(142,2,15),(143,2,16),(144,2,17),(145,2,18),(146,2,19),(147,2,20),(148,2,21),(149,2,22),(150,2,23),(151,2,24),(152,2,25),(153,2,26),(154,3,1),(155,4,28),(156,4,29),(157,4,30),(158,4,31),(159,4,32),(160,4,27),(161,1,33),(162,1,34),(163,2,33),(164,2,34);
/*!40000 ALTER TABLE `printer_to_paper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-26  2:10:11
