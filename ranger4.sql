-- MySQL dump 10.13  Distrib 5.7.10, for osx10.9 (x86_64)
--
-- Host: 115.28.177.76    Database: ranger
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `angency`
--

DROP TABLE IF EXISTS `angency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `angency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `register_name` varchar(45) NOT NULL DEFAULT '',
  `register_certifate_type` varchar(45) NOT NULL DEFAULT '',
  `regiester_number` varchar(45) NOT NULL DEFAULT '""',
  `register_brief` varchar(100) NOT NULL DEFAULT '',
  `phone` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `lincense_picture` varchar(100) NOT NULL DEFAULT '',
  `balance` double NOT NULL DEFAULT '0',
  `brief` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `angency`
--

LOCK TABLES `angency` WRITE;
/*!40000 ALTER TABLE `angency` DISABLE KEYS */;
INSERT INTO `angency` VALUES (0,'system','system','system','system','system','system','system','system','system',0,'system',''),(1,'无名旅游社','Andy_wang','身份证','622824456546546','622824456546546','1522222222222','we@126.com','嘉定区','images\\头像.jpg',0,'这是简介','wang'),(2,'旅游圈','wdc','身份证','622824456546546','622824456546546','5423523532532','admintj@123.con','嘉定区','images\\star.jpg',0,'这是简介','123'),(6,'天马旅行社','Wang Dechang','身份证','1234567890111119','1234567890111119','15222222222','wdchang@github.com','上海四平路','images\\star.jpg',144999,'这是简介','123'),(7,'驰骋','Buyer','身份证','622824456546546','12345678978','1255555555555','buy@github.com','上海市闵行区','images\\b200781802621.jpg&images\\2323.jpg&images\\IMG_20140329_071111.jpg&images\\2f.jpg',819199,'驰骋旅游公司，值得信赖的公司','123'),(8,'八爪鱼','张三','身份证','323232323','这是什么','11111111111111112','admin@126.com','同济大学嘉定校区','images\\8-3f.jpg&images\\8-1350954016fUkwCk.jpg',0,'这是八爪鱼旅游公司','wang'),(9,'八爪鱼分公司','LiSi','身份证','2323232323233','注册人借鉴是什么鬼啊','123123123131','2016512@qq.com','同济大学嘉定校区','images\\5f.jpg',12,'this is brief','wang'),(13,'同济旅游','代总','身份证','12312131','622824456546546','15221399560','admin23@123.com','济事楼516','images\\13-2f.jpg&images\\IMG_20140324_215804.jpg&images\\IMG_6941.JPG',0,'这是公司简介','1231231'),(14,'康康旅游','tongji','身份证','1231231231313','1231312313132','1521223693','tongji@126.com','上海市闵行区','&images\\1663798587338578376.jpg',0,'这是康康旅游公司','tongji'),(15,'3','1','身份证','3','3','3','linsm8968@126.com','3','&images/决策表.xlsx&images/决策表.xlsx',0,'3','3'),(16,'1','1','身份证','1','1','1','linsm8968@126.com','1','&images/决策表.xlsx',0,'1','1');
/*!40000 ALTER TABLE `angency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_card`
--

DROP TABLE IF EXISTS `bank_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `angency_id` bigint(20) NOT NULL,
  `owner` varchar(45) NOT NULL DEFAULT '',
  `card_number` varchar(45) NOT NULL DEFAULT '',
  `bank` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `Fk_angencyId_idx` (`angency_id`),
  CONSTRAINT `Fk_angencyId` FOREIGN KEY (`angency_id`) REFERENCES `angency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_card`
--

LOCK TABLES `bank_card` WRITE;
/*!40000 ALTER TABLE `bank_card` DISABLE KEYS */;
INSERT INTO `bank_card` VALUES (1,1,'wdc','123333333333','BOC'),(2,2,'ddy','1234515999990','ICBC'),(3,2,'wdc','1234556667777','BOC'),(4,2,'ddy','888888888888','BOC'),(5,6,'邪也','8989898989898','ICBC'),(6,7,'徐扬','12345667777777','ICBC'),(7,6,'李豪','00000000000000','ICBC'),(8,7,'L好','12344449988888','ICBC');
/*!40000 ALTER TABLE `bank_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `angency_id` bigint(20) NOT NULL,
  `collect_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id_2` (`product_id`,`angency_id`),
  KEY `product_id` (`product_id`),
  KEY `angency_id` (`angency_id`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`angency_id`) REFERENCES `angency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (4,2,1,'2016-06-19 13:26:40'),(8,2,7,'2016-06-19 16:41:42'),(9,4,7,'2016-06-19 16:41:42'),(11,13,7,'2016-06-19 16:41:42'),(12,14,7,'2016-06-19 16:41:42'),(13,16,7,'2016-06-19 16:41:42'),(14,22,7,'2016-06-19 16:41:42'),(15,24,7,'2016-06-19 16:41:42'),(16,26,7,'2016-06-19 16:41:42'),(17,27,7,'2016-06-19 16:41:42'),(18,28,7,'2016-06-19 16:41:42'),(19,29,7,'2016-06-19 16:41:42'),(20,30,7,'2016-06-19 16:41:42'),(21,32,7,'2016-06-19 16:41:42'),(22,33,7,'2016-06-19 16:41:42'),(23,34,7,'2016-06-19 16:41:43'),(24,35,7,'2016-06-19 16:41:43'),(25,37,7,'2016-06-19 16:41:43'),(26,38,7,'2016-06-19 16:41:43'),(27,40,7,'2016-06-19 16:41:43'),(28,41,7,'2016-06-19 16:41:43'),(29,42,7,'2016-06-19 16:41:43'),(33,24,1,'2016-06-20 04:02:58');
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `angency_id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL DEFAULT '',
  `gender` bit(1) NOT NULL DEFAULT b'1',
  `phone` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `angency_id` (`angency_id`),
  CONSTRAINT `guide_ibfk_1` FOREIGN KEY (`angency_id`) REFERENCES `angency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES `guide` WRITE;
/*!40000 ALTER TABLE `guide` DISABLE KEYS */;
INSERT INTO `guide` VALUES (1,2,'Andy','','152222222222','111@162.com','同济大学嘉定校区'),(2,7,'赵豪总','','123000000000','120000@com','空岛不知道是什'),(3,6,'Micheal','\0','12345678901','hello@world.com','one picece'),(4,7,'代总','','123456789988','daizongh@123.com','同济大学'),(5,7,'李豪','','123456789988','lizongh@123.com','同济大学济事楼526'),(6,13,'程程','','23423242432','chen@126.com','同济大学学学学');
/*!40000 ALTER TABLE `guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `father_id` bigint(20) NOT NULL DEFAULT '-1',
  `e_name` varchar(45) DEFAULT NULL,
  `has_child` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `father_id` (`father_id`),
  KEY `c_name` (`name`),
  KEY `e_name` (`e_name`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (0,'root',-1,NULL,1),(2,'中国',0,'China',1),(3,'美国',0,'United States',1),(4,'北京',2,NULL,0),(5,'香港',2,'HongKong',0),(6,'台湾',2,'Taiwan',1),(7,'新加坡',0,'Singapore',0),(8,'加利福尼亚州',3,'California',0),(9,'澳门',2,'Macao',0),(10,'河南',2,'Henan',1),(11,'上海',2,'Shanghai',0),(17,'湖南',2,'Hunan',1),(23,'湖北',2,'Hubei',1),(24,'甘肃',2,'Gansu',0),(26,'上海',-1,NULL,0),(32,'上海',-1,NULL,0),(34,'江苏',2,'Jiangsu',0),(36,'南京',-1,NULL,0),(37,'上海',-1,NULL,0),(38,'重庆',2,'chongqing',0),(39,'湖北',-1,NULL,0),(40,'上海',-1,NULL,0),(42,'上海',-1,NULL,0),(43,'Hubei',-1,NULL,0),(44,'上海',-1,NULL,0),(45,'上海',-1,NULL,0),(47,'南京',-1,NULL,0),(48,'南京',-1,NULL,0),(50,'南京',-1,NULL,0),(51,'南京',-1,NULL,0),(52,'南京',-1,NULL,0),(53,'南京',-1,NULL,0),(54,'南京',-1,NULL,0),(55,'上海',-1,NULL,0),(56,'上海',-1,NULL,0),(57,'上海',-1,NULL,0),(58,'上海',-1,NULL,0),(59,'印度',0,'India',0),(60,'日本',0,'Japan',0),(61,'老挝',0,'Laos ',0),(62,'马来西亚',0,'Malaysia',0),(63,'马尔代夫',0,'Maldives ',0),(64,'越南',0,'Vietnam',0),(65,'泰国',0,'Thailand',0),(66,'朝鲜',0,'North Korea',0),(67,'韩国',0,'South Korea',0),(68,'丹麦',0,'Denmark',0),(69,'芬兰',0,'Finland',0),(70,'法国',0,'France',0),(71,'德国',0,'Germany',0),(72,'冰岛',0,'Iceland',0),(73,'爱尔兰',0,'Ireland',0),(74,'意大利',0,'Italy',0),(75,'荷兰',0,'Netherlands',0),(76,'挪威',0,'Norway',0),(77,'波兰',0,'Poland',0),(78,'葡萄牙',0,'Portugal',0),(79,'俄罗斯',0,'Russia',0),(80,'西班牙',0,'Spain ',0),(81,'瑞典',0,'Sweden',0),(82,'瑞士',0,'Switzerland',0),(83,'英国',0,'England',0),(84,'澳大利亚',0,'Australia',0),(85,'新西兰',0,'Neuseeland',0),(86,'阿根廷',0,'Argentina',0),(87,'加拿大',0,'Canada',0),(88,'巴西',0,'Brazi',0),(89,'墨西哥',0,'Mexico',0),(91,'浙江',2,'Zhejiang',0),(92,'天津',2,'Tianjin',0),(93,'河北',2,'Hebei',1),(94,'石家庄市',93,'Shijiazhuang',0),(95,'唐山市',93,'Tangshan',0),(96,'秦皇岛市',93,'Qinhuangdao',0),(97,'邯郸市',93,'Handan',0),(98,'邢台市',93,'Xingtai',0),(99,'保定市',93,'Baoding',0),(100,'张家口市',93,'Zhangjiakou',0),(101,'承德市',93,'Chengde',0),(102,'沧州市',93,'Cangzhou',0),(103,'廊坊市',93,'Langfang',0),(104,'衡水市',93,'Hengshui',0),(105,'山西',2,'Shanxi',1),(106,'太原市',105,'Taiyuan',0),(107,'大同市',105,'Datong',0),(108,'阳泉市',105,'Yangquan',0),(109,'长治市',105,'Changzhi',0),(110,'晋城市',105,'Jincheng',0),(111,'朔州市',105,'Shuzhou',0),(112,'晋中市',105,'Jinzhong',0),(113,'运城市',105,'Yuncheng',0),(114,'忻州市',105,'Qizhou',0),(115,'临汾市',105,'LinFen',0),(116,'吕梁市',105,'Lvliang',0),(117,'台北市',6,'Taibei',0),(118,'高雄市',6,'Gaoxiong',0),(119,'基隆市',6,'Jilong',0),(120,'台中市',6,'Taizhong',0),(121,'台南市',6,'Tainan',0),(122,'新竹市',6,'Xinzhu',0),(123,'嘉义市',6,'Jiayi',0),(124,'郑州市',10,'Zhengzhou',0),(125,'开封市',10,'Kaifeng',0),(126,'洛阳市',10,'Luoyang',0),(127,'平顶山市',10,'Pingdingshan',0),(128,'安阳市',10,'Anyang',0),(129,'鹤壁市',10,'Hebi',0),(130,'新乡市',10,'Xinxiang',0),(131,'焦作市',10,'Jiaozuo',0),(132,'濮阳市',10,'Puyang',0),(133,'许昌市',10,'Xuchang',0),(134,'漯河市',10,'Luohe',0),(135,'三门峡市',10,'Sanmenxia',0),(136,'南阳市',10,'Nanyang',0),(137,'商丘市',10,'Shangcheng',0),(138,'信阳市',10,'Xinyang',0),(139,'周口市',10,'Zhoukou',0),(140,'驻马店市',10,'Zhumadian',0),(141,'济源市',10,'Jiyuan',0),(142,'长沙市',17,'Changsha',0),(143,'株洲市',17,'Zhuzhou',0),(144,'湘潭市',17,'Xiangtan',0),(145,'衡阳市',17,'Hengyang',0),(146,'邵阳市',17,'Shaoyang',0),(147,'岳阳市',17,'Yueyang',0),(148,'常德市',17,'Changde',0),(149,'张家界市',17,'Zhangjiajie',0),(150,'益阳市',17,'Yiyang',0),(151,'郴州市',17,'Bangzhou',0),(152,'武汉市',23,'Wuhan',0),(153,'黄石市',23,'Huangshi',0),(154,'十堰市',23,'Shiyan',0),(155,'荆州市',23,'Jinzhou',0),(156,'宜昌市',23,'Yichang',0),(157,'襄樊市',23,'Xiangfan',0),(158,'鄂州市',23,'Ezhou',0),(159,'荆门市',23,'Jinmen',0),(160,'孝感市',23,'Xiaogan',0),(161,'黄冈市',23,'Huanggang',0),(162,'咸宁市',23,'Xianning',0),(163,'随州市',23,'Suizhou',0),(164,'仙桃市',23,'Xiantao',0),(165,'天门市',23,'Tianmen',0),(166,'潜江市',23,'Qianjiang',0),(167,'神农架林区',23,'Shennujia',0),(168,'恩施土家族苗族自治州',23,'Enshi',0);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderform_id` bigint(20) NOT NULL,
  `content` text,
  `generate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_viewed` tinyint(1) NOT NULL DEFAULT '0',
  `receiver_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderform_id` (`orderform_id`),
  KEY `index_receiver_id` (`receiver_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`orderform_id`) REFERENCES `orderform` (`id`),
  CONSTRAINT `notification_ibfk_2` FOREIGN KEY (`receiver_id`) REFERENCES `angency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,8,'天马旅行社（供应方）上传了出台通知书，快去看看吧','2016-05-06 19:39:41',1,7),(2,8,'天马旅行社已经向您发送了合同，快去看看吧','2016-05-06 19:39:41',0,7),(3,9,'天马旅行社（供应方）上传了出台通知书，快去看看吧','2016-05-06 19:39:41',0,7),(4,9,'天马旅行社已经向您发送了合同，快去看看吧','2016-05-06 19:39:41',1,7),(5,10,'天马旅行社（供应方）上传了出台通知书，快去看看吧','2016-05-06 19:39:41',0,7),(6,10,'天马旅行社已经向您发送了合同，快去看看吧','2016-05-06 19:39:41',0,7);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform`
--

DROP TABLE IF EXISTS `orderform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `buyer_id` bigint(20) NOT NULL,
  `trip_setoff_id` bigint(20) NOT NULL,
  `booker` varchar(45) NOT NULL DEFAULT 'wdc',
  `booker_phone` varchar(45) NOT NULL DEFAULT '00000000000',
  `booker_address` varchar(45) NOT NULL DEFAULT 'not set address yet!',
  `book_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `confirm_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int(11) NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `deposit` double NOT NULL DEFAULT '0',
  `confirm_list_buyer` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `confirm_list_supplier` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `trip_notice` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `contract_supplier` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `contract_buyer` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `invoice` varchar(100) NOT NULL DEFAULT 'documents\\default.pdf',
  `comment` varchar(100) NOT NULL DEFAULT '',
  `remark` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `buyer_id` (`buyer_id`),
  KEY `trip_setoff_id` (`trip_setoff_id`),
  CONSTRAINT `orderform_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `angency` (`id`),
  CONSTRAINT `orderform_ibfk_2` FOREIGN KEY (`trip_setoff_id`) REFERENCES `trip_setoff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
INSERT INTO `orderform` VALUES (1,1,1,'马致远','1213','上海','2016-05-02 16:00:00','2016-05-06 16:00:00',1,5600,123,'廖大炮','代总','documentsdefault.pdf','代总','廖大炮','','we',0),(2,2,2,'邪爷','1234567890','北京四平路','2016-05-06 19:06:37','2016-05-06 19:06:37',2,0,0,'files\\default.pdf','files\\default.pdf','documentsdefault.pdf','files\\default.pdf','files\\default.pdf','','',0),(3,7,3,'徐扬','1234567890','北京路由路','2016-05-06 19:12:30','2016-05-06 19:12:30',12,0,0,'documents/上机实践10.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(4,7,4,'xuyang','1234567890','上海嘉定区','2016-05-06 19:12:30','2016-05-06 19:12:30',12,0,0,'documents/global-capstone-proposal-4-TJU.PDF','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(5,7,5,'许扬','1234567890','上海南京东路','2016-05-06 19:12:30','2016-05-06 19:12:30',4,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(6,7,6,'许扬','1234567890','新加坡','2016-05-06 19:12:30','2016-05-06 19:12:30',2,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(7,7,7,'廖山河','1234567890','6号楼','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','大大',0),(8,7,8,'马致远','2345678901','6号楼3楼','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','sda',0),(9,7,9,'王德昌','234543211234',' 电话号码有点长的地方','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(10,7,10,'wdchang','2345678901','拉夫耶夫','2016-05-06 19:12:30','2016-05-06 19:12:30',7,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(11,1,2,'daidongyang','18149771976','sipinglu','2016-05-23 18:39:19','2016-05-23 18:39:19',1,0,0,'documents\\default.pdf','documents\\default.pdf','','documents\\default.pdf','documents\\default.pdf','documets\\default.pdf','',0),(12,7,1,'代东洋','18149771976','四平路','2016-05-24 00:33:04','2016-05-24 00:33:04',6,400,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','sd',0),(13,7,1,'代东洋','18149771976','11111','2016-06-01 17:50:33','2016-06-01 17:50:33',2,1600,0,'documents\\default.pdf','images/上机实践03.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(14,7,1,'代东洋','18149771976','11111','2016-06-01 17:53:11','2016-06-01 17:53:11',3,3200,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(15,7,1,'王德昌','18149771976','11111','2016-06-02 00:37:53','2016-06-02 00:37:53',12,800,0,'documents/第1章 引论.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(16,7,1,'带你搞定','1234567889','我的地址','2016-06-20 01:00:26','2016-06-20 01:00:26',6,800,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','我给满分',0),(17,7,1,'代东洋','1234567890','代东洋的地址','2016-06-20 02:24:27','2016-06-20 02:24:27',12,800,0,'documents/第7章 语义分析和中间代码产生.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(18,7,19,'代东洋','1234567890','四平路1239号','2016-06-20 03:29:03','2016-06-20 03:29:03',1,0,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0);
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform_tourist`
--

DROP TABLE IF EXISTS `orderform_tourist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform_tourist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderform_id` bigint(20) NOT NULL,
  `tourist_type_id` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL DEFAULT '',
  `gender` bit(1) NOT NULL DEFAULT b'0',
  `phone` varchar(45) NOT NULL DEFAULT '00000000000',
  `email` varchar(45) NOT NULL DEFAULT 'noemail@email.com',
  `birth_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `certifate_type` varchar(45) NOT NULL DEFAULT '身份证',
  `certifate_number` varchar(45) NOT NULL DEFAULT '000000000000000000',
  `state` int(11) NOT NULL DEFAULT '0',
  `remark` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `orderform_id` (`orderform_id`),
  KEY `tourist_type_id` (`tourist_type_id`),
  CONSTRAINT `orderform_tourist_ibfk_1` FOREIGN KEY (`orderform_id`) REFERENCES `orderform` (`id`),
  CONSTRAINT `orderform_tourist_ibfk_2` FOREIGN KEY (`tourist_type_id`) REFERENCES `tourist_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform_tourist`
--

LOCK TABLES `orderform_tourist` WRITE;
/*!40000 ALTER TABLE `orderform_tourist` DISABLE KEYS */;
INSERT INTO `orderform_tourist` VALUES (1,1,1,'马大哥','','000000000000','','2016-05-05 06:08:14','身份证','000000000000000000',0,''),(2,1,2,'小马','\0','622824456546546','','2016-05-05 06:08:14','身份证','000000000000000000',0,''),(3,2,1,'王德昌','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(4,2,2,'许扬','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(5,2,3,'王德昌','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(6,3,1,'王大锤','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(7,3,2,'王德昌','\0','12345678901','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(8,4,1,'王大锤','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(9,4,2,'王德昌','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(10,5,1,'许扬','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(11,5,2,'邪也','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(12,6,1,'东方不切','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(13,6,2,'王德昌','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(14,7,1,'王德福','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(15,7,2,'王德芳','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(16,8,1,'王德芳','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(17,8,2,'党风','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(18,9,1,'东方不切','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(19,9,2,'邪夜','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(20,10,1,'谢烨','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(21,10,2,'邪爷','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(22,10,3,'东方不白','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(23,1,1,'dsa','','weqe','wqeq','2016-05-11 16:00:00','身份证','wqe',0,'ewqe'),(24,1,1,'sd','','dsa','sad@12','2016-05-10 16:00:00','身份证','asdad',0,'das'),(25,1,1,'sd','','dsa','sad@12','2016-05-10 16:00:00','身份证','asdad',0,'das'),(26,1,1,'sd','','dsa','sad@1232','2016-05-10 16:00:00','身份证','asdad',0,'das'),(27,1,2,'das','','发送','43@q','2016-05-10 16:00:00','身份证','2313',0,'叫姐姐'),(28,1,1,'热','\0','11213','2323@12','2016-05-25 16:00:00','身份证','3243434',0,'4mfds'),(29,4,1,'opi','','oip','oiu@yt','2016-05-18 16:00:00','身份证','oip',0,'poi'),(30,3,1,'么么','','123','12@23','2016-05-11 16:00:00','身份证','3213',0,'213'),(31,3,1,'么么','','123','12@23','2016-05-11 16:00:00','身份证','3213',0,'213'),(32,12,2,'weq','','we','wae@qw','2016-05-28 16:00:00','身份证','wae',0,'wa'),(33,3,1,'12','','231','ew@qw','2016-05-18 16:00:00','身份证','231',0,'wean'),(34,3,1,'we','\0','wea','wae@qw','2016-05-04 16:00:00','身份证','wa',0,'wae'),(35,3,1,'asd','','asd','sad@daw','2016-05-25 16:00:00','身份证','asd',0,'das'),(36,3,1,'w','\0','32','wae@we','2016-05-18 16:00:00','身份证','eqw',0,'wq'),(37,3,1,'ew','','we','we@ew','2016-05-11 16:00:00','身份证','wea',0,'we'),(38,3,1,'sad','\0','sad','dsa@e','2016-05-17 16:00:00','护照','sa',0,'sad'),(39,3,1,'wae','','wea','aew@ewa','2016-05-18 16:00:00','身份证','wae',0,'wae'),(40,3,1,'y','','tr','et@r','2016-04-26 16:00:00','身份证','tr',0,'tr'),(41,3,1,'ewr','\0','ewr','rew@re','2016-05-18 16:00:00','护照','ewr',0,'rew'),(42,3,1,'dsa','','sad','dsaq@wq','2016-05-03 16:00:00','身份证','sad',0,'sad'),(43,3,1,'123','','213','123','2016-04-25 00:00:00','身份证','213',0,'213'),(44,3,1,'12321','','23','21313','2016-05-09 00:00:00','身份证','2323',0,'2133213'),(45,15,1,'王德昌','','18149771976','test@test.com','2016-12-31 00:00:00','护照','1111111',0,'备注'),(46,13,1,'f 问问','','we','321@32','2016-06-17 00:00:00','身份证','213',0,'23'),(47,13,1,'321','','213','321','2016-06-09 00:00:00','身份证','213',0,'23'),(48,16,1,'马2','','3213','432@q1','2016-06-21 00:00:00','身份证','2131313',0,'2132131'),(49,14,1,'1','','12','12','2016-06-09 00:00:00','身份证','12',0,'12'),(50,14,1,'2','','12','12','2016-06-15 00:00:00','身份证','21',0,'12'),(51,14,1,'3','','12','12','2016-06-22 00:00:00','身份证','12',0,'21'),(52,14,1,'ewqewq','','weqe','weq','2016-06-16 00:00:00','身份证','wqe',0,'wqe'),(53,17,1,' ew','','ewq','weq@11','2016-06-01 00:00:00','身份证','wqe',0,'eqw');
/*!40000 ALTER TABLE `orderform_tourist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform_tourist_picture`
--

DROP TABLE IF EXISTS `orderform_tourist_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform_tourist_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderform_tourist_id` bigint(20) NOT NULL,
  `picture_path` varchar(100) NOT NULL DEFAULT 'images\\default.png',
  `brief` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `orderform_tourist_id` (`orderform_tourist_id`),
  CONSTRAINT `orderform_tourist_picture_ibfk_1` FOREIGN KEY (`orderform_tourist_id`) REFERENCES `orderform_tourist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform_tourist_picture`
--

LOCK TABLES `orderform_tourist_picture` WRITE;
/*!40000 ALTER TABLE `orderform_tourist_picture` DISABLE KEYS */;
INSERT INTO `orderform_tourist_picture` VALUES (1,1,'images\\default.png',''),(2,2,'images\\default.png',''),(3,3,'images\\default.png',''),(4,4,'images\\default.png',''),(5,5,'images\\default.png',''),(6,6,'images\\default.png',''),(7,7,'images\\default.png',''),(8,8,'images\\default.png',''),(9,9,'images\\default.png',''),(10,10,'images\\default.png',''),(11,11,'images\\default.png',''),(12,12,'images\\default.png',''),(13,13,'images\\default.png',''),(14,14,'images\\default.png',''),(15,15,'images\\default.png',''),(16,16,'images\\default.png',''),(17,17,'images\\default.png',''),(18,18,'images\\default.png',''),(19,19,'images\\default.png',''),(20,20,'images\\default.png',''),(21,21,'images\\default.png',''),(22,22,'images\\default.png','');
/*!40000 ALTER TABLE `orderform_tourist_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform_track`
--

DROP TABLE IF EXISTS `orderform_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform_track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderform_id` bigint(20) NOT NULL,
  `track_item` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `orderform_id` (`orderform_id`),
  CONSTRAINT `orderform_track_ibfk_1` FOREIGN KEY (`orderform_id`) REFERENCES `orderform` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform_track`
--

LOCK TABLES `orderform_track` WRITE;
/*!40000 ALTER TABLE `orderform_track` DISABLE KEYS */;
INSERT INTO `orderform_track` VALUES (1,1,'用户已提交预定信息','2016-05-06 19:31:22'),(2,2,'用户已提交预定信息','2016-05-06 19:31:22'),(3,3,'用户已提交预定信息','2016-05-06 19:31:22'),(4,4,'用户已提交预定信息','2016-05-06 19:31:22'),(5,5,'用户已提交预定信息','2016-05-06 19:31:22'),(6,6,'用户已提交预定信息','2016-05-06 19:31:22'),(7,7,'用户已提交预定信息','2016-05-06 19:31:22'),(8,8,'用户已提交预定信息','2016-05-06 19:31:22'),(9,9,'用户已提交预定信息','2016-05-06 19:31:22'),(10,10,'用户已提交预定信息','2016-05-06 19:31:22'),(11,2,'采购方已提交游客信息','2016-05-06 19:33:04'),(12,3,'采购方已提交游客信息','2016-05-06 19:33:04'),(13,4,'采购方已提交游客信息','2016-05-06 19:33:04'),(14,5,'采购方已提交游客信息','2016-05-06 19:33:04'),(15,8,'采购方已提交游客信息','2016-05-06 19:33:04'),(16,9,'采购方已提交游客信息','2016-05-06 19:33:04'),(17,10,'采购方已提交游客信息','2016-05-06 19:33:04'),(18,8,'供应方已上传出团通知书','2016-05-06 19:34:05'),(19,9,'供应方已上传出团通知书','2016-05-06 19:34:05'),(20,10,'供应方已上传出团通知书','2016-05-06 19:34:06'),(21,5,'采购方申请退款','2016-05-06 19:41:07'),(22,4,'采购方申请退款','2016-05-06 19:41:29');
/*!40000 ALTER TABLE `orderform_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `summary` varchar(100) NOT NULL DEFAULT '',
  `search_content` varchar(300) NOT NULL DEFAULT '',
  `duration` int(11) NOT NULL DEFAULT '1',
  `supplier_id` bigint(20) NOT NULL,
  `setoff_location_id` bigint(20) NOT NULL,
  `postcode` varchar(10) NOT NULL DEFAULT '',
  `post_receiver` varchar(45) NOT NULL DEFAULT '',
  `post_address` varchar(100) NOT NULL DEFAULT '',
  `post_phone` varchar(45) NOT NULL DEFAULT '',
  `click_rate` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `angency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'金牌旅游','非常好','上海三日游',10,1,1,'','','','',0),(2,'港澳台三日游','港澳台','港澳台 游轮 如家 飞机 香港 澳门 台湾',3,6,4,'21804','wdChang','上海东大街11111号','1234567890',42),(3,'加州一日游','加州','美国 加州 一日游',3,6,4,'201804','wdc','上海西大街234号','1234567890',2),(4,'新加坡两日游','新加坡','新加坡 singapore',4,6,4,'123456','wdc','北京欢饮您','',6),(7,'?????','?????','?? ???',3,7,17,'201804','wdchang','SiPing Road','12345678',0),(13,'北京三日游','北京三日游','北京 三日游',3,7,11,'201804','wdchang','SiPing Road','12345678',13),(14,'北京三日游','北京三日游 这是北京三日游详情 + 三日游','北京 三日游',3,7,11,'201804','wdchang','SiPing Road','12345678',19),(16,'杭州一日游','杭州一日游，从上海出发，杭州一日游，从上海出发，','杭州一日游，从上海出发，杭州一日游，从上海出发，杭州一日游，从上海出发，杭州一日游，从上海出发。',1,7,11,'12365','receiver','addresss','1111111',0),(22,'杭州三日游','杭州三日游 杭州三日游','杭州三日游杭州三日游杭州三日游',3,7,11,'12365','receiver2','addresss2','121212121',0),(24,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',10),(26,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',6),(27,'杭州三日游','杭州三日游 这是真滴','杭州三日游 这是真滴，难道还有假？？？',3,7,11,'12365','receiver','addresss','121212121',0),(28,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(29,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(30,'杭州6日游','杭州6日游','杭州6日游杭州6日游',6,7,11,'12365','receiver','addresss','12121',0),(32,'一日游苏州','苏州一日游呀','是呀 是苏州一日游',1,7,11,'12365232','receiver3','test addresss !!!','2345667789',0),(33,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(34,'南京旅游','南京旅游 南京旅游火车南京旅游南京旅游南京旅游南京旅游五星级上海飞机2016-05-13T16:00:00.000Z自由行7','南京旅游南京旅游南京旅游',7,7,11,'12365232','receiver24','addresss234','235678990',0),(35,'南京旅游2','南京旅游2 南京旅游2飞机南京旅游2南京旅游2南京旅游2南京旅游2四星级上海大巴2016-05-28T16:00:00.000Z自由行6','南京旅游2南京旅游2南京旅游2',6,7,11,'12365232','receiver245','addresss235','1234566788',0),(37,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',2),(38,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(40,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',3),(41,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(42,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(43,'北京三日游','北京三日游','北京 三日游',3,9,53,'201804','wdchang','SiPing Road','12345678',0),(44,'北京三日游','北京三日游','北京 三日游',3,9,54,'201804','wdchang','SiPing Road','12345678',0),(46,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(47,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(48,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(49,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(50,'北京三日游','北京三日游','北京 三日游',3,9,3,'201804','wdchang','SiPing Road','12345678',0),(51,'西安旅游','西安旅游西安旅游测试back西安旅游西安旅游西安旅游测试酒店上海测试','西安旅游西安旅游',3,7,55,'12365232','receiver2456','addresss23','234555455',0),(52,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,56,'200091','代总','同济大学','182125362',0),(53,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,57,'200091','代总','同济大学','182125362',0),(54,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,58,'200091','代总','同济大学','182125362',0),(58,'出境游','这还是出境游简介 详情','这还是出境游简介飞机这还是出境游简介 详情出境游五星级飞机自由行23 2016年 06月 20日 ',23,7,11,'12365','receiver','addresss','2345667789',0),(59,'美法游','美法游详情如下：','这是美法游飞机美法游详情如下：美法游五星级香港飞机出境游3 2016年 06月 21日 ',3,7,5,'12365','receiver','addresss','2345667789',0),(61,'西北游','这是西北游简介 详情','这是西北游简介大巴这是西北游简介 详情西北游酒店香港飞机自由行34 2016年 06月 29日  2016年 07月 28日 ',34,13,5,'12365','receiver24','addresss','2345667789',0),(62,'湖南游','美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游','美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游湖南游五星级上海跟团游8 2016年 06月 14日  2016年 06月 23日 ',8,7,11,'12365','receiver3','addresss23','2345667789',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refund`
--

DROP TABLE IF EXISTS `refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderform_id` bigint(20) NOT NULL,
  `message` varchar(200) NOT NULL DEFAULT '',
  `state` int(11) NOT NULL DEFAULT '0',
  `supplier_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderform_id` (`orderform_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `refund_ibfk_1` FOREIGN KEY (`orderform_id`) REFERENCES `orderform` (`id`),
  CONSTRAINT `refund_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `angency` (`id`),
  CONSTRAINT `refund_ibfk_3` FOREIGN KEY (`buyer_id`) REFERENCES `angency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refund`
--

LOCK TABLES `refund` WRITE;
/*!40000 ALTER TABLE `refund` DISABLE KEYS */;
INSERT INTO `refund` VALUES (1,4,'不想买了，退款',0,6,7),(2,5,'顾客临时家里有事',0,6,7);
/*!40000 ALTER TABLE `refund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refund_picture`
--

DROP TABLE IF EXISTS `refund_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refund_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `refund_id` bigint(20) NOT NULL,
  `picture_path` varchar(100) NOT NULL DEFAULT 'images\\default.png',
  `brief` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `refund_id` (`refund_id`),
  CONSTRAINT `refund_picture_ibfk_1` FOREIGN KEY (`refund_id`) REFERENCES `refund` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refund_picture`
--

LOCK TABLES `refund_picture` WRITE;
/*!40000 ALTER TABLE `refund_picture` DISABLE KEYS */;
INSERT INTO `refund_picture` VALUES (1,1,'images\\default.png',''),(2,2,'images\\default.png',''),(3,2,'images\\default.png','');
/*!40000 ALTER TABLE `refund_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_type`
--

DROP TABLE IF EXISTS `tourist_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL DEFAULT '',
  `brief` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_type`
--

LOCK TABLES `tourist_type` WRITE;
/*!40000 ALTER TABLE `tourist_type` DISABLE KEYS */;
INSERT INTO `tourist_type` VALUES (1,'成人',''),(2,'儿童',''),(3,'学生',''),(4,'军人',''),(5,'喰种','');
/*!40000 ALTER TABLE `tourist_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traffic_type`
--

DROP TABLE IF EXISTS `traffic_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traffic_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL DEFAULT '',
  `brief` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traffic_type`
--

LOCK TABLES `traffic_type` WRITE;
/*!40000 ALTER TABLE `traffic_type` DISABLE KEYS */;
INSERT INTO `traffic_type` VALUES (1,'火车','train'),(2,'飞机','flight'),(3,'轮船','ship'),(4,'汽车','一言不合就开车'),(6,'其他','其他'),(8,'出发','飞机'),(9,'出发','飞机'),(10,'出发','飞机'),(11,'出发','飞机'),(12,'出发','大巴'),(13,'出发','出发方式'),(14,'出发','出发方式'),(15,'出发','出发方式'),(16,'出发','出发方式'),(17,'出发','出发方式'),(18,'出发','出发方式'),(19,'出发','出发方式');
/*!40000 ALTER TABLE `traffic_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_record`
--

DROP TABLE IF EXISTS `transaction_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_id` bigint(20) NOT NULL,
  `to_id` bigint(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0',
  `orderform_id` bigint(20) DEFAULT NULL,
  `brief` varchar(45) DEFAULT '""',
  PRIMARY KEY (`id`),
  KEY `from_ref_idx` (`from_id`),
  KEY `to_ref_idx` (`to_id`),
  KEY `order_ref_idx` (`orderform_id`),
  CONSTRAINT `from_ref` FOREIGN KEY (`from_id`) REFERENCES `angency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ref` FOREIGN KEY (`orderform_id`) REFERENCES `orderform` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `to_ref` FOREIGN KEY (`to_id`) REFERENCES `angency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_record`
--

LOCK TABLES `transaction_record` WRITE;
/*!40000 ALTER TABLE `transaction_record` DISABLE KEYS */;
INSERT INTO `transaction_record` VALUES (9,7,6,'2016-06-20 04:35:36',0,6,NULL),(10,7,6,'2016-06-20 04:42:55',0,6,NULL),(11,7,6,'2016-06-20 04:58:07',1,7,NULL),(12,7,6,'2016-06-20 06:46:17',0,5,NULL);
/*!40000 ALTER TABLE `transaction_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_accomodation`
--

DROP TABLE IF EXISTS `trip_accomodation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_accomodation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `accomodation_type` varchar(45) NOT NULL DEFAULT '',
  `brief` varchar(100) NOT NULL DEFAULT '',
  `is_expired` tinyint(1) NOT NULL DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `trip_accomodation_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_accomodation`
--

LOCK TABLES `trip_accomodation` WRITE;
/*!40000 ALTER TABLE `trip_accomodation` DISABLE KEYS */;
INSERT INTO `trip_accomodation` VALUES (1,2,'五星级','生态大酒店,香港',0,'2016-05-03 16:00:00'),(2,2,'五星级','澳门大酒店',0,'2016-05-06 13:54:29'),(3,2,'五星级','台湾客栈',0,'2016-05-06 13:54:48'),(4,3,'三星级','加州如家',0,'2016-05-06 13:55:12'),(5,4,'五星级','',0,'2016-05-06 13:55:43'),(8,27,'酒店','这是5星酒店',0,'2016-05-13 11:35:25'),(9,30,'酒店','这是5星酒店',0,'2016-05-13 11:48:51'),(11,32,'五星级','这是5星酒店',0,'2016-05-13 12:29:51'),(12,34,'五星级','这是5星酒店',0,'2016-05-14 07:42:50'),(13,35,'四星级','这是4星酒店',0,'2016-05-14 07:47:50'),(15,51,'测试酒店','测试酒店说明',0,'2016-05-14 10:42:08'),(16,52,'酒店','这是5星酒店',0,'2016-06-07 01:23:06'),(17,53,'酒店','这是5星酒店',0,'2016-06-07 01:23:12'),(18,54,'酒店','这是5星酒店',0,'2016-06-07 01:23:21'),(22,58,'五星级','这是5星酒店',0,'2016-06-19 06:39:51'),(23,59,'五星级','测试酒店说明',0,'2016-06-19 07:10:31'),(25,61,'酒店','这是5星酒店',0,'2016-06-19 07:35:09'),(26,62,'五星级','测试酒店说明',0,'2016-06-19 11:20:44');
/*!40000 ALTER TABLE `trip_accomodation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_destination`
--

DROP TABLE IF EXISTS `trip_destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_destination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `location_id` bigint(20) NOT NULL,
  `brief` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `trip_destination_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `trip_destination_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_destination`
--

LOCK TABLES `trip_destination` WRITE;
/*!40000 ALTER TABLE `trip_destination` DISABLE KEYS */;
INSERT INTO `trip_destination` VALUES (1,2,5,'香港'),(2,2,9,'澳门'),(3,2,6,'台湾'),(4,3,3,'加州'),(5,4,7,''),(6,7,2,''),(8,13,2,''),(9,14,2,''),(10,16,2,''),(16,22,2,''),(18,24,2,'test td1'),(20,26,2,'test td1'),(21,26,3,'test td2'),(22,27,2,''),(23,28,3,'test td2'),(24,28,2,'test td1'),(25,29,3,'test td2'),(26,29,2,'test td1'),(27,30,2,''),(29,32,2,''),(30,33,3,'test td2'),(31,33,2,'test td1'),(32,34,2,''),(33,35,2,''),(35,37,3,'test td2'),(36,37,2,'test td1'),(37,38,3,'test td2444'),(38,38,2,'test td1333'),(41,40,2,'test td1333'),(42,40,3,'test td2444'),(43,41,2,'test td1333'),(44,41,3,'test td2444'),(45,42,2,'test tdd1'),(46,42,3,'test tdd2'),(47,43,2,'test tdd1'),(48,43,3,'test tdd2'),(49,51,2,''),(50,52,2,''),(51,53,2,''),(52,54,2,''),(59,58,8,''),(60,59,8,''),(61,59,70,''),(64,61,106,''),(65,61,24,''),(66,62,24,''),(67,62,142,'');
/*!40000 ALTER TABLE `trip_destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_detail`
--

DROP TABLE IF EXISTS `trip_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL DEFAULT '',
  `content` text,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `trip_detail_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_detail`
--

LOCK TABLES `trip_detail` WRITE;
/*!40000 ALTER TABLE `trip_detail` DISABLE KEYS */;
INSERT INTO `trip_detail` VALUES (1,'行程简介','携程旅行网\n简体中文\n客服中心\n国内：1010-6666\n首页\n酒店 \n旅游 \n机票 \n火车 \n汽车票 \n用车 \n门票 \n团购 \n攻略\n全球购 \n礼品卡 \n商旅 \n更多 \n登录|注册我的携程\n目的地攻略游记问答伴游周末游口碑榜智慧旅游我的主页\n搜索城市、景点、游记、问答、用户\n \n旅游攻略社区>目的地>中国>香港行程>\n香港紧凑充实暴走1日游\n香港紧凑充实暴走1日游\n\n作者携程小编|浏览14056分享\n天数：1天观光地：11个 全程：13公里\n此行去了：香港\n行程标签：美食 城市观光 逛特色街 逛夜市 看表演 游山/爬山\n你可以一天内走遍香港最知名的景点，既坐了特色缆车和双层巴士又搭乘了港剧里经典的天星小轮，既能在太平山顶用餐又能在香港的夜市探寻小吃。\n行程详情\n心动特惠\n行程详情\n第1天 | 香港\n今日备忘：如果你只有1天时间，而且还是第一次来香港，那么这条线路再适合不过了。白天奔走在维港两岸看到摩天大楼的现代，到了夜晚，深入香港老街体会不夜城的魅力吧！\n1海港城\n4.6分(1102条点评)\n游玩指南：在尖沙咀吃过早茶，10点左右前往全香港面积最大的购物中心——海港城，是大陆人最熟知的一站式购物商场。价格虽然不比莎莎卓悦优惠，但胜在大而全。早上游览购物，刚好可以避免在大牌门前排长龙。商场里餐厅也不少，午餐就在这里解决啦。建议游玩时间3小时 #交通指南#乘坐港铁港铁尖沙咀站A1、C1和E出口。\n开放时间：周一-周日10:00-22:00\n分类：综合商场\n\n两地距离约1.3 公里 ：公交约27分钟 查看地图\n\n2维多利亚港\n4.4分(2194条点评)\n游玩指南：维港类似广州的珠江、上海的黄浦江。传说中的维港的大黄鸭就停在海港城旁，漫步海港边，遥看对岸港岛的高楼大厦。出了海港城，岸边就是维多利亚湾。\n游玩时间：建议1小时\n开放时间：全天开放\n门票价格：￥149 |  携程价：¥36预订\n\n3天星小轮\n游玩指南：沿维港向东步行，抵达尖沙咀天星码头，乘坐香港历史最悠久的渡轮。而且只需要2、3元港币，不仅便宜，沿途还能欣赏到维港风光。乘坐时间30分钟。\n4山顶缆车\n4.1分(502条点评)\n游玩指南：下了天星小轮，来到太平山顶下，乘坐香港独具特色的山顶缆车，直达太平山顶。坐在缆车上，可以看到传说中斜45度的视觉效果哟！建议上山和下山，一次乘坐缆车一次乘坐巴士。\n游玩时间：建议1小时\n开放时间：7:00-凌晨00:00(周一-周日及公众假期)，每10-15分钟一班。\n\n两地距离约1.8 公里 ：公交约47分钟 查看地图\n\n5太平山顶\n4.5分(4466条点评)\n游玩指南：乘坐缆车到达太平山顶仅需8分钟。山顶最有名的莫过于杜莎夫人蜡像馆，其次就是俯瞰维港夜景。游览整个太平山顶，杜莎夫人蜡像馆等至少需3个小时。\n游玩时间：建议3小时\n开放时间：缆车: 7:00-24:00，每10-15分钟一班；凌霄阁: 周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00。\n门票价格：￥25 |  携程价：¥18预订\n\n两地距离约784米 ：步行约15分钟 查看地图\n\n6凌霄阁\n4.2分(328条点评)\n游玩指南：山顶缆车的终点站就在凌霄阁的3楼，动身直奔凌霄阁的杜莎夫人蜡像馆或者信不信由你奇趣馆！如果是乘坐缆车，8分钟后就已经在凌霄阁3楼。\n游玩时间：建议1小时\n开放时间：周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00；山顶缆车：7:00-24:00(周一-周日及公众假期)\n\n两地距离约12米 ：步行约1分钟查看地图\n\n7香港杜莎夫人蜡像馆\n4.5分(2228条点评)\n游玩指南：鼎鼎有名的杜莎夫人蜡像馆是香港游的必去之地。蜡像馆就山顶凌霄阁内。游玩时间1.5小时。\n游玩时间：建议3小时\n开放时间：10:00-22:00，21:45停止入场；位于花园道山顶缆车总站的杜莎夫人蜡像馆套票专柜 9:30-21:00。\n门票价格：￥175 |  携程价：¥120预订\n\n两地距离约3.9 公里 ：公交约47分钟 查看地图\n\n8星光大道\n4.2分(1852条点评)\n游玩指南：从天星码头步行来到效仿好莱坞的星光大道，试着寻找地面上名人的打手印吧！\n游玩时间：建议1小时\n开放时间：全天开放\n\n9幻彩咏香江\n游玩指南：每晚8点，全程15分钟，维港两岸44座摩天大楼合作进行灯光互动表演，是香港的经典游玩项目之一。\n10旺角\n4.2分(1295条点评)\n游玩指南：这里较受年轻人的喜欢，不少商店和餐厅都是通宵营业。好像内地的夜市，街边林立着各种铺子，售卖各种小商品的和小吃，还有不少街边的艺人表演。\n游玩时间：建议3小时\n开放时间：全天开放，各商铺营业时间不同\n\n两地距离约271米 ：步行约3分钟 查看地图\n\n11通菜街\n3.7分(211条点评)\n游玩指南：夜晚的通菜街，绝对让你体会到什么是人口密度最高的地方。女生也不会无聊，因为街边林立着各种香港知名小吃，比如义顺牛奶、许留山、牛丸等等。当然啦，连锁的化妆品店莎莎、卓悦也是有的可以一边吃一边逛，就像是内地的夜市。\n游玩时间：建议1小时\n开放时间：街道全天开放，摊位营业时间为12:00-22:30。\n\n心动特惠\n正在努力加载中…\n12\n地图数据 ©2016 GS(2011)6020 Google\n使用条款\n\n\n\n\n周边酒店周边餐饮查看大地图\n你可能也想看更多\n\n香港离岛风情3日游\n3天 6个景点\n香港\n\n吃货的香港专属3日游\n3天 15个景点\n香港\n\n香港经典4日游\n4天 21个景点\n香港\n旅游攻略导航当季热点：香港上海深圳重庆三亚西安厦门南京武汉昆明青岛天津郑州沈阳乌鲁木齐\n香港旅游攻略指南? 携程攻略社区! 靠谱的旅游攻略平台，最佳的香港自助游、自由行、自驾游、跟团旅线路，海量香港旅游景点图片、游记、交通、美食、购物、住宿、娱乐、行程、指南等旅游攻略信息，了解更多香港旅游信息就来携程旅游攻略。\n香港旅游快速入口+更多\n香港旅游攻略香港旅游介绍香港旅游地图香港旅游图片香港交通线路香港天气预报香港旅行游记香港旅游问答香港景点推荐香港酒店预订香港特色美食香港购物攻略香港娱乐体验香港行程推荐香港酒店推荐香港客栈预订香港旅游香港结伴旅游香港攻略下载香港旅游印象香港自助游攻略香港周末旅游香港特价机票\n中国旅游攻略导航：\n\n杭州上海成都厦门台北香港北京苏州南京丽江重庆台湾武汉昆明广州天津深圳云南澳门无锡大理大连长沙宁波沈阳四川桂林西安西双版纳哈尔滨张家界拉萨高雄三亚扬州青岛花莲黄山香格里拉凤凰北海绍兴西藏中国垦丁南宁乌镇贵阳阿坝福州西宁海南阳朔湘西秦皇岛长春九寨沟浙江广东威海\n热门旅游目的地推荐全部 >\n洞头旅游攻略文登旅游攻略绥宁旅游攻略东极旅游攻略巴伦西亚旅游攻略高淳旅游攻略沽岛旅游攻略丹江口旅游攻略沙姆沙伊赫旅游攻略泰宁旅游攻略蓬莱旅游攻略从江旅游攻略库车旅游攻略怡保旅游攻略黄龙溪古镇旅游攻略胶州旅游攻略长阳旅游攻略图们旅游攻略牡丹江旅游攻略仰光旅游攻略\n亚历山大蛇岛许愿墙恒河回龙观蒙顶山三家店西岭雪山金海湖嘉兴天柱山天一广场微山湖园博园止锚湾中国城牛背山哭墙印象刘三姐白云峰\n热门旅游攻略+更多\n上海旅游攻略黄山旅游攻略厦门旅游攻略青岛旅游攻略台湾旅游攻略乌镇旅游攻略九寨沟旅游攻略长白山旅游攻略桂林旅游攻略杭州旅游攻略张家界旅游攻略北京旅游攻略西双版纳旅游攻略阳朔旅游攻略西安旅游攻略凤凰旅游攻略重庆旅游攻略泰山旅游攻略敦煌旅游攻略三亚旅游攻略\n地标推荐\n香港地标保健服务餐馆餐厅大型卖场公共交通交通服务酒店旅馆美发洗浴汽车销服商场百货商务住宅生活服务水电煤气附近玩乐医院诊所饮料小食运动场所专柜专卖\n地图导航\n攻略社区旅游攻略旅行游记旅游问答结伴向导智慧旅游攻略下载机票查询天气预报旅游资讯旅游榜单旅游百科旅游专题欧洲旅游亚洲旅游地图大全氢气球移动入口\n最新游友动态资讯\n[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................\n社区必读\n用户协议\n社区指南\n经验与等级\n新手导航\n发现你的旅行\n了解目的地\n阅读精彩游记\n下载精品攻略\n请教旅行达人\n发起结伴\n分享你的旅行\n发表游记大作\n点评去过的景点\n关于我们\n社区简介\n联系我们\n加入我们\n智慧旅游\n关注携程攻略社区\n网站导航 | 宾馆索引 | 机票索引 | 旅游索引 | 商旅索引 | 攻略索引 | 关于携程 | 企业公民 | 诚聘英才  | 智慧旅游  | 分销联盟 | 代理合作 | 企业商旅 | 中小企业差旅 | 广告业务 | 联系我们\n酒店加盟 | 旅游局及景区合作 |  服务说明 |  营业执照 | 旅游度假资质 | 保险代理 | 友情链接 | Copyright©1999-2016, ctrip.com. All rights reserved. | ICP证：沪B2-20050130\n沪公网备31010502000018号\n信用评级上海工商诚信网站网络社会征信网信息举报中心可信网站违法和不良信息举报中心 \n写点评100%送礼品卡！美食商家入驻携程，助你脱颖而出！争华人优选，成2.5亿人美食首选\n \n反馈建议\n携程旅行网\n简体中文\n客服中心\n国内：1010-6666\n首页\n酒店 \n旅游 \n机票 \n火车 \n汽车票 \n用车 \n门票 \n团购 \n攻略\n全球购 \n礼品卡 \n商旅 \n更多 \n登录|注册我的携程\n目的地攻略游记问答伴游周末游口碑榜智慧旅游我的主页\n搜索城市、景点、游记、问答、用户\n \n旅游攻略社区>目的地>中国>香港行程>\n香港紧凑充实暴走1日游\n香港紧凑充实暴走1日游\n\n作者携程小编|浏览14056分享\n天数：1天观光地：11个 全程：13公里\n此行去了：香港\n行程标签：美食 城市观光 逛特色街 逛夜市 看表演 游山/爬山\n你可以一天内走遍香港最知名的景点，既坐了特色缆车和双层巴士又搭乘了港剧里经典的天星小轮，既能在太平山顶用餐又能在香港的夜市探寻小吃。\n行程详情\n心动特惠\n行程详情\n第1天 | 香港\n今日备忘：如果你只有1天时间，而且还是第一次来香港，那么这条线路再适合不过了。白天奔走在维港两岸看到摩天大楼的现代，到了夜晚，深入香港老街体会不夜城的魅力吧！\n1海港城\n4.6分(1102条点评)\n游玩指南：在尖沙咀吃过早茶，10点左右前往全香港面积最大的购物中心——海港城，是大陆人最熟知的一站式购物商场。价格虽然不比莎莎卓悦优惠，但胜在大而全。早上游览购物，刚好可以避免在大牌门前排长龙。商场里餐厅也不少，午餐就在这里解决啦。建议游玩时间3小时 #交通指南#乘坐港铁港铁尖沙咀站A1、C1和E出口。\n开放时间：周一-周日10:00-22:00\n分类：综合商场\n\n两地距离约1.3 公里 ：公交约27分钟 查看地图\n\n2维多利亚港\n4.4分(2194条点评)\n游玩指南：维港类似广州的珠江、上海的黄浦江。传说中的维港的大黄鸭就停在海港城旁，漫步海港边，遥看对岸港岛的高楼大厦。出了海港城，岸边就是维多利亚湾。\n游玩时间：建议1小时\n开放时间：全天开放\n门票价格：￥149 |  携程价：¥36预订\n\n3天星小轮\n游玩指南：沿维港向东步行，抵达尖沙咀天星码头，乘坐香港历史最悠久的渡轮。而且只需要2、3元港币，不仅便宜，沿途还能欣赏到维港风光。乘坐时间30分钟。\n4山顶缆车\n4.1分(502条点评)\n游玩指南：下了天星小轮，来到太平山顶下，乘坐香港独具特色的山顶缆车，直达太平山顶。坐在缆车上，可以看到传说中斜45度的视觉效果哟！建议上山和下山，一次乘坐缆车一次乘坐巴士。\n游玩时间：建议1小时\n开放时间：7:00-凌晨00:00(周一-周日及公众假期)，每10-15分钟一班。\n\n两地距离约1.8 公里 ：公交约47分钟 查看地图\n\n5太平山顶\n4.5分(4466条点评)\n游玩指南：乘坐缆车到达太平山顶仅需8分钟。山顶最有名的莫过于杜莎夫人蜡像馆，其次就是俯瞰维港夜景。游览整个太平山顶，杜莎夫人蜡像馆等至少需3个小时。\n游玩时间：建议3小时\n开放时间：缆车: 7:00-24:00，每10-15分钟一班；凌霄阁: 周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00。\n门票价格：￥25 |  携程价：¥18预订\n\n两地距离约784米 ：步行约15分钟 查看地图\n\n6凌霄阁\n4.2分(328条点评)\n游玩指南：山顶缆车的终点站就在凌霄阁的3楼，动身直奔凌霄阁的杜莎夫人蜡像馆或者信不信由你奇趣馆！如果是乘坐缆车，8分钟后就已经在凌霄阁3楼。\n游玩时间：建议1小时\n开放时间：周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00；山顶缆车：7:00-24:00(周一-周日及公众假期)\n\n两地距离约12米 ：步行约1分钟查看地图\n\n7香港杜莎夫人蜡像馆\n4.5分(2228条点评)\n游玩指南：鼎鼎有名的杜莎夫人蜡像馆是香港游的必去之地。蜡像馆就山顶凌霄阁内。游玩时间1.5小时。\n游玩时间：建议3小时\n开放时间：10:00-22:00，21:45停止入场；位于花园道山顶缆车总站的杜莎夫人蜡像馆套票专柜 9:30-21:00。\n门票价格：￥175 |  携程价：¥120预订\n\n两地距离约3.9 公里 ：公交约47分钟 查看地图\n\n8星光大道\n4.2分(1852条点评)\n游玩指南：从天星码头步行来到效仿好莱坞的星光大道，试着寻找地面上名人的打手印吧！\n游玩时间：建议1小时\n开放时间：全天开放\n\n9幻彩咏香江\n游玩指南：每晚8点，全程15分钟，维港两岸44座摩天大楼合作进行灯光互动表演，是香港的经典游玩项目之一。\n10旺角\n4.2分(1295条点评)\n游玩指南：这里较受年轻人的喜欢，不少商店和餐厅都是通宵营业。好像内地的夜市，街边林立着各种铺子，售卖各种小商品的和小吃，还有不少街边的艺人表演。\n游玩时间：建议3小时\n开放时间：全天开放，各商铺营业时间不同\n\n两地距离约271米 ：步行约3分钟 查看地图\n\n11通菜街\n3.7分(211条点评)\n游玩指南：夜晚的通菜街，绝对让你体会到什么是人口密度最高的地方。女生也不会无聊，因为街边林立着各种香港知名小吃，比如义顺牛奶、许留山、牛丸等等。当然啦，连锁的化妆品店莎莎、卓悦也是有的可以一边吃一边逛，就像是内地的夜市。\n游玩时间：建议1小时\n开放时间：街道全天开放，摊位营业时间为12:00-22:30。\n\n心动特惠\n正在努力加载中…\n12\n地图数据 ©2016 GS(2011)6020 Google\n使用条款\n\n\n\n\n周边酒店周边餐饮查看大地图\n你可能也想看更多\n\n香港离岛风情3日游\n3天 6个景点\n香港\n\n吃货的香港专属3日游\n3天 15个景点\n香港\n\n香港经典4日游\n4天 21个景点\n香港\n旅游攻略导航当季热点：香港上海深圳重庆三亚西安厦门南京武汉昆明青岛天津郑州沈阳乌鲁木齐\n香港旅游攻略指南? 携程攻略社区! 靠谱的旅游攻略平台，最佳的香港自助游、自由行、自驾游、跟团旅线路，海量香港旅游景点图片、游记、交通、美食、购物、住宿、娱乐、行程、指南等旅游攻略信息，了解更多香港旅游信息就来携程旅游攻略。\n香港旅游快速入口+更多\n香港旅游攻略香港旅游介绍香港旅游地图香港旅游图片香港交通线路香港天气预报香港旅行游记香港旅游问答香港景点推荐香港酒店预订香港特色美食香港购物攻略香港娱乐体验香港行程推荐香港酒店推荐香港客栈预订香港旅游香港结伴旅游香港攻略下载香港旅游印象香港自助游攻略香港周末旅游香港特价机票\n中国旅游攻略导航：\n\n杭州上海成都厦门台北香港北京苏州南京丽江重庆台湾武汉昆明广州天津深圳云南澳门无锡大理大连长沙宁波沈阳四川桂林西安西双版纳哈尔滨张家界拉萨高雄三亚扬州青岛花莲黄山香格里拉凤凰北海绍兴西藏中国垦丁南宁乌镇贵阳阿坝福州西宁海南阳朔湘西秦皇岛长春九寨沟浙江广东威海\n热门旅游目的地推荐全部 >\n洞头旅游攻略文登旅游攻略绥宁旅游攻略东极旅游攻略巴伦西亚旅游攻略高淳旅游攻略沽岛旅游攻略丹江口旅游攻略沙姆沙伊赫旅游攻略泰宁旅游攻略蓬莱旅游攻略从江旅游攻略库车旅游攻略怡保旅游攻略黄龙溪古镇旅游攻略胶州旅游攻略长阳旅游攻略图们旅游攻略牡丹江旅游攻略仰光旅游攻略\n亚历山大蛇岛许愿墙恒河回龙观蒙顶山三家店西岭雪山金海湖嘉兴天柱山天一广场微山湖园博园止锚湾中国城牛背山哭墙印象刘三姐白云峰\n热门旅游攻略+更多\n上海旅游攻略黄山旅游攻略厦门旅游攻略青岛旅游攻略台湾旅游攻略乌镇旅游攻略九寨沟旅游攻略长白山旅游攻略桂林旅游攻略杭州旅游攻略张家界旅游攻略北京旅游攻略西双版纳旅游攻略阳朔旅游攻略西安旅游攻略凤凰旅游攻略重庆旅游攻略泰山旅游攻略敦煌旅游攻略三亚旅游攻略\n地标推荐\n香港地标保健服务餐馆餐厅大型卖场公共交通交通服务酒店旅馆美发洗浴汽车销服商场百货商务住宅生活服务水电煤气附近玩乐医院诊所饮料小食运动场所专柜专卖\n地图导航\n攻略社区旅游攻略旅行游记旅游问答结伴向导智慧旅游攻略下载机票查询天气预报旅游资讯旅游榜单旅游百科旅游专题欧洲旅游亚洲旅游地图大全氢气球移动入口\n最新游友动态资讯\n[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................\n社区必读\n用户协议\n社区指南\n经验与等级\n新手导航\n发现你的旅行\n了解目的地\n阅读精彩游记\n下载精品攻略\n请教旅行达人\n发起结伴\n分享你的旅行\n发表游记大作\n点评去过的景点\n关于我们\n社区简介\n联系我们\n加入我们\n智慧旅游\n关注携程攻略社区\n网站导航 | 宾馆索引 | 机票索引 | 旅游索引 | 商旅索引 | 攻略索引 | 关于携程 | 企业公民 | 诚聘英才  | 智慧旅游  | 分销联盟 | 代理合作 | 企业商旅 | 中小企业差旅 | 广告业务 | 联系我们\n酒店加盟 | 旅游局及景区合作 |  服务说明 |  营业执照 | 旅游度假资质 | 保险代理 | 友情链接 | Copyright©1999-2016, ctrip.com. All rights reserved. | ICP证：沪B2-20050130\n沪公网备31010502000018号\n信用评级上海工商诚信网站网络社会征信网信息举报中心可信网站违法和不良信息举报中心 \n写点评100%送礼品卡！美食商家入驻携程，助你脱颖而出！争华人优选，成2.5亿人美食首选\n \n反馈建议\n携程旅行网\n简体中文\n客服中心\n国内：1010-6666\n首页\n酒店 \n旅游 \n机票 \n火车 \n汽车票 \n用车 \n门票 \n团购 \n攻略\n全球购 \n礼品卡 \n商旅 \n更多 \n登录|注册我的携程\n目的地攻略游记问答伴游周末游口碑榜智慧旅游我的主页\n搜索城市、景点、游记、问答、用户\n \n旅游攻略社区>目的地>中国>香港行程>\n香港紧凑充实暴走1日游\n香港紧凑充实暴走1日游\n\n作者携程小编|浏览14056分享\n天数：1天观光地：11个 全程：13公里\n此行去了：香港\n行程标签：美食 城市观光 逛特色街 逛夜市 看表演 游山/爬山\n你可以一天内走遍香港最知名的景点，既坐了特色缆车和双层巴士又搭乘了港剧里经典的天星小轮，既能在太平山顶用餐又能在香港的夜市探寻小吃。\n行程详情\n心动特惠\n行程详情\n第1天 | 香港\n今日备忘：如果你只有1天时间，而且还是第一次来香港，那么这条线路再适合不过了。白天奔走在维港两岸看到摩天大楼的现代，到了夜晚，深入香港老街体会不夜城的魅力吧！\n1海港城\n4.6分(1102条点评)\n游玩指南：在尖沙咀吃过早茶，10点左右前往全香港面积最大的购物中心——海港城，是大陆人最熟知的一站式购物商场。价格虽然不比莎莎卓悦优惠，但胜在大而全。早上游览购物，刚好可以避免在大牌门前排长龙。商场里餐厅也不少，午餐就在这里解决啦。建议游玩时间3小时 #交通指南#乘坐港铁港铁尖沙咀站A1、C1和E出口。\n开放时间：周一-周日10:00-22:00\n分类：综合商场\n\n两地距离约1.3 公里 ：公交约27分钟 查看地图\n\n2维多利亚港\n4.4分(2194条点评)\n游玩指南：维港类似广州的珠江、上海的黄浦江。传说中的维港的大黄鸭就停在海港城旁，漫步海港边，遥看对岸港岛的高楼大厦。出了海港城，岸边就是维多利亚湾。\n游玩时间：建议1小时\n开放时间：全天开放\n门票价格：￥149 |  携程价：¥36预订\n\n3天星小轮\n游玩指南：沿维港向东步行，抵达尖沙咀天星码头，乘坐香港历史最悠久的渡轮。而且只需要2、3元港币，不仅便宜，沿途还能欣赏到维港风光。乘坐时间30分钟。\n4山顶缆车\n4.1分(502条点评)\n游玩指南：下了天星小轮，来到太平山顶下，乘坐香港独具特色的山顶缆车，直达太平山顶。坐在缆车上，可以看到传说中斜45度的视觉效果哟！建议上山和下山，一次乘坐缆车一次乘坐巴士。\n游玩时间：建议1小时\n开放时间：7:00-凌晨00:00(周一-周日及公众假期)，每10-15分钟一班。\n\n两地距离约1.8 公里 ：公交约47分钟 查看地图\n\n5太平山顶\n4.5分(4466条点评)\n游玩指南：乘坐缆车到达太平山顶仅需8分钟。山顶最有名的莫过于杜莎夫人蜡像馆，其次就是俯瞰维港夜景。游览整个太平山顶，杜莎夫人蜡像馆等至少需3个小时。\n游玩时间：建议3小时\n开放时间：缆车: 7:00-24:00，每10-15分钟一班；凌霄阁: 周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00。\n门票价格：￥25 |  携程价：¥18预订\n\n两地距离约784米 ：步行约15分钟 查看地图\n\n6凌霄阁\n4.2分(328条点评)\n游玩指南：山顶缆车的终点站就在凌霄阁的3楼，动身直奔凌霄阁的杜莎夫人蜡像馆或者信不信由你奇趣馆！如果是乘坐缆车，8分钟后就已经在凌霄阁3楼。\n游玩时间：建议1小时\n开放时间：周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00；山顶缆车：7:00-24:00(周一-周日及公众假期)\n\n两地距离约12米 ：步行约1分钟查看地图\n\n7香港杜莎夫人蜡像馆\n4.5分(2228条点评)\n游玩指南：鼎鼎有名的杜莎夫人蜡像馆是香港游的必去之地。蜡像馆就山顶凌霄阁内。游玩时间1.5小时。\n游玩时间：建议3小时\n开放时间：10:00-22:00，21:45停止入场；位于花园道山顶缆车总站的杜莎夫人蜡像馆套票专柜 9:30-21:00。\n门票价格：￥175 |  携程价：¥120预订\n\n两地距离约3.9 公里 ：公交约47分钟 查看地图\n\n8星光大道\n4.2分(1852条点评)\n游玩指南：从天星码头步行来到效仿好莱坞的星光大道，试着寻找地面上名人的打手印吧！\n游玩时间：建议1小时\n开放时间：全天开放\n\n9幻彩咏香江\n游玩指南：每晚8点，全程15分钟，维港两岸44座摩天大楼合作进行灯光互动表演，是香港的经典游玩项目之一。\n10旺角\n4.2分(1295条点评)\n游玩指南：这里较受年轻人的喜欢，不少商店和餐厅都是通宵营业。好像内地的夜市，街边林立着各种铺子，售卖各种小商品的和小吃，还有不少街边的艺人表演。\n游玩时间：建议3小时\n开放时间：全天开放，各商铺营业时间不同\n\n两地距离约271米 ：步行约3分钟 查看地图\n\n11通菜街\n3.7分(211条点评)\n游玩指南：夜晚的通菜街，绝对让你体会到什么是人口密度最高的地方。女生也不会无聊，因为街边林立着各种香港知名小吃，比如义顺牛奶、许留山、牛丸等等。当然啦，连锁的化妆品店莎莎、卓悦也是有的可以一边吃一边逛，就像是内地的夜市。\n游玩时间：建议1小时\n开放时间：街道全天开放，摊位营业时间为12:00-22:30。\n\n心动特惠\n正在努力加载中…\n\n12\n地图数据 ©2016 GS(2011)6020 Google\n使用条款\n\n\n\n\n周边酒店周边餐饮查看大地图\n你可能也想看更多\n\n香港离岛风情3日游\n3天 6个景点\n香港\n\n吃货的香港专属3日游\n3天 15个景点\n香港\n\n香港经典4日游\n4天 21个景点\n香港\n旅游攻略导航当季热点：香港上海深圳重庆三亚西安厦门南京武汉昆明青岛天津郑州沈阳乌鲁木齐\n香港旅游攻略指南? 携程攻略社区! 靠谱的旅游攻略平台，最佳的香港自助游、自由行、自驾游、跟团旅线路，海量香港旅游景点图片、游记、交通、美食、购物、住宿、娱乐、行程、指南等旅游攻略信息，了解更多香港旅游信息就来携程旅游攻略。\n香港旅游快速入口+更多\n香港旅游攻略香港旅游介绍香港旅游地图香港旅游图片香港交通线路香港天气预报香港旅行游记香港旅游问答香港景点推荐香港酒店预订香港特色美食香港购物攻略香港娱乐体验香港行程推荐香港酒店推荐香港客栈预订香港旅游香港结伴旅游香港攻略下载香港旅游印象香港自助游攻略香港周末旅游香港特价机票\n中国旅游攻略导航：\n\n杭州上海成都厦门台北香港北京苏州南京丽江重庆台湾武汉昆明广州天津深圳云南澳门无锡大理大连长沙宁波沈阳四川桂林西安西双版纳哈尔滨张家界拉萨高雄三亚扬州青岛花莲黄山香格里拉凤凰北海绍兴西藏中国垦丁南宁乌镇贵阳阿坝福州西宁海南阳朔湘西秦皇岛长春九寨沟浙江广东威海\n热门旅游目的地推荐全部 >\n洞头旅游攻略文登旅游攻略绥宁旅游攻略东极旅游攻略巴伦西亚旅游攻略高淳旅游攻略沽岛旅游攻略丹江口旅游攻略沙姆沙伊赫旅游攻略泰宁旅游攻略蓬莱旅游攻略从江旅游攻略库车旅游攻略怡保旅游攻略黄龙溪古镇旅游攻略胶州旅游攻略长阳旅游攻略图们旅游攻略牡丹江旅游攻略仰光旅游攻略\n亚历山大蛇岛许愿墙恒河回龙观蒙顶山三家店西岭雪山金海湖嘉兴天柱山天一广场微山湖园博园止锚湾中国城牛背山哭墙印象刘三姐白云峰\n热门旅游攻略+更多\n上海旅游攻略黄山旅游攻略厦门旅游攻略青岛旅游攻略台湾旅游攻略乌镇旅游攻略九寨沟旅游攻略长白山旅游攻略桂林旅游攻略杭州旅游攻略张家界旅游攻略北京旅游攻略西双版纳旅游攻略阳朔旅游攻略西安旅游攻略凤凰旅游攻略重庆旅游攻略泰山旅游攻略敦煌旅游攻略三亚旅游攻略\n地标推荐\n香港地标保健服务餐馆餐厅大型卖场公共交通交通服务酒店旅馆美发洗浴汽车销服商场百货商务住宅生活服务水电煤气附近玩乐医院诊所饮料小食运动场所专柜专卖\n地图导航\n攻略社区旅游攻略旅行游记旅游问答结伴向导智慧旅游攻略下载机票查询天气预报旅游资讯旅游榜单旅游百科旅游专题欧洲旅游亚洲旅游地图大全氢气球移动入口\n最新游友动态资讯\n[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................\n社区必读\n用户协议\n社区指南\n经验与等级\n新手导航\n发现你的旅行\n了解目的地\n阅读精彩游记\n下载精品攻略\n请教旅行达人\n发起结伴\n分享你的旅行\n发表游记大作\n点评去过的景点\n关于我们\n社区简介\n联系我们\n加入我们\n智慧旅游\n关注携程攻略社区\n网站导航 | 宾馆索引 | 机票索引 | 旅游索引 | 商旅索引 | 攻略索引 | 关于携程 | 企业公民 | 诚聘英才  | 智慧旅游  | 分销联盟 | 代理合作 | 企业商旅 | 中小企业差旅 | 广告业务 | 联系我们\n酒店加盟 | 旅游局及景区合作 |  服务说明 |  营业执照 | 旅游度假资质 | 保险代理 | 友情链接 | Copyright©1999-2016, ctrip.com. All rights reserved. | ICP证：沪B2-20050130\n沪公网备31010502000018号\n信用评级上海工商诚信网站网络社会征信网信息举报中心可信网站违法和不良信息举报中心 \n写点评100%送礼品卡！美食商家入驻携程，助你脱颖而出！争华人优选，成2.5亿人美食首选\n \n反馈建议\n携程旅行网\n简体中文\n客服中心\n国内：1010-6666\n首页\n酒店 \n旅游 \n机票 \n火车 \n汽车票 \n用车 \n门票 \n团购 \n攻略\n全球购 \n礼品卡 \n商旅 \n更多 \n登录|注册我的携程\n目的地攻略游记问答伴游周末游口碑榜智慧旅游我的主页\n搜索城市、景点、游记、问答、用户\n \n旅游攻略社区>目的地>中国>香港行程>\n香港紧凑充实暴走1日游\n香港紧凑充实暴走1日游\n\n作者携程小编|浏览14056分享\n天数：1天观光地：11个 全程：13公里\n此行去了：香港\n行程标签：美食 城市观光 逛特色街 逛夜市 看表演 游山/爬山\n你可以一天内走遍香港最知名的景点，既坐了特色缆车和双层巴士又搭乘了港剧里经典的天星小轮，既能在太平山顶用餐又能在香港的夜市探寻小吃。\n行程详情\n心动特惠\n行程详情\n第1天 | 香港\n今日备忘：如果你只有1天时间，而且还是第一次来香港，那么这条线路再适合不过了。白天奔走在维港两岸看到摩天大楼的现代，到了夜晚，深入香港老街体会不夜城的魅力吧！\n1海港城\n4.6分(1102条点评)\n游玩指南：在尖沙咀吃过早茶，10点左右前往全香港面积最大的购物中心——海港城，是大陆人最熟知的一站式购物商场。价格虽然不比莎莎卓悦优惠，但胜在大而全。早上游览购物，刚好可以避免在大牌门前排长龙。商场里餐厅也不少，午餐就在这里解决啦。建议游玩时间3小时 #交通指南#乘坐港铁港铁尖沙咀站A1、C1和E出口。\n开放时间：周一-周日10:00-22:00\n分类：综合商场\n\n两地距离约1.3 公里 ：公交约27分钟 查看地图\n\n2维多利亚港\n4.4分(2194条点评)\n游玩指南：维港类似广州的珠江、上海的黄浦江。传说中的维港的大黄鸭就停在海港城旁，漫步海港边，遥看对岸港岛的高楼大厦。出了海港城，岸边就是维多利亚湾。\n游玩时间：建议1小时\n开放时间：全天开放\n门票价格：￥149 |  携程价：¥36预订\n\n3天星小轮\n游玩指南：沿维港向东步行，抵达尖沙咀天星码头，乘坐香港历史最悠久的渡轮。而且只需要2、3元港币，不仅便宜，沿途还能欣赏到维港风光。乘坐时间30分钟。\n4山顶缆车\n4.1分(502条点评)\n游玩指南：下了天星小轮，来到太平山顶下，乘坐香港独具特色的山顶缆车，直达太平山顶。坐在缆车上，可以看到传说中斜45度的视觉效果哟！建议上山和下山，一次乘坐缆车一次乘坐巴士。\n游玩时间：建议1小时\n开放时间：7:00-凌晨00:00(周一-周日及公众假期)，每10-15分钟一班。\n\n两地距离约1.8 公里 ：公交约47分钟 查看地图\n\n5太平山顶\n4.5分(4466条点评)\n游玩指南：乘坐缆车到达太平山顶仅需8分钟。山顶最有名的莫过于杜莎夫人蜡像馆，其次就是俯瞰维港夜景。游览整个太平山顶，杜莎夫人蜡像馆等至少需3个小时。\n游玩时间：建议3小时\n开放时间：缆车: 7:00-24:00，每10-15分钟一班；凌霄阁: 周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00。\n门票价格：￥25 |  携程价：¥18预订\n\n两地距离约784米 ：步行约15分钟 查看地图\n\n6凌霄阁\n4.2分(328条点评)\n游玩指南：山顶缆车的终点站就在凌霄阁的3楼，动身直奔凌霄阁的杜莎夫人蜡像馆或者信不信由你奇趣馆！如果是乘坐缆车，8分钟后就已经在凌霄阁3楼。\n游玩时间：建议1小时\n开放时间：周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00；山顶缆车：7:00-24:00(周一-周日及公众假期)\n\n两地距离约12米 ：步行约1分钟查看地图\n\n7香港杜莎夫人蜡像馆\n4.5分(2228条点评)\n游玩指南：鼎鼎有名的杜莎夫人蜡像馆是香港游的必去之地。蜡像馆就山顶凌霄阁内。游玩时间1.5小时。\n游玩时间：建议3小时\n开放时间：10:00-22:00，21:45停止入场；位于花园道山顶缆车总站的杜莎夫人蜡像馆套票专柜 9:30-21:00。\n门票价格：￥175 |  携程价：¥120预订\n\n两地距离约3.9 公里 ：公交约47分钟 查看地图\n\n8星光大道\n4.2分(1852条点评)\n游玩指南：从天星码头步行来到效仿好莱坞的星光大道，试着寻找地面上名人的打手印吧！\n游玩时间：建议1小时\n开放时间：全天开放\n\n9幻彩咏香江\n游玩指南：每晚8点，全程15分钟，维港两岸44座摩天大楼合作进行灯光互动表演，是香港的经典游玩项目之一。\n10旺角\n4.2分(1295条点评)\n游玩指南：这里较受年轻人的喜欢，不少商店和餐厅都是通宵营业。好像内地的夜市，街边林立着各种铺子，售卖各种小商品的和小吃，还有不少街边的艺人表演。\n游玩时间：建议3小时\n开放时间：全天开放，各商铺营业时间不同\n\n两地距离约271米 ：步行约3分钟 查看地图\n\n11通菜街\n3.7分(211条点评)\n游玩指南：夜晚的通菜街，绝对让你体会到什么是人口密度最高的地方。女生也不会无聊，因为街边林立着各种香港知名小吃，比如义顺牛奶、许留山、牛丸等等。当然啦，连锁的化妆品店莎莎、卓悦也是有的可以一边吃一边逛，就像是内地的夜市。\n游玩时间：建议1小时\n开放时间：街道全天开放，摊位营业时间为12:00-22:30。\n\n心动特惠\n正在努力加载中…\n\n12\n地图数据 ©2016 GS(2011)6020 Google\n使用条款\n\n\n\n\n周边酒店周边餐饮查看大地图\n你可能也想看更多\n\n香港离岛风情3日游\n3天 6个景点\n香港\n\n吃货的香港专属3日游\n3天 15个景点\n香港\n\n香港经典4日游\n4天 21个景点\n香港\n旅游攻略导航当季热点：香港上海深圳重庆三亚西安厦门南京武汉昆明青岛天津郑州沈阳乌鲁木齐\n香港旅游攻略指南? 携程攻略社区! 靠谱的旅游攻略平台，最佳的香港自助游、自由行、自驾游、跟团旅线路，海量香港旅游景点图片、游记、交通、美食、购物、住宿、娱乐、行程、指南等旅游攻略信息，了解更多香港旅游信息就来携程旅游攻略。\n香港旅游快速入口+更多\n香港旅游攻略香港旅游介绍香港旅游地图香港旅游图片香港交通线路香港天气预报香港旅行游记香港旅游问答香港景点推荐香港酒店预订香港特色美食香港购物攻略香港娱乐体验香港行程推荐香港酒店推荐香港客栈预订香港旅游香港结伴旅游香港攻略下载香港旅游印象香港自助游攻略香港周末旅游香港特价机票\n中国旅游攻略导航：\n\n杭州上海成都厦门台北香港北京苏州南京丽江重庆台湾武汉昆明广州天津深圳云南澳门无锡大理大连长沙宁波沈阳四川桂林西安西双版纳哈尔滨张家界拉萨高雄三亚扬州青岛花莲黄山香格里拉凤凰北海绍兴西藏中国垦丁南宁乌镇贵阳阿坝福州西宁海南阳朔湘西秦皇岛长春九寨沟浙江广东威海\n热门旅游目的地推荐全部 >\n洞头旅游攻略文登旅游攻略绥宁旅游攻略东极旅游攻略巴伦西亚旅游攻略高淳旅游攻略沽岛旅游攻略丹江口旅游攻略沙姆沙伊赫旅游攻略泰宁旅游攻略蓬莱旅游攻略从江旅游攻略库车旅游攻略怡保旅游攻略黄龙溪古镇旅游攻略胶州旅游攻略长阳旅游攻略图们旅游攻略牡丹江旅游攻略仰光旅游攻略\n亚历山大蛇岛许愿墙恒河回龙观蒙顶山三家店西岭雪山金海湖嘉兴天柱山天一广场微山湖园博园止锚湾中国城牛背山哭墙印象刘三姐白云峰\n热门旅游攻略+更多\n上海旅游攻略黄山旅游攻略厦门旅游攻略青岛旅游攻略台湾旅游攻略乌镇旅游攻略九寨沟旅游攻略长白山旅游攻略桂林旅游攻略杭州旅游攻略张家界旅游攻略北京旅游攻略西双版纳旅游攻略阳朔旅游攻略西安旅游攻略凤凰旅游攻略重庆旅游攻略泰山旅游攻略敦煌旅游攻略三亚旅游攻略\n地标推荐\n香港地标保健服务餐馆餐厅大型卖场公共交通交通服务酒店旅馆美发洗浴汽车销服商场百货商务住宅生活服务水电煤气附近玩乐医院诊所饮料小食运动场所专柜专卖\n地图导航\n攻略社区旅游攻略旅行游记旅游问答结伴向导智慧旅游攻略下载机票查询天气预报旅游资讯旅游榜单旅游百科旅游专题欧洲旅游亚洲旅游地图大全氢气球移动入口\n最新游友动态资讯\n[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................\n社区必读\n用户协议\n社区指南\n经验与等级\n新手导航\n发现你的旅行\n了解目的地\n阅读精彩游记\n下载精品攻略\n请教旅行达人\n发起结伴\n分享你的旅行\n发表游记大作\n点评去过的景点\n关于我们\n社区简介\n联系我们\n加入我们\n智慧旅游\n关注携程攻略社区\n网站导航 | 宾馆索引 | 机票索引 | 旅游索引 | 商旅索引 | 攻略索引 | 关于携程 | 企业公民 | 诚聘英才  | 智慧旅游  | 分销联盟 | 代理合作 | 企业商旅 | 中小企业差旅 | 广告业务 | 联系我们\n酒店加盟 | 旅游局及景区合作 |  服务说明 |  营业执照 | 旅游度假资质 | 保险代理 | 友情链接 | Copyright©1999-2016, ctrip.com. All rights reserved. | ICP证：沪B2-20050130\n沪公网备31010502000018号\n信用评级上海工商诚信网站网络社会征信网信息举报中心可信网站违法和不良信息举报中心 \n写点评100%送礼品卡！美食商家入驻携程，助你脱颖而出！争华人优选，成2.5亿人美食首选\n \n反馈建议\n','2016-05-06 14:04:12',2),(2,'费用说明','携程旅行网\n简体中文\n客服中心\n国内：1010-6666\n首页\n酒店 \n旅游 \n机票 \n火车 \n汽车票 \n用车 \n门票 \n团购 \n攻略\n全球购 \n礼品卡 \n商旅 \n更多 \n登录|注册我的携程\n目的地攻略游记问答伴游周末游口碑榜智慧旅游我的主页\n搜索城市、景点、游记、问答、用户\n \n旅游攻略社区>目的地>中国>香港行程>\n香港紧凑充实暴走1日游\n香港紧凑充实暴走1日游\n\n作者携程小编|浏览14056分享\n天数：1天观光地：11个 全程：13公里\n此行去了：香港\n行程标签：美食 城市观光 逛特色街 逛夜市 看表演 游山/爬山\n你可以一天内走遍香港最知名的景点，既坐了特色缆车和双层巴士又搭乘了港剧里经典的天星小轮，既能在太平山顶用餐又能在香港的夜市探寻小吃。\n行程详情\n心动特惠\n行程详情\n第1天 | 香港\n今日备忘：如果你只有1天时间，而且还是第一次来香港，那么这条线路再适合不过了。白天奔走在维港两岸看到摩天大楼的现代，到了夜晚，深入香港老街体会不夜城的魅力吧！\n1海港城\n4.6分(1102条点评)\n游玩指南：在尖沙咀吃过早茶，10点左右前往全香港面积最大的购物中心——海港城，是大陆人最熟知的一站式购物商场。价格虽然不比莎莎卓悦优惠，但胜在大而全。早上游览购物，刚好可以避免在大牌门前排长龙。商场里餐厅也不少，午餐就在这里解决啦。建议游玩时间3小时 #交通指南#乘坐港铁港铁尖沙咀站A1、C1和E出口。\n开放时间：周一-周日10:00-22:00\n分类：综合商场\n\n两地距离约1.3 公里 ：公交约27分钟 查看地图\n\n2维多利亚港\n4.4分(2194条点评)\n游玩指南：维港类似广州的珠江、上海的黄浦江。传说中的维港的大黄鸭就停在海港城旁，漫步海港边，遥看对岸港岛的高楼大厦。出了海港城，岸边就是维多利亚湾。\n游玩时间：建议1小时\n开放时间：全天开放\n门票价格：￥149 |  携程价：¥36预订\n\n3天星小轮\n游玩指南：沿维港向东步行，抵达尖沙咀天星码头，乘坐香港历史最悠久的渡轮。而且只需要2、3元港币，不仅便宜，沿途还能欣赏到维港风光。乘坐时间30分钟。\n4山顶缆车\n4.1分(502条点评)\n游玩指南：下了天星小轮，来到太平山顶下，乘坐香港独具特色的山顶缆车，直达太平山顶。坐在缆车上，可以看到传说中斜45度的视觉效果哟！建议上山和下山，一次乘坐缆车一次乘坐巴士。\n游玩时间：建议1小时\n开放时间：7:00-凌晨00:00(周一-周日及公众假期)，每10-15分钟一班。\n\n两地距离约1.8 公里 ：公交约47分钟 查看地图\n\n5太平山顶\n4.5分(4466条点评)\n游玩指南：乘坐缆车到达太平山顶仅需8分钟。山顶最有名的莫过于杜莎夫人蜡像馆，其次就是俯瞰维港夜景。游览整个太平山顶，杜莎夫人蜡像馆等至少需3个小时。\n游玩时间：建议3小时\n开放时间：缆车: 7:00-24:00，每10-15分钟一班；凌霄阁: 周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00。\n门票价格：￥25 |  携程价：¥18预订\n\n两地距离约784米 ：步行约15分钟 查看地图\n\n6凌霄阁\n4.2分(328条点评)\n游玩指南：山顶缆车的终点站就在凌霄阁的3楼，动身直奔凌霄阁的杜莎夫人蜡像馆或者信不信由你奇趣馆！如果是乘坐缆车，8分钟后就已经在凌霄阁3楼。\n游玩时间：建议1小时\n开放时间：周一-周五10:00-23:00，周六、周日及公众假期8:00-23:00；山顶缆车：7:00-24:00(周一-周日及公众假期)\n\n两地距离约12米 ：步行约1分钟查看地图\n\n7香港杜莎夫人蜡像馆\n4.5分(2228条点评)\n游玩指南：鼎鼎有名的杜莎夫人蜡像馆是香港游的必去之地。蜡像馆就山顶凌霄阁内。游玩时间1.5小时。\n游玩时间：建议3小时\n开放时间：10:00-22:00，21:45停止入场；位于花园道山顶缆车总站的杜莎夫人蜡像馆套票专柜 9:30-21:00。\n门票价格：￥175 |  携程价：¥120预订\n\n两地距离约3.9 公里 ：公交约47分钟 查看地图\n\n8星光大道\n4.2分(1852条点评)\n游玩指南：从天星码头步行来到效仿好莱坞的星光大道，试着寻找地面上名人的打手印吧！\n游玩时间：建议1小时\n开放时间：全天开放\n\n9幻彩咏香江\n游玩指南：每晚8点，全程15分钟，维港两岸44座摩天大楼合作进行灯光互动表演，是香港的经典游玩项目之一。\n10旺角\n4.2分(1295条点评)\n游玩指南：这里较受年轻人的喜欢，不少商店和餐厅都是通宵营业。好像内地的夜市，街边林立着各种铺子，售卖各种小商品的和小吃，还有不少街边的艺人表演。\n游玩时间：建议3小时\n开放时间：全天开放，各商铺营业时间不同\n\n两地距离约271米 ：步行约3分钟 查看地图\n\n11通菜街\n3.7分(211条点评)\n游玩指南：夜晚的通菜街，绝对让你体会到什么是人口密度最高的地方。女生也不会无聊，因为街边林立着各种香港知名小吃，比如义顺牛奶、许留山、牛丸等等。当然啦，连锁的化妆品店莎莎、卓悦也是有的可以一边吃一边逛，就像是内地的夜市。\n游玩时间：建议1小时\n开放时间：街道全天开放，摊位营业时间为12:00-22:30。\n\n心动特惠\n正在努力加载中…\n\n12\n地图数据 ©2016 GS(2011)6020 Google\n使用条款\n\n\n\n\n周边酒店周边餐饮查看大地图\n你可能也想看更多\n\n香港离岛风情3日游\n3天 6个景点\n香港\n\n吃货的香港专属3日游\n3天 15个景点\n香港\n\n香港经典4日游\n4天 21个景点\n香港\n旅游攻略导航当季热点：香港上海深圳重庆三亚西安厦门南京武汉昆明青岛天津郑州沈阳乌鲁木齐\n香港旅游攻略指南? 携程攻略社区! 靠谱的旅游攻略平台，最佳的香港自助游、自由行、自驾游、跟团旅线路，海量香港旅游景点图片、游记、交通、美食、购物、住宿、娱乐、行程、指南等旅游攻略信息，了解更多香港旅游信息就来携程旅游攻略。\n香港旅游快速入口+更多\n香港旅游攻略香港旅游介绍香港旅游地图香港旅游图片香港交通线路香港天气预报香港旅行游记香港旅游问答香港景点推荐香港酒店预订香港特色美食香港购物攻略香港娱乐体验香港行程推荐香港酒店推荐香港客栈预订香港旅游香港结伴旅游香港攻略下载香港旅游印象香港自助游攻略香港周末旅游香港特价机票\n中国旅游攻略导航：\n\n杭州上海成都厦门台北香港北京苏州南京丽江重庆台湾武汉昆明广州天津深圳云南澳门无锡大理大连长沙宁波沈阳四川桂林西安西双版纳哈尔滨张家界拉萨高雄三亚扬州青岛花莲黄山香格里拉凤凰北海绍兴西藏中国垦丁南宁乌镇贵阳阿坝福州西宁海南阳朔湘西秦皇岛长春九寨沟浙江广东威海\n热门旅游目的地推荐全部 >\n洞头旅游攻略文登旅游攻略绥宁旅游攻略东极旅游攻略巴伦西亚旅游攻略高淳旅游攻略沽岛旅游攻略丹江口旅游攻略沙姆沙伊赫旅游攻略泰宁旅游攻略蓬莱旅游攻略从江旅游攻略库车旅游攻略怡保旅游攻略黄龙溪古镇旅游攻略胶州旅游攻略长阳旅游攻略图们旅游攻略牡丹江旅游攻略仰光旅游攻略\n亚历山大蛇岛许愿墙恒河回龙观蒙顶山三家店西岭雪山金海湖嘉兴天柱山天一广场微山湖园博园止锚湾中国城牛背山哭墙印象刘三姐白云峰\n热门旅游攻略+更多\n上海旅游攻略黄山旅游攻略厦门旅游攻略青岛旅游攻略台湾旅游攻略乌镇旅游攻略九寨沟旅游攻略长白山旅游攻略桂林旅游攻略杭州旅游攻略张家界旅游攻略北京旅游攻略西双版纳旅游攻略阳朔旅游攻略西安旅游攻略凤凰旅游攻略重庆旅游攻略泰山旅游攻略敦煌旅游攻略三亚旅游攻略\n地标推荐\n香港地标保健服务餐馆餐厅大型卖场公共交通交通服务酒店旅馆美发洗浴汽车销服商场百货商务住宅生活服务水电煤气附近玩乐医院诊所饮料小食运动场所专柜专卖\n地图导航\n攻略社区旅游攻略旅行游记旅游问答结伴向导智慧旅游攻略下载机票查询天气预报旅游资讯旅游榜单旅游百科旅游专题欧洲旅游亚洲旅游地图大全氢气球移动入口\n最新游友动态资讯\n[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................[29分钟前] 绿色** 发布了游记 趁春光正好 到香港来一场吃、喝、玩、乐的惬意之行[29分钟前] Flor** 发布了游记 四岁，就去香港过生日吧[29分钟前] E15*** 发布了游记 去香港海洋公园亲亲大自然小动物附香港买钻攻略[29分钟前] ____** 发布了游记 150124非典型香港自由行4D3N[27分钟前] M27*** 发表了问题 #香港九龙维景酒店#贵酒店有沒有提供停车位？如果有的话，是怎样...[27分钟前] _WB2** 发表了问题 #香港盛世酒店 (Inn Hotel Hong Kong)#三个人入住怎么订？[27分钟前] _CFT** 发表了问题 非联程机票 上海_香港_金奈 分开买的机票 是否需要港澳通行证[27分钟前] _CFT** 发表了问题 #香港泰兴酒店（家庭旅馆）#17岁可以入住吗.......................\n社区必读\n用户协议\n社区指南\n经验与等级\n新手导航\n发现你的旅行\n了解目的地\n阅读精彩游记\n下载精品攻略\n请教旅行达人\n发起结伴\n分享你的旅行\n发表游记大作\n点评去过的景点\n关于我们\n社区简介\n联系我们\n加入我们\n智慧旅游\n关注携程攻略社区\n网站导航 | 宾馆索引 | 机票索引 | 旅游索引 | 商旅索引 | 攻略索引 | 关于携程 | 企业公民 | 诚聘英才  | 智慧旅游  | 分销联盟 | 代理合作 | 企业商旅 | 中小企业差旅 | 广告业务 | 联系我们\n酒店加盟 | 旅游局及景区合作 |  服务说明 |  营业执照 | 旅游度假资质 | 保险代理 | 友情链接 | Copyright©1999-2016, ctrip.com. All rights reserved. | ICP证：沪B2-20050130\n沪公网备31010502000018号\n信用评级上海工商诚信网站网络社会征信网信息举报中心可信网站违法和不良信息举报中心 \n写点评100%送礼品卡！美食商家入驻携程，助你脱颖而出！争华人优选，成2.5亿人美食首选\n \n反馈建议\n','2016-05-06 14:06:07',2),(3,'预定须知','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:06:42',2),(4,'行程说明','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',3),(5,'行程须知','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',4),(6,'预定须知','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',4),(12,'自由行','杭州三日游杭州三日游杭州三日游','2016-05-12 16:12:49',22),(15,'自由行','杭州三日游 这是真滴，难道还有假？？？','2016-05-13 11:35:25',27),(16,'自由行','杭州6日游杭州6日游','2016-05-13 11:48:51',30),(18,'自由行','是呀 是苏州一日游','2016-05-13 12:29:51',32),(19,'自由行','南京旅游南京旅游南京旅游','2016-05-14 07:42:50',34),(20,'自由行','南京旅游2南京旅游2南京旅游2','2016-05-14 07:47:50',35),(22,'自由行','西安旅游西安旅游','2016-05-14 10:42:08',51),(23,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:06',52),(24,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:12',53),(25,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:21',54),(29,'自由行','这还是出境游简介 详情','2016-06-19 06:39:51',58),(30,'出境游','美法游详情如下：','2016-06-19 07:10:31',59),(32,'自由行','这是西北游简介 详情','2016-06-19 07:35:09',61),(33,'跟团游','美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游','2016-06-19 11:20:44',62);
/*!40000 ALTER TABLE `trip_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_picture`
--

DROP TABLE IF EXISTS `trip_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `picture_path` varchar(100) NOT NULL DEFAULT '',
  `brief` varchar(100) NOT NULL DEFAULT '',
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `trip_picture_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_picture`
--

LOCK TABLES `trip_picture` WRITE;
/*!40000 ALTER TABLE `trip_picture` DISABLE KEYS */;
INSERT INTO `trip_picture` VALUES (1,'images/2.png','这是默认图片',2),(2,'images/3.png','this is a default picture',2),(3,'images/4.png','this is a default picture',2),(4,'images/5.png','this is a default picture',2),(5,'images/2.png','this is a default picture',3),(6,'images/3.png','this is a default picture',3),(7,'images/4.png','this is a default picture',3),(9,'images\\3f.jpg','图片',27),(10,'images\\3f.jpg','图片',30),(12,'images\\1350954016fUkwCk.jpg','图片',32),(13,'images\\2f.jpg','图片',34),(14,'images\\1350953977DsVHPd.jpg','图片',35),(16,'images\\2f.jpg','图片',51),(17,'images\\51-1350954016fUkwCk.jpg','你在说笑',51),(18,'images\\51-3f.jpg','',58),(19,'images\\51-2f.jpg','这是美法游旅游产品图片',59),(20,'images\\51-2f.jpg','这是西北游',61),(21,'images\\51-3f.jpg','这是 关于旅游景点的图片',62);
/*!40000 ALTER TABLE `trip_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_price`
--

DROP TABLE IF EXISTS `trip_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `tourist_type_id` bigint(20) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `is_expired` tinyint(1) NOT NULL DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `tourist_type_id` (`tourist_type_id`),
  CONSTRAINT `trip_price_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `trip_price_ibfk_2` FOREIGN KEY (`tourist_type_id`) REFERENCES `tourist_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_price`
--

LOCK TABLES `trip_price` WRITE;
/*!40000 ALTER TABLE `trip_price` DISABLE KEYS */;
INSERT INTO `trip_price` VALUES (1,1,1,800,0,'2016-05-05 06:10:19'),(2,1,2,400,0,'2016-05-05 06:10:19'),(3,2,1,8888,0,'2016-05-06 14:31:03'),(4,2,2,4000,0,'2016-05-06 14:31:03'),(5,2,3,5000,0,'2016-05-06 14:31:03'),(6,2,4,1000,0,'2016-05-06 14:31:03'),(7,3,1,10000,0,'2016-05-06 14:31:29'),(8,3,2,5000,0,'2016-05-06 14:31:29'),(9,4,1,1000,0,'2016-05-06 14:32:28'),(10,4,2,500,0,'2016-05-06 14:32:28'),(11,4,5,200,0,'2016-05-06 14:32:28'),(13,27,1,123,0,'2016-05-13 11:35:25'),(14,30,1,123,0,'2016-05-13 11:48:51'),(16,32,1,180,0,'2016-05-13 12:29:51'),(17,34,1,790,0,'2016-05-14 07:42:50'),(18,35,1,789,0,'2016-05-14 07:47:50'),(19,51,2,234,0,'2016-05-14 10:42:08'),(20,51,1,345,0,'2016-05-14 10:42:08'),(21,13,1,200,0,'2016-05-16 13:06:09'),(22,13,2,200,0,'2016-05-16 13:06:09'),(23,14,1,300,0,'2016-05-16 13:06:09'),(24,14,2,200,0,'2016-05-16 13:06:09'),(25,16,1,400,0,'2016-05-16 13:06:09'),(26,16,2,200,0,'2016-05-16 13:06:09'),(27,22,1,600,0,'2016-05-16 13:06:09'),(28,22,2,300,0,'2016-05-16 13:06:09'),(29,24,1,600,0,'2016-05-16 13:06:09'),(30,24,2,300,0,'2016-05-16 13:06:09'),(31,26,1,600,0,'2016-05-16 13:06:09'),(32,26,2,300,0,'2016-05-16 13:06:09'),(33,52,2,134,0,'2016-06-07 01:23:06'),(34,52,1,345,0,'2016-06-07 01:23:06'),(35,53,1,345,0,'2016-06-07 01:23:12'),(36,53,2,134,0,'2016-06-07 01:23:12'),(37,54,1,345,0,'2016-06-07 01:23:21'),(38,54,2,134,0,'2016-06-07 01:23:21'),(45,58,1,23424,0,'2016-06-19 06:39:51'),(46,58,2,2342,0,'2016-06-19 06:39:51'),(47,59,2,2332,0,'2016-06-19 07:10:31'),(48,59,1,2342,0,'2016-06-19 07:10:31'),(51,61,1,2342,0,'2016-06-19 07:35:09'),(52,61,2,232,0,'2016-06-19 07:35:09'),(53,62,2,567,0,'2016-06-19 11:20:44'),(54,62,1,2342,0,'2016-06-19 11:20:44');
/*!40000 ALTER TABLE `trip_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_setoff`
--

DROP TABLE IF EXISTS `trip_setoff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_setoff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `guide_id` bigint(20) NOT NULL,
  `trip_setoff_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `purchase_count` int(11) NOT NULL DEFAULT '0',
  `comment_count` int(11) NOT NULL DEFAULT '0',
  `avg_remark` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `guide_id` (`guide_id`),
  CONSTRAINT `trip_setoff_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `trip_setoff_ibfk_2` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_setoff`
--

LOCK TABLES `trip_setoff` WRITE;
/*!40000 ALTER TABLE `trip_setoff` DISABLE KEYS */;
INSERT INTO `trip_setoff` VALUES (1,1,1,'2004-05-01 16:00:00','2005-05-02 16:00:00',1,1,0),(2,2,2,'2016-05-03 16:00:00','2016-05-06 18:49:06',0,0,0),(3,2,2,'2016-05-05 16:00:00','2016-05-06 18:49:06',0,0,0),(4,2,2,'2016-05-07 16:00:00','2016-05-06 18:49:07',0,0,0),(5,3,2,'2016-05-07 16:00:00','2016-05-06 18:49:07',0,0,0),(6,3,2,'2016-05-09 16:00:00','2016-05-06 18:49:07',0,0,0),(7,3,2,'2016-05-11 16:00:00','2016-05-06 18:49:07',0,0,0),(8,3,2,'2016-05-13 16:00:00','2016-05-06 18:49:07',0,0,0),(9,4,2,'2016-05-08 16:00:00','2016-05-06 18:49:07',0,0,0),(10,4,2,'2016-05-12 16:08:00','2016-05-06 18:49:07',0,0,0),(11,32,2,'2016-05-12 08:00:00','2016-05-15 15:10:42',0,0,0),(12,34,2,'2016-05-13 08:00:00','2016-05-14 07:42:50',0,0,0),(13,35,2,'2016-05-28 08:00:00','2016-05-14 07:47:50',0,0,0),(14,51,2,'2016-05-13 08:00:00','2016-06-19 15:43:50',0,0,0),(15,52,2,'2016-06-11 08:00:00','2016-06-07 01:23:06',0,0,0),(16,53,2,'2016-06-11 08:00:00','2016-06-07 01:23:12',0,0,0),(17,54,2,'2016-06-11 08:00:00','2016-06-07 01:23:21',0,0,0),(18,14,2,'2016-06-18 11:04:41','2016-06-19 15:05:57',0,0,0),(19,14,2,'2016-07-20 16:00:00','2016-06-19 15:38:43',1,0,0),(20,58,4,'2016-06-22 08:00:00','2016-06-19 06:39:51',0,0,0),(21,59,4,'2016-06-21 08:00:00','2016-06-19 07:10:31',0,0,0),(22,61,6,'2016-07-28 08:00:00','2016-06-19 07:35:09',0,0,0),(23,61,6,'2016-06-29 08:00:00','2016-06-19 07:35:09',0,0,0),(24,62,5,'2016-06-23 08:00:00','2016-06-19 11:20:44',0,0,0),(25,62,4,'2016-06-14 08:00:00','2016-06-19 11:20:44',0,0,0);
/*!40000 ALTER TABLE `trip_setoff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_traffic`
--

DROP TABLE IF EXISTS `trip_traffic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_traffic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `traffic_type_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `brief` varchar(100) NOT NULL DEFAULT '',
  `is_expired` tinyint(1) NOT NULL DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `traffic_type_id` (`traffic_type_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `trip_traffic_ibfk_1` FOREIGN KEY (`traffic_type_id`) REFERENCES `traffic_type` (`id`),
  CONSTRAINT `trip_traffic_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_traffic`
--

LOCK TABLES `trip_traffic` WRITE;
/*!40000 ALTER TABLE `trip_traffic` DISABLE KEYS */;
INSERT INTO `trip_traffic` VALUES (1,1,2,'北京到香港',0,'2016-05-06 14:16:14'),(2,2,2,'香港到澳门',0,'2016-05-06 14:16:14'),(3,3,2,'澳门到台湾',0,'2016-05-06 14:16:15'),(4,2,2,'台湾到北京',0,'2016-05-06 14:16:15'),(5,2,3,'北京到加州',0,'2016-05-06 14:17:36'),(6,2,3,'加州到北京',0,'2016-05-06 14:17:36'),(7,2,4,'北京到新加坡',0,'2016-05-06 14:17:36'),(8,2,4,'新加坡到北京',0,'2016-05-06 14:17:37'),(10,6,22,'',1,'2016-05-12 16:12:49'),(12,8,27,'',1,'2016-05-13 11:35:25'),(13,9,30,'',1,'2016-05-13 11:48:51'),(14,10,32,'',1,'2016-05-13 12:29:51'),(15,11,34,'',1,'2016-05-14 07:42:50'),(16,12,35,'',1,'2016-05-14 07:47:50'),(17,13,37,'',1,'2016-05-14 08:25:35'),(18,14,38,'',1,'2016-05-14 08:29:40'),(19,15,40,'',1,'2016-05-14 08:49:29'),(20,16,41,'',1,'2016-05-14 08:53:08'),(21,17,42,'',1,'2016-05-14 09:30:17'),(22,18,43,'',1,'2016-05-14 09:32:32'),(23,19,44,'',1,'2016-05-14 09:34:30'),(24,2,46,'',1,'2016-05-14 09:42:35'),(25,2,47,'',1,'2016-05-14 09:43:43'),(26,2,48,'',1,'2016-05-14 09:44:44'),(27,1,50,'',1,'2016-05-14 09:49:55'),(28,2,50,'',1,'2016-05-14 09:49:55'),(29,2,51,'',1,'2016-05-14 10:42:08'),(30,1,51,'',1,'2016-05-14 10:42:08'),(31,2,52,'',1,'2016-06-07 01:23:06'),(32,1,52,'',1,'2016-06-07 01:23:06'),(33,2,53,'',1,'2016-06-07 01:23:12'),(34,1,53,'',1,'2016-06-07 01:23:12'),(35,1,54,'',1,'2016-06-07 01:23:21'),(36,2,54,'',1,'2016-06-07 01:23:21'),(37,2,58,'',1,'2016-06-19 06:39:51'),(38,1,58,'',1,'2016-06-19 06:39:51'),(39,1,59,'',1,'2016-06-19 07:10:31'),(40,2,59,'',1,'2016-06-19 07:10:31'),(41,1,61,'',1,'2016-06-19 07:35:09'),(42,2,61,'',1,'2016-06-19 07:35:09'),(43,3,62,'',1,'2016-06-19 11:20:44'),(44,1,62,'',1,'2016-06-19 11:20:44');
/*!40000 ALTER TABLE `trip_traffic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-20 15:38:39
