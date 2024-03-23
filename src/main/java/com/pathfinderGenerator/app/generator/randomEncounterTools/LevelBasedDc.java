package com.pathfinderGenerator.app.generator.randomEncounterTools;

public class LevelBasedDc {
    public int levelBasedDc(int level){
        int startingDc = 14;
        int diffAdder = level/3;
        int dc = startingDc + diffAdder + level;
        return dc;
    }
}
