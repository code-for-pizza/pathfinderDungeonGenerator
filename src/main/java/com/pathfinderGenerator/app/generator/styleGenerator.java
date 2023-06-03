package com.pathfinderGenerator.app.generator;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.Style;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class styleGenerator {

    static ObjectMapper objectMapper = new ObjectMapper();

    static Map<Integer, List<Monster>> monsterGuide = new styleGenerator().instance();
    static Map<String, Style> styleGuide = new styleGenerator().instance2();

    private Style readStyle(JsonParser jsonParser) throws IOException {
        Style style = new Style();
        List<String> traitList = new ArrayList<>();

        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String Property = jsonParser.getCurrentName();
//            System.out.println(Property);

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
//            System.out.println(Property);

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
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
                case "Trait 3":
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
                case "Trait 4":
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
                case "Trait 5":
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
                case "Trait 6":
                    if(jsonParser.getValueAsString().isEmpty()) break;
                    traitList.add(jsonParser.getValueAsString());
                    break;
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

//            System.out.println(monsters.get(3).size());
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

    private List<Monster> generateEncounter(int xp){

        return null;
    }




    public void styleGenerators(String style, int partySize, int partyLevel){

        Style style1 = styleGuide.get(style);
        //okay lets retrieve the style guide
        System.out.println("Name "+style1.getName()+" Enounters "+style1.getTrivial()+", "+style1.getLow()+", "+style1.getModerate()+", "+style1.getSevere()+", "+style1.getExtreme());
        System.out.println("style = " + style + ", partySize = " + partySize + ", partyLevel = " + partyLevel);

        for(int i = 0; i < Integer.getInteger(style1.getTrivial()); i++){

        }
        for(int i = 0; i < Integer.getInteger(style1.getLow()); i++){

        }
        for(int i = 0; i < Integer.getInteger(style1.getModerate()); i++){

        }
        for(int i = 0; i < Integer.getInteger(style1.getSevere()); i++){

        }
        for(int i = 0; i < Integer.getInteger(style1.getExtreme()); i++){

        }

//        System.out.println(monsterGuide.get(3));


    }
}


