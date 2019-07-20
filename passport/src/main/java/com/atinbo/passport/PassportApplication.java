package com.atinbo.passport;

import com.atinbo.mvc.AtinboMvcConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * 登录服务
 *
 * @author breggor
 */
@Slf4j
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atinbo.user")
@SpringBootApplication(scanBasePackageClasses = {PassportApplication.class, AtinboMvcConfig.class})
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




