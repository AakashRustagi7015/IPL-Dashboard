package com.ipl.dashboard.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor

@Table(name="Teams")
public class TeamDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String teamName;
    Double totalWin;
    Double totalLoss;
    Double totalDraws;

    @Transient
    List<Matches> latestMatches= new ArrayList<>();

    public TeamDetails(String teamName) {
        this.teamName=teamName;
        this.totalDraws=0.0;
        this.totalWin=0.0;
        this.totalLoss=0.0;
    }
}

