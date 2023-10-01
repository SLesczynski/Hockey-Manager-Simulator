package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import LeagueInfo.Team;
import Simulation.Controller;

public class RosterPanel extends JPanel{

    public RosterPanel(Team thisTeam){


        //Setup Panel
        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Border
        setBorder(BorderFactory.createLineBorder(Color.RED, Controller.width/300));

        //Setup game name text
        JLabel gameName = new JLabel();
        gameName.setText("Roster");
        gameName.setHorizontalAlignment(JTextField.CENTER);
        gameName.setBounds(0,
                           0, 
                           this.getWidth(), 
                           this.getHeight()/8);
        gameName.setForeground(Color.white);
        gameName.setFont(new Font("Verdana", Font.PLAIN, 75));
        add(gameName);

        //Roster
        JScrollPane rosterPane = new JScrollPane();
        JTable roster;

        String[][] array = new String[thisTeam.roster.length][5];
        String[] columnNames = { "Player Name", "Overall", "Potential", "Position", "Age" };
        for(int i = 0; i < array.length; i++){
            array[i][0] = thisTeam.roster[i].getName();
            array[i][1] = Integer.toString(thisTeam.roster[i].getOverall());
            array[i][2] = Integer.toString(thisTeam.roster[i].getPotential());
            array[i][3] = thisTeam.roster[i].getPosition();
            array[i][4] = Integer.toString(thisTeam.roster[i].getAge());
        }
        DefaultTableModel model = new DefaultTableModel(50, columnNames.length);
        model.setDataVector(array, columnNames);
        roster = new JTable(model);

        roster.getColumnModel().getColumn(0).setPreferredWidth(210);
        roster.getColumnModel().getColumn(1).setPreferredWidth(10);
        roster.getColumnModel().getColumn(2).setPreferredWidth(10);
        roster.getColumnModel().getColumn(3).setPreferredWidth(10);
        roster.getColumnModel().getColumn(3).setPreferredWidth(10);

        roster.setFont(new Font("Verdana", Font.PLAIN, 17));

        rosterPane.add(roster);
        rosterPane.setBounds((int) ((int) this.getWidth() * 0.05),
                        (int) ((int) this.getHeight() * 0.125),
                        (int) ((int) this.getWidth() * 0.8),
                        (int) ((int) this.getHeight() * 0.8));
        roster.setBounds(0,
                        0,
                        rosterPane.getWidth(),
                        rosterPane.getHeight());
        add(rosterPane);
    }
}
