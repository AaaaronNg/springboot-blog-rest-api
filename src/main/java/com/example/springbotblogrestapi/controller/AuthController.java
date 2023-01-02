package com.example.springbotblogrestapi.controller;


import com.example.springbotblogrestapi.payload.LoginDto;
import com.example.springbotblogrestapi.payload.RegisterDto;
import com.example.springbotblogrestapi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String res = authService.login(loginDto);
        return ResponseEntity.ok(res);
    }


    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String res = authService.register(registerDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }


}
