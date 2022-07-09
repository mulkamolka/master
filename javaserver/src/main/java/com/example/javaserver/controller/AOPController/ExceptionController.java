package com.example.javaserver.controller.AOPController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaserver.exception.CustomException;

@RestController
public class ExceptionController {
    @GetMapping("exception1")
    public String exception1() throws Exception {
        boolean isError = true;
        if (isError)
            throw new Exception("exception!");
        return "exception1";
    }

    @GetMapping("exception2")
    public String exception2() {
        boolean isError = true;
        if (isError)
            throw new CustomException("runtime exception!");
        return "exception2";
    }
}
