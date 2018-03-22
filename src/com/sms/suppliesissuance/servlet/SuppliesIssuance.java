package com.sms.suppliesissuance.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		System.out.println("doPost");
		String action = request.getParameter("action");
		List<IssuedSupply> issuedSupplies = new ArrayList<>();
		String page = "pages/listingAndIssuance.jsp";
		try {
			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/suppliesissuance/resource/applicationContext.xml");
			SuppliesIssuanceService suppliesIssuanceService = 
					(SuppliesIssuanceService) applicationContext.getBean("SuppliesIssuanceService");
			
			if("add".equals(action)) {
				System.out.println("add");
				suppliesIssuanceService.insertIssueSupply(request);
			}
			else if("update".equals(action)) {
				suppliesIssuanceService.updateIssuedSupply(request);
				System.out.println("after update");
			}
			issuedSupplies = suppliesIssuanceService.getIssuedSupplies();
			request.setAttribute("issuedSupplies", issuedSupplies);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}
}
