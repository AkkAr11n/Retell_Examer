-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 124.222.228.37    Database: Examination
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.22.04.1

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
-- Table structure for table `paper_question`
--

DROP TABLE IF EXISTS `paper_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paper_question` (
  `paper_id` int NOT NULL,
  `question_id` int NOT NULL,
  `mark` double NOT NULL,
  PRIMARY KEY (`paper_id`,`question_id`),
  KEY `paper_question_ibfk_2` (`question_id`),
  CONSTRAINT `paper_question_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `tb_paper` (`paper_id`),
  CONSTRAINT `paper_question_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `tb_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_question`
--

LOCK TABLES `paper_question` WRITE;
/*!40000 ALTER TABLE `paper_question` DISABLE KEYS */;
INSERT INTO `paper_question` (`paper_id`, `question_id`, `mark`) VALUES (1,1,25),(1,2,25),(1,3,25),(1,4,25),(2,3,25),(2,5,25),(2,6,25),(2,7,25),(3,1,50),(3,9,50),(4,2,10),(4,3,10),(4,4,10),(4,6,10),(4,8,10),(4,10,10),(4,17,10),(4,19,10),(4,23,10),(4,24,10),(5,2,10),(5,3,10),(5,5,10),(5,8,10),(5,9,10),(5,17,10),(5,18,10),(5,21,10),(5,25,10),(5,26,10),(6,2,5),(6,3,10),(6,5,5),(6,6,10),(6,7,5),(6,8,10),(6,9,10),(6,17,10),(6,21,10),(6,24,10),(6,25,5),(6,26,5),(6,27,5),(7,1,5),(7,2,5),(7,4,10),(7,5,5),(7,7,5),(7,8,10),(7,9,10),(7,17,10),(7,18,10),(7,19,10),(7,21,10),(7,25,5),(7,26,5),(8,2,5),(8,3,10),(8,4,10),(8,5,5),(8,6,10),(8,7,5),(8,9,10),(8,17,10),(8,21,10),(8,23,10),(8,25,5),(8,26,5),(8,27,5),(9,2,10),(9,5,10),(9,6,10),(9,8,10),(9,9,10),(9,10,10),(9,18,10),(9,21,10),(9,25,10),(9,27,10),(10,3,10),(10,5,10),(10,8,10),(10,17,10),(10,18,10),(10,19,10),(10,21,10),(10,25,10),(10,26,10),(10,27,10),(11,21,10),(11,23,10),(11,25,10),(11,31,10),(11,48,10),(11,54,10),(11,55,10),(11,56,10),(11,60,10),(11,61,10),(12,1,10),(12,3,10),(12,6,10),(12,7,10),(12,8,10),(12,19,10),(12,21,10),(12,25,10),(12,30,10),(12,59,10),(13,3,10),(13,7,10),(13,9,10),(13,19,10),(13,24,10),(13,32,10),(13,48,10),(13,52,10),(13,53,10),(13,60,10),(14,3,10),(14,8,10),(14,17,10),(14,19,10),(14,21,10),(14,24,10),(14,25,20),(14,30,20);
/*!40000 ALTER TABLE `paper_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper_student`
--

DROP TABLE IF EXISTS `paper_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paper_student` (
  `paper_id` int NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `teacher_id` varchar(10) NOT NULL,
  `grade` tinyint DEFAULT NULL,
  PRIMARY KEY (`paper_id`,`student_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `paper_student_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `tb_paper` (`paper_id`),
  CONSTRAINT `paper_student_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `tb_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_student`
--

LOCK TABLES `paper_student` WRITE;
/*!40000 ALTER TABLE `paper_student` DISABLE KEYS */;
INSERT INTO `paper_student` (`paper_id`, `student_id`, `teacher_id`, `grade`) VALUES (1,'21045301','10001',75),(2,'21045301','10001',75),(3,'21045101','10001',NULL),(3,'21045116','10001',NULL),(3,'21045312','10002',100),(6,'21045301','10001',5),(6,'21045308','10001',55),(6,'21045312','10001',NULL),(6,'21045317','10001',NULL),(6,'21045332','10001',NULL),(7,'21045101','10001',NULL),(7,'21045116','10001',NULL),(7,'21045201','10001',NULL),(7,'21045301','10001',NULL),(7,'21045308','10001',NULL),(7,'21045312','10001',85),(7,'21045317','10001',75),(7,'21045332','10001',NULL),(7,'21045401','10001',NULL),(8,'21045101','10001',NULL),(8,'21045116','10001',NULL),(8,'21045301','10001',NULL),(8,'21045308','10001',NULL),(8,'21045312','10001',NULL),(8,'21045317','10001',NULL),(8,'21045332','10001',NULL),(12,'21045101','10001',NULL),(12,'21045116','10001',NULL),(12,'21045201','10001',NULL),(12,'21045301','10001',NULL),(12,'21045308','10001',NULL),(12,'21045312','10001',80),(12,'21045317','10001',NULL),(12,'21045332','10001',NULL);
/*!40000 ALTER TABLE `paper_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_admin` (
  `manager_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `manager` (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` (`manager_id`, `name`) VALUES ('admin','admin');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paper`
--

DROP TABLE IF EXISTS `tb_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_paper` (
  `paper_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '试卷名',
  `create_time` datetime NOT NULL COMMENT '试卷生成时间',
  PRIMARY KEY (`paper_id`),
  UNIQUE KEY `paper_id` (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paper`
--

LOCK TABLES `tb_paper` WRITE;
/*!40000 ALTER TABLE `tb_paper` DISABLE KEYS */;
INSERT INTO `tb_paper` (`paper_id`, `title`, `create_time`) VALUES (1,'数据库','2023-12-09 17:33:58'),(2,'数据库','2023-12-09 21:44:39'),(3,'数据库','2023-12-09 21:44:45'),(4,'嘿嘿','2023-12-11 19:20:07'),(5,'测试卷','2023-12-11 19:44:48'),(6,'数据库','2023-12-11 21:42:41'),(7,'操作系统','2023-12-12 00:40:31'),(8,'计算机网络','2023-12-12 13:47:00'),(9,'软件工程','2023-12-13 14:17:45'),(10,'计算机组成原理','2023-12-13 14:18:34'),(11,'计算方法','2023-12-14 14:45:55'),(12,'高等数学','2023-12-14 14:47:38'),(13,'测试随机十题','2023-12-21 16:46:59'),(14,'测试自定义试卷','2023-12-21 16:47:55');
/*!40000 ALTER TABLE `tb_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_question` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `category` int NOT NULL,
  `title` text,
  `content` text,
  `answer` text NOT NULL,
  `difficulty` int NOT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `question_id` (`question_id`),
  KEY `tb_question_ibfk_1` (`teacher_id`),
  CONSTRAINT `tb_question_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question`
--

LOCK TABLES `tb_question` WRITE;
/*!40000 ALTER TABLE `tb_question` DISABLE KEYS */;
INSERT INTO `tb_question` (`question_id`, `category`, `title`, `content`, `answer`, `difficulty`, `teacher_id`, `create_time`) VALUES (1,0,'数据库系统是采用了数据库技术的计算机系统，数据库系统由数据库、数据库管理系统、应用系统和（ ）','系统分析员#程序员#数据库管理员#操作员','C',0,'10001','2023-12-09 17:42:12'),(2,0,'数据库（DB），数据库系统（DBS）和数据库管理系统（DBMS）之间的关系是（    ）','DBS包括DB和DBMS#DBMS包括DB和DBS#DB包括DBS和DBMS#DBS就是DB，也就是DBMS','A',0,'10001','2023-12-09 17:42:42'),(3,3,'与人工管理和文件系统相比，数据库数据具有__________、__________、__________和__________三个基本特点。','','永久存储#有组织#可共享#数据独立性高',0,'10001','2023-12-09 17:44:21'),(4,2,'要保证数据库的数据独立性，需要修改的是三层模式',NULL,'F',0,'10001','2023-12-09 17:45:18'),(5,0,'52.规范化理论是关系数据库进行逻辑设计的理论依据，根据这个理论，关系数据库中的关系必须满足：每一个属性都是（ ）。','长度不变的#不可分解的#互相关联的#互不相关的','B',0,'10002','2023-12-09 21:46:15'),(6,2,'关系模式中，满足2NF的模式必定是3NF',NULL,'F',0,'10003','2023-12-09 21:46:56'),(7,0,'消除了部分函数依赖的1NF的关系模式，必定是（ ）。','1NF#2NF#3NF#BCNF','B',0,'10002','2023-12-09 21:47:41'),(8,2,'候选码的属性可以有1个或多个',NULL,'T',0,'10004','2023-12-09 21:47:42'),(9,3,'若关系为1NF，且它的每一非主属性都__________ 候选码，则该关系为2NF。','','完全函数依赖于# # # ',0,'10001','2023-12-09 21:47:43'),(10,3,'如果X→Y和X→Z成立，那么X→YZ也成立，这个推理规则称为___________ 。','','合并规则# # # ',0,'10002','2023-12-09 21:47:44'),(17,1,'黎凤同学的美好品质有？','温柔#美丽#善良#大方','ABCD',0,'10001','2023-12-11 15:42:44'),(18,2,'Java是世界上最好的语言','','T',0,'10001','2023-12-11 15:43:07'),(19,3,'小梁同学的美好品质有____、______、_______、______','','温柔#美丽#善良#大方',0,'10001','2023-12-11 15:45:19'),(21,1,'黎凤同学最喜欢谁？','FF#LL#QQ#ZZ','ABCD',0,'10001','2023-12-11 15:50:07'),(23,2,'你是谁？','','T',0,'10001','2023-12-11 15:53:10'),(24,2,'来自哪里？','','T',0,'10001','2023-12-11 15:53:21'),(25,0,'构成E—R模型的三个基本要素是（）','实体、属性值、关系； #实体、属性、联系；#实体、实体集、联系；#实体、实体集、属性；','B',0,NULL,'2023-12-11 15:55:33'),(26,0,'在下列关于规范化理论的叙述中，不正确的是（）','任何一个关系模式一定有键。#任何一个包含两个属性的关系模式一定满足3NF。#任何一个包含两个属性的关系模式一定满足BCNF。#任何一个包含三个属性的关系模式一定满足2NF。','D',0,NULL,'2023-12-11 15:57:21'),(27,0,'教数据库的老师是谁','付老师#张老师#蔡老师#李老师','A',0,'10001','2023-12-11 20:14:35'),(30,0,'以下（ ）不属于实现数据库系统安全性的主要技术和方法。','存取控制技术#视图技术#审计技术#出入机房登记和加防盗门','D',0,'10001','2023-12-13 15:05:12'),(31,0,'SQL中的视图机制提高了数据库系统的（ ）。','完整性\r\n#并发控制#隔离性#安全性','D',0,'10001','2023-12-13 15:06:01'),(32,0,'SQL语言的GRANT和REVOKE语句主要是用来维护数据库的（ ）。','完整性#可靠性#安全性#一致性','C',1,'10001','2023-12-13 15:06:41'),(33,0,'在数据库的安全性控制中，授权的数据对象的（ ），授权子系统就越灵活。','范围越小#约束越细致#范围越大#约束范围大','A',1,'10001','2023-12-13 15:09:59'),(48,3,'数据库的安全性是指保护数据库以防止不合法的使用所造成的_______、_______或______。','','数据泄露 #更改 \r\n#破坏 # ',1,'10001','2023-12-13 15:13:36'),(49,3,'计算机系统有三类安全性问题，即________ 、_________和 ________。','','技术安全类 \r\n#管理安全类 \r\n#政策法律类# ',1,'10001','2023-12-13 15:14:03'),(50,3,'用户标识和鉴别的方法有很多种，而且在一个系统中往往是多种方法并举，以获得更强的安全性。常用的方法有通过输入________和 ________来鉴别用户。','','用户名#口令# # ',1,'10001','2023-12-13 15:21:50'),(51,3,'________ 和 ________ 一起组成了DBMS的安全子系统。','','存取权限定义#合法权检查机制# # ',1,'10001','2023-12-13 15:22:12'),(52,3,'当前大型的DBMS一般都支持________ ，有些DBMS同时还支持________ 。','','自主存取控制（DAC）#强制存取控制（MAC）# # ',1,NULL,'2023-12-13 15:34:52'),(53,3,'用户权限是由两个要素组成的：________ 和 ________ 。','','数据对象#操作类型# # ',1,NULL,'2023-12-13 15:35:32'),(54,3,'在数据库系统中，定义存取权限称为________ 。SQL语言用________语句向用户授予对数据的操作权限，用________语句收回授予的权限。','','授权#授权#REVOKE# ',1,NULL,'2023-12-13 15:37:03'),(55,3,'对数据库模式的授权由DBA在________ 时实现。','','创建用户# # # ',1,NULL,'2023-12-13 15:37:17'),(56,1,'下面描述正确的是________。\r\n\r\n','每个数据文件中有且只有一个主数据文件\r\n#日志文件可以存在于任意文件组中#主数据文件默认为primary文件组\r\n#文件组是为了更好的实现数据库文件组织','ACD',1,NULL,'2023-12-13 15:58:44'),(57,1,'对视图的描述正确的是________。','是一张虚拟的表#在存储视图时存储的是视图的定义#在存储视图时存储的是视图中的数据#可以像查询表一样来查询视图','ABD',2,NULL,'2023-12-13 15:59:17'),(58,1,'若要删除book表中所有数据，以下语句错误的是（ ）。','truncate table book#drop table book#delete from book#delete * from book','BD',1,NULL,'2023-12-13 15:59:47'),(59,1,'在SQL SERVER中，下面关于子查询的说法你认为正确的是（ ）。\r\n\r\n','应用简单子查询的SQL语句的执行效率比采用SQL变量的实现方案要低#带子查询的查询执行顺序是，先执行父查询，再执行子查询\r\n#表连接一般都可以用子查询替换，但有的子查询不能用表连接替换#如果一个子查询语句一次返回二个字段的值，那么父查询的where子句中应该使用[NOT] EXISTS关键字','CD',0,NULL,'2023-12-13 16:00:29'),(60,2,' 我们使用的sql语言是结构化查询语言。','','T',0,NULL,'2023-12-13 16:01:20'),(61,2,'外键一般是从表的非主属性','','F',1,NULL,'2023-12-13 16:01:43'),(63,0,'1+1=？','2#3#4#5','A',0,'10001','2023-12-21 16:30:32');
/*!40000 ALTER TABLE `tb_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_student` (
  `student_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `academy` varchar(50) NOT NULL COMMENT '学院',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `squad` varchar(50) NOT NULL COMMENT '班级',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_student`
--

LOCK TABLES `tb_student` WRITE;
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
INSERT INTO `tb_student` (`student_id`, `name`, `academy`, `major`, `squad`) VALUES ('21045101','小明','软件学院','计算机科学与技术','210451'),('21045116','小琪','信息工程学院','计算机科学与技术','210451'),('21045201','小李','信息工程学院','计算机科学与技术','210452'),('21045301','小王','信息工程学院','计算机科学与技术','210453'),('21045308','小秋','信息工程学院','计算机科学与技术','210453'),('21045312','小黎','信息工程学院','计算机科学与技术','210453'),('21045317','小梁','信息工程学院','计算机科学与技术','210453'),('21045332','小曾','信息工程学院','计算机科学与技术','210453'),('21045401','小白','信息工程学院','计算机科学与技术','210454');
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_teacher`
--

DROP TABLE IF EXISTS `tb_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_teacher` (
  `teacher_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `academy` varchar(50) NOT NULL COMMENT '学院',
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_teacher`
--

LOCK TABLES `tb_teacher` WRITE;
/*!40000 ALTER TABLE `tb_teacher` DISABLE KEYS */;
INSERT INTO `tb_teacher` (`teacher_id`, `name`, `academy`) VALUES ('10001','黄老师','软件学院'),('10002','王老师','软件学院'),('10003','蔡老师','信息工程学院'),('10004','付老师','信息工程学院'),('10005','张老师','信息工程学院');
/*!40000 ALTER TABLE `tb_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `username` varchar(20) NOT NULL,
  `permission` int NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`username`, `permission`) VALUES ('10001',1),('10002',1),('10003',1),('10004',1),('10005',1),('21045101',0),('21045201',0),('21045301',0),('21045308',0),('21045312',0),('21045317',0),('21045332',0),('admin',2);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_paper`
--

DROP TABLE IF EXISTS `teacher_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_paper` (
  `teacher_id` varchar(20) NOT NULL,
  `paper_id` int NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`teacher_id`,`paper_id`),
  KEY `paper_id` (`paper_id`),
  CONSTRAINT `teacher_paper_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`teacher_id`),
  CONSTRAINT `teacher_paper_ibfk_2` FOREIGN KEY (`paper_id`) REFERENCES `tb_paper` (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_paper`
--

LOCK TABLES `teacher_paper` WRITE;
/*!40000 ALTER TABLE `teacher_paper` DISABLE KEYS */;
INSERT INTO `teacher_paper` (`teacher_id`, `paper_id`, `start_time`, `end_time`) VALUES ('10001',1,'2023-12-10 17:47:03','2023-12-10 19:47:05'),('10001',2,'2023-12-09 21:51:45','2023-12-09 23:51:46'),('10001',3,'2023-12-28 04:33:24','2023-12-31 05:37:27'),('10001',4,'2023-12-11 21:25:17','2023-12-11 22:25:22'),('10001',5,'2023-12-11 21:25:37','2023-12-11 22:25:41'),('10001',6,'2023-12-13 02:00:00','2023-12-14 14:00:00'),('10001',7,'2023-12-21 15:51:40','2023-12-23 15:51:45'),('10001',8,'2023-12-21 17:12:07','2023-12-21 21:12:08'),('10001',12,'2023-12-14 14:50:16','2023-12-16 14:50:23'),('10002',3,'2024-12-09 21:51:57','2024-12-09 23:51:59');
/*!40000 ALTER TABLE `teacher_paper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-22 11:53:44
