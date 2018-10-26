package com.n2s.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			int studentId = Integer.parseInt(request.getParameter("studentid")) ;
			
			StudentDetailDAO studentDao = new StudentDetailDAO();
			
			StudentDetail student = new StudentDetail();
			
			student = studentDao.getStudentDetail(studentId);
			
			String sFirstName = student.getFirstName();
			String sLastName = student.getLastName();
			int sAge = student.getAge();
			String sEmail = student.getContactMail();
			String sPhone = student.getContactPhone();
			
			request.setAttribute("sID", studentId);
			request.setAttribute("sFirstName", sFirstName);
			request.setAttribute("sLastName", sLastName);
			request.setAttribute("sAge", sAge);
			request.setAttribute("sMail", sEmail);
			request.setAttribute("sPhone", sPhone);
			RequestDispatcher rd = request.getRequestDispatcher("updateGet.jsp");
			rd.forward(request, response);
			
			
		}else {
			response.sendRedirect("login.html");
		}
	}

}
