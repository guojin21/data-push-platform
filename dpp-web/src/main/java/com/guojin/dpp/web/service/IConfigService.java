package com.guojin.dpp.web.service;

import com.guojin.dpp.web.dto.ConfigInfoDTO;

/**
 * @describe: 配置管理接口
 * @author: guojin
 * @date: 2018/8/2 12:45
 **/
public interface IConfigService {

    /**
     * @describe: 新增配置接口
     * @date: 2018/8/2 12:45
     **/
    boolean addConfig(ConfigInfoDTO configInfoDTO);
}
