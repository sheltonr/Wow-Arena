<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>WAM Admin Panel</title>
        <script type="text/javascript" src="/stylesheets/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/niceforms-default.css"/>
    </head>
    <body>
        <div id="container">
            <img src="/images/WAM_logo.png" alt="Wow Arena Metrics Logo" width="622" height="202"></img>
            <form action="/admin" method="post" class="niceform">
                <fieldset>
                    <legend>Admin Panel</legend>
                    <dl>
                        <dt><label for="pass">Password:</label></dt>
                        <dd><input type="password" name="pass" id="pass" size="12" maxlength="20"/></dd>
                    </dl>
                    
                    <dl>
                        <dt><label for="size"># Arenateams:</label></dt>
                        <dd>
                            <input type="text" name="size" id="size" size="2" maxlength="4"/>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="purge">Options:</label></dt>
                        <dd>
                            <input type="checkbox" name="purge" id="purge" value="Yes" />
                            <label for="purge" class="opt">Purge datastore before update</label>
                        </dd>
                    </dl>
                </fieldset>
                <fieldset class="action">
                    <input type="submit" name="submit" id="submit" value="Submit"/>
                </fieldset>
            </form>
            <p id="footer">Wow Arena Metrics<br />Copyright © 2011 Team Terrible</p>
        </div>
    </body>
</html>