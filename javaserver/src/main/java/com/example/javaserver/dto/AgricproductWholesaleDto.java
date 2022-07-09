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
public class AgricproductWholesaleDto {

    private String categoryCode;
    private String pGroup;
    private String kind;
    private String rank;
    private String unit;
    private boolean isrepresented;

}
