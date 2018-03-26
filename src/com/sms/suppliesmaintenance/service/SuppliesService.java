package com.sms.suppliesmaintenance.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesmaintenance.entity.Supplies;

public interface SuppliesService {
	List<Supplies> getSupplies() throws SQLException;
	List<Supplies> searchSupplies(HttpServletRequest request) throws SQLException;
	List<Supplies> getSupplyTypes() throws SQLException;
	void insertSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException;
	void delSupply() throws SQLException;
	void updateSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException;
}
