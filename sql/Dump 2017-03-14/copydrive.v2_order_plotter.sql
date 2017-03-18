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
-- Table structure for table `order_plotter`
--

DROP TABLE IF EXISTS `order_plotter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_plotter` (
  `id_order_plotter` int(11) NOT NULL AUTO_INCREMENT,
  `id_orders` int(11) DEFAULT NULL,
  `id_сategory` int(11) DEFAULT '2',
  `name_order` varchar(150) DEFAULT NULL,
  `id_plotter` int(11) DEFAULT NULL,
  `id_plotter_paper` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `density` int(11) DEFAULT NULL,
  `fill` int(11) DEFAULT NULL,
  `text_desc` varchar(500) DEFAULT NULL,
  `area` decimal(10,2) DEFAULT NULL,
  `cost_meter` decimal(10,2) DEFAULT NULL,
  `prime_cost_print` decimal(10,2) DEFAULT NULL,
  `prime_cost_paper` decimal(10,2) DEFAULT NULL,
  `prime_cost_sum_one` decimal(10,2) DEFAULT NULL,
  `prime_cost_sum_all` decimal(10,2) DEFAULT NULL,
  `sum_one` decimal(10,2) DEFAULT NULL,
  `sum_all` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_order_plotter`),
  KEY `fk_ord_plotter_idx` (`id_orders`),
  CONSTRAINT `fk_ord_plotter` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id_orders`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_plotter`
--

LOCK TABLES `order_plotter` WRITE;
/*!40000 ALTER TABLE `order_plotter` DISABLE KEYS */;
INSERT INTO `order_plotter` VALUES (42,281,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x1)',1,1,1,610,1,180,100,'',0.00,130.00,10.00,25.00,0.02,0.02,0.08,0.08),(44,281,2,'Плотер ART 0% ( 0, 0x1)',4,0,1,0,1,0,0,'',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00),(45,281,2,'Плотер ART 0% ( 0, 0x1)',4,0,1,0,1,0,0,'',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00),(46,281,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x1)',1,1,1,610,1,180,100,'',0.00,130.00,10.00,25.00,0.02,0.02,0.08,0.08),(47,281,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x1)',1,1,1,610,1,180,100,'',0.00,130.00,10.00,25.00,0.02,0.02,0.08,0.08),(48,281,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'',0.26,130.00,10.00,25.00,9.18,9.18,34.10,34.10),(50,284,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'',0.26,0.00,10.00,25.00,9.18,9.18,0.00,0.00),(51,285,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'2434',0.26,130.00,10.00,25.00,9.18,9.18,34.10,34.10),(52,285,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'',0.26,130.00,10.00,25.00,9.18,9.18,34.10,34.10),(53,287,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'',0.26,130.00,10.00,25.00,9.18,9.18,34.10,34.10),(54,289,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x850)',1,1,850,610,1,180,100,'',0.52,130.00,10.00,25.00,18.15,18.15,67.41,67.41),(55,294,2,'Плоттер Мат. 100% (Матовая фото бумага 180, 610x430)',1,1,430,610,1,180,100,'',0.26,130.00,10.00,25.00,9.18,9.18,34.10,34.10);
/*!40000 ALTER TABLE `order_plotter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-14  1:57:57
