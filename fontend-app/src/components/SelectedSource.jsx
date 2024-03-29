import React from 'react';
import {Form} from 'react-bootstrap';

function SelectedSource({setNewSource}) {
    return (
        <Form.Select size="sm" className="mb-3" onChange={e => setNewSource(e)}>
            <option>Select Source</option>
            <option value ="All">All options</option>
            <option value ="1-00: Origin of the Open Road">1-00: Origin of the Open Road</option>
            <option value ="1-01: The Absalom Initiation">1-01: The Absalom Initiation</option>
            <option value ="1-02: The Mosquito Witch">1-02: The Mosquito Witch</option>
            <option value ="1-03: Escaping the Grave">1-03: Escaping the Grave</option>
            <option value ="1-04: Bandits of Immenwood">1-04: Bandits of Immenwood</option>
            <option value ="1-05: Trailblazerse28099 Bounty">1-05: Trailblazerse28099 Bounty</option>
            <option value ="1-06: Lost on the Spirit Road">1-06: Lost on the Spirit Road</option>
            <option value ="1-07: Flooded Kinge28099s Court">1-07: Flooded Kinge28099s Court</option>
            <option value ="1-08: Revolution on the Riverside">1-08: Revolution on the Riverside</option>
            <option value ="1-09: Star-Crossed Voyages">1-09: Star-Crossed Voyages</option>
            <option value ="1-10: Tarnbreakere28099s Trail">1-10: Tarnbreakere28099s Trail</option>
            <option value ="1-11: Flames of Rebellion">1-11: Flames of Rebellion</option>
            <option value ="1-12: The Burden of Envy">1-12: The Burden of Envy</option>
            <option value ="1-13: Devil at the Crossroads">1-13: Devil at the Crossroads</option>
            <option value ="1-14: Lions of Katapesh">1-14: Lions of Katapesh</option>
            <option value ="1-15: The Blooming Catastrophe">1-15: The Blooming Catastrophe</option>
            <option value ="1-16: The Perennial Crown Part 1: Opal of Bhopan">1-16: The Perennial Crown Part 1: Opal of Bhopan</option>
            <option value ="1-17: The Perennial Crown Part 2: The Thorned Monarch">1-17: The Perennial Crown Part 2: The Thorned Monarch</option>
            <option value ="1-18: Lodge of the Living God">1-18: Lodge of the Living God</option>
            <option value ="1-19: Iolite Squad Alpha">1-19: Iolite Squad Alpha</option>
            <option value ="1-20: The Lost Legend">1-20: The Lost Legend</option>
            <option value ="1-21: Mistress of the Maze">1-21: Mistress of the Maze</option>
            <option value ="1-22: Doom of Cassomir">1-22: Doom of Cassomir</option>
            <option value ="1-24: Lightning Strikes, Stars Fall">1-24: Lightning Strikes, Stars Fall</option>
            <option value ="10: The Broken Scales">10: The Broken Scales</option>
            <option value ="1: Sundered Waves">1: Sundered Waves</option>
            <option value ="1: The Sandstone Secret">1: The Sandstone Secret</option>
            <option value ="2-00: The King in Thorns [Tiers 1-2]">2-00: The King in Thorns [Tiers 1-2]</option>
            <option value ="2-00: The King in Thorns [Tiers 3-6]">2-00: The King in Thorns [Tiers 3-6]</option>
            <option value ="2-00: The King in Thorns [Tiers 7-8]">2-00: The King in Thorns [Tiers 7-8]</option>
            <option value ="2-01: Citadel of Corruption">2-01: Citadel of Corruption</option>
            <option value ="2-01: The Whitefang Wyrm">2-01: The Whitefang Wyrm</option>
            <option value ="2-02: Blood of the Beautiful">2-02: Blood of the Beautiful</option>
            <option value ="2-02: Mountain of Sea and Sky">2-02: Mountain of Sea and Sky</option>
            <option value ="2-03: Catastrophee28099s Spark">2-03: Catastrophee28099s Spark</option>
            <option value ="2-03: Shadows and Scarecrows">2-03: Shadows and Scarecrows</option>
            <option value ="2-04: Path of Kings">2-04: Path of Kings</option>
            <option value ="2-05: Balancing the Scales">2-05: Balancing the Scales</option>
            <option value ="2-06: The Crashing Wave">2-06: The Crashing Wave</option>
            <option value ="2-07: The Blakros Deception">2-07: The Blakros Deception</option>
            <option value ="2-08: A Frosty Mug">2-08: A Frosty Mug</option>
            <option value ="2-09: The Seven Secrets of Dacilane Academy">2-09: The Seven Secrets of Dacilane Academy</option>
            <option value ="2-10: In Burning Dawn">2-10: In Burning Dawn</option>
            <option value ="2-11: The Pathfinder Trials">2-11: The Pathfinder Trials</option>
            <option value ="2-12: Snakes in the Grass">2-12: Snakes in the Grass</option>
            <option value ="2-13: A Gilded Test">2-13: A Gilded Test</option>
            <option value ="2-14: Lost in Flames">2-14: Lost in Flames</option>
            <option value ="2-7: Cleanup Duty">2-7: Cleanup Duty</option>
            <option value ="2: Unforgiving Fire">2: Unforgiving Fire</option>
            <option value ="3: Grehundee28099s Gorget">3: Grehundee28099s Gorget</option>
            <option value ="4: Port Peril Pub Crawl">4: Port Peril Pub Crawl</option>
            <option value ="5: The Dragon Who Stole Evoking Day">5: The Dragon Who Stole Evoking Day</option>
            <option value ="6: Archaeology in Aspenthar">6: Archaeology in Aspenthar</option>
            <option value ="7: A Curious Claim">7: A Curious Claim</option>
            <option value ="8: Shadows of the Black Sovereign">8: Shadows of the Black Sovereign</option>
            <option value ="9: Wayfinder Origins">9: Wayfinder Origins</option>
            <option value ="Abomination Vaults - 01 - Ruins of Gauntlight">Abomination Vaults - 01 - Ruins of Gauntlight</option>
            <option value ="Abomination Vaults - 02 - Hands of the Devil">Abomination Vaults - 02 - Hands of the Devil</option>
            <option value ="Abomination Vaults - 03 - Eyes of Empty Death">Abomination Vaults - 03 - Eyes of Empty Death</option>
            <option value ="Age of Ashes - 01 - Hellknight Hill">Age of Ashes - 01 - Hellknight Hill</option>
            <option value ="Age of Ashes - 02 - Cult of Cinders">Age of Ashes - 02 - Cult of Cinders</option>
            <option value ="Age of Ashes - 03 - Tomorrow Must Burn">Age of Ashes - 03 - Tomorrow Must Burn</option>
            <option value ="Age of Ashes - 04 - Fires of the Haunted City">Age of Ashes - 04 - Fires of the Haunted City</option>
            <option value ="Age of Ashes - 05 - Against the Scarlet Triad">Age of Ashes - 05 - Against the Scarlet Triad</option>
            <option value ="Age of Ashes - 06 - Broken Promises">Age of Ashes - 06 - Broken Promises</option>
            <option value ="Agents of Edgewatch - 01 - Devil at the Dreaming Palace">Agents of Edgewatch - 01 - Devil at the Dreaming Palace</option>
            <option value ="Agents of Edgewatch - 02 - Sixty Feet Under">Agents of Edgewatch - 02 - Sixty Feet Under</option>
            <option value ="Agents of Edgewatch - 03 - All or Nothing">Agents of Edgewatch - 03 - All or Nothing</option>
            <option value ="Agents of Edgewatch - 04 - Assault on Hunting Lodge Seven">Agents of Edgewatch - 04 - Assault on Hunting Lodge Seven</option>
            <option value ="Agents of Edgewatch - 05 - Belly of the Black Whale">Agents of Edgewatch - 05 - Belly of the Black Whale</option>
            <option value ="Agents of Edgewatch - 06 - Ruins of the Radiant Siege">Agents of Edgewatch - 06 - Ruins of the Radiant Siege</option>
            <option value ="Beginner Box Game Mastere28099s Guide">Beginner Box Game Mastere28099s Guide</option>
            <option value ="Bestiary">Bestiary</option>
            <option value ="Bestiary 2">Bestiary 2</option>
            <option value ="Bestiary 3">Bestiary 3</option>
            <option value ="Core Rulebook">Core Rulebook</option>
            <option value ="Extinction Curse - 01 - The Show Must Go On">Extinction Curse - 01 - The Show Must Go On</option>
            <option value ="Extinction Curse - 02 - Legacy of the Lost God">Extinction Curse - 02 - Legacy of the Lost God</option>
            <option value ="Extinction Curse - 03 - Lifee28099s Long Shadows">Extinction Curse - 03 - Lifee28099s Long Shadows</option>
            <option value ="Extinction Curse - 04 - Siege of the Dinosaurs">Extinction Curse - 04 - Siege of the Dinosaurs</option>
            <option value ="Extinction Curse - 05 - Lord of the Black Sands">Extinction Curse - 05 - Lord of the Black Sands</option>
            <option value ="Extinction Curse - 06 - The Apocalypse Prophet">Extinction Curse - 06 - The Apocalypse Prophet</option>
            <option value ="Gamemastery Guide">Gamemastery Guide</option>
            <option value ="Little Trouble in Big Absalom">Little Trouble in Big Absalom</option>
            <option value ="Lost Omens Character Guide">Lost Omens Character Guide</option>
            <option value ="The Fall of Plaguestone">The Fall of Plaguestone</option>
            <option value ="The Slithering">The Slithering</option>
            <option value ="Troubles in Otari">Troubles in Otari</option>
        </Form.Select>
    );
};
export default SelectedSource;