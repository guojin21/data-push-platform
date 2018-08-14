package com.guojin.dpp.master;

import com.guojin.dpp.common.cache.ConfigCache;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigTransfer;
import com.guojin.dpp.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

/**
 * @describe: 启动类
 * @author: guojin
 * @date: 2018/8/2 19:32
 **/
@SpringBootApplication(scanBasePackages = {
        "com.guojin.dpp.*"
})
@ImportResource({"classpath:mybatis-config.xml"})
@EnableScheduling
public class DppMasterApplication {

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
        Set<String> userSet = ConfigCache.getUserSet(configDTOS);
        //加载配置到内存，便于快速读取配置信息
        ConfigCache.loadGlobalConfigs(userSet, configDTOS);

        System.out.println("GLOBAL_CONFIG_CACHE:" +  ConfigCache.GLOBAL_CONFIG_CACHE);
    }


}
