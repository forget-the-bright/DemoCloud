package com.mr.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZkController {

    private static final String  ZK_SERVER_URL="http://cloud-provider-payment";
    @Value("${server.port}")
    private  String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/zk")
    public String testRest(){
        return restTemplate.getForObject(ZK_SERVER_URL+"/payment/zk",String.class);
    }
}
