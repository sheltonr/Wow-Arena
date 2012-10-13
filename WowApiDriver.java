import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WowApiDriver {

	public static String input = "";

	public static void readInput() {
		try {
			URL myUrl = new URL("http://us.battle.net/api/wow/pvp/arena/ruin/2v2?size=3");
			BufferedReader in =  new BufferedReader(new InputStreamReader(myUrl.openStream()));
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				input += inputLine;
				//System.out.println(inputLine);
			}
			in.close();
		} catch(Exception e) {
			//
		}
	}

	public static void newLineTab(int tab) {
		System.out.print("\n");
		for(int i = 0; i < tab*5; i++)
			System.out.print(" ");
	}

	public static void printJSON() {
		char next;
		int tab = 0;
		for(int i = 0; i < input.length(); i++) {
			next = input.charAt(i);
			switch(next) {
				case '{':
				case '[':
					tab++;
					newLineTab(tab);
					break;
				case '\"':
					break;
				case ':':
					System.out.print("  ");
					break;
				case ',':
					newLineTab(tab);
					break;
				case '}':
				case ']':
					tab--;
					break;
				default:
					System.out.print(next);
					break;
			}
		}
	}
	public static void main(String[] args) {
		readInput();
		printJSON();
		System.out.print("\n\n");
	}
}