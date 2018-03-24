package com.sms.homeandlogin.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;

public interface UserService {
	List<User> findUser(HttpServletRequest request) throws SQLException;
	void removeAccess(HttpServletRequest request) throws SQLException;
	void updateLastLogin(HttpServletRequest request) throws SQLException;
}
