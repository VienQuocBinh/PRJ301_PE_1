<%-- 
    Document   : EditContact
    Created on : Jan 2, 2022, 4:02:27 PM
    Author     : LucasBV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit a Contact</h1>
        <h3>${requestScope.EDIT_ERROR}</h3>
        <form action="MainController" method="POST">
            ID: <input type="text" value="${param.contactID}" disabled=""><br>
            First Name: <input type="text" name="firstName" value="${param.firstName}"><br>
            Last Name: <input type="text" name="lastName" value="${param.lastName}"><br>
            Group: 

            <select name="group">
                <c:forEach var="group" items="${sessionScope.LIST_GROUP}">
                    <option value="${group.id}">${group.name} - ${group.description}</option>
                </c:forEach>
            </select><br>

            Phone Number: <input type="text" name="phone" value="${param.phone}"><br>
            <input type="hidden" name="id" value="${param.contactID}">
            <input type="submit" name="action" value="Edit"><br>
            <input type="submit" name="action" value="Return To Contact List" formaction="ListContactController">
        </form>
    </body>
</html>
