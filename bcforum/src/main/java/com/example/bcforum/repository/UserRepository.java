package com.example.bcforum.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bcforum.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long>{
    
    Optional<UsersEntity> findByUsername(String username);

}
