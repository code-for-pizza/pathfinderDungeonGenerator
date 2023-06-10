package com.pathfinderGenerator.app;

//import the generators
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(Main.class, args);

    }
}
