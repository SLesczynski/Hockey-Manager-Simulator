package LeagueInfo;

import java.io.IOException;

public class Team {
    public String city;
    public String name;

    public Schedule currentSchedule;

    public Player[] roster = new Player[50];

    public int numSkaters = 0;
    public int offense = 0;
    public int defense = 0;

    public int numGoalies = 0;
    public int goalie = 0;
    public int overall;

    public int wins = 0;
    public int loses = 0;  

    Team(String inputName) throws IOException{
    
            //Random Number with bounds: int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
            this.name = inputName;

            this.currentSchedule = new Schedule();

            for(int i = 0; i < 47; i++){
                String tempName = this.name + i;
                roster[i] = new Skater(tempName, "Skater");
            }

            for(int i = 47; i < 50; i++){
                String tempName = this.name + i;
                roster[i] = new Goalie(tempName);
            }

            for(int i = 0; i < 50; i++){
                if(roster[i] instanceof Skater){
                    this.offense+=(((Skater) roster[i]).getSkatingSkill() + ((Skater) roster[i]).getShootingSkill())/2;
                    this.defense+=(((Skater) roster[i]).getDefensiveSkill());
                    numSkaters++;
                } else {
                    this.goalie+=(((Goalie) roster[i]).getGoalieSkill());
                    numGoalies++;
                }
            }

            this.offense = this.offense/numSkaters;
            this.defense = this.defense/numSkaters;
            this.goalie = this.goalie/numGoalies;
            this.overall = this.offense + this.defense + this.goalie;
    }

    public void makeTeamSchedule() throws IOException{
        this.currentSchedule.makeSchedule(this);
    }
}
