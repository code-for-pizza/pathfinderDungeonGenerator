package com.pathfinderGenerator.app.generator.randomEncounterTools;

import com.pathfinderGenerator.app.generator.RollDice;


public class GetEncounterDescription {

    QuickEnvDetails quickEnvDetails = new QuickEnvDetails();

    RollDice rollDice = new RollDice();

    HazardEnvDetails hazardEnvDetails = new HazardEnvDetails();

    public String getHarmlessEncounterDescription(String terrain){
        int rnd = rollDice.rollDice(5,false);
        String sense = "";
        switch (rnd) {
            case 0: sense = "Sights"; break;
            case 1: sense = "Sounds"; break;
            case 2: sense = "Smells"; break;
            case 3: sense = "Textures"; break;
            case 4: sense = "Weather"; break;
        }
        String description = "";
        switch(terrain){
            case "Aquatic":
                description = (quickEnvDetails.aquatic().get(sense)[rollDice.rollDice(quickEnvDetails.aquatic().get(sense).length,false)]);
                break;
            case "Arctic":
                description = (quickEnvDetails.arctic().get(sense)[rollDice.rollDice(quickEnvDetails.arctic().get(sense).length,false)]);
                break;
            case "Forest":
                description = (quickEnvDetails.forest().get(sense)[rollDice.rollDice(quickEnvDetails.forest().get(sense).length,false)]);
                break;
            case "Plains":
                 description = (quickEnvDetails.plains().get(sense)[rollDice.rollDice(quickEnvDetails.plains().get(sense).length,false)]);
                break;
            case "Swamp":
                description = (quickEnvDetails.swamp().get(sense)[rollDice.rollDice(quickEnvDetails.swamp().get(sense).length,false)]);
                break;
            case "Mountain":
                description = (quickEnvDetails.mountain().get(sense)[rollDice.rollDice(quickEnvDetails.mountain().get(sense).length,false)]);
                break;
        }

        return description;
    }

    public String getHazardEncounterDescription(String terrain){
        int rnd = rollDice.rollDice(5,false);
        String description = "";
        switch(terrain){
            case "Aquatic":
                description = (hazardEnvDetails.aquatic()[rnd]);
                break;
            case "Arctic":
                description = (hazardEnvDetails.arctic()[rnd]);
                break;
            case "Forest":
                description = (hazardEnvDetails.forest()[rnd]);
                break;
            case "Plains":
                description = (hazardEnvDetails.plains()[rnd]);
                break;
            case "Swamp":
                description = (hazardEnvDetails.swamp()[rnd]);
                break;
            case "Mountain":
                description = (hazardEnvDetails.mountain()[rnd]);
                break;
        }

        return description;
    }
}
