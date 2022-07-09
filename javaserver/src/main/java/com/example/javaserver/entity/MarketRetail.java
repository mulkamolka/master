package com.example.javaserver.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.geo.Point;

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
public class MarketRetail {

    @Id
    @Column(name = "mCode", insertable = false, updatable = false)
    private String mCode;
    private String mName;
    private int mType;
    // private double x;
    // private double y;
    private Point loc;

    @JsonManagedReference
    @OneToMany(mappedBy = "marketR",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Product> productR = new ArrayList<>();

}
