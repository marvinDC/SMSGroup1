package com.sms.homeandlogin.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.homeandlogin.dao.UserDao;
import com.sms.homeandlogin.entity.User;

public class UserDaoImpl implements UserDao {

	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findUser(HttpServletRequest request) throws SQLException {
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));
//		user.setUserId("user1");
//		user.setPassword("user1");
		
		return this.getSqlMapClient().queryForList("findUser", user);
	}

	@Override
	public void removeAccess(HttpServletRequest request) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		User user = new User();
		user.setActiveTag("N");
		user.setUserId(request.getParameter("userId"));

		this.getSqlMapClient().update("removeAccess", user);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		
	}

	@Override
	public void updateLastLogin(HttpServletRequest request) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		
		Date date = new Date();
		user.setLastLogin(new SimpleDateFormat("dd-MMM-yy").format(date));
		
		this.getSqlMapClient().update("updateLastLogin", user);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		
	}

}
