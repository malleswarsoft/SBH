package com.spark.dao.impl;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.spark.dao.model.*;
import com.spark.dto.SignUpJB;
import com.spark.vo.ValuesJB;


public class Operations implements SBHInterface{
	static Connection connectionObject = null;
	static Statement statementObject=null;
	static ResultSet resultSetObject =null;
	static String increment;
	static String username;
	static Operations operationsObject = new Operations();
	static java.util.Properties propertiesObject=null;
	static InputStream inputStreamObject;
	boolean isSuccess;

	
	

  public  void toInsertValues(SignUpJB signUpJBObject){
	  username = signUpJBObject.getUserName();
	  String password = signUpJBObject.getPassword();
	  String firstname = signUpJBObject.getFirstName();
	  String lastname = signUpJBObject.getLastName();
	  String email = signUpJBObject.getEmail();
	  String dob = signUpJBObject.getDob();
	  System.out.println(username);
	  System.out.println(password);
	  System.out.println(firstname);
	  System.out.println(lastname);
	  System.out.println(email);
	  System.out.println(dob);
	 
  }
  public static String getMyAccountNumber(SignUpJB signUpJBObject){
	  String accountno=null;
		
		try {
			username = signUpJBObject.getUserName();
			System.out.println("username is "+username);
			String sqlQuery = "select ac from sbh where username = '"+username+"'";
			statementObject=  operationsObject.getStatement(connectionObject);
			//statementObject = connectionObject.getStatement();
			ResultSet resultSetObject = statementObject.executeQuery(sqlQuery);
			System.out.println("hi this is my acoountnumber  method sql query "+sqlQuery);
			while(resultSetObject.next()){
				accountno = resultSetObject.getString(1);
				System.out.println("resultset object is :"+resultSetObject);
				System.out.println("acno is :"+accountno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionObject.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return accountno;
 
  }
  public  ArrayList toGetResults(){
	  ArrayList arrayListObject = new ArrayList();
	  
      try {
        connectionObject=  operationsObject.getConnection();
		statementObject =operationsObject.getStatement(connectionObject);
		String sqlQuery = "select * from sbh";
	    resultSetObject = statementObject.executeQuery(sqlQuery);
	    while(resultSetObject.next()){
	    	ValuesJB valuesJBObject = new ValuesJB();
	    	
	    	valuesJBObject.setUsername(resultSetObject.getString(1));
	    	valuesJBObject.setPassword(resultSetObject.getString(2));
	    	valuesJBObject.setFirstname(resultSetObject.getString(3));
	    	valuesJBObject.setLastname(resultSetObject.getString(4));
	    	valuesJBObject.setEmail(resultSetObject.getString(5));
	    	valuesJBObject.setDob(resultSetObject.getString(6));
	    	valuesJBObject.setAcno(resultSetObject.getString(1));
	    	arrayListObject.add(valuesJBObject);
	    	
	    }
		  
	} catch (SQLException e) {
		e.printStackTrace();
	}  
      
      try {
		connectionObject.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return arrayListObject;
	  
  }	
  public boolean toLogin(String username,String password){
  
  
	  String sqlQuery = "select * from sbh where username = '"+username+"' and password = '"+password+"'";
  connectionObject = operationsObject.getConnection();
  statementObject = operationsObject.getStatement(connectionObject);
  try {
   resultSetObject = statementObject.executeQuery(sqlQuery);
   System.out.println("sqlQuery"+sqlQuery);
  if(resultSetObject.next()){
	  isSuccess= true;
  }
  else{
	  isSuccess= false;
  }
} catch (SQLException e) {

	e.printStackTrace();
}

return isSuccess;
  }
@Override
public Connection getConnection() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Statement getStatement(Connection connectionObject) {
	// TODO Auto-generated method stub
	return null;
}


}
