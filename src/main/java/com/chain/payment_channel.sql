/*
 Navicat Premium Data Transfer

 Source Server         : zz
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : zhumf

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/05/2019 13:44:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment_channel
-- ----------------------------
DROP TABLE IF EXISTS `payment_channel`;
CREATE TABLE `payment_channel`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CHANNEL_NAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `CHANNEL_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道ID',
  `strategy_bean_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '策略执行beanid',
  PRIMARY KEY (`ID`, `CHANNEL_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付渠道 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_channel
-- ----------------------------
INSERT INTO `payment_channel` VALUES (5, '小米支付渠道', 'xiaomi_pay', 'xiaomiPayStrategy');
INSERT INTO `payment_channel` VALUES (6, '调用支付宝接口', 'ali', 'aliPayStrategy');

SET FOREIGN_KEY_CHECKS = 1;
