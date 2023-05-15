package LeagueInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Team {
    String city;
    String name;

    public Schedule currentSchedule;
    List<Schedule> scheduleHistory = new ArrayList<Schedule>();
    
    OffensiveLine[] currentOffensiveLines = new OffensiveLine[4];
    DefensiveLine[] currentDefensiveLines = new DefensiveLine[3];
    Goalie currentGoalie;

    public Player[] roster = new Player[50];

    int numSkaters = 0;
    int offense = 0;
    int defense = 0;

    int numGoalies = 0;
    int goalie = 0;
    int overall;

    Team(String inputName) throws IOException{
    
            //Random Number with bounds: int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
            name = inputName;

            currentSchedule = new Schedule();

            for(int i = 0; i < 47; i++){
                String tempFirstName = Files.readAllLines(Paths.get("FirstNames.txt")).get((int) (Math.random() * (2900 - 0) + 0));
                String tempLastName = Files.readAllLines(Paths.get("LastNames.txt")).get((int) (Math.random() * (88000 - 0) + 0));
                roster[i] = new Skater(tempFirstName, tempLastName, "Skater");
            }

            for(int i = 47; i < 50; i++){
                String tempFirstName = Files.readAllLines(Paths.get("FirstNames.txt")).get((int) (Math.random() * (2900 - 0) + 0));
                String tempLastName = Files.readAllLines(Paths.get("LastNames.txt")).get((int) (Math.random() * (88000 - 0) + 0));
                roster[i] = new Goalie(tempFirstName, tempLastName);
            }

            for(int i = 0; i < 50; i++){
                if(roster[i] instanceof Skater){
                    offense+=(((Skater) roster[i]).getSkatingSkill() + ((Skater) roster[i]).getShootingSkill())/2;
                    defense+=(((Skater) roster[i]).getDefensiveSkill());
                    numSkaters++;
                } else {
                    goalie+=(((Goalie) roster[i]).getGoalieSkill());
                    numGoalies++;
                }
            }

            offense = offense/numSkaters;
            defense = defense/numSkaters;
            goalie = goalie/numGoalies;
            overall = offense + defense + goalie;
    }

    public void makeTeamSchedule() throws IOException{
        this.currentSchedule.makeSchedule(this);
    }

    public void makeLines(){

    }

    public String getCity(){
        return this.city;
    }

    public String getName(){
        return this.name;
    }

    public int getOffence(){
        return this.offense;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getGoalie(){
        return this.goalie;
    }

    public int getOverall(){
        return this.overall;
    }

    public int totalWinsInGame(){
        int returnInt = currentSchedule.wins;
        for(int i = 0; i < scheduleHistory.size() - 1; i++){
            returnInt+=scheduleHistory.get(i).wins;
        }
        return returnInt;
    }

    public int totalLosesInGame(){
        int returnInt = currentSchedule.wins;
        for(int i = 0; i < scheduleHistory.size() - 1; i++){
            returnInt+=scheduleHistory.get(i).wins;
        }
        return returnInt;
    }
}