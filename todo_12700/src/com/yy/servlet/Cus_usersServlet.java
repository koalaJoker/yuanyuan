package com.yy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.dao.Cus_usersDao;
import com.yy.dao.impl.Cus_usersDaoImpl;
import com.yy.entity.Cus_users;
import com.yy.service.Cus_userService;
import com.yy.service.impl.Cus_userServiceImpl;

public class Cus_usersServlet extends HttpServlet {

	Cus_userService cus=new Cus_userServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("login")){
			login(request,response);
		}else if(method.equals("update")){
			update(request,response);
		}
	  
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		Cus_users cus_users=cus.findCus_users(username);
		String user_name=(String)request.getSession().getAttribute("username");
		Cus_users cususers=cus.findCus_users(user_name);
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cus_users!=null&&(cususers.getUser_name()!=username)){
			pw.write("1");
		}else{
			pw.write("0");
		}
		pw.flush();
		pw.close();
	}


	private void login(HttpServletRequest request, HttpServletResponse response) {
		 String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Cus_userService cs=new Cus_userServiceImpl();
			Cus_users user=cs.findCus_users(username);
			if(user==null){
				pw.write("1");
			}else if(!user.getPassword().equals(password)){
				pw.write("0");
			}else{
				
				pw.write("2");
			}
			pw.flush();
			pw.close();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doGet(request,response);
	}

	
}
