package com.example.javaserver.dto;

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
public class ProductDto {
    
    private String pCode;
    private String pName;
    private String pCategory;
    private String mCode;

    
}
