package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.entity.IssuedSupply;

public interface SuppliesIssuanceService {
	List<IssuedSupply> getIssuedSupplies() throws SQLException;
	void insertIssueSupply() throws SQLException;
	void delIssuedSupply() throws SQLException;
	void updateIssuedSupply() throws SQLException;
}
