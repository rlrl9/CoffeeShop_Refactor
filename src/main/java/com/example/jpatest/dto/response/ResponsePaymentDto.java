package com.example.jpatest.dto.response;

import com.example.jpatest.Entity.OrdersDrinks;
import com.example.jpatest.Entity.Payment;
import com.example.jpatest.Entity.PaymentStatus;
import lombok.*;

import java.util.List;

/**
 * 결제 응답 받기 위한 dto
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class ResponsePaymentDto {
    private Long ordersId; // 주문 id

    private Long customerId; // 고객 id

    private List<OrdersDrinks> drinksMap; // 음료 list

    private String paymentStatus; // 결제 성공/실패 상태

    private String paymentMethod; // 결제 수단(0: 현금, 1: 카드, 2: 상품권)

    private Long amount; // 결제 금액

    // 결제 성공시
    public static ResponsePaymentDto from(Payment payment, PaymentStatus paymentStatus){
        return ResponsePaymentDto.builder()
                .ordersId(payment.getOrders().getOrdersId())
                .customerId(payment.getOrders().getCustomer().getCustomerId())
                .drinksMap(payment.getOrders().getOrdersDrinksList())
                .paymentStatus(paymentStatus.getDescription())
                .paymentMethod(payment.getPaymentMethod().getDescription())
                .amount(payment.getAmount())
                .build();
    }
}
