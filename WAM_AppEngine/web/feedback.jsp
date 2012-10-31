<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>WAM Feedback</title>
        <script type="text/javascript" src="/stylesheets/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/niceforms-default.css"/>
        <script language="JavaScript" type="text/javascript">
function getParams() {
    var idx = document.URL.indexOf('?');
    if (idx != -1) {
        var tempParams = new Object();
        var pairs = document.URL.substring(idx+1,document.URL.length).split('&');
        for (var i=0; i<pairs.length; i++) {
            nameVal = pairs[i].split('=');
            tempParams[nameVal[0]] = nameVal[1];
        }
    return tempParams;
    }
}
var params = getParams();
        </script> 
    </head>
    <body>
        <div id="container">
            <img src="/images/WAM_logo.png" alt="Wow Arena Metrics Logo" width="622" height="202"></img>
            <form name="form1" action="/pagered" method="post" class="niceform">
                <fieldset>
                    <legend>Wow Arena Metrics says:</legend>
<% 
    if(request.getParameter("msg") != null) {
        if(request.getParameter("msg").equals("0")) {
%>
                    <p>Not a valid password.</p>
<%
        } else if(request.getParameter("msg").equals("1")) {
%>
                    <p>Success! Press OK to view the full datastore.</p>
<%
        } else if(request.getParameter("msg").equals("2")) {
%>
                    <p>Error parsing size input. Don't you know what a number is?</p>
<%
        }
    }
%>
                </fieldset>
                <fieldset class="action">
                    <input type="hidden" name="page"/>
                    <input type="submit" name="submit" id="submit" value="OK"/>
                </fieldset>
            </form>
                <script language="JavaScript" type="text/javascript">
pvMsg = unescape(params["msg"]);
if(pvMsg) document.form1.page.value = pvMsg;
                </script>
            <p id="footer">Wow Arena Metrics<br />Copyright © 2011 Team Terrible</p>
        </div>
    </body>
</html>