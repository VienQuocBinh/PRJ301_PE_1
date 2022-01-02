<%-- 
    Document   : error
    Created on : Jan 1, 2022, 11:36:20 PM
    Author     : LucasBV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error: ${sessionScope.ERROR_MESSAGE}</h1>
    </body>
</html>
