<%@ page import="javax.jdo.Query" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="wowarenametrics.DBArenateam" %>
<%@ page import="wowarenametrics.DBCharacter" %>

<%@ page import="wowarenametrics.PMF" %>

<html>
    <body>
<%
    PersistenceManager pm = PMF.get().getPersistenceManager();
    
    Query query = pm.newQuery("select from " + DBArenateam.class.getName());
    query.setUnique(false);
    
    List<DBArenateam> dbats = (List<DBArenateam>) query.execute();
    if(dbats.isEmpty()) {
        out.println("No arenateams found.");
    } else {
%>
        <table border="1">
            <tr>
                <td width="170"><b>Realm</b></td>
                <td width="50"><b>Ranking</b></td>
                <td width="50"><b>Rating</b></td>
                <td width="50"><b>Team Size</b></td>
                <td width="170"><b>Name</b></td>
                <td width="70"><b>Games Played</b></td>
                <td width="70"><b>Games Won</b></td>
                <td width="70"><b>Games Lost</b></td>
                <td width="70"><b>Session GP</b></td>
                <td width="70"><b>Session GW</b></td>
                <td width="70"><b>Session GL</b></td>
                <td width="70"><b>Last Session Rank</b></td>
                <td width="70"><b>Side</b></td>
                <td width="70"><b>Current Week Rating</b></td>
            </tr>
<%
        for (DBArenateam dbat : dbats) { 
%>
            <tr>
                <td width="170"><%=dbat.getRealm()%></td>
                <td width="50"><%=dbat.getRanking()%></td>
                <td width="50"><%=dbat.getRating()%></td>
                <td width="50"><%=dbat.getTeamsize()%></td>
                <td width="170"><%=dbat.getName()%></td>
                <td width="70"><%=dbat.getGP()%></td>
                <td width="70"><%=dbat.getGW()%></td>
                <td width="70"><%=dbat.getGL()%></td>
                <td width="70"><%=dbat.getSGP()%></td>
                <td width="70"><%=dbat.getSGW()%></td>
                <td width="70"><%=dbat.getSGL()%></td>
                <td width="70"><%=dbat.getLSR()%></td>
                <td width="70"><%=dbat.getSide()%></td>
                <td width="70"><%=dbat.getCWR()%></td>
            </tr>
<%
        } 
%>
        </table>    
<%
        out.println("\nNumber of arenateams: " + dbats.size());
    }
    
    query = pm.newQuery("select from " + DBCharacter.class.getName());
    query.setUnique(false);
    
    List<DBCharacter> dbcs = (List<DBCharacter>) query.execute();
    if(dbcs.isEmpty()) {
        out.println("No characters found.");
    } else {
%>
        <table border="1">
            <tr>
                <td width="170"><b>Name</b></td>
                <td width="170"><b>Realm</b></td>
                <td width="170"><b>Battlegroup</b></td>
                <td width="100"><b>Class</b></td>
                <td width="100"><b>Race</b></td>
                <td width="70"><b>Gender</b></td>
                <td width="70"><b>Level</b></td>
                <td width="70"><b>Achievement Points</b></td>
                <td width="100"><b>Thumbnail</b></td>
                <td width="100"><b>Guild</b></td>
                <td width="170"><b>Arenateam</b></td>
                
                
                <!--String name, String realm, String battlegroup,
            String classvar, String race, int gender, int level, int achievementPoints,
            String thumbnail, String guild, String arenateam-->
            </tr>
<%
        for (DBCharacter dbc : dbcs) { 
%>
            <tr>
                <td width="170"><%=dbc.getName()%></td>
                <td width="170"><%=dbc.getRealm()%></td>
                <td width="170"><%=dbc.getBG()%></td>
                <td width="100"><%=dbc.getClassvar()%></td>
                <td width="100"><%=dbc.getRace()%></td>
                <td width="70"><%=dbc.getGender()%></td>
                <td width="70"><%=dbc.getLevel()%></td>
                <td width="70"><%=dbc.getAP()%></td>
                <td width="100"><%=dbc.getThumb()%></td>
                <td width="100"><%=dbc.getGuild()%></td>
                <td width="170"><%=dbc.getAT()%></td>
            </tr>
<%
        } 
%>
        </table>

<%
        out.println("\nNumber of characters: " + dbcs.size());
    }
    pm.close();
%>
    </body>
</html>