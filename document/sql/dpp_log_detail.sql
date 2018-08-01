CREATE TABLE `dpp_log_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户外键',
  `gmt_create` datetime DEFAULT NULL COMMENT '当前推送时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最后修改时间',
  `push_duration` int(11) DEFAULT NULL COMMENT '推送耗时',
  `push_url` varchar(150) DEFAULT NULL COMMENT '推送地址',
  `param` longtext COMMENT '推送参数（json格式）',
  `class_path` varchar(100) DEFAULT NULL COMMENT '适配器类路径',
  `is_failed` varchar(2) DEFAULT NULL COMMENT '推送是否失败',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;