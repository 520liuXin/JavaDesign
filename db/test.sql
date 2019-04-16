/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-17 00:13:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `heat_value` bigint(20) DEFAULT NULL,
  `rent` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `car_describe` varchar(255) DEFAULT NULL,
  `displacement` varchar(255) DEFAULT NULL,
  `drive_way` varchar(255) DEFAULT NULL,
  `engine` varchar(255) DEFAULT NULL,
  `fuel_consumption` varchar(255) DEFAULT NULL,
  `riding_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i30y75iyqeljinunjxneofv4y` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('7', '湘A154611', '奔驰A100', '奔驰', 'SUV', '红色', '500', '2003', '2019-03-24 08:49:23', '2019-03-24 08:49:23', '1', '奔驰566464', '1.4', '四驱', '200批', '15L', '四人');
INSERT INTO `car` VALUES ('8', '湘A1546110', '奔驰A100', '奔驰', 'SUV', '红色', '200', '2008', '2019-03-24 10:27:51', '2019-04-27 10:27:51', '0', '', '1.4', '1.4', null, null, null);
INSERT INTO `car` VALUES ('10', '湘A1546112', '奔驰A100', '奔驰', 'SUV', '红色', '255', '200', '2019-03-24 10:27:51', '2019-03-24 10:27:51', '0', '奔驰', '1.5', null, null, null, null);
INSERT INTO `car` VALUES ('11', '湘A1546113', '奔驰A100', '奔驰', 'SUV', '红色', '56', '209', '2019-04-07 10:27:51', '2019-03-24 10:27:51', '0', null, '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('12', '湘A1546114', '奔驰A100', '奔驰', 'SUV', '红色', '600', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '0', 'uhadjaldh，奔驰', '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('13', '湘A1546115', '奔驰A100', '奔驰', 'SUV', '红色', '59', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '0', null, '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('14', '湘A1546116', '奔驰A100', '奔驰', 'SUV', '红色', '562', '208', '2019-03-24 10:27:52', '2019-04-28 10:27:52', '0', null, '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('15', '湘A1546117', '奔驰A100', '奔驰', 'SUV', '红色', '900', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '1', '奔驰', '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('16', '湘A1546118', '奔驰A100', '奔驰', 'SUV', '红色', '8130', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '1', null, '1.4', null, null, null, null);
INSERT INTO `car` VALUES ('17', '湘A1546119', '奔驰A100', '奔驰', 'SUV', '红色', '894', '200', '2019-04-26 10:27:52', '2019-05-24 10:27:52', '1', '奔驰', '1.4', null, null, null, null);

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `delete_time` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_origin_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `resource_id` varchar(255) DEFAULT NULL,
  `size` bigint(20) NOT NULL,
  `upload_time` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `valid` bit(1) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3h1ea71ovfm9de65vo6vdddmh` (`car_id`),
  CONSTRAINT `FK3h1ea71ovfm9de65vo6vdddmh` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_info
-- ----------------------------
INSERT INTO `file_info` VALUES ('14', null, null, null, null, null, 'FL_er3u1fOxuIEc8311H.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221321', 'image/jpeg', '\0', null, '139701', '2019-04-16 22:13:21', '\\carFile\\img\\20190416\\221321\\FL_er3u1fOxuIEc8311H.jpg', '', null);
INSERT INTO `file_info` VALUES ('15', null, null, null, null, null, 'FL_furBiMmCVTRk8kFBw.jpg', '36b58550-02190554so.jpg', '\\carFile\\img\\20190416\\221341', 'image/jpeg', '\0', null, '192293', '2019-04-16 22:13:41', '\\carFile\\img\\20190416\\221341\\FL_furBiMmCVTRk8kFBw.jpg', '', '7');
INSERT INTO `file_info` VALUES ('16', null, null, null, null, null, 'FL_cDQJuZG4fR2hsVP2e.jpg', '1024x0_1_q87_20120423151702722264.jpg', '\\carFile\\img\\20190416\\221347', 'image/jpeg', '\0', null, '141842', '2019-04-16 22:13:47', '\\carFile\\img\\20190416\\221347\\FL_cDQJuZG4fR2hsVP2e.jpg', '', '7');
INSERT INTO `file_info` VALUES ('17', null, null, null, null, null, 'FL_bJ4uk2f6Pko73tCar.jpg', '1024x0_1_q87_autohomecar__wKgH0FZqc7aAF7BXAAn-hCdIuOM507.jpg', '\\carFile\\img\\20190416\\221356', 'image/jpeg', '\0', null, '196552', '2019-04-16 22:13:56', '\\carFile\\img\\20190416\\221356\\FL_bJ4uk2f6Pko73tCar.jpg', '', '7');
INSERT INTO `file_info` VALUES ('18', null, null, null, null, null, 'FL_dS3jcfAai0T9GK6Td.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', '\\carFile\\img\\20190416\\221402', 'image/jpeg', '\0', null, '151728', '2019-04-16 22:14:02', '\\carFile\\img\\20190416\\221402\\FL_dS3jcfAai0T9GK6Td.jpg', '', '7');
INSERT INTO `file_info` VALUES ('19', null, null, null, null, null, 'FL_fTHG7xIdVir5uTVP1.jpg', '1024x0_1_q87_autohomecar__wKjB0FZF16aAUO5NAAVqUsWDgqg567.jpg', '\\carFile\\img\\20190416\\221408', 'image/jpeg', '\0', null, '115080', '2019-04-16 22:14:08', '\\carFile\\img\\20190416\\221408\\FL_fTHG7xIdVir5uTVP1.jpg', '', '7');
INSERT INTO `file_info` VALUES ('20', null, null, null, null, null, 'FL_emX7bjyfTAP8Yv0GM.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221414', 'image/jpeg', '\0', null, '139701', '2019-04-16 22:14:14', '\\carFile\\img\\20190416\\221414\\FL_emX7bjyfTAP8Yv0GM.jpg', '', '7');
INSERT INTO `file_info` VALUES ('21', null, null, null, null, null, 'FL_cklAB6gbY6EcPD5mr.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', 'D:\\file\\img\\20190417\\001156', 'image/jpeg', '\0', null, '151728', '2019-04-17 00:11:56', 'D:\\file\\img\\20190417\\001156\\FL_cklAB6gbY6EcPD5mr.jpg', '', null);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('3');
INSERT INTO `hibernate_sequence` VALUES ('3');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, '添加用户', '/user/add', null, null, null, null, null);
INSERT INTO `menu` VALUES ('2', null, '修改用户', '/user/update', null, null, null, null, null);
INSERT INTO `menu` VALUES ('3', null, '删除用户', '/user/del', null, null, null, null, null);
INSERT INTO `menu` VALUES ('4', null, '会员列表', '/user/list', null, null, null, null, null);
INSERT INTO `menu` VALUES ('5', null, '文件操作', 'api/file/*', null, null, null, null, null);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `buyer_amount` decimal(19,2) DEFAULT NULL,
  `car_brand` varchar(255) DEFAULT NULL,
  `car_color` varchar(255) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `car_name` varchar(255) DEFAULT NULL,
  `car_rent` bigint(20) DEFAULT NULL,
  `car_type` varchar(255) DEFAULT NULL,
  `lease_day` int(11) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `user_id_card` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `userr_id` bigint(20) DEFAULT NULL,
  `detailed_address` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `send_car` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `car_img_url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', '管理员', null, null, null, null);
INSERT INTO `role` VALUES ('2', '2', '用户', null, null, null, null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `role_menu` VALUES ('2', '1', '2', null, null, null, null);
INSERT INTO `role_menu` VALUES ('3', '1', '3', null, null, null, null);
INSERT INTO `role_menu` VALUES ('4', '1', '4', null, null, null, null);
INSERT INTO `role_menu` VALUES ('5', '2', '4', null, null, null, null);
INSERT INTO `role_menu` VALUES ('6', '1', '5', null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '/home/ableliu/file/20190225/113243/FL_fjKCUy29p4ykoixyg.jpg', '17673817175', '430523199706197758', '1', null, null, null, null, '男', null, null);
INSERT INTO `user` VALUES ('2', 'user', 'user', '/home/ableliu/file/20190225/113647/FL_eUnpB2tShpk7cRuR8.jpeg', '17673817175', '430253196606428865', '2', null, null, null, null, '男', null, null);
INSERT INTO `user` VALUES ('3', '刘慧', '25', '/home/ableliu/file/20190225/114350/FL_cPXXvO2SzHs5y7OlD.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', '小星星', '2', '/home/ableliu/file/20190225/133722/FL_efPQSqDYCPMbTf529.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '小星', '9', '/home/ableliu/file/20190225/133916/FL_frknRug9HL9l76f69.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', '木木', '1', '/home/ableliu/file/20190225/144855/FL_cVxdDz6R4Tc9SDGgY.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '灵敏度', '5', '/home/ableliu/file/20190225/144917/FL_bh3uYGteT6HiUkCVE.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '刘', '1', '/home/ableliu/file/20190304/171305/FL_cxw6tgVfuJQ1AhAlD.png', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', '6', '6', '/home/ableliu/file/20190311/140013/FL_cxaBsaJoWLC1OoYka.png', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('15', 'updata', 'updata11121', null, null, 'updata', '1', null, null, null, '2019-03-19 12:27:46', '女', null, null);
INSERT INTO `user` VALUES ('16', 'updata', 'updata11121', null, null, 'updata', '2', null, '2019-03-19 12:23:30', null, '2019-03-19 12:23:30', '女', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `user_role` VALUES ('2', '2', '2', null, null, null, null);
