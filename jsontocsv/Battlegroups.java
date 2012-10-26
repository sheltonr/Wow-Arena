package jsontocsv;

public class Battlegroups {

    public static String[] bgs = {
        "bloodlust", "cyclone", "emberstorm", "nightfall",
        "rampage", "reckoning", "retaliation", "ruin",
        "shadowburn", "stormstrike", "vengeance", "vindication",
        "whirlwind"
    };
    
    public String getBg(int i) {
        if(i < 0 || i >= bgs.length)
            return "error";
        return bgs[i];
    }
}