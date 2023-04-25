import java.io.IOException;

import LeagueInfo.League;
import Simulation.Controller;

/**
 * Launcher
 */
public class Launcher {
    public static void main(String[] args) throws IOException {

        new League();
        new Controller();
    }
    
}