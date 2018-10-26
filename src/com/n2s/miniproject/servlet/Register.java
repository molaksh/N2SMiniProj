package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.n2s.miniproject.AdminRegister;
import com.n2s.miniproject.core.AdminDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		
		AdminRegister newAdmin = new AdminRegister(username, password, confirmPassword, firstName, lastName, address, phone);
		
		AdminDAO adminDao = new AdminDAO();
		
		boolean register = adminDao.registerAdmin(newAdmin);
		
		
		if(register) {
			System.out.println("New Admin Registered");
			
			
			out.println("Thank you for registering "+ username);
		}else {
			System.out.println("Could Not Register New Admin");
			
			
			out.println("Registration Failure, Try changing the username");
		}
		
		
			
	
	}

}
