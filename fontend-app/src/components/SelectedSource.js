import React from 'react';
import { Form } from 'react-bootstrap';
import { source } from './datasets';

function SelectedSource({ setNewSource }) {
    return (

        <Form.Select size="sm" className="mb-3" onChange={e => setNewSource(e)}>
            <option>Select Source</option>
            {source.map(book => (
                <option value={book}>{book}</option>
            ))}
        </Form.Select>
    );
};
export default SelectedSource;
