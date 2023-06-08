package com.pathfinderGenerator.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathfinderGenerator.app.generator.StyleGenerator;
import com.pathfinderGenerator.app.object.Monster;
import com.pathfinderGenerator.app.object.StyleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    StyleGenerator styleGenerator;

    @RequestMapping(value ="/styleGenerator", method = RequestMethod.GET)
    public List<List<List<Monster>>> runGenerator(@RequestBody StyleRequest styleRequest) throws JsonProcessingException {
        return styleGenerator.styleGenerators(styleRequest);
    }

}
