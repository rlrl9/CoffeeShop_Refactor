package com.example.jpatest.repository.querydsl.impl;

import com.example.jpatest.repository.querydsl.PaymentRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryCustomImpl implements PaymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public PaymentRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
