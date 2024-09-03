package com.example.jpatest.Entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, Long> {
    @Override
    public Long convertToDatabaseColumn(PaymentMethod paymentMethod) {
        return paymentMethod.getValue();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(Long dbData) {
        return PaymentMethod.ofCode(dbData);
    }
}
