package com.sms.suppliesstocks.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.suppliesstocks.StocksDAO;
import com.sms.suppliesstocks.entity.Stocks;

import oracle.sql.DATE;

public class StocksDAOImpl implements StocksDAO{

	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stocks> getStock() throws SQLException {
		return this.getSqlMapClient().queryForList("getStock");
	}

	@Override
	public void insertStock(HttpServletRequest request) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Stocks stck = new Stocks();
		stck.setStockId(6);
		stck.setSupplyId(Integer.parseInt(request.getParameter("itemname")));
		stck.setRefNo(request.getParameter("refno"));
		stck.setQuantity(Integer.parseInt(request.getParameter("quantity")));
/*		stck.setSupplyId(6);
		stck.setRefNo("ab");
		stck.setQuantity(5);*/
		stck.setLastUser("Grette");

//		stck.setDateAdded(Date.parseFormat((request.getParameter("obj.dateadded"), "DD-MM-YYYY"));


		this.getSqlMapClient().insert("insertStock", stck);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
	}

	@Override
	public void delStock() throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Stocks stck = new Stocks();
		   
		stck.setStockId(23);

		this.getSqlMapClient().delete("deleteStock", stck);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		
	}

	@Override
	public void updateStock() throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Stocks stck = new Stocks();
		   
		stck.setStockId(23);
		stck.setSupplyId(5);
		stck.setRefNo("abc");
		stck.setQuantity(20);
		stck.setLastUser("John");

		this.getSqlMapClient().update("updateStock", stck);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		
	}

}
