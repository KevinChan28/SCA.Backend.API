-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sca_db
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documents` (
  `Id_Document` int NOT NULL AUTO_INCREMENT,
  `Folio` varchar(150) NOT NULL,
  `Loaded_Date` datetime NOT NULL,
  `Subject` varchar(400) DEFAULT NULL,
  `Assigned_To` int DEFAULT NULL,
  `Limit_Date` datetime DEFAULT NULL,
  `Status_id` int NOT NULL,
  `Type_id` int NOT NULL,
  `Sender` varchar(400) DEFAULT NULL,
  `Observation` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`Id_Document`),
  KEY `idx_documents` (`Id_Document`),
  KEY `idx_documents_status` (`Status_id`),
  KEY `idx_documents_type` (`Type_id`),
  KEY `idx_documents_asigned` (`Assigned_To`),
  CONSTRAINT `documents_ibfk_1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`Id_Status`),
  CONSTRAINT `documents_ibfk_2` FOREIGN KEY (`Type_id`) REFERENCES `type_document` (`Id_Type`),
  CONSTRAINT `fk_id_responsible` FOREIGN KEY (`Assigned_To`) REFERENCES `responsible` (`Id_Responsible`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documents`
--

LOCK TABLES `documents` WRITE;
/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` VALUES (3,'101 Prueba','2026-10-16 00:00:00','UAJ Auditoria',1,'2026-10-19 00:00:00',1,1,'UAJ','Responder pronto');
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-16 18:14:49
