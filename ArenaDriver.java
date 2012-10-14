import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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



public class ArenaDriver {
	public static void main(String[] args) throws Exception{
		String currenturl = "http://us.battle.net/api/wow/pvp/arena/nightfall/3v3?size=25";
		ArenaTeam currentTeam = new ArenaTeam();
		try {
			URL url = new URL(currenturl);
			BufferedReader r = new BufferedReader(new InputStreamReader(
			    ((HttpURLConnection) url.openConnection()).getInputStream()));
			JsonParser jparse = new JsonParser();
			JsonElement jsonElement =  jparse.parse(r);
			//Turn the element into a json object
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			//whole team
			System.out.println(jsonObject.toString());
			//what the team contains
			System.out.println(jsonObject.get("arenateam"));
			//turn object into array, seperates the teams into 2 different things.
			JsonArray jArray = jsonObject.getAsJsonArray("arenateam");
			for (int i = 0; i < jArray.size();i++) {
				System.out.println("Ranking: " + i +" "+ jArray.get(i));
			}
						
		}catch(Exception e) {
			System.out.println("error" + e);
		}
	}
}

class ArenaTeam {
	String player1 = new String();
	String player2 = new String();
	String player3 = new String();
	String player4 = new String();
	String player5 = new String();
	
	public ArenaTeam () {}
}
