package com.example.jpatest.repository.querydsl;

import com.example.jpatest.Entity.Drinks;

import java.util.Optional;

public interface DrinksRepositoryCustom {
    // 음료 id로 음료 찾기
    Optional<Drinks> findByDrinksId(Long DrinksId);
}
