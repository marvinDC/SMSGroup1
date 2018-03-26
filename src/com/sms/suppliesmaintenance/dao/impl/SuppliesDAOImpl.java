package com.sms.suppliesmaintenance.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.suppliesmaintenance.dao.SuppliesDAO;
import com.sms.suppliesmaintenance.entity.Supplies;

public class SuppliesDAOImpl implements SuppliesDAO{

	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplies> getSupplies() throws SQLException {
		return this.getSqlMapClient().queryForList("getSupplies");
	} 

	@SuppressWarnings("unchecked")
	public List<Supplies> getSupplyTypes() throws SQLException {
		return this.getSqlMapClient().queryForList("getSupplyTypes");
	}

	@Override
	public void insertSupply(Supplies addSupplies) throws SQLException, ParseException {
		
		System.out.println("Start SupplyDAOImpl");
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		try {
			

		this.getSqlMapClient().insert("insertSupplies", addSupplies);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
		
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		System.out.println("Finish SupplyDAOImpl");
	}

	@Override
	public void updateSupply(Supplies updateSupplies) throws SQLException, ParseException {
		System.out.println("Start SupplyDAOImpl");
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		try {
			this.getSqlMapClient().update("updateSupplies", updateSupplies);
		
			this.sqlMapClient.executeBatch(); 
			this.sqlMapClient.getCurrentConnection().commit();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		System.out.println("Finish SupplyDAOImpl");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplies> searchSupplies(Supplies searchSupplies) throws SQLException {
		System.out.println("Start SupplyDAOImpl");
		return this.getSqlMapClient().queryForList("searchSupplies", searchSupplies);
		
	}
}
