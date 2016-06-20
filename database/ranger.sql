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
INSERT INTO `angency` VALUES (0,'system','system','system','system','system','system','system','system','system',3200,'system',''),(1,'无名旅游社','Andy_wang','身份证','622824456546546','622824456546546','1522222222222','we@126.com','嘉定区','images\\头像.jpg',4600,'这是简介','wang'),(2,'旅游圈','wdc','身份证','622824456546546','622824456546546','5423523532532','admintj@123.con','嘉定区','images\\star.jpg',0,'这是简介','123'),(6,'天马旅行社','Wang Dechang','身份证','1234567890111119','1234567890111119','15222222222','wdchang@github.com','上海四平路','images\\star.jpg',189999,'这是简介','123'),(7,'驰骋','Buyer','身份证','622824456546546','12345678978','1255555555555','buy@github.com','上海市闵行区','images\\b200781802621.jpg&images\\2323.jpg&images\\IMG_20140329_071111.jpg&images\\2f.jpg',766399,'驰骋旅游公司，值得信赖的公司','123'),(8,'八爪鱼','张三','身份证','323232323','这是什么','11111111111111112','admin@126.com','同济大学嘉定校区','images\\8-3f.jpg&images\\8-1350954016fUkwCk.jpg',0,'这是八爪鱼旅游公司','wang'),(9,'八爪鱼分公司','LiSi','身份证','2323232323233','注册人借鉴是什么鬼啊','123123123131','2016512@qq.com','同济大学嘉定校区','images\\5f.jpg',12,'this is brief','wang'),(13,'同济旅游','代总','身份证','12312131','622824456546546','15221399560','admin23@123.com','济事楼516','images\\13-2f.jpg&images\\IMG_20140324_215804.jpg&images\\IMG_6941.JPG',0,'这是公司简介','1231231'),(14,'康康旅游','tongji','身份证','1231231231313','1231312313132','1521223693','tongji@126.com','上海市闵行区','&images\\1663798587338578376.jpg',0,'这是康康旅游公司','tongji'),(15,'3','1','身份证','3','3','3','linsm8968@126.com','3','&images/决策表.xlsx&images/决策表.xlsx',0,'3','3'),(16,'1','1','身份证','1','1','1','linsm8968@126.com','1','&images/决策表.xlsx',0,'1','1');
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (4,2,1,'2016-06-19 13:26:40'),(8,2,7,'2016-06-19 16:41:42'),(9,4,7,'2016-06-19 16:41:42'),(11,13,7,'2016-06-19 16:41:42'),(12,14,7,'2016-06-19 16:41:42'),(13,16,7,'2016-06-19 16:41:42'),(14,22,7,'2016-06-19 16:41:42'),(15,24,7,'2016-06-19 16:41:42'),(16,26,7,'2016-06-19 16:41:42'),(17,27,7,'2016-06-19 16:41:42'),(18,28,7,'2016-06-19 16:41:42'),(19,29,7,'2016-06-19 16:41:42'),(20,30,7,'2016-06-19 16:41:42'),(21,32,7,'2016-06-19 16:41:42'),(22,33,7,'2016-06-19 16:41:42'),(23,34,7,'2016-06-19 16:41:43'),(24,35,7,'2016-06-19 16:41:43'),(25,37,7,'2016-06-19 16:41:43'),(26,38,7,'2016-06-19 16:41:43'),(27,40,7,'2016-06-19 16:41:43'),(28,41,7,'2016-06-19 16:41:43'),(29,42,7,'2016-06-19 16:41:43'),(33,24,1,'2016-06-20 04:02:58'),(35,64,7,'2016-06-20 09:38:57');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES `guide` WRITE;
/*!40000 ALTER TABLE `guide` DISABLE KEYS */;
INSERT INTO `guide` VALUES (1,2,'Andy','','152222222222','111@162.com','同济大学嘉定校区'),(2,7,'赵豪总','','123000000000','120000@com','空岛不知道是什'),(3,6,'Micheal','\0','12345678901','hello@world.com','one picece'),(4,7,'代总','','123456789988','daizongh@123.com','同济大学'),(5,7,'李豪','','123456789988','lizongh@123.com','同济大学济事楼526'),(6,13,'程程','','23423242432','chen@126.com','同济大学学学学'),(7,1,'赵世雨','\0','23332333233','zsy@z.com','四平路'),(8,1,'扬阳','','1234567890','youxiang@github.com','四平路'),(9,1,'李豪','','2345678001','li@li.com','四平路');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
INSERT INTO `orderform` VALUES (1,1,1,'马致远','1213','上海','2016-05-02 16:00:00','2016-05-06 16:00:00',1,5600,123,'廖大炮','代总','documentsdefault.pdf','代总','廖大炮','','we',0),(2,2,2,'邪爷','1234567890','北京四平路','2016-05-06 19:06:37','2016-05-06 19:06:37',2,0,0,'files\\default.pdf','files\\default.pdf','documentsdefault.pdf','files\\default.pdf','files\\default.pdf','','',0),(3,7,3,'徐扬','1234567890','北京路由路','2016-05-06 19:12:30','2016-05-06 19:12:30',12,0,0,'documents/上机实践10.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(4,7,4,'xuyang','1234567890','上海嘉定区','2016-05-06 19:12:30','2016-05-06 19:12:30',12,0,0,'documents/1001-3695(2008)01-0018-04.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(5,7,5,'许扬','1234567890','上海南京东路','2016-05-06 19:12:30','2016-05-06 19:12:30',2,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(6,7,6,'许扬','1234567890','新加坡','2016-05-06 19:12:30','2016-05-06 19:12:30',2,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(7,7,7,'廖山河','1234567890','6号楼','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','大大',0),(8,7,8,'马致远','2345678901','6号楼3楼','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','sda',0),(9,7,9,'王德昌','234543211234',' 电话号码有点长的地方','2016-05-06 19:12:30','2016-05-06 19:12:30',6,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(10,7,10,'wdchang','2345678901','拉夫耶夫','2016-05-06 19:12:30','2016-05-06 19:12:30',7,0,0,'documents\\default.pdf','documents\\default.pdf','documentsdefault.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(11,1,2,'daidongyang','18149771976','sipinglu','2016-05-23 18:39:19','2016-05-23 18:39:19',1,0,0,'documents\\default.pdf','documents\\default.pdf','','documents\\default.pdf','documents\\default.pdf','documets\\default.pdf','',0),(12,7,1,'代东洋','18149771976','四平路','2016-05-24 00:33:04','2016-05-24 00:33:04',6,400,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','sd',0),(13,7,1,'代东洋','18149771976','11111','2016-06-01 17:50:33','2016-06-01 17:50:33',6,1600,0,'documents\\default.pdf','images/上机实践03.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','eeew',0),(14,7,1,'代东洋','18149771976','11111','2016-06-01 17:53:11','2016-06-01 17:53:11',12,3200,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(15,7,1,'王德昌','18149771976','11111','2016-06-02 00:37:53','2016-06-02 00:37:53',12,800,0,'documents/1001-3695(2008)01-0018-04.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(16,7,1,'带你搞定','1234567889','我的地址','2016-06-20 01:00:26','2016-06-20 01:00:26',12,800,0,'documents/1001-3695(2008)01-0018-04.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','我给满分',0),(17,7,1,'代东洋','1234567890','代东洋的地址','2016-06-20 02:24:27','2016-06-20 02:24:27',2,800,0,'documents/第7章 语义分析和中间代码产生.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(18,7,19,'代东洋','1234567890','四平路1239号','2016-06-20 03:29:03','2016-06-20 03:29:03',2,0,0,'documents/global-capstone-proposal-4-TJU.PDF','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(19,7,27,'马致远','4446666888','四平路','2016-06-20 09:39:38','2016-06-20 09:39:38',6,0,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','哇去',0),(20,7,27,'代东洋','1234567890','四平路','2016-06-20 10:38:32','2016-06-20 10:38:32',12,0,0,'documents/1001-3695(2008)01-0018-04.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0),(21,7,27,'dai','1234567890','sipinglu','2016-06-20 10:40:43','2016-06-20 10:40:43',12,0,0,'documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','documents\\default.pdf','',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform_tourist`
--

LOCK TABLES `orderform_tourist` WRITE;
/*!40000 ALTER TABLE `orderform_tourist` DISABLE KEYS */;
INSERT INTO `orderform_tourist` VALUES (1,1,1,'马大哥','','000000000000','','2016-05-05 06:08:14','身份证','000000000000000000',0,''),(2,1,2,'小马','\0','622824456546546','','2016-05-05 06:08:14','身份证','000000000000000000',0,''),(3,2,1,'王德昌','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(4,2,2,'许扬','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(5,2,3,'王德昌','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(6,3,1,'王大锤','\0','1234567890','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(7,3,2,'王德昌','\0','12345678901','','2016-05-06 19:18:05','身份证','000000000000000000',0,''),(8,4,1,'王大锤','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(9,4,2,'王德昌','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(10,5,1,'许扬','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(11,5,2,'邪也','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(12,6,1,'东方不切','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(13,6,2,'王德昌','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(14,7,1,'王德福','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(15,7,2,'王德芳','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(16,8,1,'王德芳','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(17,8,2,'党风','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(18,9,1,'东方不切','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(19,9,2,'邪夜','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(20,10,1,'谢烨','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(21,10,2,'邪爷','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(22,10,3,'东方不白','\0','12345678901','','2016-05-06 19:18:06','身份证','000000000000000000',0,''),(23,1,1,'dsa','','weqe','wqeq','2016-05-11 16:00:00','身份证','wqe',0,'ewqe'),(24,1,1,'sd','','dsa','sad@12','2016-05-10 16:00:00','身份证','asdad',0,'das'),(25,1,1,'sd','','dsa','sad@12','2016-05-10 16:00:00','身份证','asdad',0,'das'),(26,1,1,'sd','','dsa','sad@1232','2016-05-10 16:00:00','身份证','asdad',0,'das'),(27,1,2,'das','','发送','43@q','2016-05-10 16:00:00','身份证','2313',0,'叫姐姐'),(28,1,1,'热','\0','11213','2323@12','2016-05-25 16:00:00','身份证','3243434',0,'4mfds'),(29,4,1,'opi','','oip','oiu@yt','2016-05-18 16:00:00','身份证','oip',0,'poi'),(30,3,1,'么么','','123','12@23','2016-05-11 16:00:00','身份证','3213',0,'213'),(31,3,1,'么么','','123','12@23','2016-05-11 16:00:00','身份证','3213',0,'213'),(32,12,2,'weq','','we','wae@qw','2016-05-28 16:00:00','身份证','wae',0,'wa'),(33,3,1,'12','','231','ew@qw','2016-05-18 16:00:00','身份证','231',0,'wean'),(34,3,1,'we','\0','wea','wae@qw','2016-05-04 16:00:00','身份证','wa',0,'wae'),(35,3,1,'asd','','asd','sad@daw','2016-05-25 16:00:00','身份证','asd',0,'das'),(36,3,1,'w','\0','32','wae@we','2016-05-18 16:00:00','身份证','eqw',0,'wq'),(37,3,1,'ew','','we','we@ew','2016-05-11 16:00:00','身份证','wea',0,'we'),(38,3,1,'sad','\0','sad','dsa@e','2016-05-17 16:00:00','护照','sa',0,'sad'),(39,3,1,'wae','','wea','aew@ewa','2016-05-18 16:00:00','身份证','wae',0,'wae'),(40,3,1,'y','','tr','et@r','2016-04-26 16:00:00','身份证','tr',0,'tr'),(41,3,1,'ewr','\0','ewr','rew@re','2016-05-18 16:00:00','护照','ewr',0,'rew'),(42,3,1,'dsa','','sad','dsaq@wq','2016-05-03 16:00:00','身份证','sad',0,'sad'),(43,3,1,'123','','213','123','2016-04-25 00:00:00','身份证','213',0,'213'),(44,3,1,'12321','','23','21313','2016-05-09 00:00:00','身份证','2323',0,'2133213'),(45,15,1,'王德昌','','18149771976','test@test.com','2016-12-31 00:00:00','护照','1111111',0,'备注'),(46,13,1,'f 问问','','we','321@32','2016-06-17 00:00:00','身份证','213',0,'23'),(47,13,1,'321','','213','321','2016-06-09 00:00:00','身份证','213',0,'23'),(48,16,1,'马2','','3213','432@q1','2016-06-21 00:00:00','身份证','2131313',0,'2132131'),(49,14,1,'1','','12','12','2016-06-09 00:00:00','身份证','12',0,'12'),(50,14,1,'2','','12','12','2016-06-15 00:00:00','身份证','21',0,'12'),(51,14,1,'3','','12','12','2016-06-22 00:00:00','身份证','12',0,'21'),(52,14,1,'ewqewq','','weqe','weq','2016-06-16 00:00:00','身份证','wqe',0,'wqe'),(53,17,1,' ew','','ewq','weq@11','2016-06-01 00:00:00','身份证','wqe',0,'eqw'),(54,19,1,'许扬','','123456789','222@22.com','2016-06-16 00:00:00','身份证','22222222222222',0,'2'),(55,19,2,'李豪','','3332221111','333@33.com','2016-06-23 00:00:00','护照','33333333333333',0,'3'),(56,18,1,'21','','1221','121@qqw','2016-06-07 00:00:00','身份证','1212',0,'1212'),(57,20,1,'li','','1234567890','邮箱','2016-06-30 00:00:00','身份证','33333333333333',0,'备注'),(58,21,1,'li','','12345678','youxiang@youxiang.com','2016-06-14 00:00:00','身份证','412724123456789',0,'beizu'),(59,21,1,'bi','','22222222','haole','2016-06-23 00:00:00','身份证','4567890',0,'beizu'),(60,15,1,'12','','23','321@23','2016-06-15 00:00:00','身份证','23',0,'23'),(61,15,1,'21313','','21321','213','2016-06-15 00:00:00','身份证','3213',0,'321'),(62,16,1,'1','','213','213@1','2016-06-23 00:00:00','身份证','213',0,'213'),(63,16,1,'23','','231','213','2016-06-16 00:00:00','身份证','213',0,'213');
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'金牌旅游','非常好','上海三日游',10,1,1,'','','','',0),(2,'港澳台三日游','港澳台','港澳台 游轮 如家 飞机 香港 澳门 台湾',3,6,4,'21804','wdChang','上海东大街11111号','1234567890',87),(3,'加州一日游','加州','美国 加州 一日游',3,6,4,'201804','wdc','上海西大街234号','1234567890',2),(4,'新加坡两日游','新加坡','新加坡 singapore',4,6,4,'123456','wdc','北京欢饮您','',12),(7,'?????','?????','?? ???',3,7,17,'201804','wdchang','SiPing Road','12345678',0),(13,'北京三日游','北京三日游','北京 三日游',3,7,11,'201804','wdchang','SiPing Road','12345678',13),(14,'北京三日游','北京三日游 这是北京三日游详情 + 三日游','北京 三日游',3,7,11,'201804','wdchang','SiPing Road','12345678',19),(16,'杭州一日游','杭州一日游，从上海出发，杭州一日游，从上海出发，','杭州一日游，从上海出发，杭州一日游，从上海出发，杭州一日游，从上海出发，杭州一日游，从上海出发。',1,7,11,'12365','receiver','addresss','1111111',0),(22,'杭州三日游','杭州三日游 杭州三日游','杭州三日游杭州三日游杭州三日游',3,7,11,'12365','receiver2','addresss2','121212121',0),(24,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',10),(26,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',6),(27,'杭州三日游','杭州三日游 这是真滴','杭州三日游 这是真滴，难道还有假？？？',3,7,11,'12365','receiver','addresss','121212121',0),(28,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(29,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(30,'杭州6日游','杭州6日游','杭州6日游杭州6日游',6,7,11,'12365','receiver','addresss','12121',0),(32,'一日游苏州','苏州一日游呀','是呀 是苏州一日游',1,7,11,'12365232','receiver3','test addresss !!!','2345667789',0),(33,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(34,'南京旅游','南京旅游 南京旅游火车南京旅游南京旅游南京旅游南京旅游五星级上海飞机2016-05-13T16:00:00.000Z自由行7','南京旅游南京旅游南京旅游',7,7,11,'12365232','receiver24','addresss234','235678990',0),(35,'南京旅游2','南京旅游2 南京旅游2飞机南京旅游2南京旅游2南京旅游2南京旅游2四星级上海大巴2016-05-28T16:00:00.000Z自由行6','南京旅游2南京旅游2南京旅游2',6,7,11,'12365232','receiver245','addresss235','1234566788',0),(37,'北京三日游','北京三日游','北京 三日游 火车',3,9,11,'201804','wdchang','SiPing Road','12345678',2),(38,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(40,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',3),(41,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(42,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(43,'北京三日游','北京三日游','北京 三日游',3,9,53,'201804','wdchang','SiPing Road','12345678',0),(44,'北京三日游','北京三日游','北京 三日游',3,9,54,'201804','wdchang','SiPing Road','12345678',0),(46,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(47,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(48,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',0),(49,'北京三日游','北京三日游','北京 三日游',3,9,11,'201804','wdchang','SiPing Road','12345678',1),(50,'北京三日游','北京三日游','北京 三日游',3,9,3,'201804','wdchang','SiPing Road','12345678',0),(51,'西安旅游','西安旅游西安旅游测试back西安旅游西安旅游西安旅游测试酒店上海测试','西安旅游西安旅游',3,7,55,'12365232','receiver2456','addresss23','234555455',0),(52,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,56,'200091','代总','同济大学','182125362',0),(53,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,57,'200091','代总','同济大学','182125362',0),(54,'北京游','这是北京旅游的产品，详情。。。。。','这是北京旅游的产品火车这是北京旅游的产品，详情。。。。。北京游酒店上海飞机2016-06-11T16:00:00.000Z自由行5',5,9,58,'200091','代总','同济大学','182125362',0),(58,'出境游','这还是出境游简介 详情','这还是出境游简介飞机这还是出境游简介 详情出境游五星级飞机自由行23 2016年 06月 20日 ',23,7,11,'12365','receiver','addresss','2345667789',0),(59,'美法游','美法游详情如下：','这是美法游飞机美法游详情如下：美法游五星级香港飞机出境游3 2016年 06月 21日 ',3,7,5,'12365','receiver','addresss','2345667789',0),(61,'西北游','这是西北游简介 详情','这是西北游简介大巴这是西北游简介 详情西北游酒店香港飞机自由行34 2016年 06月 29日  2016年 07月 28日 ',34,13,5,'12365','receiver24','addresss','2345667789',0),(62,'湖南游','美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游','美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游美食之旅·湖南+大理+丽江+石林+双廊+玉龙雪山+丽江古城6日5晚跟团游湖南游五星级上海跟团游8 2016年 06月 14日  2016年 06月 23日 ',8,7,11,'12365','receiver3','addresss23','2345667789',5),(64,'港澳台三日游','港澳台三日游 香港 澳门 台湾','港澳台三日游 香港 澳门 台湾港澳台三日游 香港 澳门 台湾港澳台三日游五星级上海跟团10 2016年 06月 19日  2016年 07月 31日 飞机',10,1,11,'200092','廖山河','曹安公路4800号','1000000000',5),(65,'港澳台十一日游','十一天','香港 澳门 台湾 十一日 在台北两天十一天港澳台十一日游四星级上海出团游11 2016年 06月 22日  2016年 06月 30日  2016年 07月 05日 飞机 火车',11,1,11,'200092','李豪','北京市','1234567890',0),(66,'港澳台十二日游','港澳台十二日游 香港 澳门 台湾','港澳台十二日游港澳台十二日游 香港 澳门 台湾港澳台十二日游四星级上海跟团游12 2016年 06月 19日  2016年 06月 21日  2016年 06月 29日 飞机',12,1,11,'200092','李豪','四平路1239号','1234567890',0),(67,'港澳台十三日游','港澳台十三日游 香港 澳门 台湾 港澳台13日游','港澳台十三日游港澳台十三日游 香港 澳门 台湾 港澳台13日游港澳台十三日游三星级上海跟团13 2016年 06月 23日  2016年 06月 21日  2016年 07月 07日 飞机 ',13,1,11,'200092','李豪','四平路1239号','1234567890',0),(68,'港澳台十四日游','香港 澳门 台湾 港澳台14日游 台北','港澳台十四日游香港 澳门 台湾 港澳台14日游 台北港澳台十四日游二星级台北市跟团行14 2016年 06月 21日  2016年 06月 21日  2016年 07月 06日 飞机',14,1,117,'200092','李豪','四平路1239号','1234567890',0),(69,'港澳台十五日游','港澳台十五日游 港澳台15日游 香港 台湾 日月潭 澳门','港澳台十五日游港澳台十五日游 港澳台15日游 香港 台湾 日月潭 澳门港澳台十五日游五星级上海跟团游15 2016年 06月 29日  2016年 06月 08日 飞机',15,1,11,'12345','李星辰','李星辰的地址','1234567890',0),(70,'港澳台十六日游','香港 澳门 台湾 日月潭 台北 港澳台16日游 五月天 周杰伦','港澳台十六日游香港 澳门 台湾 日月潭 台北 港澳台16日游 五月天 周杰伦港澳台十六日游三星级上海16日游16 2016年 06月 22日  2016年 06月 08日 飞机',16,1,11,'12345','李星辰','收件人的地址','1234567890',4),(71,'港澳台十七日游','港澳台17日游 香港 澳门 台湾 周杰伦','港澳台十七日游-周杰伦演唱会港澳台17日游 香港 澳门 台湾 周杰伦港澳台十七日游三星级上海跟团16 2016年 06月 21日 飞机',16,1,11,'123456','李星辰','李星辰的地址','1234567890',2),(72,'港澳台十八日游','香港 澳门 台湾 日月潭 港澳台18日游','港澳台十八日游香港 澳门 台湾 日月潭 港澳台18日游港澳台十八日游三星级上海自由行18 2016年 06月 07日 飞机',18,1,11,'12345','代东洋','代东洋的收件地址','13803948879',0),(73,'港澳台十九日游','产品详情','港澳台十九日游  香港 澳门 台湾 旅游产品详情港澳台十九日游三星级上海自由行19 2016年 06月 20日  2016年 06月 20日  2016年 06月 21日  2016年 06月 23日  2016年 06月 29日  2016年 06月 30日 ',19,1,11,'12345','代东洋','代东洋的收件地址','123467893345',0),(74,'港澳台二十日游','香港 澳门 台湾 港澳台20日游','港澳台二十日游香港 澳门 台湾 港澳台20日游港澳台二十日游三星级上海20 2016年 06月 23日 飞机',20,1,11,'234567','代东洋','代东洋的收件地址','1234567890',0),(75,'港澳台五日游','港澳台5日游  香港 澳门 台湾 日月潭 五月天','港澳台五日游港澳台5日游  香港 澳门 台湾 日月潭 五月天港澳台五日游六星级上海自由行5 2016年 06月 27日  2016年 06月 26日 飞机',5,1,11,'200092','代东洋','代东洋的收件地址','1234567890',0),(76,'港澳台八日游','港澳台八日游 香港 澳门 台湾','港澳台八日游港澳台八日游 香港 澳门 台湾港澳台八日游三星级上海自由行8 飞机 2016年 06月 22日 ',8,1,11,'1234567890','王德昌','王德昌的地址','1234567890',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_record`
--

LOCK TABLES `transaction_record` WRITE;
/*!40000 ALTER TABLE `transaction_record` DISABLE KEYS */;
INSERT INTO `transaction_record` VALUES (18,7,1,'2016-06-20 11:37:46',1,17,NULL),(19,7,1,'2016-06-20 11:47:41',0,17,NULL),(20,7,1,'2016-06-20 11:52:26',0,17,NULL),(21,7,1,'2016-06-20 11:58:05',0,17,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_accomodation`
--

LOCK TABLES `trip_accomodation` WRITE;
/*!40000 ALTER TABLE `trip_accomodation` DISABLE KEYS */;
INSERT INTO `trip_accomodation` VALUES (1,2,'五星级','生态大酒店,香港',0,'2016-05-03 16:00:00'),(2,2,'五星级','澳门大酒店',0,'2016-05-06 13:54:29'),(3,2,'五星级','台湾客栈',0,'2016-05-06 13:54:48'),(4,3,'三星级','加州如家',0,'2016-05-06 13:55:12'),(5,4,'五星级','',0,'2016-05-06 13:55:43'),(8,27,'酒店','这是5星酒店',0,'2016-05-13 11:35:25'),(9,30,'酒店','这是5星酒店',0,'2016-05-13 11:48:51'),(11,32,'五星级','这是5星酒店',0,'2016-05-13 12:29:51'),(12,34,'五星级','这是5星酒店',0,'2016-05-14 07:42:50'),(13,35,'四星级','这是4星酒店',0,'2016-05-14 07:47:50'),(15,51,'测试酒店','测试酒店说明',0,'2016-05-14 10:42:08'),(16,52,'酒店','这是5星酒店',0,'2016-06-07 01:23:06'),(17,53,'酒店','这是5星酒店',0,'2016-06-07 01:23:12'),(18,54,'酒店','这是5星酒店',0,'2016-06-07 01:23:21'),(22,58,'五星级','这是5星酒店',0,'2016-06-19 06:39:51'),(23,59,'五星级','测试酒店说明',0,'2016-06-19 07:10:31'),(25,61,'酒店','这是5星酒店',0,'2016-06-19 07:35:09'),(26,62,'五星级','测试酒店说明',0,'2016-06-19 11:20:44'),(28,64,'五星级','如家',0,'2016-06-20 09:32:19'),(29,65,'四星级','如家',0,'2016-06-20 09:59:30'),(30,66,'四星级','如家',0,'2016-06-20 10:04:28'),(31,67,'三星级','如家',0,'2016-06-20 10:10:20'),(32,68,'二星级','如家',0,'2016-06-20 10:17:04'),(33,69,'五星级','如家',0,'2016-06-20 12:18:43'),(34,70,'三星级','如家',0,'2016-06-20 12:25:11'),(35,71,'三星级','如家',0,'2016-06-20 12:29:06'),(36,72,'三星级','如家',0,'2016-06-20 12:41:00'),(37,73,'三星级','如家',0,'2016-06-20 12:45:10'),(38,74,'三星级','如家',0,'2016-06-20 12:49:08'),(39,75,'六星级','如家',0,'2016-06-20 12:52:49'),(40,76,'三星级','如家',0,'2016-06-20 13:29:01');
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
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_destination`
--

LOCK TABLES `trip_destination` WRITE;
/*!40000 ALTER TABLE `trip_destination` DISABLE KEYS */;
INSERT INTO `trip_destination` VALUES (1,2,5,'香港'),(2,2,9,'澳门'),(3,2,6,'台湾'),(4,3,3,'加州'),(5,4,7,''),(6,7,2,''),(8,13,2,''),(9,14,2,''),(10,16,2,''),(16,22,2,''),(18,24,2,'test td1'),(20,26,2,'test td1'),(21,26,3,'test td2'),(22,27,2,''),(23,28,3,'test td2'),(24,28,2,'test td1'),(25,29,3,'test td2'),(26,29,2,'test td1'),(27,30,2,''),(29,32,2,''),(30,33,3,'test td2'),(31,33,2,'test td1'),(32,34,2,''),(33,35,2,''),(35,37,3,'test td2'),(36,37,2,'test td1'),(37,38,3,'test td2444'),(38,38,2,'test td1333'),(41,40,2,'test td1333'),(42,40,3,'test td2444'),(43,41,2,'test td1333'),(44,41,3,'test td2444'),(45,42,2,'test tdd1'),(46,42,3,'test tdd2'),(47,43,2,'test tdd1'),(48,43,3,'test tdd2'),(49,51,2,''),(50,52,2,''),(51,53,2,''),(52,54,2,''),(59,58,8,''),(60,59,8,''),(61,59,70,''),(64,61,106,''),(65,61,24,''),(66,62,24,''),(67,62,142,''),(69,64,5,''),(70,64,9,''),(71,64,6,''),(72,65,9,''),(73,65,117,''),(74,65,6,''),(75,65,5,''),(76,66,118,''),(77,66,5,''),(78,66,9,''),(79,67,5,''),(80,67,9,''),(81,67,117,''),(82,68,9,''),(83,68,5,''),(84,68,117,''),(85,69,117,''),(86,69,9,''),(87,69,5,''),(88,70,6,''),(89,70,5,''),(90,70,9,''),(91,70,117,''),(92,71,121,''),(93,71,5,''),(94,71,6,''),(95,72,5,''),(96,72,6,''),(97,73,5,''),(98,73,6,''),(99,74,9,''),(100,74,5,''),(101,74,117,''),(102,75,123,''),(103,75,5,''),(104,76,5,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_detail`
--

LOCK TABLES `trip_detail` WRITE;
/*!40000 ALTER TABLE `trip_detail` DISABLE KEYS */;
INSERT INTO `trip_detail` VALUES (1,'行程简介','早餐后，在酒店大厅集合，专车前往丝绸港湾码头，乘９点快艇前往第一个马慕迪岛，您可在此浮潜（浮潜用具以及救生提供)，还可自费参加精采刺激的香蕉船、拖曳伞、水上摩托车、飞鱼等各种水上活动！过后中午于岛上享用BBQ午餐。餐后前往另一个岛（沙比岛），您可在此游泳、浮潜或进行水上活动（请务必穿着救生衣）。下午约３点离开海岛，返回码头然后再乘车回酒店。','2016-05-06 14:04:12',2),(2,'费用说明','住宿标准：全程入住指定酒店，特别安排2晚特色酒店-“海景房”。\n用餐标准：含6正4早；早餐：围桌五点一粥（不用不退费）；正餐：十菜一汤（十人一桌）；正餐餐标：15元/人/餐；（自愿放弃 费用不退）。','2016-05-06 14:06:07',2),(3,'预定须知','1.为了不耽误您的行程，请您严格按照《出团通知书》要求，在航班起飞前2小时到达机场办理登机手续。出团通知书会在出发前1天给到您。\n2.按国家规定，可以不占座位的儿童的标准为0.8米以下怀抱婴儿，0.8米以上儿童必须占座，否则，我社可依据《新交通法规》的有规定，为了保证车上其他游客的正常行程及生命安全，有权拒绝儿童参加本次旅游活动，由此产生的一切后果和损失由游客自负。\n3.根据国家法律规定，为确保您的游程顺利，请随身携带并自行保管好您的有效身份证明原件（儿童携带户口簿原件）。','2016-05-06 14:06:42',2),(4,'行程说明','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',3),(5,'行程须知','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',4),(6,'预定须知','景点介绍\n\n维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-05-06 14:07:45',4),(12,'自由行','杭州三日游杭州三日游杭州三日游','2016-05-12 16:12:49',22),(15,'自由行','杭州三日游 这是真滴，难道还有假？？？','2016-05-13 11:35:25',27),(16,'自由行','杭州6日游杭州6日游','2016-05-13 11:48:51',30),(18,'自由行','是呀 是苏州一日游','2016-05-13 12:29:51',32),(19,'自由行','南京旅游南京旅游南京旅游','2016-05-14 07:42:50',34),(20,'自由行','南京旅游2南京旅游2南京旅游2','2016-05-14 07:47:50',35),(22,'自由行','西安旅游西安旅游','2016-05-14 10:42:08',51),(23,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:06',52),(24,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:12',53),(25,'自由行','这是北京旅游的产品，详情。。。。。','2016-06-07 01:23:21',54),(29,'自由行','这还是出境游简介 详情','2016-06-19 06:39:51',58),(30,'出境游','美法游详情如下：','2016-06-19 07:10:31',59),(32,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-19 07:35:09',61),(33,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-19 11:20:44',62),(35,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 09:32:19',64),(36,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 09:59:30',65),(37,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 10:04:28',66),(38,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 10:10:20',67),(39,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 10:17:04',68),(40,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:18:43',69),(41,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:25:11',70),(42,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:29:06',71),(43,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:41:00',72),(44,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:45:10',73),(45,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:49:08',74),(46,'行程须知','景点介绍  维多利亚港简称维港，地处香港岛（中环、湾仔）与九龙半岛（尖沙咀）之间，因无敌海景和夜景，成为游客来港必到之地。入夜后万家灯火，相互辉映，维港夜景因而与日本函馆和意大利那不勒斯并列“世界三大夜景”。 两岸景观盘点 维多利亚港不只是一个海港，更是一个不能错过的景点，首推的是每晚8点上演的大型灯光汇演“幻彩咏香江”，40余栋大楼配合着充满节奏感的音乐，发出缤纷而闪烁跃动的灯光、激光，令人目眩神迷。此外，港口南北两岸的景观也令人称道，南岸的香港岛有充满现代感的高楼大厦，最醒目的是那几何形的中银大厦和高耸的新地标建筑——香港国际金融中心，还有经常在影视作品中出现的香港会议展览中心。北岸的九龙则有星光大道、尖沙咀天星码头、香港太空馆和香港艺术馆等知名景点。 最佳“景观位” 印有明星手印的星光大道就在维港北岸边，它和边上的尖沙咀天星码头观景平台，都是观赏维港南岸景致和“幻彩咏香江”的绝佳位置。而维港南岸的中环天星码头和香港会议展览中心，则是观赏北岸九龙景色的绝佳位置。若想更好的欣赏维港，可以坐上天星小轮漫游维港，或者参加不同的维港海上游观光团，登上观光船或者中','2016-06-20 12:52:49',75),(47,'自由行','港澳台八日游 香港 澳门 台湾','2016-06-20 13:29:01',76);
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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_picture`
--

LOCK TABLES `trip_picture` WRITE;
/*!40000 ALTER TABLE `trip_picture` DISABLE KEYS */;
INSERT INTO `trip_picture` VALUES (1,'images/2.png','这是默认图片',2),(2,'images/3.png','this is a default picture',2),(3,'images/4.png','this is a default picture',2),(4,'images/5.png','this is a default picture',2),(5,'images/2.png','this is a default picture',3),(6,'images/3.png','this is a default picture',3),(7,'images/4.png','this is a default picture',3),(9,'images\\3f.jpg','图片',27),(10,'images\\3f.jpg','图片',30),(12,'images\\1350954016fUkwCk.jpg','图片',32),(13,'images\\2f.jpg','图片',34),(14,'images\\1350953977DsVHPd.jpg','图片',35),(16,'images\\2f.jpg','图片',51),(17,'images\\51-1350954016fUkwCk.jpg','你在说笑',51),(18,'images\\51-3f.jpg','',58),(19,'images\\51-2f.jpg','这是美法游旅游产品图片',59),(20,'images\\51-2f.jpg','这是西北游',61),(21,'images/51-3f.jpg','这是 关于旅游景点的图片',62),(22,'images/51-test1.jpg','澳门',64),(23,'images/51-test2.jpg','迪士尼？',64),(24,'images/51-test3.jpeg','港澳台',64),(25,'images/51-test4.jpg','维多利亚港',64),(26,'images/51-19300001193818133739397808357.jpg','维港1',65),(27,'images/51-9202027_094240189000_2.jpg','图片介绍',65),(28,'images/51-5171786_223819081000_2.jpg','图片介绍',65),(29,'images/51-1340159332VMAkji.jpg','这是图片介绍',66),(30,'images/51-2497788_162025949788_2.jpg','这是图片介绍',66),(31,'images/51-101.jpg','这也是图片介绍',66),(32,'images/51-test1.jpg','test1',66),(33,'images/51-10277245_093028367134_2.jpg','真的是最后一张了',66),(34,'images/51-9202027_094240189000_2.jpg','这是图片介绍',67),(35,'images/51-2497788_162025949788_2.jpg','这是图片介绍',67),(36,'images/51-test4.jpg','这也是图片介绍',67),(37,'images/51-330599-140ZP4192010.jpg','图片介绍',68),(38,'images/51-test1.jpg','图片介绍',68),(39,'images/51-3f9d9754d3ddaddd589e4f967441770a.jpg','澳门的图片',69),(40,'images/51-4e369de65a8c233ff0885fe7b30c5a8c.jpeg','台湾的图片',69),(41,'images/51-7bf32e32daca7b88f47ab54159c03470.jpg','日月潭',70),(42,'images/51-42efe2ccb36e6c2c9eb7cb0a4f13762f.jpg','维港',70),(43,'images/51-85e4e10c7ab30f3cc094a27316865cdc.jpg','',71),(44,'images/51-383a729582f1c4b6aa76a31930d372ab.jpeg','没有图片介绍也可以',71),(45,'images/51-505f6967194e6a026b9ea662ba3c4a0a.jpg','',72),(46,'images/51-776df8f890137151a5536bc55d731642.jpg','',72),(47,'images/51-0801874b5339c1d6abd6fdd5c063a45f.jpg','1',73),(48,'images/51-a0c8a7bf04d977bda3301208164efd34.jpg','2',73),(49,'images/51-b6909e3b664df6aaed62a67767320a2f.jpg','',74),(50,'images/51-d6bb03a227e0258a10d66c5d5a468ffa.jpg','',74),(51,'images/51-b6909e3b664df6aaed62a67767320a2f.jpg','',75),(52,'images/51-baf78a01cf6998e125c4b0276087c507.jpeg','buffer',75),(53,'images/51-f4cb2fb777fe318f744d09a2b9849cd1.jpg','图片介绍',76),(54,'images/51-e3b39ae0219eade396a77d05fb32f092.jpg','图片介绍',76);
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
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_price`
--

LOCK TABLES `trip_price` WRITE;
/*!40000 ALTER TABLE `trip_price` DISABLE KEYS */;
INSERT INTO `trip_price` VALUES (1,1,1,800,0,'2016-05-05 06:10:19'),(2,1,2,400,0,'2016-05-05 06:10:19'),(3,2,1,8888,0,'2016-05-06 14:31:03'),(4,2,2,4000,0,'2016-05-06 14:31:03'),(5,2,3,5000,0,'2016-05-06 14:31:03'),(6,2,4,1000,0,'2016-05-06 14:31:03'),(7,3,1,10000,0,'2016-05-06 14:31:29'),(8,3,2,5000,0,'2016-05-06 14:31:29'),(9,4,1,1000,0,'2016-05-06 14:32:28'),(10,4,2,500,0,'2016-05-06 14:32:28'),(11,4,5,200,0,'2016-05-06 14:32:28'),(13,27,1,123,0,'2016-05-13 11:35:25'),(14,30,1,123,0,'2016-05-13 11:48:51'),(16,32,1,180,0,'2016-05-13 12:29:51'),(17,34,1,790,0,'2016-05-14 07:42:50'),(18,35,1,789,0,'2016-05-14 07:47:50'),(19,51,2,234,0,'2016-05-14 10:42:08'),(20,51,1,345,0,'2016-05-14 10:42:08'),(21,13,1,200,0,'2016-05-16 13:06:09'),(22,13,2,200,0,'2016-05-16 13:06:09'),(23,14,1,300,0,'2016-05-16 13:06:09'),(24,14,2,200,0,'2016-05-16 13:06:09'),(25,16,1,400,0,'2016-05-16 13:06:09'),(26,16,2,200,0,'2016-05-16 13:06:09'),(27,22,1,600,0,'2016-05-16 13:06:09'),(28,22,2,300,0,'2016-05-16 13:06:09'),(29,24,1,600,0,'2016-05-16 13:06:09'),(30,24,2,300,0,'2016-05-16 13:06:09'),(31,26,1,600,0,'2016-05-16 13:06:09'),(32,26,2,300,0,'2016-05-16 13:06:09'),(33,52,2,134,0,'2016-06-07 01:23:06'),(34,52,1,345,0,'2016-06-07 01:23:06'),(35,53,1,345,0,'2016-06-07 01:23:12'),(36,53,2,134,0,'2016-06-07 01:23:12'),(37,54,1,345,0,'2016-06-07 01:23:21'),(38,54,2,134,0,'2016-06-07 01:23:21'),(45,58,1,23424,0,'2016-06-19 06:39:51'),(46,58,2,2342,0,'2016-06-19 06:39:51'),(47,59,2,2332,0,'2016-06-19 07:10:31'),(48,59,1,2342,0,'2016-06-19 07:10:31'),(51,61,1,2342,0,'2016-06-19 07:35:09'),(52,61,2,232,0,'2016-06-19 07:35:09'),(53,62,2,567,0,'2016-06-19 11:20:44'),(54,62,1,2342,0,'2016-06-19 11:20:44'),(57,64,2,1000,0,'2016-06-20 09:32:19'),(58,64,1,2000,0,'2016-06-20 09:32:19'),(59,65,1,3001,0,'2016-06-20 09:59:30'),(60,65,2,2001,0,'2016-06-20 09:59:30'),(61,66,1,430,0,'2016-06-20 10:04:28'),(62,66,2,23,0,'2016-06-20 10:04:28'),(63,67,2,5001,0,'2016-06-20 10:10:20'),(64,67,1,1001,0,'2016-06-20 10:10:20'),(65,68,2,600,0,'2016-06-20 10:17:04'),(66,68,1,230,0,'2016-06-20 10:17:04'),(67,69,1,15,0,'2016-06-20 12:18:43'),(68,69,2,5,0,'2016-06-20 12:18:43'),(69,70,1,25,0,'2016-06-20 12:25:11'),(70,70,2,15,0,'2016-06-20 12:25:11'),(71,71,1,100,0,'2016-06-20 12:29:06'),(72,71,2,0,0,'2016-06-20 12:29:06'),(73,72,1,10000,0,'2016-06-20 12:41:00'),(74,72,2,20000,0,'2016-06-20 12:41:00'),(75,73,2,260,0,'2016-06-20 12:45:10'),(76,73,1,250,0,'2016-06-20 12:45:10'),(77,74,1,20,0,'2016-06-20 12:49:08'),(78,74,2,19,0,'2016-06-20 12:49:08'),(79,75,2,20000,0,'2016-06-20 12:52:49'),(80,75,1,50000,0,'2016-06-20 12:52:49'),(81,76,2,4,0,'2016-06-20 13:29:01'),(82,76,1,8,0,'2016-06-20 13:29:01');
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_setoff`
--

LOCK TABLES `trip_setoff` WRITE;
/*!40000 ALTER TABLE `trip_setoff` DISABLE KEYS */;
INSERT INTO `trip_setoff` VALUES (1,1,1,'2004-05-01 16:00:00','2005-05-02 16:00:00',1,1,0),(2,2,2,'2016-05-03 16:00:00','2016-05-06 18:49:06',0,0,0),(3,2,2,'2016-05-05 16:00:00','2016-05-06 18:49:06',0,0,0),(4,2,2,'2016-05-07 16:00:00','2016-05-06 18:49:07',0,0,0),(5,3,2,'2016-05-07 16:00:00','2016-05-06 18:49:07',0,0,0),(6,3,2,'2016-05-09 16:00:00','2016-05-06 18:49:07',0,0,0),(7,3,2,'2016-05-11 16:00:00','2016-05-06 18:49:07',0,0,0),(8,3,2,'2016-05-13 16:00:00','2016-05-06 18:49:07',0,0,0),(9,4,2,'2016-05-08 16:00:00','2016-05-06 18:49:07',0,0,0),(10,4,2,'2016-05-12 16:08:00','2016-05-06 18:49:07',0,0,0),(11,32,2,'2016-05-12 08:00:00','2016-05-15 15:10:42',0,0,0),(12,34,2,'2016-05-13 08:00:00','2016-05-14 07:42:50',0,0,0),(13,35,2,'2016-05-28 08:00:00','2016-05-14 07:47:50',0,0,0),(14,51,2,'2016-05-13 08:00:00','2016-06-19 15:43:50',0,0,0),(15,52,2,'2016-06-11 08:00:00','2016-06-07 01:23:06',0,0,0),(16,53,2,'2016-06-11 08:00:00','2016-06-07 01:23:12',0,0,0),(17,54,2,'2016-06-11 08:00:00','2016-06-07 01:23:21',0,0,0),(18,14,2,'2016-06-18 11:04:41','2016-06-19 15:05:57',0,0,0),(19,14,2,'2016-07-20 16:00:00','2016-06-19 15:38:43',1,0,0),(20,58,4,'2016-06-22 08:00:00','2016-06-19 06:39:51',0,0,0),(21,59,4,'2016-06-21 08:00:00','2016-06-19 07:10:31',0,0,0),(22,61,6,'2016-07-28 08:00:00','2016-06-19 07:35:09',0,0,0),(23,61,6,'2016-06-29 08:00:00','2016-06-19 07:35:09',0,0,0),(24,62,5,'2016-06-23 08:00:00','2016-06-19 11:20:44',0,0,0),(25,62,4,'2016-06-14 08:00:00','2016-06-19 11:20:44',0,0,0),(26,64,7,'2016-06-19 08:00:00','2016-06-20 09:32:19',0,0,0),(27,64,7,'2016-07-31 08:00:00','2016-06-20 09:32:19',3,0,0),(28,65,8,'2016-06-30 08:00:00','2016-06-20 09:59:30',0,0,0),(29,65,9,'2016-07-05 08:00:00','2016-06-20 09:59:30',0,0,0),(30,65,7,'2016-06-22 08:00:00','2016-06-20 09:59:30',0,0,0),(31,66,8,'2016-06-21 08:00:00','2016-06-20 10:04:28',0,0,0),(32,66,7,'2016-06-19 08:00:00','2016-06-20 10:04:28',0,0,0),(33,66,8,'2016-06-29 08:00:00','2016-06-20 10:04:28',0,0,0),(34,67,9,'2016-07-07 08:00:00','2016-06-20 10:10:20',0,0,0),(35,67,8,'2016-06-23 08:00:00','2016-06-20 10:10:20',0,0,0),(36,67,7,'2016-06-21 08:00:00','2016-06-20 10:10:20',0,0,0),(37,68,8,'2016-06-21 08:00:00','2016-06-20 10:17:04',0,0,0),(38,68,7,'2016-06-21 08:00:00','2016-06-20 10:17:04',0,0,0),(39,68,8,'2016-07-06 08:00:00','2016-06-20 10:17:04',0,0,0),(40,69,8,'2016-06-08 08:00:00','2016-06-20 12:18:43',0,0,0),(41,69,7,'2016-06-29 08:00:00','2016-06-20 12:18:43',0,0,0),(42,70,9,'2016-06-08 08:00:00','2016-06-20 12:25:11',0,0,0),(43,70,8,'2016-06-22 08:00:00','2016-06-20 12:25:11',0,0,0),(44,71,7,'2016-06-21 08:00:00','2016-06-20 12:29:06',0,0,0),(45,72,8,'2016-06-07 08:00:00','2016-06-20 12:41:00',0,0,0),(46,73,8,'2016-06-29 08:00:00','2016-06-20 12:45:10',0,0,0),(47,73,7,'2016-06-20 08:00:00','2016-06-20 12:45:10',0,0,0),(48,73,9,'2016-06-21 08:00:00','2016-06-20 12:45:10',0,0,0),(49,73,7,'2016-06-23 08:00:00','2016-06-20 12:45:10',0,0,0),(50,73,9,'2016-06-30 08:00:00','2016-06-20 12:45:10',0,0,0),(51,73,8,'2016-06-20 08:00:00','2016-06-20 12:45:10',0,0,0),(52,74,8,'2016-06-23 08:00:00','2016-06-20 12:49:08',0,0,0),(53,75,7,'2016-06-26 08:00:00','2016-06-20 12:52:49',0,0,0),(54,75,9,'2016-06-27 08:00:00','2016-06-20 12:52:49',0,0,0),(55,76,8,'2016-06-22 08:00:00','2016-06-20 13:29:01',0,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_traffic`
--

LOCK TABLES `trip_traffic` WRITE;
/*!40000 ALTER TABLE `trip_traffic` DISABLE KEYS */;
INSERT INTO `trip_traffic` VALUES (1,1,2,'北京到香港',0,'2016-05-06 14:16:14'),(2,2,2,'香港到澳门',0,'2016-05-06 14:16:14'),(3,3,2,'澳门到台湾',0,'2016-05-06 14:16:15'),(4,2,2,'台湾到北京',0,'2016-05-06 14:16:15'),(5,2,3,'北京到加州',0,'2016-05-06 14:17:36'),(6,2,3,'加州到北京',0,'2016-05-06 14:17:36'),(7,2,4,'北京到新加坡',0,'2016-05-06 14:17:36'),(8,2,4,'新加坡到北京',0,'2016-05-06 14:17:37'),(10,6,22,'',1,'2016-05-12 16:12:49'),(12,8,27,'',1,'2016-05-13 11:35:25'),(13,9,30,'',1,'2016-05-13 11:48:51'),(14,10,32,'',1,'2016-05-13 12:29:51'),(15,11,34,'',1,'2016-05-14 07:42:50'),(16,12,35,'',1,'2016-05-14 07:47:50'),(17,13,37,'',1,'2016-05-14 08:25:35'),(18,14,38,'',1,'2016-05-14 08:29:40'),(19,15,40,'',1,'2016-05-14 08:49:29'),(20,16,41,'',1,'2016-05-14 08:53:08'),(21,17,42,'',1,'2016-05-14 09:30:17'),(22,18,43,'',1,'2016-05-14 09:32:32'),(23,19,44,'',1,'2016-05-14 09:34:30'),(24,2,46,'',1,'2016-05-14 09:42:35'),(25,2,47,'',1,'2016-05-14 09:43:43'),(26,2,48,'',1,'2016-05-14 09:44:44'),(27,1,50,'',1,'2016-05-14 09:49:55'),(28,2,50,'',1,'2016-05-14 09:49:55'),(29,2,51,'',1,'2016-05-14 10:42:08'),(30,1,51,'',1,'2016-05-14 10:42:08'),(31,2,52,'',1,'2016-06-07 01:23:06'),(32,1,52,'',1,'2016-06-07 01:23:06'),(33,2,53,'',1,'2016-06-07 01:23:12'),(34,1,53,'',1,'2016-06-07 01:23:12'),(35,1,54,'',1,'2016-06-07 01:23:21'),(36,2,54,'',1,'2016-06-07 01:23:21'),(37,2,58,'',1,'2016-06-19 06:39:51'),(38,1,58,'',1,'2016-06-19 06:39:51'),(39,1,59,'',1,'2016-06-19 07:10:31'),(40,2,59,'',1,'2016-06-19 07:10:31'),(41,1,61,'',1,'2016-06-19 07:35:09'),(42,2,61,'',1,'2016-06-19 07:35:09'),(43,3,62,'',1,'2016-06-19 11:20:44'),(44,1,62,'',1,'2016-06-19 11:20:44'),(45,1,64,'',1,'2016-06-20 09:32:19'),(46,3,65,'',1,'2016-06-20 09:59:30'),(47,2,65,'',1,'2016-06-20 09:59:30'),(48,2,66,'',1,'2016-06-20 10:04:28'),(49,2,67,'',1,'2016-06-20 10:10:20'),(50,2,68,'',1,'2016-06-20 10:17:04'),(51,2,69,'',1,'2016-06-20 12:18:43'),(52,2,69,'',1,'2016-06-20 12:18:43'),(53,2,69,'',1,'2016-06-20 12:18:43'),(54,3,69,'',1,'2016-06-20 12:18:43'),(55,2,69,'',1,'2016-06-20 12:18:43'),(56,2,70,'',1,'2016-06-20 12:25:11'),(57,2,71,'',1,'2016-06-20 12:29:06'),(58,1,71,'',1,'2016-06-20 12:29:06'),(59,2,72,'',1,'2016-06-20 12:41:00'),(60,1,72,'',1,'2016-06-20 12:41:01'),(61,2,73,'',1,'2016-06-20 12:45:11'),(62,1,73,'',1,'2016-06-20 12:45:11'),(63,2,73,'',1,'2016-06-20 12:45:11'),(64,1,73,'',1,'2016-06-20 12:45:11'),(65,1,74,'',1,'2016-06-20 12:49:09'),(66,2,74,'',1,'2016-06-20 12:49:08'),(67,1,75,'',1,'2016-06-20 12:52:49'),(68,2,75,'',1,'2016-06-20 12:52:49'),(69,2,76,'',1,'2016-06-20 13:29:01');
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

-- Dump completed on 2016-06-20 21:34:25
