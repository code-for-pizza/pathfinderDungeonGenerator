import React from 'react';
import {Card} from 'react-bootstrap';

function TabContent({encounters}) {
    if (!encounters) return [];

    return encounters.map((encounter,idx) => {


         const creatureCards = encounter.map(creature => {
            return (
                <Card key={JSON.stringify(creature)}>
                    <Card.Body>
                        <Card.Title>Creature Name: {creature.name}</Card.Title>
                        <Card.Text>
                            Creature Rating : {creature['Creature Level']}
                            <br/>
                            Creature Traits : [{creature.Trait.join(", ")}]
                        </Card.Text>
                    </Card.Body>
                </Card>
            )
        })

        return(
            <Card key={JSON.stringify(encounter)}>
                <Card.Body>
                    <Card.Title> Encounter Number : {idx+1} </Card.Title>
                    <Card.Text>
                        {creatureCards}
                    </Card.Text>
                </Card.Body>
            </Card>

        )

    });
}

export default TabContent;