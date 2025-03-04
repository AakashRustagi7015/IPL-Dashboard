import { React, useEffect, useState } from 'react';
import { useParams,Link } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
import './TeamPage.css';
import { PieChart } from 'react-minimal-pie-chart';
export const TeamPage=()=> {
  const [team, setTeam] = useState({ latestMatches: [] })
  const { teamName } = useParams()
  const [years, setYears] = useState([]);

  useEffect(
    () => {
    const fetchMatches = async () => {
      const response = await fetch(`http://localhost:8080/team/getTeam/${teamName}` )
      const data = await response.json()
      setTeam(data)
      console.log(data)
    };
    fetchMatches();
    }, [teamName]
  );
  

  useEffect(() => {
    const fetchYear = async () => {
      const fetchData = await fetch("http://localhost:8080/getYears")
      const data = await fetchData.json();
      console.log(data)
      setYears(data);
    };
    fetchYear();
  }, []
  );
  
  if (!team || !team.teamName) {
    return <h1>Team not found</h1>
  } 
  return (
    <div className="TeamPage">
      <div className="team-name-section">
        <h1 className='team-name'>{team.teamName}</h1>
      </div>
      <div className='win-loss-section'>
        Wins / Losses
        <PieChart
          data={[
            { title: 'Losses', value: team.totalLoss, color: '#a34d5d' },
            { title: 'Wins', value: team.totalWin, color: '#4da375' },
          ]}
        />
      </div>
      <div className="detail-section">
        { /*<h3>Latest Matches</h3>*/}
        <MatchDetailCard teamName={teamName} match={team.latestMatches[0]} />
      </div>
      {team.latestMatches.slice(1).map(match => <MatchSmallCard key={ match.id} match={match} teamName={teamName} />)}
      <div className="more-section">
        <Link to={`/teams/${teamName}/${years[years.length-1]}`} >More{'>'} </Link>
      </div>
    </div>
  );
}
