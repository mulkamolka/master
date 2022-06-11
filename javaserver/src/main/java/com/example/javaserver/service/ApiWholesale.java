package com.example.javaserver.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface ApiWholesale {

    // 도, 소매 물가

    ArrayList wholeSalePricesVeg();

    ArrayList wholeSalePricesMeat();

    ArrayList wholeSalePricesSea();

}
