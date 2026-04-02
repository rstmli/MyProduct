package com.myproduct.util.enums;

import lombok.Getter;

@Getter
public enum User_Role {
  ROLE_ADMIN(100.0),
  ROLE_SELLER(50.0),
  ROLE_USER(0.0);


  double price;
  User_Role(double price){
    this.price = price;
  }
}
