package com.myproduct.service;

import com.myproduct.dao.entity.UserEntity;
import com.myproduct.dao.repository.ProductRepository;
import com.myproduct.dto.request.seller.SellerAddProductRequestDto;
import static com.myproduct.mapper.SellerMapper.*;

import com.myproduct.dto.response.seller.SellerResponseDto;
import com.myproduct.mapper.SellerMapper;
import com.myproduct.util.helper.GetCurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {
  private final ProductRepository productRepository;
  private final GetCurrentUser getCurrentUser;



  public void addProduct(SellerAddProductRequestDto dto){
    UserEntity user = getCurrentUser.getCurrentUser();
    productRepository.save(productRequestToEntity(dto,user));
  }


  public List<SellerResponseDto> MySale(){
    UserEntity user = getCurrentUser.getCurrentUser();
    return user.getEntityList().stream().map(SellerMapper::sellerResponseDto).toList();
  }
  public void deleteMySale(Long id){
    var user = getCurrentUser.getCurrentUser();
    var mehsul = productRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Product not fund!")
    );
    if(!mehsul.getUser().equals(user)){
      throw new RuntimeException("bu mehsul sizin deyil.");
    }
    productRepository.delete(mehsul);
  }
}
