package com.mr.wh.controller;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import com.mr.wh.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = service.create(payment);
        log.info("********插入结果:"+payment);
        if (result>0){
            return new CommonResult(200,"插入数据库成功: d=====(￣▽￣*)b  ε=ε=ε=(~￣▽￣)~  serverPort:  "+serverPort+"  (❤ ω ❤)  "+payment,result);
        }else{
             return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        log.info("********查询结果:"+payment);
        if (null!=payment){
             return new CommonResult(200,"查询数据库成功,serverPort:  "+serverPort+"  (❤ ω ❤)  ",payment);
        }else{
             return new CommonResult(444,"查询数据库失败,查询id:"+id,null);
        }
    }
    @GetMapping(value = "payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service:
                services) {
            log.info("**********"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:
             instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return  discoveryClient;
    }

    @GetMapping(value = "payment/lb")
    public String lb(){

       return serverPort+"";
    }

    @GetMapping(value = "payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort+"";
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi i am paymentZipkin server fall back,welcome to mingrui,d=====(￣▽￣*)b";
    }
}
