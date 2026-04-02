package com.myproduct.controller;

import com.myproduct.dto.request.user.UserRequestDto;
import com.myproduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  @PutMapping("/update/")
  public void updateRole(@RequestBody UserRequestDto dto){
    userService.updateRole(dto);
  }

}
