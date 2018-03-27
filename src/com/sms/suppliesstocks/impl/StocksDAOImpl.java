package com.sms.suppliesstocks.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	

	
	

	@Override
	public void insertStock(HttpServletRequest request) throws SQLException {
		try{
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Stocks stck = new Stocks();
		stck.setStockId(6);
		stck.setItemName(request.getParameter("itemname"));

		stck.setRefNo(request.getParameter("refno"));
		stck.setQuantity(Integer.parseInt(request.getParameter("quantity")));
/*		stck.setItemName(6);
		stck.setRefNo("ab");
		stck.setQuantity(5);*/
		stck.setLastUser("Grette");
//		stck.se0tDateAdded(Date.parseFormat((request.getParameter("obj.dateadded"), "DD-MM-YYYY"));


		this.getSqlMapClient().insert("insertStock", stck);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
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
	public void updateStock(HttpServletRequest request) throws SQLException {
		try {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		Stocks stck = new Stocks();
		System.out.println("TEST");
		stck.setStockId(Integer.parseInt(request.getParameter("stockid")));
		stck.setItemName(request.getParameter("itemname"));
		stck.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		stck.setRefNo(request.getParameter("refno"));
		stck.setDateAdded(request.getParameter("dateadded"));
		stck.setPurchaseDate(request.getParameter("datepurchase"));

       /* List<Stocks> updatelist = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        
        params.put("stockId", Integer.parseInt(request.getParameter("stockid")));
        params.put("itemName", Integer.parseInt(request.getParameter("itemname")));
        params.put("quantity", Integer.parseInt(request.getParameter("quantity")));
        params.put("refNo", request.getParameter("refno"));
        params.put("dateAdded", request.getParameter("dateadded"));
        params.put("purchaseDate", request.getParameter("datepurchase"));*/
        
		//updatelist = this.getSqlMapClient().queryForList("updateStock", params);

		this.getSqlMapClient().update("updateStock", stck);
		//this.getSqlMapClient().update("updateStock", stck);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		} catch (SQLException e){
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	public List<Stocks> searchStock(HttpServletRequest request) throws SQLException {
		List<Stocks> list = new ArrayList<>();
		
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
			
			//Stocks stck = new Stocks();		
			//stck.setStockId(Integer.parseInt(request.getParameter("search")));
			Map<String, Object> params = new HashMap<>();
			
			params.put("stockId", Integer.parseInt(request.getParameter("search")));
			list = this.getSqlMapClient().queryForList("searchStock", params);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
			
			} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
			}
			
			return list;
	}


	
	@SuppressWarnings("unchecked")
	public List<Stocks> getStock() throws SQLException {
		List<Stocks> l = new ArrayList<>();
		try {
			l = this.getSqlMapClient().queryForList("getStock");
		} catch(SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}      
		return l;
	}

	@Override
	public List<Stocks> getItemNames() throws SQLException {
		// TODO Auto-generated method stub
		return this.getSqlMapClient().queryForList("getItemName");
	}


}
