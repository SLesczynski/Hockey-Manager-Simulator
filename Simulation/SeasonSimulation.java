package Simulation;

import java.io.IOException;

import LeagueInfo.League;
import LeagueInfo.Schedule;

public class SeasonSimulation {
    
    static int currentDayIndex;

    public static void simulateDay() throws IOException {
        System.out.println(currentDayIndex);
        for(int i = 0; i < 32; i++){
            if(League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex] != null){
                if(League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex].getHomeTeam() == League.teamArray[i]){
                    League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex].getGame().playGame();
                }
            }
        }
        if(currentDayIndex == 364){
        Schedule.nextSeasonSchedule();
        currentDayIndex = 0;
        } else {
        currentDayIndex++;
        }
    }
    
}
