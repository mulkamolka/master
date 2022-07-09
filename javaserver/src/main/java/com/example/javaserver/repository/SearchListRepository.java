package com.example.javaserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaserver.entity.SearchList;

public interface SearchListRepository extends JpaRepository<SearchList, Long>{

    List<SearchList>findBydate(String date);
    
    List<SearchList>deleteBydate(String date);
}
