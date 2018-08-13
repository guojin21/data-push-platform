package com.guojin.dpp.reciever.client;


import com.google.gson.Gson;
import com.guojin.dpp.common.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/target")
public class ApiTestController {
    private static final Logger logger = LoggerFactory.getLogger(ApiTestController.class);
    Gson gson = new Gson();

    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    public void testGet(MessageDTO param) {
        logger.debug("接口接收到的数据为:" + gson.toJson(param));
    }

    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    public void testPost(HttpServletRequest request) {
        logger.debug("test_post    ---    data:" + request.getParameter("data"));
    }
}
