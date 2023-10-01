package LeagueInfo;

public class Goalie extends Player{

    Goalie(String name, String lastName){
        setFirstName(name);
        setLastName(lastName);
        overall = (int) (Math.random() * (99 - 40)) + 40;
        age = (int) (Math.random() * (40 - 18) + 18);
    }

    public int getGoalieSkill(){
        return this.overall;
    }

    public void setGoalieSkill(int newOverall){
        this.overall = newOverall;
    }

    public String getPosition(){
        return "Goalie";
    }
}
