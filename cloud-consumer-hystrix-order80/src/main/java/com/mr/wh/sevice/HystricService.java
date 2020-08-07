package com.mr.wh.sevice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = HystricFullbackService.class)
public interface HystricService {

    @GetMapping("/payment/hystrix/ok/{id}")
     String paymentHystric_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
     String paymentHystric_Timeout(@PathVariable("id") Integer id);

}
