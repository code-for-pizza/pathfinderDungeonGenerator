import React from 'react';
import { useState } from 'react';
import { Form, Row, Col, Card, Button, Tabs, Tab, InputGroup } from 'react-bootstrap';
import TabContent from './TabContent.js';
import SelectedStyle from './SelectedStyle.js';
import SelectedSource from './SelectedSource.js';
import { monsterTraits } from './datasets.js';
function StyleOptionsDropdown() {

    const [set, setSetter] = useState('');
    const [partySize, setPartySize] = useState('');
    const [level, setLevel] = useState('');
    const [trivial, setTrivial] = useState('');
    const [low, setLow] = useState('');
    const [moderate, setModerate] = useState('');
    const [severe, setSevere] = useState('');
    const [extreme, setExtreme] = useState('');
    const [traits, setTraits] = useState([]);
    const [source, setSource] = useState([]);
    const [currTrait, setCurrTrait] = useState('')


    async function changed(e) {
        e.preventDefault();
        let url = `http://localhost:30001/api/styleGenerator?style=${set}&partySize=${partySize}&level=${level}`;

        if (level > 20 || level < 1) {
            alert("Use a viable level [1-20], you have inputted " + level);
            return;
        }

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
                //console.log(result);
                setTrivial(result.Trivial);
                setLow(result.Low);
                setModerate(result.Moderate);
                setSevere(result.Severe);
                setExtreme(result.Extreme);
            })
    }

    async function newTrait(e) {
        e.preventDefault();
        if (currTrait.length){
            setTraits([...traits, currTrait]);
        }
    }

    async function clearTraits() {
        setTraits("");
    }
    async function clearSource() {
        setSource("");
    }

    async function clearMonsters() {
        setTrivial("");
        setLow("");
        setModerate("");
        setSevere("");
        setExtreme("");
    }

    async function newSources(e) {
        setSource([...source, e.target.value]);
    }

    return (
        <div>
            <h3> Generate 3-4 sessions of a campaign using a pre-defined style.</h3>
            <div>
                <Form method="post" onSubmit={changed}>
                        <div md="2">
                            <div className='style-selection-form'>
                                <SelectedStyle setSetter={setSetter} />
                            </div>
                            <div>
                                <div className='party-size-input-wrapper'>
                                    <input size="sm" type="number" placeholder="Party Size" onChange={e => setPartySize(e.target.value)} />
                                </div>
                                <div className='level-input-wrapper'>
                                    <input size="sm" type="number" placeholder="Level" onChange={e => setLevel(e.target.value)} />
                                </div>
                            </div>
                            <div>
                                <div className="select-traits-wrapper-div">
                                    <select size="sm" className="mb-3" onChange={e => setCurrTrait(e.target.value)}>
                                        <option value={''}>Traits</option>
                                        {monsterTraits.map(trait => <option value={trait}>{trait}</option>)}
                                    </select>
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon1"
                                        onClick={e => newTrait(e)}> Add Trait </Button>
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon2"
                                        onClick={e => clearTraits()} > Clear </Button>
                                </div>
                            </div>

                                <div className="select-sources-wrapper-div">
                                    <SelectedSource setNewSource={newSources} />
                                    <Button size="sm" className="mb-3" variant="outline-secondary" id="button-addon2"
                                        onClick={e => clearSource()} > Clear </Button>
                                </div>

                            <Button variant="primary" size="md" active type="submit" onClick={e => clearMonsters()}> Submit </Button>
                        </div>
                        <div md="1" className="ms-2">
                            List of Active traits.
                            <textarea size="sm" as="textarea" rows={3} value={traits} readOnly />
                            <div>
                                List of Active Sources
                                <textarea size="sm" as="textarea" rows={3} value={source} readOnly />
                            </div>
                        </div>
                        <label column md="1" className="ms-2"> Encounters </label>
                        <div className='encounter-tabs-wrapper-div'>
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
                        </div>
                </Form>
            </div>
        </div>
    )
}
export default StyleOptionsDropdown;
