package com.sms.maintenance.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.maintenance.entity.Users;


public interface UsersService {
	List<Users> getUser(HttpServletRequest request) throws SQLException;
	void insertUser(HttpServletRequest request) throws SQLException;
	void updateUser(HttpServletRequest request) throws SQLException;

}
