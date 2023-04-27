package LeagueInfo;
public abstract class Player {

    int age;
    String name;
    int height = 100;
    int weight = 100;

    public int[] seasonStats = {0,0,0};
    int[][] careerStats = {};

    public int getAge(){
        return this.age;
    }

    public void ageUp(){
        this.age++;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public int getHeight(){
        return this.height;
    }

    public void setHeight(int newHeight){
        this.height = newHeight;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int newWeight){
        this.weight = newWeight;
    }
}
