package com.guojin.dpp.web.model;

import com.guojin.dpp.web.dto.ConfigDTO;

public class ConfigTransfer {

    public static ConfigPO dto2po(ConfigDTO dto){
        ConfigPO configPo = new ConfigPO();
        configPo.setAdapterId(dto.getAdapterId());
        configPo.setDataSourceSubject(dto.getDataSourceSubject());
        configPo.setDataSourceType(dto.getDataSourceType());
        configPo.setName(dto.getName());
        configPo.setUrl(dto.getUrl());
        configPo.setStatus(dto.getStatus());
        configPo.setUserId(dto.getUserId());
        return configPo;
    }


    public static ConfigDTO po2dto(ConfigPO configPo) {
        ConfigDTO configDTO = new ConfigDTO();
        configDTO.setId(configPo.getId());
        configDTO.setAdapterId(configPo.getAdapterId());
        configDTO.setDataSourceSubject(configPo.getDataSourceSubject());
        configDTO.setDataSourceType(configPo.getDataSourceType());
        configDTO.setName(configPo.getName());
        configDTO.setUrl(configPo.getUrl());
        configDTO.setStatus(configPo.getStatus());
        configDTO.setUserId(configPo.getUserId());
        return configDTO;
    }
}
