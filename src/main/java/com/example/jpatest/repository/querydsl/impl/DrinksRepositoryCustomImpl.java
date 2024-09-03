package com.example.jpatest.repository.querydsl.impl;

import com.example.jpatest.Entity.Drinks;
import com.example.jpatest.repository.querydsl.DrinksRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.jpatest.Entity.QDrinks.drinks;

@Repository
public class DrinksRepositoryCustomImpl implements DrinksRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public DrinksRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Drinks> findByDrinksId(Long DrinksId){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(drinks)
                .where(drinks.drinksId.eq(DrinksId))
                .fetchOne());
    }
}
