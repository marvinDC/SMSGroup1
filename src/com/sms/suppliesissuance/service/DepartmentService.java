package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.entity.Department;
import com.sms.suppliesissuance.entity.IssuedSupply;

public interface DepartmentService {
	List<Department> getDepartments() throws SQLException;
}
