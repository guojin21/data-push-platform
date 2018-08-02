package com.guojin.dpp.web.service.impl;


import com.guojin.dpp.web.dao.PushConfigInfoPoMapper;
import com.guojin.dpp.web.dto.ConfigInfoDTO;
import com.guojin.dpp.web.model.PushConfigInfoPo;
import com.guojin.dpp.web.model.PushConfigInfoTransfer;
import com.guojin.dpp.web.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @describe: 推送配置管理接口实现
 * @author: guojin
 * @date: 2018/8/2 13:13
 **/
@Service
public class ConfigServiceImpl implements IConfigService {

    @Autowired
    private PushConfigInfoPoMapper pushConfigInfoPoMapper;

    @Override
    public boolean addConfig(ConfigInfoDTO configInfoDTO) {
        PushConfigInfoPo pushConfigInfoPo = PushConfigInfoTransfer.configInfoDto2po(configInfoDTO);
        int resultCode = pushConfigInfoPoMapper.insert(pushConfigInfoPo);
        return resultCode > 0 ? true : false;
    }
}
