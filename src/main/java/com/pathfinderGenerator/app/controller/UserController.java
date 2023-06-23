package com.pathfinderGenerator.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathfinderGenerator.app.generator.RandomEncounter;
import com.pathfinderGenerator.app.generator.StyleGenerator;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.RandomEncounterObj;
import com.pathfinderGenerator.app.object.StyleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/")
public class UserController {

    //    @Autowired
    StyleGenerator styleGenerator = new StyleGenerator();

    @CrossOrigin(origins = "http://75.46.130.114:30000")
    @RequestMapping(value ="/styleGenerator", method = RequestMethod.GET)
    public Map<String, List<List<Monster>>> runGenerator(@RequestParam String style, @RequestParam int partySize, @RequestParam int level, @RequestParam(required = false) List<String> traits, @RequestParam(required = false) List<String> source) throws JsonProcessingException {
        StyleRequest styleRequest1 = new StyleRequest();

        styleRequest1.setStyleName(style);
        styleRequest1.setPartyLevel(level);
        styleRequest1.setPartySize(partySize);
        styleRequest1.setTraits(traits);
        styleRequest1.setSource(source);
        return styleGenerator.styleGenerators(styleRequest1);
    }

    @CrossOrigin(origins = "http://75.46.130.114:30000")
    @RequestMapping(value="/randomGenerator", method = RequestMethod.GET)
    public List<Monster> randomizer(@RequestParam String environment,  @RequestParam int partySize, @RequestParam int level, @RequestParam(required = false) List<String> sourceList){
        RandomEncounter randomEncounter = new RandomEncounter();
        return randomEncounter.rndEncGenerator(environment, partySize, level, sourceList);
    }

    @CrossOrigin(origins = "http://75.46.130.114:30000")
    @RequestMapping(value="/getMonster", method = RequestMethod.GET)
    public void getMonster(@RequestParam String monsterName) throws SQLException, ClassNotFoundException, IOException {
        StyleGenerator sty = new StyleGenerator();
        sty.createMonsterQuery(monsterName);
    }

}