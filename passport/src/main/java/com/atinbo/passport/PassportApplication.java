package com.atinbo.passport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.IOException;

/**
 * 登录服务
 *
 * @author 陈路嘉
 */
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atinbo.user")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PassportApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassportApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




