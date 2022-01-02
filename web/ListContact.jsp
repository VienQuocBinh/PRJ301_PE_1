<%-- 
    Document   : ListContact
    Created on : Jan 1, 2022, 11:02:39 PM
    Author     : LucasBV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Contact Page</title>
    </head>
    <body>
        <h1>List Of Contacts</h1>
        <p>There are ${sessionScope.NUMBER_OF_CONTACT} contact(s) in the list</p>
        <form action="MainController">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Group</th>
                        <th>Phone Number</th>
                        <th>Operation</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contact" items="${sessionScope.LIST_CONTACT}">
                        <tr>
                            <td>${contact.id}</td>
                            <td>${contact.firstName}</td>
                            <td>${contact.lastName}</td>
                            <td>
                                <c:forEach var="group" items="${sessionScope.LIST_GROUP}">
                                    <c:if test="${group.id == contact.groupID}">
                                        ${group.name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${contact.phoneNumber}</td>
                            <td>
                                <a href="<c:url value="EditContact.jsp">
                                       <c:param name="contactID" value="${contact.id}"></c:param>
                                       <c:param name="firstName" value="${contact.firstName}"></c:param>
                                       <c:param name="lastName" value="${contact.lastName}"></c:param>
                                       <c:param name="phone" value="${contact.phoneNumber}"></c:param>
                                       <c:param name="groupID" value="${contact.groupID}"></c:param>
                                   </c:url>">Edit</a>

                                <a href="<c:url value="MainController">
                                       <c:param name="contactID" value="${contact.id}"></c:param>
                                       <c:param name="action" value="RemoveContact"></c:param>
                                   </c:url>">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <input type="submit" value="Add Contact" formaction="AddContact.jsp">
            <input type="submit" name="action" value="List Group">
        </form>
    </body>
</html>
