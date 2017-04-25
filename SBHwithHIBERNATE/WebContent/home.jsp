<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home login</title>
</head>
<body>
	<form action="http://localhost:8888/SBHwithHIBERNATE/LoginServlet">
		Enter user name <input type="text" name="username" method=post /><br />
		Enter password <input type="password" name="password" /><br /> <input
			type="submit" value="login" />
		<p>
			<a href="s.jsp">Create a new Account</a>
		</p>

	</form>

</body>
</html>