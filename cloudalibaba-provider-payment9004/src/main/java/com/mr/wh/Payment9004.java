package com.mr.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @ClassName: Payment9004
 * @Author: User
 * @date: 2020.08.21 15:32
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9004.class, args);
    }
}
