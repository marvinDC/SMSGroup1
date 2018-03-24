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

import com.sms.maintenance.entity.Users;
import com.sms.maintenance.service.UsersService;


public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3254083445269926470L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			String page = "pages/listing.jsp";
	 		String action = request.getParameter("action");
	 		List<Users> l = new ArrayList<>();
	 		HttpSession session = request.getSession();
	 		
	 		ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/maintenance/resource/applicationContext.xml");
			UsersService useService = 
					(UsersService) applicationContext.getBean("userService");
			
	 		if(action != null && action.equals("save")){
	 			useService.insertUser(request);
			
	 		}else if(action != null && action.equals("save1")){
	 			useService.updateUser(request);
	 			l = useService.getUser(request);
	 			request.setAttribute("queryList", l);
	 			
	 		}else if(action != null && action.equals("adding")){
	 			page = "pages/adding.jsp";
	 			
	 		}else if(action != null && action.equals("changepass")){
	 			String password = request.getParameter("currentPass");
	 			System.out.println(password);
	 			session.setAttribute("password", password);
	 			
	 			page = "pages/changePass.jsp";
	 			
	 		}else if(action == null || action.equals("cancel")){
	 			l = useService.getUser(request);
	 			request.setAttribute("queryList", l);
	 			page = "pages/listing.jsp";
	 			
	 		}else if(action.equals("search")){
	 			l = useService.getUser(request);
	 			
	 			request.setAttribute("querySearch", l);
	 			page = "pages/listing.jsp";
	 		}else if(action.equals("savePW")){
	 			
	 			System.out.println("if savePW");
	 			useService.updateUser(request);
	 			l = useService.getUser(request);
	 			request.setAttribute("queryList", l);
	 			page = "pages/listing.jsp";
	 		}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
