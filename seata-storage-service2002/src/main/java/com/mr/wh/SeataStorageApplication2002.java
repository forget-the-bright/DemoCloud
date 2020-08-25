package com.mr.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @ClassName: SeataStorageApplication2002
 * @Author: User
 * @date: 2020.08.25 14:56
 * @version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataStorageApplication2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication2002.class, args);
    }
}
