package com.sms.suppliesstocks.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.suppliesstocks.StocksDAO;
import com.sms.suppliesstocks.entity.Stocks;
import com.sms.suppliesstocks.service.StockService;

public class StockServiceImpl implements StockService {

	private StocksDAO stockDAO;

	public StocksDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StocksDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public List<Stocks> getStock() throws SQLException {
		return stockDAO.getStock();
	}

	@Override
	public void insertStock(HttpServletRequest request) throws SQLException {
		this.stockDAO.insertStock(request);
	}

	@Override
	public void delStock() throws SQLException {
		this.stockDAO.delStock();

	}

	@Override
	public void updateStock(HttpServletRequest request) throws SQLException {
		this.stockDAO.updateStock(request);
	}

	@Override
	public List<Stocks> searchStock(HttpServletRequest request) throws SQLException {

		return stockDAO.searchStock(request);
	}

	public StocksDAO searchStockDAO() {
		return stockDAO;
	}

	@Override
	public List<Stocks> getItemNames() throws SQLException {
		return stockDAO.getItemNames();
	}

}
