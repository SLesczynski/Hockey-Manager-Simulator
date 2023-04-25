package Simulation;

import LeagueInfo.League;

public class SeasonSimulation {
    
    static int currentDayIndex;

    public static void simulateDay() {
        System.out.println(currentDayIndex);
        for(int i = 0; i < 32; i++){
            if(League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex] != null){
                if(League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex].getHomeTeam() == League.teamArray[i]){
                    League.teamArray[i].currentSchedule.teamSchedule[currentDayIndex].getGame().playGame();
                }
            }
        }
        currentDayIndex++;
    }
    
}
