package com.myproduct.mapper;

import com.myproduct.dao.entity.ProductEntity;
import com.myproduct.dto.response.product.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductResponseDto productResponseDto (ProductEntity e){
    return ProductResponseDto.builder()
            .id(e.getId())
            .sellerName(e.getUser().getName())
            .productName(e.getProductName())
            .productDescription(e.getProductDescription())
            .category(e.getCategory())
            .count(e.getCount())
            .price(e.getPrice())
            .build();
  }

}
