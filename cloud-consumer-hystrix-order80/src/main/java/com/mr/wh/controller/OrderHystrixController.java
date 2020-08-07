package com.mr.wh.controller;

import com.mr.wh.sevice.HystricService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGolbal")
public class OrderHystrixController {

    @Resource
    private HystricService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentHystric_OK(@PathVariable("id") Integer id){
      /*  try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int a= 1/0;
        return  service.paymentHystric_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String paymentHystric_Timeout(@PathVariable("id") Integer id){
        String s = service.paymentHystric_Timeout(id);
        return s;
    }

    public String paymentTimeOutFallBackMethod(Integer id){
        return "我是消费者80，对方支付系统繁忙，请稍后再试，o(╥﹏╥)o";
    }
    public String paymentGolbal(){
        return "我是Golbal Exception，请稍后再试，o(╥﹏╥)o";
    }
}
