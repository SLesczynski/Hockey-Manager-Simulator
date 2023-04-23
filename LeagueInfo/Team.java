package LeagueInfo;

public class Team {
    public String city;
    public String name;
    public Player[] roster;
    public int offense;
    public int defense;
    public int goalie;
    public int overall;
    public int wins = 0;
    public int loses = 0;  

    Team(String inputName){
    
            //Random Number with bounds: int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
            this.name = inputName;
            this.offense = (int) (Math.random() * (100 - 50) + 50);
            this.defense = (int) (Math.random() * (100 - 50) + 50);
            this.goalie = (int) (Math.random() * (100 - 50) + 50);
            this.overall = this.offense + this.defense + this.goalie;
    }
}
