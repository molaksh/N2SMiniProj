package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.n2s.miniproject.StudentDetail;

public class TestDAO  {

	
	public void createStudentDetail(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean updateStudentDetail(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public StudentDetail getStudentDetail(int studentId) {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
				List<StudentDetail> sList = new ArrayList<>();
				
				
				
				conn = OracleConn.getConn();
				String sqlQuery =  "SELECT * FROM STUDENTDB WHERE STUDENTID = ?";
				preparedStatement = conn.prepareStatement(sqlQuery);
				preparedStatement.setInt(1, studentId);
				resultSet = preparedStatement.executeQuery();
			
				
				while(resultSet.next()) {
				StudentDetail student = new StudentDetail();
				student.setID(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setAge(resultSet.getInt(4));
				student.setContactPhone(resultSet.getString(5));
				student.setContactMail(resultSet.getString(6));
				
				sList.add(student);
				}
				System.out.println(sList.size());
				return sList.get(0);
				
				
				
				
				
			}
			
			catch (Exception e) {
				e.printStackTrace(System.err);
				System.out.println("general exception");
				return null;
			}finally {
				OracleConn.closeResource(conn);
				OracleConn.closeResource(preparedStatement);
				OracleConn.closeResource(resultSet);
				
			}
	}

	
	public boolean deleteStudenDetail(int studentid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
