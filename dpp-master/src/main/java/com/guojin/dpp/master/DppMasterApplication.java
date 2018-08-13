package com.guojin.dpp.master;

import com.guojin.dpp.server.dto.ConfigDTO;
import com.guojin.dpp.server.model.ConfigPO;
import com.guojin.dpp.server.model.ConfigTransfer;
import com.guojin.dpp.server.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @describe: 启动类
 * @author: guojin
 * @date: 2018/8/2 19:32
 **/
@SpringBootApplication(scanBasePackages = {
        "com.guojin.dpp.*"
})
@ImportResource({"classpath:mybatis-config.xml"})
public class DppMasterApplication {

    public static Map<String, Set<ConfigDTO>> GLOBAL_CONFIG_CACHE = new ConcurrentHashMap<>();

    @Autowired
    private ConfigService configService;

    public static void main(String[] args) {
        SpringApplication.run(DppMasterApplication.class, args);
    }


    /**
     * @describe: 启动时加载数据推送配置到内存
     * @date: 2018/8/13 16:44
     **/
    @PostConstruct
    public void loadConfigs4Map() {

        List<ConfigPO> configPOS = configService.getAllConfigInfo();
        if (CollectionUtils.isEmpty(configPOS)) {
            throw new IllegalArgumentException(String.format("记录为空"));
        }
        List<ConfigDTO> configDTOS = ConfigTransfer.poList2dtoList(configPOS);

        //获取用户集合
        Set<String> userSet = getUserSet(configDTOS);
        //加载配置到内存，便于快速读取配置信息
        loadGlobalConfigs(userSet, configDTOS);

        System.out.println("GLOBAL_CONFIG_CACHE:" + GLOBAL_CONFIG_CACHE);
    }

    private Set<String> getUserSet(List<ConfigDTO> configDTOS) {
        Set<String> userSet = new TreeSet<>();
        for (ConfigDTO configDTO : configDTOS) {
            userSet.add(configDTO.getUserId());
        }
        return userSet;
    }

    private void loadGlobalConfigs(Set<String> userSet, List<ConfigDTO> configDTOS) {
        for (String userId : userSet) {
            Set<ConfigDTO> configDTOSet = new HashSet<>();
            for (ConfigDTO configDTO : configDTOS) {
                if (userId.equals(configDTO.getUserId())) {
                    configDTOSet.add(configDTO);
                }
            }
            GLOBAL_CONFIG_CACHE.put(userId, configDTOSet);
        }
    }
}
