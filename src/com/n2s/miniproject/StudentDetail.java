package com.n2s.miniproject;

public class StudentDetail {
	
	private int ID;
	private String firstName;
	private String lastName;
	private int age;
	private String contactPhone;
	private String contactMail;
	
	
	public StudentDetail() {super();}
	
	public StudentDetail(int ID, String firstName, String lastName, int age, String contactPhone,
			String contactMail) {
		super();
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactPhone = contactPhone;
		this.contactMail = contactMail;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactMail() {
		return contactMail;
	}
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	@Override
	public String toString() {
		return "StudentDetail [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", contactPhone=" + contactPhone + ", contactMail=" + contactMail + "]";
	
	}
	
	

}
