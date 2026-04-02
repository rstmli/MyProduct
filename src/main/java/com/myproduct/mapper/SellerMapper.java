package com.myproduct.mapper;

import com.myproduct.dao.entity.ProductEntity;
import com.myproduct.dao.entity.UserEntity;
import com.myproduct.dto.request.seller.SellerAddProductRequestDto;
import com.myproduct.dto.response.seller.SellerResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {
  public static ProductEntity productRequestToEntity(SellerAddProductRequestDto dto,UserEntity e){
    return ProductEntity.builder()
            .productName(dto.getProductName())
            .productDescription(dto.getProductDescription())
            .category(dto.getCategory())
            .price(dto.getPrice())
            .count(dto.getCount())
            .user(e)
            .build();
  }

  public static SellerResponseDto sellerResponseDto(ProductEntity e){
    return SellerResponseDto.builder()
            .id(e.getId())
            .productName(e.getProductName())
            .productDescription(e.getProductDescription())
            .category(e.getCategory())
            .price(e.getPrice())
            .count(e.getCount())
            .build();
  }




}
