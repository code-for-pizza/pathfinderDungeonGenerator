package com.pathfinderGenerator.app.utility;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.RandomEncounterObj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Extractor {



    public void sqlExtractor() throws FileNotFoundException {
        File file = new File ("src/main/java/com/pathfinderGenerator/app/database/monsterDB.json");
        JsonFactory jsonFactory = new JsonFactory();

        Map<Integer, List<Monster>> monsters = new HashMap<>();
        Map<String, Monster> monsterMap = new HashMap<>();

        InputStream inputStream = new FileInputStream(file);
        try(JsonParser jsonParser = jsonFactory.createParser(inputStream)) {

            //ensure first token is an array start
            if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected content to be an array");
            }

            //iterate through the entire document
                //read the monster token and do something with it
                System.out.println("Generating SQL query");
                String x = "INSERT INTO creatures " +
                        "(name, cr, traits, sources, hp, ac, abilityScore, savingThrows, immunities, resistance, speed, actions, skills)" +
                        "VALUES \r\n";

                ObjectMapper objectMapper = new ObjectMapper();


                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {


                        //this will be the new SQL generator
                        String temp;
                        Monster monster1 = readMonsters(jsonParser);
                        String tempSource = monster1.getSource().replaceAll("#", "");
                        String tempName = monster1.getName().replaceAll("'", "");
                        String tempTrait = monster1.getTrait().stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",", "'", "'"));
                        String tempResistance = monster1.getResistance().stream().map(r -> String.valueOf(r)).collect(Collectors.joining(",","'","'"));
                        temp = "( '" + tempName + "' ," + monster1.getCr() + "," + tempTrait
                                + ", '" + tempSource + "' , '" + monster1.getHp() + "', '"+ monster1.getAc() + "', '"+
                                objectMapper.writeValueAsString(monster1.getAbilityScore()) +
                                "', '"+ objectMapper.writeValueAsString(monster1.getSavingThrows()) + "' , '"+ monster1.getImmunities() + "', '"+
                                monster1.getResistance() + "', '" + monster1.getSpeed()+ "', '" + objectMapper.writeValueAsString(monster1.getActions()) +
                                "', '" + objectMapper.writeValueAsString(monster1.getSkills()) +"' ), \r\n";

                        x += temp;

                    }


                try {
                    FileWriter fileWriter = new FileWriter("insertMonsterDb.sql");
                    fileWriter.write(x);
                    fileWriter.close();
                    System.out.println("Writing completed.");
                } catch (IOException e) {
                    e.printStackTrace();
                }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Monster readMonsters(JsonParser jsonParser) throws IOException {
        Monster monster = new Monster();
        List<String> traitList = new ArrayList<>();
        Map<String, String> MAP_LIST = new HashMap<>();
        Map<String, String> ST_LIST = new HashMap<>();
        Map<String, String> SK_LIST = new HashMap<>();
        List<String> IMMUNITIES_LIST = new ArrayList<>();
        List<String> RESISTANCE_LIST = new ArrayList<>();
        Map<String, String> ACT_LIST = new HashMap<>();

        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            String Property = jsonParser.getCurrentName();

            jsonParser.nextToken();

            //Figure out what to do with these properties

            switch (Property) {
                case "name":
                    monster.setName(jsonParser.getValueAsString());
                    break;
                case "HP":
                    monster.setHp(jsonParser.getIntValue());
                    break;
                case "AC":
                    monster.setAc(jsonParser.getIntValue());
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
                case "Source":
                    monster.setSource(jsonParser.getValueAsString());
                    break;
                case "Dexterity":
                case "Constitution":
                case "Intelligence":
                case "Wisdom":
                case "Charisma":
                case "Strength":
                    MAP_LIST.put(Property,jsonParser.getValueAsString());
                    break;
                case "Fort":
                case "Ref":
                case "Will":
                    ST_LIST.put(Property, jsonParser.getValueAsString());
                    break;
                case "Acrobatics":
                case "Arcana":
                case "Athletics":
                case "Crafting":
                case "Deception":
                case "Diplomacy":
                case "Intimidation":
                case "Medicine":
                case "Nature":
                case "Occultism":
                case "Performance":
                case "Religion":
                case "Society":
                case "Stealth":
                case "Survival":
                case "Thievery":
                    if(jsonParser.getValueAsString() == null){SK_LIST.put(Property, "0"); break;}
                    SK_LIST.put(Property, jsonParser.getValueAsString());
                    break;
                case "Immunities":
                    String tempImmune = jsonParser.getValueAsString();
                    IMMUNITIES_LIST = List.of(tempImmune.split(", "));
                    break;
                case "Resistances":
                    RESISTANCE_LIST = List.of(jsonParser.getValueAsString().split(", "));
                    RESISTANCE_LIST.stream().forEach((e) -> e.split(" "));
                    break;
                case "Speed":
                    monster.setSpeed(jsonParser.getValueAsString());
                    break;
                case "Attack 1":
                case "Attack 2":
                case "Attack 3":
                case "Attack 4":
                case "Attack 5":
                case "Attack 6":
                case "Attack 7":
                case "Spells 1":
                case "Spells 2":
                case "Spells 3":
                case "Reactions 1":
                case "Reactions 2":
                case "Reactions 3":
                    ACT_LIST.put(Property,jsonParser.getValueAsString());
                    break;
            }


        }
        monster.setAbilityScore(MAP_LIST);
        monster.setTrait(traitList);
        monster.setSkills( SK_LIST);
        monster.setSavingThrows(ST_LIST);
        monster.setImmunities(IMMUNITIES_LIST);
        monster.setResistance(RESISTANCE_LIST);
        monster.setActions(ACT_LIST);

        return monster;
    }

}
