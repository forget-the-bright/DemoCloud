package com.mr.wh.controller;

import com.mr.wh.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = service.PaymentInfo_OK(id);
        log.info("*******"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = service.PaymentInfo_Timeout(id);
        log.info("*******"+result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentInfo_circuit(@PathVariable("id") Integer id){
        String result = service.paymentCircuitBreaker(id);
        log.info("*******"+result);
        return result;
    }

}

