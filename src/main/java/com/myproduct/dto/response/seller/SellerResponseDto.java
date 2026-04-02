package com.myproduct.dto.response.seller;

import com.myproduct.util.enums.Category;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerResponseDto {
  Long id;
  String productName;
  String productDescription;
  Integer count;
  Double price;
  Category category;
}
