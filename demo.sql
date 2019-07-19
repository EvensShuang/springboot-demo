/*
Navicat MySQL Data Transfer

Source Server         : 192.168.19.14
Source Server Version : 50628
Source Host           : 192.168.19.14:3306
Source Database       : erp_sync

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2019-07-19 16:53:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', 'bbbbbbbbbbbbbbbb', 'bbbbbbbbbbbbbbbb');
INSERT INTO `demo` VALUES ('2', '22', '22');
