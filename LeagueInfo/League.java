package LeagueInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class League {
    public static Team[] teamArray = new Team[32];
    public static String[] teamNameArray = new String[32];

    public static List<String> firstNames;
    public static List<String> lastNames;
    
    Player[] playerArray;

    public League() throws IOException{
        //Setup Files
        firstNames = Files.readAllLines(Paths.get("FirstNames.txt"));
        lastNames = Files.readAllLines(Paths.get("LastNames.txt"));
        
        //Setup teams
        for(int i = 0; i != 32 ; i++){
            try {
                teamArray[i] = new Team(Files.readAllLines(Paths.get("cities.txt")).get(i), Files.readAllLines(Paths.get("teams.txt")).get(i));
                System.out.println(teamArray[i].name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i != 32 ; i++){
            teamArray[i].makeTeamSchedule();
        }

        for(int i = 0; i < teamArray.length; i++){
            teamNameArray[i] = teamArray[i].name;
        }
    }
}
