package com.guojin.dpp.server.handler;

import com.guojin.dpp.common.cache.ConfigCache;
import com.guojin.dpp.common.dto.MessageDTO;
import com.guojin.dpp.server.adapter.AdapterFactory;
import com.guojin.dpp.common.dto.ConfigDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

public class MessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    public static void sendMessage(MessageDTO messageDTO) {
        process(messageDTO);
    }

    private static void process(MessageDTO messageDTO) {
        String userId = messageDTO.getUserId();
        String type = messageDTO.getDataSourceType();
        String subject = messageDTO.getDataSourceSubject();
        Set<ConfigDTO> configDTOSet = ConfigCache.GLOBAL_CONFIG_CACHE.get(userId);
        Iterator<ConfigDTO> iterator = configDTOSet.iterator();
        while (iterator.hasNext()) {
            ConfigDTO configDTO = iterator.next();
            if (configDTO.getDataSourceSubject().equals(subject)
                    && configDTO.getDataSourceType() == 0
                    && configDTO.getStatus() == 0) {
                String url = configDTO.getUrl();
                String classPath = configDTO.getAdapterDTO().getClassPath();
                Object result = AdapterFactory.getAdapterInstance().getPushTarget(classPath).push(url, messageDTO);
                logger.info("推送数据的返回值为：" + result);
            }
        }

    }
}
