import React from 'react';
import {useState} from 'react';
import {Form,Row,Col,Card, Button,Tabs,Tab,InputGroup} from 'react-bootstrap';
import TabContent from './TabContent';
import SelectedStyle from './SelectedStyle';
import SelectedSource from './SelectedSource';

function StyleOptionsDropdown(){

    const [set, setSetter] = useState('');
    const [partySize, setPartySize] = useState('');
    const [level, setLevel] = useState('');
    const [trivial, setTrivial] = useState('');
    const [low, setLow] = useState('');
    const [moderate, setModerate] = useState('');
    const [severe, setSevere] = useState('');
    const [extreme, setExtreme] = useState('');
    const [tempTrait, setTempTrait] = React.useState('');
    const [traits, setTraits] = React.useState([]);
    const [source, setSource] = React.useState([]);

    async function changed(e){
        e.preventDefault();
        let url = `http://localhost:30001/api/styleGenerator?style=${set}&partySize=${partySize}&level=${level}`;

        if(level > 20 || level < 1){
            alert("Use a viable level [1-20], you have inputted "+level);
            return;
        }

        console.log(url);
        if(traits.length > 0){
            url = url + `&traits=${traits}`;
        }
        if(source.length > 0){
            url = url + `&source=${source}`;
        }
        await fetch(url)
        .then(res => res.json())
        .then((result) => {
                //console.log(result);
                setTrivial(result.Trivial);
                setLow(result.Low);
                setModerate(result.Moderate);
                setSevere(result.Severe);
                setExtreme(result.Extreme);
            })
        }

    async function newTrait(e){
        e.preventDefault();

        if(!tempTrait.length === 0){
            let x = tempTrait;
            x = x.toLowerCase();
            x = x.charAt(0).toUpperCase() + x.slice(1);
            setTraits([...traits, x]);
        }
    }

    async function clearTraits(){
        setTraits("");
    }
    async function clearSource(){
        setSource("");
    }

    async function clearMonsters(){
        setTrivial("");
        setLow("");
        setModerate("");
        setSevere("");
        setExtreme("");
    }

    async function newSources(e){
        setSource([...source, e.target.value]);
    }

    return(
        <Card>
            <Card.Header> Generate 3-4 sessions of a campaign using a pre-defined style.</Card.Header>
            <Card.Body>
                <Form method="post" onSubmit={changed}>
                    <Form.Group as={Row} className="g-2">
                        <Col md="2">
                            <Row>
                                <SelectedStyle setSetter={setSetter}/>
                            </Row>
                            <Row>
                                <Col>
                                    <Form.Control size="sm" type="number" placeholder="Party Size" onChange={e => setPartySize(e.target.value)} />
                                </Col>
                                <Col>
                                    <Form.Control size="sm" type="number" placeholder="Level" onChange={e => setLevel(e.target.value)} />
                                </Col>
                            </Row>
                            <Row>
                                <InputGroup className="mb-3">
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon1"
                                     onClick={e => newTrait(e)}> Add Trait </Button>
                                    <Form.Control size="sm" className="mb-3" onChange={e=> setTempTrait(e.target.value)}
                                    wrap="hard"
                                    />
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon2"
                                    onClick={e => clearTraits()} > Clear </Button>
                                </InputGroup>
                            </Row>
                            <Row>
                                <InputGroup className="mb-3">
                                    <SelectedSource setNewSource={newSources} />
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon2"
                                                                        onClick={e => clearSource()} > Clear </Button>
                                </InputGroup>
                            </Row>
                            <Button variant="primary" size="md"  active type="submit" onClick={e => clearMonsters()}> Submit </Button>
                        </Col>
                        <Col md="1" className="ms-2">
                            List of Active traits.
                            <Form.Control size="sm" as="textarea" rows={3} value={traits} readOnly />
                        <Row>
                            List of Active Sources
                            <Form.Control size="sm" as="textarea" rows={3} value={source} readOnly />
                        </Row>
                        </Col>
                        <Form.Label column md="1" className="ms-2"> Encounters </Form.Label>
                        <Col md>
                            <Tabs
                              defaultActiveKey="profile" id="uncontrolled-tab-example" className="mb-3">
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
                                    <TabContent encounters={extreme} />
                                </Tab>
                            </Tabs>
                        </Col>
                    </Form.Group>
                </Form>
            </Card.Body>
        </Card>
    )
}
export default StyleOptionsDropdown;