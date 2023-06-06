package Panels;

import Simulation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class MainMenuPanel extends JPanel implements ActionListener{

    JButton startSingleGameButton;
    JButton startCareerButton;

    public MainMenuPanel(){

        setBounds(0, 0, Controller.width, Controller.height);
        setLayout(null);
        setBackground(Color.darkGray);

        //Setup game name text
        JLabel gameName = new JLabel();
        gameName.setText("Hockey Manager Simulator");
        gameName.setHorizontalAlignment(JTextField.CENTER);
        gameName.setBounds(0, 10, this.getWidth(), 75);
        System.out.println(Controller.width);
        System.out.println(Controller.height);
        gameName.setForeground(Color.white);
        gameName.setFont(new Font("Verdana", Font.PLAIN, 75));
        add(gameName);

        //Setup button to switch to Team Selection screen
        startCareerButton = new JButton();
        startCareerButton.setBounds(Controller.width/100, Controller.height/3, Controller.width/2 - Controller.width/100, Controller.height/4);
        startCareerButton.addActionListener((ActionListener) this);
        startCareerButton.setText("New Career");
        add(startCareerButton);

        //Setup button to switch to OneVsOne screen
        startSingleGameButton = new JButton();
        startSingleGameButton.setBounds(Controller.width/2 + Controller.width/100, Controller.height/3, Controller.width/2 - (2 * Controller.width/100), Controller.height/4);
        startSingleGameButton.addActionListener((ActionListener) this);
        startSingleGameButton.setText("Single Game");
        add(startSingleGameButton);

        //Border
        Border border = BorderFactory.createLineBorder(Color.RED, Controller.width/675);
        setBorder(border);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startCareerButton) {
                try {
                    Controller.setSelectManagedTeam();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
        if (e.getSource() == startSingleGameButton) {
            Controller.setSelectTwoTeams();
        }
    }
}
