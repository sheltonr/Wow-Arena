package wowarenametrics;

import com.google.appengine.api.datastore.Key;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.KeyFactory.Builder;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DBArenateam {
    
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key; // name + realm

    @Persistent private String realm;
    @Persistent private int ranking;
    @Persistent private int rating;
    @Persistent private int teamsize;
    @Persistent private String name;
    @Persistent private int gamesPlayed;
    @Persistent private int gamesWon;
    @Persistent private int gamesLost;
    @Persistent private int sessionGamesPlayed;
    @Persistent private int sessionGamesWon;
    @Persistent private int sessionGamesLost;
    @Persistent private int lastSessionRanking;
    @Persistent private String side;
    @Persistent private int currentWeekRating;
    
    public DBArenateam(String realm, int ranking, int rating, int teamsize,
            String name, int gamesPlayed, int gamesWon, int gamesLost,
            int sessionGamesPlayed, int sessionGamesWon, int sessionGamesLost,
            int lastSessionRanking, String side, int currentWeekRating) {
        this.realm = realm;
        this.ranking = ranking;
        this.rating = rating;
        this.teamsize = teamsize;
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.sessionGamesPlayed = sessionGamesPlayed;
        this.sessionGamesWon = sessionGamesWon;
        this.sessionGamesLost = sessionGamesLost;
        this.lastSessionRanking = lastSessionRanking;
        this.side = side;
        this.currentWeekRating = currentWeekRating;
        this.key = new Builder(DBArenateam.class.getSimpleName(), name).addChild(
                DBArenateam.class.getSimpleName(), realm).getKey();
    }
    
    
    public String getRealm() {return realm;}
    public int getRanking() {return ranking;}
    public int getRating() {return rating;}
    public int getTeamsize() {return teamsize;}
    public String getName() {return name;}
    public int getGP() {return gamesPlayed;}
    public int getGW() {return gamesWon;}
    public int getGL() {return gamesLost;}
    public int getSGP() {return sessionGamesPlayed;}
    public int getSGW() {return sessionGamesWon;}
    public int getSGL() {return sessionGamesLost;}
    public int getLSR() {return lastSessionRanking;}
    public String getSide() {return side;}
    public int getCWR() {return currentWeekRating;}
}