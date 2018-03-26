package com.sms.homeandlogin.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.dao.UserDao;
import com.sms.homeandlogin.entity.User;
import com.sms.homeandlogin.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findUser(HttpServletRequest request) throws SQLException {
		return this.userDao.findUser(request);
	}

	@Override
	public void removeAccess(HttpServletRequest request) throws SQLException {
		this.userDao.removeAccess(request);
	}

	@Override
	public void updateLastLogin(HttpServletRequest request) throws SQLException {
		this.userDao.updateLastLogin(request);
	}

}
