package com.atinbo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;

/**
 * 用户服务
 *
 * @author breggor
 */
@EnableCaching
@SpringCloudApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}