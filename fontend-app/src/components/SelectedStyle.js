import React from 'react';
import { Form } from 'react-bootstrap';

function SelectStyle({ setSetter }) {
    return (
        <Form.Select name="selectedStyle" onChange={e => setSetter(e.target.value)}>
            <option>Style Selection</option>
            <option value="Dungeon Crawl">Dungeon Crawl</option>
            <option value="Gritty Adventure">Gritty Adventure</option>
            <option value="High Adventure">High Adventure</option>
            <option value="Horror">Horror</option>
            <option value="Intrigue"> Intrigue</option>
            <option value="Military Adventure">Military Adventure</option>
            <option value="Mystery">Mystery</option>
            <option value="Planar Adventure">Planar Adventure</option>
            <option value="Romantic Adventure">Romantic Adventure</option>
        </Form.Select>
    );
};
export default SelectStyle;
