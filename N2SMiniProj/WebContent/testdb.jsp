<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage = "login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

test jdbc connection...

<%
Connection Conn = null;

try{
	String url = "jdbc:oracle:thin:@localhost:1521:orcl12c";
	String username = "system";
	String password = "oracle";
	
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,username,password);
		if(conn!=null) {System.out.println("connected");}
		
		
		
	} catch (Exception e) {
		System.out.println("connection failure...");
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
	
}
catch(Exception e){
	e.getMessage();
}

%>

</body>
</html>