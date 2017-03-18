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
-- Table structure for table `plotter_price`
--

DROP TABLE IF EXISTS `plotter_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plotter_price` (
  `id_plotter_price` int(11) NOT NULL AUTO_INCREMENT,
  `id_plotter_cost` int(11) DEFAULT NULL,
  `id_plotter_paper_cost` int(11) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_plotter_price`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plotter_price`
--

LOCK TABLES `plotter_price` WRITE;
/*!40000 ALTER TABLE `plotter_price` DISABLE KEYS */;
INSERT INTO `plotter_price` VALUES (5,1,1,0),(6,1,2,0),(7,1,3,0),(8,2,1,0),(9,2,2,0),(10,2,3,0),(11,3,1,0),(12,3,2,0),(13,3,3,0),(14,1,4,0),(15,2,4,0),(16,3,4,0),(17,1,5,0),(18,2,5,0),(19,3,5,0),(20,1,6,0),(21,2,6,0),(22,3,6,0),(23,1,7,0),(24,2,7,0),(25,3,7,0),(26,1,8,0),(27,2,8,0),(28,3,8,0),(29,1,9,0),(30,2,9,0),(31,3,9,0);
/*!40000 ALTER TABLE `plotter_price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-18  0:51:35
