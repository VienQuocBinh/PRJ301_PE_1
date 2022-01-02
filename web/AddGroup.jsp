<%-- 
    Document   : AddGroup
    Created on : Jan 2, 2022, 10:37:51 PM
    Author     : LucasBV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Group Page</title>
    </head>
    <body>
        <h1>Add A Group</h1>
        <h3>${sessionScope.ADD_GROUP_ERROR}</h3>
        <form action="MainController" method="POST">
            Name: <input type="text" name="groupName" value="${param.groupName}"><br>
            Description: <input type="text" name="description" ${param.description}><br>
            <input type="hidden" name="action" value="Add Group">
            <input type="submit" value="Add"><br>
            <input type="submit" value="Return To Group List" formaction="ListGroupController">
        </form>
    </body>
</html>
