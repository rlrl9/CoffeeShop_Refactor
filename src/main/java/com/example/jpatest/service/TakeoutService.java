package com.example.jpatest.service;

import com.example.jpatest.dto.response.ResponseOrdersDto;

/**
 * 테이크아웃 서비스 인터페이스
 */
public interface TakeoutService {
    //테이크아웃
    ResponseOrdersDto takeoutMenu(Long ordersId);
}
