package com.example.jpatest.dto.response;

import com.example.jpatest.Entity.OrderStatus;
import com.example.jpatest.Entity.Orders;
import com.example.jpatest.Entity.OrdersDrinks;
import lombok.*;

import java.util.List;

/**
 * 주문 응답 받기 위한 dto
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class ResponseOrdersDto {
    private Long ordersId; // 주문 id

    private Long customerId; // 고객 id

    private List<OrdersDrinks> drinksMap; // 음료 목록

    private String statusMessage; // 상태 메세지

    public static ResponseOrdersDto from(Orders orders, OrderStatus orderStatus){
        return ResponseOrdersDto.builder()
                .ordersId(orders.getOrdersId())
                .customerId(orders.getCustomer().getCustomerId())
                .drinksMap(orders.getOrdersDrinksList())
                .statusMessage(orderStatus.getDescription())
                .build();
    }
}
