package com.sms.maintenance.dao;

import java.sql.SQLException;
import java.util.List;

import com.sms.maintenance.entity.Users;


public interface UsersDAO {
	List<Users> getUser() throws SQLException;
	void insertUser() throws SQLException;
	void delUser() throws SQLException;
	void updateUser() throws SQLException;

}
