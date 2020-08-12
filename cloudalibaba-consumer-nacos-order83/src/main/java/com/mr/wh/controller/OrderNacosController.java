package com.mr.wh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: OrderNacosController
 * @Author: User
 * @date: 2020.08.12 22:32
 * @version: 1.0
 */
@RestController
public class OrderNacosController {
    @Value("${service-url.nacos-user-service}")
    private String serverURl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return  restTemplate.getForObject(serverURl+"/payment/nacos/"+id, String.class);
    }
}
