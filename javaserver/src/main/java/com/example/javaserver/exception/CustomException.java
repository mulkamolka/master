package com.example.javaserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    
    private String message;

}
