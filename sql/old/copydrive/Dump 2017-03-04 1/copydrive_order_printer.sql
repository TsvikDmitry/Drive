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
  `cost_sum_one` varchar(45) DEFAULT NULL,
  `cost_sum_all` varchar(45) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_printer`
--

LOCK TABLES `order_printer` WRITE;
/*!40000 ALTER TABLE `order_printer` DISABLE KEYS */;
INSERT INTO `order_printer` VALUES (175,213,'Лазерный ЧБ',2,1,1,1,1,'80',1,1.10,0.20,1.30,1.30,1,'',NULL,NULL,NULL,NULL),(176,213,'Лазерный ЧБ',2,1,1,1,1,'80',1,1.10,0.20,1.30,1.30,1,'',NULL,NULL,NULL,NULL),(177,213,'Лазерный ЧБ',2,1,1,3,1,'130',1,1.10,1.40,2.50,2.50,1,'',NULL,NULL,NULL,NULL),(178,213,'Лазерный ЧБ',2,1,1,3,3,'130',1,1.10,1.40,2.50,2.50,1,'',NULL,NULL,NULL,NULL),(179,213,'Лазерный ЧБ',2,1,1,3,3,'130',1,1.10,1.40,2.50,2.50,1,'',NULL,NULL,NULL,NULL),(180,214,'L800',4,1,1,4,1,'230',331,2.50,5.00,7.50,2482.50,331,'',NULL,NULL,NULL,NULL),(181,218,'Лазерный Цвет',1,1,1,2,1,'300',50,2.75,0.90,3.65,182.50,50,'',NULL,NULL,NULL,NULL),(182,219,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',NULL,NULL,NULL,NULL),(185,219,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',NULL,NULL,NULL,NULL),(186,219,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',NULL,NULL,NULL,NULL),(187,219,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',NULL,NULL,NULL,NULL),(188,219,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',NULL,NULL,NULL,NULL),(189,217,'Лазерный ЧБ',2,1,1,1,1,'80',1,1.10,0.20,1.30,1.30,1,'',NULL,NULL,NULL,NULL),(190,217,'Лазерный Цвет',1,2,1,1,3,'80',100,8.50,0.40,8.90,890.00,100,'',NULL,NULL,NULL,NULL),(191,220,'L800',4,1,1,4,1,'230',1,3.00,5.00,8.00,8.00,1,'',NULL,NULL,NULL,NULL),(192,220,'HP 4250',3,1,1,1,1,'80',1,0.40,0.20,0.60,0.60,1,'',0.00,0.00,'0.0','0.0'),(193,220,'Лазерный Цвет',1,1,1,1,1,'80',1,4.25,0.20,4.45,4.45,1,'',0.00,0.00,'0.0','0.0'),(194,220,'Лазерный Цвет',1,1,2,1,1,'80',1,4.25,0.20,8.70,8.70,2,'',0.00,0.00,'0.0','0.0'),(195,220,'Лазерный Цвет',1,2,2,1,1,'80',1,8.50,0.40,17.40,17.40,2,'',0.00,0.00,'0.0','0.0'),(196,220,'Лазерный Цвет',1,1,1,1,1,'80',1,4.25,0.20,4.45,4.45,1,'',0.00,0.00,'0.0','0.0'),(197,220,'Лазерный Цвет',1,2,1,1,1,'80',1,8.50,0.40,8.90,8.90,2,'',0.00,0.00,'0.0','0.0'),(198,220,'Лазерный Цвет',1,2,2,1,1,'80',1,8.50,0.40,17.40,17.40,4,'',0.00,0.00,'0.0','0.0'),(199,220,'Лазерный Цвет',1,2,2,1,1,'80',100,5.00,0.40,10.40,1040.00,400,'',0.00,0.00,'0.0','0.0'),(200,220,'Лазерный Цвет',1,2,1,1,1,'80',100,5.00,0.40,5.40,540.00,200,'',0.00,0.00,'0.0','0.0'),(201,220,'Лазерный ЧБ',2,2,1,1,1,'80',100,2.00,0.40,2.40,240.00,200,'',0.00,0.00,'0.0','0.0');
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

-- Dump completed on 2017-03-04  7:03:49
