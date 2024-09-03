package com.example.jpatest.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 결제 정보
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // 결제 id

    @OneToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders; // 주문 정보

    @Column(name = "amount", nullable = false)
    private Long amount; // 결제 금액

    @Convert(converter = PaymentMethodConverter.class)
    private PaymentMethod paymentMethod; // 결제 수단(0: 현금, 1: 카드, 2: 상품권)

    public static Payment of(Orders orders,Long paymentMethod){
        Payment payment = new Payment();
        payment.orders = orders;
        payment.paymentMethod = PaymentMethod.ofCode(paymentMethod);
        payment.amount = orders.getTotPrice();

        return payment;
    }
}
