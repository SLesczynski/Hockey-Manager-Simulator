package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import LeagueInfo.Player;
import LeagueInfo.Team;
import Simulation.Controller;

public class TradePanel extends JPanel{
    
    Team yourTeam;

    public TradePanel(Team managedTeam){

        yourTeam = managedTeam;

        //Setup Panel
        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Setup game name text
        JLabel gameName = new JLabel();
        gameName.setText("Trading");
        gameName.setHorizontalAlignment(JTextField.CENTER);
        gameName.setBounds(0,
                           0, 
                           this.getWidth(), 
                           this.getHeight()/8);
        gameName.setForeground(Color.white);
        gameName.setFont(new Font("Verdana", Font.PLAIN, 75));
        add(gameName);

        //Show your assests.
        Player[] data = yourTeam.roster;
        JList dataList = new JList(data);
        JScrollPane scrollPane = new JScrollPane(dataList);
        scrollPane.setBounds((int) ((int) this.getWidth() * 0.05),
                                    (int) ((int) this.getHeight() * 0.125),
                                    (int) ((int) this.getWidth() * 0.3),
                                    (int) ((int) this.getHeight() * 0.6));
        add(scrollPane);
        //Select other team.

        //Show other teams assests.

        //Submit trade

        //Go Back
    }
}
