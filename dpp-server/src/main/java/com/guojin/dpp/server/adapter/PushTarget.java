package com.guojin.dpp.server.adapter;


import com.guojin.dpp.common.dto.MessageDTO;

/**
 * @describe: 具体推送的接口
 * @author: guojin
 * @date: 2018/8/13 18:48
 **/
public interface PushTarget {

    /**
     * @describe: 推送数据到指定url
     * @date: 2018/8/13 18:48
     **/
    String push(String url, MessageDTO messageDTO);
}
