# CREATE DATABASE  IF NOT EXISTS `cm` /*!40100 DEFAULT CHARACTER SET utf8 */;
# USE `cm`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cm
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `audio`
--

DROP TABLE IF EXISTS `audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qw04iuto79xls5ixycsua6ehb` (`user_id`),
  CONSTRAINT `FK_qw04iuto79xls5ixycsua6ehb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audio`
--

LOCK TABLES `audio` WRITE;
/*!40000 ALTER TABLE `audio` DISABLE KEYS */;
INSERT INTO `audio` VALUES (1,'[FDM] Porter Robinson feat. Amy Millan - Divinity (filous Remix) [320 kbps] [Rel.mp3','/resources/audio/user4/[FDM] Porter Robinson feat. Amy Millan - Divinity (filous Remix) [320 kbps] [Rel.mp3',4),(2,'Fleetwood_Mac_-_The_Chain.mp3','/resources/audio/user1/Fleetwood_Mac_-_The_Chain.mp3',1),(3,'Imagine Dragons - Whatever It Takes.mp3','/resources/audio/user1/Imagine Dragons - Whatever It Takes.mp3',1);
/*!40000 ALTER TABLE `audio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialogs`
--

DROP TABLE IF EXISTS `dialogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dialogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deletedByFrom` bit(1) NOT NULL,
  `deletedByTo` bit(1) NOT NULL,
  `lastMessage` varchar(255) DEFAULT NULL,
  `userFrom_id` int(11) DEFAULT NULL,
  `userTo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tftakxjy09r7o2w81lcncech7` (`userFrom_id`),
  KEY `FK_1cusb8eblejnenm5vxf49f0q9` (`userTo_id`),
  CONSTRAINT `FK_1cusb8eblejnenm5vxf49f0q9` FOREIGN KEY (`userTo_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_tftakxjy09r7o2w81lcncech7` FOREIGN KEY (`userFrom_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialogs`
--

LOCK TABLES `dialogs` WRITE;
/*!40000 ALTER TABLE `dialogs` DISABLE KEYS */;
INSERT INTO `dialogs` VALUES (1,'\0','\0','gdfg',4,1),(2,'\0','\0','horosho',6,1);
/*!40000 ALTER TABLE `dialogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follower` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFollower` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j13a8l6ld8frpudw2adhoxm05` (`user_id`),
  CONSTRAINT `FK_j13a8l6ld8frpudw2adhoxm05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES (2,4,2),(3,5,2);
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `following`
--

DROP TABLE IF EXISTS `following`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `following` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFollowing` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mhkb2tt9el8l7e1w993osyelr` (`user_id`),
  CONSTRAINT `FK_mhkb2tt9el8l7e1w993osyelr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `following`
--

LOCK TABLES `following` WRITE;
/*!40000 ALTER TABLE `following` DISABLE KEYS */;
INSERT INTO `following` VALUES (2,2,4),(3,2,5);
/*!40000 ALTER TABLE `following` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFriend` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e616f41dyfk6lxa1pnae835o6` (`user_id`),
  CONSTRAINT `FK_e616f41dyfk6lxa1pnae835o6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (1,4,1),(2,1,4),(3,6,1),(4,1,6);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `information`
--

DROP TABLE IF EXISTS `information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `interests` longtext,
  `maritalStatus` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `socialStatus` longtext,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c0nl7bcgq2rpw5iqxlu06cjdj` (`user_id`),
  CONSTRAINT `FK_c0nl7bcgq2rpw5iqxlu06cjdj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information`
--

LOCK TABLES `information` WRITE;
/*!40000 ALTER TABLE `information` DISABLE KEYS */;
INSERT INTO `information` VALUES (1,'2017-05-23 16:10:25','Rickards was born and raised in British Columbia. Beginning on her career path at a young age, she introduced herself to musical theatre and dance, with the hope of later introducing herself to more serious acting. She graduated from high school early and attended the Vancouver Film School, completing the Acting Essentials Program. After completing the program, she attended an open call audition, which gained her an agent. She studied at the Alida Vocal Studio in Vancouver','Married','+58205151','Female','Rickards appeared in the video of the Nickelback single \"Never Gonna Be Alone\" in 2008 and, after some minor roles, was cast as Felicity Smoak in the TV series Arrow in 2012.Originally signed as a one-episode guest star, positive reaction from her co-star and from Warner Brothers producer Peter Roth before the show aired, led to her being signed on as a recurring star for the rest of show\'s first season. The success of the character, coupled with positive fan response, led to her being made a series regular from the second season onwards.The following year she landed the role of Lauren Phillips in the television movie Romeo Killer: The Chris Porco Story.',1),(2,'2017-05-23 16:25:06','fndjsknfkjsdng','Married','+3551251','Male',' fghfgh gfh\r\nfgh\r\nfgh',4),(3,'2017-06-01 14:07:56','jhjhkjkkj\r\nj\r\njjjjjjj kjhjkhkjh ojoij oiji joij i\r\n\r\n p\r\npiuj','Married','+35626842','Female','jhuin78j\r\n h h kjk j;\r\n j j \r\n ijiujuioiou iuupoi oiu 897 89',5),(4,'2017-06-04 12:31:32','I like Donald Trump byt in the same time I hate him)\r\nI like Donald Trump byt in the same time I hate him)\r\nI like Donald Trump byt in the same time I hate him)\r\nI like Donald Trump byt in the same time I hate him)','Single','+25251025','Female','I would be a president!\r\nI would be a president!I would be a president!I would be a president!\r\nI would be a president!',6);
/*!40000 ALTER TABLE `information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `deletedByFrom` bit(1) NOT NULL,
  `deletedByTo` bit(1) NOT NULL,
  `favorite` bit(1) NOT NULL,
  `statusFrom` bit(1) NOT NULL,
  `statusTo` bit(1) NOT NULL,
  `text` longtext,
  `dialogs_id` int(11) DEFAULT NULL,
  `userFrom_id` int(11) DEFAULT NULL,
  `userTo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pxnwhc013h3bgt4gomyw7shpc` (`dialogs_id`),
  KEY `FK_fw45mcwudv6fy725hfx5y5iwi` (`userFrom_id`),
  KEY `FK_t4ca8dhp1rwepb6spa5804e3e` (`userTo_id`),
  CONSTRAINT `FK_fw45mcwudv6fy725hfx5y5iwi` FOREIGN KEY (`userFrom_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_pxnwhc013h3bgt4gomyw7shpc` FOREIGN KEY (`dialogs_id`) REFERENCES `dialogs` (`id`),
  CONSTRAINT `FK_t4ca8dhp1rwepb6spa5804e3e` FOREIGN KEY (`userTo_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'2017-05-23 16:31:48','\0','\0','\0','','','Дщдд',1,4,1),(2,'2017-05-23 16:32:56','\0','\0','\0','','','gfdgfdg',1,4,1),(3,'2017-05-23 16:33:01','\0','\0','\0','','','gdfg',1,1,4),(4,'2017-06-04 10:12:41','\0','\0','\0','','','Hi Emilie)\r\nHow are you?',2,6,1),(5,'2017-06-04 13:21:59','\0','\0','\0','','','Oy hi hil)\ni\'m norm)',2,1,6),(6,'2017-06-05 11:18:39','\0','\0','\0','','\0','horosho',2,6,1);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kc6mvr611vy4kyfsg2654c22k` (`user_id`),
  CONSTRAINT `FK_kc6mvr611vy4kyfsg2654c22k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,'','2017-05-23 16:11:05','/resources/photo/user1/599928-1680x1050.jpg',0,1),(2,'\0','2017-05-23 16:11:05','/resources/photo/user1/celwalls.com_6101.jpg',0,1),(3,'\0','2017-05-23 16:11:05','/resources/photo/user1/poleznoe.ru_14955.jpg',0,1),(5,'','2017-05-23 16:15:46','/resources/photo/user2/ss-160812-twip-02_3380f5e9d30b766138155f8c3f11f9a8.nbcnews-fp-1200-800.jpg',0,2),(6,'','2017-05-23 16:27:52','/resources/photo/user4/pictures-2.jpg',0,4),(7,'\0','2017-05-23 16:28:15','/resources/photo/user4/ss-160812-twip-02_3380f5e9d30b766138155f8c3f11f9a8.nbcnews-fp-1200-800.jpg',0,4),(8,'','2017-06-01 14:14:06','/resources/photo/user5/1225895117_x_57ff459d.jpg',0,5),(9,'','2017-06-04 10:14:18','/resources/photo/user6/Hillary_Clinton_official_Secretary_of_State_portrait_crop.jpg',0,6),(10,'\0','2017-06-04 10:14:19','/resources/photo/user6/hillary-clinton-thumbs-up.jpg',0,6),(11,'\0','2017-06-04 10:14:19','/resources/photo/user6/Без названия.jpg',0,6),(15,'\0','2017-06-04 23:55:12','/resources/photo/user1/1396509321_kinopoisk.ru-emily-bett-rickards-2090885.jpg',0,1),(19,'\0','2017-06-05 00:08:24','/resources/photo/user1/968full-emily-bett-rickards.jpg',0,1);
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photocomments`
--

DROP TABLE IF EXISTS `photocomments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photocomments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `photo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5g29vv3c729kqw8q4g1o68o6k` (`photo_id`),
  CONSTRAINT `FK_5g29vv3c729kqw8q4g1o68o6k` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photocomments`
--

LOCK TABLES `photocomments` WRITE;
/*!40000 ALTER TABLE `photocomments` DISABLE KEYS */;
/*!40000 ALTER TABLE `photocomments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coments` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `text` longtext,
  `author_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bd50q8mj2ag7xxrdwbtokb8ht` (`author_id`),
  KEY `FK_g05xf29or7en755vc5j500sxl` (`user_id`),
  CONSTRAINT `FK_bd50q8mj2ag7xxrdwbtokb8ht` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_g05xf29or7en755vc5j500sxl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (2,0,'2017-05-23 16:30:18','павпвапр',4,4),(3,0,'2017-05-23 16:31:39','павпвап',4,1),(4,0,'2017-05-23 16:33:54','gdfgsdf',4,4);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postscomments`
--

DROP TABLE IF EXISTS `postscomments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postscomments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `text` longtext,
  `author_id` int(11) DEFAULT NULL,
  `posts_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pgnje1rho6b87u6xrps0x0cpb` (`author_id`),
  KEY `FK_r2e59cblm6sdgo20vfefsu156` (`posts_id`),
  CONSTRAINT `FK_pgnje1rho6b87u6xrps0x0cpb` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_r2e59cblm6sdgo20vfefsu156` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postscomments`
--

LOCK TABLES `postscomments` WRITE;
/*!40000 ALTER TABLE `postscomments` DISABLE KEYS */;
/*!40000 ALTER TABLE `postscomments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatarPath` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `who` varchar(255) DEFAULT NULL,
  `information_id` int(11) DEFAULT NULL,
  `posts_id` int(11) DEFAULT NULL,
  `postsComments_id` int(11) DEFAULT NULL,
  `userConfig_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_boi69b1vy1n9mc6eacsr2o1yi` (`information_id`),
  KEY `FK_rytbinxfyrm2kpvkvsjjvdynm` (`posts_id`),
  KEY `FK_c0qy7tc8tjwnod9kjigvqqw4v` (`postsComments_id`),
  KEY `FK_analvf2hayulb7kll57ktcvq` (`userConfig_id`),
  CONSTRAINT `FK_analvf2hayulb7kll57ktcvq` FOREIGN KEY (`userConfig_id`) REFERENCES `userconfig` (`id`),
  CONSTRAINT `FK_boi69b1vy1n9mc6eacsr2o1yi` FOREIGN KEY (`information_id`) REFERENCES `information` (`id`),
  CONSTRAINT `FK_c0qy7tc8tjwnod9kjigvqqw4v` FOREIGN KEY (`postsComments_id`) REFERENCES `postscomments` (`id`),
  CONSTRAINT `FK_rytbinxfyrm2kpvkvsjjvdynm` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'/resources/photo/user1/599928-1680x1050.jpg','qwe@qwe.qwe','Emily','qwe123','ROLE_USER','Bett',NULL,NULL,NULL,NULL,1),(2,'/resources/photo/user2/ss-160812-twip-02_3380f5e9d30b766138155f8c3f11f9a8.nbcnews-fp-1200-800.jpg','asd@asd.asd','Richard','asd456','ROLE_USER','Geil',NULL,NULL,NULL,NULL,2),(4,'/resources/photo/user4/pictures-2.jpg','a.v.k.9570@gmail.com','Artem','artem1995','ROLE_USER','Kindiak',NULL,NULL,NULL,NULL,4),(5,'/resources/photo/user5/1225895117_x_57ff459d.jpg','rorelapap@p33.org','Иван','qwerty123','ROLE_USER','Пупкин',NULL,3,NULL,NULL,5),(6,'/resources/photo/user6/Hillary_Clinton_official_Secretary_of_State_portrait_crop.jpg','wihumiyepa@p33.org','Hilary','hilary123','ROLE_USER','Clinton',NULL,4,NULL,NULL,6);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userconfig`
--

DROP TABLE IF EXISTS `userconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activated` bit(1) NOT NULL,
  `activationCode` int(11) NOT NULL,
  `block` bit(1) NOT NULL,
  `blockMessage` bit(1) NOT NULL,
  `blockPost` bit(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_woyxndc0gpkt87wyjnbf0b7g` (`user_id`),
  CONSTRAINT `FK_woyxndc0gpkt87wyjnbf0b7g` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userconfig`
--

LOCK TABLES `userconfig` WRITE;
/*!40000 ALTER TABLE `userconfig` DISABLE KEYS */;
INSERT INTO `userconfig` VALUES (1,'',17902396,'','\0','\0',1),(2,'',25946471,'','\0','\0',2),(4,'',9022723,'','\0','\0',4),(5,'',37894006,'','\0','\0',5),(6,'',88083705,'','\0','\0',6);
/*!40000 ALTER TABLE `userconfig` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-05 20:21:22
