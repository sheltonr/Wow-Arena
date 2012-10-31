<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Wow Arena Metrics</title>
        <script type="text/javascript" src="/stylesheets/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/niceforms-default.css"/>
    </head>
    <body>
        <div id="container">
            <img src="/images/WAM_logo.png" alt="Wow Arena Metrics Logo" width="622" height="202"></img>
            <form action="/query" method="post" class="niceform">
                <fieldset>
                    <legend>General Info</legend>
                    <dl>
                        <dt><label for="team">Team:</label></dt>
                        <dd><input type="text" name="team" id="team" size="32" maxlength="30"/></dd>
                    </dl>
                    <dl>
                        <dt><label for="realm">Realm:</label></dt>
                        <dd>
                            <select size="1" name="realm" id="realm">
                                <option value="All">All</option>
                                <option value="AeriePeak">Aerie Peak</option>
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="faction">Faction:</label></dt>
                        <dd>
                            <select size="1" name="faction" id="faction">
                                <option value="All">All</option>
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="rating">Rating:</label></dt>
                        <dd>
                            <input type="text" name="rating" id="ratingLo" size="2" maxlength="4"/>
                            <input type="text" name="rating" id="ratingHi" size="2" maxlength="4"/>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="comp">Composition:</label></dt>
                        <dd>
                            <input type="radio" name="comp" id="compAll" value="All" />
                            <label for="compAll" class="opt">Show all team compositions</label>
                            <input type="radio" name="comp" id="compFilter" value="Filter" />
                            <label for="compFilter" class="opt">Filter by team compositions</label>
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