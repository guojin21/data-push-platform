package com.guojin.dpp.master.task;


import com.guojin.dpp.common.dto.MessageDTO;
import com.guojin.dpp.server.handler.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @describe: 数据产生来源----数据模拟分发器
 * @author: guojin
 * @date: 2018/8/14 18:09
 **/
@Component
public class SendMessageTimer {

    private static final Logger logger = LoggerFactory.getLogger(SendMessageTimer.class);


    /**
     * @describe: 定时模拟发送消息
     * @date: 2018/8/14 18:09
     **/
    @Scheduled(fixedRate = 5000)
    public void run(){
        logger.info("开始发送数据---");
        String message = "hello dpp";
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setBody(message);
        messageDTO.setDataSourceSubject("subject");
        messageDTO.setDataSourceType("0");
        messageDTO.setUserId("1001");
        MessageHandler.getInstance().sendMessage(messageDTO);
    }

}
