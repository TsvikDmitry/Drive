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
-- Table structure for table `binding_work`
--

DROP TABLE IF EXISTS `binding_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binding_work` (
  `id_binding_work` int(11) NOT NULL AUTO_INCREMENT,
  `id_binding_format` int(11) DEFAULT NULL,
  `sheet_work` int(11) NOT NULL,
  `cost_work` decimal(10,2) NOT NULL DEFAULT '0.00',
  `prime_cost_work` decimal(10,2) NOT NULL DEFAULT '0.00',
  `visible` tinyint(4) NOT NULL DEFAULT '0',
  `name_work` varchar(45) DEFAULT 'Переплет',
  `name_work_eng` varchar(45) DEFAULT 'Binding',
  PRIMARY KEY (`id_binding_work`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binding_work`
--

LOCK TABLES `binding_work` WRITE;
/*!40000 ALTER TABLE `binding_work` DISABLE KEYS */;
INSERT INTO `binding_work` VALUES (1,1,5,2.00,0.00,0,'Переплет','Binding'),(2,2,30,2.50,0.00,0,'Переплет','Binding'),(3,1,50,3.00,0.00,0,'Переплет','Binding'),(4,2,60,3.50,0.00,0,'Переплет','Binding'),(5,1,70,4.00,0.00,0,'Переплет','Binding'),(6,2,80,5.00,0.00,0,'Переплет','Binding'),(7,1,90,6.00,0.00,0,'Переплет','Binding'),(8,2,100,7.00,0.00,0,'Переплет','Binding'),(9,1,110,8.00,0.00,0,'Переплет','Binding'),(10,2,120,9.00,0.00,0,'Переплет','Binding'),(11,1,130,10.00,0.00,0,'Переплет','Binding'),(12,2,170,11.00,0.00,0,'Переплет','Binding'),(13,1,190,12.00,0.00,0,'Переплет','Binding'),(14,2,220,13.00,0.00,0,'Переплет','Binding'),(15,1,250,14.00,0.00,0,'Переплет','Binding'),(16,2,280,13.00,0.00,0,'Переплет','Binding'),(17,1,320,15.00,0.00,0,'Переплет','Binding'),(18,2,380,16.00,0.00,0,'Переплет','Binding'),(19,1,400,17.00,0.00,0,'Переплет','Binding'),(20,2,420,18.00,0.00,0,'Переплет','Binding');
/*!40000 ALTER TABLE `binding_work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-14 20:32:52
