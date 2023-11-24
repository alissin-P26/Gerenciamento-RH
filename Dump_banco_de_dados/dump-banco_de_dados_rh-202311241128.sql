-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_de_dados_rh
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atestados`
--

DROP TABLE IF EXISTS `atestados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atestados` (
  `id` int NOT NULL,
  `id_dados_pessoais_funcionario` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `data_afastamento` datetime DEFAULT NULL,
  `motivo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_dados_pessoais_funcionario` (`id_dados_pessoais_funcionario`),
  CONSTRAINT `atestados_ibfk_1` FOREIGN KEY (`id_dados_pessoais_funcionario`) REFERENCES `dados_pessoais_funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atestados`
--

LOCK TABLES `atestados` WRITE;
/*!40000 ALTER TABLE `atestados` DISABLE KEYS */;
/*!40000 ALTER TABLE `atestados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastro_de_gerenciamentorh`
--

DROP TABLE IF EXISTS `cadastro_de_gerenciamentorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastro_de_gerenciamentorh` (
  `id` int NOT NULL,
  `id_dados_pessoais_funcionario` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_dados_pessoais_funcionario` (`id_dados_pessoais_funcionario`),
  CONSTRAINT `cadastro_de_gerenciamentorh_ibfk_1` FOREIGN KEY (`id_dados_pessoais_funcionario`) REFERENCES `dados_pessoais_funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_de_gerenciamentorh`
--

LOCK TABLES `cadastro_de_gerenciamentorh` WRITE;
/*!40000 ALTER TABLE `cadastro_de_gerenciamentorh` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_de_gerenciamentorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `id` int NOT NULL,
  `id_estado` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_estado` (`id_estado`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,1,'Campo Mourão'),(2,1,'Peabiru'),(3,1,'Araruna');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_pessoais_funcionario`
--

DROP TABLE IF EXISTS `dados_pessoais_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_pessoais_funcionario` (
  `id` int NOT NULL,
  `id_cidade` int NOT NULL,
  `id_estado_civil` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `RG` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `setor` varchar(45) DEFAULT NULL,
  `horario_de_trabalho` int DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `status_funcionario` char(1) DEFAULT NULL,
  `data_admissao` date DEFAULT NULL,
  `data_demissao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cidade` (`id_cidade`),
  KEY `id_estado_civil` (`id_estado_civil`),
  CONSTRAINT `dados_pessoais_funcionario_ibfk_1` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id`),
  CONSTRAINT `dados_pessoais_funcionario_ibfk_3` FOREIGN KEY (`id_estado_civil`) REFERENCES `estado_civil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_pessoais_funcionario`
--

LOCK TABLES `dados_pessoais_funcionario` WRITE;
/*!40000 ALTER TABLE `dados_pessoais_funcionario` DISABLE KEYS */;
INSERT INTO `dados_pessoais_funcionario` VALUES (1,1,1,'','ASDASD',1,'AASDAD','111','111','111',1,1111.00,'A','2023-11-01','2023-01-20'),(2,1,1,'asdasd','asdasdas',1,'aasd','111','1111','1111',1,12331.00,'A','2023-11-20',NULL),(3,1,2,'alisson','jose',18,'masculino','15572638989','54897845465','inteligencia',8,5600.00,'A','2020-05-08',NULL),(4,1,1,'alisson','jose',18,'masculino','68545645648','5468578979','TI',8,2500.00,'A','2023-01-15',NULL);
/*!40000 ALTER TABLE `dados_pessoais_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Paraná','PR');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_civil` (
  `id` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
INSERT INTO `estado_civil` VALUES (1,'Solteiro (a)'),(2,'Casado (a)'),(3,'Viuvo (a)'),(4,'União estável');
/*!40000 ALTER TABLE `estado_civil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'banco_de_dados_rh'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 11:28:13
