package com.example.javaserver.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface ApiSeoul {

    // 서울 마켓 가격

    ArrayList seoulMarketMeat();

    ArrayList seoulMarketVeg();

    ArrayList seoulMarketSea();
    
}