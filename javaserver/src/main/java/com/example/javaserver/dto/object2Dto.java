package com.example.javaserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class object2Dto {

    // 마트 description 제공 

    private String categoryCode;
    private String pGroup;
    private String kind;
    private String rank;
    private String unit;
    private String description;
    
}
