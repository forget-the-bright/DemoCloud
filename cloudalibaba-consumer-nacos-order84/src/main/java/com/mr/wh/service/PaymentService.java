package com.mr.wh.service;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @ClassName: PaymentService
 * @Author: User
 * @date: 2020.08.21 19:33
 * @version: 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);


}
