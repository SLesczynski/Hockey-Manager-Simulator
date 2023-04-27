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
    public int extraMinutesPlayed = 0;


    public Game( Team homeTeam, Team awayTeam) throws IOException {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        favor = favor + (homeTeam.getOffence() - awayTeam.getOffence()) + (homeTeam.getDefense() - awayTeam.getDefense()) + (homeTeam.getGoalie() - awayTeam.getGoalie());
    }

    //Simulates game and then assigns win and loss.
    public void playGame() {
        simulateGame();
        System.out.println("Expected Shots " + getExpectedShots(homeTeam, awayTeam));
        if(homeTeamScore > awayTeamScore){
            homeTeam.currentSchedule.wonGame();
            awayTeam.currentSchedule.lostGame();
        } else {
           homeTeam.currentSchedule.lostGame();
           awayTeam.currentSchedule.wonGame();
        }
    }

    //Simulates each period and necessary overtime periods.
    public void simulateGame(){
        homeTeamScore = 0;
        awayTeamScore = 0;
        periodsPlayed = 3;
        extraMinutesPlayed = 0;
        simulatePeriod();
        simulatePeriod();
        simulatePeriod();
        while(homeTeamScore == awayTeamScore){
            simulateOvertime();
            periodsPlayed++;
        }
    }

    //Simulates a minute of gameplay
    public void simulateMinute(){
        int randomIndex = (int) (Math.random() * (1000 - 0)) + 0;
            if(randomIndex < 50 + favor){
                homeTeamScore++;
                assignPoints(homeTeam);
            } else if (randomIndex > 950 - favor){
                awayTeamScore++;
                assignPoints(awayTeam);
            }
    }

    //Simulates a period which is 20 minutes.
    public void simulatePeriod(){
        for(int i = 0; i < 20; i++){
            simulateMinute();
        }
    }

    //Simulates a period of overtime and stops if one of the teams scores.
    public void simulateOvertime(){
        for(int i = 0; i < 20; i++){
            if(homeTeamScore == awayTeamScore){
              simulateMinute();  
              extraMinutesPlayed++;
            }
        }
        if(extraMinutesPlayed == 20){
            extraMinutesPlayed = 0;
        }
    }

    //When a team scores this sets the scorer and assists.
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

    public double getExpectedShots(Team attackTeam, Team defenseTeam){
        int totalShootingSkill = 0;
        int opposingTeamDefense = 0;
        for(int i = 0; i < 47; i++){
            totalShootingSkill+= (((Skater) attackTeam.roster[i]).getSkatingSkill());
        }

        for(int i = 0; i < 47; i++){
            opposingTeamDefense+= (((Skater) defenseTeam.roster[i]).getDefensiveSkill());
        }
        System.out.println(totalShootingSkill);
        System.out.println(opposingTeamDefense);
        return ((totalShootingSkill/opposingTeamDefense) * 100);
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
}
