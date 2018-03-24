package com.sms.suppliesstocks.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.suppliesstocks.entity.Stocks;
import com.sms.suppliesstocks.service.StockService;



public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3254083445269926470L;

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/suppliesstocks/resource/applicationContext.xml");
			
			StockService stockService = 
					(StockService) applicationContext.getBean("stockService");
			
			
			
			List<Stocks> l = new ArrayList<>();
			l = stockService.getStock();
			
			String action = request.getParameter("actionSave");
			
			if (("actionSave").equals(action)) {
				stockService.insertStock(request);
				System.out.println("Here");
				for (Stocks s:l){
			//		System.out.println(s.getStockId()+ ", " + s.getSupplyId() + ", " + s.getRefNo() + ", " + s.getQuantity() + ", " + s.getLastUser() + ", " + s.getLastUpdate());
				}
			} else if(action.equals("save")){
				System.out.println("HERE");
				stockService.insertStock(request);
				System.out.println("Here");
				for (Stocks s:l){
			//		System.out.println(s.getStockId()+ ", " + s.getSupplyId() + ", " + s.getRefNo() + ", " + s.getQuantity() + ", " + s.getLastUser() + ", " + s.getLastUpdate());
				}
			}
			
			
			

		} catch (SQLException e){
			
		}
	}
}
