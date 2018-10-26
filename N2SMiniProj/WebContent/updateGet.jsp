<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ page errorPage = "login.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Details</title>
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



<% 
int sID =Integer.parseInt(request.getAttribute("sID").toString());
String sFirstName = request.getAttribute("sFirstName").toString();
String sLastName = request.getAttribute("sLastName").toString();
int sAge = Integer.parseInt(request.getAttribute("sAge").toString());
String sEmail = request.getAttribute("sMail").toString();
String sPhone = request.getAttribute("sPhone").toString();
%>

<table><form action = "UpdateAction" method= "post">
<tr><td></td><td><input type = "hidden" name = "studentid" value = <%= sID %> ></td></tr>
<tr><td>Student ID</td><td><%= sID %></td></tr>
<tr><td>First Name</td><td><input type = "text" name = "firstname" value = <%= sFirstName %> ></td></tr>
<tr><td>Last Name</td><td><input type = "text" name = "lastname" value = <%= sLastName %> ></td></tr>
<tr><td>Age</td><td><input type = "text" name = "age" value = <%= sAge %> ></td></tr>
<tr><td>Phone</td><td><input type = "text" name = "phone" value = <%= sPhone %> ></td></tr>
<tr><td>Email</td><td><input type = "text" name = "email" value = <%= sEmail %> ></td></tr>
<tr><td></td><td><input type = "submit" name = "Update" ></td></tr>
</form>
</table>

</body>
</html>