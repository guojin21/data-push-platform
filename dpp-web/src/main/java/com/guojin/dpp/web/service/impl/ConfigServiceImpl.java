package com.guojin.dpp.web.service.impl;


import com.guojin.dpp.web.dao.ConfigPOMapper;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigPOExample;
import com.guojin.dpp.web.model.ConfigTransfer;
import com.guojin.dpp.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    @Override
    public List<ConfigPO> getConfigsByUserId(String userId) {
        ConfigPOExample example = new ConfigPOExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return configPoMapper.selectByExample(example);
    }

    @Override
    public boolean updateConfig(ConfigDTO configDTO) {
        ConfigPOExample example = new ConfigPOExample();
        example.createCriteria().andIdEqualTo(configDTO.getId());
        Date now = new Date();
        ConfigPO configPo = ConfigTransfer.dto2po(configDTO);
        configPo.setGmtModified(now);
        int resultCode = configPoMapper.updateByExampleSelective(configPo,example);
        return resultCode > 0 ? true : false;
    }

    @Override
    public boolean deleteConfig(Long configId) {
        int resultCode = configPoMapper.deleteByPrimaryKey(configId);
        return resultCode > 0 ? true : false;
    }

    @Override
    public List<ConfigPO> getAllConfigInfo() {
        ConfigPOExample example = new ConfigPOExample();
        return configPoMapper.selectByExample(example);
    }
}
