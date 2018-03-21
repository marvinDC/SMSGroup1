package com.sms.maintenance.entity;

import java.util.Date;

public class Users {
	private String userId;
	private String passWord;
	private String firstName;
	private String lastName;
	private char midInitial;
	private char activeTag;
	private String accessLevel;
	private Date entryDate;
	private Date lastLogin;
	private String lastUser;
	
	public Users(String userId, String passWord, String firstName, String lastName, char midInitial, char activeTag,
			String accessLevel, Date entryDate, Date lastLogin, String lastUser) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midInitial = midInitial;
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
	public char getMidInitial() {
		return midInitial;
	}
	public void setMidInitial(char midInitial) {
		this.midInitial = midInitial;
	}
	public char getActiveTag() {
		return activeTag;
	}
	public void setActiveTag(char activeTag) {
		this.activeTag = activeTag;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	
	
	
}
