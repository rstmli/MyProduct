package com.myproduct.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDto {
  @NotBlank(message = "ad bos ol bilmez")
  String name;
  @NotBlank(message = "soyad bos ol bilmez")
  String surname;
  @Email(message = "yazdiginiz email formati duzgun deyil")
  String email; // @.
  String username;
  String password;


}
