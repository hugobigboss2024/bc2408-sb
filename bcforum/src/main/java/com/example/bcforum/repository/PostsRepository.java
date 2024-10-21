package com.example.bcforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bcforum.entity.PostsEntity;

public interface PostsRepository extends JpaRepository<PostsEntity, Long>{
    
}
