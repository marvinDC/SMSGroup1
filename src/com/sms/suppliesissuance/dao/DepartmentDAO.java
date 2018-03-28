package com.sms.suppliesissuance.dao;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.entity.Department;

public interface DepartmentDAO {
	List<Department> getDepartments() throws SQLException;
}
