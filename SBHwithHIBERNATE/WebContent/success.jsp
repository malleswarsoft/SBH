<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
import="com.spark.controller.*,com.spark.vo.*,com.spark.dto.*,com.spark.dao.*,java.util.*"
	isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Result</title>
</head>
<body bgcolor="#E69E19">
	<%
	
	Object obj = request.getAttribute("jbObject");
	System.out.println(obj.getClass());
	SignUpJB sb = (SignUpJB)obj;
	 System.out.println("YOUR NEW ACCOUNT NUMBER IS   " +sb.getAc());
	 out.println("SIGN UP SUCCESSFULLY COMPLETED  ::");
	 out.println("YOUR NEW ACCOUNT NUMBER IS   " +sb.getAc());
 
 %>

</body>
</html>    