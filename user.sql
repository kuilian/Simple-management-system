/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.40 : Database - glxt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glxt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `glxt`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `gender` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`gender`,`age`,`address`,`qq`,`time`) values (7,'1234','123','kkk','女',19,'广东','123456','2020-06-13 16:03:55'),(8,'1234','123','kkk','女',19,'广东省','123456','2020-06-11 18:26:47'),(12,'1234','123','kkk','女',19,'广东省','123456','2020-06-11 18:26:47'),(13,'1234','123','kkk','女',19,'广东省','123456','2020-06-11 18:26:47'),(14,'1234','123','kkk','女',19,'广东省','123456','2020-06-11 18:26:47'),(16,NULL,NULL,'','男',2,'广东','','2020-06-14 14:25:15'),(17,NULL,NULL,'','男',0,'广东','','2020-06-13 16:04:06'),(18,NULL,NULL,'','男',0,'广东','','2020-06-13 16:04:07'),(19,NULL,NULL,'34324','男',0,'广东','','2020-06-13 17:02:51'),(20,NULL,NULL,'','男',0,'广东','','2020-06-14 13:34:45'),(27,NULL,NULL,'kkkk','男',12,'广东','11','2020-06-18 09:51:53'),(28,NULL,NULL,'kkkk','男',12,'东北','11','2020-06-18 09:51:54'),(29,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:54'),(30,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:55'),(31,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:56'),(32,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:56'),(33,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:57'),(34,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:57'),(35,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:58'),(36,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:51:59'),(37,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:00'),(38,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:01'),(39,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:01'),(40,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:02'),(41,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:03'),(42,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:03'),(43,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:04'),(44,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:05'),(45,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:06'),(46,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:07'),(47,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:07'),(48,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:08'),(49,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:09'),(50,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:09'),(51,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:11'),(52,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:11'),(53,NULL,NULL,'kkkk','男',12,'东北','1','2020-06-18 09:52:12'),(54,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59'),(55,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59'),(56,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59'),(57,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59'),(58,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59'),(59,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:42:00'),(60,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:42:00'),(61,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:42:01'),(62,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:43:01'),(63,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:43:59'),(64,NULL,NULL,'kkkk','男',12,'东北','994743350','2020-06-14 14:41:59');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
