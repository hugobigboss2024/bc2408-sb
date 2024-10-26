package com.example.forum_bc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    // private String address;
    private String phone;
    private String website;
    // private String company;

    @Embedded
    private Address address;

    @Embedded
    private Company company;

    /*
     * @Column(name = "address")
     * private String street;
     * private String suite;
     * private String city;
     * private String zipcode;
     * private String geo;
     * 
     * @Column(name = "geo")
     * private String lat;
     * private String lng;
     */

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostsEntity> posts = new ArrayList<>();

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        @Embedded
        private Geo geo;

        @Embeddable
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Geo {
            private String lat;
            private String lng;
        }

        public static Object builder() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'builder'");
        }
    }

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

}