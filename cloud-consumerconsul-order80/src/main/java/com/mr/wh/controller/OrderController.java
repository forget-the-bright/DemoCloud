package com.mr.wh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static final String  CONSUL_SERVER_URL="http://consul-provider-payment";
    @Value("${server.port}")
    private  String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/consul")
    public String testRest(){
        return restTemplate.getForObject(CONSUL_SERVER_URL+"/payment/consul",String.class);
    }

}
