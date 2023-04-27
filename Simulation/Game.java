package Simulation;
import java.io.IOException;

import LeagueInfo.*;

public class Game {
    
    double winNumber;

    double favor = 10;

    Team homeTeam;
    public int homeTeamScore;

    Team awayTeam;
    public int awayTeamScore;

    public int periodsPlayed = 3;

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
            homeTeam.currentSchedule.wonGame();
            awayTeam.currentSchedule.lostGame();
        } else {
           winner = awayTeam.getName();
           homeTeam.currentSchedule.lostGame();
           awayTeam.currentSchedule.wonGame();
        }
    }

    public void simulateGame(){
        homeTeamScore = 0;
        awayTeamScore = 0;
        periodsPlayed = 3;
        simulatePeriod();
        simulatePeriod();
        simulatePeriod();
        while(homeTeamScore == awayTeamScore){
            simulatePeriod();
            periodsPlayed++;
        }
        if(homeTeamScore > awayTeamScore){
            winner = homeTeam.getName();
        } else {
            winner = awayTeam.getName();
        }
    }

    public void simulatePeriod(){
        for(int i = 0; i < 20; i++){
            int randomIndex = (int) (Math.random() * (1000 - 0)) + 0;
            if(randomIndex < 50 + favor){
                homeTeamScore++;
                assignPoints(homeTeam);
            } else if (randomIndex > 950 - favor){
                awayTeamScore++;
                assignPoints(awayTeam);
            }
        }
    }

    public void assignPoints(Team scoringTeam){
        int randomScorer = (int) (Math.random() * (47 - 0)) + 0;
        int randomAssistOne = (int) (Math.random() * (47 - 0)) + 0;
        int randomAssistTwo = (int) (Math.random() * (47 - 0)) + 0;
        while(randomScorer == randomAssistOne){
            randomAssistOne = (int) (Math.random() * (47 - 0)) + 0;
            while(randomScorer == randomAssistTwo){
                randomAssistTwo = (int) (Math.random() * (47 - 0)) + 0;
                while(randomAssistOne == randomAssistTwo){
                    randomAssistTwo = (int) (Math.random() * (47 - 0)) + 0;
                }
            }
        }
        scoringTeam.roster[randomScorer].seasonStats[0]+=1;
        scoringTeam.roster[randomAssistOne].seasonStats[1]+=1;
        scoringTeam.roster[randomAssistTwo].seasonStats[1]+=1;
        System.out.println("Goal Scored by " + scoringTeam.roster[randomScorer].getName() + " with an assist from " + scoringTeam.roster[randomAssistOne].getName() + " and " + scoringTeam.roster[randomAssistTwo].getName());
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
