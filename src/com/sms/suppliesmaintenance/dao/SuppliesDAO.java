package com.sms.suppliesmaintenance.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesmaintenance.entity.Supplies;

public interface SuppliesDAO {
	List<Supplies> getSupplies() throws SQLException;
	List<Supplies> searchSupplies(Supplies addSupplies) throws SQLException;
	List<Supplies> getSupplyTypes() throws SQLException;
	List<Supplies> checkChildRecord(Supplies updateSupplies) throws SQLException;
	void insertSupply(Supplies addSupplies) throws SQLException, ParseException;
	void updateSupply(Supplies updateSupplies) throws SQLException, ParseException;
	
}
