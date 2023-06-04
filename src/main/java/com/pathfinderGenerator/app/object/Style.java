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
public class Style {

    @Override
    public String toString() {
        return "Style{" +
                "name='" + name + '\'' +
                ", trivial='" + trivial + '\'' +
                ", low='" + low + '\'' +
                ", moderate='" + moderate + '\'' +
                ", severe='" + severe + '\'' +
                ", extreme='" + extreme + '\'' +
                '}';
    }

    private String name;

    @JsonSetter("Combat Encounter Trivial")
    private String trivial;

    @JsonSetter("Combat Encounter Low")
    private String low;

    @JsonSetter("Combat Encounter Moderate")
    private String moderate;

    @JsonSetter("Combat Encounter Severe")
    private String severe;

    @JsonSetter("Combat Encounter Extreme")
    private String extreme;
}
