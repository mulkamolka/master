package com.example.javaserver.entity.emf;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UniqueEntityManagerFactory {

    // persistence-unit의 이름으로 EntityManagerFactory 생성
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    // 애플리케이션 유일 EntityManagerFactory로 설정
    // UniqueEntityManagerFactory.emf = emf;

    // EntityManager em = emf.createEntityManager();
    
}
