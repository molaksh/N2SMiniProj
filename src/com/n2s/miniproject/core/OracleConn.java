package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.DriverManager;


public class OracleConn {
		public static Connection getConn() {
				
				String url = "jdbc:oracle:thin:@localhost:1521:orcl12c";
				String username = "system";
				String password = "oracle";
				
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url,username,password);
					if(conn!=null) {System.out.println("connected");}
					return conn;
					
					
				} catch (Exception e) {
					System.out.println("connection failure...");
					System.out.println(e.getMessage());
					return null;
				}
				 
			}
			
			public static void closeResource(AutoCloseable res) {
				
				try {
					if(res!=null) {
						res.close();
						System.out.println("resource closed");
					}
				} catch (Exception e) {
					System.out.println(res+" did not close");
					System.err.println(e.getMessage());
				}
				
			}

}
