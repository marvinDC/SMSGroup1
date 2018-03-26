package com.sms.suppliesissuance.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.dao.DepartmentDAO;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;
	
	public DepartmentDAO getDepartmentDao() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	@Override
	public List<IssuedSupply> getDepartments() throws SQLException {
		return departmentDAO.getDepartments();
	}
}
