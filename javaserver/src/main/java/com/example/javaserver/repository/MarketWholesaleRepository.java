package com.example.javaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaserver.entity.MarketWholesale;

public interface MarketWholesaleRepository extends JpaRepository<MarketWholesale, String>{
    
}
