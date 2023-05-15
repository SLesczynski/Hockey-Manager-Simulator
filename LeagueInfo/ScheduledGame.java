package LeagueInfo;

import java.io.IOException;

import Simulation.Game;

public class ScheduledGame {

    static int dayInSeason;

    Team homeTeam;
    Team awayTeam;

    Game gameSetup;

    ScheduledGame(int index, Team homeTeam, Team awayTeam) throws IOException{

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        dayInSeason = index;
        gameSetup = new Game(homeTeam,awayTeam);

        homeTeam.currentSchedule.teamSchedule[index] = this;
    
        awayTeam.currentSchedule.teamSchedule[index] = this;
    }

    public static int getGameDay(){
        return dayInSeason;
    }

    public Team getHomeTeam(){
        return homeTeam;
    }

    public Team getAwayTeam(){
        return awayTeam;
    }

    public Game getGame(){
        return gameSetup;
    }
}
