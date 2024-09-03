package com.example.jpatest.repository;

import com.example.jpatest.Entity.Payment;
import com.example.jpatest.repository.querydsl.PaymentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentRepositoryCustom {
}
