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

 Date: 01/09/2020 23:18:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hotkey_config
-- ----------------------------
DROP TABLE IF EXISTS `hotkey_config`;
CREATE TABLE `hotkey_config`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `search_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '高频词汇',
  `key_status` tinyint(4) NOT NULL COMMENT '关键字状态，是否启用',
  `key_order` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '关键词位置',
  `start_time` datetime(0) NOT NULL COMMENT '关键词开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '关键词结束时间',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `key`(`search_key`) USING BTREE,
  INDEX `start_time`(`start_time`, `end_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
