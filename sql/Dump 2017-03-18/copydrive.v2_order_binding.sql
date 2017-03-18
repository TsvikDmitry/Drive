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
-- Table structure for table `order_binding`
--

DROP TABLE IF EXISTS `order_binding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_binding` (
  `id_order_binding` int(11) NOT NULL AUTO_INCREMENT,
  `id_orders` int(11) DEFAULT NULL,
  `id_сategory` int(11) DEFAULT '3',
  `name_order` varchar(45) DEFAULT NULL,
  `id_cover` int(11) DEFAULT NULL,
  `count_cover` decimal(10,2) DEFAULT NULL,
  `cover_cost` decimal(10,2) DEFAULT NULL,
  `cover_prime_cost` decimal(10,2) DEFAULT NULL,
  `cover_cost_one` decimal(10,2) DEFAULT NULL,
  `cover_prime_cost_one` decimal(10,2) DEFAULT NULL,
  `id_format` int(11) DEFAULT NULL,
  `id_spring` int(11) DEFAULT NULL,
  `id_spring_size` int(11) DEFAULT NULL,
  `count_spring` decimal(10,2) DEFAULT NULL,
  `spring_size_cost` decimal(10,2) DEFAULT NULL,
  `spring_size_prime_cost` decimal(10,2) DEFAULT NULL,
  `spring_size_cost_one` decimal(10,2) DEFAULT NULL,
  `spring_size_prime_cost_one` decimal(10,2) DEFAULT NULL,
  `work_cost` decimal(10,2) DEFAULT NULL,
  `count_work` decimal(10,2) DEFAULT NULL,
  `work_cost_one` decimal(10,2) DEFAULT NULL,
  `sheet` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `sum_one` decimal(10,2) DEFAULT NULL,
  `sum_all` decimal(10,2) DEFAULT NULL,
  `prime_cost_sum_one` decimal(10,2) DEFAULT NULL,
  `prime_cost_sum_all` decimal(10,2) DEFAULT NULL,
  `text_desc` varchar(435) DEFAULT NULL,
  PRIMARY KEY (`id_order_binding`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_binding`
--

LOCK TABLES `order_binding` WRITE;
/*!40000 ALTER TABLE `order_binding` DISABLE KEYS */;
INSERT INTO `order_binding` VALUES (40,350,3,'Без обложки, Без пружины, 0, 50',2,0.00,0.00,0.00,0.00,0.00,2,1,20,0.00,0.00,0.00,0.00,0.00,3.50,1.00,3.50,50,1,3.50,3.50,0.00,0.00,''),(41,345,3,'Пластик+Пластик, Без пружины, 0, 50',4,1.00,8.00,4.00,8.00,4.00,2,1,20,0.00,0.00,0.00,0.00,0.00,3.50,1.00,3.50,50,1,11.50,11.50,4.00,4.00,''),(42,345,3,'Пластик+Пластик, Без пружины, 0, 50',3,1.00,4.00,2.00,4.00,2.00,1,1,20,0.00,0.00,0.00,0.00,0.00,3.00,1.00,3.00,50,1,7.00,7.00,2.00,2.00,''),(52,353,3,'Пластик+Пластик, Пластиковая, 6 mm, 30',3,0.50,4.00,1.00,4.00,2.00,1,2,1,0.50,2.00,0.50,2.00,1.00,1.50,0.50,3.00,30,1,6.50,6.50,1.50,1.50,''),(53,353,3,'Пластик+Пластик, Пластиковая, 22 mm, 170',3,1.00,4.00,2.00,4.00,2.00,1,2,7,1.00,10.00,5.00,10.00,5.00,12.00,1.00,12.00,170,1,26.00,26.00,7.00,7.00,''),(54,353,3,'Пластик+Пластик, Металлическая, 14,3 mm, 120',3,1.00,4.00,2.00,4.00,2.00,1,3,19,1.00,8.00,4.00,8.00,4.00,10.00,1.00,10.00,120,1,22.00,22.00,6.00,6.00,'');
/*!40000 ALTER TABLE `order_binding` ENABLE KEYS */;
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
