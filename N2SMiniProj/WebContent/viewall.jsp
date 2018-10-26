<%@page import="com.n2s.miniproject.StudentDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

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

<table>
<tr><th>Student ID</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Phone</th><th>Email</th></tr>

<%
  List<StudentDetail> allStudentDetail=(List<StudentDetail>) request.getAttribute("allStudentDetail"); 
  for (StudentDetail student: allStudentDetail) {   
%>
  <tr>
    <td><%=student.getID()%></td>
    <td><%=student.getFirstName()%></td>
    <td><%=student.getLastName()%></td>
    <td><%=student.getAge()%></td>
    <td><%=student.getContactPhone()%></td>
    <td><%=student.getContactMail()%></td>
   </tr>
<%}%>
</table>
</body>
</html>