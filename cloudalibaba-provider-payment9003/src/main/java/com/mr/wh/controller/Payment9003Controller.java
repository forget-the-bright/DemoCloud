package com.mr.wh.controller;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description:
 * @ClassName: Payment9003Controller
 * @Author: User
 * @date: 2020.08.21 15:26
 * @version: 1.0
 */
@RestController
public class Payment9003Controller {
    @Value("${server.port}")
    String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "1111111111111"));
        hashMap.put(2L, new Payment(2L, "2222222222222"));
        hashMap.put(3L, new Payment(3L, "3333333333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql, serverPort: " + serverPort, payment);
        return result;
    }
}
