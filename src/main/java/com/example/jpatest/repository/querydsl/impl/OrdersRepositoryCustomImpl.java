package com.example.jpatest.repository.querydsl.impl;

import com.example.jpatest.Entity.Orders;
import com.example.jpatest.repository.querydsl.OrdersRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.jpatest.Entity.QOrders.orders;

@Repository
public class OrdersRepositoryCustomImpl implements OrdersRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public OrdersRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Orders> findByOrdersId(Long ordersId){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(orders)
                .where(orders.ordersId.eq(ordersId))
                .fetchOne());
    }
}
