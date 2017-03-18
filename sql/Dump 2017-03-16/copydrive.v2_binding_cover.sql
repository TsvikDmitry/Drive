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
-- Table structure for table `binding_cover`
--

DROP TABLE IF EXISTS `binding_cover`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binding_cover` (
  `id_binding_cover` int(11) NOT NULL AUTO_INCREMENT,
  `id_binding_format` int(11) DEFAULT NULL,
  `name_cover` varchar(45) DEFAULT NULL,
  `name_cover_eng` varchar(45) DEFAULT NULL,
  `cost_cover` decimal(10,2) DEFAULT NULL,
  `prime_cost_cover` decimal(10,2) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_binding_cover`),
  KEY `fk_cover_ormat_idx` (`id_binding_format`),
  CONSTRAINT `fk_cover_ormat` FOREIGN KEY (`id_binding_format`) REFERENCES `binding_format` (`id_binding_format`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binding_cover`
--

LOCK TABLES `binding_cover` WRITE;
/*!40000 ALTER TABLE `binding_cover` DISABLE KEYS */;
INSERT INTO `binding_cover` VALUES (1,1,'Без обложки','',0.00,0.00,NULL),(2,2,'Без обложки',NULL,0.00,0.00,NULL),(3,1,'Пластик+Пластик',NULL,4.00,3.00,NULL),(4,2,'Пластик+Пластик',NULL,8.00,4.00,NULL),(5,1,'Пластик+Картон',NULL,3.00,1.50,NULL),(6,2,'Пластик+Картон',NULL,7.00,2.00,NULL);
/*!40000 ALTER TABLE `binding_cover` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-16  0:32:48
