-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: copydrive.v2
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
  `id_printer_price` int(11) NOT NULL AUTO_INCREMENT,
  `id_printer` int(11) DEFAULT NULL,
  `id_format` int(11) DEFAULT NULL,
  `id_price` int(11) DEFAULT NULL,
  `count_print` int(11) DEFAULT NULL,
  `cost_print` decimal(10,2) DEFAULT NULL,
  `prime_cost_print` decimal(10,2) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_printer_price`),
  KEY `fk_pp_idx` (`id_format`),
  KEY `fk_pp_print_idx` (`id_printer`),
  KEY `fk_pp_price_idx` (`id_price`),
  CONSTRAINT `fk_pp_format` FOREIGN KEY (`id_format`) REFERENCES `format` (`id_format`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pp_price` FOREIGN KEY (`id_price`) REFERENCES `price` (`id_price`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pp_print` FOREIGN KEY (`id_printer`) REFERENCES `printer` (`id_printer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printer_price`
--

LOCK TABLES `printer_price` WRITE;
/*!40000 ALTER TABLE `printer_price` DISABLE KEYS */;
INSERT INTO `printer_price` VALUES (1,1,1,1,1,4.25,1.55,0),(2,1,1,1,5,4.25,1.55,0),(3,1,1,1,15,3.75,1.55,0),(4,1,1,1,30,3.25,1.55,0),(5,1,1,1,50,3.00,1.55,0),(6,1,1,1,100,2.75,1.55,0),(7,1,1,1,200,2.50,1.55,0),(8,1,1,1,999999999,2.25,1.55,0),(9,1,1,2,50,2.75,1.55,0),(10,1,1,2,100,2.75,1.55,0),(11,1,1,2,200,2.50,1.55,0),(12,1,1,2,999999999,2.25,1.55,0),(13,1,1,3,999999999,4.25,1.55,0),(14,1,2,1,1,8.50,3.10,0),(15,1,2,1,5,8.50,3.10,0),(16,1,2,1,15,7.50,3.10,0),(17,1,2,1,30,6.50,3.10,0),(18,1,2,1,50,6.00,3.10,0),(19,1,2,1,100,5.50,3.10,0),(20,1,2,1,200,5.00,3.10,0),(21,1,2,1,999999999,4.50,3.10,0),(22,1,2,2,50,5.50,3.10,0),(23,1,2,2,100,5.50,3.10,0),(24,1,2,2,200,5.00,3.10,0),(25,1,2,2,999999999,4.50,3.10,0),(26,1,2,3,999999999,8.50,3.10,0),(27,2,1,3,1,1.10,0.45,0),(28,2,1,1,100,1.10,0.45,0),(29,2,1,1,300,1.00,0.45,0),(30,2,1,1,500,0.90,0.45,0),(34,2,1,1,999999999,0.80,0.45,0),(35,2,1,2,300,0.90,0.45,0),(36,2,1,2,500,0.90,0.45,0),(38,2,1,2,999999999,0.80,0.45,0),(39,2,1,3,999999999,1.10,0.45,0),(40,2,2,1,1,2.20,0.90,0),(43,2,2,1,100,2.20,0.90,0),(44,2,2,1,300,2.00,0.90,0),(45,2,2,1,500,1.80,0.90,0),(46,2,2,1,999999999,1.60,0.90,0),(48,2,2,2,300,1.80,0.90,0),(49,2,2,2,500,1.80,0.90,0),(50,2,2,2,999999999,1.60,0.90,0),(51,2,2,3,999999999,2.20,0.90,0),(52,3,1,1,1,0.40,0.15,0),(53,3,1,1,100,0.40,0.15,0),(54,3,1,1,300,0.38,0.15,0),(55,3,1,1,500,0.36,0.15,0),(56,3,1,1,999999999,0.34,0.15,0),(57,4,1,1,1,3.00,0.20,0),(58,4,1,1,50,3.00,0.20,0),(59,4,1,1,100,2.75,0.20,0),(60,4,3,1,1,4.00,0.10,0),(61,4,3,1,10,4.00,0.10,0),(62,4,3,1,50,3.75,0.10,0),(63,4,3,1,100,3.50,0.10,0),(64,4,4,1,999999999,3.00,0.10,0),(65,4,5,1,999999999,2.00,0.10,0),(68,4,1,1,999999999,2.50,0.20,0),(69,4,3,1,999999999,3.25,0.10,0),(70,1,1,4,999999999,0.00,1.55,0),(71,1,2,4,999999999,0.00,3.10,0),(72,2,1,4,999999999,0.00,0.45,0),(73,2,2,4,999999999,0.00,0.90,0);
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

-- Dump completed on 2017-03-06  8:08:29
