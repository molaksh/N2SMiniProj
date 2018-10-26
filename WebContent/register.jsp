<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage = "login.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="Register" method="post">  
User name:<input type="text" name="username"/><br/>
Password:<input type="password" name="password"/><br/>
Confirm Password:<input type="text" name="confirmpassword"/><br/>
First Name:<input type="text" name="firstName"/><br/>
Last Name:<input type="text" name="lastName"/><br/>
Address:<input type="text" name="address"/><br/>
Phone:<input type="text" name="phone"/><br/>

<input type="submit" value="register"/>
</form>
</body>
</html>