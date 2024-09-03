package com.example.jpatest.repository;

import com.example.jpatest.Entity.Customer;
import com.example.jpatest.repository.querydsl.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
//    //고객 id로 고객 찾기
//    Optional<Customer> findByCustomerId(Long customerId);
}
