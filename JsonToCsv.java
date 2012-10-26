package jsontocsv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class JsonToCsv {
    public String baseurl = "http://us.battle.net/api/wow/pvp/arena/";
    public Battlegroups bg;
    
    public ArrayList<Arenateam> arenateams;
    public ArrayList<Character> characters;
    
    public JsonToCsv() {
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
            System.out.println("Error: " + e);
        }
    }
    
    public void printLoadedData() {
        for (Arenateam team : arenateams) {
            System.out.println(team.getTeamString());
        }
        System.out.print("\n");
        for (Character c : characters) {
            System.out.println(c.getCharString());
        }
    }
    
    public void saveArenateamToCSV() {
        try {
            File file = new File(System.getProperty("user.home")
                    + System.getProperty("file.separator") + "arenateam.csv");
            if (!file.exists())
                file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for (Arenateam team : arenateams) {
                bw.write(team.getTeamString());
                bw.newLine();
            }
            bw.close();
            System.out.println("\nArenateam data written to CSV");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void saveCharacterToCSV() {
        try {
            File file = new File(System.getProperty("user.home")
                    + System.getProperty("file.separator") + "character.csv");
            if (!file.exists())
                file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for (Character c : characters) {
                bw.write(c.getCharString());
                bw.newLine();
            }
            bw.close();
            System.out.println("\nCharacter data written to CSV");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    

    public static void main(String[] args) {
        JsonToCsv jtc = new JsonToCsv();
        jtc.loadDataFromBG(0, 3);
        jtc.printLoadedData();
        jtc.saveArenateamToCSV();
        jtc.saveCharacterToCSV();
    }
}