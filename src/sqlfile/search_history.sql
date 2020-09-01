/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : mini_project

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 01/09/2020 23:18:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for search_history
-- ----------------------------
DROP TABLE IF EXISTS `search_history`;
CREATE TABLE `search_history`  (
  `id` int(11) NOT NULL,
  `search_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '搜索 的key',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_date`(`create_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
