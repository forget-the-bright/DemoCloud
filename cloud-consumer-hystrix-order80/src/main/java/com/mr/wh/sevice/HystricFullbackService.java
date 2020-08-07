package com.mr.wh.sevice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HystricFullbackService implements HystricService{


    @Override
    public String paymentHystric_OK(Integer id) {
        return "ok";
    }

    @Override
    public String paymentHystric_Timeout(Integer id) {
        return "out";
    }
}
