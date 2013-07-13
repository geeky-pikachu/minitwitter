package com.minitwitter.domain;

public class User {
	private String username;
	private String password1;
	private String password2;
	private String email;
	private boolean isNewUser = false;

	public boolean isNewUser() {
		return isNewUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}
	
}