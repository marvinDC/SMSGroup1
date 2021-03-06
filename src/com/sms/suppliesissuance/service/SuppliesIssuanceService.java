package com.sms.suppliesissuance.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.exception.InsufficientAmountException;
import com.sms.suppliesmaintenance.entity.Supplies;

public interface SuppliesIssuanceService {
	List<IssuedSupply> getIssuedSupplies() throws SQLException;
	String insertIssueSupply(HttpServletRequest request, User currUser, List<Supplies> supplies) throws SQLException, ParseException, InsufficientAmountException;
	void delIssuedSupply() throws SQLException;
	String updateIssuedSupply(HttpServletRequest request, User currUser, List<Supplies> supplies) throws SQLException, ParseException, InsufficientAmountException;
	List<IssuedSupply> findItem(HttpServletRequest request) throws SQLException;
}
