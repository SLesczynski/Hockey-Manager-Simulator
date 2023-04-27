package Simulation;
import java.io.IOException;

import javax.swing.JFrame;

import LeagueInfo.Team;
import Panels.*;
import Panels.SelectTwoTeams;

/**
 * Controller
 */
public class Controller extends JFrame{
    static JFrame thisJFrame;
    public Controller(){
        thisJFrame = this;
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        setContentPane(new MainMenuPanel());
        validate();
    }

    public static void setSelectTwoTeams(){
        thisJFrame.setContentPane(new SelectTwoTeams());
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void setOneVsOne(Team homeTeam, Team awayTeam) throws IOException{
        thisJFrame.setContentPane(new OneVsOnePanel(homeTeam, awayTeam));
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void setSelectManagedTeam() throws IOException{
        thisJFrame.setContentPane(new SelectManagedTeam());
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void setManagerView() throws IOException{
        thisJFrame.setContentPane(new ManagerViewPanel());
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void simulateDay() throws IOException{
        SeasonSimulation.simulateDay();
    }
}