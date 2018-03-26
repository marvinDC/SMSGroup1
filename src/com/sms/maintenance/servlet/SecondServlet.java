package com.sms.maintenance.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3485668769556795283L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
 		String page = "pages/listing.jsp";
 		String action = request.getParameter("action");
 		
 		if(action != null && action.equals("adding")){
 			page = "pages/adding.jsp";
 		}else if(action != null && action.equals("changepass")){
 			page = "pages/changePass.jsp";
 		}else if(action != null && action.equals("cancel")){
 			page = "pages/listing.jsp";
 		}
 		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
		
}
