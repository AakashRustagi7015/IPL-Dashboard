import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchSmallCard.css';
export const MatchSmallCard = ({ match ,teamName }) => {
  if (!match) return null;
  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const isMatchWon=match.winningTeam===teamName? true:false
  return (
    <div className={isMatchWon ? "MatchSmallCard won-card" : "MatchSmallCard lost-card"}>
      <span className="vs">vs</span>
      <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
      <p className='winner-section'>{match.winningTeam} won By {match.margin} {match.wonBy}</p>
    </div>
  );
}
