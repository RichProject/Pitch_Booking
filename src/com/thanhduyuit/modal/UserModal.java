package com.thanhduyuit.modal;

public class UserModal {

	
	private String username;
	
	private String password;
	
	private String fullName;
	
	private String email;
	
	private String phoneNumber;
	
	private String userType;
	
	private String note;
	
	
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


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public UserModal() {
		// TODO Auto-generated constructor stub
	}


	public UserModal(String username, String password, String fullName, String email, String phoneNumber,
			String userType, String note) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
		this.note = note;
	}

	
	
}
