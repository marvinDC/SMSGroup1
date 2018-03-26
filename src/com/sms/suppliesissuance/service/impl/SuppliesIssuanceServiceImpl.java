package com.sms.suppliesissuance.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.dao.SuppliesIssuanceDAO;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.exception.InsufficientAmountException;
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
	public void insertIssueSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException, InsufficientAmountException {
		IssuedSupply newIssueSupply = new IssuedSupply();
		newIssueSupply.setDeptId(request.getParameter("departmentId"));
		newIssueSupply.setIssueDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueDate")));
		newIssueSupply.setLastUser(currUser.getUserId());
		newIssueSupply.setQuantity(new Integer(request.getParameter("quantity")));
		newIssueSupply.setRequestor(request.getParameter("requestedBy"));
		newIssueSupply.setSupplyId( new Integer(request.getParameter("supplyId")));
		this.suppliesIssuanceDAO.insertIssueSupply(newIssueSupply);
	}

	@Override
	public void delIssuedSupply() throws SQLException {
		this.suppliesIssuanceDAO.delIssueSupply();
	}

	@Override
	public void updateIssuedSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException, InsufficientAmountException {
		IssuedSupply newIssueSupply = new IssuedSupply();
		Integer quantity = new Integer(request.getParameter("quantity"));
		newIssueSupply.setDeptId(request.getParameter("departmentId"));
		newIssueSupply.setIssueDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueDate")));
		newIssueSupply.setLastUser(currUser.getUserId());
		newIssueSupply.setQuantity(quantity);
		newIssueSupply.setRequestor(request.getParameter("requestedBy"));
		newIssueSupply.setSupplyId( new Integer(request.getParameter("supplyId")));
		newIssueSupply.setIssueId(new Integer(request.getParameter("issueId")));
		newIssueSupply.setQuantityDifference((quantity - new Integer(request.getParameter("currentQuantity"))));
		this.suppliesIssuanceDAO.updateIssueSupply(newIssueSupply);
	}

	@Override
	public List<IssuedSupply> findItem(HttpServletRequest request) throws SQLException {
		IssuedSupply issueSupply = new IssuedSupply();
		issueSupply.setItemName("%" + request.getParameter("itemName").toLowerCase() + "%");
//		searchParam.put("itemName", );
		return this.suppliesIssuanceDAO.findItem(issueSupply);
	}

}
