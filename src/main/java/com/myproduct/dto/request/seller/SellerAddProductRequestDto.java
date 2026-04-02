package com.myproduct.dto.request.seller;

import com.myproduct.util.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerAddProductRequestDto {
  String productName;
  String productDescription;
  Integer count;
  Double price;
  Category category;
}
