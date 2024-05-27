-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: store
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` bigint NOT NULL AUTO_INCREMENT,
  `user_user_id` bigint DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `register_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `UK_naj0b58u08ktctrm1kb0wooff` (`user_user_id`),
  CONSTRAINT `FK6vle7qy9wblyc5g0iw2peqmph` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,1,'ikea','3455513bc');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `individual`
--

DROP TABLE IF EXISTS `individual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `individual` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_user_id` bigint DEFAULT NULL,
  `birthdate` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_cay09bruqmudhgk35gqwjkwao` (`user_user_id`),
  CONSTRAINT `FK2s3imgadawi03722835qer58d` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individual`
--

LOCK TABLES `individual` WRITE;
/*!40000 ALTER TABLE `individual` DISABLE KEYS */;
INSERT INTO `individual` VALUES (1,3,'1956-12-15','Patrik','Jonsson'),(3,4,'1992-06-11','Lisa','Svensson'),(4,5,'1991-12-27','kj','shsh'),(5,6,'1991-06-07','Karl','Karlsson');
/*!40000 ALTER TABLE `individual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,3,'2024-05-26 13:45:15.492108','mittmail@mail.com'),(2,4,'2024-05-26 15:55:20.636273','lisa@gmail.com'),(3,3,'2024-05-27 11:14:39.287142','mittmail@mail.com'),(4,3,'2024-05-27 12:47:05.941081','mittmail@mail.com'),(5,3,'2024-05-27 14:36:47.521702','mittmail@mail.com'),(6,3,'2024-05-27 15:44:48.138055','mittmail@mail.com'),(7,3,'2024-05-27 17:34:26.201666','mittmail@mail.com'),(8,3,'2024-05-27 18:03:54.563912','mittmail@mail.com'),(9,3,'2024-05-27 18:05:06.908747','mittmail@mail.com'),(10,3,'2024-05-27 18:40:34.825593','mittmail@mail.com'),(11,3,'2024-05-27 18:45:17.470538','mittmail@mail.com'),(12,6,'2024-05-27 20:29:48.760415','kalle@gmail.com');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_items`
--

DROP TABLE IF EXISTS `transaction_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1oanxhyc6c85qyt2fppunyusq` (`transaction_id`),
  CONSTRAINT `FK1oanxhyc6c85qyt2fppunyusq` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_items`
--

LOCK TABLES `transaction_items` WRITE;
/*!40000 ALTER TABLE `transaction_items` DISABLE KEYS */;
INSERT INTO `transaction_items` VALUES (1,'guldfynd',799.99,'Gold Necklace',1,1),(2,'guldfynd',799.99,'Gold Necklace',1,2),(3,'guldfynd',1499.99,'Diamond Ring',1,2),(4,'netonet',599.99,'Smartphone',1,2),(5,'netonet',999.99,'Laptop',1,2),(6,'guldfynd',799.99,'Gold Necklace',1,3),(7,'guldfynd',2999.98,'Diamond Ring',2,5),(8,'guldfynd',799.99,'Gold Necklace',1,5),(9,'hm',29.99,'Jeans',1,5),(10,'hm',9.99,'T-Shirt',1,5),(11,'guldfynd',799.99,'Gold Necklace',1,6),(12,'hm',29.99,'Jeans',1,6),(13,'netonet',599.99,'Smartphone',1,6),(14,'guldfynd',1599.98,'Gold Necklace',2,7),(15,'guldfynd',2999.98,'Diamond Ring',2,7),(16,'hm',9.99,'T-Shirt',1,8),(17,'guldfynd',799.99,'Gold Necklace',1,9),(18,'hm',29.99,'Jeans',1,9),(19,'guldfynd',1499.99,'Diamond Ring',1,10),(20,'guldfynd',799.99,'Gold Necklace',1,10),(21,'guldfynd',799.99,'Gold Necklace',1,11),(22,'hm',29.99,'Jeans',1,11),(23,'guldfynd',799.99,'Gold Necklace',1,12),(24,'netonet',599.99,'Smartphone',1,12),(25,'stadium',29.99,'Sports Jersey',1,12);
/*!40000 ALTER TABLE `transaction_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_type` tinyint DEFAULT NULL,
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_chk_1` CHECK ((`user_type` between 0 and 1))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'5678@mail.com','1234abc','ingvar'),(0,3,'mittmail@mail.com','$2a$10$amfQs3LM1rlOljP1NMto6OqNgco0KGds3bOP50/Cuehhyxr7XZP02','Pelle'),(0,4,'lisa@gmail.com','$2a$10$3XqQI9Ex9wcExacmMn/pAeqxDz/eyTfktzxxH55E.pw6HMXumFp92','Lisa'),(0,5,'sjsj@gmail.com','$2a$10$R5T7Uy0uFnpEIJKKLVTYHe/fkSfNH/VQOEYv1bZQU6dkm/0/imIw6','Kalle'),(0,6,'kalle@gmail.com','$2a$10$7zu7RWMJYWATM.31OJMPpe3ylvPW7c1L9ebVRqGFn1TawFd3UOJmy','Karl');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-27 20:37:29
