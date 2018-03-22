package com.sms.maintenance.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sms.maintenance.dao.UsersDAO;
import com.sms.maintenance.entity.Users;
import com.sms.maintenance.service.UsersService;

public class UsersServiceImpl implements UsersService{

	private UsersDAO userDAO;
	
	
	public UsersDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<Users> getUser() throws SQLException {
		System.out.println("TEST!");
		return userDAO.getUser();
	}

	@Override
	public void insertUser() throws SQLException {
		System.out.println("SERVICE");
		this.userDAO.insertUser();		
	}

	@Override
	public void delUser() throws SQLException {
		this.userDAO.delUser();
	}

	@Override
	public void updateUser() throws SQLException {
		this.userDAO.updateUser();
	}

}
