/*
Navicat MySQL Data Transfer

Source Server         : mysql-192.168.47.11-开发环境
Source Server Version : 50716
Source Host           : 192.168.47.11:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-08-22 15:42:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_burn
-- ----------------------------
DROP TABLE IF EXISTS `bus_burn`;
CREATE TABLE `bus_burn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(32) DEFAULT NULL,
  `worker` varchar(20) DEFAULT NULL,
  `workOrderNum` varchar(32) DEFAULT NULL,
  `partNum` varchar(32) DEFAULT NULL,
  `testTime` datetime DEFAULT NULL,
  `adc0` varchar(32) DEFAULT NULL,
  `adc10_15` varchar(32) DEFAULT NULL,
  `adc350` varchar(32) DEFAULT NULL,
  `maxCodes` varchar(32) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_burn
-- ----------------------------
INSERT INTO `bus_burn` VALUES ('9', '1234567890ABC', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('10', '1234567890ABC', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('11', '1234567890ABC', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('12', '1', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('13', '1', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('14', '1', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:45', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('15', '1', 'hs0001', 'WD201906060001', '05.85500167', '2019-07-15 23:14:42', '723', '682', '316', '483', null, 'pass');
INSERT INTO `bus_burn` VALUES ('17', 'string', '111', '222', 'string', '2019-07-08 15:14:12', 'string', 'string', 'string', 'string', '5674567', 'pass');

-- ----------------------------
-- Table structure for bus_exterior
-- ----------------------------
DROP TABLE IF EXISTS `bus_exterior`;
CREATE TABLE `bus_exterior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(32) DEFAULT NULL,
  `worker` varchar(20) DEFAULT NULL,
  `testTime` datetime DEFAULT NULL,
  `_result` varchar(255) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_exterior
-- ----------------------------
INSERT INTO `bus_exterior` VALUES ('5', '1', '0002', '2019-07-19 21:07:01', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('6', '1', '0002', '2019-07-19 21:07:01', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('7', '1', '0002', '2019-07-19 21:07:01', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('8', '1', '0002', '2019-07-19 21:07:01', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('9', '1', '0002', '2019-07-19 21:07:02', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('10', '1', '0002', '2019-07-19 21:07:02', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('12', '1234567890ABC', '0002', '2019-07-19 21:07:26', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('13', '1234567890ABC', '0002', '2019-07-19 21:07:28', 'pass', null, null);
INSERT INTO `bus_exterior` VALUES ('14', 'string', '123', '2019-07-20 14:02:14', '123', 'stri123ng', 'string');

-- ----------------------------
-- Table structure for bus_fun
-- ----------------------------
DROP TABLE IF EXISTS `bus_fun`;
CREATE TABLE `bus_fun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(32) DEFAULT NULL,
  `worker` varchar(20) DEFAULT NULL,
  `testTime` datetime DEFAULT NULL,
  `drawLineTest` varchar(20) DEFAULT NULL,
  `leakWaterTest` varchar(20) DEFAULT NULL,
  `upBtnTest` varchar(20) DEFAULT NULL,
  `downBtnTest` varchar(20) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_fun
-- ----------------------------
INSERT INTO `bus_fun` VALUES ('1', '1234567890ABC', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('2', '1234567890ABC', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('3', '1234567890ABC', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('4', 'HB78946', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('5', 'HB0001', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('6', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('7', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('8', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('9', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('10', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('11', 'HB0002', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('12', '1', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('13', '1', 'hs0001', '2019-07-15 23:14:45', 'Pass', 'Fail', 'NotTest', 'Pass', null, null);
INSERT INTO `bus_fun` VALUES ('14', 'string', 'string', '2019-07-20 14:03:13', '123', '123', 'string', '123', 'string', 'string');

-- ----------------------------
-- Table structure for bus_pressure
-- ----------------------------
DROP TABLE IF EXISTS `bus_pressure`;
CREATE TABLE `bus_pressure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(32) DEFAULT NULL,
  `worker` varchar(20) DEFAULT NULL,
  `testTime` datetime DEFAULT NULL,
  `agWeight` int(11) DEFAULT NULL,
  `agTestResult` varchar(20) DEFAULT NULL,
  `agAvgPressure` int(11) DEFAULT NULL,
  `bgWeight` int(11) DEFAULT NULL,
  `bgTestResult` varchar(20) DEFAULT NULL,
  `bgAvgPressure` int(11) DEFAULT NULL,
  `cgWeight` int(11) DEFAULT NULL,
  `cgTestResult` varchar(20) DEFAULT NULL,
  `cgAvgPressure` int(11) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_pressure
-- ----------------------------
INSERT INTO `bus_pressure` VALUES ('1', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('2', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('3', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('4', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('5', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('6', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('7', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('8', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('9', '1', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('10', '1', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('11', '1', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('12', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('13', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('14', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('15', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('16', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('17', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('18', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('19', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('20', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('21', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('22', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('23', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('24', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('25', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('26', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('27', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('28', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('29', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('30', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('31', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('32', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('33', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('34', 'HB0000001', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('37', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('38', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('39', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('40', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('41', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('42', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('43', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('45', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('46', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('47', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('48', 'HB0000002', '0001', '2019-07-16 15:25:14', '80', 'pass', '10', '90', 'pass', '20', '90', 'pass', '30', null, null);
INSERT INTO `bus_pressure` VALUES ('49', 'string', 'string', '2019-07-20 14:07:56', '0', '1342', '0', '0', 'string', '0', '0', 'string', '0', 'string', 'string');

-- ----------------------------
-- Table structure for bus_weight
-- ----------------------------
DROP TABLE IF EXISTS `bus_weight`;
CREATE TABLE `bus_weight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(32) DEFAULT NULL,
  `worker` varchar(20) DEFAULT NULL,
  `testTime` datetime DEFAULT NULL,
  `weight` varchar(32) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_weight
-- ----------------------------
INSERT INTO `bus_weight` VALUES ('2', 'HB001', '0002', '2019-07-08 15:12:47', '21', null, null);
INSERT INTO `bus_weight` VALUES ('3', 'HB001', '0002', '2019-07-08 15:12:47', '22', null, null);
INSERT INTO `bus_weight` VALUES ('4', 'HB001', '0002', '2019-07-08 15:12:47', '23', null, null);
INSERT INTO `bus_weight` VALUES ('5', 'HB002', '0002', '2019-07-08 15:12:47', '23', null, null);
INSERT INTO `bus_weight` VALUES ('6', 'HB002', '0002', '2019-07-08 15:12:47', '23', null, null);
INSERT INTO `bus_weight` VALUES ('7', 'HB002', '0002', '2019-07-08 15:12:47', '23', null, null);
INSERT INTO `bus_weight` VALUES ('8', 'HB002', '0002', '2019-07-08 15:12:47', '23', null, null);
INSERT INTO `bus_weight` VALUES ('9', '1', '员工1', '2019-08-07 12:15:14', '中文', null, null);
INSERT INTO `bus_weight` VALUES ('10', 'string', 'string', '2019-07-20 14:09:02', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for license
-- ----------------------------
DROP TABLE IF EXISTS `license`;
CREATE TABLE `license` (
  `license` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of license
-- ----------------------------
INSERT INTO `license` VALUES ('pIGYcvR5D+SeaKJZvSUQI8LN88tvDH5aaOpKsozt9hY=');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_name` varchar(255) DEFAULT NULL,
  `_type` varchar(255) DEFAULT NULL,
  `_url` varchar(255) DEFAULT NULL,
  `_image` varchar(255) DEFAULT NULL,
  `_orderliness` int(11) DEFAULT NULL,
  `_permission` varchar(255) DEFAULT NULL,
  `_level` int(11) DEFAULT NULL,
  `_end` bit(1) DEFAULT NULL,
  `_parent_menu_fk` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', 'folder', '', 'fa fa-home', '1', 'config', '1', '', null);
INSERT INTO `menu` VALUES ('2', '菜单管理', 'link', '/menu/list.do', 'fa fa-tree', '1', 'menu', '2', '\0', '1');
INSERT INTO `menu` VALUES ('5', '用户列表', 'link', '/user/list.do', 'fa fa-child', '2', 'user', '1', '\0', '1');
INSERT INTO `menu` VALUES ('7', '角色管理', 'link', '/role/list.do', 'fa fa-arrows', '3', 'role', '1', '', '1');
INSERT INTO `menu` VALUES ('8', '烧录校准', 'link', '/burn/list.do', 'fa fa-edit', '3', 'burn', '1', '\0', null);
INSERT INTO `menu` VALUES ('9', '数据查询', 'link', '/pickData/list.do', 'fa fa-search', '8', 'pickData', '1', '', null);
INSERT INTO `menu` VALUES ('10', '功能测试', 'link', '/fun/list.do', 'fa fa-bug', '4', 'fun', '1', '\0', null);
INSERT INTO `menu` VALUES ('11', '压力测试', 'link', '/pressure/list.do', 'fa fa-paper-plane', '5', 'pressure', '1', '\0', null);
INSERT INTO `menu` VALUES ('12', '称重检查', 'link', '/weight/list.do', 'fa fa-navicon', '7', 'weight', '1', '\0', null);
INSERT INTO `menu` VALUES ('14', 'API接口', 'link', '/swagger-ui.html', 'fa fa-cloud', '9', 'swagger', '1', '', null);
INSERT INTO `menu` VALUES ('15', '外观检测', 'link', '/exterior/list.do', 'fa fa-cube', '6', 'exterior', '1', '\0', null);
INSERT INTO `menu` VALUES ('16', '投单工站', 'link', '/order/list.do', 'fa fa-inbox', '2', 'order', '1', '\0', null);
INSERT INTO `menu` VALUES ('17', '编辑', 'function', '', '', '1', 'order-edit', '2', '', '16');
INSERT INTO `menu` VALUES ('18', '查看', 'function', '', '', '2', 'order-view', '2', '', '16');
INSERT INTO `menu` VALUES ('19', '编辑', 'function', '', '', '1', 'burn-edit', '2', '', '8');
INSERT INTO `menu` VALUES ('20', '查看', 'function', '', '', '2', 'burn-view', '2', '', '8');
INSERT INTO `menu` VALUES ('21', '编辑', 'function', '', '', '1', 'fun-edit', '2', '', '10');
INSERT INTO `menu` VALUES ('22', '查看', 'function', '', '', '2', 'fun-view', '2', '', '10');
INSERT INTO `menu` VALUES ('23', '编辑', 'function', '', '', '1', 'pressure-edit', '2', '', '11');
INSERT INTO `menu` VALUES ('24', '查看', 'function', '', '', '2', 'pressure-view', '2', '', '11');
INSERT INTO `menu` VALUES ('25', '编辑', 'function', '', '', '1', 'exterior-edit', '2', '', '15');
INSERT INTO `menu` VALUES ('26', '查看', 'function', '', '', '2', 'exterior-view', '2', '', '15');
INSERT INTO `menu` VALUES ('27', '编辑', 'function', '', '', '1', 'weight-edit', '2', '', '12');
INSERT INTO `menu` VALUES ('28', '查看', 'function', '', '', '2', 'weight-view', '2', '', '12');

-- ----------------------------
-- Table structure for oper_role
-- ----------------------------
DROP TABLE IF EXISTS `oper_role`;
CREATE TABLE `oper_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_code` varchar(255) DEFAULT NULL,
  `_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oper_role
-- ----------------------------
INSERT INTO `oper_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `oper_role` VALUES ('2', 'test', '测试角色');

-- ----------------------------
-- Table structure for oper_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `oper_role_permission`;
CREATE TABLE `oper_role_permission` (
  `_role_fk` int(11) DEFAULT NULL,
  `_menu_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oper_role_permission
-- ----------------------------
INSERT INTO `oper_role_permission` VALUES ('2', '11');
INSERT INTO `oper_role_permission` VALUES ('2', '24');
INSERT INTO `oper_role_permission` VALUES ('2', '12');
INSERT INTO `oper_role_permission` VALUES ('2', '28');
INSERT INTO `oper_role_permission` VALUES ('2', '8');
INSERT INTO `oper_role_permission` VALUES ('2', '20');
INSERT INTO `oper_role_permission` VALUES ('2', '9');
INSERT INTO `oper_role_permission` VALUES ('2', '10');
INSERT INTO `oper_role_permission` VALUES ('2', '22');
INSERT INTO `oper_role_permission` VALUES ('2', '14');
INSERT INTO `oper_role_permission` VALUES ('2', '15');
INSERT INTO `oper_role_permission` VALUES ('2', '26');
INSERT INTO `oper_role_permission` VALUES ('2', '16');
INSERT INTO `oper_role_permission` VALUES ('2', '18');
INSERT INTO `oper_role_permission` VALUES ('1', '1');
INSERT INTO `oper_role_permission` VALUES ('1', '2');
INSERT INTO `oper_role_permission` VALUES ('1', '5');
INSERT INTO `oper_role_permission` VALUES ('1', '7');
INSERT INTO `oper_role_permission` VALUES ('1', '9');
INSERT INTO `oper_role_permission` VALUES ('1', '10');
INSERT INTO `oper_role_permission` VALUES ('1', '21');
INSERT INTO `oper_role_permission` VALUES ('1', '22');
INSERT INTO `oper_role_permission` VALUES ('1', '11');
INSERT INTO `oper_role_permission` VALUES ('1', '23');
INSERT INTO `oper_role_permission` VALUES ('1', '24');
INSERT INTO `oper_role_permission` VALUES ('1', '12');
INSERT INTO `oper_role_permission` VALUES ('1', '27');
INSERT INTO `oper_role_permission` VALUES ('1', '28');
INSERT INTO `oper_role_permission` VALUES ('1', '14');
INSERT INTO `oper_role_permission` VALUES ('1', '8');
INSERT INTO `oper_role_permission` VALUES ('1', '19');
INSERT INTO `oper_role_permission` VALUES ('1', '20');
INSERT INTO `oper_role_permission` VALUES ('1', '15');
INSERT INTO `oper_role_permission` VALUES ('1', '25');
INSERT INTO `oper_role_permission` VALUES ('1', '26');
INSERT INTO `oper_role_permission` VALUES ('1', '16');
INSERT INTO `oper_role_permission` VALUES ('1', '17');
INSERT INTO `oper_role_permission` VALUES ('1', '18');

-- ----------------------------
-- Table structure for oper_role_user
-- ----------------------------
DROP TABLE IF EXISTS `oper_role_user`;
CREATE TABLE `oper_role_user` (
  `_user_fk` int(11) DEFAULT NULL,
  `_role_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oper_role_user
-- ----------------------------
INSERT INTO `oper_role_user` VALUES ('1', '1');
INSERT INTO `oper_role_user` VALUES ('2', '1');
INSERT INTO `oper_role_user` VALUES ('7', '1');
INSERT INTO `oper_role_user` VALUES ('11', '2');

-- ----------------------------
-- Table structure for oper_user
-- ----------------------------
DROP TABLE IF EXISTS `oper_user`;
CREATE TABLE `oper_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_name` varchar(255) DEFAULT NULL,
  `_account` varchar(255) DEFAULT NULL,
  `_password` varchar(255) DEFAULT NULL,
  `_allow_login` varchar(255) DEFAULT NULL,
  `_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oper_user
-- ----------------------------
INSERT INTO `oper_user` VALUES ('1', 'douzy', 'douzy', '123456', '1', 'douzy@qq.com');
INSERT INTO `oper_user` VALUES ('2', '管理员', 'system', '123456', '1', 'system@qq.com');
INSERT INTO `oper_user` VALUES ('7', '测试员', 'test01', '123456', '1', 'douzy');
INSERT INTO `oper_user` VALUES ('9', '111', '111', '123456', '0', 'douzy');
INSERT INTO `oper_user` VALUES ('10', '1112', '1112', '123456', '0', 'douzy');
INSERT INTO `oper_user` VALUES ('11', '1', '1', '123456', '1', 'douzy');
