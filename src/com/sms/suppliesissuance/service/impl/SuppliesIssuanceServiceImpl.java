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
import com.sms.suppliesmaintenance.dao.SuppliesDAO;
import com.sms.suppliesmaintenance.entity.Supplies;

public class SuppliesIssuanceServiceImpl implements SuppliesIssuanceService {
	
	private SuppliesIssuanceDAO suppliesIssuanceDAO;
	private SuppliesDAO suppliesDAO;
	
	public SuppliesIssuanceDAO getSuppliesIssuanceDAO() {
		return suppliesIssuanceDAO;
	}

	public void setSuppliesIssuanceDAO(SuppliesIssuanceDAO suppliesIssuanceDAO) {
		this.suppliesIssuanceDAO = suppliesIssuanceDAO;
	}
	
	public SuppliesDAO getSuppliesDAO() {
		return suppliesDAO;
	}

	public void setSuppliesDAO(SuppliesDAO suppliesDAO) {
		this.suppliesDAO = suppliesDAO;
	}

	@Override
	public List<IssuedSupply> getIssuedSupplies() throws SQLException {
		return suppliesIssuanceDAO.getIssueSupplies();
	}

	@Override
	public String insertIssueSupply(HttpServletRequest request, User currUser, List<Supplies> supplies) throws SQLException, ParseException, InsufficientAmountException {
		IssuedSupply newIssueSupply = new IssuedSupply();
		Supplies supply = findSupply(new Integer(request.getParameter("supplyId")), supplies);
		String message = checkReorderLevel(request, supply);
		if(supply != null && checkStock(request, supply)) {
			newIssueSupply.setDeptId(request.getParameter("departmentId"));
			newIssueSupply.setIssueDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueDate")));
			newIssueSupply.setLastUser(currUser.getUserId());
			newIssueSupply.setQuantity(new Integer(request.getParameter("quantity")));
			newIssueSupply.setRequestor(request.getParameter("requestedBy"));
			newIssueSupply.setSupplyId( new Integer(request.getParameter("supplyId")));
			this.suppliesIssuanceDAO.insertIssueSupply(newIssueSupply);
		}
		else {
			throw new InsufficientAmountException("Insufficient Stock: " + supply.getItemName() + " only has " + supply.getActualCount() + ".");
		}
		return message;
	}

	@Override
	public void delIssuedSupply() throws SQLException {
		this.suppliesIssuanceDAO.delIssueSupply();
	}

	@Override
	public String updateIssuedSupply(HttpServletRequest request, User currUser, List<Supplies> supplies) throws SQLException, ParseException, InsufficientAmountException {
		IssuedSupply newIssueSupply = new IssuedSupply();
		Supplies supply = findSupply(new Integer(request.getParameter("supplyId")), supplies);
		String message = checkReorderLevel(request, supply);
		if(supply != null && checkStock(request, supply)) {
			Integer quantity = new Integer(request.getParameter("quantity"));
			newIssueSupply.setDeptId(request.getParameter("departmentId"));
			newIssueSupply.setIssueDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueDate")));
			newIssueSupply.setLastUser(currUser.getUserId());
			newIssueSupply.setQuantity(quantity);
			newIssueSupply.setRequestor(request.getParameter("requestedBy"));
			newIssueSupply.setSupplyId( new Integer(request.getParameter("supplyId")));
			newIssueSupply.setIssueId(new Integer(request.getParameter("issueId")));
			newIssueSupply.setCurrQuantity(new Integer(request.getParameter("currentQuantity")));
			newIssueSupply.setCurrSupplyId(new Integer(request.getParameter("currentSupplyId")));
			this.suppliesIssuanceDAO.updateIssueSupply(newIssueSupply);
		} else {
			throw new InsufficientAmountException("Insufficient Stock: " + supplies.get(0).getItemName() + " only has " + supplies.get(0).getActualCount() + ".");
		}
		return message;
	}

	@Override
	public List<IssuedSupply> findItem(HttpServletRequest request) throws SQLException {
		IssuedSupply issueSupply = new IssuedSupply();
		issueSupply.setItemName("%" + request.getParameter("itemName").toLowerCase() + "%");
		return this.suppliesIssuanceDAO.findItem(issueSupply);
	}
	
	public Supplies findSupply(Integer supplyId, List<Supplies> supplies) throws SQLException {
		for (Supplies supply : supplies) {
			if(supply.getSupplyId().compareTo(supplyId) == 0) {
				return supply;
			}
		}
		return null;
	}
	
	public boolean checkStock(HttpServletRequest request, Supplies supply) {
		if (request.getParameter("currentQuantity") != null && supply.getActualCount().compareTo(
				new Integer(request.getParameter("quantity")) - new Integer(request.getParameter("currentQuantity"))) > 0) {
			return true;
		}
		else if(request.getParameter("currentQuantity") == null && supply.getActualCount().compareTo(new Integer(request.getParameter("quantity"))) > 0) {
			return true;
		}
		return false;
	}
	
	public String checkReorderLevel(HttpServletRequest request, Supplies supply) {
		if ((request.getParameter("currentQuantity") != null && supply.getReorderLevel().compareTo(
				new Integer(request.getParameter("quantity")) - new Integer(request.getParameter("currentQuantity"))) < 0) ||
				(request.getParameter("currentQuantity") == null && supply.getReorderLevel().compareTo(
						new Integer(request.getParameter("quantity"))) < 0)) {
			return "The actual count of the item " + supply.getItemName() + " is below the reorder level.";
		}
		else if((request.getParameter("currentQuantity") != null && supply.getReorderLevel().compareTo(
				new Integer(request.getParameter("quantity")) - new Integer(request.getParameter("currentQuantity"))) == 0) ||
				(request.getParameter("currentQuantity") == null && supply.getReorderLevel().compareTo(
						new Integer(request.getParameter("quantity"))) == 0)) {
			return "The actual count of the item " + supply.getItemName() + " is equal the reorder level.";
		}
		return null;
	}
}
