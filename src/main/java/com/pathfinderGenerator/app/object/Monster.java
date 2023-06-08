package com.pathfinderGenerator.app.object;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Monster {
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", cr=" + cr +
                ", trait=" + trait +
                '}';
    }

    private static List<String> TRAIT_LIST = Arrays.asList("Trait 1", "Trait 2", "Trait 3",
            "Trait 4", "Trait 5", "Trait 6", "Trait 7");

    private String name;
    @JsonSetter("Creature Level")
    private Integer cr;
    @JsonSetter("Trait")
    private List<String> trait;

    private String difficulty;

}
