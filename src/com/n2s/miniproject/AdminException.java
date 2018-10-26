package com.n2s.miniproject;

public class AdminException extends Exception{
	
	public AdminException() {}

	public AdminException(String message) {super(message);}
	
	public AdminException(Throwable cause) {super(cause);}
	
	public AdminException(Throwable cause, String message) {super(message, cause);}
	
}
