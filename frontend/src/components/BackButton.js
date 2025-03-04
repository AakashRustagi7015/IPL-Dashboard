// BackButton.jsx
import React from 'react';
import { useNavigate } from 'react-router-dom';

    const BackButton = () => {
    const navigate = useNavigate();

    const goBack = () => {
        navigate(-1);
    };

    return (
        <button onClick={goBack}>
        <span>&#8592;</span> Back
        </button>
    );
    };

export default BackButton;
