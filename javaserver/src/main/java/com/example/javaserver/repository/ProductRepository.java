package com.example.javaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaserver.entity.Product;

public interface ProductRepository extends JpaRepository<Product,String>  {
    
}
