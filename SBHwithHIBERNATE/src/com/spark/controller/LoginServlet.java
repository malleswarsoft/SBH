package com.spark.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.spark.dto.SignUpJB;


public class LoginServlet extends HttpServlet {
	static RequestDispatcher requestDispatcherObject;
	public static boolean isSuccess;
	static String username;
	public String password1;
	public void service(HttpServletRequest request,HttpServletResponse response){
		username = request.getParameter("username");
		password1 = request.getParameter("password");
		System.out.println("username&password"+username+password1);
		//int passd = Integer.parseInt(password);
		
		System.out.println(username);
		System.out.println(password1);
		Configuration configurationObject =  new Configuration();
		Session sessionObject  = configurationObject.configure().buildSessionFactory().openSession();
		Criteria criteriaObject = sessionObject.createCriteria(SignUpJB.class);
		//Criterion criterionObject = Restrictions.like("password", password1);
		System.out.println("before criteria query");
		criteriaObject.add(Restrictions.and(Restrictions.like("userName",username),Restrictions.eq("password", password1)));
		//criteriaObject.add(criterionObject);
		
		//criteriaObject.add(Restrictions.or(Restrictions.like("userName","%username%"),Restrictions.eq("password", passd)));
		System.out.println("after criteria query");
		List list = criteriaObject.list();
		System.out.println("list object"+list);
		Iterator iterator = list.iterator();
		if(iterator.hasNext())
		{
			SignUpJB sb =(SignUpJB)iterator.next();
			/*System.out.println("Username is  "+sb.getUserName());
			System.out.println("Passwrod  is "+sb.getPassword());
			System.out.println("class name is "+sb.getClass()); */
			
			
				String u = sb.getUserName();
				String p = sb.getPassword();
				System.out.println("user name is "+username+password1);
				System.out.println("u,p "+u+p);
				
				if(u.equals(username)&&p.equals(password1)){ 
					
				requestDispatcherObject = request.getRequestDispatcher("loginSuccess.jsp");  
					try {
						requestDispatcherObject.forward(request, response);
					} catch (ServletException |IOException e) {
						e.printStackTrace();
					} 
								 
				}
				
		}
			   else{
				requestDispatcherObject = request.getRequestDispatcher("loginfail.jsp");
				try {
					requestDispatcherObject.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}  
		
	}

	}