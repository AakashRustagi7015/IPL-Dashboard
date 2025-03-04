package com.ipl.dashboard.controllers;

import com.ipl.dashboard.pojo.TeamDetails;
import com.ipl.dashboard.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    MatchController matchController;
    @Autowired
    TeamRepository teamRepo;

    @GetMapping("/getTeam/{teamName}")
    public TeamDetails getTeamDetails(@PathVariable String teamName) {
        TeamDetails obj = teamRepo.findTeambyName(teamName);
        obj.setLatestMatches(matchController.findLatestMatches(teamName));
        return obj;
    }

    @GetMapping("/getAllTeams")
    public Iterable<TeamDetails> getAllTeams() {
        return teamRepo.findAll();
    }

}

