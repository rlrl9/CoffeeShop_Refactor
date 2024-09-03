package com.example.jpatest.repository.querydsl.impl;

import com.example.jpatest.Entity.Customer;
import com.example.jpatest.repository.querydsl.CustomerRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.jpatest.Entity.QCustomer.customer;

@Repository
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public CustomerRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Customer> findByCustomerId(Long customerId){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(customer)
                .where(customer.customerId.eq(customerId))
                .fetchOne());
    }
}
