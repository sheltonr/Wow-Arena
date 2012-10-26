import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jsontocsv.Battlegroups;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * 
 * 
 * @author Michael Terada
 * 
 * Base reader for wow api
 * Understanding the document format: http://www.json.org/
 * Object (denoted by {}) ArenaTeam contains an array (the []) of values which contains objects {} which contains name:value separated by ,
 * For 1 item, this does not contain children
 *
 */



public class CreateJsonFile {
	public static void main(String[] args) throws Exception{
		String baseurl = "http://us.battle.net/api/wow/pvp/arena/";
		Battlegroups bg = new Battlegroups();
		
		//Use this to iterate through bgs
		//Appropriate usage: Loop from 0-12 (13 bgs)
		for (int i = 0; i < 13; i++) {
			String currentBg = bg.getBg(i);
		
			String currenturl = baseurl + currentBg + "/3v3?size=50";
			try {
				URL url = new URL(currenturl);
				BufferedReader buffreader = new BufferedReader(new InputStreamReader(
				    ((HttpURLConnection) url.openConnection()).getInputStream()));
				String jsonFileName = (currentBg + ".json");
				BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFileName));
				String currentLine = null;
				while ((currentLine = buffreader.readLine()) != null) {
					writer.write(currentLine);
				}
				writer.close();
				buffreader.close();
				
			}catch(Exception e) {
					System.out.println("Error " + e);
			}
		}
	}
}
			