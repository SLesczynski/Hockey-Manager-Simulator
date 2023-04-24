package LeagueInfo;

public class Team {
    public String city;
    public String name;

    public Player[] roster = new Player[50];

    public int numSkaters = 0;
    public int offense = 0;
    public int defense = 0;

    public int numGoalies = 0;
    public int goalie = 0
    ;
    public int overall;

    public int wins = 0;
    public int loses = 0;  

    Team(String inputName){
    
            //Random Number with bounds: int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
            this.name = inputName;

            for(int i = 0; i < 47; i++){
                String tempName = this.name + i;
                roster[i] = new Player(tempName, "Skater");
            }

            for(int i = 47; i < 50; i++){
                String tempName = this.name + i;
                roster[i] = new Player(tempName, "Goalie");
            }

            for(int i = 0; i < 50; i++){
                if(roster[i].position.toString() == "Skater"){
                    this.offense+=(roster[i].skatingSkill + roster[i].shootingSkill)/2;
                    this.defense+=(roster[i].defenseSkill);
                    numSkaters++;
                } else {
                    this.goalie+=(roster[i].goalieSkill);
                    numGoalies++;
                }
            }

            this.offense = this.offense/numSkaters;
            this.defense = this.defense/numSkaters;
            this.goalie = this.goalie/numGoalies;
            this.overall = this.offense + this.defense + this.goalie;
    }
}
