package com.example.javaserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaserver.entity.AgricproductWholesale;


public interface AgricproductWholesaleRepository extends JpaRepository<AgricproductWholesale,String> {
    
    List<AgricproductWholesale> findBypGroup(String pGroup);

    List<AgricproductWholesale> findByCategoryCode(String categoryCode);

    List<AgricproductWholesale> findByisrepresented(Boolean isrepresented);

    
}
