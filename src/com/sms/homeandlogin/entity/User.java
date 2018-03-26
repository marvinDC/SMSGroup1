package com.sms.homeandlogin.entity;

public class User {
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String email;
	private String activeTag;
	private String accessLevel;
	private String entryDate;
	private String lastLogin;
	private String lastUser;
	
	
	public void setUser(String userId, String password, String firstName, String lastName, String email, String middleInitial, String activeTag,
			String accessLevel, String entryDate, String lastLogin, String lastUser) {
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.email = email;
		this.activeTag = activeTag;
		this.accessLevel = accessLevel;
		this.entryDate = entryDate;
		this.lastLogin = lastLogin;
		this.lastUser = lastUser;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
		this.password = passWord;
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
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String midInitial) {
		this.middleInitial = midInitial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActiveTag() {
		return activeTag;
	}
	public void setActiveTag(String activeTag) {
		this.activeTag = activeTag;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
}
