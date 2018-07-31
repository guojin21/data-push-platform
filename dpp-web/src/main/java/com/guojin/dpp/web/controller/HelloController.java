package com.guojin.dpp.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/v1/web", tags = "web-rest-api", description = "HelloController")
@RestController
public class HelloController {

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ApiOperation(value = "测试swagger", notes = "测试swagger")
    public String hello(){
        return "hello dpp";
    }

}
