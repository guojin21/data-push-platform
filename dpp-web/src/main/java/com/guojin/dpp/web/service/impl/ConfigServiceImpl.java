package com.guojin.dpp.web.service.impl;


import com.guojin.dpp.common.cache.ConfigCache;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.web.dao.ConfigPOMapper;
import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigPOExample;
import com.guojin.dpp.web.model.ConfigTransfer;
import com.guojin.dpp.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
        //通过回调获取刚入库记录的id
        long id = configPo.getId();
        if (resultCode > 0) {
            //获取该用户已有的配置集合并追加新的配置到内存
            configDTO.setId(id);
            ConfigCache.GLOBAL_CONFIG_CACHE.get(configDTO.getUserId()).add(configDTO);
        }
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
        boolean success = false;
        ConfigPOExample example = new ConfigPOExample();
        example.createCriteria().andIdEqualTo(configDTO.getId());
        Date now = new Date();
        ConfigPO configPo = ConfigTransfer.dto2po(configDTO);
        configPo.setGmtModified(now);
        int resultCode = configPoMapper.updateByExampleSelective(configPo,example);
        if (resultCode > 0) {
            //获取该用户已有的配置并删除
            Set<ConfigDTO> configSet =  ConfigCache.GLOBAL_CONFIG_CACHE.get(configDTO.getUserId());
            Iterator<ConfigDTO> iterator = configSet.iterator();
            while(iterator.hasNext()){
                ConfigDTO config = iterator.next();
                if(config.getUserId().equals(configDTO.getUserId()) && config.getId().equals(configDTO.getId())){
                    iterator.remove();
                }
            }
            //将修改后的新添加集合
            success = configSet.add(configDTO);
        }
        return success;
    }

    @Override
    public boolean deleteConfig(Long configId) {
        //获取该用户已有的配置集合并删除指定配置到内存
        ConfigPO configPO = getConfigInfoById(configId);
        ConfigDTO configDTO = ConfigTransfer.po2dto(configPO);
        Set<ConfigDTO> configSet =   ConfigCache.GLOBAL_CONFIG_CACHE.get(configDTO.getUserId());
        Iterator<ConfigDTO> iterator = configSet.iterator();
        while(iterator.hasNext()){
            ConfigDTO config = iterator.next();
            if(config.getUserId().equals(configDTO.getUserId()) && config.getId().equals(configDTO.getId())){
                iterator.remove();
            }
        }
        int resultCode = configPoMapper.deleteByPrimaryKey(configId);
        return resultCode > 0 ? true : false;
    }

    @Override
    public List<ConfigPO> getAllConfigInfo() {
        ConfigPOExample example = new ConfigPOExample();
        return configPoMapper.selectByExample(example);
    }
}
