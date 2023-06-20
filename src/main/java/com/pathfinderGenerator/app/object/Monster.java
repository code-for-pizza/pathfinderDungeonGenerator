package com.pathfinderGenerator.app.object;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Table(name = "creatures")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Monster {
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", cr=" + cr +
                ", trait=" + trait +
                ", difficulty='" + difficulty + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    private static List<String> TRAIT_LIST = Arrays.asList("Trait 1", "Trait 2", "Trait 3",
            "Trait 4", "Trait 5", "Trait 6", "Trait 7");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name="cr")
    @JsonSetter("Creature Level")
    private Integer cr;
    @Column(name = "traits")
    @JsonSetter("Trait")
    private List<String> trait;

    @Column(name = "sources")
    private String source;

    private String difficulty;

    // Denotes the type of the encounter. If null it's probably a monster
    private String encType;
    // TODO: figure out type checking and subclasses and separate this class out
    private String harmlessDescription;
}