/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : luma

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 07/10/2019 22:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for asset_trade_log
-- ----------------------------
DROP TABLE IF EXISTS `asset_trade_log`;
CREATE TABLE `asset_trade_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for asset_user_bank
-- ----------------------------
DROP TABLE IF EXISTS `asset_user_bank`;
CREATE TABLE `asset_user_bank` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for basic_dict
-- ----------------------------
DROP TABLE IF EXISTS `basic_dict`;
CREATE TABLE `basic_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_type` varchar(30) NOT NULL COMMENT '字典类型',
  `dict_name` varchar(30) NOT NULL COMMENT '字典名',
  `dict_value` varchar(255) NOT NULL COMMENT '字典值',
  `status` tinyint(2) unsigned NOT NULL COMMENT '状态 0不可以、1可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Table structure for basic_media
-- ----------------------------
DROP TABLE IF EXISTS `basic_media`;
CREATE TABLE `basic_media` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uploader_type` tinyint(2) DEFAULT NULL COMMENT '上传人类型',
  `uploader_id` int(11) unsigned DEFAULT NULL COMMENT '上传人id',
  `media_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体地址',
  `media_size` int(11) DEFAULT NULL COMMENT '媒体大小，单位K',
  `media_type` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体类型',
  `media_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体标题',
  `media_ext` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '拓展名',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='媒体表';

-- ----------------------------
-- Records of basic_media
-- ----------------------------
BEGIN;
INSERT INTO `basic_media` VALUES (1, 0, 6, 'http://img.khetao.com/avatar/ec5ec0a93577f768/5d86efc57a6c94059a424e4b.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-21 22:52:04', '2019-09-21 22:52:04');
INSERT INTO `basic_media` VALUES (3, 0, 6, 'http://img.khetao.com/avatar/ec5ec0a93577f768/5d86f1557a6cc128b1dbc388.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-21 22:58:17', '2019-09-21 22:58:17');
INSERT INTO `basic_media` VALUES (4, 0, 6, 'http://img.khetao.com/c1/ec5ec0a93577f768/5d87000b7a6cc4bf0ea45582.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 00:01:07', '2019-09-22 00:01:07');
INSERT INTO `basic_media` VALUES (5, 0, 6, 'http://img.khetao.com/c1/ec5ec0a93577f768/5d8700a07a6cc4bf0ea45583.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-22 00:03:31', '2019-09-22 00:03:31');
INSERT INTO `basic_media` VALUES (6, 0, 6, 'c1/ec5ec0a93577f768/5d8716d37a6cbd276ba48e04.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 01:38:20', '2019-09-22 01:38:20');
INSERT INTO `basic_media` VALUES (7, 0, 6, 'c1/ec5ec0a93577f768/5d87191f7a6cbd276ba48e05.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 01:48:04', '2019-09-22 01:48:04');
INSERT INTO `basic_media` VALUES (8, 0, 6, 'c1/ec5ec0a93577f768/5d87195e7a6cbd276ba48e06.webp', 64484, 'image/webp', 'photo-1477064996809-dae46985eee7 (1).webp', 'webp', '2019-09-22 01:49:05', '2019-09-22 01:49:05');
INSERT INTO `basic_media` VALUES (9, 0, 6, 'c1/ec5ec0a93577f768/5d87196e7a6cbd276ba48e07.webp', 64484, 'image/webp', 'photo-1477064996809-dae46985eee7 (1).webp', 'webp', '2019-09-22 01:49:22', '2019-09-22 01:49:22');
INSERT INTO `basic_media` VALUES (10, 0, 6, 'c1/ec5ec0a93577f768/5d8719f47a6cbd276ba48e08.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 01:51:37', '2019-09-22 01:51:37');
INSERT INTO `basic_media` VALUES (11, 0, 6, 'c1/ec5ec0a93577f768/5d871af07a6cbd276ba48e09.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-22 01:55:47', '2019-09-22 01:55:47');
INSERT INTO `basic_media` VALUES (12, 0, 6, 'c1/ec5ec0a93577f768/5d871dc17a6cbd276ba48e0a.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-22 02:07:48', '2019-09-22 02:07:48');
INSERT INTO `basic_media` VALUES (13, 0, 6, 'c1/ec5ec0a93577f768/5d871dd47a6cbd276ba48e0b.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 02:08:10', '2019-09-22 02:08:10');
INSERT INTO `basic_media` VALUES (14, 0, 6, 'c1/ec5ec0a93577f768/5d871ef17a6cbd276ba48e0c.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-22 02:12:52', '2019-09-22 02:12:52');
INSERT INTO `basic_media` VALUES (15, 0, 6, 'c1/ec5ec0a93577f768/5d871f5e7a6cbd276ba48e0d.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 02:14:44', '2019-09-22 02:14:44');
INSERT INTO `basic_media` VALUES (16, 0, 6, 'c1/ec5ec0a93577f768/5d871f877a6cbd276ba48e0e.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 02:15:24', '2019-09-22 02:15:24');
INSERT INTO `basic_media` VALUES (17, 0, 6, 'c1/ec5ec0a93577f768/5d8720c37a6cbd276ba48e0f.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 02:20:43', '2019-09-22 02:20:43');
INSERT INTO `basic_media` VALUES (18, 0, 6, 'c1/ec5ec0a93577f768/5d872a5a7a6cbd276ba48e10.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 03:01:37', '2019-09-22 03:01:37');
INSERT INTO `basic_media` VALUES (19, 0, 6, 'c1/ec5ec0a93577f768/5d872a947a6cbd276ba48e11.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 03:02:32', '2019-09-22 03:02:32');
INSERT INTO `basic_media` VALUES (20, 0, 6, 'c1/ec5ec0a93577f768/5d872bc07a6cbd276ba48e12.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 03:07:34', '2019-09-22 03:07:34');
INSERT INTO `basic_media` VALUES (21, 0, 6, 'c1/ec5ec0a93577f768/5d872ca27a6cbd276ba48e13.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-22 03:11:16', '2019-09-22 03:11:16');
INSERT INTO `basic_media` VALUES (22, 0, 6, 'c1/ec5ec0a93577f768/5d872fc37a6cbd276ba48e14.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 03:24:39', '2019-09-22 03:24:39');
INSERT INTO `basic_media` VALUES (23, 0, 6, 'c1/ec5ec0a93577f768/5d873d6b7a6cbd276ba48e15.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 04:22:58', '2019-09-22 04:22:58');
INSERT INTO `basic_media` VALUES (24, 0, 6, 'c1/ec5ec0a93577f768/5d873db27a6cbd276ba48e16.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 04:24:08', '2019-09-22 04:24:08');
INSERT INTO `basic_media` VALUES (25, 0, 6, 'c1/ec5ec0a93577f768/5d874c197a6cbd276ba48e17.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 05:25:37', '2019-09-22 05:25:37');
INSERT INTO `basic_media` VALUES (26, 0, 6, 'c1/ec5ec0a93577f768/5d8752507a6cbd276ba48e18.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-22 05:52:03', '2019-09-22 05:52:03');
INSERT INTO `basic_media` VALUES (27, 0, 6, 'c1/ec5ec0a93577f768/5d875b23772e58a2b25f9d9f.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 06:29:44', '2019-09-22 06:29:44');
INSERT INTO `basic_media` VALUES (28, 0, 6, 'c1/ec5ec0a93577f768/5d875b67772e58a2b25f9da0.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 06:30:54', '2019-09-22 06:30:54');
INSERT INTO `basic_media` VALUES (29, 0, 6, 'c1/ec5ec0a93577f768/5d875b81772e58a2b25f9da1.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 06:31:18', '2019-09-22 06:31:18');
INSERT INTO `basic_media` VALUES (30, 0, 6, 'c1/ec5ec0a93577f768/5d87824a772e58a2b25f9da2.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 09:16:48', '2019-09-22 09:16:48');
INSERT INTO `basic_media` VALUES (31, 0, 6, 'c1/ec5ec0a93577f768/5d87831a772e58a2b25f9da3.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 09:20:15', '2019-09-22 09:20:15');
INSERT INTO `basic_media` VALUES (32, 0, 6, 'c1/ec5ec0a93577f768/5d87840f772e58a2b25f9da4.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-22 09:24:18', '2019-09-22 09:24:18');
INSERT INTO `basic_media` VALUES (33, 0, 6, 'c1/ec5ec0a93577f768/5d878718772e58a2b25f9da5.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 09:37:17', '2019-09-22 09:37:17');
INSERT INTO `basic_media` VALUES (34, 0, 6, 'c1/ec5ec0a93577f768/5d878744772e58a2b25f9da6.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 09:37:59', '2019-09-22 09:37:59');
INSERT INTO `basic_media` VALUES (35, 0, 6, 'c1/ec5ec0a93577f768/5d878b9b772e58a2b25f9da7.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 09:56:31', '2019-09-22 09:56:31');
INSERT INTO `basic_media` VALUES (36, 0, 6, 'c1/ec5ec0a93577f768/5d878c25772e58a2b25f9da8.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-22 09:58:48', '2019-09-22 09:58:48');
INSERT INTO `basic_media` VALUES (37, 0, 6, 'c1/ec5ec0a93577f768/5d878c9c772e58a2b25f9da9.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-22 10:00:49', '2019-09-22 10:00:49');
INSERT INTO `basic_media` VALUES (38, 0, 6, 'c1/ec5ec0a93577f768/5d878cd3772e58a2b25f9daa.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-22 10:01:43', '2019-09-22 10:01:43');
INSERT INTO `basic_media` VALUES (39, 0, 6, 'c1/ec5ec0a93577f768/5d878cec772e58a2b25f9dab.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 10:02:10', '2019-09-22 10:02:10');
INSERT INTO `basic_media` VALUES (40, 0, 6, 'c1/ec5ec0a93577f768/5d878de7772e58a2b25f9dac.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-22 10:06:20', '2019-09-22 10:06:20');
INSERT INTO `basic_media` VALUES (41, 0, 6, 'c1/ec5ec0a93577f768/5d878e1e772e58a2b25f9dad.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 10:07:16', '2019-09-22 10:07:16');
INSERT INTO `basic_media` VALUES (42, 0, 6, 'c1/ec5ec0a93577f768/5d878e68772e58a2b25f9dae.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-22 10:08:27', '2019-09-22 10:08:27');
INSERT INTO `basic_media` VALUES (43, 0, 6, 'c1/ec5ec0a93577f768/5d878f5a772e58a2b25f9daf.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-22 10:12:34', '2019-09-22 10:12:34');
INSERT INTO `basic_media` VALUES (44, 0, 6, 'c1/ec5ec0a93577f768/5d878f78772e58a2b25f9db0.png', 1179771, 'image/png', '2019091303.png', 'png', '2019-09-22 10:13:14', '2019-09-22 10:13:14');
INSERT INTO `basic_media` VALUES (45, 0, 6, 'c1/ec5ec0a93577f768/5d879332772e58a2b25f9db1.png', 1389062, 'image/png', '19091401.png', 'png', '2019-09-22 10:29:12', '2019-09-22 10:29:12');
INSERT INTO `basic_media` VALUES (46, 0, 6, 'c1/ec5ec0a93577f768/5d8793a7772e58a2b25f9db2.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 10:30:56', '2019-09-22 10:30:56');
INSERT INTO `basic_media` VALUES (47, 0, 6, 'c1/ec5ec0a93577f768/5d879474772e58a2b25f9db3.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 10:34:22', '2019-09-22 10:34:22');
INSERT INTO `basic_media` VALUES (48, 0, 6, 'c1/ec5ec0a93577f768/5d8794bc772e58a2b25f9db4.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 10:35:33', '2019-09-22 10:35:33');
INSERT INTO `basic_media` VALUES (49, 0, 6, 'c1/67ea0eeac8592c94/5d87a18f772e58a2b25f9db5.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 11:30:17', '2019-09-22 11:30:17');
INSERT INTO `basic_media` VALUES (50, 0, 6, 'c1/67ea0eeac8592c94/5d87a1d2772e58a2b25f9db6.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 11:31:23', '2019-09-22 11:31:23');
INSERT INTO `basic_media` VALUES (51, 0, 6, 'c1/67ea0eeac8592c94/5d87a247772e58a2b25f9db7.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 11:33:19', '2019-09-22 11:33:19');
INSERT INTO `basic_media` VALUES (52, 0, 6, 'c1/67ea0eeac8592c94/5d87a340772e58a2b25f9db8.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 11:37:29', '2019-09-22 11:37:29');
INSERT INTO `basic_media` VALUES (53, 0, 6, 'c1/67ea0eeac8592c94/5d87a593772e58a2b25f9db9.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 11:47:24', '2019-09-22 11:47:24');
INSERT INTO `basic_media` VALUES (54, 0, 6, 'c1/67ea0eeac8592c94/5d87aeee772e58a2b25f9dba.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-09-22 12:27:20', '2019-09-22 12:27:20');
INSERT INTO `basic_media` VALUES (55, 0, 6, 'c1/67ea0eeac8592c94/5d88d6be772e58a2b25f9dbb.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-23 09:29:21', '2019-09-23 09:29:21');
INSERT INTO `basic_media` VALUES (56, 0, 6, 'c1/67ea0eeac8592c94/5d88dbdd772e58a2b25f9dbc.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-23 09:51:16', '2019-09-23 09:51:16');
INSERT INTO `basic_media` VALUES (57, 0, 6, 'c1/67ea0eeac8592c94/5d88dc14772e58a2b25f9dbd.jpg', 320410, 'image/jpeg', 'buildings-1245953_1280.jpg', 'jpg', '2019-09-23 09:52:10', '2019-09-23 09:52:10');
INSERT INTO `basic_media` VALUES (58, 0, 6, 'c1/67ea0eeac8592c94/5d88dcbb772e58a2b25f9dbe.jpg', 320410, 'image/jpeg', 'buildings-1245953_1280.jpg', 'jpg', '2019-09-23 09:54:58', '2019-09-23 09:54:58');
INSERT INTO `basic_media` VALUES (59, 0, 6, 'c1/67ea0eeac8592c94/5d88dd04772e58a2b25f9dbf.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-23 09:56:07', '2019-09-23 09:56:07');
INSERT INTO `basic_media` VALUES (60, 0, 6, 'c1/67ea0eeac8592c94/5d88dd91772e58a2b25f9dc0.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-23 09:58:28', '2019-09-23 09:58:28');
INSERT INTO `basic_media` VALUES (61, 0, 6, 'c2/9123b9ead6156521/5d88f4b1772e998d85eff40a.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-23 11:37:09', '2019-09-23 11:37:09');
INSERT INTO `basic_media` VALUES (62, 0, 6, 'c2/9123b9ead6156521/5d88f4ed772e998d85eff40b.jpeg', 86097, 'image/jpeg', 'WechatIMG32820.jpeg', 'jpeg', '2019-09-23 11:38:07', '2019-09-23 11:38:07');
INSERT INTO `basic_media` VALUES (63, 0, 6, 'c2/9123b9ead6156521/5d88f5cd772e998d85eff40c.jpeg', 71462, 'image/jpeg', 'WechatIMG32818.jpeg', 'jpeg', '2019-09-23 11:41:52', '2019-09-23 11:41:52');
INSERT INTO `basic_media` VALUES (64, 0, 6, 'c2/9123b9ead6156521/5d88f5db772e998d85eff40d.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-09-23 11:42:10', '2019-09-23 11:42:10');
INSERT INTO `basic_media` VALUES (65, 0, 6, 'c2/9123b9ead6156521/5d88f5eb772e998d85eff40e.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-23 11:42:26', '2019-09-23 11:42:26');
INSERT INTO `basic_media` VALUES (66, 0, 6, 'c2/9123b9ead6156521/5d88f609772e998d85eff40f.jpeg', 33654, 'image/jpeg', 'WechatIMG32817.jpeg', 'jpeg', '2019-09-23 11:42:51', '2019-09-23 11:42:51');
INSERT INTO `basic_media` VALUES (67, 0, 6, 'c2/9123b9ead6156521/5d88f647772e998d85eff410.jpeg', 317675, 'image/jpeg', 'WechatIMG32813.jpeg', 'jpeg', '2019-09-23 11:43:57', '2019-09-23 11:43:57');
INSERT INTO `basic_media` VALUES (68, 2, 6, 'c1/6ba0b6dc92109df9/5d945c7f7a6c7d859e9c7f62.jpeg', 233583, 'image/jpeg', 'WechatIMG85.jpeg', 'jpeg', '2019-10-02 03:15:00', '2019-10-02 03:15:00');
INSERT INTO `basic_media` VALUES (69, 2, 6, 'product/ff5b09f2dfa46a9c/5d9735546356908a1e5a91b4.png', 1179771, 'image/png', '2019091303.png', 'png', '2019-10-04 07:04:42', '2019-10-04 07:04:42');
INSERT INTO `basic_media` VALUES (70, 2, 6, 'product/ff5b09f2dfa46a9c/5d9735bb6356908a1e5a91b5.png', 1179771, 'image/png', '2019091303.png', 'png', '2019-10-04 07:06:23', '2019-10-04 07:06:23');
INSERT INTO `basic_media` VALUES (71, 2, 6, 'product/ff5b09f2dfa46a9c/5d97366d6356908a1e5a91b6.png', 1139009, 'image/png', '19091302.png', 'png', '2019-10-04 07:09:21', '2019-10-04 07:09:21');
INSERT INTO `basic_media` VALUES (72, 2, 6, 'product/ff5b09f2dfa46a9c/5d9736a36356908a1e5a91b7.png', 1179771, 'image/png', '2019091303.png', 'png', '2019-10-04 07:10:15', '2019-10-04 07:10:15');
INSERT INTO `basic_media` VALUES (73, 2, 6, 'product/ff5b09f2dfa46a9c/5d9736e16356908a1e5a91b8.png', 1179771, 'image/png', '2019091303.png', 'png', '2019-10-04 07:11:18', '2019-10-04 07:11:18');
INSERT INTO `basic_media` VALUES (74, 2, 6, 'product/ff5b09f2dfa46a9c/5d973e8c6356908a1e5a91b9.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-10-04 07:44:02', '2019-10-04 07:44:02');
INSERT INTO `basic_media` VALUES (75, 2, 6, 'product/ff5b09f2dfa46a9c/5d9741bf6356908a1e5a91ba.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-10-04 07:57:39', '2019-10-04 07:57:39');
INSERT INTO `basic_media` VALUES (76, 2, 6, 'product/ff5b09f2dfa46a9c/5d9741cb6356908a1e5a91bb.png', 1156766, 'image/png', 'WechatIMG927.png', 'png', '2019-10-04 07:57:52', '2019-10-04 07:57:52');
INSERT INTO `basic_media` VALUES (77, 2, 6, 'product/ff5b09f2dfa46a9c/5d97460d6356908a1e5a91bc.png', 1389062, 'image/png', '19091401.png', 'png', '2019-10-04 08:16:04', '2019-10-04 08:16:04');
INSERT INTO `basic_media` VALUES (78, 2, 6, 'product/6cb2eded3acb8f37/5d9b47856356290103f1abd7.png', 1139009, 'image/png', '19091302.png', 'png', '2019-10-07 09:11:36', '2019-10-07 09:11:36');
INSERT INTO `basic_media` VALUES (79, 2, 6, 'product/6cb2eded3acb8f37/5d9b483b6356290103f1abd8.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-10-07 09:14:28', '2019-10-07 09:14:28');
INSERT INTO `basic_media` VALUES (80, 2, 6, 'product/6cb2eded3acb8f37/5d9b499b6356290103f1abd9.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-10-07 09:20:23', '2019-10-07 09:20:23');
INSERT INTO `basic_media` VALUES (81, 2, 6, 'product/6cb2eded3acb8f37/5d9b4a8c6356290103f1abda.jpg', 464150, 'image/jpeg', 'nb.jpg', 'jpg', '2019-10-07 09:24:20', '2019-10-07 09:24:20');
COMMIT;

-- ----------------------------
-- Table structure for basic_region
-- ----------------------------
DROP TABLE IF EXISTS `basic_region`;
CREATE TABLE `basic_region` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `level` smallint(2) unsigned NOT NULL COMMENT '级别',
  `parent_id` int(11) unsigned NOT NULL COMMENT '父id',
  `i18n` varchar(30) DEFAULT NULL,
  `parents` varchar(255) NOT NULL COMMENT '父路径',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fore_resource
-- ----------------------------
DROP TABLE IF EXISTS `fore_resource`;
CREATE TABLE `fore_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `res_name` varchar(30) NOT NULL COMMENT '资源名称',
  `res_type` tinyint(2) NOT NULL COMMENT '资源类型 1=菜单 2=功能',
  `parent_id` int(11) unsigned NOT NULL COMMENT '上级',
  `parents` varchar(100) NOT NULL COMMENT '上级路径',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '可用状态 0=不可用 1=可用',
  `is_del` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `res_path` varchar(255) NOT NULL COMMENT '资源路径',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家资源表';

-- ----------------------------
-- Table structure for fore_role
-- ----------------------------
DROP TABLE IF EXISTS `fore_role`;
CREATE TABLE `fore_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `show_name` varchar(30) NOT NULL COMMENT '显示的名称',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '可用状态 0=不可用 1=可用',
  `is_del` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fore_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `fore_role_resource`;
CREATE TABLE `fore_role_resource` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(11) unsigned NOT NULL COMMENT '商家角色表',
  `res_id` bigint(11) unsigned NOT NULL COMMENT '商家资源id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家角色资源表';

-- ----------------------------
-- Table structure for fore_user
-- ----------------------------
DROP TABLE IF EXISTS `fore_user`;
CREATE TABLE `fore_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `mobile_code` varchar(10) DEFAULT NULL COMMENT '国际区号',
  `email` varchar(122) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 0=保密 1=男 2=女',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  `is_ merchant` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否商家 0=否 1=是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前端用户表';

-- ----------------------------
-- Table structure for fore_user_address
-- ----------------------------
DROP TABLE IF EXISTS `fore_user_address`;
CREATE TABLE `fore_user_address` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址';

-- ----------------------------
-- Table structure for fore_user_bill
-- ----------------------------
DROP TABLE IF EXISTS `fore_user_bill`;
CREATE TABLE `fore_user_bill` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票';

-- ----------------------------
-- Table structure for fore_user_role
-- ----------------------------
DROP TABLE IF EXISTS `fore_user_role`;
CREATE TABLE `fore_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '前端用户id',
  `role_id` int(11) NOT NULL,
  `status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '可用状态 0=不可用 1=可用',
  `gmt_start` datetime NOT NULL COMMENT '开始时间',
  `gmt_end` datetime NOT NULL COMMENT '结束时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mc_coupon
-- ----------------------------
DROP TABLE IF EXISTS `mc_coupon`;
CREATE TABLE `mc_coupon` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Table structure for mc_coupon_group
-- ----------------------------
DROP TABLE IF EXISTS `mc_coupon_group`;
CREATE TABLE `mc_coupon_group` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Table structure for mc_coupon_log
-- ----------------------------
DROP TABLE IF EXISTS `mc_coupon_log`;
CREATE TABLE `mc_coupon_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券记录';

-- ----------------------------
-- Table structure for mc_present
-- ----------------------------
DROP TABLE IF EXISTS `mc_present`;
CREATE TABLE `mc_present` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mc_present_record
-- ----------------------------
DROP TABLE IF EXISTS `mc_present_record`;
CREATE TABLE `mc_present_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_brand
-- ----------------------------
DROP TABLE IF EXISTS `pd_brand`;
CREATE TABLE `pd_brand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_name` varchar(64) NOT NULL COMMENT '品牌名称',
  `brand_img` varchar(255) DEFAULT NULL COMMENT '品牌图片',
  `intro` varchar(255) NOT NULL COMMENT '品牌介绍',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- ----------------------------
-- Records of pd_brand
-- ----------------------------
BEGIN;
INSERT INTO `pd_brand` VALUES (1, '壳桃', '', '壳桃', '2019-06-29 14:50:04', '2019-06-29 14:50:10');
COMMIT;

-- ----------------------------
-- Table structure for pd_category
-- ----------------------------
DROP TABLE IF EXISTS `pd_category`;
CREATE TABLE `pd_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cate_name` varchar(32) NOT NULL COMMENT '分类名称',
  `i18n` varchar(32) DEFAULT NULL COMMENT '国际化',
  `level` tinyint(2) NOT NULL COMMENT '分类级别',
  `parent_id` int(11) DEFAULT NULL COMMENT '父分类、根节点为0',
  `parents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `priority` smallint(6) NOT NULL DEFAULT '100' COMMENT '优先级',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
-- Records of pd_category
-- ----------------------------
BEGIN;
INSERT INTO `pd_category` VALUES (0, '主营分类', 'ROOT', 0, -1, '', '', 100, '2019-09-18 00:15:14', '2019-09-18 00:15:18');
INSERT INTO `pd_category` VALUES (13, '帽子1', 'head', 1, 0, '0', 'c1/67ea0eeac8592c94/5d87a593772e58a2b25f9db9.jpg', 10, '2019-09-14 11:38:23', '2019-09-22 11:47:39');
INSERT INTO `pd_category` VALUES (14, '礼帽', 'LMO', 2, 13, '0,13', 'c1/67ea0eeac8592c94/5d88dd04772e58a2b25f9dbf.jpeg', 10, '2019-09-17 05:21:59', '2019-09-23 09:58:13');
INSERT INTO `pd_category` VALUES (15, '毛织w', 'MZI', 3, 14, '0,13,14', 'c1/67ea0eeac8592c94/5d88dd91772e58a2b25f9dc0.jpeg', 100, '2019-09-16 23:24:19', '2019-09-23 09:58:35');
INSERT INTO `pd_category` VALUES (16, '衣服1', '90', 1, 0, '0', 'c1/6ba0b6dc92109df9/5d945c7f7a6c7d859e9c7f62.jpeg', 90, '2019-10-02 03:15:05', '2019-10-02 03:15:05');
COMMIT;

-- ----------------------------
-- Table structure for pd_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `pd_category_attribute`;
CREATE TABLE `pd_category_attribute` (
  `id` int(11) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for pd_category_attribute_model
-- ----------------------------
DROP TABLE IF EXISTS `pd_category_attribute_model`;
CREATE TABLE `pd_category_attribute_model` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for pd_category_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pd_category_attribute_value`;
CREATE TABLE `pd_category_attribute_value` (
  `id` int(11) NOT NULL,
  `attribute_id` int(11) DEFAULT NULL,
  `attribute_model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for pd_category_custom
-- ----------------------------
DROP TABLE IF EXISTS `pd_category_custom`;
CREATE TABLE `pd_category_custom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cate_name` varchar(32) NOT NULL COMMENT '分类名称',
  `i18n` varchar(32) DEFAULT NULL COMMENT '国际化',
  `level` tinyint(2) NOT NULL COMMENT '分类级别',
  `parent_id` int(11) DEFAULT NULL COMMENT '父分类、根节点为0',
  `parents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `priority` smallint(6) NOT NULL DEFAULT '100' COMMENT '优先级',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
-- Records of pd_category_custom
-- ----------------------------
BEGIN;
INSERT INTO `pd_category_custom` VALUES (0, '根节点', 'ROOT', 0, -1, NULL, NULL, 100, '2019-09-19 01:06:58', '2019-09-19 01:06:48', 0, 0);
INSERT INTO `pd_category_custom` VALUES (14, '衣服', 'col', 1, 0, '0', 'c2/9123b9ead6156521/5d88f4ed772e998d85eff40b.jpeg', 10, '2019-09-18 10:38:09', '2019-09-23 11:38:16', 3, 6);
INSERT INTO `pd_category_custom` VALUES (15, '裤子', 'kuzi', 1, 0, '0', 'c2/9123b9ead6156521/5d88f5db772e998d85eff40d.jpeg', 10, '2019-09-18 10:38:31', '2019-09-23 11:42:12', 3, 6);
INSERT INTO `pd_category_custom` VALUES (16, 'neiku1', 'neiku', 1, 0, '0', 'c2/9123b9ead6156521/5d88f609772e998d85eff40f.jpeg', 1, '2019-09-17 21:41:12', '2019-09-23 11:43:01', 3, 6);
INSERT INTO `pd_category_custom` VALUES (19, '衣服12', '11', 1, 0, '0', 'c2/9123b9ead6156521/5d88f5eb772e998d85eff40e.jpeg', 2, '2019-09-18 23:45:43', '2019-09-23 11:42:38', 3, 6);
INSERT INTO `pd_category_custom` VALUES (20, 'T', 'T', 2, 14, '0,14', 'c2/9123b9ead6156521/5d88f5cd772e998d85eff40c.jpeg', 11, '2019-09-18 23:46:02', '2019-09-23 11:41:54', 3, 6);
INSERT INTO `pd_category_custom` VALUES (21, '衣服11', 'ODK', 2, 19, '0,19', 'c2/9123b9ead6156521/5d88f647772e998d85eff410.jpeg', 10, '2019-09-23 11:43:59', '2019-09-23 11:43:59', 3, 6);
COMMIT;

-- ----------------------------
-- Table structure for pd_product
-- ----------------------------
DROP TABLE IF EXISTS `pd_product`;
CREATE TABLE `pd_product` (
  `id` bigint(11) unsigned NOT NULL COMMENT '主键',
  `alias` varchar(32) NOT NULL COMMENT '别名',
  `shop_id` bigint(11) NOT NULL COMMENT '店铺id',
  `status` tinyint(2) unsigned NOT NULL COMMENT '可用状态 0=不可用 1=可用',
  `title` varchar(255) NOT NULL COMMENT '商品标题',
  `summary` varchar(255) NOT NULL COMMENT '商品副标题',
  `cid` bigint(11) NOT NULL COMMENT '商品分类id',
  `pic_urls` varchar(255) NOT NULL COMMENT '商品图片地址',
  `prod_type` tinyint(2) unsigned NOT NULL COMMENT '商品类型 1=普通商品 2=预购',
  `sale_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '销售类型 1=自营 2=商家',
  `sales_volume` int(11) NOT NULL COMMENT '销量',
  `origin_price` bigint(11) NOT NULL COMMENT '原价',
  `price` bigint(11) NOT NULL COMMENT '价格',
  `art_no` varchar(64) DEFAULT NULL COMMENT '商品货号',
  `is_show_stock` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '是否显示库存 0=否 1=是',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '总库存',
  `delivery_fee_type` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '运费类型 1=统一运费 2=运费模板',
  `delivery_fee` bigint(11) NOT NULL DEFAULT '0' COMMENT '运费',
  `delivery_temp_id` bigint(11) DEFAULT NULL COMMENT '运费模板',
  `sale_status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '销售状态 1=上架 2=下架',
  `priority` smallint(5) unsigned NOT NULL COMMENT '排序分数，最大越前',
  `is_del` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `auto_putaway_time` datetime DEFAULT NULL COMMENT '自动上架时间',
  `message_json` varchar(255) NOT NULL COMMENT '留言配置',
  `brand_id` bigint(11) DEFAULT NULL COMMENT '品牌',
  `is_pre` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否预购 0 否 1 是',
  `ext_id` bigint(11) NOT NULL COMMENT '扩展功能id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Table structure for pd_product_content
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_content`;
CREATE TABLE `pd_product_content` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `temp_id` int(11) NOT NULL COMMENT '模板id',
  `temp_data` varchar(1000) NOT NULL COMMENT '模板数据',
  `intro` varchar(10000) NOT NULL COMMENT '商品描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情';

-- ----------------------------
-- Table structure for pd_product_content_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_content_snapshot`;
CREATE TABLE `pd_product_content_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_ext
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_ext`;
CREATE TABLE `pd_product_ext` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_ext_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_ext_snapshot`;
CREATE TABLE `pd_product_ext_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku`;
CREATE TABLE `pd_product_sku` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `status` tinyint(2) NOT NULL COMMENT '可以状态 0=不可用 1=可用',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `props` varchar(255) NOT NULL COMMENT '商品规格',
  `item_no` varchar(64) DEFAULT NULL COMMENT '商品货号',
  `price` int(11) NOT NULL COMMENT '价格',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量',
  `forze_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '未付款冻结的库存',
  `sale_volume` int(11) NOT NULL COMMENT '销量',
  `heading_code` varchar(64) DEFAULT NULL COMMENT '识别码',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格';

-- ----------------------------
-- Table structure for pd_product_sku_prop
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku_prop`;
CREATE TABLE `pd_product_sku_prop` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prop_name` varchar(32) NOT NULL COMMENT '属性名称',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `user_id` int(11) NOT NULL COMMENT '用户',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格属性';

-- ----------------------------
-- Table structure for pd_product_sku_prop_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku_prop_snapshot`;
CREATE TABLE `pd_product_sku_prop_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_sku_prop_val
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku_prop_val`;
CREATE TABLE `pd_product_sku_prop_val` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `prop_id` int(11) NOT NULL COMMENT '属性id',
  `prop_val` varchar(32) NOT NULL COMMENT '规格值',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格值表';

-- ----------------------------
-- Table structure for pd_product_sku_prop_val_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku_prop_val_snapshot`;
CREATE TABLE `pd_product_sku_prop_val_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_sku_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_sku_snapshot`;
CREATE TABLE `pd_product_sku_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_snapshot`;
CREATE TABLE `pd_product_snapshot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pd_product_tag
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_tag`;
CREATE TABLE `pd_product_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int(11) unsigned NOT NULL COMMENT '商品id',
  `tag_id` int(11) unsigned NOT NULL COMMENT '标签id',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '可用状态 0=不可用 1=可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品标签关系表';

-- ----------------------------
-- Table structure for pd_product_temp
-- ----------------------------
DROP TABLE IF EXISTS `pd_product_temp`;
CREATE TABLE `pd_product_temp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alias` varchar(32) NOT NULL COMMENT '别名',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `is_show` tinyint(2) unsigned NOT NULL COMMENT '是否显示 0=否 1=是',
  `status` tinyint(2) unsigned NOT NULL COMMENT '可用状态 0=不可用  1=可用',
  `temp_json` varchar(1000) NOT NULL COMMENT '模板数据',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `gmt_delete` datetime NOT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品模板';

-- ----------------------------
-- Table structure for pd_tag
-- ----------------------------
DROP TABLE IF EXISTS `pd_tag`;
CREATE TABLE `pd_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alias` varchar(32) NOT NULL COMMENT '别名',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `tag_name` varchar(16) NOT NULL COMMENT '名称',
  `status` tinyint(2) unsigned NOT NULL COMMENT '可用状态 0=不可用 1=可用',
  `tag_type` tinyint(2) unsigned NOT NULL COMMENT '标签类型 1=自定义 2=其他 3=最新商品 4=最热商品 4=隐藏',
  `item_count` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分组';

-- ----------------------------
-- Table structure for scm_delivery
-- ----------------------------
DROP TABLE IF EXISTS `scm_delivery`;
CREATE TABLE `scm_delivery` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `delivery_name` varchar(60) NOT NULL COMMENT '物流名称',
  `is_show` tinyint(2) NOT NULL DEFAULT '1' COMMENT '是否显示 0=否 1=是',
  `status` tinyint(2) NOT NULL COMMENT '可用状态 0=不可用 2=可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流表';

-- ----------------------------
-- Table structure for scm_delivery_order
-- ----------------------------
DROP TABLE IF EXISTS `scm_delivery_order`;
CREATE TABLE `scm_delivery_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nu` varchar(64) NOT NULL COMMENT '快递单号',
  `delivery_id` int(11) unsigned NOT NULL COMMENT '物流',
  `delivery_data` varchar(1000) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '状态 0=不可用 1=可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流单';

-- ----------------------------
-- Table structure for scm_delivery_temp
-- ----------------------------
DROP TABLE IF EXISTS `scm_delivery_temp`;
CREATE TABLE `scm_delivery_temp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `res_name` varchar(30) NOT NULL COMMENT '资源名',
  `res_type` tinyint(2) unsigned NOT NULL COMMENT '资源类型  1 菜单 、2 按钮',
  `parent_id` int(11) unsigned NOT NULL COMMENT '父id',
  `i18n` varchar(60) DEFAULT NULL COMMENT '国际化',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `parents` varchar(100) NOT NULL COMMENT '父路径',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '状态 0不可用、1可用',
  `is_del` tinyint(2) unsigned NOT NULL COMMENT '是否删除 0否、1是',
  `res_path` varchar(255) NOT NULL COMMENT '资源路径',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(16) NOT NULL COMMENT '角色名',
  `show_name` varchar(30) DEFAULT NULL COMMENT '显示的名称',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '可用状态 0不可用 、1可用',
  `is_del` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 否 1是',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `res_id` int(11) unsigned NOT NULL COMMENT '资源id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_res` (`role_id`,`res_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源映射表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(16) NOT NULL COMMENT '加密',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(16) DEFAULT NULL COMMENT '昵称',
  `status` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '状态 0不可用、1可用',
  `is_del` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0否、1是',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_name` (`username`) USING BTREE,
  UNIQUE KEY `uk_mobile` (`mobile`) USING BTREE,
  UNIQUE KEY `uk_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'luma', '18718418728', '123456', '123456', 'qhchen96@gmail.com', '陈钦浩', '鹿马', 1, 0, '2019-05-05 00:28:45', '2019-05-05 00:28:49');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_role` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Table structure for td_customer
-- ----------------------------
DROP TABLE IF EXISTS `td_customer`;
CREATE TABLE `td_customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Table structure for td_oauth_client
-- ----------------------------
DROP TABLE IF EXISTS `td_oauth_client`;
CREATE TABLE `td_oauth_client` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `redirect_uri` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `client_secret` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `resources` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_client_id` (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for td_shop
-- ----------------------------
DROP TABLE IF EXISTS `td_shop`;
CREATE TABLE `td_shop` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL COMMENT '店铺名称',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `user_id` int(11) unsigned DEFAULT NULL,
  `is_del` tinyint(2) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `service_phone` varchar(255) DEFAULT NULL COMMENT '客服电话',
  `service_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客服时间',
  `contacts` varchar(255) DEFAULT NULL COMMENT '联系人',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `website` varchar(255) DEFAULT NULL COMMENT '网址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of td_shop
-- ----------------------------
BEGIN;
INSERT INTO `td_shop` VALUES (3, '鹿马旗舰店', '2019-07-14 10:29:57', '2019-07-14 10:29:57', 6, 0, 0, 'https://ecmb.bdimg.com/tam-ogel/299c55e31d7f50ae4dc85faa90d6f445_121_121.jpg', 'qhchen96@gamil.com', '广州', '13800138000', '00:00-02:00', '陈', '帽子，鞋子', '超级无敌', 'http://www.khetao.com', '鹿马旗舰店');
COMMIT;

-- ----------------------------
-- Table structure for td_shop_auth
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_auth`;
CREATE TABLE `td_shop_auth` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(11) unsigned NOT NULL COMMENT '前端用户id',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '加密盐',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `mobile_code` varchar(10) DEFAULT NULL COMMENT '国际区号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `status` tinyint(2) unsigned NOT NULL COMMENT '状态 0不可用、1可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile_mobile_code` (`mobile`,`mobile_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='本地登录表';

-- ----------------------------
-- Records of td_shop_auth
-- ----------------------------
BEGIN;
INSERT INTO `td_shop_auth` VALUES (1, 3, '$2a$10$5yn/jylaXQP6znGTkMu2l.z5/sXugWbsBlH2VPSqKUchepd8ZRJ0G', 'khetao', NULL, NULL, 'elo0096@163.com', NULL, 0, '2019-07-14 10:29:57', '2019-07-14 10:29:57');
INSERT INTO `td_shop_auth` VALUES (2, 6, '$2a$10$XeoPF2zkhFN8lZJY2Q.piucGe8ty/KLlaL9fFwmXbZhE4hisQn2Pq', 'khetao', NULL, NULL, 'qhchen96@gmail.com', NULL, 1, '2019-07-15 12:15:06', '2019-07-15 12:15:06');
COMMIT;

-- ----------------------------
-- Table structure for td_shop_auth_thirdparty
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_auth_thirdparty`;
CREATE TABLE `td_shop_auth_thirdparty` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '前端用户id',
  `app_name` varchar(20) NOT NULL COMMENT '应用名称',
  `app_id` varchar(64) NOT NULL COMMENT '应用id',
  `access_token` varchar(128) NOT NULL COMMENT '令牌',
  `refresh_token` varchar(128) DEFAULT NULL COMMENT '刷新令牌',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 0 保密 1 男 2 女',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_id_app_name` (`user_id`,`app_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方登录表';

-- ----------------------------
-- Table structure for td_shop_factory
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_factory`;
CREATE TABLE `td_shop_factory` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for td_shop_resource
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_resource`;
CREATE TABLE `td_shop_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `res_name` varchar(30) NOT NULL COMMENT '资源名称',
  `res_type` tinyint(2) NOT NULL COMMENT '资源类型 1=菜单 2=功能',
  `parent_id` int(11) NOT NULL COMMENT '上级',
  `parents` varchar(100) NOT NULL COMMENT '上级路径',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '可用状态 0=不可用 1=可用',
  `is_del` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `res_path` varchar(255) NOT NULL COMMENT '资源路径',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家资源表';

-- ----------------------------
-- Table structure for td_shop_role
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_role`;
CREATE TABLE `td_shop_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(16) NOT NULL COMMENT '角色名称',
  `show_name` varchar(30) NOT NULL COMMENT '显示名',
  `intro` varchar(100) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) unsigned NOT NULL COMMENT '可用状态 0=不可用 1=可用',
  `is_del` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商家角色表';

-- ----------------------------
-- Records of td_shop_role
-- ----------------------------
BEGIN;
INSERT INTO `td_shop_role` VALUES (1, 'ROLE_ADMIN', 'admin', '管理员', 1, 0, '2019-07-14 12:23:42', '2019-07-14 12:23:42');
INSERT INTO `td_shop_role` VALUES (2, 'ROLE_USER', 'user', '用户', 1, 0, '2019-07-15 12:06:29', '2019-07-15 12:06:29');
COMMIT;

-- ----------------------------
-- Table structure for td_shop_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_role_resource`;
CREATE TABLE `td_shop_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) unsigned NOT NULL COMMENT '商家角色表',
  `res_id` int(11) unsigned NOT NULL COMMENT '商家资源id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家角色资源表';

-- ----------------------------
-- Table structure for td_shop_user
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_user`;
CREATE TABLE `td_shop_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `mobile_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国际区号',
  `status` tinyint(2) NOT NULL COMMENT '状态 0不可用、1可用',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `is_del` tinyint(2) NOT NULL COMMENT '是否删除 0否、1是',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别 0=保密 1=男 2=女',
  `signature` varchar(200) DEFAULT NULL COMMENT '签名',
  `nick_name` varchar(30) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `shop_count` tinyint(2) unsigned zerofill DEFAULT '00' COMMENT '店铺数量',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='店铺用户id';

-- ----------------------------
-- Records of td_shop_user
-- ----------------------------
BEGIN;
INSERT INTO `td_shop_user` VALUES (3, 'elo0096@163.com', NULL, NULL, 1, NULL, 0, 0, NULL, '鹿马', NULL, NULL, '2019-07-14 10:29:57', '2019-07-14 10:29:57', 00, NULL);
INSERT INTO `td_shop_user` VALUES (6, 'qhchen96@gmail.com', NULL, NULL, 1, NULL, 0, 0, NULL, '壳桃科技', NULL, NULL, '2019-07-15 12:15:05', '2019-07-15 12:15:05', 00, 'avatar/ec5ec0a93577f768/5d86f1557a6cc128b1dbc388.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for td_shop_user_role
-- ----------------------------
DROP TABLE IF EXISTS `td_shop_user_role`;
CREATE TABLE `td_shop_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '商家id',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商家用户角色表';

-- ----------------------------
-- Records of td_shop_user_role
-- ----------------------------
BEGIN;
INSERT INTO `td_shop_user_role` VALUES (2, 6, 1, '2019-07-15 21:59:12', '2019-07-15 21:59:12');
INSERT INTO `td_shop_user_role` VALUES (3, 6, 2, '2019-07-16 01:06:52', '2019-07-16 01:06:52');
COMMIT;

-- ----------------------------
-- Table structure for td_trade
-- ----------------------------
DROP TABLE IF EXISTS `td_trade`;
CREATE TABLE `td_trade` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `type` tinyint(3) unsigned NOT NULL COMMENT '订单类型',
  `status` tinyint(3) unsigned NOT NULL COMMENT '状态 0=不可以 1=可用',
  `close_type` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '关闭类型 0=正常 1=超时未支付 2=退款关闭 4=买家取消 15=已通过活到付款交易',
  `close_time` datetime DEFAULT NULL,
  `quantity` int(11) unsigned NOT NULL COMMENT '购买数量',
  `kind` smallint(6) NOT NULL COMMENT '种类',
  `trade_status` tinyint(4) NOT NULL COMMENT '交易状态 ',
  `trade_no` varchar(64) NOT NULL COMMENT '订单编号',
  `shop_name` varchar(122) NOT NULL COMMENT '店铺名称',
  `buyer_id` int(11) NOT NULL COMMENT '买家id',
  `buyer_memo` varchar(255) DEFAULT NULL COMMENT '买家留言',
  `pic_path` varchar(255) NOT NULL COMMENT '图片途径，多个用逗号分割',
  `title` varchar(255) NOT NULL COMMENT '标题，多个商品时默认第一个',
  `receiver_address_id` int(11) DEFAULT NULL COMMENT '收货地址id',
  `receiver_name` varchar(122) NOT NULL COMMENT '收货人姓名',
  `receiver_address` varchar(122) NOT NULL COMMENT '详细地址',
  `receiver_place` varchar(122) NOT NULL COMMENT '地区',
  `region_id` int(11) NOT NULL COMMENT '地区编号',
  `receiver_postcode` varchar(30) NOT NULL COMMENT '邮编',
  `delivery_type` tinyint(4) NOT NULL COMMENT '物流方式 1快递、2自提',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `deal_time` datetime DEFAULT NULL COMMENT '成交时间',
  `trade_memo` varchar(255) DEFAULT NULL COMMENT '卖家备注',
  `seller_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '备注星标 1-5',
  `transaction_id` int(11) DEFAULT NULL COMMENT '支付交易号',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_type` tinyint(4) DEFAULT NULL COMMENT '支付类型 1=微信 2=支付宝 3=银行支付',
  `pay_serial_no` varchar(64) DEFAULT NULL COMMENT '支付流水号',
  `delivery_fee` int(11) NOT NULL DEFAULT '0' COMMENT '运费',
  `discount_amount` int(11) NOT NULL DEFAULT '0' COMMENT '优惠总额',
  `discount` varchar(255) DEFAULT NULL COMMENT '优惠信息',
  `total_amount` int(11) NOT NULL COMMENT '总金额',
  `actual_amount` int(11) DEFAULT NULL COMMENT '实付金额',
  `refunded_amount` int(11) DEFAULT '0' COMMENT '退款金额',
  `bill_id` int(11) DEFAULT NULL COMMENT '发票id',
  `is_bill` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '是否开票 0=否 1=是',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易订单表';

-- ----------------------------
-- Table structure for td_trade_bill
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_bill`;
CREATE TABLE `td_trade_bill` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `trade_id` int(11) unsigned NOT NULL COMMENT '交易订单id',
  `bill_title` varchar(122) NOT NULL COMMENT '发票抬头',
  `tax_no` varchar(32) DEFAULT NULL COMMENT '纳税人识别号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(30) DEFAULT NULL COMMENT '电话',
  `bank_name` varchar(122) DEFAULT NULL COMMENT '开户行',
  `bank_account` varchar(64) DEFAULT NULL COMMENT '银行账号',
  `download_path` varchar(255) DEFAULT NULL COMMENT '下载路径',
  `make_type` tinyint(2) unsigned NOT NULL COMMENT '开票类型 1=纸质 2=电子',
  `bill_code` varchar(32) NOT NULL COMMENT '发票代码',
  `bill_no` varchar(32) NOT NULL COMMENT '发票号码',
  `bill_content` varchar(255) DEFAULT NULL COMMENT '发票内容',
  `delivery_no` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `delivery_name` varchar(32) DEFAULT NULL COMMENT '物流名称',
  `bill_amount` int(11) unsigned DEFAULT NULL COMMENT '发票金额',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票信息';

-- ----------------------------
-- Table structure for td_trade_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_cart_item`;
CREATE TABLE `td_trade_cart_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `status` tinyint(2) NOT NULL COMMENT '可用状态 0=不可用 1=可用',
  `buyer_id` int(11) unsigned DEFAULT NULL COMMENT '卖家id',
  `sign_code` varchar(255) DEFAULT NULL COMMENT '会话',
  `item_id` int(11) unsigned NOT NULL COMMENT '商品id',
  `sku_id` int(11) unsigned NOT NULL COMMENT '商品规格',
  `quantity` int(11) NOT NULL,
  `buyer_memo` varchar(255) NOT NULL COMMENT '买家评论',
  `trade_id` int(11) unsigned DEFAULT NULL COMMENT '交易单编号',
  `buyer_time` datetime DEFAULT NULL COMMENT '下单时间',
  `activity_id` int(11) unsigned DEFAULT NULL COMMENT '优惠信息',
  `activity_type` tinyint(4) DEFAULT NULL COMMENT '活动类型',
  `gmt_delete` datetime DEFAULT NULL COMMENT '删除时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modigy` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Table structure for td_trade_delivery_order
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_delivery_order`;
CREATE TABLE `td_trade_delivery_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `trade_id` int(11) NOT NULL COMMENT '订单id',
  `trade_detail_id` int(11) NOT NULL COMMENT '交易明细',
  `nu` varchar(64) NOT NULL COMMENT '快递单号',
  `delivery_id` int(11) NOT NULL COMMENT '快递编号',
  `status` tinyint(2) NOT NULL COMMENT '状态 0=不可用 1=可用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易发货快递订单';

-- ----------------------------
-- Table structure for td_trade_delivery_setting
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_delivery_setting`;
CREATE TABLE `td_trade_delivery_setting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delivery` tinyint(2) NOT NULL COMMENT '是否支持快递 0=不支持 1=支持',
  `calc_type` tinyint(2) NOT NULL COMMENT '计费方式 1=按商品累加 2=组合运费',
  `status` tinyint(2) NOT NULL COMMENT '状态 0=不可用 1=可用',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易物流设置表';

-- ----------------------------
-- Table structure for td_trade_delivery_temp
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_delivery_temp`;
CREATE TABLE `td_trade_delivery_temp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `temp_name` varchar(122) NOT NULL COMMENT '模板名称',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 0=不可用 1=可用',
  `use_count` int(11) NOT NULL DEFAULT '0' COMMENT '使用次数',
  `pay_type` tinyint(2) unsigned NOT NULL COMMENT '支付类型 1=买家  2=卖家',
  `valuation_type` tinyint(2) NOT NULL COMMENT '计算类型 1=按件 2=按重量 3=按体积',
  `valuation_rules` varchar(1000) NOT NULL COMMENT '运费规则',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `gmt_delete` datetime NOT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运费模板';

-- ----------------------------
-- Table structure for td_trade_detail
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_detail`;
CREATE TABLE `td_trade_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) unsigned NOT NULL COMMENT '店铺id',
  `trade_id` int(11) unsigned NOT NULL COMMENT '交易单号',
  `status` tinyint(4) NOT NULL COMMENT '可用状态 0=不可用 1=可用',
  `item_id` int(11) unsigned NOT NULL COMMENT '商品编号',
  `title` varchar(255) NOT NULL COMMENT '商品标题',
  `pic_path` varchar(255) NOT NULL COMMENT '主图图片',
  `item_type` tinyint(4) NOT NULL COMMENT '商品类型 1=自营 2=第三方',
  `sku_id` int(11) unsigned NOT NULL COMMENT '商品sku',
  `sku_prop_name` varchar(255) NOT NULL COMMENT '商品规格名称',
  `price` int(11) NOT NULL COMMENT '单价',
  `quantity` int(11) unsigned NOT NULL COMMENT '数量',
  `snapshot_no` varchar(32) NOT NULL COMMENT '快照编号',
  `message_json` varchar(255) NOT NULL COMMENT '留言数据结构',
  `is_send` tinyint(3) unsigned NOT NULL COMMENT '是否发货 0=否 1=是',
  `sale_status` tinyint(4) DEFAULT NULL COMMENT '售后状态 1=正常 2=退款中 3=退款退货 12=已退款 13=已退款退货',
  `refunded_amount` int(11) DEFAULT '0' COMMENT '退款金额',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易明细';

-- ----------------------------
-- Table structure for td_trade_refund
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_refund`;
CREATE TABLE `td_trade_refund` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `trade_id` int(11) NOT NULL COMMENT '交易单',
  `trade_detail_id` int(11) DEFAULT NULL COMMENT '交易明细id',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `refund_type` tinyint(2) NOT NULL COMMENT '退款类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退款单';

-- ----------------------------
-- Table structure for td_trade_refund_delivery_order
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_refund_delivery_order`;
CREATE TABLE `td_trade_refund_delivery_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for td_trade_refund_message
-- ----------------------------
DROP TABLE IF EXISTS `td_trade_refund_message`;
CREATE TABLE `td_trade_refund_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
