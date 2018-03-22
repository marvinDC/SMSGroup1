package com.sms.homeandlogin.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.maintenance.entity.Users;

public class HomeAndLogin extends HttpServlet{

	private static final long serialVersionUID = -740594152785089541L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String page = "index.jsp";
		
		if (session.getAttribute("currentUser") != null)
			request.setAttribute("currentUser", session.getAttribute("currentUser"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String page = "index.jsp";

		if ("login".equals(action)) {
			// dummy user replace this!!! add validation!!!
			Users currentUser = new Users("admin", "admin", "admin", "admin", "admin@gmail.com", "A", "Y", "A", new Date(), new Date(), "admin");
			request.setAttribute("currentUser", currentUser);
			page = "pages/main.jsp";
		} else if ("logout".equals(action)) {
			session.invalidate();
			page = "pages/main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
