/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : tourismsys

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 19/08/2019 13:23:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `pwd` varchar(128) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `id_num` int(30) DEFAULT NULL,
  `avatar_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, '帅地', '帅帅', '123456', '12', '123', 123456, 'https://user-gold-cdn.xitu.io/2019/8/16/16c9821984e9ac54?w=500&h=333&f=png&s=242020');
COMMIT;

-- ----------------------------
-- Table structure for alarm
-- ----------------------------
DROP TABLE IF EXISTS `alarm`;
CREATE TABLE `alarm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `content` longtext NOT NULL,
  `create_time` datetime NOT NULL,
  `result` varchar(255) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk5` (`admin_id`) USING BTREE,
  CONSTRAINT `fk5` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `content` longtext NOT NULL,
  `create_time` datetime NOT NULL,
  `result` varchar(255) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk7` (`admin_id`) USING BTREE,
  CONSTRAINT `fk7` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of complaint
-- ----------------------------
BEGIN;
INSERT INTO `complaint` VALUES (21, '20190819095521000021', 'shuaidi', '15627917690', '男', '投诉', '2019-08-19 09:55:22', '我懒的理你', '2019-08-19 09:57:14', 1);
INSERT INTO `complaint` VALUES (22, '20190819095521000022', '张三', '15627917691', '女', '我就是要投诉你，怎么了？', '2019-08-19 13:11:41', NULL, NULL, NULL);
INSERT INTO `complaint` VALUES (23, '20190819095521000023', '李四', '15627917692', '男', '我就是要投诉你，不服啊？', '2019-08-14 13:12:14', NULL, NULL, NULL);
INSERT INTO `complaint` VALUES (24, '20190819095521000025', '王二', '15627917693', '女', '我就是要投诉你，不解释', '2019-08-16 13:12:37', NULL, NULL, NULL);
INSERT INTO `complaint` VALUES (25, '20190819095521000026', '王八', '15627917694', '女', '我就是要投诉你，我开心', '2019-08-17 13:13:22', NULL, NULL, NULL);
INSERT INTO `complaint` VALUES (26, '20190819095521000027', '老王', '15627917695', '女', '5', '2019-08-18 13:13:53', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for cookie
-- ----------------------------
DROP TABLE IF EXISTS `cookie`;
CREATE TABLE `cookie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cookie` varchar(100) NOT NULL,
  `cookie_status` tinyint(4) NOT NULL,
  `login_time` datetime NOT NULL,
  `valid_time` datetime NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk6` (`admin_id`) USING BTREE,
  CONSTRAINT `fk6` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cookie
-- ----------------------------
BEGIN;
INSERT INTO `cookie` VALUES (1, '39317bb5-5e1f-4a5a-a1ce-fc7352e0efd5', 0, '2019-08-19 13:10:30', '2019-08-20 13:10:30', 1);
COMMIT;

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `vacancy` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `distance` double NOT NULL,
  `popularity` int(11) NOT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of hotel
-- ----------------------------
BEGIN;
INSERT INTO `hotel` VALUES (1, '七天酒店', 30, '15627917593123', 26, 30, 'https://f10.baidu.com/it/u=1208544201,1064095414&fm=72');
INSERT INTO `hotel` VALUES (2, '八天酒店', 40, '15627917591', 67, 34, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3841372738,2842049830&fm=26&gp=0.jpg');
INSERT INTO `hotel` VALUES (3, '九天酒店', 50, '15627917598', 43, 12, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=53401268,1769664459&fm=26&gp=0.jpg');
INSERT INTO `hotel` VALUES (4, '成都酒店', 69, '15627917598', 45, 2, 'http://img2.imgtn.bdimg.com/it/u=1717388952,3208829706&fm=26&gp=0.jpg');
INSERT INTO `hotel` VALUES (5, '广州酒店', 23, '15627917593', 4, 299, 'http://img5.imgtn.bdimg.com/it/u=53401268,1769664459&fm=26&gp=0.jpg');
INSERT INTO `hotel` VALUES (6, '锦鲤酒店', 32, '2', 43, 14, 'http://img3.imgtn.bdimg.com/it/u=1202584246,2135194049&fm=26&gp=0.jpg');
COMMIT;

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `vacancy` int(11) NOT NULL,
  `distance` double NOT NULL,
  `fee` double NOT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of park
-- ----------------------------
BEGIN;
INSERT INTO `park` VALUES (1, '成都停车场', 50, 30, 10, 'http://img0.imgtn.bdimg.com/it/u=1627567447,576855731&fm=26&gp=0.jpg');
INSERT INTO `park` VALUES (2, '广州停车场', 40, 40, 3, 'http://img5.imgtn.bdimg.com/it/u=282096365,1593429672&fm=26&gp=0.jpg');
INSERT INTO `park` VALUES (3, '深圳停车场', 60, 10, 15, 'http://img2.imgtn.bdimg.com/it/u=3307902580,4030305752&fm=26&gp=0.jpg');
INSERT INTO `park` VALUES (4, '锦鲤停车场', 12, 45, 4, 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3470563516,2326032056&fm=26&gp=0.jpg');
INSERT INTO `park` VALUES (5, '无名停车场', 26, 90, 7, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4051373130,2245073258&fm=26&gp=0.jpg');
INSERT INTO `park` VALUES (6, '秘密停车场', 20, 21, 4, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=28905229,2794510173&fm=26&gp=0.jpg');
COMMIT;

-- ----------------------------
-- Table structure for per_emer
-- ----------------------------
DROP TABLE IF EXISTS `per_emer`;
CREATE TABLE `per_emer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `job` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of per_emer
-- ----------------------------
BEGIN;
INSERT INTO `per_emer` VALUES (4, '33', '222', '男', '景区人员');
COMMIT;

-- ----------------------------
-- Table structure for per_plan
-- ----------------------------
DROP TABLE IF EXISTS `per_plan`;
CREATE TABLE `per_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `per_id` int(11) NOT NULL,
  `plan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk1` (`per_id`) USING BTREE,
  KEY `fk2` (`plan_id`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`per_id`) REFERENCES `per_emer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`plan_id`) REFERENCES `plan_emer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for plan_emer
-- ----------------------------
DROP TABLE IF EXISTS `plan_emer`;
CREATE TABLE `plan_emer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `plan` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk3` (`admin_id`) USING BTREE,
  CONSTRAINT `fk3` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of ticket
-- ----------------------------
BEGIN;
INSERT INTO `ticket` VALUES (1, '134198487321', '2019-08-10 10:28:49');
INSERT INTO `ticket` VALUES (2, '134198487323', '2019-08-11 10:29:12');
INSERT INTO `ticket` VALUES (3, '134198487322', '2019-08-12 10:29:22');
INSERT INTO `ticket` VALUES (4, '134198487332', '2019-08-14 10:29:32');
INSERT INTO `ticket` VALUES (5, '134198487332', '2019-08-15 10:29:44');
INSERT INTO `ticket` VALUES (6, '1239', '2019-08-19 10:29:58');
COMMIT;

-- ----------------------------
-- Table structure for warning
-- ----------------------------
DROP TABLE IF EXISTS `warning`;
CREATE TABLE `warning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `state` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk4` (`admin_id`) USING BTREE,
  CONSTRAINT `fk4` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of warning
-- ----------------------------
BEGIN;
INSERT INTO `warning` VALUES (1, '极端天气', '大风来了', '我去，这大风，太恐怖了', '1', '2019-08-21 13:18:28', 1);
INSERT INTO `warning` VALUES (2, '极端天气', '小风来了', '我去，这大风，太恐怖了', '1', '2019-08-13 13:19:00', 1);
INSERT INTO `warning` VALUES (3, '极端天气', '冷风来了', '我去，这大风，太恐怖了，然而我并不怕', '1', '2019-08-15 13:19:17', 1);
INSERT INTO `warning` VALUES (4, '极端天气', '狂风来了', '我去，这大风，太恐怖了，然而我并不怕', '1', '2019-08-16 13:19:30', 1);
INSERT INTO `warning` VALUES (5, '极端天气', '没风来了', '我去，这大风，太恐怖了，然而我并不怕，怕啥，区区台风', '1', '2019-08-18 13:19:42', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
