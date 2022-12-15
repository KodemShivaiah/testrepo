package com.jpa.example.service.service;

import org.springframework.stereotype.Service;

@Service("axisBank")
public class AxisBankPaymentServiceImpl extends PaymentServiceImpl {
    @Override
    public String payment() {
        return "Aixs bank success";
    }
}
