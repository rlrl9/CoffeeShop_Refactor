package com.example.jpatest.repository;

import com.example.jpatest.Entity.Drinks;
import com.example.jpatest.repository.querydsl.DrinksRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinksRepository extends JpaRepository<Drinks, Long>, DrinksRepositoryCustom {
//    // 음료 id로 음료 찾기
//    Optional<Drinks> findByDrinksId(Long DrinksId);
}
