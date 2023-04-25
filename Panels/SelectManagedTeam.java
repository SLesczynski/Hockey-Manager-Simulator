package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import LeagueInfo.League;
import Simulation.Controller;

public class SelectManagedTeam extends JPanel implements ActionListener{
    
    JComboBox<String> selectedManagedTeam;

    JTable teamInformationTable;

    JButton startGame;

    public SelectManagedTeam(){
        
        //Setup Panel
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        setBackground(Color.darkGray);

        //Select Team
        JLabel homeTeamSelectText = new JLabel();
        homeTeamSelectText.setText("Select Team");
        homeTeamSelectText.setBounds(25, 25, 700, 50);
        homeTeamSelectText.setForeground(Color.white);
        homeTeamSelectText.setFont(new Font("Verdana", Font.PLAIN, 50));
        this.add(homeTeamSelectText);

        //Team Selection
        selectedManagedTeam = new JComboBox<>(League.teamNameArray);
        selectedManagedTeam.setBounds(25, 100, 400, 50);
        selectedManagedTeam.setFont(new Font("Verdana", Font.PLAIN, 25));
        this.add(selectedManagedTeam);

        //Setup button to switch to another screen
        startGame = new JButton();
        startGame.setBounds(200, 600, 500, 50);
        startGame.addActionListener((ActionListener) this);
        startGame.setText("Click to Start");
        this.add(startGame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Controller.setManagerView();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
