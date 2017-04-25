<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="org.hibernate.cfg.Configuration.*,com.spark.controller.*,com.spark.vo.*,com.spark.dto.*,com.spark.dao.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrived Results</title>
</head>
<body>
	<%
	Configuration configurationObject =  new Configuration();
	Session sessionObject  = configurationObject.configure().buildSessionFactory().openSession();
	Criteria criteriaObject = sessionObject.createCriteria(SignUpJB.class);
	List listObject = criteriaObject.list();
	Iterator iteratorObject = listObject.iterator();
	while(iteratorObject.hasNext()){
		SignUpJB sb =(SignUpJB)iteratorObject.next();
		request.setAttribute("sbObject", sb);
		System.out.println("values are   "+sb.getUserName()+" "+sb.getPassword());
		out.println("values are   "+sb.getUserName()+" "+sb.getPassword());
		%>
		</br>
		<% 
		}%>

</body>
</html>