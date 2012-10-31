package wowarenametrics;

import java.io.IOException;
import javax.servlet.http.*;

/**
 * A rather stupid class that does nothing except redirect to the main sign-up
 * page. Used to avoid difficulties with form submission when hitting a
 * "return to main"-type button.
 * 
 * @author William
 */

public class PageRedirect extends HttpServlet{    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
        if(req.getParameter("page").equals("0")) {
            resp.sendRedirect("/admin.jsp");
        } else if(req.getParameter("page").equals("1")) {
            resp.sendRedirect("/viewer.jsp");
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }
}