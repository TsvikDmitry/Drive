-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: copydrive.v2
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
  `density` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price_print` decimal(10,2) DEFAULT NULL,
  `price_paper` decimal(10,2) DEFAULT NULL,
  `sum_one` decimal(10,2) DEFAULT NULL,
  `sum_all` decimal(10,2) DEFAULT NULL,
  `count_print_a4` int(11) DEFAULT NULL,
  `text_desc` varchar(200) DEFAULT NULL,
  `cost_price` decimal(10,2) DEFAULT NULL,
  `cost_paper` decimal(10,2) DEFAULT NULL,
  `cost_sum_one` decimal(10,2) DEFAULT NULL,
  `cost_sum_all` decimal(10,2) DEFAULT NULL,
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
  CONSTRAINT `fk_ord_printer` FOREIGN KEY (`id_printer`) REFERENCES `printer` (`id_printer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_printer`
--

LOCK TABLES `order_printer` WRITE;
/*!40000 ALTER TABLE `order_printer` DISABLE KEYS */;
INSERT INTO `order_printer` VALUES (208,223,'Лазерный Цвет',1,1,1,1,1,'80',20,3.25,0.20,3.45,69.00,20,'',1.55,0.10,1.65,33.00),(209,224,'Лазерный Цвет',1,2,1,1,1,'200',10,7.50,1.20,8.70,87.00,20,'',3.10,0.60,3.70,37.00),(211,225,'Лазерный ЧБ',2,1,1,1,1,'80',20,1.10,0.20,1.30,26.00,20,'',0.45,0.10,0.55,11.00),(213,226,'Лазерный ЧБ',2,1,1,1,1,'80',100,1.00,0.20,1.20,120.00,100,'',0.45,0.10,0.55,55.00),(214,227,'Лазерный Цвет',1,1,1,1,1,'80',5,3.75,0.20,3.95,19.75,5,'',1.55,0.10,1.65,8.25),(216,227,'Лазерный Цвет',1,1,2,1,1,'80',1,4.25,0.20,8.70,8.70,2,'',1.55,0.10,3.20,3.20),(217,227,'Лазерный Цвет',1,2,1,1,1,'80',1,8.50,0.40,8.90,8.90,2,'',3.10,0.20,3.30,3.30);
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

-- Dump completed on 2017-03-04 21:14:38
