package com.n2s.miniproject;

public class AdminRegister {
		private String username;
		private String password;
		private String confirmPassword;
		private String firstName;
		private String lastName;
		private String address;
		private String phone;
		
		
		
		
		public AdminRegister() {super();}
		
		public AdminRegister(String username, String password, String confirmPassword, String firstName,
				String lastName, String address, String phone) {
			super();
			this.username = username;
			this.password = password;
			this.confirmPassword = confirmPassword;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.phone = phone;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "AdminRegister [username=" + username + ", password=" + password + ", confirmPassword="
					+ confirmPassword + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
					+ ", phone=" + phone + "]";
		}
		
		
		
}


