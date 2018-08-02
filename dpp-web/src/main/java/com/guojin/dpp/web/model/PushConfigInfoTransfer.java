package com.guojin.dpp.web.model;

import com.google.gson.Gson;
import com.guojin.dpp.web.dto.ConfigInfoDTO;

public class PushConfigInfoTransfer {
    private static Gson gson = new Gson();

    public static PushConfigInfoPo configInfoDto2po(ConfigInfoDTO dto){
        PushConfigInfoPo pushConfigInfoPo = new PushConfigInfoPo();
        pushConfigInfoPo.setAdapterId(dto.getAdapterId());
        pushConfigInfoPo.setDataSourceSubject(dto.getDataSourceSubject());
        pushConfigInfoPo.setDataSourceType(dto.getDataSourceType());
        pushConfigInfoPo.setName(dto.getName());
        pushConfigInfoPo.setUrl(dto.getUrl());
        pushConfigInfoPo.setStatus(dto.getStatus());
        pushConfigInfoPo.setUserId(dto.getUserId());
        return pushConfigInfoPo;
    }


}
