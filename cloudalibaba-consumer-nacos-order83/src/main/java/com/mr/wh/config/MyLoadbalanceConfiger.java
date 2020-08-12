package com.mr.wh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @ClassName: MyLoadbalanceConfiger
 * @Author: User
 * @date: 2020.08.12 22:30
 * @version: 1.0
 */
@Configuration
public class MyLoadbalanceConfiger {
    //Nacos自带Ribbon，引入RestTemplate
    @Bean
    @LoadBalanced //RestTemplate结合Ribbon做负载均衡一定要加@LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}

