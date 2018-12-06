package com.example.webmagic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@MapperScan(basePackages = "com.example.webmagic.dao")
@SpringBootApplication
public class WebmagicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmagicApplication.class, args);
    }
}
