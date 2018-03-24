package com.sms.maintenance.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public List<Users> getUser(HttpServletRequest request) throws SQLException {
		Users emp = new Users();
		System.out.println("this is in getting searched");
		String action = request.getParameter("action");
		
		if(action != null && action.equals("search")){
		emp.setSearchKeyWord(request.getParameter("searchKeyWord"));
		return this.getSqlMapClient().queryForList("getSearch", emp);
		}else{
		return this.getSqlMapClient().queryForList("getUser");
		}
	}

	@Override
	public void insertUser(HttpServletRequest request) throws SQLException {
		System.out.println("insert user");
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		System.out.println(request.getParameter("userid"));
		
		Date date = new Date();
		
		Users emp = new Users();	
			emp.setUserId(request.getParameter("userid"));
			emp.setPassWord(request.getParameter("password"));
			emp.setFirstName(request.getParameter("firstname"));
			emp.setLastName(request.getParameter("lastname"));
			emp.setMidInitial(request.getParameter("midinitial"));
			emp.setEmail(request.getParameter("email"));
			emp.setActiveTag(request.getParameter("acttag"));
			emp.setAccessLevel(request.getParameter("acclevel"));
			emp.setEntryDate(date);
			emp.setLastLogin(date);
			emp.setLastUser("lau");
		
		this.getSqlMapClient().insert("insertUser", emp);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
			
	}


	@Override
	public void updateUser(HttpServletRequest request) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		HttpSession session = request.getSession();
		Users emp = new Users();
		String action = request.getParameter("action");
		
		
		
		if(action != null && action.equals("savePW")){
			
			System.out.println(session.getAttribute("password"));
			emp.setPassWord((String)session.getAttribute("password"));
			emp.setNewPassword(request.getParameter("retypePassword"));
			System.out.println(request.getParameter("newPassword"));
			System.out.println(request.getParameter("retypePassword"));

			System.out.println("getting password" + emp.getPassWord());
			
			this.getSqlMapClient().update("updatePassword", emp);
		}else{
			Date date = new Date();	
			emp.setUserId(request.getParameter("userid"));
			emp.setFirstName(request.getParameter("firstnameUpd"));
			emp.setLastName(request.getParameter("lastnameUpd"));
			emp.setMidInitial(request.getParameter("midinitialUpd"));
			emp.setEmail(request.getParameter("emailUpd"));
			emp.setActiveTag(request.getParameter("acttagUpd"));
			emp.setAccessLevel(request.getParameter("acclevelUpd"));
			emp.setLastLogin(date);
			emp.setLastUser("lau");
		
		this.getSqlMapClient().update("updateUser", emp);
		}
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();		
	}

}
