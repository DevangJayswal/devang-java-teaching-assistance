package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootProducerDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootProducerDemoApplication.class, args);

    }

}
