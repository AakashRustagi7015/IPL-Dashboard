import { React, useEffect, useState } from "react";
import { TeamTile } from "../components/TeamTile";
import './HomePage.css';
export const HomePage = () => { 
    const [teams, setTeams] = useState([]);
    useEffect(() => { 
            const fetchAllTeams = async () => { 
                const allTeams = await fetch("http://localhost:8080/team/getAllTeams")
                const data = await allTeams.json()
                setTeams(data)
            }
            fetchAllTeams()
        }, []
    )
    return (
        <div className="HomePage">
            <div className="header-section">
                <h1 className="app-name">IPL DashBoard</h1>
            </div>
            <div className="team-grid">
                {teams.map(team => <TeamTile key={team.id} teamName={team.teamName}/>)}
            </div>
        </div>
    )
}

// && xcopy .\\buld\\* ..\\main\\resources\\public /s /y