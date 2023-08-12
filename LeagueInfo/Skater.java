package LeagueInfo;

import java.util.Random;

public class Skater extends Player{

    String position;
    int skatingSkill;
    int shootingSkill;
    int defenseSkill;
    int overall;

    Skater(String name, String lastName, String position){
        setFirstName(name);

        String newLastName = lastName.toLowerCase();
        newLastName = newLastName.substring(0, 1).toUpperCase() + newLastName.substring(1);
        setLastName(newLastName);
        setPosition(position);
        skatingSkill = (int) (Math.random() * (99 - 40)) + 40;
        shootingSkill = (int) (Math.random() * (99 - 40)) + 40;
        defenseSkill = (int) (Math.random() * (99 - 40)) + 40;
        overall = (skatingSkill + shootingSkill + defenseSkill)/3;
        age = (int) (Math.random() * (40 - 18) + 18);
        Random r = new Random();
        setPotential((int) r.nextGaussian()* 25 + 50);
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

    public int getOverall(){
        return this.overall;
    }
}
