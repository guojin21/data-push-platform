package com.guojin.dpp.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.guojin.dpp.master",
        "com.guojin.dpp.web.*",
}
)
public class DppMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DppMasterApplication.class, args);
    }
}
