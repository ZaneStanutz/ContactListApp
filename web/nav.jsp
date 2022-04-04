
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="header">
    <div id="headerImage">
        </div>
    
    <div id= "navButtons">
        <form action="ContactListServlet" method="get">
            <input type="hidden" name="action" value="add">
            <label>&nbsp;</label>
            <input class="indexButton" type="submit" value="Add Contact">
        </form>    
        <form action="ContactListServlet" method="get">
            <input type="hidden" name="action" value="view">
            <label>&nbsp;</label>
            <input class="indexButton" type="submit" value="View Contacts">
        </form>
    </div>
</div>