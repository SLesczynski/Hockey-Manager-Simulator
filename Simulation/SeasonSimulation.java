package Simulation;

import LeagueInfo.League;

public class SeasonSimulation {
    
    int currentDayIndex;

    public static void simulateDay() {
        for(int i = 0; i < 32; i++){
            if(League.teamArray[i].currentSchedule.teamSchedule[i] != null){
                if(League.teamArray[i].currentSchedule.teamSchedule[i].getHomeTeam() == League.teamArray[i]){
                    League.teamArray[i].currentSchedule.teamSchedule[i].getGame().playGame();
                }
            }
        }
    }
    
}
