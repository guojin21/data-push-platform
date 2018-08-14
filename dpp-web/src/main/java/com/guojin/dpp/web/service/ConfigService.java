package com.guojin.dpp.web.service;

import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;

import java.util.List;

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


    /**
     * @describe: 查询用户userId所有配置信息
     * @date: 2018/8/9 18:06
     **/
    List<ConfigPO> getConfigsByUserId(String userId);


    /**
     * @describe: 修改推送配置信息
     * @date: 2018/8/10 16:46
     **/
    boolean updateConfig(ConfigDTO configDTO);


    /**
     * @describe: 删除推送配置信息
     * @date: 2018/8/10 17:08
     **/
    boolean deleteConfig(Long configId);


    /**
     * @describe: 获取数据库所有配置信息
     * @date: 2018/8/13 16:57
     **/
    List<ConfigPO> getAllConfigInfo();
}
