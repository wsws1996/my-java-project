/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : purchasing

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-05-14 22:47:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pur_bus_order
-- ----------------------------
DROP TABLE IF EXISTS `pur_bus_order`;
CREATE TABLE `pur_bus_order` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `processInstance_id` varchar(255) DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pur_bus_order
-- ----------------------------
INSERT INTO `pur_bus_order` VALUES ('7525365843f542dda244ddfe5e79dda3', 'test', '12', '2016-05-14', '2', '1', null, null, 'gdf');
INSERT INTO `pur_bus_order` VALUES ('b93b2fd5c57e4c8db41a82c16cc3f28e', '5月14日第一次采购', '49999', '2016-05-14', '5', '1', null, null, '笔记本，台式机');

-- ----------------------------
-- Table structure for pur_bus_order_audit
-- ----------------------------
DROP TABLE IF EXISTS `pur_bus_order_audit`;
CREATE TABLE `pur_bus_order_audit` (
  `id` varchar(255) NOT NULL,
  `user_Id` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `audit_info` varchar(255) DEFAULT NULL,
  `audit_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`user_Id`),
  KEY `orderId` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pur_bus_order_audit
-- ----------------------------
INSERT INTO `pur_bus_order_audit` VALUES ('49fafdd172784be39e98bf9527074172', '3', 'b93b2fd5c57e4c8db41a82c16cc3f28e', '还可以', null, '1', null);
INSERT INTO `pur_bus_order_audit` VALUES ('8080195f90c1495c84d65a17b5293e13', '2', 'b93b2fd5c57e4c8db41a82c16cc3f28e', '挺好', null, '1', null);

-- ----------------------------
-- Table structure for pur_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `pur_sys_role`;
CREATE TABLE `pur_sys_role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pur_sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for pur_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `pur_sys_user`;
CREATE TABLE `pur_sys_user` (
  `id` varchar(255) NOT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pur_sys_user
-- ----------------------------
INSERT INTO `pur_sys_user` VALUES ('1', 'admin', 'admin', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `pur_sys_user` VALUES ('2', 'jingli', '部门经理', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `pur_sys_user` VALUES ('3', 'zongjingli', '总经理', '96e79218965eb72c92a549dd5a330112');

-- ----------------------------
-- Table structure for pur_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pur_sys_user_role`;
CREATE TABLE `pur_sys_user_role` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pur_sys_user_role
-- ----------------------------
