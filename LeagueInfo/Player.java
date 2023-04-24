package LeagueInfo;
public class Player {

    public String name;
    public String position;
    public int skatingSkill;
    public int shootingSkill;
    public int defenseSkill;
    public int goalieSkill;
    public int height = 100;
    public int weight = 100;

    Player(String newName, String newPosition){

        this.name = newName;
        this.position = newPosition;
        if(newPosition == "Skater"){
            this.skatingSkill = (int) (Math.random() * (99 - 40)) + 40;
            this.shootingSkill = (int) (Math.random() * (99 - 40)) + 40;
            this.defenseSkill = (int) (Math.random() * (99 - 40)) + 40;
        } else {
            this.goalieSkill = (int) (Math.random() * (99 - 40)) + 40;
        }
    }
}
