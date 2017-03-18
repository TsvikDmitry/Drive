-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: copydrive
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
-- Table structure for table `order_printer`
--

DROP TABLE IF EXISTS `order_printer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_printer` (
  `id_order_printer` int(11) NOT NULL AUTO_INCREMENT,
  `id_orders` int(11) DEFAULT NULL,
  `name_order` varchar(45) DEFAULT NULL,
  `id_printer` int(11) DEFAULT NULL,
  `id_format` int(11) DEFAULT NULL,
  `id_duplex` int(11) DEFAULT NULL,
  `id_paper` int(11) DEFAULT NULL,
  `id_price` int(11) DEFAULT NULL,
  `cost_print` decimal(10,2) DEFAULT NULL,
  `cost_paper` decimal(10,2) DEFAULT NULL,
  `density` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `sum_one` decimal(10,2) DEFAULT NULL,
  `sum_all` decimal(10,2) DEFAULT NULL,
  `count_print_a4` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_order_printer`),
  KEY `fk_ord_duplex_idx` (`id_duplex`),
  KEY `fk_ord_printer_idx` (`id_printer`),
  KEY `fk_ord_paper_idx` (`id_paper`),
  KEY `fk_ord_format_idx` (`id_format`),
  KEY `fk_ord_price_idx` (`id_price`),
  CONSTRAINT `fk_ord_duplex` FOREIGN KEY (`id_duplex`) REFERENCES `duplex` (`idDuplex`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ord_format` FOREIGN KEY (`id_format`) REFERENCES `format` (`idFormat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ord_paper` FOREIGN KEY (`id_paper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ord_price` FOREIGN KEY (`id_price`) REFERENCES `price` (`idPrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ord_printer` FOREIGN KEY (`id_printer`) REFERENCES `printer` (`idPrinter`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_printer`
--

LOCK TABLES `order_printer` WRITE;
/*!40000 ALTER TABLE `order_printer` DISABLE KEYS */;
INSERT INTO `order_printer` VALUES (63,111,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(64,111,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(65,111,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(66,111,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(67,52,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(68,52,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(69,53,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(70,53,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(71,54,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(72,54,'Лазерный Цвет',1,1,1,3,1,4.25,1.40,'130',1,5.65,5.65,1),(73,55,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(74,55,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(75,55,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(76,55,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(77,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(78,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(79,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(80,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(81,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(82,56,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(83,58,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(84,58,'HP 4250',3,1,1,1,1,0.38,0.20,'80',166,0.58,96.28,166),(85,58,'Лазерный Цвет',1,1,2,2,3,4.25,0.60,'200',33,9.10,300.30,66),(86,60,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(87,60,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(88,60,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(89,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(90,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(91,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(92,101,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(93,103,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(94,105,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(95,106,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(96,106,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(97,106,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(98,107,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(99,107,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(100,108,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(101,137,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(102,138,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(103,140,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(104,139,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(105,155,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(106,155,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(107,156,'HP 4250',3,1,1,1,1,0.40,0.20,'80',12,0.60,7.20,12),(108,156,'L800',4,1,1,4,1,3.00,5.00,'230',5,8.00,40.00,5),(109,157,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(110,157,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(111,157,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',13,1.30,16.90,13),(112,157,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',13,1.30,16.90,13),(113,158,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(114,158,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(115,158,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(116,159,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(117,159,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(118,162,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(119,162,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(120,164,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(121,164,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(122,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(123,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(124,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(125,168,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(126,168,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',31,1.30,40.30,31);
/*!40000 ALTER TABLE `order_printer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-24  1:41:19
