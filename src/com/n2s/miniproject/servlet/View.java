package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			int studentId = Integer.parseInt(request.getParameter("studentid"));
			
			String v = request.getParameter("view/viewall");
			//PrintWriter out = response.getWriter();
			
			if(v.equals("View")) {
				
				StudentDetailDAO studentDao = new StudentDetailDAO();
				
				StudentDetail student = new StudentDetail();
				
				student = studentDao.getStudentDetail(studentId);
				
				String sFirstName = student.getFirstName();
				String sLastName = student.getLastName();
				int sAge = student.getAge();
				String sEmail = student.getContactMail();
				String sPhone = student.getContactPhone();
				
				request.setAttribute("studentId", studentId);
				request.setAttribute("sFirstName", sFirstName);
				request.setAttribute("sLastName", sLastName);
				request.setAttribute("sAge", sAge);
				request.setAttribute("sMail", sEmail);
				request.setAttribute("sPhone", sPhone);				
				RequestDispatcher rs = request.getRequestDispatcher("viewone.jsp");
				rs.forward(request, response);
				
			}
			else if (v.equals("ViewAll")) {
				
				StudentDetailDAO studentDao = new StudentDetailDAO();
				
				
				List<StudentDetail> allStudentDetail = new ArrayList<>();
				
				allStudentDetail = studentDao.getAllStudentDetail();
				
				request.setAttribute("allStudentDetail", allStudentDetail);
				RequestDispatcher rs = request.getRequestDispatcher("viewall.jsp");
				rs.forward(request, response);
			}
		}
		else {
			response.sendRedirect("login.html");
		}
	}

}
