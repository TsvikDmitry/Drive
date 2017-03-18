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
-- Table structure for table `binding_spring_size`
--

DROP TABLE IF EXISTS `binding_spring_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binding_spring_size` (
  `id_binding_spring_ size` int(11) NOT NULL AUTO_INCREMENT,
  `id_binding_spring` int(11) DEFAULT NULL,
  `name_spring_size` varchar(50) DEFAULT NULL,
  `sheet_spring` int(11) DEFAULT NULL,
  `cost_spring` decimal(10,2) DEFAULT NULL,
  `prime_cost_spring` decimal(10,2) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_binding_spring_ size`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binding_spring_size`
--

LOCK TABLES `binding_spring_size` WRITE;
/*!40000 ALTER TABLE `binding_spring_size` DISABLE KEYS */;
INSERT INTO `binding_spring_size` VALUES (1,1,'6 mm',30,2.00,1.00,NULL),(2,1,'8 mm',50,3.00,1.50,NULL),(3,1,'10 mm',70,4.00,2.00,NULL),(4,1,'12 mm',90,5.00,2.50,NULL),(5,1,'16 mm',110,6.00,3.00,NULL),(6,1,'19 mm',130,7.00,3.50,NULL),(7,1,'22 mm',170,10.00,5.00,NULL),(8,1,'25 mm',190,12.00,6.00,NULL),(9,1,'28 mm',220,14.00,7.00,NULL),(10,1,'32 mm',250,16.00,8.00,NULL),(11,1,'38 mm',280,18.00,9.00,NULL),(12,1,'51 mm',480,20.00,10.00,NULL),(13,2,'5,5 mm',20,3.00,1.50,NULL),(14,2,'6,9 mm',30,4.00,2.00,NULL),(15,2,'8 mm',50,4.50,2.25,NULL),(16,2,'9,5 mm',60,5.00,2.50,NULL),(17,2,'11 mm',80,6.00,3.00,NULL),(18,2,'12,7 mm',100,7.00,3.50,NULL),(19,2,'14,3 mm',120,8.00,4.00,NULL);
/*!40000 ALTER TABLE `binding_spring_size` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-14  1:57:58
