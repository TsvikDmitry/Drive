INDX( 	 �#            (   8   �       �ex1                               L    ' �}���H����W���}���       5               P a y O r d e r C o n t r o l l e r $ 3 . c l a s s                 L    ' ������
����/������� @      )4               P a y O r d e r C o n t r o l l e r . c l a s s                     L    ' ������
����
�������� @      )4               P a y O r d e r C o n t r o l l e r . c l a s s                     L    ' ������
�� �
�������� @      )4               P a y O r d e r C o n t r o l l e r . c l a s s                     L    ' ������
����
�������� @      )4               P a y O r d e r C o n t r o l l e r . c l a s s                     OTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `duplex`
--

DROP TABLE IF EXISTS `duplex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `duplex` (
  `idDupl ` int(11) NOT NULL AUTO_INCREMENT,
  `nameDuplex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDuplex`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duplex`
--

LOCK TABLES `duplex` WRITE;
/*!40000 ALTER TABLE `duplex` DISABLE KEYS */;
INSERT INTO `duplex` VALUES (1,'4+0'),(2,'4+4');
/*!40000 ALTER TABLE `duplex` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!4010 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 19:45:36
