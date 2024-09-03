package com.example.jpatest.service.Impl;

import com.example.jpatest.dto.request.DrinkQtyDto;
import com.example.jpatest.dto.request.RequestOrdersDto;
import com.example.jpatest.dto.response.ResponseOrdersDto;
import com.example.jpatest.Entity.*;
import com.example.jpatest.global.exception.CoffeeBusinessException;
import com.example.jpatest.global.exception.CoffeeExceptionInfo;
import com.example.jpatest.repository.*;
import com.example.jpatest.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final DrinksRepository drinksRepository;
    private final OrdersDrinksRepository ordersDrinksRepository;
    /**
     * 메뉴 주문
     * @param requestOrdersDto
     * @return ResponseOrdersDto
     */
    @Override
    public ResponseOrdersDto registerOrder(RequestOrdersDto requestOrdersDto){
        Customer customer = customerRepository.findByCustomerId(requestOrdersDto.getCustomerId())
                .orElseThrow(() -> new CoffeeBusinessException(CoffeeExceptionInfo.NOT_EXIST_CUSTOMER));
        long totPrice=0L;
        Orders orders = ordersRepository.save(Orders.of(customer,OrderStatus.WAITING.getValue(), totPrice));
        List<OrdersDrinks> ordersDrinksList = new ArrayList<>();
        for (DrinkQtyDto drinkQty : requestOrdersDto.getDrinksList()) {
            Drinks drinks = drinksRepository.findByDrinksId(drinkQty.getDrinksId())
                    .orElseThrow(() -> new CoffeeBusinessException(CoffeeExceptionInfo.NOT_EXIST_DRINKS));
            OrdersDrinks ordersDrinks = OrdersDrinks.of(drinks, drinkQty.getQty(),orders);
            ordersDrinksList.add(ordersDrinks);
            orders.addOrdersDrinks(ordersDrinks);
            totPrice += drinkQty.getQty() * drinks.getPrice();
        }
        ordersDrinksRepository.saveAll(ordersDrinksList);
        orders.updateTotPrice(totPrice);
        return ResponseOrdersDto.from(orders,OrderStatus.WAITING);
    }
}
