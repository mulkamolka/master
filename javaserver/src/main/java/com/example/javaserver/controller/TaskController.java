package com.example.javaserver.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaserver.dto.object1Dto;
import com.example.javaserver.dto.object2Dto;
import com.example.javaserver.entity.MarketRetail;
import com.example.javaserver.entity.Price;
import com.example.javaserver.entity.Product;
import com.example.javaserver.entity.SearchList;
import com.example.javaserver.repository.AgricproductWholesaleRepository;
import com.example.javaserver.service.Task1Service;

@CrossOrigin
@RestController
@RequestMapping("/list")
public class TaskController {

    @Autowired
    public Task1Service task1Service;

    @Autowired
    AgricproductWholesaleRepository repo;

    // (구현) 1. 모든 품목 상품명 
    @GetMapping("/all")
    public List<object1Dto> wCategory() {
        return task1Service.searchButton();
    }

    // (구현) 1. 모든 품목 상품명 / 해당 table에서 값 받아와서 바로 전달하는 logic
    @GetMapping("/all/{date}")
    public List<SearchList> wCategory1(@PathVariable String date) {
        return task1Service.getList(date);
    }

    // (구현) 2. 농산물 도매 물가 리스트
    @GetMapping("/agric")
    public List<object1Dto> agr1() {
        return task1Service.getAgricPgroup();
    }

    // (구현) 3. 검색창에서, 상품 클릭시 카테고리만 먼저 전달
    @GetMapping("/category/{pGroup}")
    public List<object2Dto> getCategory(@PathVariable String pGroup) {
        return task1Service.getCategoryList(pGroup);
    }

    // (구현) 3-1. 카테고리가 갖는 상품의 가격값 전체 전송
    @GetMapping("/price/{cCode}")
    public List<Price> getPrices(@PathVariable String cCode) {
        return task1Service.getPrices(cCode);
    }

    // (미구현) 4. 농산물 도매 물가 상품 동네 위치 정보
    @PostMapping("/4/{latitude}/{longitude}/{pGroup}")
    public HashMap<MarketRetail, Product> Info(@PathVariable String pGroup, Double latitude, Double longitude) {

        return null;
    }






    


    // @@@@@@@@@@@@@@@ TEST CODE @@@@@@@@@@@@@@@
    // @@@@@@@@@@@@@@@ TEST CODE @@@@@@@@@@@@@@@


    // jpql Test
    @GetMapping("/111")
    @Transactional
    public List<Object> jpql() { // Dto 사용 ( new 명령어 )

        return task1Service.test();
    }

    // db Test Insert
    @GetMapping("/22222")
    public void wCategory1() {
        task1Service.setDb();
    }

    // db Test delete
    @GetMapping("/33333")
    public void wCategory2() {
        task1Service.delDb();
    }

}
