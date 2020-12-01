<%-- 
    Document   : index
    Created on : 24.11.2020, 14:32:31
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная</title>
    </head>
    <body>
        <h1> [ Библиотека ] </h1>
        <p>${info}</p>
        <a href="addBook"> Добавить новую книгу </a>
        <a href="createReader"> Добавить читателя </a>
        <a href="listReader"> Список книг </a>
    </body>
</html>
