package com.spark.dao.model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import com.spark.dto.*;

public interface SBHInterface {
	public Connection getConnection();
	public Statement getStatement(Connection connectionObject);
	public void toInsertValues(SignUpJB signUpJBObject);
	public ArrayList toGetResults();
	public boolean toLogin(String username,String password);

}
