import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Races: http://us.battle.net/api/wow/data/character/races
 * @author Home
 *
 */
public class Wowinfo {
	public static void main(String[] args) {
		String baseurl = "http://us.battle.net/api/wow/";
		
		
		String currenturl = baseurl + "data/character/races";
		try {
			URL url = new URL(currenturl);
			BufferedReader buffreader = new BufferedReader(new InputStreamReader(
			    ((HttpURLConnection) url.openConnection()).getInputStream()));
			JsonParser jparse = new JsonParser();
			JsonElement jsonElement =  jparse.parse(buffreader);
			
			//Turn the element into a json object
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			
			//Print all information
			System.out.println(jsonObject.toString());
		}catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
}