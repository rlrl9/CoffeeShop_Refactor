package com.example.jpatest.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDrinks is a Querydsl query type for Drinks
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDrinks extends EntityPathBase<Drinks> {

    private static final long serialVersionUID = -1930025772L;

    public static final QDrinks drinks = new QDrinks("drinks");

    public final NumberPath<Integer> categoryNo = createNumber("categoryNo", Integer.class);

    public final NumberPath<Long> drinksId = createNumber("drinksId", Long.class);

    public final StringPath drinksName = createString("drinksName");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public QDrinks(String variable) {
        super(Drinks.class, forVariable(variable));
    }

    public QDrinks(Path<? extends Drinks> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDrinks(PathMetadata metadata) {
        super(Drinks.class, metadata);
    }

}

