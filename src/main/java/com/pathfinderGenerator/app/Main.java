package com.pathfinderGenerator.app;

//import the generators
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathfinderGenerator.app.generator.StyleGenerator;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.StyleRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JsonProcessingException {

//        SpringApplication.run(Main.class, args);

        StyleRequest styleRequest = new StyleRequest();
        styleRequest.setStyleName("Horror");
        styleRequest.setPartySize(4);
        styleRequest.setPartyLevel(3);
        styleRequest.setTraits(Collections.singletonList("Undead"));

        StyleGenerator styleGenerator = new StyleGenerator();

        List<List<List<Monster>>> test = styleGenerator.styleGenerators(styleRequest);
    }
}
