import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
/**
 * 
 * 
 * @author Michael Terada
 * 
 * Base reader for wow api
 *
 */



public class ArenaDriver {
	public static void main(String[] args) throws Exception{
		String url = "http://us.battle.net/api/wow/pvp/arena/ruin/2v2?size=1";
		try {
			Document document = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
			System.out.println(document.text());
			
		}catch(Exception e) {
			System.out.println("error" + e);
		}
	}
}