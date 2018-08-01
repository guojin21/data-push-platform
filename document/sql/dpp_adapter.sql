-- ----------------------------
-- Table structure for `dpp_adapter`
-- ----------------------------
CREATE TABLE `dpp_adapter` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '适配器名称',
  `class_path` varchar(100) DEFAULT NULL COMMENT '类路径',
  `file_path` varchar(100) DEFAULT NULL COMMENT 'jar文件路径（支持热部署）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;