package Simulation;
import java.io.IOException;

import LeagueInfo.*;

public class Game {
    
    double winNumber;

    double favor = 10;

    public int faceOffs = 0;

    Team homeTeam;
    public int homeTeamScore;
    public int homeTeamShots;
    public int homeTeamHits;

    Team awayTeam;
    public int awayTeamScore;
    public int awayTeamShots;
    public int awayTeamHits;

    public int periodsPlayed = 3;
    public int extraMinutesPlayed = 0;
    public int extraSecondsPlayed = 0;


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
        System.out.println("Home Team Goalie Save Percentage: " + (1 - ((awayTeamScore*1.000))/awayTeamShots));
        System.out.println("Away Team Goalie Save Percentage: " + (1 - ((homeTeamScore*1.000))/homeTeamShots));
    }

    //Simulates each period and necessary overtime periods.
    public void simulateGame(){
        homeTeamScore = 0;
        awayTeamScore = 0;

        homeTeamShots = 0;
        awayTeamShots = 0;

        periodsPlayed = 3;
        extraMinutesPlayed = 0;
        extraSecondsPlayed = 0;

        homeTeamHits = 0;
        awayTeamHits = 0;
        faceOffs = 0;

        simulatePeriod();
        simulatePeriod();
        simulatePeriod();
        while(homeTeamScore == awayTeamScore){
            simulateOvertime();
            periodsPlayed++;
        }
        System.out.println(faceOffs);
        System.out.println("Home Team Hits: " + homeTeamHits);
        System.out.println("Away Team Hits: " + awayTeamHits);
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

    //Simulates a period which is 20 minutes.
    public void simulatePeriod(){
        for(int i = 0; i < 20; i++){
            simulateMinute();
        }
    }

    //Simulates a minute of gameplay
    public void simulateMinute(){
        for(int i = 0; i < 60; i++)
            simulateSecond();
    }

    public void simulateSecond(){
        int randomEvent = (int) (Math.random() * (1000 - 0)) + 0;
        if(randomEvent > 0 && randomEvent < 200){
            simulateShot();
        } else if(randomEvent > 962 && randomEvent <= 970) {
            homeTeamHits++;
        } else if(randomEvent > 972 && randomEvent <= 980){
            awayTeamHits++;
        } else if(randomEvent > 983 && randomEvent < 999) {
            simulateFaceoff();
        } else {
            return;
        }
    }

    public void simulateShot(){
        int randomIndex = (int) (Math.random() * (1000 - 0)) + 0;
        if(randomIndex < 40 + favor){
            homeTeamShots++;
            shoot(homeTeam, awayTeam);
        } else if (randomIndex > 960 - favor){
            awayTeamShots++;
            shoot(awayTeam, homeTeam);
        }
    }


    public void shoot(Team offense, Team defense){
        double randomShotSelection = Math.random();
        System.out.println("Shot:" + randomShotSelection);
        
        int randomScorer = (int) (Math.random() * (21 - 0)) + 0;
        Skater shootingPlayer = ((Skater) offense.roster[randomScorer]);

        Goalie goalieInNet = ((Goalie) defense.roster[48]);

        double goalieSaveChance = 0.9000 - (((shootingPlayer.getShootingSkill()/1000.0000)*1.1) - (goalieInNet.getGoalieSkill()/1000.0000));

        System.out.println("Shooter skill : " + shootingPlayer.getShootingSkill());
        System.out.println("Goalie skill: " + goalieInNet.getGoalieSkill());
        System.out.println("Goalie Expected Save percent: " + goalieSaveChance);

        if(randomShotSelection > goalieSaveChance ) {
            scoreGoal(offense);
            assignPoints(offense, shootingPlayer);
        }
    }

    public void scoreGoal(Team scoringTeam){
        if(scoringTeam == homeTeam){
            homeTeamScore++;
        } else {
            awayTeamScore++;
        }
    }

    public void simulateFaceoff(){
        faceOffs++;
    }

    //When a team scores this sets the scorer and assists.
    public void assignPoints(Team scoringTeam, Skater scorer){
        int randomAssistOne = (int) (Math.random() * (21 - 0)) + 0;
        int randomAssistTwo = (int) (Math.random() * (21 - 0)) + 0;
        while(scorer == scoringTeam.roster[randomAssistOne]){
            randomAssistOne = (int) (Math.random() * (21 - 0)) + 0;
            while(scorer == scoringTeam.roster[randomAssistTwo]){
                randomAssistTwo = (int) (Math.random() * (21 - 0)) + 0;
                while(randomAssistOne == randomAssistTwo){
                    randomAssistTwo = (int) (Math.random() * (21 - 0)) + 0;
                }
            }
        }
        scorer.seasonStats[0]+=1;
        scoringTeam.roster[randomAssistOne].seasonStats[1]+=1;
        scoringTeam.roster[randomAssistTwo].seasonStats[1]+=1;
        System.out.println("Goal Scored by " + scorer.getName() + " with an assist from " + scoringTeam.roster[randomAssistOne].getName() + " and " + scoringTeam.roster[randomAssistTwo].getName());
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