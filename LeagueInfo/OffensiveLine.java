package LeagueInfo;

public class OffensiveLine {

    Skater[] currentSkaters = new Skater[3];

    OffensiveLine(Skater One, Skater Two, Skater Three){
        currentSkaters[0] = One;
        currentSkaters[1] = Two;
        currentSkaters[2] = Three;
    }
}
