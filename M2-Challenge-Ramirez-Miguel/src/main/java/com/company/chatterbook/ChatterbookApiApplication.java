package com.company.chatterbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//For testing via web browser or Insomnia
@SpringBootApplication
public class ChatterbookApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatterbookApiApplication.class, args);
    }
}
