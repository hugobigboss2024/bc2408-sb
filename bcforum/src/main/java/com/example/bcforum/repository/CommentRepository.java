package com.example.bcforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bcforum.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

    
} 
