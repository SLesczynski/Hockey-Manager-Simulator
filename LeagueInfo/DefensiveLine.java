package LeagueInfo;

public class DefensiveLine {

    Skater[] currentSkaters = new Skater[2];

    DefensiveLine(Skater One, Skater Two){
        currentSkaters[0] = One;
        currentSkaters[1] = Two;
    }
}
