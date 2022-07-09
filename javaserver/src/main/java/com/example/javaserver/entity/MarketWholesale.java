package com.example.javaserver.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class MarketWholesale {

    @Id
    @Column(name = "mCode", insertable = false, updatable = false, nullable = false)
    private String mCode;
    private String mOrigin;

    @JsonManagedReference
    @OneToMany(mappedBy = "marketW",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Product> productW = new ArrayList<>();
    
}
