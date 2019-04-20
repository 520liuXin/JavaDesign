/*
 Navicat Premium Data Transfer

 Source Server         : MARIX-mysqlLocal
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 20/04/2019 12:25:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `heat_value` bigint(20) NULL DEFAULT NULL,
  `rent` bigint(20) NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `car_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `displacement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drive_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `engine` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fuel_consumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `riding_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_i30y75iyqeljinunjxneofv4y`(`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (7, '湘A154611', '奔驰c100', 'Benz', 'SSC', '红色', 500, 2003, '2019-03-24 08:49:23', '2019-03-24 08:49:23', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '300P', '15L', '四人');
INSERT INTO `car` VALUES (8, '湘A1546110', 'BMW Z5', 'BMW', 'WRC', '蓝色', 200, 2008, '2019-03-24 10:27:51', '2019-04-27 10:27:51', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '300P', '16L', '四人');
INSERT INTO `car` VALUES (10, '湘A1546112', '别克君威', 'buick', 'SSC', '黑色', 255, 200, '2019-03-24 10:27:51', '2019-03-24 10:27:51', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.5', '后驱', '400P', '16L', '四人');
INSERT INTO `car` VALUES (11, '湘A1546113', '保时捷911', 'Porsche', 'WRC', '紫色', 56, 209, '2019-04-07 10:27:51', '2019-03-24 10:27:51', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '400P', '16L', '四人');
INSERT INTO `car` VALUES (12, '湘A1546114', '兰博基尼大牛', 'Lamborghini', 'SUV', '绿色', 600, 200, '2019-03-24 10:27:52', '2019-03-24 10:27:52', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '400P', '16L', '四人');
INSERT INTO `car` VALUES (13, '湘A1546115', '莲花lotus', 'Lotus', 'SSC', '橙色', 59, 200, '2019-03-24 10:27:52', '2019-03-24 10:27:52', 0, '帕加尼风之子', '1.4', '前驱', '500P', '14L', '四人');
INSERT INTO `car` VALUES (14, '湘A1546116', '福特focus', 'Ford', 'SUV', '火焰橙', 562, 208, '2019-03-24 10:27:52', '2019-04-28 10:27:52', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '500P', '14L', '四人');
INSERT INTO `car` VALUES (15, '湘A1546117', '雷诺G3', 'Reynolds', 'WRC', '动感绿', 900, 200, '2019-03-24 10:27:52', '2019-03-24 10:27:52', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '前驱', '300P', '14L', '四人');
INSERT INTO `car` VALUES (16, '湘A1546118', '雷克萨斯GTS', 'Lexus', 'SSC', '原谅绿', 8130, 200, '2019-03-24 10:27:52', '2019-03-24 10:27:52', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '6L', '四人');
INSERT INTO `car` VALUES (17, '湘A1546119', '奔驰A100', 'OFO', 'MPV', '粉红色', 894, 200, '2019-04-26 10:27:52', '2019-05-24 10:27:52', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '前驱', '300P', '6L', '四人');
INSERT INTO `car` VALUES (18, '湘A1231311', '奔驰x7', 'Benz', 'WRC', '骚粉色', 100, 200, '2019-04-18 19:53:42', '2019-04-18 19:53:46', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '12L', '四人');
INSERT INTO `car` VALUES (19, '湘B1212312', '奔驰A100', 'Benz', 'SUV', '果皮绿', 100, 200, '2019-04-18 11:56:35', '2019-04-18 11:56:35', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '300P', '7L', '四人');
INSERT INTO `car` VALUES (20, '湘J21B111', '奔驰A100', 'Benz', 'GT', '奇异红', 100, 200, '2019-04-18 11:56:36', '2019-04-18 11:56:36', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '300P', '7L', '四人');
INSERT INTO `car` VALUES (21, '湘J21B112', '尼桑GTR36', 'Nissan', 'WCC', '骚粉色', 100, 200, '2019-04-18 12:01:49', '2019-04-18 12:01:49', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '450P', '8L', '四人');
INSERT INTO `car` VALUES (22, '湘J21B1113', '兰博小牛', 'Lamborghini', 'SSC', '中国红', 100, 200, '2019-04-18 12:01:49', '2019-04-18 12:01:49', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '450P', '8L', '四人');
INSERT INTO `car` VALUES (23, '湘J21B1114', '莲花lotus2', 'Lotus', 'VV', '动感绿', 100, 200, '2019-04-18 12:01:49', '2019-04-18 12:01:49', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '450P', '8L', '四人');
INSERT INTO `car` VALUES (24, '湘J21B1115', '雷诺QQ', 'Reynolds', 'SSC', '中国红', 100, 200, '2019-04-18 12:01:49', '2019-04-18 12:01:49', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '四驱', '450P', '8L', '四人');
INSERT INTO `car` VALUES (25, '湘J21B1116', '奥克斯空调', 'AUX', 'WCC', '动感绿', 100, 200, '2019-04-18 12:01:49', '2019-04-18 12:01:49', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '四驱', '450P', '8L', '四人');
INSERT INTO `car` VALUES (26, '湘J21B1117', '尼桑GTR36', 'Nissan', 'SSC', '骚粉色', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人');
INSERT INTO `car` VALUES (27, '湘J21B1118', '尼桑GTR35', 'Nissan', 'WCC', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '700P', '20L', '四人');
INSERT INTO `car` VALUES (28, '湘J21B1119', '兰博基尼蝙蝠', 'Lamborghini', 'MPV', '动感绿', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人');
INSERT INTO `car` VALUES (29, '湘J21B1110', '桑塔纳', 'Nissan', 'WCC', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '700P', '20L', '四人');
INSERT INTO `car` VALUES (30, '湘J21B111A', '尼桑GTR1997', 'Nissan', 'VV', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '700P', '20L', '四人');
INSERT INTO `car` VALUES (31, '湘J21B111B', '尼桑', 'Lamborghini', 'SSC', '动感绿', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (32, '湘J21B111C', '雷诺GTR08', 'Reynolds', 'WRC', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (33, '湘J21B111D', '毒药2017', 'Lamborghini', 'SSC', '骚粉色', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (34, '湘J21B111E', '雷诺N27', 'Reynolds', 'GT', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (35, '湘J21B111F', '兰博拖拉机', 'Lamborghini', 'WRC', '动感绿', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (36, '湘J21B111G', '雷诺R55', 'Reynolds', 'WCC', '中国红', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, ' 洒脱流畅的线条汇集于一处：与您心灵相约———奔驰cls级轿跑车', '1.4', '后驱', '650P', '20L', '四人');
INSERT INTO `car` VALUES (37, '湘J21B111H', '兰博基尼毒药', 'Lamborghini', 'MPV', '骚粉色', 100, 200, '2019-04-18 12:31:15', '2019-04-18 12:31:15', 0, '为路而生，道路就在脚下———奔驰新款m级越野车', '1.4', '后驱', '650P', '20L', '四人');

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  `delete_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_origin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` bit(1) NULL DEFAULT NULL,
  `resource_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` bigint(20) NULL DEFAULT NULL,
  `upload_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `valid` bit(1) NULL DEFAULT NULL,
  `car_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3h1ea71ovfm9de65vo6vdddmh`(`car_id`) USING BTREE,
  CONSTRAINT `FK3h1ea71ovfm9de65vo6vdddmh` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_info
-- ----------------------------
INSERT INTO `file_info` VALUES (14, NULL, NULL, NULL, NULL, NULL, 'FL_er3u1fOxuIEc8311H.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221321', 'image/jpeg', b'0', NULL, 139701, '2019-04-16 22:13:21', '../img/a-1.jpg', b'1', 7);
INSERT INTO `file_info` VALUES (15, NULL, NULL, NULL, NULL, NULL, 'FL_furBiMmCVTRk8kFBw.jpg', '36b58550-02190554so.jpg', '\\carFile\\img\\20190416\\221341', 'image/jpeg', b'0', NULL, 192293, '2019-04-16 22:13:41', '../img/a-2.jpg', b'1', 8);
INSERT INTO `file_info` VALUES (16, NULL, NULL, NULL, NULL, NULL, 'FL_cDQJuZG4fR2hsVP2e.jpg', '1024x0_1_q87_20120423151702722264.jpg', '\\carFile\\img\\20190416\\221347', 'image/jpeg', b'0', NULL, 141842, '2019-04-16 22:13:47', '../img/a-3.jpg', b'1', 10);
INSERT INTO `file_info` VALUES (17, NULL, NULL, NULL, NULL, NULL, 'FL_bJ4uk2f6Pko73tCar.jpg', '1024x0_1_q87_autohomecar__wKgH0FZqc7aAF7BXAAn-hCdIuOM507.jpg', '\\carFile\\img\\20190416\\221356', 'image/jpeg', b'0', NULL, 196552, '2019-04-16 22:13:56', '../img/g-1.jpg', b'1', 11);
INSERT INTO `file_info` VALUES (18, NULL, NULL, NULL, NULL, NULL, 'FL_dS3jcfAai0T9GK6Td.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', '\\carFile\\img\\20190416\\221402', 'image/jpeg', b'0', NULL, 151728, '2019-04-16 22:14:02', '../img/g-2.jpg', b'1', 12);
INSERT INTO `file_info` VALUES (19, NULL, NULL, NULL, NULL, NULL, 'FL_fTHG7xIdVir5uTVP1.jpg', '1024x0_1_q87_autohomecar__wKjB0FZF16aAUO5NAAVqUsWDgqg567.jpg', '\\carFile\\img\\20190416\\221408', 'image/jpeg', b'0', NULL, 115080, '2019-04-16 22:14:08', '../img/g-3.jpg', b'1', 13);
INSERT INTO `file_info` VALUES (20, NULL, NULL, NULL, NULL, NULL, 'FL_emX7bjyfTAP8Yv0GM.jpg', '1024x0_1_q87_autohomecar__wKjB0lfD_-OAGcxpAAcPrYIzS1U931.jpg', '\\carFile\\img\\20190416\\221414', 'image/jpeg', b'0', NULL, 139701, '2019-04-16 22:14:14', '../img/g-4.jpg', b'1', 14);
INSERT INTO `file_info` VALUES (21, NULL, NULL, NULL, NULL, NULL, 'FL_cklAB6gbY6EcPD5mr.jpg', '1024x0_1_q87_autohomecar__wKgHIVpYityAbPnfAAc9vrfj3IM377.jpg', 'D:\\file\\img\\20190417\\001156', 'image/jpeg', b'0', NULL, 151728, '2019-04-17 00:11:56', '../img/g-5.jpg', b'1', 15);
INSERT INTO `file_info` VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/g-6.jpg', NULL, 16);
INSERT INTO `file_info` VALUES (23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/g-7.jpg', NULL, 17);
INSERT INTO `file_info` VALUES (24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/g-8.jpg', NULL, 18);
INSERT INTO `file_info` VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/g-9.jpg', NULL, 19);
INSERT INTO `file_info` VALUES (26, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/g-10.jpg', NULL, 20);
INSERT INTO `file_info` VALUES (27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery1.jpg', NULL, 21);
INSERT INTO `file_info` VALUES (28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery2.jpg', NULL, 22);
INSERT INTO `file_info` VALUES (29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery3.jpg', NULL, 23);
INSERT INTO `file_info` VALUES (30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery4.jpg', NULL, 24);
INSERT INTO `file_info` VALUES (31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery5.jpg', NULL, 25);
INSERT INTO `file_info` VALUES (32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/gallery6.jpg', NULL, 26);
INSERT INTO `file_info` VALUES (33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/img1.jpg', NULL, 27);
INSERT INTO `file_info` VALUES (34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/img2.jpg', NULL, 28);
INSERT INTO `file_info` VALUES (35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/jpeg', b'0', NULL, 151728, NULL, '../img/img4.jpg', NULL, 29);
INSERT INTO `file_info` VALUES (36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic1.jpg', NULL, 30);
INSERT INTO `file_info` VALUES (37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic2.jpg', NULL, 31);
INSERT INTO `file_info` VALUES (38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic3.jpg', NULL, 32);
INSERT INTO `file_info` VALUES (39, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic4.jpg', NULL, 33);
INSERT INTO `file_info` VALUES (40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic5.jpg', NULL, 34);
INSERT INTO `file_info` VALUES (41, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic6.jpg', NULL, 35);
INSERT INTO `file_info` VALUES (42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic7.jpg', NULL, 36);
INSERT INTO `file_info` VALUES (43, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic9.jpg', NULL, 37);
INSERT INTO `file_info` VALUES (44, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic15.jpg', NULL, 7);
INSERT INTO `file_info` VALUES (45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic16.jpg', NULL, 14);
INSERT INTO `file_info` VALUES (46, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic17.jpg', NULL, 7);
INSERT INTO `file_info` VALUES (47, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic18.jpg', NULL, 7);
INSERT INTO `file_info` VALUES (48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic19.jpg', NULL, 7);
INSERT INTO `file_info` VALUES (49, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic20.jpg', NULL, 7);
INSERT INTO `file_info` VALUES (50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic21.jpg', NULL, 14);
INSERT INTO `file_info` VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic22.jpg', NULL, 14);
INSERT INTO `file_info` VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic23.jpg', NULL, 14);
INSERT INTO `file_info` VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic24.jpg', NULL, 14);
INSERT INTO `file_info` VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '../img/pic25.jpg', NULL, 14);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (3);
INSERT INTO `hibernate_sequence` VALUES (3);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, NULL, '添加用户', '/user/add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (2, NULL, '修改用户', '/user/update', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (3, NULL, '删除用户', '/user/del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (4, NULL, '会员列表', '/user/list', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (5, NULL, '文件操作', 'api/file/*', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  `buyer_amount` decimal(19, 2) NULL DEFAULT NULL,
  `car_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_id` bigint(20) NULL DEFAULT NULL,
  `car_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_rent` bigint(20) NULL DEFAULT NULL,
  `car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lease_day` int(11) NULL DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(11) NULL DEFAULT NULL,
  `user_id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userr_id` bigint(20) NULL DEFAULT NULL,
  `detailed_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_date` datetime(0) NULL DEFAULT NULL,
  `send_car` int(11) NULL DEFAULT NULL,
  `start_date` datetime(0) NULL DEFAULT NULL,
  `car_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 1, '管理员', NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES (2, 2, '用户', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu` VALUES (2, 1, 2, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu` VALUES (3, 1, 3, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu` VALUES (4, 1, 4, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu` VALUES (5, 2, 4, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu` VALUES (6, 1, 5, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '/home/ableliu/file/20190225/113243/FL_fjKCUy29p4ykoixyg.jpg', '17673817175', '430523199706197758', '1', NULL, NULL, NULL, NULL, '男', NULL, NULL);
INSERT INTO `user` VALUES (2, 'user', 'user', '/home/ableliu/file/20190225/113647/FL_eUnpB2tShpk7cRuR8.jpeg', '17673817175', '430253196606428865', '2', NULL, NULL, NULL, NULL, '男', NULL, NULL);
INSERT INTO `user` VALUES (3, '刘慧', '25', '/home/ableliu/file/20190225/114350/FL_cPXXvO2SzHs5y7OlD.jpg', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, '小星星', '2', '/home/ableliu/file/20190225/133722/FL_efPQSqDYCPMbTf529.jpg', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '小星', '9', '/home/ableliu/file/20190225/133916/FL_frknRug9HL9l76f69.jpg', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '木木', '1', '/home/ableliu/file/20190225/144855/FL_cVxdDz6R4Tc9SDGgY.jpg', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, '灵敏度', '5', '/home/ableliu/file/20190225/144917/FL_bh3uYGteT6HiUkCVE.jpg', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, '刘', '1', '/home/ableliu/file/20190304/171305/FL_cxw6tgVfuJQ1AhAlD.png', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, '6', '6', '/home/ableliu/file/20190311/140013/FL_cxaBsaJoWLC1OoYka.png', '17673817175', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (15, 'updata', 'updata11121', NULL, NULL, 'updata', '1', NULL, NULL, NULL, '2019-03-19 12:27:46', '女', NULL, NULL);
INSERT INTO `user` VALUES (16, 'updata', 'updata11121', NULL, NULL, 'updata', '2', NULL, '2019-03-19 12:23:30', NULL, '2019-03-19 12:23:30', '女', NULL, NULL);
INSERT INTO `user` VALUES (17, '18216215139', '111', NULL, '18216215139', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (18, '17673817175', '111', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (2, 2, 2, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
