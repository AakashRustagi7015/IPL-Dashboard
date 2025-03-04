import { React } from 'react';
import { Link } from 'react-router-dom';
import './TeamTile.css';
export const TeamTile = ({ teamName }) => { 
    return (
        <div className='team-tile-section'>
            <h1 className='team-name'><Link to={`/teams/${teamName}`}>{teamName}</Link></h1>
        </div>
    )
}