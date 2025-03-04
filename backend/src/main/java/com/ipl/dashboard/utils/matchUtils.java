package com.ipl.dashboard.utils;
import com.ipl.dashboard.pojo.Matches;
import com.ipl.dashboard.pojo.TeamDetails;
import com.ipl.dashboard.repositories.MatchRepository;
import com.ipl.dashboard.repositories.TeamRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class matchUtils {


    public MatchRepository matchRepository;


    public TeamRepository teamRepository;

    @Value("${filePath}")
    String filePath;

    @Autowired
    public matchUtils(MatchRepository m,TeamRepository t){
        this.matchRepository=m;
        this.teamRepository = t;
        readFromCSV();
    }

    public List<List<String>> help(String filePath){
//        List<Match> ans= new ArrayList<>();
        List<List<String>> l = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            String[] line =null;
            while((line= csvReader.readNext())!=null){
                l.add(Arrays.asList(line));
            }
        }catch (Exception exception){log.error("error");}
        return l;
    }


    public void readFromCSV(){
        String filePath="/home/aakash/IPL-Dashboard/backend/src/main/resources/IPL_Matches_2008_2022.csv";
        List<List<String>> l =help(filePath);
        List<Matches> ans= new ArrayList<>();
        Map<String, TeamDetails> teamMap= new HashMap<>();
        for(int i=1;i<l.size();i++) {
            List<String> temp = l.get(i);
            Matches t = new Matches();
            t.setId(Long.parseLong(temp.get(0)));
            t.setCity(temp.get(1));
            t.setDate(LocalDate.parse(temp.get(2)));
            t.setSeason(temp.get(3));
            t.setMatchNumber(temp.get(4));
            t.setTeam1(temp.get(5));
            t.setTeam2(temp.get(6));
            t.setVenue(temp.get(7));
            t.setTossWinner(temp.get(8));
            t.setTossDecision(temp.get(9));
            t.setSuperOver(temp.get(10));
            t.setWinningTeam(temp.get(11));
            t.setWonBy(temp.get(12));
            t.setMargin(temp.get(13));
            t.setMethod(temp.get(14));
            t.setPlayerOfMatch(temp.get(15));
            t.setTeam1Players(new ArrayList<>(Arrays.asList(temp.get(16).split(","))));
            t.setTeam2Players(new ArrayList<>(Arrays.asList(temp.get(17).split(","))));
            ans.add(t);
            matchRepository.save(t);


//            Adding  details of each team
            TeamDetails temp1=teamMap.getOrDefault(t.getTeam1(),new TeamDetails(t.getTeam1()));
            TeamDetails temp2= teamMap.getOrDefault(t.getTeam2(),new TeamDetails(t.getTeam2()));

            if(Objects.equals(t.getWinningTeam(), "NA")){
                temp1.setTotalDraws(temp1.getTotalDraws()+1);
                temp2.setTotalDraws(temp2.getTotalDraws()+1);
            }
            else if(t.getWinningTeam()==temp1.getTeamName()){
                temp1.setTotalWin(temp1.getTotalWin()+1);
                temp2.setTotalLoss(temp2.getTotalLoss()+1);
            }
            else{
                temp2.setTotalWin(temp2.getTotalWin()+1);
                temp1.setTotalLoss(temp2.getTotalLoss()+1);
            }
            teamMap.put(t.getTeam1(),temp1);
            teamMap.put(t.getTeam2(),temp2);
        }
        System.out.println(teamMap.values());
        teamRepository.saveAll(teamMap.values());
    }
}

