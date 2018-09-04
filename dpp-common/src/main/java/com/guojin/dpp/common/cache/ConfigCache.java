package com.guojin.dpp.common.cache;

import com.guojin.dpp.common.dto.ConfigDTO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @describe: 全局推送配置缓存类
 * @author: guojin
 * @date: 2018/8/14 17:19
 **/
public class ConfigCache {

    /**
     * 根据不同用户定制不同的推送形式
     */
    public static Map<String, Set<ConfigDTO>> GLOBAL_CONFIG_CACHE = new ConcurrentHashMap<>();

    public static Set<String> getUserSet(List<ConfigDTO> configDTOS) {
        Set<String> userSet = new TreeSet<>();
        for (ConfigDTO configDTO : configDTOS) {
            userSet.add(configDTO.getUserId());
        }
        return userSet;
    }

    public static void loadGlobalConfigs(Set<String> userSet, List<ConfigDTO> configDTOS) {
        for (String userId : userSet) {
            Set<ConfigDTO> configDTOSet = new HashSet<>();
            for (ConfigDTO configDTO : configDTOS) {
                if (userId.equals(configDTO.getUserId())) {
                    configDTOSet.add(configDTO);
                }
            }
            ConfigCache.GLOBAL_CONFIG_CACHE.put(userId, configDTOSet);
        }
    }
}
