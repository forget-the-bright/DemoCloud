package com.mr.wh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: PaymentController
 * @Author: User
 * @date: 2020.08.12 22:04
 * @version: 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
   private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry,serverPort: "+serverPort+"\t id"+id;
    }
}
