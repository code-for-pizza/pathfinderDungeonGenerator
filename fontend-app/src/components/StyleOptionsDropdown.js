import React from 'react';
import {useState} from 'react';
import {Form,Row,Col,Card, Button,Tabs,Tab} from 'react-bootstrap';
import TabContent from './TabContent.js'

function StyleOptionsDropdown(){

    const [set, setSetter] = useState('')
    const [partySize, setPartySize] = useState('')
    const [level, setLevel] = useState('')
    const [elements, setElements] = React.useState([]);
    const [trivial, setTrivial] = useState('');
    const [low, setLow] = useState('');
    const [moderate, setModerate] = useState('');
    const [severe, setSevere] = useState('');
    const [extreme, setExtreme] = useState('');

    async function changed(e){
        e.preventDefault();
        await fetch(`http://localhost:8080/api/styleGenerator?style=${set}&partySize=${partySize}&level=${level}`)
        .then(res => res.json())
        .then((result) => {
            setTrivial(result.Trivial);
            console.log(result.Trivial);
            setLow(result.Low);
            setModerate(result.Moderate);
            setSevere(result.Severe);
            setExtreme(result.Extreme);
        })
        }





    return(
        <Card>
            <Card.Header> Generate 3-4 sessions of a campaign using a pre-defined style.</Card.Header>
            <Card.Body>
                <Form method="post" onSubmit={changed}>
                    <Form.Group as={Row} className="g-2">
                        <Form.Label column md="1"> Select a Style </Form.Label>
                        <Col md="2">
                            <Row>
                            <Form.Select name="selectedStyle" onChange={e => setSetter(e.target.value)}>
                                <option>Style Selection</option>
                                <option value ="Dungeon Crawl">Dungeon Crawl</option>
                                <option value ="Gritty Adventure">Gritty Adventure</option>
                                <option value ="High Adventure">High Adventure</option>
                                <option value ="Horror">Horror</option>
                                <option value ="Intrigue"> Intrigue</option>
                                <option value ="Military Adventure">Military Adventure</option>
                                <option value ="Mystery">Mystery</option>
                                <option value ="Planar Adventure">Planar Adventure</option>
                                <option value ="Romantic Adventure">Romantic Adventure</option>
                            </Form.Select>
                            </Row>
                            <Row>
                                <Col>
                                    <Form.Control size="sm" type="number" placeholder="Party Size" onChange={e => setPartySize(e.target.value)} />
                                </Col>
                                <Col>
                                    <Form.Control size="sm" type="number" placeholder="Level" onChange={e => setLevel(e.target.value)} />
                                </Col>
                            </Row>
                        </Col>
                        <Form.Label column md="1" className="ms-2"> Encounters </Form.Label>
                        <Col md>
                            <Tabs
                              defaultActiveKey="profile"
                              id="uncontrolled-tab-example"
                              className="mb-3"
                            >
                                <Tab eventKey="Trivial" title="Trivial">
                                    <TabContent encounters={trivial} />
                                </Tab>
                                <Tab eventKey="Low" title="Low">
                                    <TabContent encounters={low}/>
                                </Tab>
                                <Tab eventKey="Moderate" title="Moderate">
                                    <TabContent encounters={moderate} />
                                </Tab>
                                <Tab eventKey="Severe" title="Severe">
                                    <TabContent encounters={severe} />
                                </Tab>
                                <Tab eventKey="Extreme" title="Extreme">
                                    <TabContent encounter={extreme} />
                                </Tab>
                            </Tabs>
                        </Col>
                    </Form.Group>
                    <Button variant="primary" size="md" active type="submit">
                        Submit
                    </Button>
                </Form>
            </Card.Body>
        </Card>
    )
}
export default StyleOptionsDropdown;