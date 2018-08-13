package com.guojin.dpp.server.adapter.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;

public class BaseAdapter {

    private static final Logger logger = LoggerFactory.getLogger(BaseAdapter.class);

    private static HttpHeaders headers = null;

    static {
        headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.setAccept(Arrays.asList(new MediaType[]{new MediaType("application", "json", Charset.forName("UTF-8"))}));
    }

    @Autowired
    protected RestTemplate restTemplate;


    protected String pushDataByREST(String url, String params, HttpMethod method) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers);
        logger.info("调用参数:" + requestEntity.toString());
        ResponseEntity<String> exchange = restTemplate.exchange(url, method, requestEntity, String.class);
        String responseResult = exchange == null ? "" : exchange.getBody();
        if (null == responseResult) {
            responseResult = "";
        }
        logger.info("调用返回结果:" + responseResult);
        return responseResult;
    }

}
