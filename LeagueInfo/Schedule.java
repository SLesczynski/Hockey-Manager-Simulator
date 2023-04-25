package LeagueInfo;

import java.io.IOException;

public class Schedule {

    public ScheduledGame[] teamSchedule = new ScheduledGame[365];

    public int homeGames;
    int awayGames;


    Schedule(){

    }

    public void makeSchedule(Team thisTeam) throws IOException{
        for(int i = 0; i < 32; i++){
            Team currentAwayTeam = League.teamArray[i];
            if(currentAwayTeam != thisTeam){
                int randomIndex = (int) (Math.random() * (250 - 59)) + 59;
                while(teamSchedule[randomIndex] != null && League.teamArray[i].currentSchedule.teamSchedule[randomIndex] != null){
                    randomIndex = (int) (Math.random() * (250 - 59)) + 59;
                }
                new ScheduledGame(randomIndex, thisTeam, currentAwayTeam);
            }
        }
    }

}

