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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id_orders` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) DEFAULT NULL,
  `id_operator` int(11) DEFAULT NULL,
  `id_order_status` int(11) DEFAULT NULL,
  `text_description` varchar(45) DEFAULT NULL,
  `data_create` date DEFAULT NULL,
  `time_create` time DEFAULT NULL,
  `data_end` date DEFAULT NULL,
  `time_end` time DEFAULT NULL,
  PRIMARY KEY (`id_orders`),
  KEY `id_idx` (`id_client`),
  KEY `fk_order1_idx` (`id_client`),
  KEY `fk_operator_idx` (`id_operator`),
  KEY `fk_staus_idx` (`id_order_status`),
  CONSTRAINT `fk_clients` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_operator` FOREIGN KEY (`id_operator`) REFERENCES `operator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_staus` FOREIGN KEY (`id_order_status`) REFERENCES `order_status` (`id_status_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (213,NULL,1,1,NULL,'2017-03-02','13:41:07','2017-03-02',NULL),(214,NULL,1,1,NULL,'2017-03-02','13:42:52','2017-03-02',NULL),(215,NULL,1,1,NULL,'2017-03-02','15:08:22','2017-03-02',NULL),(216,NULL,1,1,NULL,'2017-03-02','16:04:59','2017-03-02',NULL),(217,NULL,2,1,NULL,'2017-03-02','16:33:09','2017-03-02',NULL),(218,NULL,2,1,NULL,'2017-03-02','17:21:21','2017-03-02',NULL),(219,NULL,2,1,NULL,'2017-03-02','17:29:48','2017-03-02',NULL),(220,NULL,2,1,NULL,'2017-03-03','15:19:58','2017-03-03',NULL),(222,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
