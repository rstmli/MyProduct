package com.myproduct.controller;

import com.myproduct.dto.request.seller.SellerAddProductRequestDto;
import com.myproduct.dto.response.seller.SellerResponseDto;
import com.myproduct.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/seller")
@RestController
@RequiredArgsConstructor
public class SellerController {
  private final SellerService sellerService;

  @PostMapping("/add")
  public void addSeller(@RequestBody SellerAddProductRequestDto dto){
    sellerService.addProduct(dto);
 }

 @GetMapping("/get-my-sale")
  public List<SellerResponseDto> getMySale(){
    return sellerService.MySale();
 }

 @DeleteMapping("/delete-my-sale/{id}")
  public void deleteMySale(@PathVariable("id") Long id){
    sellerService.deleteMySale(id);
 }
}
