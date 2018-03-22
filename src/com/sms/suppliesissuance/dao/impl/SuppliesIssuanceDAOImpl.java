package com.sms.suppliesissuance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.suppliesissuance.dao.SuppliesIssuanceDAO;
import com.sms.suppliesissuance.entity.IssuedSupply;

public class SuppliesIssuanceDAOImpl implements SuppliesIssuanceDAO {
	
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuedSupply> getIssueSupplies() throws SQLException {
		return this.getSqlMapClient().queryForList("getIssueSupplies");
	}

	@Override
	public void insertIssueSupply(IssuedSupply issuedSupply) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		this.getSqlMapClient().insert("insertIssueSupply", issuedSupply);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
	}

	@Override
	public void delIssueSupply() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIssueSupply(IssuedSupply issuedSupply) throws SQLException {
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();
		
		this.getSqlMapClient().update("updateIssueSupply", issuedSupply);
		
		this.sqlMapClient.executeBatch();
		this.sqlMapClient.getCurrentConnection().commit();
	}

}
