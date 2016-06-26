/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : elec

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-04-14 23:47:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Elec_CommonMsg
-- ----------------------------
DROP TABLE IF EXISTS `Elec_CommonMsg`;
CREATE TABLE `Elec_CommonMsg` (
  `comID` varchar(50) NOT NULL,
  `stationRun` varchar(5000) DEFAULT NULL,
  `devRun` varchar(5000) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`comID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_CommonMsg
-- ----------------------------
INSERT INTO `Elec_CommonMsg` VALUES ('ff80808153c29e290153c2a3a0360011', '1', '2', '2016-04-12 22:25:08');

-- ----------------------------
-- Table structure for Elec_CommonMsg_Content
-- ----------------------------
DROP TABLE IF EXISTS `Elec_CommonMsg_Content`;
CREATE TABLE `Elec_CommonMsg_Content` (
  `comID` varchar(50) NOT NULL,
  `type` char(2) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `orderby` int(11) DEFAULT NULL,
  PRIMARY KEY (`comID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_CommonMsg_Content
-- ----------------------------
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60540', '1', '<p>\r\n	9月10日 正常 <img alt=\"smiley\" height=\"20\" src=\"', '1');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60541', '1', 'http://localhost:8080/Elec/ckeditor/plugins/smiley', '2');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60542', '1', '/images/regular_smile.gif\" title=\"smiley\" width=\"2', '3');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60543', '1', '0\" /></p>\r\n', '4');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60544', '2', '<p>\r\n	<img alt=\"\" src=\"/Elec/userfiles/images/%E5%', '1');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60545', '2', 'A3%81%E7%BA%B8.jpg\" style=\"width: 300px; height: 1', '2');
INSERT INTO `Elec_CommonMsg_Content` VALUES ('ff808081540ad9e401540adc94e60546', '2', '69px;\" /></p>\r\n', '3');

-- ----------------------------
-- Table structure for Elec_Popedom
-- ----------------------------
DROP TABLE IF EXISTS `Elec_Popedom`;
CREATE TABLE `Elec_Popedom` (
  `mid` varchar(32) NOT NULL,
  `pid` varchar(32) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `url` varchar(5000) DEFAULT NULL,
  `icon` varchar(5000) DEFAULT NULL,
  `target` varchar(500) DEFAULT NULL,
  `isParent` tinyint(1) DEFAULT NULL,
  `isMenu` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`mid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_Popedom
-- ----------------------------
INSERT INTO `Elec_Popedom` VALUES ('aa', '0', '技术设施维护管理', null, '../images/MenuIcon/jishusheshiweihuguanli.gif', null, '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('ab', 'aa', '仪器设备管理', '', '../images/MenuIcon/shebeijiaozhunjianxiu.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ac', 'aa', '设备校准检修', '', '../images/MenuIcon/shebeijiaozhunjianxiu.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ad', 'aa', '设备购置计划', '', '../images/MenuIcon/shebeigouzhijihua.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ae', '0', '技术资料图纸管理', '', '../images/MenuIcon/jishuziliaotuzhiguanli.gif', '', '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('af', 'ae', '资料图纸管理', '../dataChart/elecFileUploadAction_home.do', '../images/MenuIcon/ziliaotuzhiguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ag', '0', '站点设备运行管理', '', '../images/MenuIcon/zhuandianshebeiyunxingguanli.gif', '', '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('ah', 'ag', '站点基本信息', '', '../images/MenuIcon/zhandianjibenxinxi.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ai', 'ag', '运行情况', '', '../images/MenuIcon/yunxingqingkuang.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('aj', 'ag', '维护情况', '', '../images/MenuIcon/weihuqingkuang.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ak', '0', '监测台建筑管理', '', '../images/MenuIcon/jiancetaijianzhuguanli.gif', '', '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('al', 'ak', '检测台建筑管理', '', '../images/MenuIcon/jiancetaijianzhu.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('am', '0', '系统管理', '', '../images/MenuIcon/xitongguanli.gif', '', '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('an', 'am', '用户管理', '../system/elecUserAction_home.do', '../images/MenuIcon/yonghuguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ao', 'am', '角色管理', '../system/elecRoleAction_home.do', '../images/MenuIcon/jueseguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ap', 'am', '运行监控', '../system/elecCommonMsgAction_home.do', '../images/MenuIcon/daibanshiyi.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('aq', 'am', '数据字典维护', '../system/elecSystemDDLAction_home.do', '../images/MenuIcon/shujuzidianguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ar', '0', '审批流转', '', '../images/MenuIcon/shenpiliuzhuanguanli.gif', '', '1', '1');
INSERT INTO `Elec_Popedom` VALUES ('as', 'ar', '审批流程管理', '', '../images/MenuIcon/shenpiliuchengguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('at', 'ar', '申请模板管理', '', '../images/MenuIcon/shenqingmobanguanli.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('au', 'ar', '起草申请', '', '../images/MenuIcon/qicaoshenqing.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('av', 'ar', '待我审批', '', '../images/MenuIcon/daiwoshenpi.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('aw', 'ar', '我的申请查询', '', '../images/MenuIcon/wodeshenqingchaxun.gif', 'mainFrame', '0', '1');
INSERT INTO `Elec_Popedom` VALUES ('ba', '0', '系统登录', '', '', '', '1', '0');
INSERT INTO `Elec_Popedom` VALUES ('bb', 'ba', '首页显示', '/system/elecMenuAction_menuHome.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bc', 'ba', '标题', '/system/elecMenuAction_title.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bd', 'ba', '菜单', '/system/elecMenuAction_left.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('be', 'ba', '加载左侧树形结构', '/system/elecMenuAction_showMenu.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bf', 'ba', '改变框架', '/system/elecMenuAction_change.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bg', 'ba', '加载主显示页面', '/system/elecMenuAction_loading.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bh', 'ba', '站点运行', '/system/elecMenuAction_alermStation.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bi', 'ba', '设备运行', '/system/elecMenuAction_alermDevice.do', '', '', '0', '0');
INSERT INTO `Elec_Popedom` VALUES ('bj', 'ba', '重新登录', '/system/elecMenuAction_logout.do', '', '', '0', '0');

-- ----------------------------
-- Table structure for Elec_Role
-- ----------------------------
DROP TABLE IF EXISTS `Elec_Role`;
CREATE TABLE `Elec_Role` (
  `roleID` varchar(32) NOT NULL,
  `roleName` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_Role
-- ----------------------------
INSERT INTO `Elec_Role` VALUES ('1', '系统管理员');
INSERT INTO `Elec_Role` VALUES ('2', '高级管理员');
INSERT INTO `Elec_Role` VALUES ('3', '中级管理员');
INSERT INTO `Elec_Role` VALUES ('4', '业务用户');
INSERT INTO `Elec_Role` VALUES ('5', '一般用户');
INSERT INTO `Elec_Role` VALUES ('6', '普通用户');

-- ----------------------------
-- Table structure for Elec_Role_Popedom
-- ----------------------------
DROP TABLE IF EXISTS `Elec_Role_Popedom`;
CREATE TABLE `Elec_Role_Popedom` (
  `roleID` varchar(32) NOT NULL,
  `mid` varchar(32) NOT NULL,
  `pid` varchar(32) NOT NULL,
  PRIMARY KEY (`roleID`,`mid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_Role_Popedom
-- ----------------------------
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'aa', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ab', 'aa');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ac', 'aa');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ad', 'aa');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ae', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'af', 'ae');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ag', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ah', 'ag');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ai', 'ag');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'aj', 'ag');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ak', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'al', 'ak');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'am', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'an', 'am');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ao', 'am');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ap', 'am');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'aq', 'am');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ar', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'as', 'ar');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'at', 'ar');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'au', 'ar');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'av', 'ar');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'aw', 'ar');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'ba', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bb', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bc', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bd', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'be', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bf', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bg', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bh', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bi', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('1', 'bj', 'ba');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'aa', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ad', 'aa');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ae', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'af', 'ae');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ag', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ah', 'ag');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'aj', 'ag');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ak', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'al', 'ak');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'am', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ap', 'am');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'ar', '0');
INSERT INTO `Elec_Role_Popedom` VALUES ('2', 'au', 'ar');

-- ----------------------------
-- Table structure for Elec_SystemDDL
-- ----------------------------
DROP TABLE IF EXISTS `Elec_SystemDDL`;
CREATE TABLE `Elec_SystemDDL` (
  `seqID` int(11) NOT NULL,
  `keyword` varchar(20) DEFAULT NULL,
  `ddlCode` int(11) DEFAULT NULL,
  `ddlName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`seqID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_SystemDDL
-- ----------------------------
INSERT INTO `Elec_SystemDDL` VALUES ('1', '性别', '1', '男');
INSERT INTO `Elec_SystemDDL` VALUES ('2', '性别', '2', '女');
INSERT INTO `Elec_SystemDDL` VALUES ('3', '北京', '1', '北京昌平电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('4', '北京', '2', '北京海淀电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('5', '北京', '3', '北京西城电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('6', '上海', '1', '上海浦东电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('7', '上海', '2', '上海闸北电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('8', '上海', '3', '上海徐汇电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('9', '深圳', '1', '深圳福田电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('10', '深圳', '2', '深圳龙岗电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('11', '深圳', '3', '深圳南山电力公司');
INSERT INTO `Elec_SystemDDL` VALUES ('18', '职位', '1', '总经理');
INSERT INTO `Elec_SystemDDL` VALUES ('19', '职位', '2', '部门经理');
INSERT INTO `Elec_SystemDDL` VALUES ('20', '职位', '3', '职员');
INSERT INTO `Elec_SystemDDL` VALUES ('21', '是否在职', '1', '是');
INSERT INTO `Elec_SystemDDL` VALUES ('22', '是否在职', '2', '否');
INSERT INTO `Elec_SystemDDL` VALUES ('26', '所属单位', '1', '北京');
INSERT INTO `Elec_SystemDDL` VALUES ('27', '所属单位', '2', '天津');
INSERT INTO `Elec_SystemDDL` VALUES ('28', '所属单位', '3', '上海');
INSERT INTO `Elec_SystemDDL` VALUES ('29', '所属单位', '4', '河北');
INSERT INTO `Elec_SystemDDL` VALUES ('30', '天津', '1', '天津超算');

-- ----------------------------
-- Table structure for Elec_Text
-- ----------------------------
DROP TABLE IF EXISTS `Elec_Text`;
CREATE TABLE `Elec_Text` (
  `textID` varchar(50) NOT NULL,
  `textName` varchar(50) DEFAULT NULL,
  `textDate` datetime DEFAULT NULL,
  `textRemark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`textID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_Text
-- ----------------------------
INSERT INTO `Elec_Text` VALUES ('ff80808153a2603e0153a26042600001', '测试hibernate名称', '2016-03-23 00:00:00', '测试hibernate备注');
INSERT INTO `Elec_Text` VALUES ('ff80808153a423870153a423b4490001', '张三', '2016-03-23 00:00:00', '张三四');
INSERT INTO `Elec_Text` VALUES ('ff80808153a7bd610153a7be0b5a0001', '李四', '2016-03-08 00:00:00', '李四四');
INSERT INTO `Elec_Text` VALUES ('ff80808153a7ccd50153a7cce45b0001', '王五iu', '2016-03-15 00:00:00', '王五额u');
INSERT INTO `Elec_Text` VALUES ('ff80808153ac3bfc0153ac408ef30000', '赵六', '2016-03-09 00:00:00', '赵老六');
INSERT INTO `Elec_Text` VALUES ('ff80808153acc0130153acc147bd0000', '赵六', '2016-03-09 00:00:00', '赵老六');
INSERT INTO `Elec_Text` VALUES ('ff80808153acc9040153acce3aec0000', '田七', '2016-04-04 00:00:00', '田七⑦');

-- ----------------------------
-- Table structure for Elec_User
-- ----------------------------
DROP TABLE IF EXISTS `Elec_User`;
CREATE TABLE `Elec_User` (
  `userID` varchar(50) NOT NULL,
  `jctID` varchar(50) DEFAULT NULL,
  `jctUnitID` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `logonName` varchar(50) DEFAULT NULL,
  `logonPwd` varchar(50) DEFAULT NULL,
  `sexID` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contactTel` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `isDuty` varchar(50) DEFAULT NULL,
  `postID` varchar(50) DEFAULT NULL,
  `onDutyDate` datetime DEFAULT NULL,
  `offDutyDate` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_User
-- ----------------------------
INSERT INTO `Elec_User` VALUES ('ff80808153d624400153d6271bba0003', '3', '2', '诸葛亮', 'zhugeliang', '202CB962AC59075B964B07152D234B70\r\n', '1', '2016-04-06 00:00:00', '北京', '8888888', 'liang@sina.com', '13213213212', '1', '1', '2016-04-12 00:00:00', null, '聪明的人');
INSERT INTO `Elec_User` VALUES ('ff80808153dd5b200153dd5c0ced0001', '1', '1', '刘备', 'liubei', '202CB962AC59075B964B07152D234B70', '1', null, '', '', '', '', '1', '1', '2016-04-06 00:00:00', null, '');
INSERT INTO `Elec_User` VALUES ('ff80808153dd69fa0153dd6af1b40001', '1', '1', '赵云', 'zhaoyun', '698D51A19D8A121CE581499D7B701668', '1', null, '', '', 'liang@sina.com', '', '1', '1', '2016-04-05 00:00:00', null, '');
INSERT INTO `Elec_User` VALUES ('ff808081540f4e3201540f4f23610001', '1', '3', '系统管理员', 'admin', '202CB962AC59075B964B07152D234B70', '1', null, '', '', '', '', '1', '1', '2016-04-12 00:00:00', null, '');
INSERT INTO `Elec_User` VALUES ('ff808081540f5f5301540f6c9b2f0001', '3', '2', '张飞', 'zhangfei', '202CB962AC59075B964B07152D234B70', '1', null, '', '', '', '', '1', '1', '2016-04-15 00:00:00', null, '');
INSERT INTO `Elec_User` VALUES ('ff808081540f70bd01540f868f6b0001', '1', '2', '赵飞', 'zhaofei', '202CB962AC59075B964B07152D234B70', '1', null, '', '', '', '', '1', '2', '2016-04-06 00:00:00', null, '');
INSERT INTO `Elec_User` VALUES ('ff808081541413f30154141d79390001', '3', '2', '张二飞', '张二飞', '202CB962AC59075B964B07152D234B70', '2', null, '', '', '', '', '1', '1', '2016-04-07 00:00:00', null, '');

-- ----------------------------
-- Table structure for Elec_User_File
-- ----------------------------
DROP TABLE IF EXISTS `Elec_User_File`;
CREATE TABLE `Elec_User_File` (
  `fileID` varchar(50) NOT NULL,
  `userID` varchar(50) DEFAULT NULL,
  `fileName` varchar(50) DEFAULT NULL,
  `fileURL` varchar(1000) DEFAULT NULL,
  `progressTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`fileID`),
  KEY `userID` (`userID`),
  CONSTRAINT `Elec_User_File_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Elec_User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Elec_User_File
-- ----------------------------
INSERT INTO `Elec_User_File` VALUES ('ff80808153d624400153d6271b9c0001', 'ff80808153d624400153d6271bba0003', 'spring-tx-3.0.xsd', '/upload/2016/04/02/用户管理/78ba88af-1639-4307-ba9e-2c0b3714113c.xsd', '2016-04-02 16:46:40');
INSERT INTO `Elec_User_File` VALUES ('ff80808153d624400153d6271bba0002', 'ff80808153d624400153d6271bba0003', '我的错误记录.txt', '/upload/2016/04/02/用户管理/f9eadfe8-b40b-400f-a8b6-27bc4e3e557f.txt', '2016-04-02 16:46:40');
INSERT INTO `Elec_User_File` VALUES ('ff80808153dcc62c0153dcc6d58d0001', 'ff80808153d624400153d6271bba0003', '传智播客的百度云.txt', '/upload/2016/04/03/用户管理/ea44247e-5d73-4b30-a214-a998d72fe702.txt', '2016-04-03 23:38:51');
INSERT INTO `Elec_User_File` VALUES ('ff80808153dcd5c10153dcd8046d0001', 'ff80808153d624400153d6271bba0003', '生产力与生产关系的关系_好搜问答.html', '/upload/2016/04/03/用户管理/aee0203d-be92-46c9-9801-f3fd1117f76a.html', '2016-04-03 23:57:37');
INSERT INTO `Elec_User_File` VALUES ('ff80808153dce2e20153dce7116c0001', 'ff80808153d624400153d6271bba0003', 'struts-2.3.24.1-src.zip', '/upload/2016/04/04/用户管理/df87f901-3cea-4787-9a47-c0ab8867430b.zip', '2016-04-04 00:14:04');
INSERT INTO `Elec_User_File` VALUES ('ff80808153dce2e20153dce7d9020002', 'ff80808153d624400153d6271bba0003', 'struts-2.3.24.1-docs.zip', '/upload/2016/04/04/用户管理/6051d4a3-0f60-406b-8765-d691fb52fd64.zip', '2016-04-04 00:14:55');

-- ----------------------------
-- Table structure for elec_user_role
-- ----------------------------
DROP TABLE IF EXISTS `elec_user_role`;
CREATE TABLE `elec_user_role` (
  `userID` varchar(255) NOT NULL,
  `roleID` varchar(255) NOT NULL,
  PRIMARY KEY (`roleID`,`userID`),
  KEY `FK14CB98302776DFCE` (`roleID`),
  KEY `FK14CB98302CCC3538` (`userID`),
  CONSTRAINT `FK14CB98302776DFCE` FOREIGN KEY (`roleID`) REFERENCES `Elec_Role` (`roleID`),
  CONSTRAINT `FK14CB98302CCC3538` FOREIGN KEY (`userID`) REFERENCES `Elec_User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elec_user_role
-- ----------------------------
INSERT INTO `elec_user_role` VALUES ('ff80808153dd5b200153dd5c0ced0001', '1');
INSERT INTO `elec_user_role` VALUES ('ff808081540f4e3201540f4f23610001', '1');
INSERT INTO `elec_user_role` VALUES ('ff80808153d624400153d6271bba0003', '2');
INSERT INTO `elec_user_role` VALUES ('ff80808153dd5b200153dd5c0ced0001', '2');
INSERT INTO `elec_user_role` VALUES ('ff80808153dd69fa0153dd6af1b40001', '2');
INSERT INTO `elec_user_role` VALUES ('ff808081540f4e3201540f4f23610001', '2');
INSERT INTO `elec_user_role` VALUES ('ff808081541413f30154141d79390001', '2');
INSERT INTO `elec_user_role` VALUES ('ff808081540f70bd01540f868f6b0001', '3');
