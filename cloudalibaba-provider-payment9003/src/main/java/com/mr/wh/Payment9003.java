package com.mr.wh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @ClassName: Payment9003
 * @Author: User
 * @date: 2020.08.21 15:24
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003.class, args);
    }
}
