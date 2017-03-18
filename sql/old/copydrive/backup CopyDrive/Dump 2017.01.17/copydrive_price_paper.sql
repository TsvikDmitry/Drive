-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: copydrive
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `price_paper`
--

DROP TABLE IF EXISTS `price_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_format_printer` int(11) DEFAULT NULL,
  `id_paper` int(11) DEFAULT NULL,
  `density` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `price_cost` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paper_idx` (`id_format_printer`),
  KEY `fk_name_idx` (`id_paper`),
  CONSTRAINT `fk_name` FOREIGN KEY (`id_paper`) REFERENCES `paper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paper` FOREIGN KEY (`id_format_printer`) REFERENCES `format_printer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_paper`
--

LOCK TABLES `price_paper` WRITE;
/*!40000 ALTER TABLE `price_paper` DISABLE KEYS */;
INSERT INTO `price_paper` VALUES (1,1,1,80,0.2,0.1),(2,1,1,120,0.4,0.2),(3,1,1,150,0.5,0.25),(4,1,1,200,0.6,0.3),(5,1,1,250,0.7,0.35),(6,2,1,80,0.4,0.2),(7,2,1,120,0.8,0.4),(8,2,1,150,1,0.5),(9,2,1,200,1.2,0.6),(10,2,1,250,1.4,0.7);
/*!40000 ALTER TABLE `price_paper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-09  1:20:51
