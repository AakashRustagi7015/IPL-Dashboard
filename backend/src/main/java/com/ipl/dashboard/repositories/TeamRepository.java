package com.ipl.dashboard.repositories;
import com.ipl.dashboard.pojo.TeamDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<TeamDetails, Long> {

    @Query(value = "Select * from teams where teams.team_Name=?1",nativeQuery = true)
    public TeamDetails findTeambyName(String teamName);
}

