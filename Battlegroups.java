/**
 * Used almost like an enum, but I'd prefer to have a useable string returned instead of a number or having to do enum.xxxxx
 * @author Home
 *
 */

public class Battlegroups {	
	public String getBg(int current) {
		String currentBg = new String();
		switch(current) {
			case 0: currentBg = "bloodlust";	break;
			case 1: currentBg = "cyclone";		break;
			case 2: currentBg = "emberstorm";	break;
			case 3: currentBg = "nightfall";	break;
			case 4: currentBg = "rampage";		break;
			case 5: currentBg = "reckoning";	break;
			case 6: currentBg = "retaliation";	break;
			case 7: currentBg = "ruin";		break;
			case 8: currentBg = "shadowburn";	break;
			case 9: currentBg = "stormstrike";	break;
			case 10: currentBg = "vengeance";	break;
			case 11: currentBg = "vindication"; 	break;
			case 12: currentBg = "whirlwind";	break;
			default: currentBg = "error";		break;
		}
		return currentBg;
	}
}