package com.sms.suppliesissuance.dao;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.entity.IssuedSupply;

public interface DepartmentDAO {
	List<IssuedSupply> getDepartments() throws SQLException;
}
