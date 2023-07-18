import React from 'react';
import { useState } from 'react';
import { Form, Row, Col, Card, Button, Tabs, Tab, InputGroup } from 'react-bootstrap';
import TabContent from './TabContent.js';
import SelectedStyle from './SelectedStyle.js';
import SelectedSource from './SelectedSource.js';

function StyleOptionsDropdown() {

    const [set, setSetter] = useState('')
    const [partySize, setPartySize] = useState('')
    const [level, setLevel] = useState('')
    const [elements, setElements] = React.useState([]);
    const [trivial, setTrivial] = useState('');
    const [low, setLow] = useState('');
    const [moderate, setModerate] = useState('');
    const [severe, setSevere] = useState('');
    const [extreme, setExtreme] = useState('');
    const [tempTrait, setTempTrait] = React.useState('');
    const [traits, setTraits] = React.useState([]);
    const [newSource, setNewSource] = React.useState('');
    const [source, setSource] = React.useState([]);

    async function changed(e) {
        e.preventDefault();
        let url = `http://75.46.130.114:30001/api/styleGenerator?style=${set}&partySize=${partySize}&level=${level}`;
        console.log(url);
        if (traits.length > 0) {
            url = url + `&traits=${traits}`;
        }
        if (source.length > 0) {
            url = url + `&source=${source}`;
        }
        await fetch(url)
            .then(res => res.json())
            .then((result) => {
                console.log(result);
                setTrivial(result.Trivial);
                setLow(result.Low);
                setModerate(result.Moderate);
                setSevere(result.Severe);
                setExtreme(result.Extreme);
            })
    }

    async function newTrait(e) {
        e.preventDefault();

        if (!tempTrait.length == 0) {
            let x = tempTrait;
            x = x.toLowerCase();
            x = x.charAt(0).toUpperCase() + x.slice(1);
            setTraits([...traits, x]);
        }
    }

    async function clearTraits() {
        setTraits("");
    }
    async function clearSource() {
        setSource("");
    }

    async function newSources(e) {
        setSource([...source, e.target.value]);
    }

    return (
        <Card>
            <Card.Header> Generate 3-4 sessions of a campaign using a pre-defined style.</Card.Header>
            <Card.Body>
                <Form method="post" onSubmit={changed}>
                    <Form.Group as={Row} className="g-2">
                        <Col md="2">
                            <Row>
                                <SelectedStyle setSetter={setSetter} />
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
                                    <Form.Select size="sm" className="mb-3" onChange={e => setTempTrait(e.target.value)}>
                                        <option value="aasimar">Aasimar</option>
                                        <option value="acid">Acid</option>
                                        <option value="aeon">Aeon</option>
                                        <option value="aesir">Aesir</option>
                                        <option value="agathion">Agathion</option>
                                        <option value="air">Air</option>
                                        <option value="alchemical">Alchemical</option>
                                        <option value="amphibious">Amphibious</option>
                                        <option value="anadi">Anadi</option>
                                        <option value="angel">Angel</option>
                                        <option value="anugobu">Anugobu</option>
                                        <option value="aquatic">Aquatic</option>
                                        <option value="arcane">Arcane</option>
                                        <option value="archon">Archon</option>
                                        <option value="asura">Asura</option>
                                        <option value="azata">Azata</option>
                                        <option value="boggard">Boggard</option>
                                        <option value="caligni">Caligni</option>
                                        <option value="catfolk">Catfolk</option>
                                        <option value="changeling">Changeling</option>
                                        <option value="charau-ka">Charau-Ka</option>
                                        <option value="clockwork">Clockwork</option>
                                        <option value="cold">Cold</option>
                                        <option value="couatl">Couatl</option>
                                        <option value="daemon">Daemon</option>
                                        <option value="darvakka">Darvakka</option>
                                        <option value="demon">Demon</option>
                                        <option value="dero">Dero</option>
                                        <option value="devil">Devil</option>
                                        <option value="dhampir">Dhampir</option>
                                        <option value="dinosaur">Dinosaur</option>
                                        <option value="div">Div</option>
                                        <option value="drow">Drow</option>
                                        <option value="duergar">Duergar</option>
                                        <option value="duskwalker">Duskwalker</option>
                                        <option value="earth">Earth</option>
                                        <option value="electricity">Electricity</option>
                                        <option value="fetchling">Fetchling</option>
                                        <option value="fire">Fire</option>
                                        <option value="formian">Formian</option>
                                        <option value="genie">Genie</option>
                                        <option value="ghoran">Ghoran</option>
                                        <option value="ghost">Ghost</option>
                                        <option value="ghoul">Ghoul</option>
                                        <option value="ghul">Ghul</option>
                                        <option value="gnoll">Gnoll</option>
                                        <option value="golem">Golem</option>
                                        <option value="gremlin">Gremlin</option>
                                        <option value="grioth">Grioth</option>
                                        <option value="grippli">Grippli</option>
                                        <option value="hag">Hag</option>
                                        <option value="hantu">Hantu</option>
                                        <option value="herald">Herald</option>
                                        <option value="ifrit">Ifrit</option>
                                        <option value="ikeshti">Ikeshti</option>
                                        <option value="illusion">Illusion</option>
                                        <option value="incorporeal">Incorporeal</option>
                                        <option value="inevitable">Inevitable</option>
                                        <option value="kaiju">Kaiju</option>
                                        <option value="kami">Kami</option>
                                        <option value="kobold">Kobold</option>
                                        <option value="kovintus">Kovintus</option>
                                        <option value="leshy">Leshy</option>
                                        <option value="lilu">Lilu</option>
                                        <option value="lizardfolk">Lizardfolk</option>
                                        <option value="locathan">Locathan</option>
                                        <option value="merfolk">Merfolk</option>
                                        <option value="mindless">Mindless</option>
                                        <option value="morlock">Morlock</option>
                                        <option value="mortic">Mortic</option>
                                        <option value="mummy">Mummy</option>
                                        <option value="munavri">Munavri</option>
                                        <option value="mutant">Mutant</option>
                                        <option value="nagaji">Nagaji</option>
                                        <option value="nymph">Nymph</option>
                                        <option value="oni">Oni</option>
                                        <option value="orc">Orc</option>
                                        <option value="oread">Oread</option>
                                        <option value="paaridar">Paaridar</option>
                                        <option value="phantom">Phantom</option>
                                        <option value="protean">Protean</option>
                                        <option value="psychopomp">Psychopomp</option>
                                        <option value="qlippoth">Qlippoth</option>
                                        <option value="rakshasa">Rakashasa</option>
                                        <option value="ratajin">Ratajin</option>
                                        <option value="ratfolk">Ratfolk</option>
                                        <option value="sahkil">Sahkil</option>
                                        <option value="samsaran">Samsaran</option>
                                        <option value="sea devil">Sea Devil</option>
                                        <option value="serpentfolk">Serpentfolk</option>
                                        <option value="seugathi">Seugathi</option>
                                        <option value="shabti">Shabti</option>
                                        <option value="shapechanger">Shapechanger</option>
                                        <option value="siktempora">Siktempora</option>
                                        <option value="skeleton">Skeleton</option>
                                        <option value="skelm">Skelm</option>
                                        <option value="skulk">Skulk</option>
                                        <option value="sonic">Sonic</option>
                                        <option value="soulbound">Soulbound</option>
                                        <option value="spriggan">Spriggan</option>
                                        <option value="sprite">Sprite</option>
                                        <option value="stheno">Stheno</option>
                                        <option value="suli">Suli</option>
                                        <option value="swarm">Swarm</option>
                                        <option value="sylph">Sylph</option>
                                        <option value="tane">Tane</option>
                                        <option value="tanggal">Tanggal</option>
                                        <option value="tengu">Tengu</option>
                                        <option value="tiefling">Tiefling</option>
                                        <option value="titan">Titan</option>
                                        <option value="troll">Troll</option>
                                        <option value="troop">Troop</option>
                                        <option value="undine">Undine</option>
                                        <option value="urdefhan">Urdefhan</option>
                                        <option value="vampire">Vampire</option>
                                        <option value="vanara">Vanara</option>
                                        <option value="velstrac">Velstrac</option>
                                        <option value="vishkanya">Vishkanya</option>
                                        <option value="water">Water</option>
                                        <option value="wayang">Wayang</option>
                                        <option value="werecreature">Werecreature</option>
                                        <option value="wight">Wight</option>
                                        <option value="wild hunt">Wild Hunt</option>
                                        <option value="wraith">Wraith</option>
                                        <option value="wyrwood">Wyrwood</option>
                                        <option value="xulgath">Xulgath</option>
                                        <option value="zombie">Zombie</option>
                                        <option value="aberration">Aberration</option>
                                        <option value="animal">Animal</option>
                                        <option value="astral">Astral</option>
                                        <option value="beast">Beast</option>
                                        <option value="celestial">Celestial</option>
                                        <option value="construct">Construct</option>
                                        <option value="dragon">Dragon</option>
                                        <option value="dream">Dream</option>
                                        <option value="elemental">Elemental</option>
                                        <option value="ethereal">Ethereal</option>
                                        <option value="fey">Fey</option>
                                        <option value="fiend">Fiend</option>
                                        <option value="fungus">Fungus</option>
                                        <option value="giant">Giant</option>
                                        <option value="humanoid">Humanoid</option>
                                        <option value="monitor">Monitor</option>
                                        <option value="negative">Negative</option>
                                        <option value="ooze">Ooze</option>
                                        <option value="petitioner">Petitioner</option>
                                        <option value="plant">Plant</option>
                                        <option value="positive">Positive</option>
                                        <option value="sprint">Sprint</option>
                                        <option value="time">Time</option>
                                        <option value="undead">Undead</option>
                                    </Form.Select>
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
                            <Button variant="primary" size="md" active type="submit"> Submit </Button>
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
                                    <TabContent encounters={low} />
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
