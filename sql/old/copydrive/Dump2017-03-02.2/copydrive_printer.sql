INDX( 	 °            (     �         ri),CH               c   	 x f     c   	 ����˒�4���˒�4���˒�����˒�        �               O r d e r P r i n t e r . c l a s s   mc   > � j     c   	 M��˒�b��˒�b��˒�M��˒�        �               O r d e r P r i n t e r D B . c l a s s     .c    x d     c   	 ����˒�����˒�����˒�����˒�       Z               P a p e r D u p l e x . c l a s s     �c    x h     c   	 T9�˒��g9�˒��g9�˒�T9�˒�       �
              P a p e r D u p l e x D B . c l a s s -c    x b     c   	 �G��˒��G��˒��G��˒��G��˒�        ^               P a p e r P r i c e . c l a s s       oc   3 x f     c   	 ���˒����˒����˒����˒�        �               P a p e r P r i c e D B . c l a s s                 e structure for table `printer`
--

DROP TABLE IF EXISTS `printer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `printer` (
  `idP nter` int(11) NOT NULL AUTO_INCREMENT,
  `namePrinter` varchar(45) DEFAULT NULL,
  `nameEngPrinter` varchar(45) DEFAULT NULL,
  `visiblePrinter` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idPrinter`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printer`
--

LOCK TABLES `printer` WRITE;
/*!40000 ALTER TABLE `printer` DISABLE KEYS */;
INSERT INTO `printer` VALUES (1,'Лазерный Цвет',NULL,0 (2,'Лазерный ЧБ',NULL,0),(3,'HP 4250',NULL,0),(4,'L800',NULL,0),(5,'Плоттер Мат',NULL,1),(6,'Плоттер ЦВ',NULL,1),(7,'Плоттер ЧБ',NULL,1),(8,'Плоттер ART',NULL,1);
/*!40000 ALTER TABLE `printer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_ ARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 19:45:43
