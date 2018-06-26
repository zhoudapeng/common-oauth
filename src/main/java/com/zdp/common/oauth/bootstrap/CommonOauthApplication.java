package com.zdp.common.oauth.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zdp.common.oauth")
public class CommonOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonOauthApplication.class, args);
    }
}
