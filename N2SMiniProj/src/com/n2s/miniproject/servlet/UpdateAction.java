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
 * Servlet implementation class UpdateAction
 */
@WebServlet("/UpdateAction")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
					
		if(session != null) {
			PrintWriter out = response.getWriter();
			
			String message = " ";
			boolean update = false;
			
			int studenId = Integer.parseInt(request.getParameter("studentid"));
			String firstname  = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			
			
			StudentDetailDAO studentDetailDao = new StudentDetailDAO();
			
			StudentDetail student = new StudentDetail(studenId, firstname, lastname, age, phone, email);
			
			update = studentDetailDao.updateStudentDetail(student);
			
			
			if(update) {
				
				message = "entry updated";
			}else {
				message = "problem with entry updation, check student id";
			}
			System.out.println(message);
			
			out.print(message+"<hr>");
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			
			rd.include(request, response);
			
			
		}else {
			
			response.sendRedirect("login.html");
		}
	
	}

}
