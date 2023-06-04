package com.pathfinderGenerator.app;

//import the generators
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathfinderGenerator.app.generator.styleGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        List<String> traits = new ArrayList<>();
        traits.add("Undead");
//        traits.add("Animal");
        styleGenerator styleGenerator = new styleGenerator();
        styleGenerator.styleGenerators("Dungeon Crawl", 4, 3, traits);
    }
}
