package com.sms.homeandlogin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import com.sms.homeandlogin.service.UserService;

public class HomeAndLogin extends HttpServlet{

	private static final long serialVersionUID = -740594152785089541L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("loginError", null);
		String page = "index.jsp";
		
		request.setAttribute("currentUser", session.getAttribute("currentUser"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String page = "index.jsp";

		if ("login".equals(action)) {
			Integer loginAttempt = (session.getAttribute("loginAttempt") == null) ? 0:(int) session.getAttribute("loginAttempt");
			List<User> resultUser = new ArrayList<>();
			try{
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("/com/sms/homeandlogin/resource/ApplicationContext.xml");
				
				UserService userService = (UserService) applicationContext.getBean("userService");
				resultUser = userService.findUser(request);
				
				if (resultUser.size() > 0) {
					session.setAttribute("loginAttempt", 0);
					userService.updateLastLogin(request);
					if ("Y".equals(resultUser.get(0).getActiveTag())) {
						session.setAttribute("loginError", null);
						session.setAttribute("currentUser", resultUser.get(0));
						request.setAttribute("currentUser", resultUser.get(0));
					}
					else
						session.setAttribute("loginError", "Your account is currently locked. Please contact the administrator.");
				} else {
					loginAttempt++;
					if (loginAttempt >= 3) {
						userService.removeAccess(request);
						session.setAttribute("loginAttempt", 0);
						session.setAttribute("loginError", "Maximum attempt reach, your account has been locked.\n Please contact the administrator.");
					} else {
						session.setAttribute("loginAttempt", loginAttempt);
						session.setAttribute("loginError", "Invalid user id and password.\n Login attempt left " + loginAttempt + ".");
					}
					
				}
			} catch (SQLException e){
				System.out.println(e.getMessage());
				session.setAttribute("loginError", "Something went wrong, please try again.");
			}
		} else if ("logout".equals(action)) {
			session.invalidate();
			page = "pages/main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
