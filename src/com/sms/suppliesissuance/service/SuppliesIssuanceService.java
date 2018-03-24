package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.entity.IssuedSupply;

public interface SuppliesIssuanceService {
	List<IssuedSupply> getIssuedSupplies() throws SQLException;
	void insertIssueSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException;
	void delIssuedSupply() throws SQLException;
	void updateIssuedSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException;
}
