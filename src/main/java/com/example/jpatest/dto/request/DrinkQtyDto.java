package com.example.jpatest.dto.request;

import lombok.*;

/**
 * 주문 음료 리스트 위한 dto
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Setter
public class DrinkQtyDto {
    private Long drinksId; //음료 id
    private int qty; // 수량
}
