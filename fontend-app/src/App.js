import React from 'react';

import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function App() {
  return (
    <div className="App">
        <Container fluid="mb">
        <Row>
            <Col sm={6}>
                <Form.Select aria-label="Default select example" size='lg'>
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
            </Col>
            <Col sm={4}>
                <InputGroup>
                    <InputGroup.Text>#</InputGroup.Text>
                    <Form.Control aria-label="Number" />
                </InputGroup>
            </Col>
        </Row>
        </Container>
    </div>
  );
}

export default App;
