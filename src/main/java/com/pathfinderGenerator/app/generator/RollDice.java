package com.pathfinderGenerator.app.generator;

public class RollDice {
    public int rollDice(int highRoll, boolean minimumOne){

        int rng = (int) (Math.random() * highRoll);
        if(minimumOne) rng +=1;
        return rng;
    }
}
