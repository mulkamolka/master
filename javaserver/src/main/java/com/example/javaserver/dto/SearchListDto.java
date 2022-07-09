package com.example.javaserver.dto;

import org.springframework.format.annotation.DateTimeFormat;

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
public class SearchListDto {
    
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private Integer rankNum;
    private String percentage;
    private String pgroupName;

}