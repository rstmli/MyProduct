package com.myproduct.service;

import com.myproduct.dao.entity.UserEntity;
import com.myproduct.dao.repository.UserRepository;
import com.myproduct.dto.request.auth.LoginRequestDto;
import com.myproduct.dto.request.auth.RegisterRequestDto;
import com.myproduct.dto.response.LoginResponseDto;
import com.myproduct.jwt.JwtHelper;
import com.myproduct.util.enums.User_Role;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NullMarked
public class AuthService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  @Autowired
  @Lazy
  private  AuthenticationManager authenticationManager;
  private final JwtHelper jwtHelper;
  public void register( RegisterRequestDto dto){
    userRepository.save(
            UserEntity.builder()
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .username(dto.getUsername())
                    .email(dto.getEmail())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .role(User_Role.ROLE_USER)
                    .build()
    );
  }



  public LoginResponseDto login(LoginRequestDto dto){
    Authentication authenticate = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    dto.getUsername(), dto.getPassword()
            )
    );

    UserDetails user = (UserDetails) authenticate.getPrincipal();

    assert user != null;
    System.out.println(jwtHelper.generateToken(user));
    return new LoginResponseDto(jwtHelper.generateToken(user));

  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    var user = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
    );

  
    return User.builder().username(user.getUsername())
            .password(user.getPassword())
            .authorities(user.getRole().name())
            .build();
  }




}
