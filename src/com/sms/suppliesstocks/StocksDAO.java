package com.sms.suppliesstocks;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.suppliesstocks.entity.Stocks;


public interface StocksDAO {
	List<Stocks> getStock() throws SQLException;
	void insertStock(HttpServletRequest request) throws SQLException;
	void delStock() throws SQLException;
	void updateStock() throws SQLException;
}
