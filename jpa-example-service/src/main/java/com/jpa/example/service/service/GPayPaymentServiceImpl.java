package com.jpa.example.service.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("gpaymentService")
@Order(1)
public class GPayPaymentServiceImpl extends PaymentServiceImpl {
    @Override
    public String payment() {
        return "GPay Success";
    }
}
