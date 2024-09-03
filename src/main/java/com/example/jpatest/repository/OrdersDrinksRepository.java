package com.example.jpatest.repository;

import com.example.jpatest.Entity.OrdersDrinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDrinksRepository extends JpaRepository<OrdersDrinks, Long> {
}
