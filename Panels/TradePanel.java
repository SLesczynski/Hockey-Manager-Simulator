package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import LeagueInfo.League;
import LeagueInfo.Team;
import Simulation.Controller;

public class TradePanel extends JPanel implements ActionListener{
    
    Team yourTeam;
    Team selectedTeam;

    JComboBox<String> selectedManagedTeam;

    JButton backButton;

    public TradePanel(Team managedTeam){

        yourTeam = managedTeam;

        //Setup Panel
        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Border
        setBorder(BorderFactory.createLineBorder(Color.RED, Controller.width/300));

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

        //Your assests
        JTable yourAssests = new JTable();
        updateTable(yourAssests, yourTeam);
        yourAssests.setFont(new Font("Verdana", Font.PLAIN, 17));
        yourAssests.setBounds((int) ((int) this.getWidth() * 0.05),
                                (int) ((int) this.getHeight() * 0.125),
                                (int) ((int) this.getWidth() * 0.3),
                                (int) ((int) this.getHeight() * 0.6));
        add(yourAssests);

        yourAssests.getColumnModel().getColumn(0).setPreferredWidth((int) ((int) yourAssests.getWidth() * 0.65));
        yourAssests.getColumnModel().getColumn(1).setPreferredWidth((int) ((int) yourAssests.getWidth() * 0.1));
        yourAssests.getColumnModel().getColumn(2).setPreferredWidth((int) ((int) yourAssests.getWidth() * 0.15));
        yourAssests.getColumnModel().getColumn(3).setPreferredWidth((int) ((int) yourAssests.getWidth() * 0.1));

        //Select other team.
        selectedManagedTeam = new JComboBox<>(League.teamNameArray);
        selectedManagedTeam.setBounds(this.getWidth()/2, (int) ((int) this.getHeight() * 0.2), this.getWidth()/2, this.getHeight()/2);
        selectedManagedTeam.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(selectedManagedTeam);

        //Show other teams assests.
        JTable theirAssests = new JTable();
        updateTable(theirAssests, yourTeam);
        theirAssests.setFont(new Font("Verdana", Font.PLAIN, 17));
        theirAssests.setBounds((int) ((int) this.getWidth() * 0.05),
                                (int) ((int) this.getHeight() * 0.125),
                                (int) ((int) this.getWidth() * 0.3),
                                (int) ((int) this.getHeight() * 0.6));
        add(theirAssests);
        //Submit trade

        // Go Back
        backButton = new JButton();
        backButton.setBounds((int) ((int) this.getWidth() * 0.05),
                                (int) ((int) this.getHeight() * 0.9),
                                (int) ((int) this.getWidth() * 0.1),
                                (int) ((int) this.getHeight() * 0.05));
        backButton.addActionListener((ActionListener) this);
        backButton.setText("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(backButton);
    }

    public void updateTable(JTable table, Team team){
        String[][] array = new String[team.roster.length][4];
        String[] columnNames = { "Player Name", "Value", "Position", "Age" };
        for(int i = 0; i < array.length; i++){
            array[i][0] = team.roster[i].getName();
            array[i][1] = Integer.toString(team.roster[i].getValue());
            array[i][2] = team.roster[i].getPosition();
            array[i][3] = Integer.toString(team.roster[i].getAge());
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(array, columnNames);
        table = new JTable(model);

        table.getColumnModel().getColumn(0).setPreferredWidth(210);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            try {
                Controller.setManagerView(yourTeam);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
