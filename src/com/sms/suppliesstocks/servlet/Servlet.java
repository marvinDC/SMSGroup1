package com.sms.suppliesstocks.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.suppliesstocks.entity.Stocks;
import com.sms.suppliesstocks.service.StockService;



public class Servlet extends HttpServlet{

	private static final long serialVersionUID = -3254083445269926470L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = "pages/stocks.jsp";
		try{
			String actionsave = request.getParameter("actionSave");
			String actionback = request.getParameter("actionBack");
			String actionsearch = request.getParameter("actionSearch");
			String actionadd = request.getParameter("actionAdd");
			String actionhome = request.getParameter("backToHome");
			String actionupdate = request.getParameter("actionUpdate");
			String action = request.getParameter("action");
		

			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/suppliesstocks/resource/applicationContext.xml");
			
			StockService stockService = 
					(StockService) applicationContext.getBean("stockService");
			

			
			
			String items="";
			List<Stocks> item = new ArrayList<>();
			item = stockService.getItemNames();

			
			request.setAttribute("item1", item);		
			
			List<Stocks> l = new ArrayList<>();
			l = stockService.getStock();
			request.setAttribute("stockList", l);
			
			
			if (("search").equals(actionsearch)) {
				List<Stocks> h = new ArrayList<>();
				h =	stockService.searchStock(request);
				request.setAttribute("SearchedstockList", h);
				page = "pages/searchedStocks.jsp";
				System.out.println(h);
				for (Stocks s:h){
					System.out.println(s.getStockId()+ ", " + s.getSupplyId() + ", " + s.getQuantity() + ", " + s.getRefNo() +  ", " + s.getDateAdded() + ", " + s.getPurchaseDate() + ", " + s.getLastUser() + ", " + s.getLastUpdate());
				}
			}
			
			
			if (("save").equals(actionsave)) {
				stockService.insertStock(request);
			}
			
			if (("update").equals(actionupdate)) {
				stockService.updateStock(request);
			}
			

			
		
			if ((("backToStock").equals(actionback)) && (actionback != null)) {
				page = "pages/stocks.jsp";				
			} else if ((("goToAdd").equals(actionadd)) && (actionadd != null)) {
				page = "pages/addstocks.jsp";			
			} else if ((("backToHome").equals(actionhome)) && (actionhome != null)) { 
				page = "index.jsp";
			} else if ((("stocks").equals(action)) && (action != null)) { 
				page = "pages/stocks.jsp";
			}
			

		} catch (SQLException e){
			
		}
		 finally {
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		 }
	}
}

