-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tpcontacts
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKna8bddygr3l3kq1imghgcskt8` (`user_id`),
  CONSTRAINT `FKna8bddygr3l3kq1imghgcskt8` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'67, rue Adolphe Wurtz','RichardEArrington@jourrapide.com','Richard','Arrington','02.45.53.37.22','https://fr.fakenamegenerator.com/images/sil-male.png',1),(4,'85, rue Charles Corbeau','JamesJKoonce@jourrapide.com','James','Koonce','01.31.48.91.30','https://fr.fakenamegenerator.com/images/sil-male.png',1),(5,'68, boulevard de Prague','test@test','Bryan','Kuiper','04.73.78.69.60','https://fr.fakenamegenerator.com/images/sil-male.png',1),(6,'30, rue de l\'Aigle','bkhb@kjsdh','Christopher','Griswold','02.94.29.84.32','https://fr.fakenamegenerator.com/images/sil-male.png',1),(7,'79, rue de la Mare aux Carats','email1@email','Rita','Webb','01.19.49.73.60','https://fr.fakenamegenerator.com/images/sil-female.png',2),(8,'37, rue Adolphe Wurtz','GaryRArmstrong@teleworm.us','Gary','Armstrong','02.33.28.64.59','https://fr.fakenamegenerator.com/images/sil-male.png',2),(9,'27, rue Victor Hugo','DamonTRutherford@jourrapide.com','Damon','Rutherford','03.00.88.54.86','https://fr.fakenamegenerator.com/images/sil-male.png',2),(11,'84, rue de Groussay','RachelWPillsbury@teleworm.us','Rachel','Pillsbury','05.33.51.99.10','https://fr.fakenamegenerator.com/images/sil-female.png',2),(12,'18, rue de l\'Aigle','EmmanuelCPatton@dayrep.com','Emmanuel','Patton','02.32.61.65.75','https://fr.fakenamegenerator.com/images/sil-male.png',3),(13,'50, avenue Ferdinand de Lesseps','JackDBanks@teleworm.us','Jack','Banks','02.90.00.15.10','https://fr.fakenamegenerator.com/images/sil-male.png',3),(14,'48, rue de la Mare aux Carats','MarieJHassan@rhyta.com','Marie','Hassan','01.11.12.98.14','https://fr.fakenamegenerator.com/images/sil-female.png',3),(15,'15, rue Banaudon','RuthKWoodbury@armyspy.com','Ruth','Woodbury','04.65.29.78.08','https://fr.fakenamegenerator.com/images/sil-female.png',3);
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','ayoub','baihat','admin','https://fr.fakenamegenerator.com/images/sil-male.png'),(2,'mmm','mmm','yguygu','mmm','https://fr.fakenamegenerator.com/images/sil-male.png'),(3,'email','first','last','pass','https://fr.fakenamegenerator.com/images/sil-female.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-09 23:14:50
