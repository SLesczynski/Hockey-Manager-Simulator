package Simulation;
import java.io.IOException;

import LeagueInfo.*;

public class Game {
    
    public double winNumber;

    public double favor = 10;

    public Team homeTeam;
    public int homeTeamAttack;
    public int homeTeamDefense;
    public int homeTeamGoalie;

    public Team awayTeam;
    public int awayTeamAttack;
    public int awayTeamDefense;
    public int awayTeamGoalie;

    public String winner;

    public void playGame() {
        winNumber = ((Math.random() * (500  - (-500))));
        if(winNumber < favor + 500){
            this.winner = homeTeam.name;
            homeTeam.wins++;
            awayTeam.loses++;
        } else {
           winner = awayTeam.name;
           homeTeam.loses++;
           awayTeam.wins++;
        }
    }



    public Game( Team homeTeam, Team awayTeam) throws IOException {

        this.homeTeam = homeTeam;
        homeTeamAttack = homeTeam.offense;
        homeTeamDefense = homeTeam.defense;
        homeTeamGoalie = homeTeam.goalie;
    
        this.awayTeam = awayTeam;
        awayTeamAttack = awayTeam.offense;
        awayTeamDefense = awayTeam.defense;
        awayTeamGoalie = awayTeam.goalie;

        favor = favor + (homeTeamAttack - awayTeamAttack) + (homeTeamDefense - awayTeamDefense) + (homeTeamGoalie - awayTeamGoalie);
    }
}
