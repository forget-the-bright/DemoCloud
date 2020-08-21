package com.mr.wh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: RateLimitController
 * @Author: User
 * @date: 2020.08.20 22:15
 * @version: 1.0
 */
@RestController
public class RateLimitController {
    @GetMapping("/bySentinel")
    @SentinelResource(value = "bySentinel", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2020L, "serial001"));
    }
    public CommonResult handleException(BlockException exc){
        return new CommonResult(444, exc.getClass().getCanonicalName()+"\t 服务不可用");
    }
}
