import React from 'react';
import {Card, Accordion} from 'react-bootstrap';

function getRandomInt(max){
    return Math.floor(Math.random() * max);
}

function TabContent({encounters}) {
    if (!encounters) return [];

    //console.log(encounters)
    return encounters.map((encounter,idx) => {


         const creatureCards = encounter.map(creature => {
            return (
                <Card key={JSON.stringify(creature)+getRandomInt(10000)} className='mb-2'>
                    <Card.Body>
                        <Card.Title>Creature Name: {creature.name}</Card.Title>
                        <Card.Text>
                            Creature Rating : {creature['Creature Level']}
                            <br/>
                            Creature Traits : [{creature.Trait.join(", ")}]
                            <br/>
                            Source Book : [{creature.source}]
                        </Card.Text>
                    </Card.Body>
                </Card>
            )
        })

        return(
            <Accordion key={JSON.stringify(encounter)}>
                <Accordion.Item eventKey="0">
                    <Accordion.Header> Encounter Number : {idx+1} </Accordion.Header>
                    <Accordion.Body>
                        {creatureCards}
                    </Accordion.Body>
                </Accordion.Item>
            </Accordion>

        )

    });
}

export default TabContent;