package com.example.jpatest.service.Impl;

import com.example.jpatest.dto.response.ResponseOrdersDto;
import com.example.jpatest.Entity.OrderStatus;
import com.example.jpatest.Entity.Orders;
import com.example.jpatest.global.exception.CoffeeBusinessException;
import com.example.jpatest.global.exception.CoffeeExceptionInfo;
import com.example.jpatest.repository.OrdersRepository;
import com.example.jpatest.service.TakeoutService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TakeoutServiceImpl implements TakeoutService {
    private final OrdersRepository ordersRepository;
    /**
     * 결제 메뉴 테이크아웃
     * @param ordersId
     * @return ResponseOrdersDto
     */
    @Override
    public ResponseOrdersDto takeoutMenu(Long ordersId){
        Orders orders = ordersRepository.findByOrdersId(ordersId)
                .orElseThrow(()->new CoffeeBusinessException(CoffeeExceptionInfo.NOT_EXIST_TAKEOUT));
        if(orders.getStatus() == OrderStatus.CANCELED.getValue()||orders.getStatus()==OrderStatus.WAITING.getValue()){
            throw new CoffeeBusinessException(CoffeeExceptionInfo.NOT_EXIST_PAID);
        } else if (orders.getStatus() == OrderStatus.DELIVERED.getValue()) {
            throw new CoffeeBusinessException(CoffeeExceptionInfo.ALREADY_DELIVERED);
        }
        ResponseOrdersDto responseOrdersDto = ResponseOrdersDto.from(orders, OrderStatus.DELIVERED);
        orders.updateAfterTakeout();
        return responseOrdersDto;
    }
}
