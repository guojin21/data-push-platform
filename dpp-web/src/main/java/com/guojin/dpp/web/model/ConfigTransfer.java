package com.guojin.dpp.web.model;

import com.google.gson.Gson;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.common.dto.PushDataAdapterDTO;

import java.util.ArrayList;
import java.util.List;

public class ConfigTransfer {

    private static Gson gson = new Gson();

    public static ConfigPO dto2po(ConfigDTO dto){
        ConfigPO po = new ConfigPO();
        po.setId(dto.getId());
        po.setAdapter(gson.toJson(dto.getAdapterDTO()));
        po.setDataSourceSubject(dto.getDataSourceSubject());
        po.setDataSourceType(dto.getDataSourceType());
        po.setName(dto.getName());
        po.setUrl(dto.getUrl());
        po.setStatus(dto.getStatus());
        po.setUserId(dto.getUserId());
        return po;
    }


    public static ConfigDTO po2dto(ConfigPO po) {
        ConfigDTO dto = new ConfigDTO();
        dto.setId(po.getId());
        dto.setAdapterDTO(gson.fromJson(po.getAdapter(),PushDataAdapterDTO.class));
        dto.setDataSourceSubject(po.getDataSourceSubject());
        dto.setDataSourceType(po.getDataSourceType());
        dto.setName(po.getName());
        dto.setUrl(po.getUrl());
        dto.setStatus(po.getStatus());
        dto.setUserId(po.getUserId());
        return dto;
    }

    public static List<ConfigDTO> poList2dtoList(List<ConfigPO> configPOS) {
        List<ConfigDTO> dtos = new ArrayList<>();
        for (ConfigPO configPO : configPOS){
            dtos.add(po2dto(configPO));
        }
        return dtos;
    }
}
