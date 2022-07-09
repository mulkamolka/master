package com.example.javaserver.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Product {

    @Id
    @Column(name = "pCode")
    private String pCode;
    private String pName;
    private String description;

    // 참조
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "mCode", name = "mCodeW")
    private MarketWholesale marketW;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "mCode", name = "mCodeR")
    private MarketRetail marketR;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "categoryCode", name = "cCodeAgrR")
    private AgricproductRetail agriRetail;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "categoryCode", name = "cCodeAgrW")
    private AgricproductWholesale agriWholesale;

    @JsonBackReference
    @OneToMany(mappedBy = "products",fetch = FetchType.EAGER , cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Price> price = new ArrayList<>();

}