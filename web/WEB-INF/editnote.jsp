<%-- 
    Document   : editnote
    Created on : Jun 3, 2021, 4:28:48 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="post" action="note">
            <lable>Title: </lable>
            <input type="text" name="title_input" value="${note.title}">
            <br>
            <lable>Contents: </lable>
            <textarea name="contents_input" cols="40" rows="5">${note.contents}</textarea>
            <br>
            <input type="submit" value="save">
        </form>
    </body>
</html>
