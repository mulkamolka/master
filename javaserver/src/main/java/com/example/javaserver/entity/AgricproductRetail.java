package com.example.javaserver.entity;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class AgricproductRetail {
    
    @Id
    @Column(name = "categoryCode")
    private String categoryCode;
    @Column(name = "pGroup")
    private String pGroup;
    @Column(name = "unit")
    private String unit;

    @JsonBackReference
    @OneToMany(mappedBy = "agriRetail",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Product> agricProduct = new ArrayList<>();

}
