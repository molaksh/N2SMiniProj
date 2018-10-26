<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage = "login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student Details</title>
</head>
<% String username = session.getAttribute("username").toString(); %> 
<%= "Hi "+username %><hr>


<body>
<form action="AdminConsole" method="post">
<input name = "action" type="submit" value="create"/>
<input name = "action" type="submit" value="update"/>
<input name = "action" type="submit" value="view"/>
<input name = "action" type="submit" value="delete"/>
<input name = "action" type="submit" value="logout"/><hr>
</form>

<form action = "Delete" method = post>
<table>
<tr><td>Student ID</td><td><input type = "text" name = "studentid" value = ""></td><td><input type ="submit"></td></tr>
</table>
</form>


</body>
</html>