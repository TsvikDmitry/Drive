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
-- Table structure for table `printer_price`
--

DROP TABLE IF EXISTS `printer_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `printer_price` (
  `idPrinterPrice` int(11) NOT NULL AUTO_INCREMENT,
  `idPrinter` int(11) DEFAULT NULL,
  `idFormat` int(11) DEFAULT NULL,
  `countPrinterPrice` int(11) DEFAULT NULL,
  `idPrice` int(11) DEFAULT NULL,
  `costPrinterPrice` decimal(10,2) DEFAULT NULL,
  `visiblePrinterPrice` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idPrinterPrice`),
  KEY `fk_pp_idx` (`idFormat`),
  KEY `fk_pp_print_idx` (`idPrinter`),
  KEY `fk_pp_price_idx` (`idPrice`),
  CONSTRAINT `fk_pp_format` FOREIGN KEY (`idFormat`) REFERENCES `format` (`idFormat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pp_price` FOREIGN KEY (`idPrice`) REFERENCES `price` (`idPrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pp_print` FOREIGN KEY (`idPrinter`) REFERENCES `printer` (`idPrinter`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printer_price`
--

LOCK TABLES `printer_price` WRITE;
/*!40000 ALTER TABLE `printer_price` DISABLE KEYS */;
INSERT INTO `printer_price` VALUES (1,1,1,1,1,4.25,0),(2,1,1,5,1,4.25,0),(3,1,1,15,1,3.75,0),(4,1,1,30,1,3.25,0),(5,1,1,50,1,3.00,0),(6,1,1,100,1,2.75,0),(7,1,1,200,1,2.50,0),(8,1,1,99999,1,2.25,0),(9,1,1,50,2,2.75,0),(10,1,1,100,2,2.75,0),(11,1,1,200,2,2.50,0),(12,1,1,99999,2,2.25,0),(13,1,1,99999,3,4.25,0),(14,1,2,1,1,8.50,0),(15,1,2,5,1,8.50,0),(16,1,2,15,1,7.50,0),(17,1,2,30,1,6.50,0),(18,1,2,50,1,6.00,0),(19,1,2,100,1,5.50,0),(20,1,2,200,1,5.00,0),(21,1,2,99999,1,4.50,0),(22,1,2,50,2,5.50,0),(23,1,2,100,2,5.50,0),(24,1,2,200,2,5.00,0),(25,1,2,99999,2,4.50,0),(26,1,2,99999,3,8.50,0),(27,2,1,1,3,1.10,0),(28,2,1,100,1,1.10,0),(29,2,1,300,1,1.00,0),(30,2,1,500,1,0.90,0),(34,2,1,99999,1,0.80,0),(35,2,1,300,2,0.90,0),(36,2,1,500,2,0.90,0),(38,2,1,99999,2,0.80,0),(39,2,1,99999,3,1.10,0),(40,2,2,1,1,2.20,0),(43,2,2,100,1,2.20,0),(44,2,2,300,1,2.00,0),(45,2,2,500,1,1.80,0),(46,2,2,99999,1,1.60,0),(48,2,2,300,2,1.80,0),(49,2,2,500,2,1.80,0),(50,2,2,99999,2,1.60,0),(51,2,2,99999,3,2.20,0),(52,3,1,1,1,0.40,0),(53,3,1,100,1,0.40,0),(54,3,1,300,1,0.38,0),(55,3,1,500,1,0.36,0),(56,3,1,99999,1,0.34,0),(57,4,1,1,1,3.00,0),(58,4,1,50,1,3.00,0),(59,4,1,100,1,2.75,0),(60,4,3,1,1,4.00,0),(61,4,3,10,1,4.00,0),(62,4,3,50,1,3.75,0),(63,4,3,100,1,3.50,0),(64,4,4,99999,1,3.00,0),(65,4,5,99999,1,2.00,0),(68,4,1,99999,1,2.50,0),(69,4,3,99999,1,3.25,0);
/*!40000 ALTER TABLE `printer_price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-28  2:13:43
