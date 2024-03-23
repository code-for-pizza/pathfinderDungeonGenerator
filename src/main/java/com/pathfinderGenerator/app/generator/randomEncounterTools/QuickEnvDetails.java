package com.pathfinderGenerator.app.generator.randomEncounterTools;

import java.util.HashMap;
import java.util.Map;

public class QuickEnvDetails {

    public Map<String, String[]> aquatic() {

        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"choppy water", "rolling waves", "sunlight glinting", "the curve of the horizon", "driftwood"});
        description.put("Sounds", new String[]{"waves lapping against a ship", "seabirds’ cries", "fluttering sails", "creatures breaching the surface"});
        description.put("Smells", new String[]{"salt water", "crisp fresh air", "dead fish"});
        description.put("Textures", new String[]{"frigid water", "slimy seaweed", "crusty salt collecting on surfaces"});
        description.put("Weather", new String[]{"powerful winds", "oncoming storms"});
        return description;
    }

    public Map<String, String[]> arctic() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"blinding reflected sunlight", "snowy plains", "distant glaciers", "deep crevasses", "rocky cliffs", "ice floes and bergs", "animal tracks in snow"});
        description.put("Sounds", new String[]{"howling winds", " drips of melting ice", " utter quiet"});
        description.put("Smells", new String[]{"clean air", " half-frozen bog", " lichen", " seaweed"});
        description.put("Textures", new String[]{"crunching snow", " hard ice"});
        description.put("Weather", new String[]{"frigid gales", " light snowfall", " pounding blizzard"});
        return description;
    }
    public Map<String, String[]> forest() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"towering trees", " dense undergrowth", " verdant canopies", " colorful wildlife", " dappled sunlight through the trees", " mossy tree trunks", " twisted roots"});
        description.put("Sounds", new String[]{"rustling leaves", " snapping branches", " animal calls"});
        description.put("Smells", new String[]{"decomposing vegetation", " flowering plants", " pine trees", " earthy mushrooms"});
        description.put("Textures", new String[]{"leaves crunching underfoot", " scraping branches", " water dripping from above", " rough bark"});
        description.put("Weather", new String[]{"still air", " cool shade", " sporadic breeze", " rain on the canopy", " branches coated in thick snow"});
        return description;
    }

    public Map<String, String[]> mountain() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"bare cliffs", " snow caps", " hardy trees", " slopes littered with scree", " fallen rocks", " birds flying on currents", " fog among the peaks"});
        description.put("Sounds", new String[]{"howling wind", " falling rocks", " clear echoes", " crunch of rocks underfoot", " distant avalanche"});
        description.put("Smells", new String[]{"blowing dust", " pine trees", " fresh snow"});
        description.put("Textures", new String[]{"rough stone", " powdery snow", " unstable rubble"});
        description.put("Weather", new String[]{"swirling clouds", " chill of high altitude", " direct sunlight", " powerful wind and rain"});
        return description;
    }

    public Map<String, String[]> plains() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"grass waving gently", " scattered wildflowers", " rocky outcroppings or boulders", " the curve of the horizon"});
        description.put("Sounds", new String[]{"rustling wind", " birdsong", " distant sounds carried far"});
        description.put("Smells", new String[]{"fresh air", " earthy soil", " distant carcasses"});
        description.put("Textures", new String[]{"touch of tall grass", " rasp of scrub brush", " crunch of dry dirt"});
        description.put("Weather", new String[]{"cooling of gentle wind", " heat of direct sunlight", " massive black thunderclouds"});
        return description;
    }

    public Map<String, String[]> swamp() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"lush leaves", " clouds of gnats", " algae-coated water", " shacks on stilts", " darting fish"});
        description.put("Sounds", new String[]{"croaking frogs", " chirping insects", " bubbling", " splashing"});
        description.put("Smells", new String[]{"rich moss and algae", " pungent swamp gases"});
        description.put("Textures", new String[]{"pushing through floating detritus", " tangling creepers", " thick mud"});
        description.put("Weather", new String[]{"oppressive humidity", " still air", " pouring rain", " rays of sunlight"});
        return description;
    }

    public Map<String, String[]> underground() {
        Map<String, String[]> description = new HashMap<String, String[]>();
        description.put("Sights", new String[]{"winding passages"," sputtering yellow torchlight"," uneven or cracked floors"," ancient writings or architecture"," stalagmites and stalactites"});
        description.put("Sounds", new String[]{"dripping condensation"," scurrying rats or insects"," distant clunks of machinery"," tinny echoes of your voices and footsteps"});
        description.put("Smells", new String[]{"staleness of still air"," sulfur"," tang of metal deposits"});
        description.put("Textures", new String[]{"rough rock walls"," erosion-smoothed stone"," cobwebs"});
        description.put("Weather", new String[]{"chill of underground air"," geothermal heat"});
        return description;
    }


}
