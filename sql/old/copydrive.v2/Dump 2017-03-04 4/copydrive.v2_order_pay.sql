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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_pay`
--

LOCK TABLES `order_pay` WRITE;
/*!40000 ALTER TABLE `order_pay` DISABLE KEYS */;
INSERT INTO `order_pay` VALUES (35,212,2,'2017-03-02','13:12:11','2017-03-02','13:12:00',7.00,''),(39,210,1,'2017-03-02','13:14:18',NULL,NULL,1474.20,NULL),(42,209,1,'2017-03-02','13:39:42',NULL,NULL,0.60,NULL),(43,208,1,'2017-03-02','13:39:46',NULL,NULL,130941.00,NULL),(44,204,1,'2017-03-02','13:39:50',NULL,NULL,6.40,NULL),(46,214,1,'2017-03-02','17:16:33',NULL,NULL,2482.50,NULL),(48,218,1,'2017-03-02','17:24:20',NULL,NULL,100.00,NULL),(50,218,3,'2017-03-02','17:25:10','2017-03-02','17:25:00',85.50,''),(51,213,2,'2017-03-02','17:26:31','2017-03-02','17:26:00',10.10,''),(52,219,1,'2017-03-02','23:44:04',NULL,NULL,3.60,NULL);
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

-- Dump completed on 2017-03-04 21:14:44
