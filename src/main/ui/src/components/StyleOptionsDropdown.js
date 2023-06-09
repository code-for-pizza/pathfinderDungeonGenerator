import React from 'react';
import {useState} from 'react';
import {Form,Row,Col,Card, Button,Tabs,Tab} from 'react-bootstrap';

function StyleOptionsDropdown(){

    const [set, setSetter] = useState('')
    const [partySize, setPartySize] = useState('')
    const [level, setLevel] = useState('')
    async function changed(e){
        e.preventDefault();
        await fetch(`http://localhost:8080/api/styleGenerator?style=${set}&partySize=${partySize}&level=${level}`)
        .then(res => res.json())
        .then((result) => {
            console.log(result)
            var temp = Object.values(result)
            console.log(temp);
            document.getElementById('trivial').value = JSON.stringify(temp[0], null, 4);
            document.getElementById('low').value = JSON.stringify(temp[1], null, 4);
            document.getElementById('moderate').value = JSON.stringify(temp[2], null, 4);
            document.getElementById('severe').value = JSON.stringify(temp[3], null, 4);
            document.getElementById('extreme').value = JSON.stringify(temp[4], null, 4);
        })
        }





    return(
        <Card>
            <Card.Header> Generate 3-4 sessions of a campaign using a pre-defined style.</Card.Header>
            <Card.Body>
                <Form method="post" onSubmit={changed}>
                    <Form.Group as={Row} className="g-2">
                        <Form.Label column md="1"> <p> Select a Style </p> </Form.Label>
                        <Col md="2">
                            <Row>
                            <Form.Select name="selectedStyle" Aria-label="Default select example" onChange={e => setSetter(e.target.value)}>
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
                        <Form.Label column md="1"> <p> Encounters</p> </Form.Label>
                        <Col md>
                            <Tabs
                              defaultActiveKey="profile"
                              id="uncontrolled-tab-example"
                              className="mb-3"
                            >
                                <Tab eventKey="Trivial" title="Trivial">
                                    <Form.Control id="trivial" as="textarea" rows={3} readOnly/>
                                </Tab>
                                <Tab eventKey="Low" title="Low">
                                    <Form.Control id="low" as="textarea" rows={3} readOnly/>
                                </Tab>
                                <Tab eventKey="Moderate" title="Moderate">
                                    <Form.Control id="moderate" as="textarea" rows={3} readOnly/>
                                </Tab>
                                <Tab eventKey="Severe" title="Severe">
                                    <Form.Control id="severe" as="textarea" rows={3} readOnly/>
                                </Tab>
                                <Tab eventKey="Extreme" title="Extreme">
                                    <Form.Control id="extreme" as="textarea" rows={3} readOnly/>
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