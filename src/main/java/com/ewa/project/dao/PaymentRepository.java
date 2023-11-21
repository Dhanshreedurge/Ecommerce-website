package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByPaymentId(Long paymentId);
}
