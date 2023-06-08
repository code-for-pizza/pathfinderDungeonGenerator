package com.pathfinderGenerator.app.generator;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.RandomEncounterObj;
import com.pathfinderGenerator.app.object.StyleRequest;

import java.io.*;
import java.util.*;

public class RandomEncounter {

    static Map<String, RandomEncounterObj> rndEnc = new RandomEncounter().instance();
    private RollDice rollDice = new RollDice();

    private Map<String, RandomEncounterObj> instance(){
        try{
            File file = new File("src/main/java/com/pathfinderGenerator/app/database/randomEncounterDb.json");
            JsonFactory jsonFactory = new JsonFactory();

            Map<String, RandomEncounterObj> rndEncounter = new HashMap<>();

            InputStream io = new FileInputStream(file);

            try(JsonParser jsonParser = jsonFactory.createParser(io)){

                //check to see if there is a token array start
                if(jsonParser.nextToken() != JsonToken.START_ARRAY){
                    throw new IllegalStateException("Excepted content to be an array");
                }

                while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                    //read the first item
                    RandomEncounterObj randomEncounterObj = readEncounter(jsonParser);
                    rndEncounter.put(randomEncounterObj.getTerrain(), randomEncounterObj);
                }

            } catch (JsonParseException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return rndEncounter;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private RandomEncounterObj readEncounter(JsonParser jsonParser) throws IOException {

        RandomEncounterObj randomEncounterObj = new RandomEncounterObj();
        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String Property = jsonParser.getCurrentName();
            jsonParser.nextToken();
            switch (Property){
                case "Terrain Type":
                    randomEncounterObj.setTerrain(jsonParser.getValueAsString());
                    break;
                case "Flat DC":
                    randomEncounterObj.setDc(jsonParser.getIntValue());
                    break;
            }
        }
        return randomEncounterObj;
    }

    private List<Monster> creatureRandomEncounter(RandomEncounterObj randomEncounterObj, int partySize, int partyLevel){

        //first lets sorta determine what creature type you might face
        List<String> traitList = new ArrayList<>();

        switch (randomEncounterObj.getTerrain()){
            case "Aquatic":
                traitList.add("Aquatic");
                traitList.add("Water");
                break;
            case "Arctic":
                traitList.add("Cold");
                traitList.add("Animal");
                break;
            case "Desert":
                traitList.add("Fire");
                traitList.add("Animal");
                traitList.add("Orc");
                break;
            case "Forest":
                traitList.add("Plant");
                traitList.add("Fey");
                traitList.add("Dinosaur");
                traitList.add("Animal");
                traitList.add("Beast");
                traitList.add("Leshy");
                traitList.add("Goblin");
                traitList.add("Orc");
                break;
            case "Mountain":
                traitList.add("Earth");
                traitList.add("Giant");
                traitList.add("Dragon");
                traitList.add("Kobold");
                break;
            case "Plains":
                traitList.add("Beast");
                traitList.add("Animal");
                traitList.add("Humanoid");
                traitList.add("Lizardfolk");
                traitList.add("Goblin");
                traitList.add("Orc");
                break;
            case "Swamp":
                traitList.add("Undead");
                traitList.add("Spirit");
                traitList.add("Amphibious");
                traitList.add("Serpentfolk");
                traitList.add("Animal");
                break;
        }

        StyleRequest styleRequest = new StyleRequest();
        styleRequest.setTraits(traitList);


        StyleGenerator styleGenerator = new StyleGenerator();
        return styleGenerator.generateEncounter("Moderate",partySize, partyLevel, traitList);


    }

    public List<Monster> rndEncGenerator(String randomEncounterObj, int partySize, int partyLevel){

        List<Monster> creatureEncounter = new LinkedList<>();
        RandomEncounterObj randomEncounterObj1 = rndEnc.get(randomEncounterObj);

        //Roll the Dice roll
        int rnd = rollDice.rollDice(20);
        if(rnd >= 21){
            System.out.println("rnd = " + rnd);
            rnd = rnd%20;
        }

        //it has rolled higher than the static DC lets see what we get now
        if(rnd > randomEncounterObj1.getDc()) {
            int rndHazard = rollDice.rollDice(10);
            switch (rndHazard) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("A harmless encounter has occurred.");
                    break;
                case 6:
                case 7:
                    System.out.println("A hazard has occurred, this could be like a cliff, or toxic mushrooms / " +
                            "corrupted land, and is not combat based. ");
                    break;
                case 8:
                case 9:
                case 10:
                    System.out.println("A random encounter has occurred, generating one based on terrain " +
                            "if the party is flying this generator will not take that into account. RAW you would " +
                            "choose a flying creature, or a creature with some sort of reach that is able to hit them.");
                    creatureEncounter = creatureRandomEncounter(randomEncounterObj1, partySize, partyLevel);
                    break;

            }
        }

        return creatureEncounter;

    }
}
