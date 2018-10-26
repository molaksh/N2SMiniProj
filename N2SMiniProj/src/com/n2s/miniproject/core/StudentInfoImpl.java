package com.n2s.miniproject.core;

import com.n2s.miniproject.StudentDetail;

public class StudentInfoImpl {
	public static void main(String[] args) {
		StudentDetailDAO dao = new StudentDetailDAO();
		
		//inseting new student details
//		StudentDetail student = new StudentDetail(233,"oifhjco","dsohfdsf",21,"23424", "doi@dfns.com");
//		dao.createStudentDetail(student);
		
		
		
//		//get detail given studentid
//		StudentDetail s = dao.getStudentDetail(1);
//		
//		System.out.println(s);
		
		
//		//updating student details		
//		StudentDetail student = new StudentDetail(233,"updated","details",21,"23424", "updated@dfns.com");
//		dao.updateStudentDetail(student);
		
		//Deleting student details
		dao.deleteStudenDetail(233);
		
	}

}
