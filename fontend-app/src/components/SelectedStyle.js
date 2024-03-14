import React from 'react';
import { Form } from 'react-bootstrap';
import { style } from './datasets';
function SelectStyle({ setSetter }) {
    return (
        <select name="selectedStyle" onChange={e => setSetter(e.target.value)}>
            <option>Style Selection</option>
            {style.map(styl => (
                <option value={styl}>{styl}</option>
            ))}
        </select>
    );
};
export default SelectStyle;
