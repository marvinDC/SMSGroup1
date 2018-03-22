package com.sms.maintenance.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.maintenance.entity.Users;
import com.sms.maintenance.service.UsersService;


public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3254083445269926470L;

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("/com/sms/maintenance/resource/applicationContext.xml");
			
			UsersService useService = 
					(UsersService) applicationContext.getBean("userService");
			
			System.out.println("tryportion");
			
			List<Users> l = new ArrayList<>();
			
			l = useService.getUser();
			System.out.println("use get user");
			useService.insertUser();
			for (Users e:l){
				System.out.println(e.getFirstName() + ", " + e.getUserId() + ", " + e.getPassWord() + ", " + e.getEntryDate());
			}
			
		} catch (SQLException e){
			
		}
	}
}
