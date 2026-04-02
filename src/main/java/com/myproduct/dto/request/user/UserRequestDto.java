package com.myproduct.dto.request.user;

import com.myproduct.util.enums.User_Role;
import lombok.Data;

@Data
public class UserRequestDto {
  User_Role userRole;
}
