package com.example.jpatest.service;

import com.example.jpatest.dto.response.ResponsePaymentDto;

/**
 * 결제 서비스 인터페이스
 */
public interface PaymentService {
    //메뉴 결제
    ResponsePaymentDto pay(Long ordersId, Long paymentMethod);
}
