package Simulation;
import java.io.IOException;

import LeagueInfo.*;

public class Game {
    
    double winNumber;

    double favor = 10;

    Team homeTeam;

    Team awayTeam;

    String winner;


    public Game( Team homeTeam, Team awayTeam) throws IOException {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        favor = favor + (homeTeam.getOffence() - awayTeam.getOffence()) + (homeTeam.getDefense() - awayTeam.getDefense()) + (homeTeam.getGoalie() - awayTeam.getGoalie());
    }

    public void playGame() {
        winNumber = ((Math.random() * (500  - (-500))));
        if(winNumber < favor + 500){
            this.winner = homeTeam.getName();
            homeTeam.wins++;
            awayTeam.loses++;
        } else {
           winner = awayTeam.getName();
           homeTeam.loses++;
           awayTeam.wins++;
        }
    }

    public Team getHomeTeam(){
        return this.homeTeam;
    }

    public Team getAwayTeam(){
        return this.awayTeam;
    }

    public double getFavor(){
        return this.favor;
    }

    public String getWinner(){
        return this.winner;
    }
}
