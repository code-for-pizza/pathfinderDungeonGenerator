package com.pathfinderGenerator.app.generator.randomEncounterTools;

public class HazardEnvDetails {

    public String[] aquatic() {
        String[] Forest = new String[5];
        Forest[0] = "Waterborne diseases: Exposure to untreated or contaminated water. Fortitude DC";
        Forest[1] = "Rip currents and undertows: These strong currents can pose a risk to swimmers. Survival DC / Fortitude DC";
        Forest[2] = "Boating accidents: Collisions, capsizing, or machinery malfunctions. Survival DC";
        Forest[3] = "Algal blooms: Harmful algal blooms releasing toxins that are hazardous to both humans and animals. Fortitude DC / Nature DC";
        Forest[4] = "Sun exposure: The sun is beaming stronger than usual. Fortitude DC / Survival DC";
        return Forest;
    }

    public String[] arctic() {
        String[] Forest = new String[5];
        Forest[0] = "Extreme cold: A coldfront appears, exposing you to sub-zero temperatures. Fortitude DC";
        Forest[1] = "Icy terrain: Slippery and uneven ice surfaces can pose a risk of falls and injuries. Reflex DC";
        Forest[2] = "Isolation and limited resources: Limited access to resource. double food useage Nature DC [Hard]";
        Forest[3] = "Avalanches: an especially heavy period of heavy snowfall and strong winds. Fortitude DC / Survival DC";
        Forest[4] = "Snowstorms and blizzards: Harsh weather conditions such as snowstorms or blizzards. Reduce visibility. Survival DC you are Lost";
        return Forest;
    }

    public String[] forest() {
        String[] Forest = new String[5];
        Forest[0] = "Wildlife encounters: Encounters with a poisonous animal such as snakes, or insects can pose a threat to safety. Fortitude DC";
        Forest[1] = "Uneven terrain: Tripping or falling due to uneven ground, tree roots, or hidden obstacles. Reflex DC";
        Forest[2] = "Weather conditions: Sudden changes in weather, such as thunderstorms, heavy rain, or extreme temperatures, slowing you down. Survival DC";
        Forest[3] = "Poisonous plants: Accidentally coming into contact with poisonous plants like poison ivy or poison oak. Fortitude DC / Nature DC";
        Forest[4] = "Getting lost: Disorientation or losing track of your location within the dense forest can lead to hazardous situations. Survival DC";
        return Forest;
    }

    public String[] mountain() {
        String[] Forest = new String[5];
        Forest[0] = "Altitude sickness: You suffer from altitude sickness. Fortitude DC";
        Forest[1] = "Difficult terrain: You are slowed down, steep, uneven, or unstable terrain increases the risk of slips, Survival DC / Reflex DC";
        Forest[2] = "Lack of resources: Limited access, food, and clean water, double food usage. Survival DC";
        Forest[3] = "Physical exhaustion: The high altitudes lead to physical [Fatigue]. Fortitude DC";
        Forest[4] = "Falling rocks and avalanches: Loose rocks, falling debris, and avalanches! Survival DC";
        return Forest;
    }

    public String[] plains() {
        String[] Forest = new String[5];
        Forest[0] = "Extreme weather conditions: Plains are often subject to severe weather such as thunderstorms, tornadoes. Survival DC / Nature DC";
        Forest[1] = "Wildfires: Dry grasslands and vegetation in plains can be susceptible to wildfires. Survival DC";
        Forest[2] = "Flash floods: Despite the flat terrain, the heavy rainfall causes a flash flood! Survival DC";
        Forest[3] = "Heat-related illnesses: Intense heat and sun exposure in plains can lead to heat exhaustion, heatstroke, and dehydration. [Fatigue] Fortitude DC";
        Forest[4] = "Dust storms: A dust storm appears! Double food useage as you are lost Survival DC";
        return Forest;
    }

    public String[] swamp() {
        String[] Forest = new String[5];
        Forest[0] = "Muddy terrain: You are stuck in the mud, Survival DC";
        Forest[1] = "Insect-borne diseases: a swarm of insects surround you. [Disease] Fortitude DC";
        Forest[2] = "Venomous snakes: A Venomous snake bits you! [Poison] Fortitude DC";
        Forest[3] = "Difficult navigation: Navigating through dense vegetation, waterways, and the intricate swamp terrain makes the party get lost Double Rations Survival DC";
        Forest[4] = "Waterborne illnesses: The standing water in swamps harbors bacteria and parasites. [Disease] Fortitude DC";
        return Forest;
    }

}
