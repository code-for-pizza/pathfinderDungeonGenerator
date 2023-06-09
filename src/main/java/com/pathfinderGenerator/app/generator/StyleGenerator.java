package com.pathfinderGenerator.app.generator;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.Style;
import com.pathfinderGenerator.app.object.StyleRequest;

import java.io.*;
import java.util.*;
public class StyleGenerator {

    static ObjectMapper objectMapper = new ObjectMapper();
    private RollDice rollDice = new RollDice();
    static Map<Integer, List<Monster>> monsterGuide = new StyleGenerator().instance();
    static Map<String, Style> styleGuide = new StyleGenerator().instance2();
    static String[][] xpChart = {{"Trivial", "40","10"}, {"Low", "60", "15"}, {"Moderate","80","20"}, {"Severe", "120","30"}, {"Extreme","160","40"}};

    static int[][] createXP = {{-4,10}, {-3,15}, {-2,20}, {-1,30}, {0,40}, {1,60}, {2,80}, {3,120}, {4,160}};
    private Style readStyle(JsonParser jsonParser) throws IOException {
        Style style = new Style();
        List<String> traitList = new ArrayList<>();

        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String Property = jsonParser.getCurrentName();

            jsonParser.nextToken();

            //Figure out what to do with these properties

            switch (Property) {
                case "name":
                    style.setName(jsonParser.getValueAsString());
                    break;
                case "Combat Encounter Trivial":
                    style.setTrivial(jsonParser.getValueAsString());
                    break;
                case "Combat Encounter Low":
                    style.setLow(jsonParser.getValueAsString());
                    break;
                case "Combat Encounter Moderate":
                    style.setModerate(jsonParser.getValueAsString());
                    break;
                case "Combat Encounter Severe":
                    style.setSevere(jsonParser.getValueAsString());
                    break;
                case "Combat Encounter Extreme":
                    style.setExtreme(jsonParser.getValueAsString());
                    break;

            }

        }

        return style;
    }
    private Monster readMonsters(JsonParser jsonParser) throws IOException {
        Monster monster = new Monster();
        List<String> traitList = new ArrayList<>();

        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String Property = jsonParser.getCurrentName();

            jsonParser.nextToken();

            //Figure out what to do with these properties

            switch (Property) {
                case "name":
                    monster.setName(jsonParser.getValueAsString());
                    break;
                case "Creature Level":
                    monster.setCr(jsonParser.getIntValue());
                    break;
                case "Trait 1":
                    traitList.add(jsonParser.getValueAsString());
                    break;
                case "Trait 2":
                case "Trait 3":
                case "Trait 4":
                case "Trait 5":
                case "Trait 6":
                case "Trait 7":
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
            }

        }
        monster.setTrait(traitList);

        return monster;
    }
    private Map<Integer,List<Monster>> instance(){
        try{
            File file = new File ("src/main/java/com/pathfinderGenerator/app/database/monsterDB.json");
            JsonFactory jsonFactory = new JsonFactory();

            Map<Integer, List<Monster>> monsters = new HashMap<>();
            Map<String, Monster> monsterMap = new HashMap<>();

            InputStream inputStream = new FileInputStream(file);
            try(JsonParser jsonParser = jsonFactory.createParser(inputStream)){
                // Create a list for 26 CR's
                List<Monster> cr0 = new ArrayList<>();
                List<Monster> cr1 = new ArrayList<>();
                List<Monster> cr2 = new ArrayList<>();
                List<Monster> cr3 = new ArrayList<>();
                List<Monster> cr4 = new ArrayList<>();
                List<Monster> cr5 = new ArrayList<>();
                List<Monster> cr6 = new ArrayList<>();
                List<Monster> cr7 = new ArrayList<>();
                List<Monster> cr8 = new ArrayList<>();
                List<Monster> cr9 = new ArrayList<>();
                List<Monster> cr10 = new ArrayList<>();
                List<Monster> cr11 = new ArrayList<>();
                List<Monster> cr12 = new ArrayList<>();
                List<Monster> cr13 = new ArrayList<>();
                List<Monster> cr14 = new ArrayList<>();
                List<Monster> cr15 = new ArrayList<>();
                List<Monster> cr16 = new ArrayList<>();
                List<Monster> cr17 = new ArrayList<>();
                List<Monster> cr18 = new ArrayList<>();
                List<Monster> cr19 = new ArrayList<>();
                List<Monster> cr20 = new ArrayList<>();
                List<Monster> cr21 = new ArrayList<>();
                List<Monster> cr22 = new ArrayList<>();
                List<Monster> cr23 = new ArrayList<>();
                List<Monster> cr24 = new ArrayList<>();
                List<Monster> cr25 = new ArrayList<>();
                List<Monster> cr26 = new ArrayList<>();

                //ensure first token is an array start
                if(jsonParser.nextToken() != JsonToken.START_ARRAY){
                    throw new IllegalStateException("Expected content to be an array");
                }

                //iterate through the entire document
                while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                    //read the monster token and do something with it
                    Monster monster1 = readMonsters(jsonParser);
//                    System.out.println(monster1.getCr().intValue());

                    switch (monster1.getCr().intValue()) {
                        case -1 -> cr0.add(monster1);
                        case 0 -> cr1.add(monster1);
                        case 1 -> cr2.add(monster1);
                        case 2 -> cr3.add(monster1);
                        case 3 -> cr4.add(monster1);
                        case 4 -> cr5.add(monster1);
                        case 5 -> cr6.add(monster1);
                        case 6 -> cr7.add(monster1);
                        case 7 -> cr8.add(monster1);
                        case 8 -> cr9.add(monster1);
                        case 9 -> cr10.add(monster1);
                        case 10 -> cr11.add(monster1);
                        case 11 -> cr12.add(monster1);
                        case 12 -> cr13.add(monster1);
                        case 13 -> cr14.add(monster1);
                        case 14 -> cr15.add(monster1);
                        case 15 -> cr16.add(monster1);
                        case 16 -> cr17.add(monster1);
                        case 17 -> cr18.add(monster1);
                        case 18 -> cr19.add(monster1);
                        case 19 -> cr20.add(monster1);
                        case 20 -> cr21.add(monster1);
                        case 21 -> cr22.add(monster1);
                        case 22 -> cr23.add(monster1);
                        case 23 -> cr24.add(monster1);
                        case 24 -> cr25.add(monster1);
                        case 25 -> cr26.add(monster1);
                    }

                }
                monsters.put(-1 , cr0);
                monsters.put(0 , cr1);
                monsters.put(1 , cr2);
                monsters.put(2 , cr3);
                monsters.put(3 , cr4);
                monsters.put(4 , cr5);
                monsters.put(5 , cr6);
                monsters.put(6 , cr7);
                monsters.put(7 , cr8);
                monsters.put(8 , cr9);
                monsters.put(9 , cr10);
                monsters.put(10 , cr11);
                monsters.put(11 , cr12);
                monsters.put(12 , cr13);
                monsters.put(13, cr14);
                monsters.put(14, cr15);
                monsters.put(15 , cr16);
                monsters.put(16 , cr17);
                monsters.put(17 , cr18);
                monsters.put(18, cr19);
                monsters.put(19, cr20);
                monsters.put(20 , cr21);
                monsters.put(21 , cr22);
                monsters.put(22 , cr23);
                monsters.put(23 , cr24);
                monsters.put(24 , cr25);
                monsters.put(25 , cr26);
            }

            return monsters;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Map<String, Style> instance2(){
        try{
            File file = new File ("src/main/java/com/pathfinderGenerator/app/database/styleDB.json");
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonFactory jsonFactory = new JsonFactory();

            Map<String, Style> styleMap = new HashMap<>();

            InputStream inputStream = new FileInputStream(file);
            try(JsonParser jsonParser = jsonFactory.createParser(inputStream)){

                //ensure first token is an array start
                if(jsonParser.nextToken() != JsonToken.START_ARRAY){
                    throw new IllegalStateException("Expected content to be an array");
                }

                //iterate through the entire document
                while(jsonParser.nextToken() != JsonToken.END_ARRAY){
                    //read the monster token and do something with it
                    Style style = readStyle(jsonParser);
                    styleMap.put(style.getName(),style);

                    }

                }

            return styleMap;


            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (JsonParseException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<Monster> generateEncounter(String diff, int partySize, int partyLevel, List<String> traits){

        int difficultyXpMax = 0;
        int temp = 0;
        int currMax = 0;
        List<Monster> finishedEncounter = new ArrayList<>();

        switch (diff) {
            case "Trivial":
                temp = partySize-4;
                difficultyXpMax = Integer.parseInt(xpChart[0][1]);
                if(temp != 0){
                    int xpAdjustment = temp * Integer.parseInt(xpChart[0][2]);
                    difficultyXpMax += xpAdjustment;
                }
                temp = 0;
                break;

            case "Low":
                temp = partySize-4;
                difficultyXpMax = Integer.parseInt(xpChart[1][1]);
                if(temp != 0){
                    int xpAdjustment = temp * Integer.parseInt(xpChart[1][2]);
                    difficultyXpMax += xpAdjustment;
                }
                temp = 0;
                break;
            case "Moderate":
                temp = partySize-4;
                difficultyXpMax = Integer.parseInt(xpChart[2][1]);
                if(temp != 0){
                    int xpAdjustment = temp * Integer.parseInt(xpChart[2][2]);
                    difficultyXpMax += xpAdjustment;
                }
                temp = 0;
                break;
            case "Severe":
                temp = partySize-4;
                difficultyXpMax = Integer.parseInt(xpChart[3][1]);
                if(temp != 0){
                    int xpAdjustment = temp * Integer.parseInt(xpChart[3][2]);
                    difficultyXpMax += xpAdjustment;
                }
                temp = 0;
                break;
            case "Extreme":
                temp = partySize-4;
                difficultyXpMax = Integer.parseInt(xpChart[4][1]);
                if(temp != 0){
                    int xpAdjustment = temp * Integer.parseInt(xpChart[4][2]);
                    difficultyXpMax += xpAdjustment;
                }
                temp = 0;
                break;
        }

        //this will determine the max difficulty for the max XP we are dealing with.
        currMax = currentMax(difficultyXpMax);
        int difficultyHold = difficultyXpMax;
        while(difficultyHold > 0){

            /*
            Okay we now have the absolute max we can roll for our set difficulty, which in this case is currMax
            We will generate a number from hopefully 1 -> maxNumber can keep subtracting exp from the difficultyHold
            until we are either just under the exp allowed, or until we are at 0
             */

            int rnd = rollDice.rollDice(currMax);

            /*
            We are going to generate a random monster from depending on the partylevel and the numebr generated by rnd
            above. If the party level is 4, and rnd = 5, then 4 - 4 = 0 we get someone from the same level of the party.
            party level 4 we get a 2 then we generate an enemy equal to party level + (-2)
             */
//            int creatureRandom = (int) (Math.random() * (monsterGuide.get(partyLevel+(createXP[rnd][0])).size()) );
            int creatureRandom = rollDice.rollDice(monsterGuide.get(partyLevel+(createXP[rnd][0])).size());
//            System.out.println("creatureRandom = " + creatureRandom);
            /*
            We now retrieve that monster back and subtract the CRxp from our xp limit.
             */
            Monster monster = new Monster();
            int monsterGuideSize = monsterGuide.get(partyLevel+(createXP[rnd][0])).size();
            if(creatureRandom == 0){
                monster = monsterGuide.get(partyLevel+(createXP[rnd][0])).get(creatureRandom);
            }else if(creatureRandom == monsterGuideSize){
                monster = monsterGuide.get(partyLevel+(createXP[rnd][0])).get(creatureRandom - 1);
            } else {
//                System.out.println(monsterGuide.get((partyLevel+(createXP[rnd][0]))).size());
                monster = monsterGuide.get(partyLevel+(createXP[rnd][0])).get(creatureRandom);
            }


            if(!(traits == null)){
                if(monster.getTrait().stream().anyMatch(traits::contains)){
                    difficultyHold -= createXP[rnd][1];

                    monster.setDifficulty(diff);
                    finishedEncounter.add(monster);
                    currMax = currentMax(difficultyHold);
                }
            } else {
                difficultyHold -= createXP[rnd][1];

                monster.setDifficulty(diff);
                finishedEncounter.add(monster);
                currMax = currentMax(difficultyHold);
            }
        }

        return finishedEncounter;
    }

    private int currentMax(int difficultyXpMax){
        int currMax = 0;
        if(difficultyXpMax<= 10){
            currMax = 0;
        } else if (difficultyXpMax <= 15){
            currMax = 1;
        } else if (difficultyXpMax <= 20){
            currMax = 2;
        } else if (difficultyXpMax <= 30){
            currMax = 3;
        } else if (difficultyXpMax <= 40){
            currMax = 4;
        } else if (difficultyXpMax <= 60){
            currMax = 5;
        } else if (difficultyXpMax <= 80){
            currMax = 6;
        } else if (difficultyXpMax <= 120){
            currMax = 7;
        } else if (difficultyXpMax <= 160){
            currMax = 8;
        }
        return currMax;
    }

    public List<List<List<Monster>>> styleGenerators(StyleRequest styleRequest) throws JsonProcessingException {

        Style style1 = styleGuide.get(styleRequest.getStyleName());

        List<List<Monster>> encountersTrivial = new ArrayList<>();
        List<List<Monster>> encountersLow = new ArrayList<>();
        List<List<Monster>> encountersModerate = new ArrayList<>();
        List<List<Monster>> encountersSevere = new ArrayList<>();
        List<List<Monster>> encountersExtreme = new ArrayList<>();

        if(!style1.getTrivial().isEmpty()){
//            System.out.println(style1.getTrivial());
            int inte = Integer.parseInt(style1.getTrivial());

            for(int i = 0; i < inte; i++){
                List<Monster> encounterInternal = generateEncounter("Trivial", styleRequest.getPartySize(), styleRequest.getPartyLevel(), styleRequest.getTraits());
                encountersTrivial.add(encounterInternal);

            }

        }
        if(!style1.getLow().isEmpty()){
            int inte = Integer.parseInt(style1.getLow());
            for(int i = 0; i < inte; i++){
                List<Monster> encounterInternal = generateEncounter("Low", styleRequest.getPartySize(), styleRequest.getPartyLevel(), styleRequest.getTraits());
                encountersLow.add(encounterInternal);

            }
        }
        if(!style1.getModerate().isEmpty()){
            int inte = Integer.parseInt(style1.getModerate());
            for(int i = 0; i < inte; i++){
                List<Monster> encounterInternal = generateEncounter("Moderate", styleRequest.getPartySize(), styleRequest.getPartyLevel(), styleRequest.getTraits());
                encountersModerate.add(encounterInternal);

            }
        }
        if(!style1.getSevere().isEmpty()){
            int inte = Integer.parseInt(style1.getSevere());
            for(int i = 0; i < inte; i++){
                List<Monster> encounterInternal = generateEncounter("Severe", styleRequest.getPartySize(), styleRequest.getPartyLevel(), styleRequest.getTraits());
                encountersSevere.add(encounterInternal);

            }
        }
        if(!style1.getExtreme().isEmpty()){
            int inte = Integer.parseInt(style1.getExtreme());
            for(int i = 0; i < inte; i++){
                List<Monster> encounterInternal = generateEncounter("Extreme", styleRequest.getPartySize(), styleRequest.getPartyLevel(), styleRequest.getTraits());
                encountersExtreme.add(encounterInternal);

            }
        }

        String attempt = "Trivial : " + encountersTrivial + " Low : " + encountersLow ;

        List<List<List<Monster>>> difficultyList = new LinkedList<>();
        difficultyList.add(encountersTrivial);
        difficultyList.add(encountersLow);
        difficultyList.add(encountersModerate);
        difficultyList.add(encountersSevere);
        difficultyList.add(encountersExtreme);

//        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
//
//        try {
//            writer.writeValue(new File("Merged.json"),difficultyList);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return difficultyList;
    }
}


