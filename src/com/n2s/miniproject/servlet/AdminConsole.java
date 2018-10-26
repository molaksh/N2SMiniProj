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

/**
 * Servlet implementation class AdminConsole
 */
@WebServlet("/AdminConsole")
public class AdminConsole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConsole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			String value = request.getParameter("action");
			PrintWriter out = response.getWriter();
			
			if(value.equals("create")) {
				
				RequestDispatcher rs = request.getRequestDispatcher("create.jsp");
				rs.forward(request, response);
				
			}
			else if (value.equals("update")) {
				
				RequestDispatcher rs = request.getRequestDispatcher("update.jsp");
				rs.forward(request, response);
			}
			else if (value.equals("view") ) {
				
				RequestDispatcher rs = request.getRequestDispatcher("view.jsp");
				rs.forward(request, response);
			}
			else if(value.equals("delete") ) {
				RequestDispatcher rs = request.getRequestDispatcher("delete.jsp");
				rs.forward(request, response);
			}
			else if (value.equals("logout")) {
				session.invalidate();
				out.println("<html><body> You have been logged out !! <br><a href=\"login.html\" >Login again</a></body></html>");
			}
		}
		else {
			response.sendRedirect("login.html");
		}
		
	}

}
