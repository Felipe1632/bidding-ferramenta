CREATE DATABASE  IF NOT EXISTS `schema_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `schema_db`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: schema_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `ferramenta`
--

DROP TABLE IF EXISTS `ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ferramenta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `horas_uso` int(11) NOT NULL DEFAULT 0,
  `vidaUtilMaxima` int(11) NOT NULL,
  `status` enum('Em Funcionamento','Parada') NOT NULL DEFAULT 'Em Funcionamento',
  `id_galpao` bigint(20) DEFAULT NULL,
  `id_usuario_responsavel` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ferramenta_galpao` (`id_galpao`),
  KEY `fk_ferramenta_usuario` (`id_usuario_responsavel`),
  CONSTRAINT `fk_ferramenta_galpao` FOREIGN KEY (`id_galpao`) REFERENCES `galpao` (`id`),
  CONSTRAINT `fk_ferramenta_usuario` FOREIGN KEY (`id_usuario_responsavel`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ferramenta`
--

LOCK TABLES `ferramenta` WRITE;
/*!40000 ALTER TABLE `ferramenta` DISABLE KEYS */;
INSERT INTO `ferramenta` VALUES (2,'Chave de fenda',3,12,'Em Funcionamento',NULL,NULL);
/*!40000 ALTER TABLE `ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galpao`
--

DROP TABLE IF EXISTS `galpao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galpao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galpao`
--

LOCK TABLES `galpao` WRITE;
/*!40000 ALTER TABLE `galpao` DISABLE KEYS */;
/*!40000 ALTER TABLE `galpao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_servico`
--

DROP TABLE IF EXISTS `ordem_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_servico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_ferramenta` bigint(20) DEFAULT NULL,
  `id_usuario_tecnico` bigint(20) DEFAULT NULL,
  `descricao` text NOT NULL,
  `data_abertura` datetime NOT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  `status` enum('Aberta','Encerrada') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ordem_servico_ferramenta` (`id_ferramenta`),
  KEY `fk_ordem_servico_usuario` (`id_usuario_tecnico`),
  CONSTRAINT `fk_ordem_servico_ferramenta` FOREIGN KEY (`id_ferramenta`) REFERENCES `ferramenta` (`id`),
  CONSTRAINT `fk_ordem_servico_usuario` FOREIGN KEY (`id_usuario_tecnico`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_servico`
--

LOCK TABLES `ordem_servico` WRITE;
/*!40000 ALTER TABLE `ordem_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordem_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `perfil` enum('ADMIN','OPERADOR','TECNICO') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-18 17:26:22
