/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - appinfodb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`appinfodb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `appinfodb`;

/*Table structure for table `ad_promotion` */

DROP TABLE IF EXISTS `ad_promotion`;

CREATE TABLE `ad_promotion` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `adPicPath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '广告图片存储路径',
  `adPV` bigint(50) DEFAULT NULL COMMENT '广告点击量',
  `carouselPosition` int(30) DEFAULT NULL COMMENT '轮播位（1-n）',
  `startTime` datetime DEFAULT NULL COMMENT '起效时间',
  `endTime` datetime DEFAULT NULL COMMENT '失效时间',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ad_promotion` */

/*Table structure for table `app_category` */

DROP TABLE IF EXISTS `app_category`;

CREATE TABLE `app_category` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类编码',
  `categoryName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `parentId` bigint(30) DEFAULT NULL COMMENT '父级节点id',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `app_category` */

insert  into `app_category`(`id`,`categoryCode`,`categoryName`,`parentId`,`createdBy`,`creationTime`,`modifyBy`,`modifyDate`) values (1,'ALL_APP','全部应用',NULL,1,'2016-08-12 18:11:47',NULL,NULL),(2,'ALL_GAME','全部游戏',NULL,1,'2016-08-12 18:11:47',NULL,NULL),(3,'APP_001','系统工具',1,1,'2016-08-12 18:11:47',NULL,NULL),(4,'APP_002','桌面插件',1,1,'2016-08-12 18:11:47',NULL,NULL),(5,'APP_003','主题美化',1,1,'2016-08-12 18:11:47',NULL,NULL),(6,'APP_004','社交聊天',1,1,'2016-08-12 18:11:47',NULL,NULL),(7,'APP_005','资讯阅读',1,1,'2016-08-12 18:11:47',NULL,NULL),(8,'APP_006','通讯网络',1,1,'2016-08-12 18:11:47',NULL,NULL),(9,'APP_007','影音娱乐',1,1,'2016-08-12 18:11:47',NULL,NULL),(10,'APP_008','摄影图片 ',1,1,'2016-08-12 18:11:47',NULL,NULL),(11,'APP_009','生活服务',1,1,'2016-08-12 18:11:47',NULL,NULL),(12,'APP_010','实用工具 ',1,1,'2016-08-12 18:11:47',NULL,NULL),(13,'APP_011','文档商务',1,1,'2016-08-12 18:11:47',NULL,NULL),(14,'APP_012','金融财经',1,1,'2016-08-12 18:11:47',NULL,NULL),(15,'APP_013','运动健康',1,1,'2016-08-12 18:11:47',NULL,NULL),(16,'APP_014','学习教育 ',1,1,'2016-08-12 18:11:47',NULL,NULL),(17,'APP_015','旅行交通',1,1,'2016-08-12 18:11:47',NULL,NULL),(18,'APP_016','购物',1,1,'2016-08-12 18:11:47',NULL,NULL),(19,'GAME_001','休闲游戏',2,1,'2016-08-12 18:11:47',NULL,NULL),(20,'GAME_002','益智游戏',2,1,'2016-08-12 18:11:47',NULL,NULL),(21,'GAME_003','棋牌游戏',2,1,'2016-08-12 18:11:47',NULL,NULL),(22,'GAME_004','体育赛车',2,1,'2016-08-12 18:11:47',NULL,NULL),(23,'GAME_005','动作射击',2,1,'2016-08-12 18:11:47',NULL,NULL),(24,'GAME_006','掌上网游',2,1,'2016-08-12 18:11:47',NULL,NULL),(25,'GAME_007','策略塔防',2,1,'2016-08-12 18:11:47',NULL,NULL),(26,'GAME_008','角色扮演',2,1,'2016-08-12 18:11:47',NULL,NULL),(27,'GAME_009','模拟经营 ',2,1,'2016-08-12 18:11:47',NULL,NULL),(28,'GAME_010','音乐游戏 ',2,1,'2016-08-12 18:11:47',NULL,NULL),(29,'APP_001_01','输入法',3,1,'2016-08-12 18:11:47',NULL,NULL),(30,'APP_001_02','文件管理',3,1,'2016-08-12 18:11:47',NULL,NULL),(31,'APP_001_03','清理优化',3,1,'2016-08-12 18:11:47',NULL,NULL),(32,'APP_001_04','安全防护',3,1,'2016-08-12 18:11:47',NULL,NULL),(33,'APP_001_05','备份还原',3,1,'2016-08-12 18:11:47',NULL,NULL),(34,'APP_001_06','辅助加强',3,1,'2016-08-12 18:11:47',NULL,NULL),(35,'APP_002_01','桌面',4,1,'2016-08-12 18:11:47',NULL,NULL),(36,'APP_002_02','插件',4,1,'2016-08-12 18:11:47',NULL,NULL),(37,'APP_002_03','锁屏',4,1,'2016-08-12 18:11:47',NULL,NULL);

/*Table structure for table `app_info` */

DROP TABLE IF EXISTS `app_info`;

CREATE TABLE `app_info` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `softwareName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '软件名称',
  `APKName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APK名称',
  `supportROM` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支持ROM',
  `interfaceLanguage` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '界面语言',
  `softwareSize` decimal(20,2) DEFAULT NULL COMMENT '软件大小（单位：M）',
  `updateDate` date DEFAULT NULL COMMENT '更新日期',
  `devId` bigint(30) DEFAULT NULL COMMENT '开发者id（来源于：dev_user表的开发者id）',
  `appInfo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用简介',
  `status` bigint(30) DEFAULT NULL COMMENT '状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `flatformId` bigint(30) DEFAULT NULL COMMENT '所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）',
  `categoryLevel3` bigint(30) DEFAULT NULL COMMENT '所属三级分类（来源于：data_dictionary）',
  `downloads` bigint(30) DEFAULT NULL COMMENT '下载量（单位：次）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `categoryLevel1` bigint(30) DEFAULT NULL COMMENT '所属一级分类（来源于：data_dictionary）',
  `categoryLevel2` bigint(30) DEFAULT NULL COMMENT '所属二级分类（来源于：data_dictionary）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `app_info` */

insert  into `app_info`(`id`,`softwareName`,`APKName`,`supportROM`,`interfaceLanguage`,`softwareSize`,`updateDate`,`devId`,`appInfo`,`status`,`onSaleDate`,`offSaleDate`,`flatformId`,`categoryLevel3`,`downloads`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`categoryLevel1`,`categoryLevel2`) values (1,'跑步记录器:runtastic PRO','com.runtastic.android.pro2','4.1及更高版本','英文软件','32.64',NULL,1,'跑步记录器runtastic PRO是一款基于GPS的运动记录软件，可以自动记录时间，距离，燃烧的卡路里，速度，可以在地图上查看你当前位置和路线等等功能',1,NULL,NULL,1,15,3000,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `app_version` */

DROP TABLE IF EXISTS `app_version`;

CREATE TABLE `app_version` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `versionNo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本介绍',
  `publishStatus` bigint(30) DEFAULT NULL COMMENT '发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）',
  `downloadLink` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `logoPicPath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片存储路径',
  `versionSize` decimal(20,2) DEFAULT NULL COMMENT '版本大小（单位：M）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `app_version` */

/*Table structure for table `backend_user` */

DROP TABLE IF EXISTS `backend_user`;

CREATE TABLE `backend_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userType` bigint(30) DEFAULT NULL COMMENT '用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `userPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `backend_user` */

insert  into `backend_user`(`id`,`userCode`,`userName`,`userType`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`,`userPassword`) values (1,'admin','系统管理员',1,1,NULL,NULL,NULL,'123456');

/*Table structure for table `data_dictionary` */

DROP TABLE IF EXISTS `data_dictionary`;

CREATE TABLE `data_dictionary` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型编码',
  `typeName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型名称',
  `valueId` bigint(30) DEFAULT NULL COMMENT '类型值ID',
  `valueName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型值Name',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `data_dictionary` */

insert  into `data_dictionary`(`id`,`typeCode`,`typeName`,`valueId`,`valueName`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`) values (1,'USER_TYPE','用户类型',1,'超级管理员',1,'2016-08-12 18:11:47',NULL,NULL),(2,'USER_TYPE','用户类型',2,'财务',1,'2016-08-12 18:11:47',NULL,NULL),(3,'USER_TYPE','用户类型',3,'市场',1,'2016-08-12 18:11:47',NULL,NULL),(4,'USER_TYPE','用户类型',4,'运营',1,'2016-08-12 18:11:47',NULL,NULL),(5,'USER_TYPE','用户类型',5,'销售',1,'2016-08-12 18:11:47',NULL,NULL),(6,'APP_STATUS','APP状态',1,'待审核',1,'2016-08-12 18:11:47',NULL,NULL),(7,'APP_STATUS','APP状态',2,'审核通过',1,'2016-08-12 18:11:47',NULL,NULL),(8,'APP_STATUS','APP状态',3,'审核未通过',1,'2016-08-12 18:11:47',NULL,NULL),(9,'APP_STATUS','APP状态',4,'已上架',1,'2016-08-12 18:11:47',NULL,NULL),(10,'APP_STATUS','APP状态',5,'已下架',1,'2016-08-12 18:11:47',NULL,NULL),(11,'APP_FLATFORM','所属平台',1,'手机',1,'2016-08-12 18:11:47',NULL,NULL),(12,'APP_FLATFORM','所属平台',2,'平板',1,'2016-08-12 18:11:47',NULL,NULL),(14,'PUBLISH_STATUS','发布状态',1,'不发布',1,'2016-08-12 18:11:47',NULL,NULL),(15,'PUBLISH_STATUS','发布状态',2,'已发布',1,'2016-08-12 18:11:47',NULL,NULL),(16,'PUBLISH_STATUS','发布状态',3,'预发布',1,'2016-08-12 18:11:47',NULL,NULL),(13,'APP_FLATFORM','所属平台',3,'通用',1,'2016-08-12 18:11:47',NULL,NULL);

/*Table structure for table `dev_user` */

DROP TABLE IF EXISTS `dev_user`;

CREATE TABLE `dev_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `devCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者帐号',
  `devName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者名称',
  `devPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者密码',
  `devEmail` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者电子邮箱',
  `devInfo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者简介',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `dev_user` */

insert  into `dev_user`(`id`,`devCode`,`devName`,`devPassword`,`devEmail`,`devInfo`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`) values (1,'hanlu','韩露','123456',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
