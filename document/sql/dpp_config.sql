-- ----------------------------
-- Table structure for `dpp_config`
-- ----------------------------
CREATE TABLE `dpp_config` (
  `id` bigint(20) NOT NULL  AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户唯一标识（不同用户可进行不同的推送配置操作）',
  `name` varchar(50) DEFAULT NULL COMMENT '推送服务名称',
  `url` varchar(100) DEFAULT NULL COMMENT '推送地址',
  `status` int(11) DEFAULT NULL COMMENT '状态  0：开启推送  1：停止推送',
  `data_source_type` int(11) DEFAULT NULL COMMENT '数据来源类型（消息队列，数据采集工具等）',
  `data_source_subject` varchar(50) DEFAULT NULL COMMENT '数据来源主题（针对消息队列的主题）',
  `adapter_id` int(11) DEFAULT NULL COMMENT '推送适配器外键（支持定制化推送模式）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;