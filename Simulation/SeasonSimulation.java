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
        if(League.teamArray[0].currentSchedule.getWins() > 0 || League.teamArray[0].currentSchedule.getLoses() > 0){
            System.out.println((double) League.teamArray[0].currentSchedule.getGoalsFor()/(League.teamArray[0].currentSchedule.getWins() + League.teamArray[0].currentSchedule.getLoses()));
        }
        System.out.println(League.teamArray[0].roster[0].seasonStats[0]);
        if(currentDayIndex == 364){
            Schedule.nextSeasonSchedule();
            currentDayIndex = 0;
        } else {
            currentDayIndex++;
        }
    }
    
}
