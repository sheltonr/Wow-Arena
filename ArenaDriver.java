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
		Battlegroups bg = new Battlegroups();
		
		//Use this to iterate through bgs
		//Appropriate usage: Loop from 0-12 (13 bgs)
		String currentBg = bg.getBg(0);
		
		String currenturl = baseurl + currentBg + "/3v3?size=30";
		try {
			URL url = new URL(currenturl);
			BufferedReader buffreader = new BufferedReader(new InputStreamReader(
			    ((HttpURLConnection) url.openConnection()).getInputStream()));
			JsonParser jparse = new JsonParser();
			JsonElement jsonElement =  jparse.parse(buffreader);
			
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
				JsonElement outerMembers = currentObj.get("members");
				JsonArray memberArray = outerMembers.getAsJsonArray();
				for (int j = 0; j < memberArray.size(); j++) {
					JsonObject currentMember = memberArray.get(j).getAsJsonObject();
					System.out.print("Current Player: " + currentMember.get("character").getAsJsonObject().get("name").toString() + "  "+
						"Class: " + getClass(currentMember.get("character").getAsJsonObject().get("class").getAsInt()) + " Race: "
						+ getRace(currentMember.get("character").getAsJsonObject().get("race").getAsInt()) + "\n");
				}
				System.out.println();
			}				
		}catch(Exception e) {
			System.out.println("error" + e);
		}
	}
	
	/**
	 * Returns classname.
	 * Use with currentMember.get("character").getAsJsonObject().get("class").getAsInt()
	 * @param currentClass
	 * @return
	 */
	public static String getClass(int currentClass) {
		String curr = new String();
		switch (currentClass) {
			case 1:	curr = "Warrior";		break;
			case 2:	curr = "Paladin";		break;
			case 3:	curr = "Hunter";		break;
			case 4:	curr = "Rogue";			break;
			case 5:	curr = "Priest";		break;
			case 6:	curr = "Death Knight";		break;
			case 7: curr = "Shaman";		break;
			case 8:	curr = "Mage";			break;
			case 9:	curr = "Warlock";		break;
			case 10:curr = "Monk";			break;
			case 11:curr = "Druid";			break;
			default:curr = "Error";			break;
		}
		return curr;
	
	}
	
	/**
	 * Returns string with race
	 * Use with currentMember.get("character").getAsJsonObject().get("race").getAsInt()
	 * Racelist from http://us.battle.net/api/wow/data/character/races
	 * @param currentClass
	 * @return
	 */
	public static String getRace(int currentClass) {
		String curr = new String();
		switch (currentClass) {
			case 1:	curr = "Human";		break;
			case 2:	curr = "Orc";		break;
			case 3:	curr = "Dwarf";		break;
			case 4:	curr = "Night Elf";	break;
			case 5:	curr = "Forsaken";	break;
			case 6:	curr = "Tauren";	break;
			case 7: curr = "Gnome";		break;
			case 8:	curr = "Troll";		break;
			case 9:	curr = "Goblin";	break;
			case 10:curr = "Blood Elf";	break;
			case 11:curr = "Draenei";	break; //Female
			case 22:curr = "Worgen";	break;
			case 24:curr = "Pandaren";	break;	//Neutral
			case 25:curr = "Pandaren";	break;	//Alliance
			case 26:curr = "Pandaren";	break;	//Horde
			default:curr = "Error";		break;
		}
		return curr;
	}
}