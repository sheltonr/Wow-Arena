package wowarenametrics;

import com.google.gson.JsonObject;

/**
 * An arenateam schema. Note that because we're only writing out to CSV, where
 * everything is technically a string, we can do the columnData hack that we
 * do. To add/remove attributes, just edit columnNames!
 * @author William
 */
public class Arenateam {
    
    public String[] columnNames = {
        "realm", "ranking", "rating", "teamsize", "name",
        "gamesPlayed", "gamesWon", "gamesLost",
        "sessionGamesPlayed", "sessionGamesWon", "sessionGamesLost",
        "lastSessionRanking", "side", "currentWeekRanking"
    };
    
    public String[] columnData = new String[columnNames.length];

    public final String getElement(JsonObject obj, String element) {
        return obj.has(element) ? obj.get(element).getAsString() : "null";
    }
    
    public Arenateam(JsonObject obj) {
        for(int i = 0; i < columnNames.length; i++)
            columnData[i] = getElement(obj, columnNames[i]);
    }
    
    public String getValue(int i) {
        return columnData[i];
    }
    
    public String getTeamString() {
        String ret = "";
        for(int i = 0; i < columnData.length; i++) {
            ret += columnData[i];
            if(i != (columnData.length - 1))
                ret += ",";
        }
        return ret;
    }
}