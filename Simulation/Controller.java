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

    public static int width;
    public static int height;
    static JFrame thisJFrame;
    public Controller(){
        thisJFrame = this;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        
        width = this.getWidth();
        height = this.getHeight();

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

    public static void setManagerView(Team managedTeam) throws IOException{
        thisJFrame.setContentPane(new ManagerViewPanel(managedTeam));
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void simulateDay() throws IOException{
        SeasonSimulation.simulateDay();
    }
}