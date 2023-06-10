package com.pathfinderGenerator.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathfinderGenerator.app.generator.StyleGenerator;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.StyleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UserController {

//    @Autowired
    StyleGenerator styleGenerator = new StyleGenerator();

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value ="/styleGenerator", method = RequestMethod.GET)
    public Map<String, List<List<Monster>>> runGenerator(@RequestParam String style, @RequestParam int partySize, @RequestParam int level) throws JsonProcessingException {
//            System.out.println("style = " + style);
            StyleRequest styleRequest1 = new StyleRequest();

            styleRequest1.setStyleName(style);
            styleRequest1.setPartyLevel(level);
            styleRequest1.setPartySize(partySize);
        return styleGenerator.styleGenerators(styleRequest1);
    }

}
