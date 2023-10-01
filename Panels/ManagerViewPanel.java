package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import LeagueInfo.League;
import LeagueInfo.Team;
import Simulation.Controller;
import Simulation.Game;
import Simulation.SeasonSimulation;

public class ManagerViewPanel extends JPanel implements ActionListener{

    Team managerTeam;
    JButton nextDay;
    JButton tradeMenu;
    JButton rosterButton;

    JTable teamInformationTable;

    JLabel lastGameInformation;

    public ManagerViewPanel(Team managedTeam){

        managerTeam = managedTeam;

        //Setup Panel
        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Setup game name text
        JLabel gameName = new JLabel();
        gameName.setText("Hockey Game Simulator");
        gameName.setHorizontalAlignment(JTextField.CENTER);
        gameName.setBounds(0, 0, this.getWidth(), this.getHeight()/7);
        gameName.setForeground(Color.white);
        gameName.setFont(new Font("Verdana", Font.PLAIN, 75));
        add(gameName);

        //Setup button to simulate a day
        nextDay = new JButton();
        nextDay.setBounds((int) ((int) this.getWidth() * 0.65),
                          (int) ((int) this.getHeight() * 0.85),
                          (int) ((int) this.getWidth() * 0.25),
                          (int) ((int) this.getHeight() * 0.1));
        nextDay.addActionListener((ActionListener) this);
        nextDay.setText("Simulate Day");
        add(nextDay);

        //Setup team and record view.
        teamInformationTable = new JTable();
        teamInformationTable.setFont(new Font("Verdana", Font.PLAIN, 17));
        updateTable(teamInformationTable);
        teamInformationTable.setBounds((int) ((int) this.getWidth() * 0.2),
                                       (int) ((int) this.getHeight() * 0.1), 
                                       (int) ((int) this.getWidth() * 0.25), 
                                       (int) ((int) this.getHeight() * 0.5));
        this.add(teamInformationTable);


        //Border
        setBorder(BorderFactory.createLineBorder(Color.RED, Controller.width/300));

        //Show last game score.
        lastGameInformation = new JLabel();
        lastGameInformation.setText("");
        gameName.setVerticalAlignment(JLabel.TOP);
        lastGameInformation.setBounds((int) ((int) this.getWidth() * 0.5),
                                      (int) ((int) this.getHeight() * 0.1), 
                                      (int) ((int) this.getWidth() * 0.45), 
                                      (int) ((int) this.getHeight() * 0.7));
        lastGameInformation.setForeground(Color.white);
        lastGameInformation.setFont(new Font("Verdana", Font.PLAIN, 15));
        lastGameInformation.setBorder(BorderFactory.createLineBorder(Color.RED, Controller.width/300));
        add(lastGameInformation);

        //Add logo of your team.
        JLabel logoLocation = new JLabel(managedTeam.logo, JLabel.CENTER);
        logoLocation.setBounds((int) ((int) this.getHeight() * 0.01),
                               (int) ((int) this.getHeight() * 0.01),
                               (int) ((int) this.getHeight() * 0.075),
                               (int) ((int) this.getHeight() * 0.08));
        ImageIcon logo = managedTeam.logo;
        Image image = logo.getImage();
        Image newImage = image.getScaledInstance(logoLocation.getWidth(), logoLocation.getHeight(), java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newImage);
        logoLocation.setIcon(logo);
        this.add(logoLocation);

        //Set up button to go to trade menu.
        tradeMenu = new JButton();
        tradeMenu.setBounds((int) ((int) this.getWidth() * 0.01),
                          (int) ((int) this.getHeight() * 0.1),
                          (int) ((int) this.getWidth() * 0.1),
                          (int) ((int) this.getHeight() * 0.1));
        tradeMenu.addActionListener((ActionListener) this);
        tradeMenu.setText("Trade");
        add(tradeMenu);

        //Set up button to show roster.
        rosterButton = new JButton();
        rosterButton.setBounds((int) ((int) this.getWidth() * 0.01),
                          (int) ((int) this.getHeight() * 0.21),
                          (int) ((int) this.getWidth() * 0.1),
                          (int) ((int) this.getHeight() * 0.1));
        rosterButton.addActionListener((ActionListener) this);
        rosterButton.setText("Roster");
        add(rosterButton);
    }

    public void updateTable(JTable table){
        String[][] array = new String[32][4];
        String[] columnNames = { "Team", "Wins", "Loses", "Points" };
        for(int i = 0; i < 32; i++){
            array[i][0] = League.teamArray[i].getCity() + " " +League.teamArray[i].getName();
            array[i][1] = Integer.toString(League.teamArray[i].currentSchedule.getWins());
            array[i][2] = Integer.toString(League.teamArray[i].currentSchedule.getLoses());
            array[i][3] = Integer.toString(League.teamArray[i].currentSchedule.totalPoints());
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(array, columnNames);
        table = new JTable(model);

        teamInformationTable.getColumnModel().getColumn(0).setPreferredWidth(210);
        teamInformationTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        teamInformationTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        teamInformationTable.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    public void updateLastGameInformation(JLabel label){
        if(managerTeam.currentSchedule.teamSchedule[SeasonSimulation.getDay() - 1] != null){
            label.setText("<html>");
            Game thisGame = managerTeam.currentSchedule.teamSchedule[SeasonSimulation.getDay() - 1].getGame();
            for(int i = 0; i < thisGame.events.size(); i++){
                System.out.println(thisGame.events);
                label.setText(label.getText() + "<br><br>" + thisGame.events.get(i));
            }
            label.setText(label.getText() + "</html>");
        } else {
            label.setText("No game on the " + SeasonSimulation.getDay() + " day of the season.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextDay){
            try {
                Controller.simulateDay();
                updateLastGameInformation(lastGameInformation);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            updateTable(teamInformationTable);
        } else if(e.getSource() == tradeMenu){
            Controller.setTradePanel(managerTeam);
        } else if(e.getSource() == rosterButton){
            Controller.setRosterPanel(managerTeam);
        }
    }    
}
