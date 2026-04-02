package com.myproduct.dto.response.product;

import com.myproduct.dao.entity.UserEntity;
import com.myproduct.dto.response.seller.SellerResponseDto;
import com.myproduct.util.enums.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
  Long id;
  String productName;
  String productDescription;
  Integer count;
  Double price;
  Category category;
  String sellerName;
}
