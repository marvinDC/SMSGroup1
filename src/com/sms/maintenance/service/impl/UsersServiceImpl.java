package com.sms.maintenance.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public List<Users> getUser(HttpServletRequest request) throws SQLException {
		return userDAO.getUser(request);
	}

	@Override
	public void insertUser(HttpServletRequest request) throws SQLException {
		this.userDAO.insertUser(request);		
	}


	@Override
	public void updateUser(HttpServletRequest request) throws SQLException {
		this.userDAO.updateUser(request);
	}

}
