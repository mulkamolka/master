package com.example.javaserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SearchList {
    
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private Integer rankNum;
    private String percentage;
    private String pgroupName;

}
