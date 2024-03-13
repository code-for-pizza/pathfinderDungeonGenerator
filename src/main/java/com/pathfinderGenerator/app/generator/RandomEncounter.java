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

    // generate map for harmless encounter descriptions
    static Map<String, String> harmlessEncDesc = RandomEncounter.makeHarmlessDesc();

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

    private List<Monster> creatureRandomEncounter(RandomEncounterObj randomEncounterObj, int partySize, int partyLevel, List<String> sourceList){

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
                traitList.add("Earth");
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
        styleRequest.setSource(sourceList);
        styleRequest.setPartyLevel(partyLevel);
        styleRequest.setPartySize(partySize);
        styleRequest.setStyleName(randomEncounterObj.getTerrain());


        StyleGenerator styleGenerator = new StyleGenerator();
        return styleGenerator.generateEncounter("Moderate",partySize, partyLevel, traitList,sourceList, styleRequest);


    }

    private static Map<String, String> makeHarmlessDesc(){
        Map<String,String> descMap = new HashMap<>();
        descMap.put("Aquatic", "seafood, coral, pearls, shipwrecks");
        descMap.put("Arctic", "scarce food (broken ice floes that allow for fishing, breeding grounds for seals or whales)");
        descMap.put("Desert", "water sources (underground springs, oases, and streams), mineral wealth");
        descMap.put("Forest", "diverse flora and fauna, natural remedies, plentiful game");
        descMap.put("Mountain", "minerals (including gold, silver, and gemstones)");
        descMap.put("Plain", "useful plants (flax or cotton)");
        descMap.put("Swamp", " materials useful for medicine or poison");
        return descMap;
    }

    public List<Monster> rndEncGenerator(String randomEncounterObj, int partySize, int partyLevel, List<String> sourceList){

        List<Monster> userEncounter = new LinkedList<>();
        RandomEncounterObj randomEncounterObj1 = rndEnc.get(randomEncounterObj);

        //Roll the Dice roll
        int rnd = rollDice.rollDice(20);
        if(rnd >= 21){
//            System.out.println("rnd = " + rnd);
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
//                    harmless encounter
                    Monster encounter = new Monster();
                    encounter.setEncType("Harmless");
                    encounter.setHarmlessDescription(harmlessEncDesc.get(randomEncounterObj1.getTerrain()));
                    userEncounter = Collections.singletonList(encounter);
                    break;
                case 6:
                case 7:
//                    hazard?
//                    System.out.println("A hazard has occurred, this could be like a cliff, or toxic mushrooms / " +
//                            "corrupted land, and is not combat based. ");
                    break;
                case 8:
                case 9:
                case 10:
//                    System.out.println("A random encounter has occurred, generating one based on terrain " +
//                            "if the party is flying this generator will not take that into account. RAW you would " +
//                            "choose a flying creature, or a creature with some sort of reach that is able to hit them.");
                    userEncounter = creatureRandomEncounter(randomEncounterObj1, partySize, partyLevel, sourceList);
                    break;

            }
        }

        System.out.println("userEncounter = " + userEncounter);

        return userEncounter;

    }
}
