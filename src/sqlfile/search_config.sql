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

 Date: 01/09/2020 23:18:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for search_config
-- ----------------------------
DROP TABLE IF EXISTS `search_config`;
CREATE TABLE `search_config`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `config_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置的key',
  `config_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置的值',
  `config_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置的标题',
  `create_date` datetime(0) NOT NULL,
  `update_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `key`(`config_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
