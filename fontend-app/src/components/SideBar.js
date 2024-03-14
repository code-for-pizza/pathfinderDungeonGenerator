import React from 'react';
import {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Offcanvas from 'react-bootstrap/Offcanvas';
import Modal from 'react-bootstrap/Modal';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function SideBar() {
    const [monsterName, setMonsterName] = useState('');
    const [monsterInfo, setMonsterInfo] = useState('');
    const [show, setShow] = useState(false);
    const handleShow = () => setShow(true);
    const handleClose = () => setShow(false);

    async function changed(e){
        e.preventDefault();
        let url = `http://localhost:30001/api/getMonster?monsterName=${monsterName}`;
        console.log(url);
        await fetch(url)
        .then(res => res.json())
        .then((result) => {
            console.log(result);
            setMonsterInfo(result);
        })

    }

  return (
    <>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title> Monster Info </Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Row className="mb-3">
                <Form.Group as={Col} md="6">
                    <Form.Label> Monster Name </Form.Label>
                    <Form.Control type="text" value={monsterInfo.name} readonly/>
                </Form.Group>
                <Form.Group as={Col} md="2">
                    <Form.Label> Cr </Form.Label>
                    <Form.Control type="text" value={monsterInfo["Creature Level"]} readonly/>
                </Form.Group>
            </Row>
            <Row className="mb-3">
                <Form.Group as={Col} md="2">
                    <Form.Label> HP </Form.Label>
                    <Form.Control type="text" value={monsterInfo.hp} readonly/>
                </Form.Group>
                <Form.Group as={Col} md="2">
                    <Form.Label> AC </Form.Label>
                    <Form.Control type="text" value={monsterInfo.ac} readonly/>
                </Form.Group>
                <Form.Group as={Col} md="6">
                    <Form.Label> Saving throws </Form.Label>
                    <Form.Control type="text" value={{...monsterInfo.savingThrows}} readonly/>
                </Form.Group>
            </Row>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>

      {['sm'].map((expand) => (
        <Navbar key={expand} expand={expand} className="bg-body-tertiary mb-3">
          <Container fluid>
            <Navbar.Brand href="#">Pathfinder Encounter</Navbar.Brand>
            <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />
            <Navbar.Offcanvas
              id={`offcanvasNavbar-expand-${expand}`}
              aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
              placement="end"
            >
              <Offcanvas.Header closeButton>
                <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                  Offcanvas
                </Offcanvas.Title>
              </Offcanvas.Header>
              <Offcanvas.Body>
                <Nav className="justify-content-end flex-grow-1 pe-3">
                  <Nav.Link href="#action1">Home</Nav.Link>
                  <Nav.Link href="#action2">Link</Nav.Link>
                  <NavDropdown
                    title="Dropdown"
                    id={`offcanvasNavbarDropdown-expand-${expand}`}
                  >
                    <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                    <NavDropdown.Item href="#action4">
                      Another action
                    </NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="#action5">
                      Something else here
                    </NavDropdown.Item>
                  </NavDropdown>
                </Nav>
                <Form className="d-flex" onSubmit={changed}>
                  <Form.Control
                    type="search"
                    placeholder="Monster Search"
                    className="me-2"
                    aria-label="Search"
                    onChange={e => setMonsterName(e.target.value)}
                  />
                  <Button variant="primary" active type="submit" onClick={handleShow} >Search</Button>
                </Form>
              </Offcanvas.Body>
            </Navbar.Offcanvas>
          </Container>
        </Navbar>
      ))}
    </>
  );
}

export default SideBar;