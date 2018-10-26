<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage = "login.html" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th {
   
    border-collapse: collapse;
}
th,td {
    padding: 15px;
}
</style>
<meta charset="UTF-8">
<title>View Student Details</title>
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

<form action = "View" method = "post">
<table>
<tr><td>Student ID</td><td><input type = "text" name = "studentid" value = "0000"></td><td><input type ="submit" name = "view/viewall" value = "View" ></td><td><input type = "submit" name = "view/viewall" value = "ViewAll" ></td></tr>
</table>
</form><hr>

<% 
int sID =Integer.parseInt(request.getAttribute("studentId").toString());
String sFirstName = request.getAttribute("sFirstName").toString();
String sLastName = request.getAttribute("sLastName").toString();
int sAge = Integer.parseInt(request.getAttribute("sAge").toString());
String sEmail = request.getAttribute("sMail").toString();
String sPhone = request.getAttribute("sPhone").toString();
%>
<table>

<tr><td>Student ID</td><td><%= sID %></td></tr>
<tr><td>First Name</td><td><%= sFirstName %> </td></tr>
<tr><td>Last Name</td><td><%= sLastName %> </td></tr>
<tr><td>Age</td><td> <%= sAge %> </td></tr>
<tr><td>Phone</td><td><%= sPhone %></td></tr>
<tr><td>Email</td><td><%= sEmail %> </td></tr>
</table>


</body>
</html>