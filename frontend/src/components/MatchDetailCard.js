import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchDetailCard.css';
export const MatchDetailCard = ({ match ,teamName })=> {
  if (!match) return null;
  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const isMatchWon = teamName === match.winningTeam ? true : false;
  return (
    <div className={isMatchWon ? "MatchDetailCard won-card" : "MatchDetailCard lost-card"}>
      <div>
        <span className="vs">vs</span>
        <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
        <h2 className='match-date'>{match.date}</h2>
        <h3 className='match-venue'>at {match.venue}</h3>
        <h3 className='match-result'>{match.winningTeam} won By {match.margin} { match.wonBy}</h3>
      </div>
      <div className="additional-details">
        <h3>First Innings</h3>
        <p>{match.team1}</p>
        <h3>Second Innings</h3>
        <p>{match.team2}</p>
        <h3>Man of the match</h3>
        <p>{match.playerOfMatch}</p>
      </div>
    </div>
  );
}
