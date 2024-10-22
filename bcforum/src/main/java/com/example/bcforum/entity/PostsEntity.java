package com.example.bcforum.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //private Long userId;
  private String title;
  private String body;

  

  @Builder.Default
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private List<CommentEntity> comments = new ArrayList<>();

   @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UsersEntity userId; 


}
