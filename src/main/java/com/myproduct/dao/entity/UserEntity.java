package com.myproduct.dao.entity;
import com.myproduct.util.enums.User_Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "al_apar_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  String surname;
  @Column(nullable = false,unique = true)
  String email;
  @Enumerated(EnumType.STRING)
  User_Role role;
  @Column(nullable = false,unique = true)
  String username;
  String password;
  Double balance;
  @OneToMany(mappedBy = "user")
  List<ProductEntity> entityList;
  @ManyToMany(mappedBy = "userEntities")
  List<ProductEntity> basket;
}
