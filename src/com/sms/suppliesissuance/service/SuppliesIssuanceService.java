package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.exception.InsufficientAmountException;

public interface SuppliesIssuanceService {
	List<IssuedSupply> getIssuedSupplies() throws SQLException;
	void insertIssueSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException, InsufficientAmountException;
	void delIssuedSupply() throws SQLException;
	void updateIssuedSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException, InsufficientAmountException;
	List<IssuedSupply> findItem(HttpServletRequest request) throws SQLException;
}
