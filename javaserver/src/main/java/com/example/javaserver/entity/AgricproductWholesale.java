package com.example.javaserver.entity;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JavaBean
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AgricproductWholesale {
    
    @Id
    @Column(name = "categoryCode")
    private String categoryCode;
    @Column(name = "pGroup", nullable = false)
    private String pGroup;
    private String kind;
    private String rank;
    private String unit;
    @Column(name = "isrepresented")
    private boolean isrepresented;
    
    @JsonBackReference
    @OneToMany(mappedBy = "agriWholesale",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Product> agricProduct = new ArrayList<>();

}