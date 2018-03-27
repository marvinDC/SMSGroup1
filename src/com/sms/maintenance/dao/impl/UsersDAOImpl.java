package com.sms.maintenance.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.homeandlogin.entity.User;
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
		HttpSession session = request.getSession();
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		Date date = new Date();
		User currentUser = (User)session.getAttribute("currentUser");
		
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
			emp.setLastUser(currentUser.getUserId());
		
		this.getSqlMapClient().insert("insertUser", emp);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
			
	}


	@Override
	public void updateUser(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		Date date = new Date();	
		User currentUser = (User)session.getAttribute("currentUser");
		Users emp = new Users();
		String action = request.getParameter("action");
		
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		if(action != null && action.equals("savePW")){
			String oldPassword = currentUser.getPassword();
			String newPassword = request.getParameter("newPassword");
			String currPassword = request.getParameter("currPassword");
			emp.setUserId(currentUser.getUserId());
			emp.setNewPassword(request.getParameter("retypePassword"));

			//password validation
			if(!oldPassword.equals(currPassword)){
				request.setAttribute("Error", "Sorry!, Password dont match with the Old!");
			}else if(!emp.getNewPassword().equals(newPassword)){
				request.setAttribute("Error", "Sorry!, Retype password dont match with the new password!");
			}else if(emp.getNewPassword().contains(" ")){
				request.setAttribute("Error", "no white space");
			}else if(emp.getNewPassword().length() < 8){
				request.setAttribute("Error", "Password should be atleast 8 characters");
			}else if(emp.getNewPassword().length() > 20){
				request.setAttribute("Error", "Password should be exceed 20 characters");
			}else{
				System.out.println("luma parehas sa bagong password");
				this.getSqlMapClient().update("updatePassword", emp);
				
			}
				
		}else if(action != null && action.equals("saveUserChanges")){
			emp.setUserId(currentUser.getUserId());
			emp.setFirstName(request.getParameter("firstnameUser"));
			emp.setLastName(request.getParameter("lastnameUser"));
			emp.setMidInitial(request.getParameter("midinitialUser"));
			emp.setEmail(request.getParameter("emailUser"));
			emp.setLastUser(currentUser.getUserId());
			emp.setLastUpdate(date);
			
			if(emp.getFirstName() == "" || emp.getLastName() == "" || emp.getMidInitial() == "" || emp.getEmail() == ""){
				request.setAttribute("Error", "Missing Text Field!");
				
			}else if(emp.getMidInitial().length() > 1){
				request.setAttribute("Error", "Put middle initial! Initial only");
			}else{
			this.getSqlMapClient().update("updateUserChanges", emp);
			}
		}else{
			emp.setUserId(request.getParameter("userid"));
			emp.setFirstName(request.getParameter("firstnameUpd"));
			emp.setLastName(request.getParameter("lastnameUpd"));
			emp.setMidInitial(request.getParameter("midinitialUpd"));
			emp.setEmail(request.getParameter("emailUpd"));
			emp.setActiveTag(request.getParameter("acttagUpd"));
			emp.setAccessLevel(request.getParameter("acclevelUpd"));
			emp.setLastUser(currentUser.getUserId());
			emp.setLastUpdate(date);
			
			if(emp.getLastName() == "" || emp.getFirstName() == "" || emp.getMidInitial() == "" || 
			   emp.getEmail() == "" || emp.getActiveTag() == "" || emp.getAccessLevel() == ""){
				request.setAttribute("Error", "Missing Text Field!");
			}else if(emp.getMidInitial().length() > 1){
				request.setAttribute("Error", "Put middle initial! Initial only");
			}else{
				this.getSqlMapClient().update("updateUser", emp);
			}
		}	
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
	}
}
