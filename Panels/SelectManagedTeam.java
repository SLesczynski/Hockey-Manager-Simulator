package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import LeagueInfo.League;
import Simulation.Controller;

public class SelectManagedTeam extends JPanel implements ActionListener{
    
    JComboBox<String> selectedManagedTeam;

    JTable teamInformationTable;

    JButton startGame;

    public SelectManagedTeam(){
        
        //Setup Panel
        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Select Team
        JLabel homeTeamSelectText = new JLabel();
        homeTeamSelectText.setText("Select Team");
        homeTeamSelectText.setHorizontalAlignment(JTextField.CENTER);
        homeTeamSelectText.setBounds(0, 10, this.getWidth(), this.getHeight()/7);
        homeTeamSelectText.setForeground(Color.white);
        homeTeamSelectText.setFont(new Font("Verdana", Font.PLAIN, 50));
        this.add(homeTeamSelectText);

        //Team Selection
        selectedManagedTeam = new JComboBox<>(League.teamNameArray);
        selectedManagedTeam.setBounds(this.getWidth()/2, (int) ((int) this.getHeight() * 0.2), this.getWidth()/2, this.getHeight()/2);
        selectedManagedTeam.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(selectedManagedTeam);

        //Logo of selected team.
        //Will be to the left of the team selector and display the logo of the current team.
        this.add(new JLabel(new ImageIcon("Chicago.png")));

        //Setup button to switch to another screen
        startGame = new JButton();
        startGame.setBounds(this.getWidth()/4, (int) ((int) this.getHeight() * 0.75), this.getWidth()/2, this.getHeight()/8);
        startGame.addActionListener((ActionListener) this);
        startGame.setText("Click to Start");
        this.add(startGame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Controller.setManagerView(League.teamArray[selectedManagedTeam.getSelectedIndex()]);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
