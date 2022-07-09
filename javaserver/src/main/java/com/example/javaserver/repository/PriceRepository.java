package com.example.javaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaserver.entity.Price;

public interface PriceRepository extends JpaRepository<Price,Long> {
    
}
