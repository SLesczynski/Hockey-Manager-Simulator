package LeagueInfo;

public class Skater extends Player{

    String position;
    int skatingSkill;
    int shootingSkill;
    int defenseSkill;

    Skater(String name, String position){
        setName(name);
        setPosition(position);
        skatingSkill = (int) (Math.random() * (99 - 40)) + 40;
        shootingSkill = (int) (Math.random() * (99 - 40)) + 40;
        defenseSkill = (int) (Math.random() * (99 - 40)) + 40;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPosition(){
        return this.position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public int getSkatingSkill(){
        return this.skatingSkill;
    }

    public void setSkatingSkill(int skatingSkill){
        this.skatingSkill = skatingSkill;
    }

    public int getShootingSkill(){
        return this.shootingSkill;
    }

    public void setShootingSkill(int shootingSkill){
        this.skatingSkill = shootingSkill;
    }

    public int getDefensiveSkill(){
        return this.defenseSkill;
    }

    public void setDefensiveSkill(int defenseSkill){
        this.defenseSkill = defenseSkill;
    }
}
