package Simulation;
import java.io.IOException;

import javax.swing.JFrame;

import LeagueInfo.Team;
import Panels.*;

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
        setUndecorated(true);
        setVisible(true);
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

    public static void setTradePanel(Team managedTeam) {
        thisJFrame.setContentPane(new TradePanel(managedTeam));
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    public static void setRosterPanel(Team managerTeam) {
        thisJFrame.setContentPane(new RosterPanel(managerTeam));
        thisJFrame.invalidate();
        thisJFrame.validate();
    }

    //Should change to list of items, add value, compare, move respective items, return true or false.
    public boolean tryTrade(int valueOne, int valueTwo){
        if(valueOne * 0.9 <= valueTwo && valueOne * 1.1 >= valueTwo){
            return true;
        } else {
            return false;
        }
    }

}