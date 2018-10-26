package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.StudentDetailException;


public class StudentDetailDAO implements StudentInfo{
	
	
	Connection conn = null;
	PreparedStatement prepStmt = null;
	ResultSet resultSet = null;
	
	
	@Override
	public boolean createStudentDetail(StudentDetail studentDetail) {
		try {
			
			String sqlQuery =  "INSERT INTO STUDENTDB VALUES (?,?,?,?,?,?)";
			
			conn = OracleConn.getConn();
			
			prepStmt = conn.prepareStatement(sqlQuery);
			prepStmt.setInt(1, studentDetail.getID());
			prepStmt.setString(2, studentDetail.getFirstName());
			prepStmt.setString(3, studentDetail.getLastName());
			prepStmt.setInt(4, studentDetail.getAge());
			prepStmt.setString(5, studentDetail.getContactPhone());
			prepStmt.setString(6, studentDetail.getContactMail());
			
			resultSet = prepStmt.executeQuery();
			
			conn.commit();
			return true;
			
		}
		catch (Exception e) {
			
			try {
				throw new StudentDetailException();
			} catch (StudentDetailException e1) {
				e1.printStackTrace();
			}
			
			return false;
			
		}finally {
			OracleConn.closeResource(conn);
			OracleConn.closeResource(prepStmt);
			OracleConn.closeResource(resultSet);
			
		}
		
	}

	@Override
	public boolean updateStudentDetail(StudentDetail studentDetail) {
		
			try {
					
					String sqlQuery =  "UPDATE STUDENTDB SET FIRSTNAME = ?, LASTNAME = ?, AGE = ?, PHONE = ?,EMAIL = ?"
							+ "WHERE STUDENTID = ?" ;
					
					conn = OracleConn.getConn();
					prepStmt = conn.prepareStatement(sqlQuery);
					prepStmt.setString(1, studentDetail.getFirstName());
					prepStmt.setString(2, studentDetail.getLastName());
					prepStmt.setInt(3, studentDetail.getAge());
					prepStmt.setString(4, studentDetail.getContactPhone());
					prepStmt.setString(5, studentDetail.getContactMail());
					prepStmt.setInt(6, studentDetail.getID());
					
					resultSet = prepStmt.executeQuery();
					
					conn.commit();
					return true;
					
				}catch (Exception e) {
					
					try {
						throw new StudentDetailException();
					} catch (StudentDetailException e1) {
						e1.printStackTrace();
					}
					return false;
					
				}finally {
					OracleConn.closeResource(conn);
					OracleConn.closeResource(prepStmt);
					OracleConn.closeResource(resultSet);
					
				}
		
		
	}

	@Override
	public StudentDetail getStudentDetail(int studentId) {
		

		try {
				
				List<StudentDetail> sList = new ArrayList<>();
			
				String sqlQuery =  "SELECT * FROM STUDENTDB WHERE STUDENTID = ?";
				
				
				
				conn = OracleConn.getConn();
				prepStmt = conn.prepareStatement(sqlQuery);
				prepStmt.setInt(1, studentId);
				resultSet = prepStmt.executeQuery();
				
				
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
				
			}catch (Exception e) {
				
				try {
					throw new StudentDetailException();
				} catch (StudentDetailException e1) {
					e1.printStackTrace();
				}return null;
				
			}finally {
				OracleConn.closeResource(conn);
				OracleConn.closeResource(prepStmt);
				OracleConn.closeResource(resultSet);
				
			}
		
		
		
	}

	@Override
	public boolean deleteStudenDetail(int studentid) {
		try {
		String sqlQuery =  "DELETE FROM STUDENTDB WHERE STUDENTID = ?" ;
		
		
		conn = OracleConn.getConn();
		prepStmt = conn.prepareStatement(sqlQuery);
		prepStmt.setInt(1, studentid);
		resultSet = prepStmt.executeQuery();
		
		conn.commit();
		
		return true;
		
	}catch (Exception e) {
		
		try {
			throw new StudentDetailException();
		} catch (StudentDetailException e1) {
			e1.printStackTrace();
		}
		return false;
		
	}finally {
		OracleConn.closeResource(conn);
		OracleConn.closeResource(prepStmt);
		OracleConn.closeResource(resultSet);
		
	}
		
	}
	
	public List<StudentDetail> getAllStudentDetail() {
		
		List<StudentDetail> allStudentDetail = new ArrayList<>();
		
		String sqlQuery = "SELECT * FROM STUDENTDB ORDER BY CAST(STUDENTID AS INT)";
		
		try {
			
			conn = OracleConn.getConn();
			prepStmt = conn.prepareStatement(sqlQuery);
			resultSet = prepStmt.executeQuery();
			
			
			while(resultSet.next()) {
				StudentDetail student = new StudentDetail();
				student.setID(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setAge(resultSet.getInt(4));
				student.setContactPhone(resultSet.getString(5));
				student.setContactMail(resultSet.getString(6));
				
				allStudentDetail.add(student);
			}
			
			
			return allStudentDetail;
			
			
		} catch (Exception e) {
			return null;
		}
		finally {
			OracleConn.closeResource(conn);
			OracleConn.closeResource(prepStmt);
			OracleConn.closeResource(resultSet);
		}
		
	}

}
