package com.example.jpatest.repository;

import com.example.jpatest.Entity.Orders;
import com.example.jpatest.repository.querydsl.OrdersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long>, OrdersRepositoryCustom {
//    // 주문 id로 주문 정보 찾기
//    Optional<Orders> findByOrdersId(Long ordersId);
}
