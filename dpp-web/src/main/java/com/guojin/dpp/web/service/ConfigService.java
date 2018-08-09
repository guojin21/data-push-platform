package com.guojin.dpp.web.service;

import com.guojin.dpp.web.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;

/**
 * @describe: 配置管理接口
 * @author: guojin
 * @date: 2018/8/2 12:45
 **/
public interface ConfigService {

    /**
     * @describe: 新增配置接口
     * @date: 2018/8/2 12:45
     **/
    boolean addConfig(ConfigDTO configDTO);

    /**
     * @describe: 根据Id查询对应配置信息
     * @date: 2018/8/8 18:25
     **/
    ConfigPO getConfigInfoById(Long configId);
}
