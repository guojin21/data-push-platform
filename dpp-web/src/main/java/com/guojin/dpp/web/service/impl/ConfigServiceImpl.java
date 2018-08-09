package com.guojin.dpp.web.service.impl;


import com.guojin.dpp.web.dao.ConfigPOMapper;
import com.guojin.dpp.web.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigTransfer;
import com.guojin.dpp.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @describe: 推送配置管理接口实现
 * @author: guojin
 * @date: 2018/8/2 13:13
 **/
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigPOMapper configPoMapper;

    @Override
    public boolean addConfig(ConfigDTO configDTO) {
        Date now = new Date();
        ConfigPO configPo = ConfigTransfer.dto2po(configDTO);
        configPo.setGmtModified(now);
        configPo.setGmtCreate(now);
        int resultCode = configPoMapper.insert(configPo);
        return resultCode > 0 ? true : false;
    }

    @Override
    public ConfigPO getConfigInfoById(Long configId) {
        return configPoMapper.selectByPrimaryKey(configId);
    }
}
