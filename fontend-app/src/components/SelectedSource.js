import React from 'react';
import { Form } from 'react-bootstrap';
import { source } from './datasets';

function SelectedSource({ setNewSource }) {
    return (
        <select size="sm" className="mb-3" onChange={e => setNewSource(e)}>
            <option>Select Source</option>
            {source.map(book => (
                <option value={book}>{book}</option>
            ))}
        </select>
    );
};
export default SelectedSource;
