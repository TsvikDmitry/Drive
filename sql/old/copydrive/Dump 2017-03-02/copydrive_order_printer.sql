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
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_printer`
--

LOCK TABLES `order_printer` WRITE;
/*!40000 ALTER TABLE `order_printer` DISABLE KEYS */;
INSERT INTO `order_printer` VALUES (107,162,'HP 4250',3,1,1,1,1,0.40,0.20,'80',12,0.60,7.20,12),(108,161,'L800',4,1,1,4,1,3.00,5.00,'230',5,8.00,40.00,5),(109,164,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(110,164,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(111,165,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',13,1.30,16.90,13),(112,162,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',13,1.30,16.90,13),(113,161,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(114,162,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(115,163,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(116,164,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(117,165,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(118,169,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(119,169,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(120,167,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(121,167,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(122,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(123,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(124,166,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(125,168,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(126,168,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',31,1.30,40.30,31),(127,173,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(128,172,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(129,182,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(130,198,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(131,198,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(132,198,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(133,198,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(134,202,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(140,208,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(141,206,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(144,207,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(146,207,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(147,204,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(148,204,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(149,204,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(150,204,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(151,204,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(152,204,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(154,206,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(155,206,'L800',4,1,1,4,1,3.00,5.00,'230',1,8.00,8.00,1),(156,206,'Лазерный Цвет',1,1,1,1,1,4.25,0.20,'80',1,4.45,4.45,1),(159,207,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1),(160,207,'Лазерный ЧБ',2,1,1,1,1,1.00,0.20,'80',144,1.20,172.80,144),(161,206,'HP 4250',3,1,2,1,1,0.40,0.20,'80',1,1.00,1.00,2),(162,208,'Лазерный ЧБ',2,1,1,1,4,0.00,0.20,'80',654665,0.20,130933.00,654665),(163,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(164,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(165,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(166,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(167,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(168,210,'Лазерный ЧБ',2,1,1,1,1,1.10,0.20,'80',1,1.30,1.30,1),(169,210,'Лазерный ЧБ',2,1,1,2,1,0.80,0.40,'115',1222,1.20,1466.40,1222),(170,209,'HP 4250',3,1,1,1,1,0.40,0.20,'80',1,0.60,0.60,1);
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

-- Dump completed on 2017-03-02  7:39:30
