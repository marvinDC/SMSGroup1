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
		} catch (SQLException e) {
			this.sqlMapClient.getCurrentConnection().rollback();
		}finally{
			this.sqlMapClient.getCurrentConnection().commit();
		}
		
	}

	@Override
	public void updateSupply(Supplies updateSupplies) throws SQLException, ParseException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		try {
			this.getSqlMapClient().update("updateSupplies", updateSupplies);
			this.sqlMapClient.executeBatch(); 
		} catch (SQLException e) {
			System.out.println(e.toString());
			this.sqlMapClient.getCurrentConnection().rollback();
		}finally{
			this.sqlMapClient.getCurrentConnection().commit();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplies> searchSupplies(Supplies searchSupplies) throws SQLException {
		System.out.println("Start SupplyDAOImpl");
		return this.getSqlMapClient().queryForList("searchSupplies", searchSupplies);
		
	}

	@SuppressWarnings("unchecked")
	public List<Supplies> checkChildRecord(Supplies updateSupplies) throws SQLException {
		System.out.println("Start SupplyDAOImpl");
		System.out.println(updateSupplies.getSupplyId());
		return this.getSqlMapClient().queryForList("checkChildRecord", updateSupplies);
		
	}
}
