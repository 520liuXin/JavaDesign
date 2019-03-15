/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : Test

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-14 17:46:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `file_info`
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_info
-- ----------------------------
INSERT INTO `file_info` VALUES ('2', null, null, null, null, null, 'FL_cbB5mnmYIwzc0gZnv.jpg', 'demo1.jpg', '/home/ableliu/file/20190225/111910', 'image/jpeg', '', null, '279356', '2019-02-25 11:19:10', '/home/ableliu/file/20190225/111910/FL_cbB5mnmYIwzc0gZnv.jpg', '');
INSERT INTO `file_info` VALUES ('3', null, null, null, null, null, 'FL_fjKCUy29p4ykoixyg.jpg', 'demo1.jpg', '/home/ableliu/file/20190225/113243', 'image/jpeg', '', null, '279356', '2019-02-25 11:32:43', '/home/ableliu/file/20190225/113243/FL_fjKCUy29p4ykoixyg.jpg', '');
INSERT INTO `file_info` VALUES ('4', null, null, null, null, null, 'FL_eUnpB2tShpk7cRuR8.jpeg', 'form.jpeg', '/home/ableliu/file/20190225/113647', 'image/jpeg', '', null, '62582', '2019-02-25 11:36:47', '/home/ableliu/file/20190225/113647/FL_eUnpB2tShpk7cRuR8.jpeg', '');
INSERT INTO `file_info` VALUES ('5', null, null, null, null, null, 'FL_cPXXvO2SzHs5y7OlD.jpg', 'login.jpg', '/home/ableliu/file/20190225/114350', 'image/jpeg', '', null, '693604', '2019-02-25 11:43:50', '/home/ableliu/file/20190225/114350/FL_cPXXvO2SzHs5y7OlD.jpg', '');
INSERT INTO `file_info` VALUES ('6', null, null, null, null, null, 'FL_efPQSqDYCPMbTf529.jpg', 'user.jpg', '/home/ableliu/file/20190225/133722', 'image/jpeg', '', null, '21836', '2019-02-25 13:37:22', '/home/ableliu/file/20190225/133722/FL_efPQSqDYCPMbTf529.jpg', '');
INSERT INTO `file_info` VALUES ('7', null, null, null, null, null, 'FL_frknRug9HL9l76f69.jpg', 'user.jpg', '/home/ableliu/file/20190225/133916', 'image/jpeg', '', null, '21836', '2019-02-25 13:39:16', '/home/ableliu/file/20190225/133916/FL_frknRug9HL9l76f69.jpg', '');
INSERT INTO `file_info` VALUES ('8', null, null, null, null, null, 'FL_cVxdDz6R4Tc9SDGgY.jpg', '1.jpg', '/home/ableliu/file/20190225/144855', 'image/jpeg', '', null, '277388', '2019-02-25 14:48:55', '/home/ableliu/file/20190225/144855/FL_cVxdDz6R4Tc9SDGgY.jpg', '');
INSERT INTO `file_info` VALUES ('9', null, null, null, null, null, 'FL_bh3uYGteT6HiUkCVE.jpg', '1.jpg', '/home/ableliu/file/20190225/144917', 'image/jpeg', '', null, '277388', '2019-02-25 14:49:17', '/home/ableliu/file/20190225/144917/FL_bh3uYGteT6HiUkCVE.jpg', '');
INSERT INTO `file_info` VALUES ('10', null, null, null, null, null, 'FL_cxw6tgVfuJQ1AhAlD.png', '2019-01-24 09-26-40屏幕截图 (5).png', '/home/ableliu/file/20190304/171305', 'image/png', '', null, '1061247', '2019-03-04 17:13:05', '/home/ableliu/file/20190304/171305/FL_cxw6tgVfuJQ1AhAlD.png', '');
INSERT INTO `file_info` VALUES ('11', null, null, null, null, null, 'FL_cxaBsaJoWLC1OoYka.png', '2019-01-24 09-26-40屏幕截图 (3).png', '/home/ableliu/file/20190311/140013', 'image/png', '', null, '1061247', '2019-03-11 14:00:13', '/home/ableliu/file/20190311/140013/FL_cxaBsaJoWLC1OoYka.png', '');

-- ----------------------------
-- Table structure for `hibernate_sequence`
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
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, null, null, null, null, '添加用户', null, '/user/add');
INSERT INTO `menu` VALUES ('2', null, null, null, null, null, '修改用户', null, '/user/update');
INSERT INTO `menu` VALUES ('3', null, null, null, null, null, '删除用户', null, '/user/del');
INSERT INTO `menu` VALUES ('4', null, null, null, null, null, '会员列表', null, '/user/list');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', null, null, null, null, '1', '管理员');
INSERT INTO `role` VALUES ('2', null, null, null, null, '2', '用户');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', null, null, null, null, '1', '1');
INSERT INTO `role_menu` VALUES ('2', null, null, null, null, '2', '1');
INSERT INTO `role_menu` VALUES ('3', null, null, null, null, '3', '1');
INSERT INTO `role_menu` VALUES ('4', null, null, null, null, '4', '1');
INSERT INTO `role_menu` VALUES ('5', null, null, null, null, '4', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `admin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/113243/FL_fjKCUy29p4ykoixyg.jpg', 'admin', '17673817175', 'admin', '1');
INSERT INTO `user` VALUES ('2', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/113647/FL_eUnpB2tShpk7cRuR8.jpeg', 'user', '17673817175', 'user', '2');
INSERT INTO `user` VALUES ('3', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/114350/FL_cPXXvO2SzHs5y7OlD.jpg', '25', '17673817175', '刘慧', null);
INSERT INTO `user` VALUES ('4', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/133722/FL_efPQSqDYCPMbTf529.jpg', '2', '17673817175', '小星星', null);
INSERT INTO `user` VALUES ('5', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/133916/FL_frknRug9HL9l76f69.jpg', '9', '17673817175', '小星', null);
INSERT INTO `user` VALUES ('6', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/144855/FL_cVxdDz6R4Tc9SDGgY.jpg', '1', '17673817175', '木木', null);
INSERT INTO `user` VALUES ('7', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190225/144917/FL_bh3uYGteT6HiUkCVE.jpg', '5', '17673817175', '灵敏度', null);
INSERT INTO `user` VALUES ('8', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190304/171305/FL_cxw6tgVfuJQ1AhAlD.png', '1', '17673817175', '刘', null);
INSERT INTO `user` VALUES ('9', null, null, null, null, '799296010@qq.com', '/home/ableliu/file/20190311/140013/FL_cxaBsaJoWLC1OoYka.png', '6', '17673817175', '6', null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', null, null, null, null, '1', '1');
INSERT INTO `user_role` VALUES ('2', null, null, null, null, '2', '2');
