import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectTwoTeams extends JPanel implements ActionListener{


    JComboBox<String> homeTeamSelection;
    JComboBox<String> awayTeamSelection;

    JButton startGame;

    SelectTwoTeams(){

        
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        setBackground(Color.darkGray);

        //Home Text
        JLabel homeTeamSelectText = new JLabel();
        homeTeamSelectText.setText("Home Team");
        homeTeamSelectText.setBounds(25, 25, 700, 50);
        homeTeamSelectText.setForeground(Color.white);
        homeTeamSelectText.setFont(new Font("Verdana", Font.PLAIN, 50));
        this.add(homeTeamSelectText);

        //Home Selection
        homeTeamSelection = new JComboBox<>(League.teamNameArray);
        homeTeamSelection.setBounds(25, 100, 400, 50);
        homeTeamSelection.setFont(new Font("Verdana", Font.PLAIN, 25));
        this.add(homeTeamSelection);

        //Away Text
        JLabel awayTeamSelectText = new JLabel();
        awayTeamSelectText.setText("Away Team");
        awayTeamSelectText.setBounds(25, 225, 700, 50);
        awayTeamSelectText.setForeground(Color.white);
        awayTeamSelectText.setFont(new Font("Verdana", Font.PLAIN, 50));
        this.add(awayTeamSelectText);

        //Away Selection
        awayTeamSelection = new JComboBox<>(League.teamNameArray);
        awayTeamSelection.setBounds(25, 300, 400, 50);
        awayTeamSelection.setFont(new Font("Verdana", Font.PLAIN, 25));
        this.add(awayTeamSelection);

        //Setup button to switch to another screen
        startGame = new JButton();
        startGame.setBounds(200, 600, 500, 50);
        startGame.addActionListener((ActionListener) this);
        startGame.setText("Click to Start");
        this.add(startGame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGame) {
        }
    }
}