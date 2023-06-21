package com.pathfinderGenerator.app;

//import the generators
import com.pathfinderGenerator.app.generator.RandomEncounter;
import com.pathfinderGenerator.app.object.RandomEncounterObj;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
//        RandomEncounter randomEncounter = new RandomEncounter();
//        List<String> testList = new ArrayList<>();
//        randomEncounter.rndEncGenerator("Aquatic", 4, 3, testList);
    }
}
