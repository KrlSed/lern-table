package com.sedliarov.learningtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LearningTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningTableApplication.class, args);
    }

}
