package com.example.javaserver.controller.AOPController;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@RestController
@RequestMapping("/AOP")
public class ControllerAspect {

    // AOP 연습
    @Before(value = "execution (* com.example.javaserver.controller.*.*(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {
        log.debug("@Before run");
    }

    @After(value = "execution (* com.example.javaserver.controller.*.*(..))")
    public void onAfterHandler(JoinPoint joinPoint) {
        log.debug("@After run");
    }

    @AfterReturning(value = "execution (* com.example.javaserver.controller.*.*(..))", returning = "data")
    public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
        if (data != null) {
            log.debug(data.toString());
        }
        log.debug("@AfterReturning run");
    }

}
