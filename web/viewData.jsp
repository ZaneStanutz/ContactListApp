
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
    </head>
    <jsp:include page="nav.jsp"/>
    <body>
        <div class="labelImage">
            <h4>Keyword Search</h4>
            <form action="ContactListServlet" method="post">
                <input type="hidden" name="action" value="searchName">
                <input type="text"   name="search" value ="${searchTerm}">
                <input class="bodyButton" type="submit" value="Search">
            </form>
        </div>
        <div class="labelImage">
            <div class="labelForm">
            <h4>Delete Contact by Email</h4>
            <form action="ContactListServlet" method="post">
                <input type="hidden" name="action" value="deleteContact">
                <label>Email:</label>
                <input type="email" name="removeContact" placeholder="notMyFriend@deleted.ca" value="${removeContact}">
                <input class="bodyButton" type="submit" value="Delete Contact">
            </form>
            <p><i>${deleteStatus}</i></p>
            </div>
        </div>
            
        <div id="labelImage">
            <div id="labelForm">
                <form action="ContactListServlet" method="post">
                    <input type="hidden" name="action" value="showAll">
                    <input class="indexButton" type="submit" value="View">   
                </form>
            </div>
        </div>    
        <i>${noData}</i>
        ${allData}
    
 
    </body>
</html>
