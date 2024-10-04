package com.bootcamp.demo.demo_sb_restapi.model;

import lombok.Getter;

public class Database {
    @Getter
    public static int[] integers = new int[5];

    public static void main(String[] args) {
        System.out.println(Database.integers[3]);
    }
}
