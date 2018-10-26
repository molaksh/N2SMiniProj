package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			String message;
			PrintWriter out = response.getWriter();
			int studentId = Integer.parseInt(request.getParameter("studentid")) ;
			
			StudentDetailDAO studentDao = new StudentDetailDAO();
			
			StudentDetail student = new StudentDetail();
			
			student = studentDao.getStudentDetail(studentId);
			
			boolean delete = studentDao.deleteStudenDetail(studentId);
			
			if(delete) {
				System.out.println("entry deleted");
				message = "entry deleted";
				
			}else {
				System.out.println("problem with deleting entry");
				message = "problem with deleting entry, check Student ID";
			}
			
			out.print(message+"<hr>");
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.include(request, response);
			
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
