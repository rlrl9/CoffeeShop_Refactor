package com.example.jpatest.repository.querydsl;

import com.example.jpatest.Entity.Customer;

import java.util.Optional;

public interface CustomerRepositoryCustom {
    //고객 id로 고객 찾기
    Optional<Customer> findByCustomerId(Long customerId);
}
