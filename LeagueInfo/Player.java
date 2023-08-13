package LeagueInfo;
public abstract class Player {

    int age;
    String firstName;
    String lastName;
    int height = 100;
    int weight = 100;

    int potential;

    public int[] seasonStats = {0,0,0};
    int[][] careerStats = {};

    public int getAge(){
        return this.age;
    }

    public void ageUp(){
        this.age++;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
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

    public void setPotential(int potential){
        this.potential = potential;
    }

    public int getValue() {
        return 100;
    }

    public String getPosition() {
        return "Player";
    }
}
