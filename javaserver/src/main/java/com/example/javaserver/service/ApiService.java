package com.example.javaserver.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface ApiService {
    
    // 서울시 대형마트,전통시장 가격 동향


    ArrayList seoulMarketVeg();

    ArrayList seoulMarketMeat();

    ArrayList seoulMarketSeaFood();




    // 도, 소매 물가


    ArrayList wholeSalePricesVeg();

    ArrayList wholeSalePricesMeat();

    ArrayList wholeSalePricesSea();


}
