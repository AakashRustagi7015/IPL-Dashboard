package com.ipl.dashboard.repositories;
import com.ipl.dashboard.pojo.Matches;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Matches, Long> {
    @Query(value="Select * from matches where matches.team1=?1 or matches.team2=?1 order by matches.date desc limit 4",nativeQuery = true)
    public List<Matches> findLatestMatches(String teamName);

    @Query(value = "Select distinct YEAR(date) from matches",nativeQuery = true)
    public List<String> getAllDistinctYear();

    @Query(value="Select * from matches where (matches.team1=?1 or matches.team2=?1) and (matches.date like ?2%) order by matches.date desc",nativeQuery = true)
    public List<Matches> findAllTeamMatchesbyYear(String TeamName, String year);
}
