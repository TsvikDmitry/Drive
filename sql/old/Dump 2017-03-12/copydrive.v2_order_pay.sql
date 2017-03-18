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
-- Table structure for table `order_pay`
--

DROP TABLE IF EXISTS `order_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_pay` (
  `id_order_pay` int(11) NOT NULL AUTO_INCREMENT,
  `id_orders` int(11) DEFAULT NULL,
  `id_order_paymant` int(11) DEFAULT NULL,
  `data_pay` date DEFAULT NULL,
  `time_pay` time DEFAULT NULL,
  `data_get` date DEFAULT NULL,
  `time_get` time DEFAULT NULL,
  `sum_pay` decimal(10,2) DEFAULT NULL,
  `text_pay` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_order_pay`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_pay`
--

LOCK TABLES `order_pay` WRITE;
/*!40000 ALTER TABLE `order_pay` DISABLE KEYS */;
INSERT INTO `order_pay` VALUES (35,212,2,'2017-03-02','13:12:11','2017-03-02','13:12:00',7.00,''),(42,209,1,'2017-03-02','13:39:42',NULL,NULL,0.60,NULL),(44,204,1,'2017-03-02','13:39:50',NULL,NULL,6.40,NULL),(50,218,3,'2017-03-02','17:25:10','2017-03-02','17:25:00',85.50,''),(51,213,2,'2017-03-02','17:26:31','2017-03-02','17:26:00',10.10,''),(52,219,1,'2017-03-02','23:44:04',NULL,NULL,3.60,NULL),(53,223,1,'2017-03-05','00:17:25',NULL,NULL,69.00,NULL),(54,227,1,'2017-03-05','10:23:57',NULL,NULL,37.35,NULL),(59,230,1,'2017-03-05','13:56:44',NULL,NULL,1.30,NULL),(60,229,1,'2017-03-05','13:56:50',NULL,NULL,8.00,NULL),(61,225,1,'2017-03-05','13:56:55',NULL,NULL,26.00,NULL),(63,226,1,'2017-03-05','13:58:33',NULL,NULL,16.00,NULL),(65,229,1,'2017-03-07','11:31:35',NULL,NULL,26.20,NULL),(67,229,1,'2017-03-07','12:11:04',NULL,NULL,114.80,NULL),(68,229,2,'2017-03-07','12:11:55','2017-03-07','12:11:00',146.40,''),(69,229,1,'2017-03-07','12:21:38',NULL,NULL,-143.90,NULL);
/*!40000 ALTER TABLE `order_pay` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-12  1:52:04
