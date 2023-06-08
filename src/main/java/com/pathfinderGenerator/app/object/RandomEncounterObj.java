package com.pathfinderGenerator.app.object;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RandomEncounterObj {

    @JsonSetter("Terrain Type")
    private String terrain;

    @JsonSetter("Flat DC")
    private int dc;
}
