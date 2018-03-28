package com.sms.maintenance.servlet;

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
import com.sms.maintenance.entity.Users;
import com.sms.maintenance.service.UsersService;


public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3254083445269926470L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			String page = "pages/maintenancePage.jsp";
	 		String action = request.getParameter("action");
	 		List<Users> l = new ArrayList<>();
	 		HttpSession session = request.getSession();
	 	
	 		ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/maintenance/resource/applicationContext.xml");
			UsersService useService = 
					(UsersService) applicationContext.getBean("userService");
			
	 		if(action != null && action.equals("saveAdded")){
	 			useService.insertUser(request);
	 			page = "pages/addingPage.jsp";
	 		
	 		}else if(action != null && action.equals("saveUpdate")){
	 			useService.updateUser(request);
	 			l = useService.getUser(request);
	 			request.setAttribute("queryList", l);
	 		
	 			//this is for the update of users//
	 		}else if(action != null && action.equals("saveUserChanges")){
	 			useService.updateUser(request);
	 			
	 			page = "pages/userPage.jsp";
	 			
	 		}else if(action != null && action.equals("addingPage")){
	 			page = "pages/addingPage.jsp";
	 			
	 		}else if(action != null && action.equals("changepass")){
	 			page = "pages/changePass.jsp";
	 			
	 		}else if(action == null || action.equals("cancel") || action.equals("cancelUserPage")){
	 			User currentUser = (User)session.getAttribute("currentUser");
	 			if(currentUser.getAccessLevel().equals("U")){
	 				page = "pages/home.jsp";
	 				
	 			}else{
	 				
	 				l = useService.getUser(request);
		 			request.setAttribute("queryList", l);
		 			page = "pages/maintenancePage.jsp";
	 			}
	 			
	 		}else if(action.equals("cancelMaintenance")){
	 			page = "pages/home.jsp";
	 			
	 		}else if(action.equals("search")){
	 			l = useService.getUser(request);
	 			
	 			request.setAttribute("querySearch", l);
	 			page = "pages/maintenancePage.jsp";
	 			
	 		}else if(action.equals("savePW")){
	 			useService.updateUser(request);
	 			page = "pages/changePass.jsp";
	 			
	 		}else if(action.equals("userPage")){
	 			page = "pages/userPage.jsp";
	 		}
	 		
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
