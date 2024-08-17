import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { useParams } from 'react-router-dom';
import './MatchPage.css';
import BackButton from '../components/BackButton';
import { YearSelector } from '../components/YearSelector';
export const MatchPage = () => {
    const [matches, setMatches] = useState([]);
    const { teamName, year } =useParams()
    useEffect( () => { 
        const fetchdata = async () => {
            const fetched = await fetch(`http://localhost:8080/teams/${teamName}?year=${year}`)
            const data = await fetched.json()
            setMatches(data)
            console.log(data)
        };
        fetchdata();
    }, [teamName, year])
    
    if (matches.length === 0) {
        return (
            <div>
                <BackButton/><p>Matches not found</p>
            </div>)
    }
    return (
        <div className="MatchPage">
            <div class="year-selector">
                <h3>Select Year</h3>
                <YearSelector teamName={teamName}/>
            </div>
            <div className="data-section">
            <h1>Match Page</h1>
            { 
                    matches.map((match) => <MatchDetailCard key={match.id} match={match} teamName={teamName} />)
            }
            </div>
        </div>
    );
}