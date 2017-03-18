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
  `cost_print` float DEFAULT NULL,
  `cost_paper` float DEFAULT NULL,
  `density` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `sum_one` float DEFAULT NULL,
  `sum_all` float DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_printer`
--

LOCK TABLES `order_printer` WRITE;
/*!40000 ALTER TABLE `order_printer` DISABLE KEYS */;
INSERT INTO `order_printer` VALUES (63,111,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(64,111,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(65,111,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(66,111,'Лазерный ЧБ',2,1,1,1,1,1.1,0.2,'80',1,1.3,1.3,1),(67,52,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(68,52,'Лазерный ЧБ',2,1,1,1,1,1.1,0.2,'80',1,1.3,1.3,1),(69,53,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(70,53,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(71,54,'Лазерный Цвет',1,1,1,1,1,4.25,0.2,'80',1,4.45,4.45,1),(72,54,'Лазерный Цвет',1,1,1,3,1,4.25,1.4,'130',1,5.65,5.65,1),(73,55,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(74,55,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(75,55,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(76,55,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(77,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(78,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(79,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(80,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(81,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(82,56,'L800',4,1,1,4,1,3,5,'230',1,8,8,1),(83,58,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(84,58,'HP 4250',3,1,1,1,1,0.38,0.2,'80',166,0.58,96.28,166),(85,58,'Лазерный Цвет',1,1,2,2,3,4.25,0.6,'200',33,9.1,300.3,66),(86,60,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(87,60,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(88,60,'HP 4250',3,1,1,1,1,0.4,0.2,'80',1,0.6,0.6,1),(89,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.2,'80',1,4.45,4.45,1),(90,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.2,'80',1,4.45,4.45,1),(91,61,'Лазерный Цвет',1,1,1,1,1,4.25,0.2,'80',1,4.45,4.45,1);
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

-- Dump completed on 2017-02-20  8:13:37
