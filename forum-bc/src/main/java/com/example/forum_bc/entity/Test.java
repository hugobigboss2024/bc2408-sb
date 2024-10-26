package com.example.forum_bc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Test")
@Data
public class Test {
    private String name;
    private Long age;

}
