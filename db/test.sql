/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-22 13:32:38
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
  `car_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `displacement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `drive_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `engine` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fuel_consumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `riding_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_source` varchar(255) DEFAULT NULL,
  `fuzzy_query` varchar(255) DEFAULT NULL,
  `source_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_i30y75iyqeljinunjxneofv4y` (`car_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('7', '湘A154611', '奔驰c100', 'Benz', 'SSC', '红色', '500', '2003', '2019-03-24 08:49:23', '2019-03-24 08:49:23', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '300P', '15L', '四人', null, '红SSC', null);
INSERT INTO `car` VALUES ('8', '湘A1546110', 'BMW Z5', 'BMW', 'WRC', '蓝色', '200', '2008', '2019-03-24 10:27:51', '2019-04-27 10:27:51', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '300P', '16L', '四人', null, null, null);
INSERT INTO `car` VALUES ('10', '湘A1546112', '别克君威', 'buick', 'SSC', '黑色', '255', '200', '2019-03-24 10:27:51', '2019-03-24 10:27:51', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.5', '后驱', '400P', '16L', '四人', null, 'SSC', null);
INSERT INTO `car` VALUES ('11', '湘A1546113', '保时捷911', 'Porsche', 'WRC', '紫色', '56', '209', '2019-04-07 10:27:51', '2019-03-24 10:27:51', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '400P', '16L', '四人', null, null, null);
INSERT INTO `car` VALUES ('12', '湘A1546114', '兰博基尼大牛', 'Lamborghini', 'SUV', '绿色', '600', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '400P', '16L', '四人', null, '', null);
INSERT INTO `car` VALUES ('13', '湘A1546115', '莲花lotus', 'Lotus', 'SSC', '橙色', '59', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '0', '帕加尼风之子', '1.4', '前驱', '500P', '14L', '四人', null, '', null);
INSERT INTO `car` VALUES ('14', '湘A1546116', '福特focus', 'Ford', 'SUV', '火焰橙', '562', '208', '2019-03-24 10:27:52', '2019-04-28 10:27:52', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '500P', '14L', '四人', null, null, null);
INSERT INTO `car` VALUES ('15', '湘A1546117', '雷诺G3', 'Reynolds', 'WRC', '动感绿', '900', '200', '2019-03-24 10:27:52', '2019-03-24 10:27:52', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '前驱', '300P', '14L', '四人', null, '', null);
INSERT INTO `car` VALUES ('16', '湘A1546118', '雷克萨斯GTS', 'Lexus', 'SSC', '原谅绿', '8130', '200', '2019-03-24 10:27:52', '2019-04-21 07:13:12', '1', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '6L', '四人', null, 'SSC', null);
INSERT INTO `car` VALUES ('17', '湘A1546119', '奔驰A100', 'OFO', 'MPV', '粉红色', '894', '200', '2019-04-26 10:27:52', '2019-05-24 10:27:52', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '前驱', '300P', '6L', '四人', null, null, null);
INSERT INTO `car` VALUES ('18', '湘A1231311', '奔驰x7', 'Benz', 'WRC', '骚粉色', '100', '200', '2019-04-18 19:53:42', '2019-04-18 19:53:46', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '12L', '四人', null, null, null);
INSERT INTO `car` VALUES ('19', '湘B1212312', '奔驰A100', 'Benz', 'SUV', '果皮绿', '100', '200', '2019-04-18 11:56:35', '2019-04-18 11:56:35', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '300P', '7L', '四人', null, null, null);
INSERT INTO `car` VALUES ('20', '湘J21B111', '奔驰A100', 'Benz', 'GT', '奇异红', '100', '200', '2019-04-18 11:56:36', '2019-04-21 04:30:33', '1', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '7L', '四人', null, null, null);
INSERT INTO `car` VALUES ('21', '湘J21B196', '尼桑', '尼桑GTR36', 'WCC', '中国红', '206', '200', null, '2019-04-21 04:24:30', '0', '全新梅赛德斯奔驰', '1.4', '后驱', '800P', '7L', null, null, null, null);
INSERT INTO `car` VALUES ('22', '湘J21B1113', '兰博小牛', 'Lamborghini', 'SSC', '中国红', '100', '200', '2019-04-18 12:01:49', '2019-04-21 03:52:07', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '450P', '8L', '四人', null, '中国红', null);
INSERT INTO `car` VALUES ('23', '湘J21B1114', '莲花lotus2', 'Lotus', 'VV', '动感绿', '100', '200', '2019-04-18 12:01:49', '2019-04-18 12:01:49', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '450P', '8L', '四人', null, null, null);
INSERT INTO `car` VALUES ('24', '湘J21B1115', '雷诺QQ', 'Reynolds', 'SSC', '中国红', '100', '200', '2019-04-18 12:01:49', '2019-04-21 06:56:35', '1', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '450P', '8L', '四人', null, null, null);
INSERT INTO `car` VALUES ('25', '湘J21B1116', '奥克斯空调', 'AUX', 'WCC', '动感绿', '1005', '200', '2019-04-18 12:01:49', '2019-04-21 06:48:40', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '450P', '8L', '四人', null, '中国红', null);
INSERT INTO `car` VALUES ('26', '湘J21B1117', '尼桑GTR36', 'Nissan', 'SSC', '骚粉色', '100', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人', null, 'SSC', null);
INSERT INTO `car` VALUES ('27', '湘J21B1118', '尼桑GTR35', 'Nissan', 'WCC', '中国红', '1004', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '700P', '20L', '四人', null, null, null);
INSERT INTO `car` VALUES ('28', '湘J21B1119', '兰博基尼蝙蝠', 'Lamborghini', 'MPV', '动感绿', '100', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人', null, null, null);
INSERT INTO `car` VALUES ('29', '湘J21B1110', '桑塔纳', 'Nissan', 'WCC', '中国红', '100', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '700P', '20L', '四人', null, '中国红', null);
INSERT INTO `car` VALUES ('30', '湘J21B111A', '尼桑GTR1997', 'Nissan', 'VV', '中国红', '10055', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '1', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人', null, '中国红', null);
INSERT INTO `car` VALUES ('31', '湘J21B111B', '尼桑', 'Lamborghini', 'SSC', '动感绿', '100', '200', '2019-04-18 12:31:15', '2019-04-21 06:32:58', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人', null, null, null);
INSERT INTO `car` VALUES ('32', '湘J21B111C', '雷诺GTR08', 'Reynolds', 'WRC', '中国红', '142', '200', '2019-04-18 12:31:15', '2019-04-20 12:25:38', '0', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '650P', '20L', '四人', null, 'WRC雷诺GTR08Reynolds中国红null', null);
INSERT INTO `car` VALUES ('33', '湘J21B111D', '毒药2017', 'Lamborghini', 'SSC', '骚粉色', '100', '200', '2019-04-18 12:31:15', '2019-04-21 10:10:41', '1', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人', null, null, null);
INSERT INTO `car` VALUES ('34', '湘J21B111E', '雷诺N27', 'Reynolds', 'GT', '中国红', '100', '200', null, '2019-04-20 12:20:16', '0', null, null, null, null, null, null, null, 'GT雷诺N27Reynolds中国红null', null);
INSERT INTO `car` VALUES ('35', '湘J21B111F', '兰博拖拉机', 'Lamborghini', 'WRC', '动感绿', '100', '200', '2019-04-18 12:31:15', '2019-04-18 12:31:15', '0', '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人', null, '', null);
INSERT INTO `car` VALUES ('36', '湘J21B111G', '雷诺R55', 'Reynolds', 'WCC', '中国红', '1005', '200', null, '2019-04-20 12:10:53', '0', null, null, null, null, null, null, null, 'WCC雷诺R55Reynolds中国红null', null);
INSERT INTO `car` VALUES ('37', '湘J21B111H', '兰博基尼毒药', 'Lamborghini', 'MPV', '骚粉色', '100', '200', null, '2019-04-20 12:07:15', '0', null, null, null, null, null, null, null, 'MPV兰博基尼毒药Lamborghini骚粉色null', null);
INSERT INTO `car` VALUES ('73', null, null, null, null, null, null, null, null, '2019-04-21 04:29:04', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('74', null, null, null, null, null, null, null, null, '2019-04-21 04:33:13', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('75', null, null, null, null, null, null, null, null, '2019-04-21 04:38:00', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('76', null, null, null, null, null, null, null, null, '2019-04-21 04:39:33', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('77', null, null, null, null, null, null, null, null, '2019-04-21 06:31:00', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('78', null, null, null, null, null, null, null, null, '2019-04-21 06:47:19', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('79', null, null, null, null, null, null, null, null, '2019-04-21 17:54:51', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('80', null, null, null, null, null, null, null, null, '2019-04-21 07:01:38', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('81', null, null, null, null, null, null, null, null, '2019-04-21 07:12:03', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('82', null, null, null, null, null, null, null, null, '2019-04-21 10:06:53', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('83', null, null, null, null, null, null, null, null, '2019-04-21 10:09:03', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('84', null, null, null, null, null, null, null, null, '2019-04-21 14:51:39', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('85', null, null, null, null, null, '102', null, '2019-04-22 01:36:11', '2019-04-22 01:36:11', '0', null, null, null, null, null, null, '店家直营', 'nullnullnullnull店家直营', '1');
INSERT INTO `car` VALUES ('86', null, '你好好', 'BW', null, '红色', null, '200', null, '2019-04-22 05:00:31', '0', '傻逼', '1.5', null, '400P', null, null, null, null, null);
INSERT INTO `car` VALUES ('87', null, '宝马', 'BMW', null, '红色', '104', '2000', '2019-04-22 05:12:54', '2019-04-22 05:12:54', '0', null, null, null, null, null, null, '店家直营', 'null宝马BMW红色店家直营', '1');
INSERT INTO `car` VALUES ('88', null, '福特999', 'Ford', null, '红色', '108', '1000', '2019-04-22 05:27:28', '2019-04-22 05:27:28', '0', null, null, null, null, null, null, '店家直营', 'null福特999Ford红色店家直营', '1');
INSERT INTO `car` VALUES ('89', null, null, null, null, null, null, null, null, '2019-04-22 05:30:06', '1', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file_origin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `resource_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `upload_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `valid` bit(1) DEFAULT NULL,
  `delete_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK3h1ea71ovfm9de65vo6vdddmh` (`car_id`) USING BTREE,
  CONSTRAINT `FK3h1ea71ovfm9de65vo6vdddmh` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of file_info
-- ----------------------------
INSERT INTO `file_info` VALUES ('14', '../img/a-1.jpg', '7', 'FL_er3u1fOxuIEc8311H.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221321', 'image/jpeg', null, '139701', '2019-04-16 22:13:21', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('15', '../img/a-2.jpg', '8', 'FL_furBiMmCVTRk8kFBw.jpg', '36b58550-02190554so.jpg', '\\carFile\\img\\20190416\\221341', 'image/jpeg', null, '192293', '2019-04-16 22:13:41', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('16', '../img/a-3.jpg', '10', 'FL_cDQJuZG4fR2hsVP2e.jpg', '1024x0_1_q87_20120423151702722264.jpg', '\\carFile\\img\\20190416\\221347', 'image/jpeg', null, '141842', '2019-04-16 22:13:47', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('17', '../img/g-1.jpg', '11', 'FL_bJ4uk2f6Pko73tCar.jpg', '1024x0_1_q87_autohomecar__wKgH0FZqc7aAF7BXAAn-hCdIuOM507.jpg', '\\carFile\\img\\20190416\\221356', 'image/jpeg', null, '196552', '2019-04-16 22:13:56', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('18', '../img/g-2.jpg', '12', 'FL_dS3jcfAai0T9GK6Td.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', '\\carFile\\img\\20190416\\221402', 'image/jpeg', null, '151728', '2019-04-16 22:14:02', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('19', '../img/g-3.jpg', '13', 'FL_fTHG7xIdVir5uTVP1.jpg', '1024x0_1_q87_autohomecar__wKjB0FZF16aAUO5NAAVqUsWDgqg567.jpg', '\\carFile\\img\\20190416\\221408', 'image/jpeg', null, '115080', '2019-04-16 22:14:08', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('20', '../img/g-4.jpg', '14', 'FL_emX7bjyfTAP8Yv0GM.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221414', 'image/jpeg', null, '139701', '2019-04-16 22:14:14', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('21', '../img/g-5.jpg', '15', 'FL_cklAB6gbY6EcPD5mr.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', 'D:\\file\\img\\20190417\\001156', 'image/jpeg', null, '151728', '2019-04-17 00:11:56', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('22', '../img/g-6.jpg', '16', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('23', '../img/g-7.jpg', '17', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('24', '../img/g-8.jpg', '18', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('25', '../img/g-9.jpg', '19', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('26', '../img/g-10.jpg', '20', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('27', '../img/gallery1.jpg', '21', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('28', '../img/gallery2.jpg', '22', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('29', '../img/gallery3.jpg', '23', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('30', '../img/gallery4.jpg', '24', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('31', '../img/gallery5.jpg', '25', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('32', '../img/gallery6.jpg', '26', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('33', '../img/img1.jpg', '27', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('34', '../img/img2.jpg', '28', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('35', '../img/img4.jpg', '29', null, null, null, 'image/jpeg', null, '151728', null, null, null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('36', '../img/pic1.jpg', '30', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('37', '../img/pic2.jpg', '31', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('38', '../img/pic3.jpg', '32', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('39', '../img/pic4.jpg', '33', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('40', '../img/pic5.jpg', '34', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('41', '../img/pic6.jpg', '35', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('42', '../img/pic7.jpg', '36', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('43', '../img/pic9.jpg', '37', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('44', '../img/pic15.jpg', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('45', '../img/pic16.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('46', '../img/pic17.jpg', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('47', '../img/pic18.jpg', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('48', '../img/pic19.jpg', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('49', '../img/pic20.jpg', '7', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('50', '../img/pic21.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('51', '../img/pic22.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('52', '../img/pic23.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('53', '../img/pic24.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('54', '../img/pic25.jpg', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `file_info` VALUES ('55', 'E:\\springboot-upload\\file\\20190422\\050031\\FL_f8jgWMOP568bwX8Hx.jpg', '86', 'FL_f8jgWMOP568bwX8Hx.jpg', 'bg.jpg', 'E:\\springboot-upload\\file\\20190422\\050031', 'image/jpeg', null, '1153168', '2019-04-22 05:00:31', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('56', 'E:\\springboot-upload\\file\\20190422\\050031\\FL_g6pmrYDSv4N1RanpU.png', '86', 'FL_g6pmrYDSv4N1RanpU.png', 'password.png', 'E:\\springboot-upload\\file\\20190422\\050031', 'image/png', null, '546', '2019-04-22 05:00:31', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('57', 'E:\\springboot-upload\\file\\20190422\\050031\\FL_fIr8GUQHt7ugk9wHC.png', '86', 'FL_fIr8GUQHt7ugk9wHC.png', 'tick.png', 'E:\\springboot-upload\\file\\20190422\\050031', 'image/png', null, '2912', '2019-04-22 05:00:31', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('58', 'E:\\springboot-upload\\file\\20190422\\050031\\FL_d1vqG7bl7z03wsUYL.png', '86', 'FL_d1vqG7bl7z03wsUYL.png', 'user.png', 'E:\\springboot-upload\\file\\20190422\\050031', 'image/png', null, '622', '2019-04-22 05:00:31', '', null, '\0', null, null, null, null);
INSERT INTO `file_info` VALUES ('59', 'E:\\springboot-upload\\file\\20190422\\051256\\FL_fb4blFPzGgN5AeEZn.jpg', '87', 'FL_fb4blFPzGgN5AeEZn.jpg', 'bg.jpg', 'E:\\springboot-upload\\file\\20190422\\051256', 'image/jpeg', null, '1153168', '2019-04-22 05:12:56', '', null, '\0', null, null, '2019-04-22 05:12:57', null);
INSERT INTO `file_info` VALUES ('60', 'E:\\springboot-upload\\file\\20190422\\051256\\FL_bzkwCFuzFwCcUhOuL.png', '87', 'FL_bzkwCFuzFwCcUhOuL.png', 'password.png', 'E:\\springboot-upload\\file\\20190422\\051256', 'image/png', null, '546', '2019-04-22 05:12:56', '', null, '\0', null, null, '2019-04-22 05:12:57', null);
INSERT INTO `file_info` VALUES ('61', 'E:\\springboot-upload\\file\\20190422\\051256\\FL_fgWlEMIHXRa4uqnnw.png', '87', 'FL_fgWlEMIHXRa4uqnnw.png', 'tick.png', 'E:\\springboot-upload\\file\\20190422\\051256', 'image/png', null, '2912', '2019-04-22 05:12:56', '', null, '\0', null, null, '2019-04-22 05:12:57', null);
INSERT INTO `file_info` VALUES ('62', 'E:\\springboot-upload\\file\\20190422\\051256\\FL_bmW6AF7zNBH2w8IAF.png', '87', 'FL_bmW6AF7zNBH2w8IAF.png', 'user.png', 'E:\\springboot-upload\\file\\20190422\\051256', 'image/png', null, '622', '2019-04-22 05:12:56', '', null, '\0', null, null, '2019-04-22 05:12:57', null);
INSERT INTO `file_info` VALUES ('63', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_cBh1mvRF9kQc7Lwie.jpg', '88', 'FL_cBh1mvRF9kQc7Lwie.jpg', 'ti1g.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '19725', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);
INSERT INTO `file_info` VALUES ('64', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_djHqlotttlMa2THFL.jpg', '88', 'FL_djHqlotttlMa2THFL.jpg', 'ti5mg.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '69820', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);
INSERT INTO `file_info` VALUES ('65', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_bi8u0ZNWFiZcB3p90.jpg', '88', 'FL_bi8u0ZNWFiZcB3p90.jpg', 'ti43mg.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '33089', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);
INSERT INTO `file_info` VALUES ('66', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_clHUCE7ghx3ftH3D4.jpg', '88', 'FL_clHUCE7ghx3ftH3D4.jpg', 'tim24g.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '37473', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);
INSERT INTO `file_info` VALUES ('67', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_bZgadbuagyt9ZYpJd.jpg', '88', 'FL_bZgadbuagyt9ZYpJd.jpg', 'timg.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '112953', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);
INSERT INTO `file_info` VALUES ('68', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_fZkDjbOiOvo9xO3k5.jpg', '88', 'FL_fZkDjbOiOvo9xO3k5.jpg', 'u=2209310624,578423942&fm=26&gp=0.jpg', 'E:\\springboot-upload\\file\\20190422\\052728', 'image/jpeg', null, '13495', '2019-04-22 05:27:28', '', null, '\0', null, null, '2019-04-22 05:27:29', null);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
  `car_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `car_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_rent` bigint(20) DEFAULT NULL,
  `car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lease_day` int(11) DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `user_id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `detailed_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `send_car` int(11) DEFAULT NULL,
  `car_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_describe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1', '2019-04-20 04:25:00', null, '1000.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '5', '120190420122500142', '0', '430523199706197758', '17673817175', '17673817175', '1', 'liuuu', '2019-04-27 16:00:00', '2019-05-01 16:00:00', '1', '../img/pic9.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('2', '2019-04-20 04:25:56', null, '1000.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '5', '120190420122556406', '0', '430523199706197758', '17673817175', '17673817175', '1', 'liuuu', '2019-04-27 16:00:00', '2019-05-01 16:00:00', '1', '../img/pic9.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('3', '2019-04-20 04:34:33', null, '1600.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '8', '120190420123433113', '0', '430523199706197758', '17673817175', '17673817175', '1', 'liuuu', '2019-05-11 16:00:00', '2019-05-18 16:00:00', '1', '../img/pic9.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('4', '2019-04-20 04:40:34', null, '1600.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '8', '120190420124034008', '0', '430523199706197758', '17673817175', '17673817175', '1', '1336565', '2019-05-11 16:00:00', '2019-05-18 16:00:00', '1', '../img/pic9.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('5', '2019-04-20 10:19:21', null, '1400.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '8', '120190420181920580', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-19 16:00:00', '2019-04-26 16:00:00', '1', '../img/pic9.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('6', '2019-04-20 10:22:49', null, '3400.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '18', '120190420182249328', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-26 16:00:00', '1', '../img/pic7.jpg', null);
INSERT INTO `order_master` VALUES ('7', '2019-04-20 10:24:32', null, '3400.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '18', '120190420182431717', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-26 16:00:00', '1', '../img/pic7.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('8', '2019-04-20 10:36:12', null, '1600.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '9', '120190420183612077', '0', '430523199706197758', '17673817175', '17673817175', '1', '15454656', '2019-04-19 16:00:00', '2019-04-27 16:00:00', '1', '../img/pic7.jpg', null);
INSERT INTO `order_master` VALUES ('9', '2019-04-20 10:39:46', null, '1600.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '9', '120190420183945990', '0', '430523199706197758', '17673817175', '17673817175', '1', '15454656', '2019-04-19 16:00:00', '2019-04-27 16:00:00', '1', '../img/pic7.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('10', '2019-04-20 10:45:45', null, '1800.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '10', '120190420184545497', '0', '430523199706197758', '17673817175', '17673817175', '1', '打到我大', '2019-04-23 16:00:00', '2019-05-02 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('11', '2019-04-20 10:52:06', null, '1400.00', 'Nissan', '中国红', '29', '桑塔纳', '200', 'WCC', '8', '120190420185206213', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-27 16:00:00', '1', '../img/img4.jpg', null);
INSERT INTO `order_master` VALUES ('12', '2019-04-20 10:55:37', null, '1000.00', 'Lamborghini', '中国红', '22', '兰博小牛', '200', 'SSC', '6', '120190420185537305', '0', '430523199706197758', '17673817175', '17673817175', '1', '42463873', '2019-04-20 16:00:00', '2019-04-25 16:00:00', '1', '../img/gallery2.jpg', null);
INSERT INTO `order_master` VALUES ('13', '2019-04-20 11:00:17', null, '800.00', 'Lamborghini', '中国红', '22', '兰博小牛', '200', 'SSC', '-3', '120190420190017009', '0', '430523199706197758', '17673817175', '17673817175', '1', '57837', '2019-04-27 16:00:00', '2019-04-23 16:00:00', '1', '../img/gallery2.jpg', null);
INSERT INTO `order_master` VALUES ('14', '2019-04-20 11:02:56', null, '600.00', 'Nissan', '中国红', '29', '桑塔纳', '200', 'WCC', '4', '120190420190256169', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-23 16:00:00', '1', '../img/img4.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('15', '2019-04-20 11:10:41', null, '3000.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '16', '120190420191041041', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-10 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('16', '2019-04-20 11:11:04', null, '3000.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '16', '120190420191103589', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-10 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('17', '2019-04-20 11:14:28', null, '0.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '1', '120190420191427506', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-20 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('18', '2019-04-20 11:15:13', null, '1400.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '8', '120190420191513063', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-27 16:00:00', '1', '../img/pic5.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('19', '2019-04-20 11:15:23', null, '1400.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '8', '120190420191523334', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-27 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('20', '2019-04-20 11:16:31', null, '1400.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '8', '120190420191631223', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-27 16:00:00', '1', '../img/pic5.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('21', '2019-04-20 11:17:53', null, '3200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '17', '120190420191752908', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('22', '2019-04-20 11:18:29', null, '3200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '17', '120190420191828793', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('23', '2019-04-20 11:21:08', null, '3200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '17', '120190420192107802', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('24', '2019-04-20 11:23:28', null, '3200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '17', '120190420192327531', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('25', '2019-04-20 11:24:37', null, '3200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '17', '120190420192436864', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-09 16:00:00', '2019-04-25 16:00:00', '1', '../img/pic5.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('26', '2019-04-20 11:28:23', null, '4400.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '23', '120190420192822663', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-11 16:00:00', '2019-05-03 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('27', '2019-04-20 11:35:49', null, '200.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '2', '120190420193548655', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('28', '2019-04-20 11:39:57', null, '1600.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '9', '120190420193956720', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-11 16:00:00', '2019-04-19 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('29', '2019-04-20 11:41:53', null, '1600.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '9', '120190420194153175', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-11 16:00:00', '2019-04-19 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('30', '2019-04-20 11:45:33', null, '1400.00', 'Lamborghini', '动感绿', '35', '兰博拖拉机', '200', 'WRC', '8', '120190420194533444', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-12 16:00:00', '2019-04-19 16:00:00', '1', '../img/pic6.jpg', null);
INSERT INTO `order_master` VALUES ('31', '2019-04-20 11:46:20', null, '2912.00', 'Ford', '火焰橙', '14', '福特focus', '208', 'SUV', '15', '120190420194619697', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-11 16:00:00', '2019-04-25 16:00:00', '1', '../img/g-4.jpg', null);
INSERT INTO `order_master` VALUES ('32', '2019-04-20 12:06:17', '2019-04-20 12:07:15', '200.00', 'Lamborghini', '骚粉色', '37', '兰博基尼毒药', '200', 'MPV', '2', '120190420200617122', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-19 16:00:00', '2019-04-20 16:00:00', '1', '../img/pic9.jpg', null);
INSERT INTO `order_master` VALUES ('33', '2019-04-20 12:10:09', '2019-04-20 12:10:53', '200.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '2', '120190420201009178', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/pic7.jpg', null);
INSERT INTO `order_master` VALUES ('34', '2019-04-20 12:19:34', '2019-04-20 12:20:16', '200.00', 'Reynolds', '中国红', '34', '雷诺N27', '200', 'GT', '2', '120190420201933630', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-19 16:00:00', '2019-04-20 16:00:00', '1', '../img/pic5.jpg', null);
INSERT INTO `order_master` VALUES ('35', '2019-04-20 12:24:54', '2019-04-20 12:25:38', '200.00', 'Reynolds', '中国红', '32', '雷诺GTR08', '200', 'WRC', '2', '120190420202454275', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-19 16:00:00', '2019-04-20 16:00:00', '1', '../img/pic3.jpg', null);
INSERT INTO `order_master` VALUES ('36', '2019-04-21 03:41:53', null, '200.00', 'Lamborghini', '动感绿', '28', '兰博基尼蝙蝠', '200', 'MPV', '2', '120190421114153155', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/img2.jpg', null);
INSERT INTO `order_master` VALUES ('37', '2019-04-21 03:48:08', null, '800.00', 'Lamborghini', '中国红', '22', '兰博小牛', '200', 'SSC', '5', '120190421114807804', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-27 16:00:00', '2019-05-01 16:00:00', '1', '../img/gallery2.jpg', null);
INSERT INTO `order_master` VALUES ('38', '2019-04-21 03:50:50', '2019-04-21 03:52:07', '200.00', 'Lamborghini', '中国红', '22', '兰博小牛', '200', 'SSC', '2', '120190421115049732', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/gallery2.jpg', null);
INSERT INTO `order_master` VALUES ('39', '2019-04-21 04:08:59', '2019-04-21 04:10:06', '200.00', 'Reynolds', '中国红', '24', '雷诺QQ', '200', 'SSC', '2', '120190421120859014', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-26 16:00:00', '2019-04-27 16:00:00', '1', '../img/gallery4.jpg', null);
INSERT INTO `order_master` VALUES ('40', '2019-04-21 04:29:03', '2019-04-21 04:29:51', '200.00', 'Benz', '奇异红', '20', '奔驰A100', '200', 'GT', '2', '120190421122903493', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/g-10.jpg', null);
INSERT INTO `order_master` VALUES ('41', '2019-04-21 04:33:13', '2019-04-21 04:34:07', '200.00', 'Nissan', '中国红', '30', '尼桑GTR1997', '200', 'VV', '2', '120190421123312983', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/pic1.jpg', null);
INSERT INTO `order_master` VALUES ('42', '2019-04-21 04:38:00', '2019-04-21 04:38:45', '600.00', 'Nissan', '中国红', '29', '桑塔纳', '200', 'WCC', '4', '120190421123800193', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-21 16:00:00', '2019-04-24 16:00:00', '1', '../img/img4.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('43', '2019-04-21 04:39:33', '2019-04-21 04:40:12', '200.00', 'Nissan', '中国红', '27', '尼桑GTR35', '200', 'WCC', '2', '120190421123932705', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/img1.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('44', '2019-04-21 06:31:00', '2019-04-21 06:32:58', '200.00', 'Lamborghini', '动感绿', '31', '尼桑', '200', 'SSC', '2', '120190421143100047', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/pic2.jpg', '为路而生，道路就在脚下———奔驰新款m级越野车');
INSERT INTO `order_master` VALUES ('45', '2019-04-21 06:47:19', '2019-04-21 06:48:40', '200.00', 'AUX', '动感绿', '25', '奥克斯空调', '200', 'WCC', '2', '120190421144718874', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-20 16:00:00', '2019-04-21 16:00:00', '1', '../img/gallery5.jpg', '为路而生，道路就在脚下———奔驰新款m级越野车');
INSERT INTO `order_master` VALUES ('46', '2019-04-21 06:54:51', '2019-04-21 06:56:35', '200.00', 'Reynolds', '中国红', '24', '雷诺QQ', '200', 'SSC', '2', '120190421065450670', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-21 00:00:00', '2019-04-22 00:00:00', '1', '../img/gallery4.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('47', '2019-04-21 07:01:38', null, '200.00', 'Lamborghini', '绿色', '12', '兰博基尼大牛', '200', 'SUV', '2', '120190421070138219', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-21 00:00:00', '2019-04-22 00:00:00', '1', '../img/g-2.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('48', '2019-04-21 07:12:03', '2019-04-21 07:13:12', '800.00', 'Lexus', '原谅绿', '16', '雷克萨斯GTS', '200', 'SSC', '5', '120190421071203092', '1', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-22 00:00:00', '2019-04-26 00:00:00', '1', '../img/g-6.jpg', ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车');
INSERT INTO `order_master` VALUES ('49', '2019-04-21 10:06:53', null, '1000.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '6', '1720190421100652904', '0', null, '17373817175', null, '17', null, '2019-04-22 00:00:00', '2019-04-27 00:00:00', '0', '../img/pic7.jpg', null);
INSERT INTO `order_master` VALUES ('50', '2019-04-21 10:09:03', '2019-04-21 10:10:41', '200.00', 'Lamborghini', '骚粉色', '33', '毒药2017', '200', 'SSC', '2', '1720190421100903338', '1', null, '17373817175', null, '17', null, '2019-04-21 00:00:00', '2019-04-22 00:00:00', '0', '../img/pic4.jpg', '为路而生，道路就在脚下———奔驰新款m级越野车');
INSERT INTO `order_master` VALUES ('51', '2019-04-21 14:51:39', null, '400.00', 'Reynolds', '中国红', '36', '雷诺R55', '200', 'WCC', '3', '120190421145139222', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-21 00:00:00', '2019-04-23 00:00:00', '1', '../img/pic7.jpg', null);
INSERT INTO `order_master` VALUES ('52', '2019-04-22 05:30:06', null, '5000.00', 'Ford', '红色', '88', '福特999', '1000', null, '6', '120190422053005913', '0', '430523199706197758', '17673817175', '17673817175', '1', '', '2019-04-22 00:00:00', '2019-04-27 00:00:00', '1', 'E:\\springboot-upload\\file\\20190422\\052728\\FL_cBh1mvRF9kQc7Lwie.jpg', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '17673817175', 'admin', '/home/ableliu/file/20190225/113243/FL_fjKCUy29p4ykoixyg.jpg', '17673817175', '430523199706197758', '1', null, null, null, null, '男', null, null);
INSERT INTO `user` VALUES ('2', '11111111111', 'user', '/home/ableliu/file/20190225/113647/FL_eUnpB2tShpk7cRuR8.jpeg', '17673817175', '430253196606428865', '2', null, null, null, null, '男', null, null);
INSERT INTO `user` VALUES ('3', '刘慧', '25', '/home/ableliu/file/20190225/114350/FL_cPXXvO2SzHs5y7OlD.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', '小星星', '2', '/home/ableliu/file/20190225/133722/FL_efPQSqDYCPMbTf529.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '小星', '9', '/home/ableliu/file/20190225/133916/FL_frknRug9HL9l76f69.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', '木木', '1', '/home/ableliu/file/20190225/144855/FL_cVxdDz6R4Tc9SDGgY.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '灵敏度', '5', '/home/ableliu/file/20190225/144917/FL_bh3uYGteT6HiUkCVE.jpg', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '刘', '1', '/home/ableliu/file/20190304/171305/FL_cxw6tgVfuJQ1AhAlD.png', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', '6', '6', '/home/ableliu/file/20190311/140013/FL_cxaBsaJoWLC1OoYka.png', '17673817175', null, '2', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('15', 'updata', 'updata11121', null, null, 'updata', '1', null, null, null, '2019-03-19 12:27:46', '女', null, null);
INSERT INTO `user` VALUES ('16', 'updata', 'updata11121', null, null, 'updata', '2', null, '2019-03-19 12:23:30', null, '2019-03-19 12:23:30', '女', null, null);
INSERT INTO `user` VALUES ('17', '17373817175', '111', null, null, null, '2', null, '2019-04-20 07:38:08', null, '2019-04-20 07:38:08', null, null, null);
INSERT INTO `user` VALUES ('18', '17673958486', '111', null, null, null, '2', null, '2019-04-20 07:39:54', null, '2019-04-20 07:39:54', null, null, null);
INSERT INTO `user` VALUES ('19', '17673817125', '111', null, null, null, '2', null, '2019-04-20 07:46:43', null, '2019-04-20 07:46:43', null, null, null);
INSERT INTO `user` VALUES ('20', '17697356842', '111', null, null, null, '2', null, '2019-04-20 07:52:37', null, '2019-04-20 07:52:37', null, null, null);
INSERT INTO `user` VALUES ('21', '17673817579', '123', null, null, null, '2', null, '2019-04-20 08:05:07', null, '2019-04-20 08:05:07', null, null, null);
INSERT INTO `user` VALUES ('22', '17673817575', '123', null, null, null, '2', null, '2019-04-20 08:25:11', null, '2019-04-20 08:25:11', null, null, null);
INSERT INTO `user` VALUES ('23', '17673817569', '123', null, null, null, '2', null, '2019-04-20 08:26:29', null, '2019-04-20 08:26:29', null, null, '[GT, Nissan, Porsche, 中国红, 火焰橙]');
INSERT INTO `user` VALUES ('24', '17395783625', '1111', null, null, null, '2', null, '2019-04-20 08:55:54', null, '2019-04-20 08:55:54', null, null, 'Benz, GT, Nissan, Porsche, 中国红, 火焰橙');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `user_role` VALUES ('2', '2', '2', null, null, null, null);
