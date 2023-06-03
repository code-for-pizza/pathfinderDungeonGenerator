package com.pathfinderGenerator.app.generator;

import java.util.HashMap;
import java.util.Map;

public class quickEnvDetails {

    public void quickEnvDetails() {

        Map<String, String[]> qEDAquatic = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"choppy water", "rolling waves", "sunlight glinting","the curve of the horizon","driftwood"});
        qEDAquatic.put("Sounds", new String[]{"waves lapping against a ship", "seabirds’ cries", "fluttering sails", "creatures breaching the surface"});
        qEDAquatic.put("Smells", new String[]{"salt water", "crisp fresh air", "dead fish"});
        qEDAquatic.put("Textures", new String[]{"frigid water", "slimy seaweed", "crusty salt collecting on surfaces"});
        qEDAquatic.put("Weather", new String[]{"powerful winds", "oncoming storms"});

        Map<String, String[]> qEDArctic = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"blinding reflected sunlight","snowy plains","distant glaciers","deep crevasses","rocky cliffs","ice floes and bergs","animal tracks in snow"});
        qEDAquatic.put("Sounds", new String[]{"howling winds"," drips of melting ice"," utter quiet"});
        qEDAquatic.put("Smells", new String[]{"clean air"," half-frozen bog"," lichen"," seaweed"});
        qEDAquatic.put("Textures", new String[]{"crunching snow"," hard ice"});
        qEDAquatic.put("Weather", new String[]{"frigid gales"," light snowfall"," pounding blizzard"});

        Map<String, String[]> qEDForest = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"towering trees"," dense undergrowth"," verdant canopies"," colorful wildlife"," dappled sunlight through the trees"," mossy tree trunks"," twisted roots"});
        qEDAquatic.put("Sounds", new String[]{"rustling leaves"," snapping branches"," animal calls"});
        qEDAquatic.put("Smells", new String[]{"decomposing vegetation"," flowering plants"," pine trees"," earthy mushrooms"});
        qEDAquatic.put("Textures", new String[]{"leaves crunching underfoot"," scraping branches"," water dripping from above"," rough bark"});
        qEDAquatic.put("Weather", new String[]{"still air"," cool shade"," sporadic breeze"," rain on the canopy"," branches coated in thick snow"});

        Map<String, String[]> qEDMountain = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"bare cliffs"," snow caps"," hardy trees"," slopes littered with scree"," fallen rocks"," birds flying on currents"," fog among the peaks"});
        qEDAquatic.put("Sounds", new String[]{"howling wind"," falling rocks"," clear echoes"," crunch of rocks underfoot"," distant avalanche"});
        qEDAquatic.put("Smells", new String[]{"blowing dust"," pine trees"," fresh snow"});
        qEDAquatic.put("Textures", new String[]{"rough stone"," powdery snow"," unstable rubble"});
        qEDAquatic.put("Weather", new String[]{"swirling clouds"," chill of high altitude"," direct sunlight"," powerful wind and rain"});

        Map<String, String[]> qEDPlains = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"grass waving gently"," scattered wildflowers"," rocky outcroppings or boulders"," the curve of the horizon"});
        qEDAquatic.put("Sounds", new String[]{"rustling wind"," birdsong"," distant sounds carried far"});
        qEDAquatic.put("Smells", new String[]{"fresh air"," earthy soil"," distant carcasses"});
        qEDAquatic.put("Textures", new String[]{"touch of tall grass"," rasp of scrub brush"," crunch of dry dirt"});
        qEDAquatic.put("Weather", new String[]{"cooling of gentle wind"," heat of direct sunlight"," massive black thunderclouds"});

        Map<String, String[]> qEDSwamp = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"lush leaves"," clouds of gnats"," algae-coated water"," shacks on stilts"," darting fish"});
        qEDAquatic.put("Sounds", new String[]{"croaking frogs"," chirping insects"," bubbling"," splashing"});
        qEDAquatic.put("Smells", new String[]{"rich moss and algae"," pungent swamp gases"});
        qEDAquatic.put("Textures", new String[]{"pushing through floating detritus"," tangling creepers"," thick mud"});
        qEDAquatic.put("Weather", new String[]{"oppressive humidity"," still air"," pouring rain"," rays of sunlight"});

        Map<String, String[]> qEDUnderground = new HashMap<String, String[]>();
        qEDAquatic.put("Sights", new String[]{"winding passages"," sputtering yellow torchlight"," uneven or cracked floors"," ancient writings or architecture"," stalagmites and stalactites"});
        qEDAquatic.put("Sounds", new String[]{"dripping condensation"," scurrying rats or insects"," distant clunks of machinery"," tinny echoes of your voices and footsteps"});
        qEDAquatic.put("Smells", new String[]{"staleness of still air"," sulfur"," tang of metal deposits"});
        qEDAquatic.put("Textures", new String[]{"rough rock walls"," erosion-smoothed stone"," cobwebs"});
        qEDAquatic.put("Weather", new String[]{"chill of underground air"," geothermal heat"});

    }


}
