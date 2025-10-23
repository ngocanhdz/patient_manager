package com.pm.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {
        // Force set timezone to Asia/Bangkok (same as Vietnam UTC+7) before Spring Boot starts
        System.setProperty("user.timezone", "Asia/Ho_Chi_Minh");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
