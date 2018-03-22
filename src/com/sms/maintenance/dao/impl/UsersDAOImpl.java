package com.sms.maintenance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.maintenance.dao.UsersDAO;
import com.sms.maintenance.entity.Users;

public class UsersDAOImpl implements UsersDAO{
	private SqlMapClient sqlMapClient;
		
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getUser() throws SQLException {
		System.out.println("getUser");
		return this.getSqlMapClient().queryForList("getUser");
	}

	@Override
	public void insertUser() throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		
		Users emp = new Users("bakulau", "yes", "crispin", "lauderez", "L", "@yahoo", "Y", "a", "SYSDATE", "SYSDATE", "lau");	
	
		this.getSqlMapClient().insert("insertUser", emp);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
			
	}

	@Override
	public void delUser() throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Users emp = new Users("bakulau", "yes", "crispin", "lauderez", "L", "@yahoo", "Y", "a", "SYSDATE", "SYSDATE", "lau");	

		this.getSqlMapClient().delete("deleteUser", emp);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();		
	}

	@Override
	public void updateUser() throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Users emp = new Users("bakulau", "yes", "crispin", "lauderez", "L", "@yahoo", "Y", "a", "SYSDATE", "SYSDATE", "lau");	

		this.getSqlMapClient().update("updateUser", emp);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();		
	}

}
