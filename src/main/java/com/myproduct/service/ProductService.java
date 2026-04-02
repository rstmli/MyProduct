package com.myproduct.service;

import com.myproduct.dao.repository.ProductRepository;
import com.myproduct.dto.response.product.ProductResponseDto;
import com.myproduct.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public List<ProductResponseDto> getProduct(){
    return productRepository.findAll()
            .stream()
            .map(productMapper::productResponseDto)
            .toList();
  }




}
