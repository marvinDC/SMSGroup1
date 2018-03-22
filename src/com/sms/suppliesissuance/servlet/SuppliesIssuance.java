package com.sms.suppliesissuance.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.suppliesissuance.entity.IssuedSupply;
import com.sms.suppliesissuance.service.SuppliesIssuanceService;
import com.sms.suppliesissuance.service.impl.SuppliesIssuanceServiceImpl;

public class SuppliesIssuance extends HttpServlet {

	private static final long serialVersionUID = 5881004780329249235L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		switch ((String) request.getParameter("action")) {
			case "table":
				page = "pages/listingAndIssuance.jsp";
				try {
					ApplicationContext applicationContext = 
							new ClassPathXmlApplicationContext("/com/sms/suppliesissuance/resource/applicationContext.xml");
					SuppliesIssuanceService suppliesIssuanceService = 
							(SuppliesIssuanceService) applicationContext.getBean("SuppliesIssuanceService");
					
					List<IssuedSupply> issuedSupplies = new ArrayList<>(); 
					issuedSupplies = suppliesIssuanceService.getIssuedSupplies();
					for (IssuedSupply e:issuedSupplies){
						System.out.println(e.toString());
					}
					request.setAttribute("issuedSupplies", issuedSupplies);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "add":
				page = "pages/addIssueSupplies.jsp";
				break;
			default:
				page = "index.jsp";
				break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		SuppliesIssuanceService newIssuance = new SuppliesIssuanceServiceImpl();
		String action = request.getParameter("action");
		Integer supplyId = new Integer(request.getParameter("supplyId"));
		Integer quantity = new Integer(request.getParameter("quantity"));
		String requestedBy = request.getParameter("requestedBy");
		Integer departmentId = new Integer(request.getParameter("departmentId"));
		String issueDate = request.getParameter("issueDate");
		
		if("add".equals(action)) {
			
		}
		else if("update".equals(action)) {
			
		}
	}
}
