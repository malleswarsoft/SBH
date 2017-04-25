<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginfailure</title>
</head>
<body>
	<%
System.out.println("Sorry Invalid username or passwrd");
System.out.println("please enter valid username and password");
out.println("Sorry Invalid username or passwrd");
out.println("please enter valid username and password");
 %>
	<form action="http://localhost:8888/OnlineSBH/LoginServlet">
		Enter user name <input type="text" name="username" method=post /><br />
		Enter password <input type="password" name="password" /><br /> <input
			type="submit" value="login" />
		<p>
			<a href="http://localhost:8888/OnlineSBH/signUp.jsp">Create a
				newAccount</a>
		</p>
	</form>
</body>
</html>