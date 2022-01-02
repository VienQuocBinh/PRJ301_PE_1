<%-- 
    Document   : ListGroup
    Created on : Jan 2, 2022, 10:06:32 PM
    Author     : LucasBV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Group Page</title>
    </head>
    <body>
        <h1>List Of Group</h1>
        <form action="MainController">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Group Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="group" items="${sessionScope.LIST_GROUP}">
                        <tr>
                            <td>${group.id}</td>
                            <td>${group.name}</td>
                            <td>${group.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <input type="submit" name="action" value="Add Group" formaction="AddGroup.jsp">
            <input type="submit" name="action" value="List Contact">
        </form>
    </body>
</html>
