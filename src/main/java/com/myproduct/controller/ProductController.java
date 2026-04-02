package com.myproduct.controller;

import com.myproduct.dto.response.product.ProductResponseDto;
import com.myproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
  private final ProductService productService;

  @GetMapping("/get")
  public List<ProductResponseDto> getProduct(){
    return productService.getProduct();
  }
}
