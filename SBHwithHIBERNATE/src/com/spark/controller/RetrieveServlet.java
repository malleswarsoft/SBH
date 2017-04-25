package com.spark.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import com.spark.dto.SignUpJB;

public class RetrieveServlet extends HttpServlet {
	
	
public void service(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
	Configuration configurationObject =  new Configuration();
	Session sessionObject  = configurationObject.configure().buildSessionFactory().openSession();
	Criteria criteriaObject = sessionObject.createCriteria(SignUpJB.class);
	
	List listObject = criteriaObject.list();
	Iterator iteratorObject = listObject.iterator();
	while(iteratorObject.hasNext()){
		SignUpJB sb =(SignUpJB)iteratorObject.next();
		httpServletRequest.setAttribute("sbObject", sb);
		System.out.println("values are   "+sb.getUserName()+" "+sb.getPassword());
	RequestDispatcher requestDispatcherObject = httpServletRequest.getRequestDispatcher("retrieveResults.jsp");
	try {
		requestDispatcherObject.forward(httpServletRequest, httpServletResponse);
	} catch (ServletException |IOException e) {
		
		e.printStackTrace();
	}	} 
}
}
	
