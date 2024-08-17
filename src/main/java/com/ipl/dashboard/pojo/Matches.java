package com.ipl.dashboard.pojo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String city;
    LocalDate date;
    String season;
    String matchNumber;
    String team1;
    String team2;
    String venue;
    String tossWinner;
    String tossDecision;
    String superOver;
    String winningTeam;
    String wonBy;
    String margin;
    String method;
    String playerOfMatch;
    List<String> team1Players;
    List<String> team2Players;
}

