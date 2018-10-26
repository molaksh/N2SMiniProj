package com.n2s.miniproject.core;

import com.n2s.miniproject.AdminLogin;
import com.n2s.miniproject.AdminRegister;

public class AdminInfoImpl {
	public static void main(String[] args) {

		
		
		AdminDAO adminDao = new AdminDAO();
		
		//password check
		AdminLogin admin = new AdminLogin("mohan","mohan");
		boolean boo = adminDao.validateAdminLogin(admin);		
		System.out.println(boo);
		
		//register admin
//		AdminRegister newAdmin = new AdminRegister("admin","admin","admin","firstname","lastname","address","phone");
//		boolean boo = adminDao.registerAdmin(newAdmin);
//		System.out.println(boo);
		
		
	}

	
	
	
}
