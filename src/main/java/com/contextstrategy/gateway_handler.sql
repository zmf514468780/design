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

 Date: 29/05/2019 13:45:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gateway_handler
-- ----------------------------
DROP TABLE IF EXISTS `gateway_handler`;
CREATE TABLE `gateway_handler`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `handler_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'handler名称',
  `handler_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'handler主键id',
  `prev_handler_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_handler_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下一个handler',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gateway_handler
-- ----------------------------
INSERT INTO `gateway_handler` VALUES (16, 'Api接口限流', 'currentLimitHandler', NULL, 'blacklistHandler');
INSERT INTO `gateway_handler` VALUES (17, '黑名单拦截', 'blacklistHandler', 'currentLimitHandler', 'conversationHandler');
INSERT INTO `gateway_handler` VALUES (18, '会话验证', 'conversationHandler', 'blacklistHandler', NULL);

SET FOREIGN_KEY_CHECKS = 1;
