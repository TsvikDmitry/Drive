INDX( 	 �*            (   8   �       �icLE                              L    > i��y�����y��K1���i��y��       5               P a y O r d e r C o n t r o l l e r $ 3 . c l a s s                 L    > óy���ֳy��2
���óy�� @      �8               P a y O r d e r C o n t r o l l e r . c l a s s                     L    > óy���ֳy���ֳy��óy�� @      �8               P a y O r d e r C o n t r o l l e r . c l a s s                     L    > óy���ֳy� �ֳy��óy�� @      �8               P a y O r d e r C o n t r o l l e r . c l a s s                     L    > óy���ֳy���ֳy��óy�� @      �8               P a y O r d e r C o n t r o l l e r . c l a s s                     SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `idPr e` int(11) NOT NULL AUTO_INCREMENT,
  `namePrice` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPrice`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'Стандарт'),(2,'Оптовая'),(3,'Розница'),(4,'Другая');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TAB S;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02  7:39:30
