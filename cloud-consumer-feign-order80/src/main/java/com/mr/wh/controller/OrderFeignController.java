package com.mr.wh.controller;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import com.mr.wh.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService service;

    @RequestMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  service.getPaymentById(id);
    }

    @RequestMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return  service.paymentFeignTimeout();
    }

}
