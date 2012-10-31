package wowarenametrics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;

public class DataLoader {
    public String baseurl = "http://us.battle.net/api/wow/pvp/arena/";
    public Battlegroups bg;
    
    public ArrayList<Arenateam> arenateams;
    public ArrayList<Character> characters;
    
    public DataLoader() {
        bg = new Battlegroups();
        arenateams = new ArrayList<Arenateam>();
        characters = new ArrayList<Character>();
    }
    
    /**
     * @param index - Battlegroup index, see Battlegroups.java
     * @param size - The number of arenateams to return
     */
    public void loadDataFromBG(int index, int size) {
        
        String realm = bg.getBg(index);
        String currenturl = baseurl + realm + "/3v3?size=" + size;
        
        try {
            URL url = new URL(currenturl);
            BufferedReader buffreader = new BufferedReader(new InputStreamReader(
                    ((HttpURLConnection) url.openConnection()).getInputStream()));
            
            JsonObject jsonObject = new JsonParser().parse(buffreader).getAsJsonObject();
            
            JsonArray jArray = jsonObject.getAsJsonArray("arenateam");
            for (int i = 0; i < jArray.size(); i++) {
                JsonObject currentObj = jArray.get(i).getAsJsonObject();
                arenateams.add(new Arenateam(currentObj));
                JsonArray memberArray = currentObj.get("members").getAsJsonArray();
                for(int j = 0; j < memberArray.size(); j++) {
                    JsonObject currentMember = memberArray.get(j).getAsJsonObject().get("character").getAsJsonObject();
                    characters.add(new Character(currentMember, currentObj.get("name").getAsString()));
                }
            }
            
            buffreader.close();
        } catch (Exception e) {
            //System.out.println("Error: " + e);
        }
    }
}