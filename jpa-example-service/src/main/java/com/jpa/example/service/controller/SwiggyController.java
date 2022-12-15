package com.jpa.example.service.controller;

import com.jpa.example.service.service.AxisBankPaymentServiceImpl;
import com.jpa.example.service.service.GPayPaymentServiceImpl;
import com.jpa.example.service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swiggy")
public class SwiggyController {

    private PaymentService paymentService;
    @GetMapping("/payment/{paymentTpe}")
    public String paymentMethod(@PathVariable("paymentType") String payemntType){
        String returnValue = "";
        switch (payemntType) {
            case "GPay":
                paymentService = new GPayPaymentServiceImpl();
                returnValue = paymentService.payment();
                break;
            case "Axis":
                paymentService = new AxisBankPaymentServiceImpl();
                returnValue = paymentService.payment();
                break;
            default:
                returnValue = "Invalid payment method";
                break;
        }
        return returnValue;
    }

}
