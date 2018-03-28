package com.sms.suppliesissuance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.suppliesissuance.dao.DepartmentDAO;
import com.sms.suppliesissuance.entity.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() throws SQLException {
		return this.getSqlMapClient().queryForList("getDepartments");
	}

}
