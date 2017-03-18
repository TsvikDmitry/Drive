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
-- Table structure for table `plotter_cost`
--

DROP TABLE IF EXISTS `plotter_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plotter_cost` (
  `id_plotter_cost` int(11) NOT NULL AUTO_INCREMENT,
  `id_plotter` int(11) DEFAULT NULL,
  `fill` int(11) DEFAULT NULL,
  `prime_cost_print` decimal(10,2) DEFAULT NULL,
  `cost_print` decimal(10,2) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_plotter_cost`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plotter_cost`
--

LOCK TABLES `plotter_cost` WRITE;
/*!40000 ALTER TABLE `plotter_cost` DISABLE KEYS */;
INSERT INTO `plotter_cost` VALUES (1,1,100,10.00,105.00,0),(2,1,50,9.00,99.00,0),(3,1,30,8.00,93.00,0),(4,2,100,10.00,105.00,0),(5,2,50,9.00,99.00,0),(6,2,30,8.00,93.00,0),(7,3,100,10.00,105.00,0),(8,3,50,9.00,99.00,0),(9,3,30,8.00,93.00,0);
/*!40000 ALTER TABLE `plotter_cost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-12  1:52:05
