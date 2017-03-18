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
-- Table structure for table `price_print`
--

DROP TABLE IF EXISTS `price_print`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_print` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_format_printer` int(11) NOT NULL,
  `count_paper` int(11) DEFAULT NULL,
  `price_count` float DEFAULT NULL,
  `price_retail` float DEFAULT NULL,
  `price_discount` float DEFAULT NULL,
  `price_cost` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pp_idx` (`id_format_printer`),
  CONSTRAINT `fk_pp` FOREIGN KEY (`id_format_printer`) REFERENCES `format_printer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_print`
--

LOCK TABLES `price_print` WRITE;
/*!40000 ALTER TABLE `price_print` DISABLE KEYS */;
INSERT INTO `price_print` VALUES (1,1,1,4.25,4.25,2.75,1.55),(2,1,5,3.75,4.25,2.75,1.55),(3,1,15,3.25,4.25,2.75,1.55),(4,1,30,3,4.25,2.75,1.55),(5,1,50,2.75,4.25,2.75,1.55),(6,1,100,2.5,4.25,2.5,1.55),(7,1,200,2.25,4.25,2.25,1.55),(8,2,1,8.5,8.5,5.5,3.1),(9,2,5,7.5,8.5,5.5,3.1),(10,2,15,6.5,8.5,5.5,3.1),(11,2,30,5,8.5,5.5,3.1),(12,2,50,5.5,8.5,5.5,3.1),(13,2,100,5,8.5,5,3.1),(14,2,200,4.5,8.5,4.5,3.1),(15,3,1,0.6,0.6,0.6,0.4),(16,3,5,NULL,NULL,NULL,NULL),(17,3,15,NULL,NULL,NULL,NULL),(18,3,30,NULL,NULL,NULL,NULL),(19,3,50,NULL,NULL,NULL,NULL),(20,3,100,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `price_print` ENABLE KEYS */;
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
