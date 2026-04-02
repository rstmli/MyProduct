package com.myproduct.util.helper;

import com.myproduct.dao.entity.UserEntity;
import com.myproduct.dao.repository.UserRepository;
import com.myproduct.util.exception.NotAuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetCurrentUser {
  private final UserRepository userRepository;


  public UserEntity getCurrentUser(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    assert auth != null;
    if(!auth.isAuthenticated()){
      throw new NotAuthenticationException("Not authentication");
    }

    String username = auth.getName();
    return userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User Not Found")
    );

  }
}
