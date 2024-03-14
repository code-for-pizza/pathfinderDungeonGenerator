package com.pathfinderGenerator.app.generator;

public class RollDice {
    public int rollDice(int highRoll){
      return (int) (Math.random() * (highRoll));
    }
}
