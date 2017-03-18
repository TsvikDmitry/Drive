-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: copydrive
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
-- Table structure for table `paper_price`
--

DROP TABLE IF EXISTS `paper_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper_price` (
  `idPaperPrice` int(11) NOT NULL AUTO_INCREMENT,
  `idFormat` int(11) DEFAULT NULL,
  `idPaper` int(11) DEFAULT NULL,
  `densityPaperPrice` int(11) DEFAULT NULL,
  `pricePaperPrice` float DEFAULT NULL,
  `priceCostPaperPrice` float DEFAULT NULL,
  PRIMARY KEY (`idPaperPrice`),
  KEY `fk_paper_idx` (`idFormat`),
  KEY `fk_name_idx` (`idPaper`),
  CONSTRAINT `fk_name` FOREIGN KEY (`idPaper`) REFERENCES `paper` (`idPaper`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paper` FOREIGN KEY (`idFormat`) REFERENCES `format` (`idFormat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_price`
--

LOCK TABLES `paper_price` WRITE;
/*!40000 ALTER TABLE `paper_price` DISABLE KEYS */;
INSERT INTO `paper_price` VALUES (1,1,1,80,0.2,0.1),(2,1,1,120,0.4,0.2),(3,1,1,150,0.5,0.25),(4,1,1,200,0.6,0.3),(5,1,1,250,0.7,0.35),(6,2,1,80,0.4,0.2),(7,2,1,120,0.8,0.4),(8,2,1,150,1,0.5),(9,2,1,200,1.2,0.6),(10,2,1,250,1.4,0.7),(11,1,2,115,0.4,0.2),(12,1,2,130,0.45,0.22),(13,1,2,150,0.5,0.25),(14,1,2,170,0.55,0.27),(15,1,2,200,0.6,0.3),(16,1,2,250,0.75,0.37),(17,1,2,300,0.9,0.45),(18,2,2,115,0.8,0.4),(19,2,2,130,0.9,0.45),(20,2,2,150,1,0.5),(21,2,2,170,1.1,0.55),(22,2,2,200,1.2,0.6),(23,2,2,250,1.5,0.75),(24,2,2,300,1.8,0.9),(25,1,3,130,1.4,0.7),(26,2,3,130,2.8,1.4),(27,1,4,230,5,4),(28,4,4,230,4,3),(29,5,4,320,3,2),(30,3,NULL,NULL,NULL,NULL),(31,3,5,0,10,6),(32,3,6,0,0,0);
/*!40000 ALTER TABLE `paper_price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-31 20:26:01
