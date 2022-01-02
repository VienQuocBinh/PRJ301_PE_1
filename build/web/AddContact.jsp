<%-- 
    Document   : AddContact
    Created on : Jan 1, 2022, 10:53:04 PM
    Author     : LucasBV
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.FriendGroupDAO"%>
<%@page import="obj.FriendGroup"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Contact Page</title>
    </head>
    <body>
        <h1>Add a Contact</h1>
        <h3>${sessionScope.ADD_CONTACT_ERROR}</h3>
        <form action="MainController" method="POST">

            First name: <input type="text" name="firstName" value="${param.firstName}"><br>
            Last name: <input type="text" name="lastName" value="${param.lastName}"><br>
            Group: 
            <select name="group">
                <%
                    FriendGroupDAO fgDao = new FriendGroupDAO();
                    ArrayList<FriendGroup> listGroup = fgDao.getListFriendGroup();
                %>

                <% for (FriendGroup friendGroup : listGroup) {
                %>
                <option value="<%= friendGroup.getId()%>"><%= friendGroup.getName() + " - " + friendGroup.getDescription()%></option>
                <%
                    }
                %>


            </select><br>
            Phone Number: <input type="text" name="phoneNumber" value="${param.phoneNumber}"><br>
            <input type="submit" name="action" value="Add"><br>
            <input type="submit" value="Return To Contact List" formaction="ListContactController">
        </form>

    </body>
</html>
