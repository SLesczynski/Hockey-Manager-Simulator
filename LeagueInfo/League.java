package LeagueInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class League {
    public static Team[] teamArray = new Team[32];
    public static String[] teamNameArray = new String[32];
    
    Player[] playerArray;

    public League() throws IOException{
        //Setup teams
        for(int i = 0; i != 32 ; i++){
            String tempName;
            try {
                tempName = Files.readAllLines(Paths.get("teams.txt")).get(i);
                teamArray[i] = new Team(tempName);
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
