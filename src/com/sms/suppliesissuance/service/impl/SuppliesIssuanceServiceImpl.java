package com.sms.suppliesissuance.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sms.suppliesissuance.dao.SuppliesIssuanceDAO;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.service.SuppliesIssuanceService;

public class SuppliesIssuanceServiceImpl implements SuppliesIssuanceService {
	
	private SuppliesIssuanceDAO suppliesIssuanceDAO;
	
	public SuppliesIssuanceDAO getSuppliesIssuanceDAO() {
		return suppliesIssuanceDAO;
	}

	public void setSuppliesIssuanceDAO(SuppliesIssuanceDAO suppliesIssuanceDAO) {
		this.suppliesIssuanceDAO = suppliesIssuanceDAO;
	}

	@Override
	public List<IssuedSupply> getIssuedSupplies() throws SQLException {
		return suppliesIssuanceDAO.getIssueSupplies();
	}

	@Override
	public void insertIssueSupply(IssuedSupply issuedSupply) throws SQLException {
		this.suppliesIssuanceDAO.insertIssueSupply(issuedSupply);

	}

	@Override
	public void delIssuedSupply() throws SQLException {
		this.suppliesIssuanceDAO.delIssueSupply();
	}

	@Override
	public void updateIssuedSupply(IssuedSupply issuedSupply) throws SQLException {
		this.suppliesIssuanceDAO.updateIssueSupply(issuedSupply);
	}

}
