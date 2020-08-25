package com.mr.wh.service;

import com.mr.wh.entities.CommonResult;
import com.mr.wh.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @ClassName: PaymentServiceImpl
 * @Author: User
 * @date: 2020.08.21 19:34
 * @version: 1.0
 */
@Component
public class PaymentServiceImpl implements  PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，-----PaymentFallbackService",new Payment(id, "errorSerial"));
    }
}
