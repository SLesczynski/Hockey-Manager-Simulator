package LeagueInfo;

import java.io.IOException;

import Simulation.Game;

public class ScheduledGame {

    int dayInSeason;

    Team homeTeam;
    Team awayTeam;

    Game gameSetup;

    ScheduledGame(int index, Team homeTeam, Team awayTeam) throws IOException{

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        dayInSeason = index;
        gameSetup = new Game(homeTeam,awayTeam);

        homeTeam.currentSchedule.teamSchedule[index] = this;
        homeTeam.currentSchedule.homeGames++;
    
        awayTeam.currentSchedule.teamSchedule[index] = this;
        awayTeam.currentSchedule.awayGames++;
    }

    public int getGameDay(){
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
