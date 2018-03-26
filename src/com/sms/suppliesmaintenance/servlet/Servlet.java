package com.sms.suppliesmaintenance.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.homeandlogin.entity.User;
import com.sms.suppliesissuance.service.SuppliesIssuanceService;
import com.sms.suppliesmaintenance.entity.Supplies;
import com.sms.suppliesmaintenance.service.SuppliesService;

public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9108765950411597927L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String errorMsg;
			String page;
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"/com/sms/suppliesmaintenance/resource/applicationContext.xml");

			SuppliesService suppliesService = (SuppliesService) applicationContext.getBean("suppliesService");
			List<Supplies> l = new ArrayList<>();

			if ("searchSupplies".equalsIgnoreCase(request.getParameter("action"))) {
				if (request.getParameter("supplyId").equals("")){
					System.out.println("NULL");
					request.setAttribute("supplyId",-1);
				}else{
				request.setAttribute("supplyId", request.getParameter("supplyId"));};
				System.out.println("HEREHERE");
				l = suppliesService.searchSupplies(request);

			} else {
				
				l = suppliesService.getSupplies();
			}

			List<Supplies> suppTypes = new ArrayList<>();
			suppTypes = suppliesService.getSupplyTypes();
			request.setAttribute("supplies", l);
			request.setAttribute("supplyTypes", suppTypes);

			if ("populate".equalsIgnoreCase(request.getParameter("action"))) {
				page = "pages/suppliesMaintenance.jsp";
			} else if ("searchSupplies".equalsIgnoreCase(request.getParameter("action"))) {
				page = "pages/suppliesMaintenance.jsp";
			} else {
				page = "pages/addSupplies.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/sms/suppliesmaintenance/resource/applicationContext.xml");
		SuppliesService suppliesService = (SuppliesService) applicationContext.getBean("suppliesService");
		User currUser = (User) session.getAttribute("currentUser");

		String page = "pages/suppliesMaintenance.jsp";
		try {

			if ("addSupplies".equalsIgnoreCase(request.getParameter("action"))) {

				request.setAttribute("supplyTypeId", request.getParameter("supplyTypeId"));
				request.setAttribute("dateAdded", request.getParameter("dateAdded"));
				request.setAttribute("itemName", request.getParameter("itemName"));
				request.setAttribute("reorderLevel", request.getParameter("reorderLevel"));
				request.setAttribute("actualCount", request.getParameter("actualCount"));
				request.setAttribute("itemUnit", request.getParameter("itemUnit"));
				request.setAttribute("remarks", request.getParameter("remarks"));
				request.setAttribute("obsolete", request.getParameter("obsolete"));
				request.setAttribute("location", request.getParameter("location"));

				suppliesService.insertSupply(request, currUser);

				List<Supplies> l = new ArrayList<>();
				l = suppliesService.getSupplies();

				List<Supplies> suppTypes = new ArrayList<>();
				suppTypes = suppliesService.getSupplyTypes();
				request.setAttribute("supplies", l);
				request.setAttribute("supplyTypes", suppTypes);

			} else {

				request.setAttribute("supplyId", request.getParameter("supplyId"));
				request.setAttribute("supplyTypeId", request.getParameter("supplyTypeId"));
				request.setAttribute("dateAdded", request.getParameter("dateAdded"));
				request.setAttribute("itemName", request.getParameter("itemName"));
				request.setAttribute("reorderLevel", request.getParameter("reorderLevel"));
				request.setAttribute("actualCount", request.getParameter("actualCount"));
				request.setAttribute("itemUnit", request.getParameter("itemUnit"));
				request.setAttribute("remarks", request.getParameter("remarks"));
				request.setAttribute("obsolete", request.getParameter("obsolete"));
				request.setAttribute("location", request.getParameter("location"));

				suppliesService.updateSupply(request, currUser);

				List<Supplies> l = new ArrayList<>();
				l = suppliesService.getSupplies();

				List<Supplies> suppTypes = new ArrayList<>();
				suppTypes = suppliesService.getSupplyTypes();

				request.setAttribute("supplies", l);
				request.setAttribute("supplyTypes", suppTypes);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {

			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}

	}
}
