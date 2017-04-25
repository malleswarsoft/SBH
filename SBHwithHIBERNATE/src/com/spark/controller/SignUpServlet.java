package com.spark.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.spark.dto.SignUpJB;
import org.hibernate.cfg.Configuration;
public class SignUpServlet extends HttpServlet {
	
	public void service(HttpServletRequest httpServletRequestObject,HttpServletResponse httpServletResponse){
		SignUpJB signUpJBObject = new SignUpJB();
		signUpJBObject.setUserName(httpServletRequestObject.getParameter("username"));
		signUpJBObject.setPassword(httpServletRequestObject.getParameter("password"));
		signUpJBObject.setFirstName(httpServletRequestObject.getParameter("firstname"));
		signUpJBObject.setLastName(httpServletRequestObject.getParameter("lastname"));
		signUpJBObject.setEmail(httpServletRequestObject.getParameter("email"));
		signUpJBObject.setDob(httpServletRequestObject.getParameter("dob"));
		httpServletRequestObject.setAttribute("jbObject",signUpJBObject);
		System.out.println("problem not here");
		Configuration configurationObject =  new Configuration();
		Session sessionObject  = configurationObject.configure().buildSessionFactory().openSession();
		Transaction transactionObject = sessionObject.beginTransaction();
		sessionObject.save(signUpJBObject);
		transactionObject.commit();
		sessionObject.close();
		System.out.println("object stored");
		
		RequestDispatcher requestDispatcherObject = httpServletRequestObject.getRequestDispatcher("success.jsp");
		
		try {
			requestDispatcherObject.include(httpServletRequestObject, httpServletResponse);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

   
}
