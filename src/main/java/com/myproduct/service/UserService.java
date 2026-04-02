package com.myproduct.service;

import com.myproduct.dao.repository.UserRepository;
import com.myproduct.dto.request.user.UserRequestDto;
import com.myproduct.util.enums.User_Role;
import com.myproduct.util.helper.GetCurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final GetCurrentUser getCurrentUser;
  private final UserRepository userRepository;


  public void updateRole(UserRequestDto dto){
    var user = getCurrentUser.getCurrentUser();

    User_Role role = dto.getUserRole();
    double rolePrice =  role.getPrice();
    if(user.getBalance() >= rolePrice){
      user.setBalance(user.getBalance() - rolePrice);
      user.setRole(role);
      userRepository.save(user);
    }else {
      throw new RuntimeException("kifayet qeder balansiniz yoxdur");
    }




  }





}
