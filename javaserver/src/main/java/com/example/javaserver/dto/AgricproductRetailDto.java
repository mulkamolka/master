package com.example.javaserver.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.javaserver.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgricproductRetailDto {
    
    private String categoryCode;
    private String pGroup;
    private String unit;

    List<Product> products = new ArrayList<>();

}
