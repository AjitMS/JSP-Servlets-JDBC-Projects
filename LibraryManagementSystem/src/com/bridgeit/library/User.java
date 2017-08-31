package com.bridgeit.library;

public class User {
	private String fullname, email, phone, password, gender;

	public User() {
		fullname = null;
		email = null;
		phone = null;
		password = null;
		gender = null;
	}

	public User(String fullname, String email, String phone, String password, String gender) {

		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
