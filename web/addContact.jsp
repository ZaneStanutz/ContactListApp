
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <jsp:include page="nav.jsp"/>
    <body>
        <div class="labelImage">
            <h1>Add Contact</h1>
            <p><i>${message}</i></p>
            <form  id="submitContact" action="ContactListServlet" method="post">
                <input type="hidden" name="action" value="add"> 
                <label>Email:</label>
                <input type="email" name="email" value="${contact.email}" required><br>
                <label>First Name:</label>
                <input type="text" name="firstName"  value="${contact.firstName}" required><br>
                <label>Last Name:</label>
                <input type="text" name="lastName"  value="${contact.lastName}" required><br>
                <label>Telephone Number</label>
                <input type="tel" name="phoneNumber" placeholder="(Area code) Number" value="${contact.phoneNumber}" required><br>
                <label>&nbsp;</label>
                <input class="indexButton" type=submit value="Submit" >
                <label>&nbsp;</label>           
            </form>
        </div>
    </body>
        
                
</html>
