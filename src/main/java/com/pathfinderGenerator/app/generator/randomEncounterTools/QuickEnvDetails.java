package com.pathfinderGenerator.app.generator.randomEncounterTools;

import java.util.HashMap;
import java.util.Map;

public class QuickEnvDetails {

    public Map<String, String[]> aquatic() {

        Map<String, String[]> Aquatic = new HashMap<String, String[]>();
        Aquatic.put("Sights", new String[]{"choppy water", "rolling waves", "sunlight glinting", "the curve of the horizon", "driftwood"});
        Aquatic.put("Sounds", new String[]{"waves lapping against a ship", "seabirds’ cries", "fluttering sails", "creatures breaching the surface"});
        Aquatic.put("Smells", new String[]{"salt water", "crisp fresh air", "dead fish"});
        Aquatic.put("Textures", new String[]{"frigid water", "slimy seaweed", "crusty salt collecting on surfaces"});
        Aquatic.put("Weather", new String[]{"powerful winds", "oncoming storms"});
        return Aquatic;
    }

    public Map<String, String[]> arctic() {
        Map<String, String[]> Arctic = new HashMap<String, String[]>();
        Arctic.put("Sights", new String[]{"blinding reflected sunlight", "snowy plains", "distant glaciers", "deep crevasses", "rocky cliffs", "ice floes and bergs", "animal tracks in snow"});
        Arctic.put("Sounds", new String[]{"howling winds", " drips of melting ice", " utter quiet"});
        Arctic.put("Smells", new String[]{"clean air", " half-frozen bog", " lichen", " seaweed"});
        Arctic.put("Textures", new String[]{"crunching snow", " hard ice"});
        Arctic.put("Weather", new String[]{"frigid gales", " light snowfall", " pounding blizzard"});
        return Arctic;
    }
    public Map<String, String[]> forest() {
        Map<String, String[]> Forest = new HashMap<String, String[]>();
        Forest.put("Sights", new String[]{"towering trees", " dense undergrowth", " verdant canopies", " colorful wildlife", " dappled sunlight through the trees", " mossy tree trunks", " twisted roots"});
        Forest.put("Sounds", new String[]{"rustling leaves", " snapping branches", " animal calls"});
        Forest.put("Smells", new String[]{"decomposing vegetation", " flowering plants", " pine trees", " earthy mushrooms"});
        Forest.put("Textures", new String[]{"leaves crunching underfoot", " scraping branches", " water dripping from above", " rough bark"});
        Forest.put("Weather", new String[]{"still air", " cool shade", " sporadic breeze", " rain on the canopy", " branches coated in thick snow"});
        return Forest;
    }

    public Map<String, String[]> mountain() {
        Map<String, String[]> Mountain = new HashMap<String, String[]>();
        Mountain.put("Sights", new String[]{"bare cliffs", " snow caps", " hardy trees", " slopes littered with scree", " fallen rocks", " birds flying on currents", " fog among the peaks"});
        Mountain.put("Sounds", new String[]{"howling wind", " falling rocks", " clear echoes", " crunch of rocks underfoot", " distant avalanche"});
        Mountain.put("Smells", new String[]{"blowing dust", " pine trees", " fresh snow"});
        Mountain.put("Textures", new String[]{"rough stone", " powdery snow", " unstable rubble"});
        Mountain.put("Weather", new String[]{"swirling clouds", " chill of high altitude", " direct sunlight", " powerful wind and rain"});
        return Mountain;
    }

    public Map<String, String[]> plains() {
        Map<String, String[]> Plains = new HashMap<String, String[]>();
        Plains.put("Sights", new String[]{"grass waving gently", " scattered wildflowers", " rocky outcroppings or boulders", " the curve of the horizon"});
        Plains.put("Sounds", new String[]{"rustling wind", " birdsong", " distant sounds carried far"});
        Plains.put("Smells", new String[]{"fresh air", " earthy soil", " distant carcasses"});
        Plains.put("Textures", new String[]{"touch of tall grass", " rasp of scrub brush", " crunch of dry dirt"});
        Plains.put("Weather", new String[]{"cooling of gentle wind", " heat of direct sunlight", " massive black thunderclouds"});
        return Plains;
    }

    public Map<String, String[]> swamp() {
        Map<String, String[]> Swamp = new HashMap<String, String[]>();
        Swamp.put("Sights", new String[]{"lush leaves", " clouds of gnats", " algae-coated water", " shacks on stilts", " darting fish"});
        Swamp.put("Sounds", new String[]{"croaking frogs", " chirping insects", " bubbling", " splashing"});
        Swamp.put("Smells", new String[]{"rich moss and algae", " pungent swamp gases"});
        Swamp.put("Textures", new String[]{"pushing through floating detritus", " tangling creepers", " thick mud"});
        Swamp.put("Weather", new String[]{"oppressive humidity", " still air", " pouring rain", " rays of sunlight"});
        return Swamp;
    }

    public Map<String, String[]> underground() {
        Map<String, String[]> Underground = new HashMap<String, String[]>();
        Underground.put("Sights", new String[]{"winding passages"," sputtering yellow torchlight"," uneven or cracked floors"," ancient writings or architecture"," stalagmites and stalactites"});
        Underground.put("Sounds", new String[]{"dripping condensation"," scurrying rats or insects"," distant clunks of machinery"," tinny echoes of your voices and footsteps"});
        Underground.put("Smells", new String[]{"staleness of still air"," sulfur"," tang of metal deposits"});
        Underground.put("Textures", new String[]{"rough rock walls"," erosion-smoothed stone"," cobwebs"});
        Underground.put("Weather", new String[]{"chill of underground air"," geothermal heat"});
        return Underground;
    }


}
