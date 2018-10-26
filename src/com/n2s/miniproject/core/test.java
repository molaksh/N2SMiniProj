package com.n2s.miniproject.core;

import com.n2s.miniproject.StudentDetail;

public class test {
	
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();
		StudentDetail student = dao.getStudentDetail(1);
		System.out.println(student);
		
	}

}
