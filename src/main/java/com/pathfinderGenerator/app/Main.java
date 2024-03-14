package com.pathfinderGenerator.app;

//import the generators
import com.pathfinderGenerator.app.utility.Extractor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;


@SpringBootApplication
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        System.out.println("Hello World");
        SpringApplication.run(Main.class, args);

//        Extractor extractor = new Extractor();
//        extractor.sqlExtractor();
    }
}
