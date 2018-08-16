package com.guojin.dpp.server.handler;

import com.guojin.dpp.common.cache.ConfigCache;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.common.dto.MessageDTO;
import com.guojin.dpp.server.adapter.AdapterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @describe: 消息处理器
 * @author: guojin
 * @date: 2018/8/16 12:43
 **/
@Component
public class MessageHandler {

    private MessageHandler(){}

    private static class MessageHandlerInstanceHolder{
        private static MessageHandler messageHandler = new MessageHandler();
    }

    public static MessageHandler getInstance(){
        return MessageHandlerInstanceHolder.messageHandler;
    }


    private final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    /**
     * 线程池配置
     */
    private static ExecutorService executorService;

    /**
     * @describe: 使用线程池技术进行消息推送
     * @date: 2018/8/15 18:06
     **/
    public void sendMessage(MessageDTO messageDTO) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String userId = messageDTO.getUserId();
                String type = messageDTO.getDataSourceType();
                String subject = messageDTO.getDataSourceSubject();
                Set<ConfigDTO> configDTOSet = ConfigCache.GLOBAL_CONFIG_CACHE.get(userId);
                Iterator<ConfigDTO> iterator = configDTOSet.iterator();
                while (iterator.hasNext()) {
                    ConfigDTO configDTO = iterator.next();
                    if (configDTO.getDataSourceSubject().equals(subject)
                            && configDTO.getDataSourceType() == Integer.parseInt(type)
                            && configDTO.getStatus() == 0) {
                        String url = configDTO.getUrl();
                        String classPath = configDTO.getAdapterDTO().getClassPath();
                        Object result = AdapterFactory.getAdapterInstance().getPushTarget(classPath).push(url, messageDTO);
                        logger.info("推送数据的返回值为：" + result);
                    }
                }
            }
        });

    }

    public static  void setExecutorService(ExecutorService executorService){
        MessageHandler.executorService = executorService;
    }
}
