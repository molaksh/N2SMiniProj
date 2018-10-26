package com.n2s.miniproject.core;


import com.n2s.miniproject.StudentDetail;

public interface StudentInfo {
	
	public boolean createStudentDetail(StudentDetail studentDetail);
	
	public boolean updateStudentDetail(StudentDetail studentDetail);
	
	public StudentDetail getStudentDetail(int studentId);
	
	public boolean deleteStudenDetail(int studentid);

}
