package com.myproduct.controller;

import com.myproduct.dto.request.auth.LoginRequestDto;
import com.myproduct.dto.request.auth.RegisterRequestDto;
import com.myproduct.dto.response.LoginResponseDto;
import com.myproduct.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
  private final AuthService authService;
  @PostMapping("/register")
  public void register(@RequestBody RegisterRequestDto dto){
    authService.register(dto);
  }

  @PostMapping("/login")
  public LoginResponseDto login(@RequestBody LoginRequestDto dto){
    return authService.login(dto);
  }


}
