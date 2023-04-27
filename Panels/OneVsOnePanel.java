package Panels;

import Simulation.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import LeagueInfo.Team;

public class OneVsOnePanel extends JPanel implements ActionListener{

    Game game;

    String htmlText;

    JButton simulateGame;
    JButton backButton;

    JLabel homeTeamInformation;
    JLabel awayTeamInformation;
    
    Team thisHomeTeam;
    Team thisAwayTeam;

    public OneVsOnePanel(Team homeTeam, Team awayTeam) throws IOException{

        thisHomeTeam = homeTeam;
        thisAwayTeam = awayTeam;
        game = new Game(homeTeam, awayTeam);
        String favorite;
        if (homeTeam.getOverall() > awayTeam.getOverall()) {
            favorite = homeTeam.getName();
        } else if (homeTeam.getOverall() < awayTeam.getOverall()) {
            favorite = awayTeam.getName();
        } else {
            favorite = "Undecided";
        }

        Color myRed = new Color(125, 0, 0);
        Color myGray = new Color(50, 50, 50);

        // Setup JFrame
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        setBackground(Color.darkGray);

        // Top Text
        JLabel gameInfoText = new JLabel();
        htmlText = new String("<html><center>" + homeTeam.getName() + " versus " + awayTeam.getName() + "<br>Favorite: "
                + favorite + "</html>");
        gameInfoText.setText(htmlText);
        gameInfoText.setHorizontalAlignment(JLabel.CENTER);
        gameInfoText.setBounds(50, 30, 900, 110);
        gameInfoText.setForeground(Color.white);
        gameInfoText.setBackground(myGray);
        gameInfoText.setOpaque(true);
        gameInfoText.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(gameInfoText);

        // Top Text Decoration
        JLabel gameInfoTextDecoration = new JLabel();
        gameInfoTextDecoration.setBounds(40, 20, 920, 130);
        gameInfoTextDecoration.setBackground(myRed);
        gameInfoTextDecoration.setOpaque(true);
        this.add(gameInfoTextDecoration);

        // Home Text
        homeTeamInformation = new JLabel();
        updateInformation(homeTeamInformation, thisHomeTeam, "left");
        homeTeamInformation.setHorizontalAlignment(JLabel.LEFT);
        homeTeamInformation.setBounds(25, 30, 400, 500);
        homeTeamInformation.setForeground(Color.white);
        homeTeamInformation.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(homeTeamInformation);

        // Away Text
        awayTeamInformation = new JLabel();
        updateInformation(awayTeamInformation, thisAwayTeam, "right");
        awayTeamInformation.setHorizontalAlignment(JLabel.RIGHT);
        awayTeamInformation.setBounds(575, 30, 400, 500);
        awayTeamInformation.setForeground(Color.white);
        awayTeamInformation.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(awayTeamInformation);

        // Show Win Chance Bar between the team information
        JLabel homeTeamWinChance = new JLabel();
        homeTeamWinChance.setBounds(450, 50, 100, (int) (500 + game.getFavor()));
        homeTeamWinChance.setBackground(Color.blue);
        homeTeamWinChance.setOpaque(true);
        this.add(homeTeamWinChance);

        JLabel awayTeamWinChance = new JLabel();
        awayTeamWinChance.setBounds(450, (int) (525 + game.getFavor()), 100, (int) (500 - game.getFavor()));
        awayTeamWinChance.setBackground(Color.red);
        awayTeamWinChance.setOpaque(true);
        this.add(awayTeamWinChance);

        // Simulate game button
        simulateGame = new JButton();
        simulateGame.setBounds(50, 900, 250, 50);
        simulateGame.addActionListener((ActionListener) this);
        simulateGame.setText("Simulate Game");
        simulateGame.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(simulateGame);

        // Back to GameCreationButon
        backButton = new JButton();
        backButton.setBounds(700, 900, 250, 50);
        backButton.addActionListener((ActionListener) this);
        backButton.setText("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(backButton);

        // Boarder Gray
        JLabel boarderGray = new JLabel();
        boarderGray.setBounds(10, 10, 980, 980);
        boarderGray.setBackground(myGray);
        boarderGray.setOpaque(true);
        this.add(boarderGray);

        // Boarder Red
        JLabel boarderRed = new JLabel();
        boarderRed.setBounds(0, 0, 1000, 1000);
        boarderRed.setBackground(myRed);
        boarderRed.setOpaque(true);
        this.add(boarderRed);

    }

    void updateInformation(JLabel text, Team team, String alignment) {
        htmlText = new String("<html><p style=\"text-align:" + alignment + ";\">" + team.getName()
                + "<br>Offense: " + team.getOffence()
                + "<br>Defense:" + team.getDefense()
                + "<br>Goalie: " + team.getGoalie()
                + "<br>Record: " + team.currentSchedule.getWins() + " - " + team.currentSchedule.getLoses() + "</p></html>");
        text.setText(htmlText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == simulateGame) {
            game.simulateGame();
            System.out.println(game.homeTeamScore + " - " + game.awayTeamScore);
            System.out.println("It took " + game.periodsPlayed + " periods to end the game.");
            updateInformation(homeTeamInformation, thisHomeTeam, "left");
            updateInformation(awayTeamInformation, thisAwayTeam, "right");
    }
    }
}
