package com.sp.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public static String generateName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }
}
