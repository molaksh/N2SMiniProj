<%@page import="com.n2s.miniproject.StudentDetail"%>
<%@page import="com.n2s.miniproject.core.StudentDetailDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage = "login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Student Details</title>
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

<table><form  action = "AdminConsoleCreate" method = "post">
<tr><td>Student ID </td><td><input type = "text" name = "studentid" value = ""></td></tr>
<tr><td>First Name </td><td><input type = "text" name = "firstname" value = ""></td></tr>
<tr><td>Last Name </td><td><input type = "text" name = "lastname" value = ""></td></tr>
<tr><td>Age </td><td><input type = "text" name = "age" value = ""></td></tr>
<tr><td>Contact Phone </td><td><input type = "text" name = "phone" value = ""></td></tr>
<tr><td>Contact Email </td><td><input type = "text" name = "email" value = ""></td></tr>
<tr><td></td><td><input name = "Submit" type="submit"/></td></tr>
</form></table>
</body>
</html>