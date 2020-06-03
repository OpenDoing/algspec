/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : array

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2019-12-20 19:57:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `array`
-- ----------------------------
DROP TABLE IF EXISTS `array`;
CREATE TABLE `array` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ele` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of array
-- ----------------------------
INSERT INTO `array` VALUES ('1', '[1, 2, 8, 8, 9, 6, 43, 8]');
INSERT INTO `array` VALUES ('2', '[3, 2, 3, 2, 4, 9, 9, 8, 7, 6, 15, 96, 15, 13]');
INSERT INTO `array` VALUES ('3', '[5,9,8,6,4,12,55,23,16,87,10]');
INSERT INTO `array` VALUES ('6', null);
INSERT INTO `array` VALUES ('7', null);
INSERT INTO `array` VALUES ('8', null);
INSERT INTO `array` VALUES ('9', null);
INSERT INTO `array` VALUES ('10', null);
INSERT INTO `array` VALUES ('11', '[19]');
