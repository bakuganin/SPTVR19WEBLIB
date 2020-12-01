<%-- 
    Document   : listBooks
    Created on : 01.12.2020, 13:05:43
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            li{
                list-style-image: url("/book.png");
            }
            ul{
                padding-left: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Список книг</h1>
        <ul>
            <c:forEach var="book" items="${listBooks}">
                <li>${book.name}. ${book}.author}. ${book.publishedYear}.</li>
            </c:forEach>
        </ul>
    </body>
</html>
