package com.guojin.dpp.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @describe: 启动类
 * @author: guojin
 * @date: 2018/8/2 19:32
 **/
@SpringBootApplication(scanBasePackages = {
        "com.guojin.dpp.*"
})
@ImportResource({"classpath:mybatis-config.xml"})
public class DppMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DppMasterApplication.class, args);
    }
}
