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

import com.n2s.miniproject.AdminLogin;
import com.n2s.miniproject.core.AdminDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		AdminDAO adminDao = new AdminDAO();
		AdminLogin adminLoginCredentials = new AdminLogin(username,password);
		
		boolean validateLogin = adminDao.validateAdminLogin(adminLoginCredentials);
		
		if(validateLogin) {
			
			session.setAttribute("username", username);
			response.sendRedirect("adminConsole.jsp");
		}
		else{
			
			out.println("Check Your Credentials and try again<hr>");
			response.setContentType("text/html");
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			
			//out.print("check your credentials");
		
		}
		
		
	}

}
