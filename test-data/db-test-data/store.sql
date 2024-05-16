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
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1fei08974yarhqpvidj0w2i9j` (`transaction_id`),
  CONSTRAINT `FK1fei08974yarhqpvidj0w2i9j` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
INSERT INTO `cart_items` VALUES (1,'ikea','Lamp',10.99,3,1),(2,'ikea','Towels',20.5,5,1),(3,'Guldfynd','Diamond Ring',1499.99,1,2),(4,'Guldfynd','Gold Necklace',799.99,1,3),(5,'Guldfynd','Diamond Ring',1499.99,1,3),(6,'H&M','Jeans',29.99,1,3),(7,'H&M','T-Shirt',9.99,1,3),(8,'NetOnet','Smartphone',599.99,1,3),(9,'NetOnet','Laptop',999.99,1,3),(10,'Stadium','Sports Jersey',29.99,1,3),(11,'Stadium','Running Shoes',79.99,1,3),(12,'Guldfynd','Gold Necklace',799.99,1,4),(13,'Guldfynd','Diamond Ring',1499.99,1,4),(14,'H&M','Jeans',29.99,1,4),(15,'H&M','T-Shirt',9.99,1,4),(16,'NetOnet','Smartphone',599.99,1,4),(17,'NetOnet','Laptop',999.99,1,4),(18,'Stadium','Sports Jersey',29.99,1,4),(19,'Stadium','Running Shoes',79.99,1,4),(20,'Guldfynd','Gold Necklace',799.99,1,5),(21,'Guldfynd','Diamond Ring',1499.99,1,5),(22,'H&M','Jeans',29.99,1,5),(23,'H&M','T-Shirt',9.99,1,5),(24,'NetOnet','Smartphone',599.99,1,5),(25,'NetOnet','Laptop',999.99,1,5),(26,'Stadium','Sports Jersey',29.99,1,5),(27,'Stadium','Running Shoes',79.99,1,5),(28,'Guldfynd','Gold Necklace',799.99,1,6),(29,'Guldfynd','Diamond Ring',1499.99,1,6),(30,'H&M','Jeans',29.99,1,6),(31,'H&M','T-Shirt',9.99,1,6),(32,'NetOnet','Smartphone',599.99,1,6),(33,'NetOnet','Laptop',999.99,1,6),(34,'Stadium','Sports Jersey',29.99,1,6),(35,'Stadium','Running Shoes',79.99,1,6),(36,'Guldfynd','Gold Necklace',799.99,1,7),(37,'Guldfynd','Diamond Ring',1499.99,1,7),(38,'H&M','Jeans',29.99,1,7),(39,'H&M','T-Shirt',9.99,1,7),(40,'NetOnet','Smartphone',599.99,1,7),(41,'NetOnet','Laptop',999.99,1,7),(42,'Stadium','Sports Jersey',29.99,1,7),(43,'Stadium','Running Shoes',79.99,1,7),(44,'Guldfynd','Gold Necklace',799.99,1,8),(45,'Guldfynd','Diamond Ring',1499.99,1,8),(46,'H&M','Jeans',29.99,1,8),(47,'H&M','T-Shirt',9.99,1,8),(48,'NetOnet','Smartphone',599.99,1,8),(49,'NetOnet','Laptop',999.99,1,8),(50,'Stadium','Sports Jersey',29.99,1,8),(51,'Stadium','Running Shoes',79.99,1,8),(52,'Guldfynd','Gold Necklace',799.99,1,9),(53,'Guldfynd','Diamond Ring',1499.99,1,9),(54,'H&M','Jeans',29.99,1,9),(55,'H&M','T-Shirt',9.99,1,9),(56,'NetOnet','Smartphone',599.99,1,9),(57,'NetOnet','Laptop',999.99,1,9),(58,'Stadium','Sports Jersey',29.99,1,9),(59,'Stadium','Running Shoes',79.99,1,9),(60,'Guldfynd','Gold Necklace',799.99,1,10),(61,'Guldfynd','Diamond Ring',1499.99,1,10),(62,'H&M','Jeans',29.99,1,10),(63,'H&M','T-Shirt',9.99,1,10),(64,'NetOnet','Smartphone',599.99,1,10),(65,'NetOnet','Laptop',999.99,1,10),(66,'Stadium','Sports Jersey',29.99,1,10),(67,'Stadium','Running Shoes',79.99,1,10),(68,'Guldfynd','Gold Necklace',799.99,1,11),(69,'Guldfynd','Diamond Ring',1499.99,1,11),(70,'H&M','Jeans',29.99,1,11),(71,'H&M','T-Shirt',9.99,1,11),(72,'NetOnet','Smartphone',599.99,1,11),(73,'NetOnet','Laptop',999.99,1,11),(74,'Stadium','Sports Jersey',29.99,1,11),(75,'Stadium','Running Shoes',79.99,1,11),(76,'Guldfynd','Gold Necklace',799.99,1,12),(77,'Guldfynd','Diamond Ring',1499.99,1,12),(78,'H&M','Jeans',29.99,1,12),(79,'H&M','T-Shirt',9.99,1,12),(80,'NetOnet','Smartphone',599.99,1,12),(81,'NetOnet','Laptop',999.99,1,12),(82,'Stadium','Sports Jersey',29.99,1,12),(83,'Stadium','Running Shoes',79.99,1,12),(84,'Guldfynd','Gold Necklace',799.99,1,13),(85,'Guldfynd','Diamond Ring',1499.99,1,13),(86,'H&M','Jeans',29.99,1,13),(87,'H&M','T-Shirt',9.99,1,13),(88,'NetOnet','Smartphone',599.99,1,13),(89,'NetOnet','Laptop',999.99,1,13),(90,'Stadium','Sports Jersey',29.99,1,13),(91,'Stadium','Running Shoes',79.99,1,13),(92,'Guldfynd','Gold Necklace',799.99,1,14),(93,'Guldfynd','Diamond Ring',1499.99,1,14),(94,'H&M','Jeans',29.99,1,14),(95,'H&M','T-Shirt',9.99,1,14),(96,'NetOnet','Smartphone',599.99,1,14),(97,'NetOnet','Laptop',999.99,1,14),(98,'Stadium','Sports Jersey',29.99,1,14),(99,'Stadium','Running Shoes',79.99,1,14),(100,'Guldfynd','Gold Necklace',799.99,1,15),(101,'Guldfynd','Diamond Ring',1499.99,1,15),(102,'H&M','Jeans',29.99,1,15),(103,'H&M','T-Shirt',9.99,1,15),(104,'NetOnet','Smartphone',599.99,1,15),(105,'NetOnet','Laptop',999.99,1,15),(106,'Stadium','Sports Jersey',29.99,1,15),(107,'Stadium','Running Shoes',79.99,1,15),(108,'Guldfynd','Gold Necklace',799.99,1,16),(109,'Guldfynd','Diamond Ring',1499.99,1,16),(110,'H&M','Jeans',29.99,1,16),(111,'H&M','T-Shirt',9.99,1,16),(112,'NetOnet','Smartphone',599.99,1,16),(113,'NetOnet','Laptop',999.99,1,16),(114,'Stadium','Sports Jersey',29.99,1,16),(115,'Stadium','Running Shoes',79.99,1,16),(116,'Guldfynd','Gold Necklace',799.99,1,17),(117,'Guldfynd','Diamond Ring',1499.99,1,17),(118,'H&M','Jeans',29.99,1,17),(119,'H&M','T-Shirt',9.99,1,17),(120,'NetOnet','Smartphone',599.99,1,17),(121,'NetOnet','Laptop',999.99,1,17),(122,'Stadium','Sports Jersey',29.99,1,17),(123,'Stadium','Running Shoes',79.99,1,17),(124,'Guldfynd','Gold Necklace',799.99,1,18),(125,'Guldfynd','Diamond Ring',1499.99,1,18),(126,'H&M','Jeans',29.99,1,18),(127,'H&M','T-Shirt',9.99,1,18),(128,'NetOnet','Smartphone',599.99,1,18),(129,'NetOnet','Laptop',999.99,1,18),(130,'Stadium','Sports Jersey',29.99,1,18),(131,'Stadium','Running Shoes',79.99,1,18),(132,'Guldfynd','Gold Necklace',799.99,1,19),(133,'Guldfynd','Diamond Ring',1499.99,1,19),(134,'H&M','Jeans',29.99,1,19),(135,'H&M','T-Shirt',9.99,1,19),(136,'NetOnet','Smartphone',599.99,1,19),(137,'NetOnet','Laptop',999.99,1,19),(138,'Stadium','Sports Jersey',29.99,1,19),(139,'Stadium','Running Shoes',79.99,1,19),(140,'Guldfynd','Gold Necklace',799.99,1,20),(141,'Guldfynd','Diamond Ring',1499.99,1,20),(142,'H&M','Jeans',29.99,1,20),(143,'H&M','T-Shirt',9.99,1,20),(144,'NetOnet','Smartphone',599.99,1,20),(145,'NetOnet','Laptop',999.99,1,20),(146,'Stadium','Sports Jersey',29.99,1,20),(147,'Stadium','Running Shoes',79.99,1,20),(148,'Guldfynd','Gold Necklace',799.99,1,21),(149,'Guldfynd','Diamond Ring',1499.99,1,21),(150,'H&M','Jeans',29.99,1,21),(151,'H&M','T-Shirt',9.99,1,21),(152,'NetOnet','Smartphone',599.99,1,21),(153,'NetOnet','Laptop',999.99,1,21),(154,'Stadium','Sports Jersey',29.99,1,21),(155,'Stadium','Running Shoes',79.99,1,21),(156,'Guldfynd','Gold Necklace',799.99,1,22),(157,'Guldfynd','Diamond Ring',1499.99,1,22),(158,'H&M','Jeans',29.99,1,22),(159,'H&M','T-Shirt',9.99,1,22),(160,'NetOnet','Smartphone',599.99,1,22),(161,'NetOnet','Laptop',999.99,1,22),(162,'Stadium','Sports Jersey',29.99,1,22),(163,'Stadium','Running Shoes',79.99,1,22),(164,'Guldfynd','Gold Necklace',799.99,1,24),(165,'Guldfynd','Diamond Ring',1499.99,1,24),(166,'Guldfynd','Gold Necklace',799.99,1,26),(167,'Guldfynd','Gold Necklace',799.99,1,28),(168,'Guldfynd','Diamond Ring',1499.99,1,28),(169,'H&M','T-Shirt',9.99,1,29),(170,'H&M','T-Shirt',9.99,1,30),(171,'Guldfynd','Diamond Ring',1499.99,1,31),(172,'Guldfynd','Gold Necklace',799.99,1,33),(173,'Guldfynd','Gold Necklace',799.99,1,37),(174,'Guldfynd','Gold Necklace',799.99,1,39),(175,'Guldfynd','Diamond Ring',1499.99,1,39);
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individual`
--

LOCK TABLES `individual` WRITE;
/*!40000 ALTER TABLE `individual` DISABLE KEYS */;
INSERT INTO `individual` VALUES (1,2,'1991-01-27','Kaj','Karlsson'),(2,3,'1971-01-27','Pelle','Larsson');
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,2,'2022-04-05 15:34:22.123457','kaj.kalas@mail.com'),(2,2,'2024-05-06 18:15:33.010366','kaj.kalas@mail.com'),(3,2,'2024-05-07 11:03:28.898352','kaj.kalas@mail.com'),(4,2,'2024-05-07 11:04:11.989925','kaj.kalas@mail.com'),(5,2,'2024-05-07 11:04:37.470630','kaj.kalas@mail.com'),(6,2,'2024-05-07 11:05:26.753036','kaj.kalas@mail.com'),(7,2,'2024-05-07 11:05:53.698970','kaj.kalas@mail.com'),(8,2,'2024-05-07 11:06:11.040923','kaj.kalas@mail.com'),(9,2,'2024-05-07 11:06:22.485881','kaj.kalas@mail.com'),(10,2,'2024-05-07 11:06:34.067049','kaj.kalas@mail.com'),(11,2,'2024-05-07 11:06:47.219389','kaj.kalas@mail.com'),(12,2,'2024-05-07 11:07:16.995515','kaj.kalas@mail.com'),(13,2,'2024-05-07 11:07:46.968320','kaj.kalas@mail.com'),(14,2,'2024-05-07 11:08:30.250401','kaj.kalas@mail.com'),(15,2,'2024-05-07 11:08:51.431123','kaj.kalas@mail.com'),(16,2,'2024-05-07 11:09:31.370889','kaj.kalas@mail.com'),(17,2,'2024-05-07 11:10:22.316312','kaj.kalas@mail.com'),(18,2,'2024-05-07 11:10:39.344466','kaj.kalas@mail.com'),(19,2,'2024-05-07 11:11:49.359358','kaj.kalas@mail.com'),(20,2,'2024-05-07 11:12:18.608589','kaj.kalas@mail.com'),(21,2,'2024-05-07 11:12:50.490349','kaj.kalas@mail.com'),(22,2,'2024-05-07 11:13:11.249951','kaj.kalas@mail.com'),(23,2,'2024-05-07 11:15:12.969051','kaj.kalas@mail.com'),(24,2,'2024-05-07 11:29:54.005071','kaj.kalas@mail.com'),(25,2,'2024-05-07 11:30:04.813273','kaj.kalas@mail.com'),(26,2,'2024-05-07 11:52:33.442432','kaj.kalas@mail.com'),(27,2,'2024-05-07 11:52:42.329955','kaj.kalas@mail.com'),(28,2,'2024-05-07 17:05:02.580112','kaj.kalas@mail.com'),(29,2,'2024-05-07 17:07:49.072115','kaj.kalas@mail.com'),(30,2,'2024-05-07 17:08:57.158800','kaj.kalas@mail.com'),(31,2,'2024-05-07 17:11:24.120737','kaj.kalas@mail.com'),(32,2,'2024-05-07 17:15:30.913018','kaj.kalas@mail.com'),(33,2,'2024-05-07 17:15:56.433440','kaj.kalas@mail.com'),(34,2,'2024-05-07 17:16:47.703695','kaj.kalas@mail.com'),(35,2,'2024-05-07 17:16:55.688036','kaj.kalas@mail.com'),(36,2,'2024-05-07 17:16:58.956224','kaj.kalas@mail.com'),(37,2,'2024-05-07 17:30:30.333635','kaj.kalas@mail.com'),(38,2,'2024-05-07 17:30:35.682626','kaj.kalas@mail.com'),(39,2,'2024-05-07 18:39:27.035813','kaj.kalas@mail.com'),(40,2,'2024-05-07 18:39:30.415953','kaj.kalas@mail.com');
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
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1oanxhyc6c85qyt2fppunyusq` (`transaction_id`),
  CONSTRAINT `FK1oanxhyc6c85qyt2fppunyusq` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_items`
--

LOCK TABLES `transaction_items` WRITE;
/*!40000 ALTER TABLE `transaction_items` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'5678@mail.com','1234abc','ingvar'),(0,2,'kaj.kalas@mail.com','12345678','Kae'),(0,3,'mittmail@mail.com','$2a$10$amfQs3LM1rlOljP1NMto6OqNgco0KGds3bOP50/Cuehhyxr7XZP02','Pelle');
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

-- Dump completed on 2024-05-16 16:50:30
