package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.model.PaymentDto;
import com.ewa.project.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
    private PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long paymentId) {
        PaymentDto payment = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
    }
    
    @GetMapping("/getAllPayments")
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        List<PaymentDto> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
    
    @PostMapping("/createPayment")
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
        PaymentDto createdPayment = paymentService.createPayment(paymentDto);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentDto paymentDto) {
        PaymentDto updatedPayment = paymentService.updatePayment(paymentId, paymentDto);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{paymentId}")
    public String deletePayment(@PathVariable Long paymentId) {
        return paymentService.deletePayment(paymentId);
    }

}
