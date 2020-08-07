package com.mr.wh.service;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//指定调用哪个微服务
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}") //那个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/feign/timeout") //那个地址
    String paymentFeignTimeout();
}
