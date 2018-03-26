package com.sms.suppliesissuance.servlet;

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
import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.exception.InsufficientAmountException;
import com.sms.suppliesissuance.service.DepartmentService;
import com.sms.suppliesissuance.service.SuppliesIssuanceService;

public class SuppliesIssuance extends HttpServlet {

	private static final long serialVersionUID = 5881004780329249235L;
	
	@SuppressWarnings("resource")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/com/sms/suppliesissuance/resource/applicationContext.xml");
		SuppliesIssuanceService suppliesIssuanceService = 
				(SuppliesIssuanceService) applicationContext.getBean("SuppliesIssuanceService");
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("DepartmentService");
		List<IssuedSupply> issuedSupplies = new ArrayList<>(); 
		List<IssuedSupply> departments = new ArrayList<>(); 
		try {
			switch ((String) request.getParameter("action")) {
				case "table":
					page = "pages/listingAndIssuance.jsp";
					issuedSupplies = suppliesIssuanceService.getIssuedSupplies();
					departments = departmentService.getDepartments();
					request.setAttribute("issuedSupplies", issuedSupplies);
					request.setAttribute("departments", departments);
					break;
				case "add":
					page = "pages/addIssueSupplies.jsp";
					departments = departmentService.getDepartments();
					request.setAttribute("departments", departments);
					break;
				case "search":
					page = "pages/listingAndIssuance.jsp";
					issuedSupplies = suppliesIssuanceService.findItem(request);
					request.setAttribute("issuedSupplies", issuedSupplies);
					request.setAttribute("issuedSupplies", issuedSupplies);
					request.setAttribute("departments", departments);
					break;
				default:
					page = "home.jsp";
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
	@SuppressWarnings("resource")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		List<IssuedSupply> issuedSupplies = new ArrayList<>();
		List<IssuedSupply> departments = new ArrayList<>(); 
		String page = "pages/listingAndIssuance.jsp";
		
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/com/sms/suppliesissuance/resource/applicationContext.xml");
		SuppliesIssuanceService suppliesIssuanceService = 
				(SuppliesIssuanceService) applicationContext.getBean("SuppliesIssuanceService");
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("DepartmentService");
		
		try {
			User currUser = (User) session.getAttribute("currentUser");
			if("add".equals(action)) {
				suppliesIssuanceService.insertIssueSupply(request, currUser);
			}
			else if("update".equals(action)) {
				suppliesIssuanceService.updateIssuedSupply(request, currUser);
			}
			departments = departmentService.getDepartments();
			issuedSupplies = suppliesIssuanceService.getIssuedSupplies();
			request.setAttribute("issuedSupplies", issuedSupplies);
			request.setAttribute("departments", departments);
		} catch (InsufficientAmountException e) {
			try {
				departments = departmentService.getDepartments();
				issuedSupplies = suppliesIssuanceService.getIssuedSupplies();
				request.setAttribute("issuedSupplies", issuedSupplies);
				request.setAttribute("departments", departments);
				request.setAttribute("message", e.getMessage());
			} catch (Exception e1) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}
}
