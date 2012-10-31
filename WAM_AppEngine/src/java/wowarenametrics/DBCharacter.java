/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wowarenametrics;


import com.google.appengine.api.datastore.Key;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.KeyFactory.Builder;

@PersistenceCapable(identityType = IdentityType.APPLICATION)


/**
 *
 * @author William
 */



public class DBCharacter {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key; // name + realm
    
    // FOREIGN KEY (arenateam, realm) REFERENCES arenateam(name, realm));

    @Persistent private String name;
    @Persistent private String realm;
    @Persistent private String battlegroup;
    @Persistent private String classvar; //class is a Java keyword!
    @Persistent private String race;
    @Persistent private int gender;
    @Persistent private int level;
    @Persistent private int achievementPoints;
    @Persistent private String thumbnail;
    @Persistent private String guild;
    @Persistent private String arenateam;
    
    public DBCharacter(String name, String realm, String battlegroup,
            String classvar, String race, int gender, int level, int achievementPoints,
            String thumbnail, String guild, String arenateam) {
        this.name = name;
        this.realm = realm;
        this.battlegroup = battlegroup;
        this.classvar = classvar;
        this.race = race;
        this.gender = gender;
        this.level = level;
        this.achievementPoints = achievementPoints;
        this.thumbnail = thumbnail;
        this.guild = guild;
        this.arenateam = arenateam;
        this.key = new Builder(DBCharacter.class.getSimpleName(), name).addChild(
                DBCharacter.class.getSimpleName(), realm).getKey();
    }
    
    
    public String getName() {return name;}
    public String getRealm() {return realm;}
    public String getBG() {return battlegroup;}
    public String getClassvar() {return classvar;}
    public String getRace() {return race;}
    public int getGender() {return gender;}
    public int getLevel() {return level;}
    public int getAP() {return achievementPoints;}
    public String getThumb() {return thumbnail;}
    public String getGuild() {return guild;}
    public String getAT() {return arenateam;}
    
}
