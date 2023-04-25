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
import javax.swing.JTextField;


public class MainMenuPanel extends JPanel implements ActionListener{

    JButton startSingleGameButton;
    JButton startCareerButton;

    public MainMenuPanel(){

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

        //Setup button to switch to Team Selection screen
        startCareerButton = new JButton();
        startCareerButton.setBounds(100, 500, 300, 100);
        startCareerButton.addActionListener((ActionListener) this);
        startCareerButton.setText("New Career");
        add(startCareerButton);

        //Setup button to switch to OneVsOne screen
        startSingleGameButton = new JButton();
        startSingleGameButton.setBounds(600, 500, 300, 100);
        startSingleGameButton.addActionListener((ActionListener) this);
        startSingleGameButton.setText("Single Game");
        add(startSingleGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startCareerButton) {
                try {
                    Controller.setSelectManagedTeam();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
        if (e.getSource() == startSingleGameButton) {
            Controller.setSelectTwoTeams();
        }
    }
}
