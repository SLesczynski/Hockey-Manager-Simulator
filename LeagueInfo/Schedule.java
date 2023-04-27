package LeagueInfo;

import java.io.IOException;

public class Schedule {

    public ScheduledGame[] teamSchedule = new ScheduledGame[365];

    int wins = 0;
    int loses = 0;

    int points = 0;

    int goalsFor = 0;
    int goalsAgainst = 0;

    public Schedule(){

    }

    public int getWins(){
        return this.wins;
    }

    public void wonGame(){
        this.wins++;
        this.points+=2;
    }

    public int getLoses(){
        return this.loses;
    }

    public void lostGame(){
        this.loses++;
    }

    public int getGoalsFor(){
        return goalsFor;
    }

    public void addGoalFor(){
        goalsFor++;
    }

    public int getGoalsAgainst(){
        return goalsAgainst;
    }

    public void addGoalAgainst(){
        goalsAgainst++;
    }

    public void makeSchedule(Team thisTeam) throws IOException{
        for(int i = 0; i < 32; i++){
            Team currentAwayTeam = League.teamArray[i];
            if(currentAwayTeam != thisTeam){
                int randomIndex = (int) (Math.random() * (250 - 59)) + 59;
                while(teamSchedule[randomIndex] != null
                        || League.teamArray[i].currentSchedule.teamSchedule[randomIndex] != null)
                {
                    randomIndex = (int) (Math.random() * (250 - 59)) + 59;
                }
                new ScheduledGame(randomIndex, thisTeam, currentAwayTeam);
            }
        }
    }

    public static void nextSeasonSchedule() throws IOException{

        //Add current schedule to history and create new empty schedule
        for(int i = 0; i < 32; i++){
            League.teamArray[i].scheduleHistory.add(League.teamArray[i].currentSchedule);
            League.teamArray[i].currentSchedule = new Schedule();

            for(int j = 0; j < 50; j++){
                League.teamArray[i].roster[j].ageUp();
            }
        }
        System.out.println(League.teamArray[0].roster[0].getAge());
        for(int i = 0; i < 32; i++){
            League.teamArray[i].makeTeamSchedule();
        }
    }

    public int totalPoints() {
        return this.points;
    }

}

