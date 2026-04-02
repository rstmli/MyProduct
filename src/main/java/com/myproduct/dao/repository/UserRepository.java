package com.myproduct.dao.repository;

import com.myproduct.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
  Optional<UserEntity> findByUsername(String username);


}
