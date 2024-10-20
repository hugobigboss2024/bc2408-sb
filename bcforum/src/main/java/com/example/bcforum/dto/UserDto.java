package com.example.bcforum.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;
    @Setter
    List<PostDto> post;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Getter
        @Builder
        public static class Geo {
            private String lat;
            private String lng;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostDto {
        private Long id;
        private String title;
        private String body;
        @Setter
        List<CommentDto> comments;

        @Getter
        @Builder
        @AllArgsConstructor
        public static class CommentDto {
            private Long id;
            private String name;
            private String email;
            private String body;
        }
    }
}

    
    
    

