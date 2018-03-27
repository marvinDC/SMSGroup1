package com.sms.suppliesissuance.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sms.suppliesissuance.entity.IssuedSupply;

public interface SuppliesIssuanceDAO {
	List<IssuedSupply> getIssueSupplies() throws SQLException;
	void insertIssueSupply(IssuedSupply issuedSupply) throws SQLException;
	void delIssueSupply() throws SQLException;
	void updateIssueSupply(IssuedSupply newIssueSupply) throws SQLException;
	List<IssuedSupply> findItem(IssuedSupply issueSupply) throws SQLException;
}
