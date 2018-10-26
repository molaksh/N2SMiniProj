package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.n2s.miniproject.AdminException;
import com.n2s.miniproject.AdminLogin;
import com.n2s.miniproject.AdminRegister;

public class AdminDAO {
	
	public void printsomething(String a) {
		System.out.println("something" + a);
	}
	
	public boolean validateAdminLogin(AdminLogin adminLogin)  {
		
		String dbPasswd ;
		String givenPasswd;
		
		Connection conn = OracleConn.getConn();
		PreparedStatement prepstmt = null;
		ResultSet resultSet = null;
		
		List<AdminLogin> aList = new ArrayList<>();
		AdminLogin a = new AdminLogin();
		
		String sqlQuery = "SELECT * FROM STUDENTADMINDB WHERE USERNAME = ?";
		
		try {
			
			prepstmt = conn.prepareStatement(sqlQuery);
			prepstmt.setString(1, adminLogin.getUserName());
			
			resultSet = prepstmt.executeQuery();
			
			//System.out.println("break");
			while(resultSet.next()) {
				AdminLogin admin = new AdminLogin();
				admin.setPassword(resultSet.getString(2));
				aList.add(admin);
				
			}
			
			a = aList.get(0);
			dbPasswd = a.getPassword();
			givenPasswd = adminLogin.getPassword();
			
			
			if(dbPasswd.equals(givenPasswd)) {
				return true;
			}else {return false;}
			
		} catch (Exception e) {
			
			try {
				throw new AdminException();
			} catch (AdminException e1) {	
				e1.printStackTrace();
				return false;
			}
			
		}
		
		
	}
	
	public boolean registerAdmin(AdminRegister adminRegister) {
		
		Connection conn = null;
		PreparedStatement prepstmt = null;
		
		String sqlquery = "INSERT INTO STUDENTADMINDB VALUES (?,?,?,?,?,?)";
		
		try {
			
			conn = OracleConn.getConn();
			prepstmt = conn.prepareStatement(sqlquery);
			prepstmt.setString(1, adminRegister.getUsername());
			prepstmt.setString(2, adminRegister.getPassword());
			prepstmt.setString(3, adminRegister.getFirstName());
			prepstmt.setString(4, adminRegister.getLastName());
			prepstmt.setString(5, adminRegister.getAddress());
			prepstmt.setString(6, adminRegister.getPhone());
			
			prepstmt.executeQuery();
			
			conn.commit();
			return true;
			
		} catch (Exception e) {
			
			
			try {
				throw new AdminException();
			} catch (AdminException e1) {
				e1.printStackTrace();
			}
			
			return false;
			
		}
		
		
		
		
	}

}
