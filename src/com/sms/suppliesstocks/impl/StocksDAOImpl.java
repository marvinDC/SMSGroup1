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
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.util.AlternativeJdkIdGenerator;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sms.homeandlogin.entity.User;
import com.sms.suppliesstocks.StocksDAO;
import com.sms.suppliesstocks.entity.Stocks;

import oracle.sql.DATE;

public class StocksDAOImpl implements StocksDAO {

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public void insertStock(HttpServletRequest request) throws SQLException {
		try {
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
			HttpSession session = request.getSession();
			User currentUser = (User) session.getAttribute("currentUser");

			Stocks stck = new Stocks();
			stck.setItemName(request.getParameter("itemname"));
			System.out.println(request.getParameter("itemname"));
			stck.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			stck.setRefNo(request.getParameter("refno"));
			stck.setLastUser(currentUser.getUserId());
			stck.setDateAdded(request.getParameter("dateadded"));
			stck.setPurchaseDate(request.getParameter("datepurchase"));

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
		this.sqlMapClient.startTransaction();
		this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
		this.sqlMapClient.startBatch();

		Stocks stck = new Stocks();
		System.out.println("TEST");
		stck.setSupplyId(Integer.parseInt(request.getParameter("itemname")));
		System.out.println(stck.getSupplyId());
		stck.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		stck.setRefNo(request.getParameter("refno"));
		stck.setDateAdded(request.getParameter("dateadded"));
		stck.setPurchaseDate(request.getParameter("purchaseadded"));
		stck.setStockId(Integer.parseInt(request.getParameter("stockid")));

		try {
			this.getSqlMapClient().update("updateStock", stck);
			this.sqlMapClient.executeBatch();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			this.sqlMapClient.getCurrentConnection().commit();
			System.out.println("finally");
		}

	}

	@SuppressWarnings("unchecked")
	public List<Stocks> searchStock(HttpServletRequest request) throws SQLException {
		List<Stocks> list = new ArrayList<>();

		try {
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();

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
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stocks> getItemNames() throws SQLException {
		return this.getSqlMapClient().queryForList("getItemName");
	}

}
