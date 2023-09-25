-- MySQL dump 10.13  Distrib 5.5.40, for Win64 (x86)
--
-- Host: localhost    Database: db_campus_market
-- ------------------------------------------------------
-- Server version	5.5.40

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
-- Table structure for table `ylrc_comment`
--

DROP TABLE IF EXISTS `ylrc_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `reply_to` varchar(64) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd01gnchhuj06oumqxrikccc3r` (`goods_id`),
  KEY `FKswirics8hhydki5ff0emtmbii` (`student_id`),
  CONSTRAINT `FKd01gnchhuj06oumqxrikccc3r` FOREIGN KEY (`goods_id`) REFERENCES `ylrc_goods` (`id`),
  CONSTRAINT `FKswirics8hhydki5ff0emtmbii` FOREIGN KEY (`student_id`) REFERENCES `ylrc_studnet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_comment`
--

LOCK TABLES `ylrc_comment` WRITE;
/*!40000 ALTER TABLE `ylrc_comment` DISABLE KEYS */;
INSERT INTO `ylrc_comment` VALUES (3,'2022-06-12 21:44:43','2022-06-12 21:44:43','Still working good?',NULL,12,5),(4,'2022-06-12 21:47:00','2022-06-12 21:47:00','Does it available?','BobC',12,5),(5,'2022-06-12 22:07:22','2022-06-12 22:07:22','Reply：“Does it available?”\n应该没有了，这个很抢手的呀，你要抓紧才行。','BobC',12,5),(6,'2022-06-12 22:08:09','2022-06-12 22:08:09','Reply：“Can you offer a better price?？”<br>This is the Lowest Price.','BobC',12,5),(7,'2022-06-12 22:08:57','2022-06-12 22:08:57','Reply：“Still working good?”<br> Working good.','158549530922',12,5),(8,'2022-06-12 22:11:54','2022-06-12 22:11:54','Can you offer a better price?？',NULL,13,5),(9,'2022-06-12 22:12:59','2022-06-12 22:12:59','This is the Lowest Price.','Alice',13,3),(10,'2022-06-15 22:32:37','2022-06-15 22:32:37','That looks nice.',NULL,31,3);
/*!40000 ALTER TABLE `ylrc_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_database_bak`
--

DROP TABLE IF EXISTS `ylrc_database_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_database_bak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `filename` varchar(128) NOT NULL,
  `filepath` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_database_bak`
--

LOCK TABLES `ylrc_database_bak` WRITE;
/*!40000 ALTER TABLE `ylrc_database_bak` DISABLE KEYS */;
INSERT INTO `ylrc_database_bak` VALUES (31,'2022-06-23 17:46:49','2022-06-23 17:46:49','db_boot_base_20200323174649.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(32,'2022-06-24 12:29:33','2022-06-24 12:29:33','db_campus_market_20220624122933.sql','D:/Projects/FinalProject/CampusMarket/campus-market/src/main/resources/backup/'),(33,'2022-06-25 00:22:35','2022-06-25 00:22:35','db_campus_market_20220625002234.sql','D:/Projects/FinalProject/CampusMarket/campus-market/src/main/resources/backup/');
/*!40000 ALTER TABLE `ylrc_database_bak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_friend_link`
--

DROP TABLE IF EXISTS `ylrc_friend_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_friend_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(64) NOT NULL,
  `sort` int(11) NOT NULL,
  `url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_friend_link`
--

LOCK TABLES `ylrc_friend_link` WRITE;
/*!40000 ALTER TABLE `ylrc_friend_link` DISABLE KEYS */;
INSERT INTO `ylrc_friend_link` VALUES (18,'2022-06-24 12:47:08','2022-06-24 12:47:08','University of Birmingham',0,'https://www.birmingham.ac.uk/index.aspx');
/*!40000 ALTER TABLE `ylrc_friend_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_goods`
--

DROP TABLE IF EXISTS `ylrc_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `buy_price` float NOT NULL,
  `content` varchar(1024) NOT NULL,
  `flag` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `photo` varchar(128) NOT NULL,
  `recommend` int(11) NOT NULL,
  `sell_price` float NOT NULL,
  `status` int(11) NOT NULL,
  `goods_category_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `view_number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjtyl6pmb9j4aj64sm54xi1hbi` (`goods_category_id`),
  KEY `FKf68a0a9u8u8hqckg0ycnjarv6` (`student_id`),
  CONSTRAINT `FKf68a0a9u8u8hqckg0ycnjarv6` FOREIGN KEY (`student_id`) REFERENCES `ylrc_studnet` (`id`),
  CONSTRAINT `FKjtyl6pmb9j4aj64sm54xi1hbi` FOREIGN KEY (`goods_category_id`) REFERENCES `ylrc_goods_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_goods`
--

LOCK TABLES `ylrc_goods` WRITE;
/*!40000 ALTER TABLE `ylrc_goods` DISABLE KEYS */;
INSERT INTO `ylrc_goods` VALUES (1,'2022-06-06 21:39:29','2022-06-12 15:24:09',128,'Ape Limited 1.0 online launched on January 12, 2018, has now spent many days and nights, the initial positioning is simple, is to share some programming development experience accumulated by the webmaster in the study work, so that we can take less detours on the road to learning. Quickly grasp the method of learning, programming development ideas.\n\nUp to now, the cumulative number of people who have learned the practical development tutorials released by Ape to this has exceeded 50,000, some people appreciate it and some people criticize it.\n\nNow, the Beta version is launched to help more and more people in a wider level. You can also show your skills, record and publish your own tutorial resources to help others learn and get income at the same time. You can also recommend other apes to learn here, and you will be rewarded!\n\n',0,'Online Course Java Programming','20200408/1586344264407.png',0,127,1,39,2,35),(5,'2022-06-06 21:54:28','2022-06-11 15:17:45',5888,'The phone is an iPhone 5s, used for more than two years, very well maintained, the phone screen has not been replaced, save very complete. Please contact me if you are interested.',0,'iPhone5s','20200406/1586181213129.jpg',0,588,1,4,2,26),(6,'2022-06-11 15:13:43','2022-06-15 19:20:15',6999,'Asus tablet computer ultra-thin very beautiful feel good 8-inch screen size suitable for easy to carry 4G running memory 64G storage and can be inserted into the memory card watching movies WeChat video entertainment games are very smooth use comfortable. The machine has not been disassembled and not repaired all original quality assurance. With data cable charger',0,'Ultra-thin Tablet PC','20200411/1586589170711.png',1,1698,1,11,2,1),(7,'2022-06-11 15:15:19','2022-06-12 12:40:34',399,'Shoes too much 38 yards to 41 yards 9.5 new',1,'High-top shoes','20200411/1586589269693.png',0,159,2,35,2,0),(8,'2022-06-11 15:25:38','2022-06-11 15:26:06',59,'Podcast: Lu Yao',0,'The ordinary world-Novel Lu Yao','20200411/1586589915016.png',0,5,1,17,3,1),(9,'2022-06-11 15:28:52','2022-06-11 21:20:01',9999,'Cartier Santos large size watch diameter: 38.4 x 51mm ',0,'Cartier watches','20200411/1586590067910.jpg',0,3999,1,54,3,2),(10,'2022-06-11 16:55:10','2022-06-16 19:39:20',25,'Soft phone cover',0,'Soft phone cover','20200411/1586595290815.jpg',0,5,1,5,3,8),(11,'2022-06-11 16:56:13','2022-06-11 16:56:13',399,'Nokia\'s slider phone, bought more than a thousand, what specific model confused. It is not disassembled and repaired, and all functions are normal. ',0,'Slider phone','20200411/1586595364409.jpg',0,80,1,6,3,0),(12,'2022-06-11 16:57:12','2022-06-15 22:26:42',690,'Sharp flip cover machine, with solar panel assistance, before it has been used by girls, due to the very early use of smart phones have been idle (to maintain the state, on the charge to maintain the normal frequency), abandoned unfortunately; machine conservative that 80% new, standby 3-4 days, as a backup machine or the elderly machine no problem, no demolition no repair no water, can use mobile, Unicom 2G.',0,'Sharp flip-top Phone with solar panel assist','20200411/1586595414403.jpeg',0,160,1,7,3,45),(13,'2022-06-11 21:05:32','2022-06-15 22:26:32',8999,'The company\'s own employees use the computer, the function are normal, normal signs of use, the configuration is i5 processor, 4g memory 320g hard disk, independent integrated dual graphics card. During the epidemic to children\'s Internet classes, look at the video, office learning are good, dual side stereo audio, 15.6-inch large screen, the company\'s own employees use the computer, do not power adapter can be less than a hundred dollars, low price to deal with!',0,'macbook pro15 Laptop','20200411/1586610285979.jpg',0,1599,1,9,3,7),(14,'2022-06-11 21:08:41','2022-06-24 22:09:48',6999,'Transfer three units of the same HuaNiu Apple model i3 all-in-one computer very new, selling 1000 yuan a, configuration as shown; CPU; core i3 M380 @ 2.53GHz,',0,'Quad-core All-in-One PC','20200411/1586610506621.jpg',0,1269,1,10,3,12),(15,'2022-06-11 21:12:41','2022-06-24 22:12:48',299,'1. Model: Mito headphones original in-line in-ear music headphones ; ',0,'Music headphones with in-line control','20200411/1586610735654.jpg',0,29,1,16,3,2),(16,'2022-06-11 21:14:03','2022-06-12 22:12:18',8999,'The HP i5 quad-core gaming machine laptop, 95 new, 4G memory! ',0,'i5 Quad-core Gaming Machine Laptop','20200411/1586610811445.jpg',0,1700,1,18,3,1),(17,'2022-06-11 21:15:52','2022-06-12 15:02:27',599,'SONY Sony VGP-WKB5IE classic wireless keyboard collection grade, good quality, only a little trace of use. Please see the pictures for the specific color, in kind. This model is Sony\'s classic design models, rarely seen on the market! Keyboard using four sister 5 battery power supply, the keyboard on the power display. Because I do not have a matching computer test so I can not guarantee that the link functions properly. (This requires Sony\'s host with the use of). ',0,'SONY Keyboard','20200411/1586610934287.jpg',0,200,1,19,3,97),(18,'2022-06-11 21:16:58','2022-06-12 11:43:39',580,'New original Apple mouse is not opened, because bought a duplicate, the official website price of 580 yuan, I offer 500 yuan.',0,'Apple original mouse','20200411/1586610997167.jpg',0,500,1,20,3,1),(19,'2022-06-11 21:21:08','2022-06-11 23:43:45',998,'This product needs to be used with storage; with a mobile hard drive you can connect the mobile hard drive to the Magic Box, install an APP on your phone, you can upload and download so the mobile hard drive information through your phone, install a client on your computer, you can also upload and download and modify the mobile hard drive information through your computer. Very convenient, equivalent to a network drive. And you can share what you want to share, and encrypt what you want to encrypt, so no one can see it. And is a double backup, even if the hard disk is broken, lost, you can also restore a key Oh!\n\nTranslated with www.DeepL.com/Translator (free version)',0,'12T Mobile Hard Drives','20200411/1586611245599.jpg',0,289,1,22,3,1),(20,'2022-06-11 21:22:10','2022-06-16 19:39:29',1980,'MINOX M3 LEICA digital camera good function with the original battery, no charger, can be charged through the USB port, without a card. Only one machine. And its production is beautiful, suitable for collection! About the parameters of the machine, please Baidu, the store is not responsible for science! ',0,'MINOX M3 LEICA Camera','20200411/1586611303491.jpg',0,920,1,23,3,4),(21,'2022-06-11 21:23:09','2022-06-16 19:40:44',2980,'1.Model request: Yizhuo mx191 ',0,'Eizo MX191 Monitor','20200411/1586611370203.jpg',0,1980,1,24,3,2),(22,'2022-06-11 21:25:14','2022-06-11 21:25:14',75,'Derek Angenet F11165 PU basketball youth elementary school indoor and outdoor training basketball wear-resistant elastic good',0,'Basketball','20200411/1586611479618.jpg',0,57,1,26,3,0),(23,'2022-06-11 21:27:46','2022-06-11 21:27:46',78,'Factory direct sales of children\'s soccer ball machine sewing soccer ball No. 4 No. 5 soccer six colors optional wear-resistant soccer sporting goods',0,'Soccer sporting goods','20200411/1586611630115.jpg',0,66,1,27,3,0),(24,'2022-06-11 21:30:06','2022-06-16 19:38:47',24,'Guangyu No.2 black goose feather badminton wholesale 12pcs family recreational type ballroom training super durable badminton',0,'Badminton 12','20200411/1586611756004.jpg',0,22,1,28,2,2),(25,'2022-06-11 21:31:27','2022-06-15 19:12:46',37,'Product Name】Crossway ',0,'Table Tennis Racket','20200411/1586611861285.jpg',1,27,1,29,2,0),(26,'2022-06-11 23:58:05','2022-06-15 19:13:32',35,'Product parameters.',0,'White T-shirt','20200411/1586620659982.jpg',1,25,1,31,4,0),(27,'2022-06-11 23:59:22','2022-06-15 19:13:27',69,'Product parameters.',0,'Casual pants male','20200411/1586620738132.jpg',1,39,1,32,4,3),(28,'2022-06-12 00:01:34','2022-06-15 19:13:23',235,'Brand: other / other texture: nylon fabric closure: zipper pattern: solid color style: Japan and Korea shape: vertical square color: new gender: male popular elements: stitching color classification: light gray medium black medium black large light gray large black plus version internal structure: cell phone pockets computer insert pockets with or without lamination: Yes Item No.: 0701251361536 applicable scene: casual lining material Material: acrylic shoulder strap style: double applicable object: youth carry parts type: soft handle outside the bag type: inside the bag hardness: soft size: medium waterproof degree: water-resistant whether back cushioning cotton: Yes to accommodate the computer size: 14 inches',0,'Waterproof nylon fabric bag','20200412/1586620860709.png',1,125,1,33,4,0),(29,'2022-06-12 00:03:39','2022-06-18 17:22:03',65,'Product parameters.',0,'Business umbrella rain or shine','20200412/1586620999408.jpg',1,25,1,34,4,26),(30,'2022-06-12 00:04:51','2022-06-16 19:39:02',56,'Brand: Hong Yi Material: mixed materialApplicable gender: femalePattern: plant floralStyle: ethnic windWhether in stock: inlaid material: not inlaidCondition: newPrice range: 10-19',0,'Brooch natural jade pearls','20200412/1586621065769.jpg',1,25,1,36,4,6),(31,'2022-06-12 00:07:24','2022-06-15 22:35:46',799,'v',0,'Hawaiian small guitar Starway SDW-UK268','20200412/1586621219617.jpg',0,499,1,38,4,38);
/*!40000 ALTER TABLE `ylrc_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_goods_category`
--

DROP TABLE IF EXISTS `ylrc_goods_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `name` varchar(48) NOT NULL,
  `sort` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKos35mkmw4k5dvi4fi2govg2pa` (`parent_id`),
  CONSTRAINT `FKos35mkmw4k5dvi4fi2govg2pa` FOREIGN KEY (`parent_id`) REFERENCES `ylrc_goods_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_goods_category`
--

LOCK TABLES `ylrc_goods_category` WRITE;
/*!40000 ALTER TABLE `ylrc_goods_category` DISABLE KEYS */;
INSERT INTO `ylrc_goods_category` VALUES (1,'2022-06-02 20:20:05','2022-06-24 12:51:49','20200402/1585834512163.png','Mobile',0,NULL),(4,'2022-06-02 20:26:45','2022-06-24 12:52:12','20200402/1585834542235.png','Smart phone',1,1),(5,'2022-06-02 21:13:04','2022-06-02 21:36:24','20200402/1585834572308.png','Phone Accessories',2,1),(6,'2022-06-02 21:37:05','2022-06-24 13:23:45','20200402/1585834607924.png','Sliding Cover',3,1),(7,'2022-06-02 21:37:23','2022-06-24 13:23:56','20200402/1585834633735.png','Flap Cover',4,1),(8,'2022-06-02 21:37:50','2022-06-24 13:24:51','20200402/1585834662625.png','Computer',5,NULL),(9,'2022-06-02 21:38:08','2022-06-24 13:25:08','20200402/1585834679788.png','Laptop',6,8),(10,'2022-06-02 21:38:26','2022-06-24 13:25:21','20200402/1585834694895.png','Desktop',7,8),(11,'2022-06-02 21:38:45','2022-06-24 13:25:39','20200402/1585834717184.png','Tablet',8,8),(15,'2022-06-05 18:46:54','2022-06-24 13:25:55','20200405/1586084764264.png','Audio/Video',9,NULL),(16,'2022-06-05 19:06:56','2022-06-24 13:26:24','20200405/1586084805468.png','Earphone',10,15),(17,'2022-06-05 19:07:45','2022-06-05 19:07:45','20200405/1586084854001.png','MP3/MP4',11,15),(18,'2022-06-05 19:08:15','2022-06-05 19:08:15','20200405/1586084878657.png','Game Machine',12,15),(19,'2022-06-05 19:08:44','2022-06-05 19:08:44','20200405/1586084911580.png','Keyboard',13,15),(20,'2022-06-05 19:09:04','2022-06-05 19:09:04','20200405/1586084936056.png','Mouse',14,15),(21,'2022-06-05 19:10:14','2022-06-05 19:10:14','20200405/1586085005899.png','Digital Accessories',15,NULL),(22,'2022-06-05 19:10:45','2022-06-05 19:10:45','20200405/1586085024716.png','Mobile Hard Drives',16,21),(23,'2022-06-05 19:11:08','2022-06-05 19:11:08','20200405/1586085052292.png','Camera',17,21),(24,'2022-06-05 19:11:25','2022-06-05 19:11:25','20200405/1586085077518.png','Monitor',18,21),(25,'2022-06-05 19:11:50','2022-06-05 19:11:50','20200405/1586085102042.png','Sports & Fitness',19,NULL),(26,'2022-06-05 19:12:13','2022-06-05 19:12:13','20200405/1586085124703.png','Basketball',20,25),(27,'2022-06-05 19:12:34','2022-06-05 19:12:34','20200405/1586085152812.png','Soccer',21,25),(28,'2022-06-05 19:12:53','2022-06-05 19:12:53','20200405/1586085164372.png','Badminton',22,25),(29,'2022-06-05 19:13:11','2022-06-05 19:13:11','20200405/1586085182130.png','Rackets',23,25),(30,'2022-06-05 19:13:50','2022-06-05 19:13:50','20200405/1586085217886.png','Clothes, shoes and hats',24,NULL),(31,'2022-06-05 19:14:15','2022-06-05 19:14:15','20200405/1586085239138.png','Top Clothes',25,30),(32,'2022-06-05 19:14:30','2022-06-05 19:14:30','20200405/1586085262037.png','Pants',26,30),(33,'2022-06-05 19:14:48','2022-06-05 19:14:48','20200405/1586085278533.png','Backpack',27,30),(34,'2022-06-05 19:15:12','2022-06-05 19:15:12','20200405/1586085302412.png','Umbrella',28,30),(35,'2022-06-05 19:15:29','2022-06-05 19:15:29','20200405/1586085319791.png','Shoes',29,30),(36,'2022-06-05 19:15:55','2022-06-05 19:15:55','20200405/1586085349204.png','Accessories',30,30),(37,'2022-06-05 19:16:38','2022-06-05 19:16:38','20200405/1586085388834.png','Life & Entertainment',31,NULL),(38,'2022-06-05 19:17:05','2022-06-05 19:17:05','20200405/1586085407122.png','Musical Instrument',32,37),(39,'2022-06-05 19:17:22','2022-06-05 19:17:22','20200405/1586085433434.png','Virtual Account',33,37),(40,'2022-06-05 19:17:39','2022-06-05 19:17:39','20200405/1586085449303.png','Membership Card',34,37),(41,'2022-06-05 19:18:00','2022-06-05 19:18:00','20200405/1586085471766.png','Cosmetics',35,37),(42,'2022-06-05 19:18:31','2022-06-05 19:18:31','20200405/1586085499095.png','Books & Materials',36,NULL),(43,'2022-06-05 19:18:49','2022-06-05 19:18:49','20200405/1586085520436.png','Textbooks',37,42),(44,'2022-06-05 19:19:05','2022-06-05 19:19:05','20200405/1586085534371.png','Exam Materials',38,42),(45,'2022-06-05 19:19:24','2022-06-05 19:19:24','20200405/1586085556673.png','Extra-curricular Books',39,42),(46,'2022-06-05 19:19:54','2022-06-05 19:19:54','20200405/1586085585909.png','Transportation',40,NULL),(47,'2022-06-05 19:20:18','2022-06-05 19:20:18','20200405/1586085604095.png','Bicycles',41,46),(48,'2022-06-05 19:20:35','2022-06-05 19:20:35','20200405/1586085624951.png','Electric Vehicles',42,46),(49,'2022-06-05 19:21:01','2022-06-05 19:21:01','20200405/1586085652162.png','Transportation Card',43,46),(50,'2022-06-05 19:21:29','2022-06-05 19:21:29','20200405/1586085681117.png','Personal Skills',44,NULL),(51,'2022-06-05 19:21:47','2022-06-05 19:21:47','20200405/1586085696883.png','Photography',45,50),(52,'2022-06-05 19:22:05','2022-06-05 19:22:05','20200405/1586085714915.png','Painting',46,50),(53,'2022-06-05 19:22:29','2022-06-05 19:22:29','20200405/1586085739125.png','Others',46,NULL),(54,'2022-06-11 21:19:25','2022-06-11 21:19:40','20200411/1586611155253.png','Watches',47,21),(55,'2022-06-12 22:31:58','2022-06-12 22:32:08','20200412/1586701902327.png','Other subcategories',48,53);
/*!40000 ALTER TABLE `ylrc_goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_menu`
--

DROP TABLE IF EXISTS `ylrc_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(32) NOT NULL,
  `url` varchar(128) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_bitton` bit(1) NOT NULL,
  `is_show` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsbtnjocfrq29e8taxdwo21gic` (`parent_id`),
  CONSTRAINT `FKsbtnjocfrq29e8taxdwo21gic` FOREIGN KEY (`parent_id`) REFERENCES `ylrc_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_menu`
--

LOCK TABLES `ylrc_menu` WRITE;
/*!40000 ALTER TABLE `ylrc_menu` DISABLE KEYS */;
INSERT INTO `ylrc_menu` VALUES (2,'2022-06-14 14:26:03','2022-06-24 21:01:52','System Settings','','mdi-settings',0,NULL,'\0',''),(3,'2022-06-14 16:58:55','2022-06-24 21:02:23','Menu','/admin/menu/list','mdi-view-list',1,2,'\0',''),(5,'2022-06-14 17:04:44','2022-06-24 21:02:50','Add','/admin/menu/add','mdi-plus',2,3,'\0',''),(7,'2022-06-14 17:07:43','2022-06-24 21:03:41','Role','/admin/role/list','mdi-account-settings-variant',5,2,'\0',''),(8,'2022-06-14 18:28:48','2022-06-24 21:03:03','Edit','edit(\'/admin/menu/edit\')','mdi-grease-pencil',3,3,'',''),(9,'2022-06-14 18:30:00','2022-06-24 21:03:17','Delete','del(\'/admin/menu/delete\')','mdi-close',4,3,'',''),(10,'2022-06-15 12:12:00','2022-06-24 21:03:53','Add','/admin/role/add','mdi-account-plus',6,7,'\0',''),(11,'2022-06-15 12:12:36','2022-06-21 22:10:45','Edit','edit(\'/admin/role/edit\')','mdi-account-edit',7,7,'',''),(12,'2022-06-15 12:13:19','2022-06-21 22:15:27','Delete','del(\'/admin/role/delete\')','mdi-account-remove',8,7,'',''),(13,'2022-06-15 12:14:52','2022-06-15 12:17:00','User','/admin/user/list','mdi-account-multiple',9,2,'\0',''),(14,'2022-06-15 12:15:22','2022-06-15 12:17:27','Add','/admin/user/add','mdi-account-plus',10,13,'\0',''),(15,'2022-06-16 17:18:14','2022-06-21 22:11:19','Edit','edit(\'/admin/user/edit\')','mdi-account-edit',11,13,'',''),(16,'2022-06-16 17:19:01','2022-06-21 22:15:36','Delete','del(\'/admin/user/delete\')','mdi-account-remove',12,13,'',''),(19,'2022-06-22 11:24:36','2022-06-22 11:26:00','Upload Photo','/admin/upload/upload_photo','mdi-arrow-up-bold-circle',0,13,'\0','\0'),(20,'2022-06-22 14:09:35','2022-06-22 14:09:47','Logs','/system/operator_log_list','mdi-tag-multiple',13,2,'\0',''),(21,'2022-06-22 14:11:39','2022-06-22 14:11:39','Delete','del(\'/system/delete_operator_log\')','mdi-tag-remove',14,20,'',''),(22,'2022-06-22 14:12:57','2022-06-22 14:46:55','Clear all logs','delAll(\'/system/delete_all_operator_log\')','mdi-delete-circle',15,20,'',''),(23,'2022-06-22 14:46:40','2022-06-22 14:47:09','Databases Bakeup','/admin/database_bak/list','mdi-database',16,2,'\0',''),(24,'2022-06-22 14:48:07','2022-06-22 15:13:41','Bakeup','add(\'/admin/database_bak/add\')','mdi-database-plus',17,23,'',''),(25,'2022-06-22 14:49:03','2022-06-22 14:49:03','Delete','del(\'/admin/database_bak/delete\')','mdi-database-minus',18,23,'',''),(26,'2022-06-22 19:36:20','2022-06-22 19:36:20','Restore','restore(\'/admin/database_bak/restore\')','mdi-database-minus',19,23,'',''),(27,'2022-06-01 20:35:09','2022-06-01 20:35:09','Goods Mgt','/admin/goods_category/list','mdi-dialpad',0,NULL,'\0',''),(28,'2022-06-01 20:35:46','2022-06-12 22:28:09','Category','/admin/goods_category/list','mdi-apps',0,27,'\0',''),(29,'2022-06-01 20:36:27','2022-06-12 22:30:39','Goods List','/admin/goods/list','mdi-cart',0,27,'\0',''),(30,'2022-06-01 20:40:48','2022-06-12 22:28:34','Add','/admin/goods_category/add','mdi-battery-positive',0,28,'\0',''),(31,'2022-06-01 20:41:33','2022-06-12 22:30:02','Edit','edit(\'/admin/goods_category/edit\')','mdi-border-color',0,28,'',''),(32,'2022-06-01 20:42:15','2022-06-12 22:30:21','Delete','del(\'/admin/goods_category/delete\')','mdi-close',0,28,'',''),(33,'2022-06-13 18:52:12','2022-06-13 18:52:12','Onshelf','up(\'/admin/goods/up_down\')','mdi-arrow-up-bold-box',0,29,'',''),(34,'2022-06-13 18:52:55','2022-06-13 18:52:55','Offshelf','down(\'/admin/goods/up_down\')','mdi-arrow-down-bold-box',0,29,'',''),(35,'2022-06-13 18:54:10','2022-06-15 19:17:48','Delete','del(\'/admin/goods/delete\')','mdi-close-box',0,29,'',''),(36,'2022-06-15 19:06:49','2022-06-15 19:06:49','Recommend','recommend(\'/admin/goods/recommend\')','mdi-thumb-up',0,29,'',''),(37,'2022-06-15 19:07:45','2022-06-15 19:07:45','Cancel Recommend','unrecommend(\'/admin/goods/recommend\')','mdi-thumb-down',0,29,'',''),(38,'2022-06-15 19:32:16','2022-06-15 19:32:16','Request Goods','/admin/wanted_goods/list','mdi-ticket',0,27,'\0',''),(39,'2022-06-15 19:32:55','2022-06-15 19:59:53','Delete','del(\'/admin/wanted_goods/delete\')','mdi-close-box',0,38,'',''),(40,'2022-06-15 20:02:04','2022-06-15 20:02:04','Student Mgt','/admin/student/list','mdi-account-multiple',0,NULL,'\0',''),(41,'2022-06-15 20:02:38','2022-06-15 20:02:38','Student List','/admin/student/list','mdi-account-multiple',0,40,'\0',''),(42,'2022-06-15 20:06:28','2022-06-15 20:06:28','Freeze','freeze(\'/admin/student/update_status\')','mdi-account-settings-variant',0,41,'',''),(43,'2022-06-15 20:06:59','2022-06-15 21:45:31','Activate','openStudent(\'/admin/student/update_status\')','mdi-account-key',0,41,'',''),(44,'2022-06-15 20:07:33','2022-06-15 20:07:33','Delete','del(\'/admin/student/delete\')','mdi-account-remove',0,41,'',''),(45,'2022-06-15 21:52:57','2022-06-15 21:52:57','Comment Mgt','/admin/comment/list','mdi-comment-account',0,NULL,'\0',''),(46,'2022-06-15 21:53:39','2022-06-15 21:53:39','Comment List','/admin/comment/list','mdi-comment-multiple-outline',0,45,'\0',''),(47,'2022-06-15 21:54:35','2022-06-15 21:54:35','Delete','del(\'/admin/comment/delete\')','mdi-message-bulleted-off',0,46,'',''),(48,'2022-06-16 19:28:48','2022-06-16 19:28:48','Report Mgt','/admin/report/list','mdi-alert',0,NULL,'\0',''),(49,'2022-06-16 19:30:31','2022-06-16 19:30:31','Report List','/admin/report/list','mdi-view-headline',0,48,'\0',''),(50,'2022-06-16 19:31:09','2022-06-16 19:31:09','Delete','del(\'/admin/report/delete\')','mdi-close-box',0,49,'',''),(51,'2022-06-16 19:46:08','2022-06-16 19:46:08','News Mgt','/admin/news/list','mdi-onenote',0,NULL,'\0',''),(52,'2022-06-16 19:46:39','2022-06-16 19:46:39','Notice Board','/admin/news/list','mdi-book-open',0,51,'\0',''),(53,'2022-06-16 19:48:01','2022-06-16 19:48:01','Add','/admin/news/add','mdi-plus',0,52,'\0',''),(54,'2022-06-16 19:48:46','2022-06-16 19:48:46','Edit','edit(\'/admin/news/edit\')','mdi-border-color',0,52,'',''),(55,'2022-06-16 19:49:37','2022-06-16 19:49:37','Delete','del(\'/admin/news/delete\')','mdi-close',0,52,'',''),(56,'2022-06-18 14:25:58','2022-06-18 14:25:58','Websit Settings','','mdi-settings',0,NULL,'\0',''),(57,'2022-06-18 14:27:31','2022-06-18 14:27:31','Friend Link','/admin/friend_link/list','mdi-vector-line',0,56,'\0',''),(58,'2022-06-18 14:28:36','2022-06-18 14:28:36','Add','/admin/friend_link/add','mdi-plus',0,57,'\0',''),(59,'2022-06-18 14:29:17','2022-06-18 15:38:53','Edit','edit(\'/admin/friend_link/edit\')','mdi-border-color',0,57,'',''),(60,'2022-06-18 14:29:45','2022-06-18 14:29:45','Delete','del(\'/admin/friend_link/delete\')','mdi-close-box',0,57,'',''),(61,'2022-06-18 16:26:45','2022-06-18 16:26:45','Website settings','/admin/site_setting/setting','mdi-wrench',0,56,'\0',''),(62,'2022-06-18 16:28:25','2022-06-18 16:28:25','Submit a modification','/admin/site_setting/save_setting','mdi-marker-check',0,61,'','\0');
/*!40000 ALTER TABLE `ylrc_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_news`
--

DROP TABLE IF EXISTS `ylrc_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(10024) NOT NULL,
  `sort` int(11) NOT NULL,
  `title` varchar(1024) NOT NULL,
  `view_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_news`
--

LOCK TABLES `ylrc_news` WRITE;
/*!40000 ALTER TABLE `ylrc_news` DISABLE KEYS */;
INSERT INTO `ylrc_news` VALUES (1,'2022-06-16 21:29:17','2022-06-24 18:22:50','MSc Computer Science Final Project @ UOBD @ Jiang Chufeng',2,'About Sunset Oasis',1),(2,'2022-06-16 21:29:49','2022-06-24 18:20:36','1. Prohibition and restriction on the release of goods management rules\r\n2. Repeatedly store goods management rules\r\n3. Payment method does not match the rules of commodity management\r\n4. Commodity price, postage does not match the rules of commodity management\r\n5. Credit speculation commodity management rules',0,'Rules for Posting Goods',0),(3,'2022-06-16 21:30:22','2022-06-24 18:22:55','When registering, please fill in the detailed registration information, and the student number is required.',1,'Registration rules',1);
/*!40000 ALTER TABLE `ylrc_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_operater_log`
--

DROP TABLE IF EXISTS `ylrc_operater_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_operater_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `operator` varchar(18) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=430 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_operater_log`
--

LOCK TABLES `ylrc_operater_log` WRITE;
/*!40000 ALTER TABLE `ylrc_operater_log` DISABLE KEYS */;
INSERT INTO `ylrc_operater_log` VALUES (394,'2022-06-24 12:29:33','2022-06-24 12:29:33','Successful backup with file information: DatabaseBak [filename=db_campus_market_20220624122933.sql, filepath=D:/Projects/FinalProject/CampusMarket/campus-market/src/main/resources/backup/]','Jiang Chufeng'),(395,'2022-06-24 12:34:29','2022-06-24 12:34:29','Edit User, user name: jiangchufeng','Jiang Chufeng'),(396,'2022-06-24 12:34:53','2022-06-24 12:34:53','Edit User, user name: Test','Jiang Chufeng'),(397,'2022-06-24 12:35:12','2022-06-24 12:35:12','Edit User, user name: Alice','Jiang Chufeng'),(398,'2022-06-24 12:35:29','2022-06-24 12:35:29','Edit User, user name: Jiang Chufeng','Jiang Chufeng'),(399,'2022-06-24 12:35:52','2022-06-24 12:35:52','Edit User, user name: Serendi','Jiang Chufeng'),(400,'2022-06-24 12:36:19','2022-06-24 12:36:19','Edit Role [Super Admin]','Jiang Chufeng'),(401,'2022-06-24 12:36:46','2022-06-24 12:36:46','Edit Role [Super Admin]','Jiang Chufeng'),(402,'2022-06-24 12:37:32','2022-06-24 12:37:32','Edit Role [Normal Admin]','Jiang Chufeng'),(403,'2022-06-24 12:37:46','2022-06-24 12:37:46','Edit Role [Normal Admin]','Jiang Chufeng'),(404,'2022-06-24 12:38:21','2022-06-24 12:38:21','Edit Role [Test User]','Jiang Chufeng'),(405,'2022-06-24 12:38:35','2022-06-24 12:38:35','Edit Role [Normal Admin]','Jiang Chufeng'),(406,'2022-06-24 12:40:05','2022-06-24 12:40:05','User [ Jiang Chufeng ] log in at [2022-06-24 12:40:05]','Jiang Chufeng'),(407,'2022-06-24 12:42:00','2022-06-24 12:42:00','User [ Jiang Chufeng ] log in at [2022-06-24 12:42:00]','Jiang Chufeng'),(408,'2022-06-24 12:45:58','2022-06-24 12:45:58','Bulk deletion of friend links, friend links IDS: 11,1,15,16,17','Jiang Chufeng'),(409,'2022-06-24 12:47:08','2022-06-24 12:47:08','Add a friend link: FriendLink [name=University of Birmingham, url=https://www.birmingham.ac.uk/index.aspx, sort=0]','Jiang Chufeng'),(410,'2022-06-24 12:48:39','2022-06-24 12:48:39','Edit Websit Settings:SiteSetting [siteName=Sunset Oasis, siteUrl=www.sunset_oasis.com, logo1=20220618/1587201658762.png, logo2=20220618/1587201663687.png, qrcode=20220618/1587201667179.png, allRights=©2022-2022 [Sunset Oasis University] Copy Right @ MSc CS Jiang Chufeng]','Jiang Chufeng'),(411,'2022-06-24 12:49:03','2022-06-24 12:49:03','Edit Websit Settings:SiteSetting [siteName=Sunset Oasis, siteUrl=www.sunset_oasis.com, logo1=20220618/1587201658762.png, logo2=20220618/1587201663687.png, qrcode=20220618/1587201667179.png, allRights=©2022-2022 [ Sunset Oasis University ] Copy Right @ MSc CS Jiang Chufeng]','Jiang Chufeng'),(412,'2022-06-24 13:19:52','2022-06-24 13:19:52','User [ Jiang Chufeng ] log in at [2022-06-24 13:19:52]','Jiang Chufeng'),(413,'2022-06-24 18:17:19','2022-06-24 18:17:19','User [ Jiang Chufeng ] log in at [2022-06-24 18:17:19]','Jiang Chufeng'),(414,'2022-06-24 18:20:36','2022-06-24 18:20:36','Edit a press release:News [title=Rules for Posting Goods, content=1. Prohibition and restriction on the release of goods management rules\r\n2. Repeatedly store goods management rules\r\n3. Payment method does not match the rules of commodity management\r\n4. Commodity price, postage does not match the rules of commodity management\r\n5. Credit speculation commodity management rules, viewNumber=0, sort=0]','Jiang Chufeng'),(415,'2022-06-24 18:21:18','2022-06-24 18:21:18','Edit a press release:News [title=Registration rules, content=When registering, please fill in the detailed registration information, and the student number is required., viewNumber=0, sort=1]','Jiang Chufeng'),(416,'2022-06-24 18:22:40','2022-06-24 18:22:40','Edit a press release:News [title=About Sunset Oasis, content=MSc Computer Science Final Project @ UOBD @ Jiang Chufeng, viewNumber=0, sort=2]','Jiang Chufeng'),(417,'2022-06-24 21:01:02','2022-06-24 21:01:02','User [ Jiang Chufeng ] log in at [2022-06-24 21:01:02]','Jiang Chufeng'),(418,'2022-06-24 21:01:52','2022-06-24 21:01:52','Edit menu information [Menu [name=System Settings, parent=null, url=, icon=mdi-settings, sort=0, isButton=false, isShow=true]]','Jiang Chufeng'),(419,'2022-06-24 21:02:24','2022-06-24 21:02:24','Edit menu information [Menu [name=Menu Management, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/menu/list, icon=mdi-view-list, sort=1, isButton=false, isShow=true]]','Jiang Chufeng'),(420,'2022-06-24 21:02:50','2022-06-24 21:02:50','Edit menu information [Menu [name=Add, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/menu/add, icon=mdi-plus, sort=2, isButton=false, isShow=true]]','Jiang Chufeng'),(421,'2022-06-24 21:03:03','2022-06-24 21:03:03','Edit menu information [Menu [name=Edit, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=edit(\'/admin/menu/edit\'), icon=mdi-grease-pencil, sort=3, isButton=true, isShow=true]]','Jiang Chufeng'),(422,'2022-06-24 21:03:17','2022-06-24 21:03:17','Edit menu information [Menu [name=Delete, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=del(\'/admin/menu/delete\'), icon=mdi-close, sort=4, isButton=true, isShow=true]]','Jiang Chufeng'),(423,'2022-06-24 21:03:41','2022-06-24 21:03:41','Edit menu information [Menu [name=Role Management, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/role/list, icon=mdi-account-settings-variant, sort=5, isButton=false, isShow=true]]','Jiang Chufeng'),(424,'2022-06-24 21:03:53','2022-06-24 21:03:53','Edit menu information [Menu [name=Add, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/role/add, icon=mdi-account-plus, sort=6, isButton=false, isShow=true]]','Jiang Chufeng'),(425,'2022-06-24 21:04:19','2022-06-24 21:04:19','User [ Jiang Chufeng ] log in at [2022-06-24 21:04:19]','Jiang Chufeng'),(426,'2022-06-24 21:13:30','2022-06-24 21:13:30','User [ Jiang Chufeng ] log in at [2022-06-24 21:13:30]','Jiang Chufeng'),(427,'2022-06-24 21:16:48','2022-06-24 21:16:48','User [ Jiang Chufeng ] log in at [2022-06-24 21:16:48]','Jiang Chufeng'),(428,'2022-06-25 00:22:19','2022-06-25 00:22:19','User [ Jiang Chufeng ] log in at [2022-06-25 00:22:19]','Jiang Chufeng'),(429,'2022-06-25 00:22:35','2022-06-25 00:22:35','Successful backup with file information: DatabaseBak [filename=db_campus_market_20220625002234.sql, filepath=D:/Projects/FinalProject/CampusMarket/campus-market/src/main/resources/backup/]','Jiang Chufeng');
/*!40000 ALTER TABLE `ylrc_operater_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_report_goods`
--

DROP TABLE IF EXISTS `ylrc_report_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_report_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g0s4688rq2bnty1u1ev1rgly` (`goods_id`),
  KEY `FKmr7s3q3jpq824h69f5ip9gleq` (`student_id`),
  CONSTRAINT `FK6g0s4688rq2bnty1u1ev1rgly` FOREIGN KEY (`goods_id`) REFERENCES `ylrc_goods` (`id`),
  CONSTRAINT `FKmr7s3q3jpq824h69f5ip9gleq` FOREIGN KEY (`student_id`) REFERENCES `ylrc_studnet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_report_goods`
--

LOCK TABLES `ylrc_report_goods` WRITE;
/*!40000 ALTER TABLE `ylrc_report_goods` DISABLE KEYS */;
INSERT INTO `ylrc_report_goods` VALUES (5,'2022-06-12 12:00:49','2022-06-12 12:00:49','涉嫌广告传销！',20,2);
/*!40000 ALTER TABLE `ylrc_report_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_role`
--

DROP TABLE IF EXISTS `ylrc_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(18) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_role`
--

LOCK TABLES `ylrc_role` WRITE;
/*!40000 ALTER TABLE `ylrc_role` DISABLE KEYS */;
INSERT INTO `ylrc_role` VALUES (1,'2022-06-15 13:16:38','2022-06-24 12:36:46','Super Admin','The super administrator has the highest authority.',1),(2,'2022-06-15 13:18:57','2022-06-24 12:38:35','Normal Admin','Normal administrators have only partial authorities.',1),(4,'2022-06-21 20:11:00','2022-06-24 12:38:21','Test User','Only for test.',0);
/*!40000 ALTER TABLE `ylrc_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_role_authorities`
--

DROP TABLE IF EXISTS `ylrc_role_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_role_authorities` (
  `role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  KEY `FKhj7ap1o1cjrl7enr9arf5f2qp` (`authorities_id`),
  KEY `FKg3xdaexmr0x1qx8omhvjtk46d` (`role_id`),
  CONSTRAINT `FKg3xdaexmr0x1qx8omhvjtk46d` FOREIGN KEY (`role_id`) REFERENCES `ylrc_role` (`id`),
  CONSTRAINT `FKhj7ap1o1cjrl7enr9arf5f2qp` FOREIGN KEY (`authorities_id`) REFERENCES `ylrc_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_role_authorities`
--

LOCK TABLES `ylrc_role_authorities` WRITE;
/*!40000 ALTER TABLE `ylrc_role_authorities` DISABLE KEYS */;
INSERT INTO `ylrc_role_authorities` VALUES (1,2),(1,3),(1,5),(1,8),(1,9),(1,7),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,30),(1,31),(1,32),(1,29),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(1,60),(1,61),(1,62),(4,2),(4,13),(4,15),(2,2),(2,3),(2,5),(2,7),(2,11),(2,13),(2,16);
/*!40000 ALTER TABLE `ylrc_role_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_site_setting`
--

DROP TABLE IF EXISTS `ylrc_site_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_site_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `all_rights` varchar(256) NOT NULL,
  `logo_1` varchar(256) NOT NULL,
  `logo_2` varchar(256) NOT NULL,
  `qrcode` varchar(256) NOT NULL,
  `site_name` varchar(128) NOT NULL,
  `site_url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_site_setting`
--

LOCK TABLES `ylrc_site_setting` WRITE;
/*!40000 ALTER TABLE `ylrc_site_setting` DISABLE KEYS */;
INSERT INTO `ylrc_site_setting` VALUES (1,'2022-06-18 17:02:17','2022-06-24 12:49:03','©2022-2022 [ Sunset Oasis University ] Copy Right @ MSc CS Jiang Chufeng','20220618/1587201658762.png','20220618/1587201663687.png','20220618/1587201667179.png','Sunset Oasis','www.sunset_oasis.com');
/*!40000 ALTER TABLE `ylrc_site_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_studnet`
--

DROP TABLE IF EXISTS `ylrc_studnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_studnet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `academy` varchar(38) DEFAULT NULL,
  `grade` varchar(18) DEFAULT NULL,
  `mobile` varchar(28) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `qq` varchar(28) DEFAULT NULL,
  `school` varchar(28) DEFAULT NULL,
  `sn` varchar(18) NOT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `password` varchar(18) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5se32pxcytmbwgepjrjrdmvjr` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_studnet`
--

LOCK TABLES `ylrc_studnet` WRITE;
/*!40000 ALTER TABLE `ylrc_studnet` DISABLE KEYS */;
INSERT INTO `ylrc_studnet` VALUES (2,'2022-06-06 12:52:02','2022-06-18 18:05:56','Computer Science and Technology','SoftwareEng1102','13656565656','Jiang Chufeng','11221232132','UOBD','158549530920','20200406/1586162585279.jpg',1,'111111'),(3,'2022-06-11 15:20:12','2022-06-11 15:23:29','Computer Science and Technology','ComputerSci1103','13946598956','Alice','11956256','UOB','158549530921','20200411/1586589655027.jpg',1,'111111'),(4,'2022-06-11 23:35:40','2022-06-15 21:48:47','Materials','Material1104','13656569456','BobC','1658555644','UOBD','158540174522','20200411/1586619722105.png',1,'111111'),(5,'2022-06-12 20:58:29','2022-06-15 21:46:39','Materials','Material2011','13656565656','Serendi','1122123213','UOBD','158549530922','20200412/1586700613292.png',1,'111111');
/*!40000 ALTER TABLE `ylrc_studnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_user`
--

DROP TABLE IF EXISTS `ylrc_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `email` varchar(48) DEFAULT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `mobile` varchar(28) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(32) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_btsosjytrl4hu7fnm1intcpo8` (`username`),
  KEY `FKg09b8o67eu61st68rv6nk8npj` (`role_id`),
  CONSTRAINT `FKg09b8o67eu61st68rv6nk8npj` FOREIGN KEY (`role_id`) REFERENCES `ylrc_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_user`
--

LOCK TABLES `ylrc_user` WRITE;
/*!40000 ALTER TABLE `ylrc_user` DISABLE KEYS */;
INSERT INTO `ylrc_user` VALUES (1,'2022-06-18 19:18:53','2022-06-24 18:23:38','cxj164@student.bham.ac.uk','20220624/1656080608803.jpg','0501672178','123456',2,1,'Jiang Chufeng',1),(2,'2022-06-18 19:20:36','2022-06-24 12:34:53','llq@qq.com','20200318/1584530412075.jpg','13918655656','123456',1,1,'Test',2),(5,'2022-06-20 20:42:19','2022-06-24 12:35:12','yw@qq.com','20200323/1584956702094.png','13356565656','123456',2,1,'Alice',4),(7,'2022-06-30 22:59:02','2022-06-24 12:35:52','llq@qq.com','20200330/1585580308721.jpg','13656565656','123456',1,1,'Serendi',2);
/*!40000 ALTER TABLE `ylrc_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ylrc_wanted_goods`
--

DROP TABLE IF EXISTS `ylrc_wanted_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ylrc_wanted_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sell_price` float NOT NULL,
  `trade_place` varchar(128) NOT NULL,
  `view_number` int(11) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqvrfd43yhp11er38hkfcxi103` (`student_id`),
  CONSTRAINT `FKqvrfd43yhp11er38hkfcxi103` FOREIGN KEY (`student_id`) REFERENCES `ylrc_studnet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ylrc_wanted_goods`
--

LOCK TABLES `ylrc_wanted_goods` WRITE;
/*!40000 ALTER TABLE `ylrc_wanted_goods` DISABLE KEYS */;
INSERT INTO `ylrc_wanted_goods` VALUES (1,'2022-06-11 18:00:07','2022-06-11 22:57:47','I wanna buy iphoneX 256G, please contact me.','iphoneX 256G',899,'Dormitory Building No. 17',0,3),(4,'2022-06-11 23:29:32','2022-06-11 23:29:32','A mac book pro， please contact me.','mac book pro',5999,'North Gate',0,3),(5,'2022-06-11 23:31:01','2022-06-11 23:31:01','The bicycle was stolen within two days, and I want to buy a second-hand one to ride.','Bicycle',98,'Lane 300 international city Road',0,2),(6,'2022-06-11 23:34:43','2022-06-11 23:34:43','Laptop performance is too poor. I want to buy a new one.','Laptop',2699,'Dormitory Building No. 17',0,2),(7,'2022-06-11 23:37:18','2022-06-11 23:37:18','Anyone willing to sell their racket? Preferably a pair, please contact me if you have one!','Racket',55,'v',0,4);
/*!40000 ALTER TABLE `ylrc_wanted_goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  0:22:39
