package com.mr.wh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @ClassName: MyConfig
 * @Author: User
 * @date: 2020.08.21 15:37
 * @version: 1.0
 */
@Configuration
public class MyConfig {
   @Bean
   @LoadBalanced
    public RestTemplate restTemplate(){
       return  new RestTemplate();
   }
}
