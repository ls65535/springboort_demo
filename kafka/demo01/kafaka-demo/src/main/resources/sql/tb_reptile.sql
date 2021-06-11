/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-01 16:24:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_reptile
-- ----------------------------
DROP TABLE IF EXISTS `tb_reptile`;
CREATE TABLE `tb_reptile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `directors` varchar(1024) NOT NULL COMMENT '导演',
  `title` varchar(1024) NOT NULL COMMENT '标题',
  `cover` varchar(1024) NOT NULL COMMENT '封面',
  `rate` varchar(1024) NOT NULL COMMENT '评分',
  `casts` varchar(1024) NOT NULL COMMENT '演员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
