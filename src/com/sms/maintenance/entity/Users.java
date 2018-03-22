package com.sms.maintenance.entity;

public class Users {
	private String userId;
	private String passWord;
	private String firstName;
	private String lastName;
	private String midInitial;
	private String email;
	private String activeTag;
	private String accessLevel;
	private String entryDate;
	private String lastLogin;
	private String lastUser;
	
	
	public Users(String userId, String passWord, String firstName, String lastName, String email, String midInitial, String activeTag,
			String accessLevel, String entryDate, String lastLogin, String lastUser) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midInitial = midInitial;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	public String getMidInitial() {
		return midInitial;
	}
	public void setMidInitial(String midInitial) {
		this.midInitial = midInitial;
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
