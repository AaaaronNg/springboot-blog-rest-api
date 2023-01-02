package com.example.springbotblogrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private String Date;
    private String message;
    private String details;

}
