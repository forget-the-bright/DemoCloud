package com.mr.wh.service;

import com.mr.wh.entities.Payment;


public interface PaymentService {
    public  int  create(Payment payment);

    public Payment getPaymentById(Long id);
}
