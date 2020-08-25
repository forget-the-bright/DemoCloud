package com.mr.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @ClassName: OrderSeataMain9001
 * @Author: User
 * @date: 2020.08.23 21:53
 * @version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
@EnableFeignClients
@EnableDiscoveryClient
public class OrderSeataMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataMain2001.class, args);
    }
}
