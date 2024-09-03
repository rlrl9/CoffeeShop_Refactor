package com.example.jpatest.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrdersDrinks is a Querydsl query type for OrdersDrinks
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrdersDrinks extends EntityPathBase<OrdersDrinks> {

    private static final long serialVersionUID = 1441322329L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrdersDrinks ordersDrinks = new QOrdersDrinks("ordersDrinks");

    public final QDrinks drinks;

    public final NumberPath<Long> odId = createNumber("odId", Long.class);

    public final QOrders orders;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QOrdersDrinks(String variable) {
        this(OrdersDrinks.class, forVariable(variable), INITS);
    }

    public QOrdersDrinks(Path<? extends OrdersDrinks> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrdersDrinks(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrdersDrinks(PathMetadata metadata, PathInits inits) {
        this(OrdersDrinks.class, metadata, inits);
    }

    public QOrdersDrinks(Class<? extends OrdersDrinks> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.drinks = inits.isInitialized("drinks") ? new QDrinks(forProperty("drinks")) : null;
        this.orders = inits.isInitialized("orders") ? new QOrders(forProperty("orders"), inits.get("orders")) : null;
    }

}

