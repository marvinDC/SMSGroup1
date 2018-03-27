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
		Users records = new Users();
		String action = request.getParameter("action");
		
		if(action != null && action.equals("search")){
		records.setSearchKeyWord(request.getParameter("searchKeyWord"));
		return this.getSqlMapClient().queryForList("getSearch", records);
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
		
		Users records = new Users();	
			records.setUserId(request.getParameter("userid"));
			records.setPassWord(request.getParameter("password"));
			records.setFirstName(request.getParameter("firstname"));
			records.setLastName(request.getParameter("lastname"));
			records.setMidInitial(request.getParameter("midinitial"));
			records.setEmail(request.getParameter("email"));
			records.setActiveTag(request.getParameter("acttag"));
			records.setAccessLevel(request.getParameter("acclevel"));
			records.setEntryDate(date);
			records.setLastLogin(date);
			records.setLastUser(currentUser.getUserId());
		
			System.out.println(records.toString().length());
			
		this.getSqlMapClient().insert("insertUser", records);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
			
	}


	@Override
	public void updateUser(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		Date date = new Date();	
		User currentUser = (User)session.getAttribute("currentUser");
		Users records = new Users();
		String action = request.getParameter("action");
		
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		if(action != null && action.equals("savePW")){
			String oldPassword = currentUser.getPassword();
			String newPassword = request.getParameter("newPassword");
			String currPassword = request.getParameter("currPassword");
			records.setUserId(currentUser.getUserId());
			records.setNewPassword(request.getParameter("retypePassword"));

			//password validation
			if(!oldPassword.equals(currPassword)){
				request.setAttribute("Error", "Sorry!, Password dont match with the Old!");
			}else if(!records.getNewPassword().equals(newPassword)){
				request.setAttribute("Error", "Sorry!, Retype password dont match with the new password!");
			}else if(records.getNewPassword().contains(" ")){
				request.setAttribute("Error", "no white space");
			}else if(records.getNewPassword().length() < 8){
				request.setAttribute("Error", "Password should be atleast 8 characters");
			}else if(records.getNewPassword().length() > 20){
				request.setAttribute("Error", "Password should be exceed 20 characters");
			}else{
				request.setAttribute("Error", "Password succesfully changed!");
				this.getSqlMapClient().update("updatePassword", records);
				
			}
				
		}else if(action != null && action.equals("saveUserChanges")){
			records.setUserId(currentUser.getUserId());
			records.setFirstName(request.getParameter("firstnameUser"));
			records.setLastName(request.getParameter("lastnameUser"));
			records.setMidInitial(request.getParameter("midinitialUser"));
			records.setEmail(request.getParameter("emailUser"));
			records.setLastUser(currentUser.getUserId());
			records.setLastUpdate(date);
			
			if(records.getFirstName() == "" || records.getLastName() == "" || records.getMidInitial() == "" || records.getEmail() == ""){
				request.setAttribute("Error", "Missing Text Field!");
				
			}else if(records.getMidInitial().length() > 1){
				request.setAttribute("Error", "Put middle initial! Initial only");
			}else{
				request.setAttribute("Error", "Successfully Updated!");
			this.getSqlMapClient().update("updateUserChanges", records);
			}
		}else{
			records.setUserId(request.getParameter("userid"));
			records.setFirstName(request.getParameter("firstnameUpd"));
			records.setLastName(request.getParameter("lastnameUpd"));
			records.setMidInitial(request.getParameter("midinitialUpd"));
			records.setEmail(request.getParameter("emailUpd"));
			records.setActiveTag(request.getParameter("acttagUpd"));
			records.setAccessLevel(request.getParameter("acclevelUpd"));
			records.setLastUser(currentUser.getUserId());
			records.setLastUpdate(date);
			
			if(records.getLastName() == "" || records.getFirstName() == "" || records.getMidInitial() == "" || 
			   records.getEmail() == "" || records.getActiveTag() == "" || records.getAccessLevel() == ""){
				request.setAttribute("Error", "Missing Text Field!");
			}else if(records.getMidInitial().length() > 1){
				request.setAttribute("Error", "Put middle initial! Initial only");
			}else{
				request.setAttribute("Error", "Successfully Updated!");
				this.getSqlMapClient().update("updateUser", records);
			}
		}	
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
	}
}
