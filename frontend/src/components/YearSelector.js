import { React,useState,useEffect } from 'react';
import { Link } from 'react-router-dom';
import './YearSelector.css';
export const YearSelector = ({teamName}) => { 

    const [years, setYears] = useState([]);
    useEffect(() => { 
        const fetchYear = async () => {
            const fetchData = await fetch("http://localhost:8080/getYears");
            const data = await fetchData.json();
            console.log(data)
            setYears(data);
        };
        fetchYear();
    }, [])
    
    return (
        <ol className='years-list'>
            {
                years.map((year) =>
                    <li key={ year}>
                        <Link  to={`/teams/${teamName}/${year}`}>{year}</Link>
                    </li>)
            }
        </ol>
    )
}