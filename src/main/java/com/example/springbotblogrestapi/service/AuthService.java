package com.example.springbotblogrestapi.service;

import com.example.springbotblogrestapi.payload.LoginDto;
import com.example.springbotblogrestapi.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
