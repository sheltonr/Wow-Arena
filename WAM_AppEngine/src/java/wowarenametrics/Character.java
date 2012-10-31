package wowarenametrics;

import com.google.gson.JsonObject;

public class Character {
    
    public String[] columnNames = {
        "name", "realm", "battlegroup", "class", "race", "gender",
        "level", "achievementPoints", "thumbnail", "guild",
        "arenateam" // This will be null until we fill it later
    };
    
    public String[] columnData = new String[columnNames.length];
    
    public static String[] classes = {
        "Warrior", "Paladin", "Hunter", "Rogue", "Priest",
        "Death Knight", "Shaman", "Mage", "Warlock", "Monk",
        "Druid"
    };
    
    public static String[] races = {
        "Error", "Human", "Orc", "Dwarf", "Night Elf",
        "Forsaken", "Tauren", "Gnome", "Troll", "Goblin",
        "Blood Elf", "Draenei", "Error", "Error", "Error",
        "Error", "Error", "Error", "Error", "Error",
        "Error", "Error", "Worgen", "Error", "Pandaren",
        "Pandaren", "Pandaren"
    };
    
    
    public final String getElement(JsonObject obj, String element) {
        return obj.has(element) ? obj.get(element).getAsString() : "null";
    }
    
    public String getValue(int i) {
        return columnData[i];
    }
    
    public Character(JsonObject obj, String arenateam) {
        for(int i = 0; i < columnNames.length; i++)
            columnData[i] = getElement(obj, columnNames[i]);
        columnData[10] = arenateam;
        columnData[3] = getClass(Integer.parseInt(columnData[3]));
        columnData[4] = getRace(Integer.parseInt(columnData[4]));
    }
    
    public static String getClass(int i) {
        i--;
        if(i < 0 || i >= classes.length)
            return "Error";
        return classes[i];
    }

    public static String getRace(int i) {
        if(i < 0 || i >= races.length)
            return "Error";
        return races[i];
    }
    
    public String getCharString() {
        String ret = "";
        for(int i = 0; i < columnData.length; i++) {
            ret += columnData[i];
            if(i != (columnData.length - 1))
                ret += ",";
        }
        return ret;
    }
}