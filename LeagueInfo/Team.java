package LeagueInfo;

import java.io.IOException;

public class Team {
    String city;
    String name;

    public Schedule currentSchedule;
    

    public Player[] roster = new Player[50];

    int numSkaters = 0;
    int offense = 0;
    int defense = 0;

    int numGoalies = 0;
    int goalie = 0;
    int overall;

    public int wins = 0;
    public int loses = 0;  

    Team(String inputName) throws IOException{
    
            //Random Number with bounds: int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
            name = inputName;

            currentSchedule = new Schedule();

            for(int i = 0; i < 47; i++){
                String tempName = name + i;
                roster[i] = new Skater(tempName, "Skater");
            }

            for(int i = 47; i < 50; i++){
                String tempName = name + i;
                roster[i] = new Goalie(tempName);
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
}
