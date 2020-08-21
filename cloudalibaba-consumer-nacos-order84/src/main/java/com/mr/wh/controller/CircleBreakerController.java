package com.mr.wh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: CircleBreakerController
 * @Author: User
 * @date: 2020.08.21 15:38
 * @version: 1.0
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")//没有配置，如果没有配置的话，当出现参数id异常的话，这样会出现error page页面，给客户的体验不好
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")//fallback只负责业务异常，像下面的参数id传递4出现的错误，这是业务出现异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规，不负责业务代码出现的error page,但是可以在控制台设置异常数来避免出现error page
    //@SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")//既负责了业务异常，有控制了sentinel控制台配置违规，但是以blockHandler为主
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException  空指针异常...");
        }
        return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }
}
