package com.example.jpatest.repository.querydsl;

import com.example.jpatest.Entity.Orders;

import java.util.Optional;

public interface OrdersRepositoryCustom {
    // 주문 id로 주문 정보 찾기
    Optional<Orders> findByOrdersId(Long ordersId);
}
