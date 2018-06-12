/*
Navicat MySQL Data Transfer

Source Server         : 192.168.33.100
Source Server Version : 50635
Source Host           : 192.168.33.100:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-06-12 15:44:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nike_name` varchar(32) DEFAULT NULL,
  `user_sex` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
