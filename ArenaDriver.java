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
		String baseurl = "http://us.battle.net/api/wow/pvp/arena/";
		
		String currentBg = new String();
		int listofItems = 0;
		switch(listofItems) {
		case 0: currentBg = "bloodlust"; break;
		case 1: currentBg = "cyclone"; break;
		case 2: currentBg =  "emberstorm"; break;
		case 3: currentBg = "nightfall"; break;
		case 4: currentBg = "rampage"; break;
		case 5: currentBg = "reckoning"; break;
		case 6: currentBg = "retaliation"; break;
		case 7: currentBg = "ruin"; break;
		case 8: currentBg = "shadowburn"; break;
		case 9: currentBg = "stormstrike"; break;
		case 10: currentBg = "vengeance"; break;
		case 11: currentBg = "vindication"; break;
		case 12: currentBg = "whirlwind"; break;
		default: currentBg = "error"; break;
		}
		String currenturl = baseurl + currentBg + "/3v3?size=5";
		try {
			URL url = new URL(currenturl);
			BufferedReader r = new BufferedReader(new InputStreamReader(
			    ((HttpURLConnection) url.openConnection()).getInputStream()));
			JsonParser jparse = new JsonParser();
			JsonElement jsonElement =  jparse.parse(r);
			
			//Turn the element into a json object
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			
			//Print all information
			//System.out.println(jsonObject.toString());
			
			//what the team contains
			//System.out.println(jsonObject.get("arenateam"));
			
			//turn object into array, seperates the teams into 2 different things.
			JsonArray jArray = jsonObject.getAsJsonArray("arenateam");
			for (int i = 0; i < jArray.size();i++) {
				//System.out.println("Ranking: " + i +" "+ jArray.get(i));
				JsonObject currentObj = jArray.get(i).getAsJsonObject();
				
				//How to access individual variables
				System.out.println("TeamName: " + currentObj.get("name"));
				System.out.println("Rank: " + currentObj.get("ranking"));
				System.out.println("Rating: " + currentObj.get("rating"));
				
				//Get the members
				JsonElement members = currentObj.get("members");
				JsonArray memberArray = members.getAsJsonArray();
				for (int j = 0; j < memberArray.size(); j++) {
					JsonObject currentMember = memberArray.get(j).getAsJsonObject();
					System.out.print("Current Player: " + currentMember.get("character").getAsJsonObject().get("name").toString() + "  "+
						"Spec: " + getClass(currentMember.get("character").getAsJsonObject().get("class").toString()) + "\n");
				}	
			}
							
		}catch(Exception e) {
			System.out.println("error" + e);
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
	
	public static String getClass(String currentClass) {
		String curr = new String();
		switch (Integer.parseInt(currentClass)) {
		case 1:curr = "Warrior"; break;
		case 2:curr = "Paladin"; break;
		case 3:curr = "Hunter"; break;
		case 4:curr = "Rogue"; break;
		case 5:curr = "Priest"; break;
		case 6:curr = "Death Knight"; break;
		case 7: curr = "Shaman"; break;
		case 8:	curr = "Mage"; break;
		case 9:curr = "Warlock"; break;
		case 10:curr = "Monk"; break;
		case 11:curr = "Druid"; break;
		default: curr = "Error"; break;
		}
		return curr;
	
	}
}