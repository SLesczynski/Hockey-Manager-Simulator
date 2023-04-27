package LeagueInfo;

public class Goalie extends Player{

    int goalieSkill;

    Goalie(String name){
        setName(name);
        goalieSkill = (int) (Math.random() * (99 - 40)) + 40;
        age = (int) (Math.random() * (40 - 18) + 18);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getGoalieSkill(){
        return this.goalieSkill;
    }

    public void setGoalieSkill(int goalieSkill){
        this.goalieSkill = goalieSkill;
    }
}
