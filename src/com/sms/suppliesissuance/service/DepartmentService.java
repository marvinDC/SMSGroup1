package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.entity.IssuedSupply;

public interface DepartmentService {
	List<IssuedSupply> getDepartments() throws SQLException;
}
