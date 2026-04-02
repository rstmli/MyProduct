package com.myproduct.dao.entity;
import com.myproduct.util.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "al_apar_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String productName;
  String productDescription;
  Integer count;
  Double price;
  @Enumerated(EnumType.STRING)
  Category category;
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  UserEntity user;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "baskets",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id"))
  List<UserEntity> userEntities;
}
