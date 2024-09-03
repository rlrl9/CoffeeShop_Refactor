package com.example.jpatest.service.Impl;

import com.example.jpatest.dto.response.ResponsePaymentDto;
import com.example.jpatest.Entity.*;
import com.example.jpatest.global.exception.CoffeeBusinessException;
import com.example.jpatest.global.exception.CoffeeExceptionInfo;
import com.example.jpatest.repository.OrdersRepository;
import com.example.jpatest.repository.PaymentRepository;
import com.example.jpatest.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final OrdersRepository ordersRepository;
    private final PaymentRepository paymentRepository;
    /**
     * 주문 결제
     * @param ordersId
     * @param paymentMethod
     * @return ResponsePaymentDto
     */
    @Override
    public ResponsePaymentDto pay(Long ordersId, Long paymentMethod){
        Orders orders = ordersRepository.findByOrdersId(ordersId)
                .orElseThrow(() -> new CoffeeBusinessException(CoffeeExceptionInfo.NOT_EXIST_ORDERS));
        if(orders.getStatus() == OrderStatus.CANCELED.getValue()){
            throw new CoffeeBusinessException(CoffeeExceptionInfo.ALREADY_CANCELED);
        } else if (orders.getStatus() == OrderStatus.COMPLETED.getValue()) {
            throw new CoffeeBusinessException(CoffeeExceptionInfo.ALREADY_PAID);
        } else if (orders.getStatus() == OrderStatus.DELIVERED.getValue()) {
            throw new CoffeeBusinessException(CoffeeExceptionInfo.ALREADY_DELIVERED);
        }
        // 결제 처리
        Payment payment = paymentRepository.save(Payment.of(orders, paymentMethod));
        orders.updateAfterPayment();//상태 '2'로 변경(주문 완료 상태)
        return ResponsePaymentDto.from(payment, PaymentStatus.PAID);
    }
}
