package com.demo.forum.bc_forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String website);

    Optional<UserEntity> findByWebsiteAndPhone(String website, String phone);
}
