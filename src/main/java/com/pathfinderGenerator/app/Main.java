package com.pathfinderGenerator.app;

//import the generators
import com.pathfinderGenerator.app.generator.styleGenerator;

public class Main {

    public static void main(String[] args) {
        styleGenerator styleGenerator = new styleGenerator();
        styleGenerator.styleGenerators("Horror", 4, 3);
    }
}
