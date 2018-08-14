package com.guojin.dpp.server.adapter.product;

import com.google.gson.Gson;
import com.guojin.dpp.common.dto.MessageDTO;
import com.guojin.dpp.server.adapter.PushTarget;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class DefaultAdapter extends BaseAdapter implements PushTarget {

    @Override
    public String push(String url, MessageDTO messageDTO) {
        String param = new Gson().toJson(messageDTO);
        return pushDataByREST(url,param,HttpMethod.POST);
    }
}
