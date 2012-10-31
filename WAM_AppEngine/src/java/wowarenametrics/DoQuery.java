package wowarenametrics;


import javax.servlet.http.*;

import java.io.IOException;

public class DoQuery extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
        String team = req.getParameter("team");
        String realm = req.getParameter("realm");
        String faction = req.getParameter("faction");
        //int realm = Integer.parseInt(req.getParameter("realm"));
        //int faction = Integer.parseInt(req.getParameter("faction"));
        
        
        resp.sendRedirect("/results.jsp?team=" + team + "&realm=" + realm + "&faction=" + faction);
        
        //if(error > 0) {
            //resp.sendRedirect("/results.jsp");
        //} else {
            //resp.sendRedirect("/validate.jsp?verify=" + req.getParameter("email"));
        //}
    }
}