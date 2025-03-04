package com.ipl.dashboard.controllers;
import com.ipl.dashboard.pojo.Matches;
import com.ipl.dashboard.repositories.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/")
public class MatchController {
    @Autowired
    MatchRepository m;

    @GetMapping("/findById")
//    @ResponseBody
    public Optional<Matches> findById(@RequestParam Long id){
//        log.info("hii");
        return m.findById(id);
    }
    @GetMapping("/findLatestMatches")
    public List<Matches> findLatestMatches(@RequestParam String teamName) {
        return m.findLatestMatches(teamName);
    }

    @GetMapping("/teams/{teamName}")
    public List<Matches> findAllTeamMatchesBasedOnYear(@PathVariable String teamName, @RequestParam String year) {
        return m.findAllTeamMatchesbyYear(teamName, year);
    }

    @GetMapping("/getYears")
    public List<String> findAllDistinctYear() {
        return m.getAllDistinctYear();
    }


}
