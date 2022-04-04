
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <jsp:include page="head.jsp"/>
   <jsp:include page="nav.jsp"/>
    <body>
        <h1>Thanks</h1>
        <p><i>${message}</i></p><br>
        <label>Email:</label>
        <span>${contact.email}</span><br>
        <label>First Name:</label>
        <span>${contact.firstName}</span><br>
        <label>Last Name:</label>
        <span>${contact.lastName}</span><br>
        <label>Telephone Number:</label>
        <span>${contact.phoneNumber}</span><br>
          
            
        <label>&nbsp;</label>
    <body/>
</html>
