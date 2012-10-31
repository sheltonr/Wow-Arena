package wowarenametrics;

import java.io.IOException;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;



public class Admin extends HttpServlet{
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
        if(!req.getParameter("pass").equals("teamterrible3"))
            resp.sendRedirect("/feedback.jsp?msg=0");
        
        
        
        int size = 1;
        try {
            size = Integer.parseInt(req.getParameter("size"));
        } catch (Exception e) {
            resp.sendRedirect("/feedback.jsp?msg=2");
        }
        
        
        
        DataLoader dl = new DataLoader();
        dl.loadDataFromBG(0, size);
        
        
        PersistenceManager pm = PMF.get().getPersistenceManager();
        
        
        if(req.getParameter("purge") != null) {
            if(req.getParameter("purge").equals("Yes")) {
                Query query = pm.newQuery("select from " + DBArenateam.class.getName());
                List<DBArenateam> dbats = (List<DBArenateam>) query.execute();
                if(!dbats.isEmpty())
                    pm.deletePersistentAll(dbats);
                query = pm.newQuery("select from " + DBCharacter.class.getName());
                List<DBCharacter> dbcs = (List<DBCharacter>) query.execute();
                if(!dbcs.isEmpty())
                    pm.deletePersistentAll(dbcs);
            }
        }
        
        
        
        
        
        DBArenateam dbat;
        
        for(Arenateam at : dl.arenateams) {
            dbat = new DBArenateam(
                    at.getValue(0),
                    Integer.parseInt(at.getValue(1)),
                    Integer.parseInt(at.getValue(2)),
                    Integer.parseInt(at.getValue(3)),
                    at.getValue(4),
                    Integer.parseInt(at.getValue(5)),
                    Integer.parseInt(at.getValue(6)),
                    Integer.parseInt(at.getValue(7)),
                    Integer.parseInt(at.getValue(8)),
                    Integer.parseInt(at.getValue(9)),
                    Integer.parseInt(at.getValue(10)),
                    Integer.parseInt(at.getValue(11)),
                    at.getValue(12),
                    Integer.parseInt(at.getValue(13))
                    
                    );
            try {
                pm.makePersistent(dbat);
            } finally {
                //
            }
        }
        
        
        DBCharacter dbc;
        for(Character c : dl.characters) {
            dbc = new DBCharacter(
                    c.getValue(0),
                    c.getValue(1),
                    c.getValue(2),
                    c.getValue(3),
                    c.getValue(4),
                    Integer.parseInt(c.getValue(5)),
                    Integer.parseInt(c.getValue(6)),
                    Integer.parseInt(c.getValue(7)),
                    c.getValue(8),
                    c.getValue(9),
                    c.getValue(10)
                    );
            try {
                pm.makePersistent(dbc);
            } finally {
                //
            }
        }
        
        
        pm.close();
        resp.sendRedirect("/feedback.jsp?msg=1");
        //resp.sendRedirect("/browser.jsp?pass=" + req.getParameter("password")
          //      + "&code=" + req.getParameter("code") + "&view=true");
    }
}