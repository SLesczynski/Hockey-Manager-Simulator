package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import LeagueInfo.League;
import Simulation.Controller;

public class ManagerViewPanel extends JPanel implements ActionListener{

    JButton nextDay;

    JTable teamInformationTable;

    public ManagerViewPanel(){
        

        //Setup Panel
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        setBackground(Color.darkGray);

        //Setup game name text
        JLabel gameName = new JLabel();
        gameName.setText("Hockey Game Simulator");
        gameName.setHorizontalAlignment(JTextField.CENTER);
        gameName.setBounds(0, 10, 1000, 75);
        gameName.setForeground(Color.white);
        gameName.setFont(new Font("Verdana", Font.PLAIN, 75));
        add(gameName);

        //Setup button to simulate a day
        nextDay = new JButton();
        nextDay.setBounds(400, 200, 100, 50);
        nextDay.addActionListener((ActionListener) this);
        nextDay.setText("Single Game");
        add(nextDay);

        teamInformationTable = new JTable();
        updateTable(teamInformationTable);
        teamInformationTable.setBounds(100, 300, 800, 600);
        this.add(teamInformationTable);


    }

    public void updateTable(JTable table){
        String[][] array = new String[32][3];
        String[] columnNames = { "Team", "Wins", "Loses" };
        for(int i = 0; i < 32; i++){
            array[i][0] = League.teamArray[i].getName();
            array[i][1] = Integer.toString(League.teamArray[i].wins);
            array[i][2] = Integer.toString(League.teamArray[i].loses);
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(array, columnNames);
        table = new JTable(model);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Controller.simulateDay();
        updateTable(teamInformationTable);
    }    
}
