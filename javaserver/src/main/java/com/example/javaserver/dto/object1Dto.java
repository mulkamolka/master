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
public class object1Dto {
    
    private Integer rankNum;
    private String pGroupName;
    private String percentage;
    
}
