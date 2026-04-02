package com.myproduct.dto.request.auth;

import lombok.Data;

@Data
public class LoginRequestDto {
  String username;
  String password;
}
