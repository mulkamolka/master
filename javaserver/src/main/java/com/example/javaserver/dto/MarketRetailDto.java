package com.example.javaserver.dto;

import org.springframework.data.geo.Point;

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
public class MarketRetailDto {
    
    private String mCode;
    private String mName;
    private int mType;
    private Point loc;
    
}
