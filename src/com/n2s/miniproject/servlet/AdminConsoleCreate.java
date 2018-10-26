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
 * Servlet implementation class AdminConsoleCreate
 */
@WebServlet("/AdminConsoleCreate")
public class AdminConsoleCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConsoleCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			PrintWriter out = response.getWriter();
			
			String message = " ";
			boolean newentry = false;
			
			int studenId = Integer.parseInt(request.getParameter("studentid"));
			String firstname  = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			StudentDetailDAO studentDetailDao = new StudentDetailDAO();
			
			StudentDetail student = new StudentDetail(studenId, firstname, lastname, age, phone, email);
			
			newentry = studentDetailDao.createStudentDetail(student);
			
			if(newentry) {
				
				message = "new entry updated<hr>";
			}else {
				message ="Student ID "+ Integer.toString(studenId) + " is already on record, try new Student ID<hr>";
			}
			System.out.println(message);
			
			out.println(message);
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
			
			rd.include(request, response);
			
			
		}else {
			
			response.sendRedirect("login.html");
		}
	
		
		
		//request.getRequestDispatcher("/postcreate.jsp").forward(request, response);
		
	}

}
