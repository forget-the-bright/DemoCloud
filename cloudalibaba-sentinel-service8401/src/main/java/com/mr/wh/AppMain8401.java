package com.mr.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @ClassName: AppMain8401
 * @Author: User
 * @date: 2020.08.19 20:56
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class, args);
    }
}
