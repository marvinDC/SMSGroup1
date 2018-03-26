package com.sms.suppliesmaintenance.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesmaintenance.dao.SuppliesDAO;
import com.sms.suppliesmaintenance.entity.Supplies;
import com.sms.suppliesmaintenance.service.SuppliesService;

public class SuppliesServiceImpl implements SuppliesService {

	private SuppliesDAO suppliesDAO;

	public SuppliesDAO getSuppliesDAO() {
		return suppliesDAO;
	}

	public void setSuppliesDAO(SuppliesDAO suppliesDAO) {
		this.suppliesDAO = suppliesDAO;
	}

	@Override
	public List<Supplies> getSupplies() throws SQLException {
		return suppliesDAO.getSupplies();
	}

	@Override
	public List<Supplies> searchSupplies(HttpServletRequest request) throws SQLException {
		Supplies searchSupplies = new Supplies();
		System.out.println("May Laman" + request.getAttribute("supplyId").toString());
		searchSupplies.setSupplyId(Integer.valueOf(request.getAttribute("supplyId").toString()));
		return suppliesDAO.searchSupplies(searchSupplies);
	}

	@Override
	public List<Supplies> getSupplyTypes() throws SQLException {
		return suppliesDAO.getSupplyTypes();
	}

	@Override
	public void insertSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException {
		System.out.println("Start SupplyServiceImpl");
		System.out.println(request.getAttribute("supplyTypeId") + " --- " + request.getAttribute("dateAdded") + " --- "
				+ request.getAttribute("itemName") + " --- " + request.getAttribute("reorderLevel") + " --- "
				+ request.getAttribute("actualCount") + " --- " + request.getAttribute("itemUnit") + " --- "
				+ request.getAttribute("remarks") + " --- " + request.getAttribute("obsolete") + " --- "
				+ request.getAttribute("location"));
		Supplies addSupplies = new Supplies();

		addSupplies.setSupplyTypeId(Integer.valueOf(request.getAttribute("supplyTypeId").toString()));
		addSupplies.setItemName(request.getAttribute("itemName").toString());
		addSupplies
				.setDateAdded(new SimpleDateFormat("MM/DD/YYYY").parse(request.getAttribute("dateAdded").toString()));
		addSupplies.setReorderLevel(Integer.valueOf(request.getAttribute("reorderLevel").toString()));
		addSupplies.setActualCount(Integer.valueOf(request.getAttribute("actualCount").toString()));
		addSupplies.setItemUnit(request.getAttribute("itemUnit").toString());
		addSupplies.setRemarks(request.getAttribute("remarks").toString());
		addSupplies.setObsoleteTag(request.getAttribute("obsolete").toString());
		addSupplies.setLocation(request.getAttribute("location").toString());
		addSupplies.setLastUser(currUser.getUserId().toString());
		this.suppliesDAO.insertSupply(addSupplies);
		System.out.println("Finish SupplyServiceImpl");
	}

	@Override
	public void delSupply() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSupply(HttpServletRequest request, User currUser) throws SQLException, ParseException {

		System.out.println("Start SupplyServiceImpl");
		System.out.println(request.getAttribute("supplyId") + "awerwe21312rweaaaaacccccccc");

		System.out.println(request.getAttribute("supplyId") + " --- " + request.getAttribute("dateAdded") + " --- "
				+ request.getAttribute("itemName") + " --- " + request.getAttribute("reorderLevel") + " --- "
				+ request.getAttribute("actualCount") + " --- " + request.getAttribute("itemUnit") + " --- "
				+ request.getAttribute("remarks") + " --- " + request.getAttribute("obsolete") + " --- "
				+ request.getAttribute("location") + " --- " + request.getAttribute("supplyId"));

		Supplies updateSupplies = new Supplies();
		updateSupplies.setSupplyId(Integer.valueOf(request.getAttribute("supplyId").toString()));
		/*
		 * updateSupplies.setSupplyTypeId(Integer.valueOf(request.getAttribute(
		 * "supplyTypeId").toString()));
		 */
		updateSupplies.setItemName(request.getAttribute("itemName").toString());
		updateSupplies
				.setDateAdded(new SimpleDateFormat("MM/DD/YYYY").parse(request.getAttribute("dateAdded").toString()));
		updateSupplies.setReorderLevel(Integer.valueOf(request.getAttribute("reorderLevel").toString()));
		updateSupplies.setActualCount(Integer.valueOf(request.getAttribute("actualCount").toString()));
		updateSupplies.setItemUnit(request.getAttribute("itemUnit").toString());
		updateSupplies.setRemarks(request.getAttribute("remarks").toString());
		updateSupplies.setObsoleteTag(request.getAttribute("obsolete").toString());
		updateSupplies.setLocation(request.getAttribute("location").toString());
		updateSupplies.setLastUser(currUser.getUserId().toString());
		this.suppliesDAO.updateSupply(updateSupplies);
		System.out.println("Finish SupplyServiceImpl");

	}

}
