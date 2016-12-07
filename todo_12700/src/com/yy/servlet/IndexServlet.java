package com.yy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.entity.Cus_users;
import com.yy.entity.Cux_items;
import com.yy.service.Cus_userService;
import com.yy.service.Cux_itemsService;
import com.yy.service.impl.Cus_userServiceImpl;
import com.yy.service.impl.Cux_itemsServiceImpl;

public class IndexServlet extends HttpServlet {

	Cus_userService cus=new Cus_userServiceImpl();
	Cux_itemsService cux=new Cux_itemsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("index")) {
			index(request, response);
		}else if(method.equals("itemsInfo")){
			itemsInfo(request, response);} 
		else if(method.equals("updateItem")){
			updateItem(request, response);
		}else if(method.equals("updateToItem")){
			updateToItem(request, response);
		}else if(method.equals("deleteItem")){
			deleteItem(request, response);
		}else if(method.equals("addItem")){
			addItem(request, response);
		}else if(method.equals("userInfo")){
			userInfo(request, response);
		}else if(method.equals("updateUser")){
			updateUser(request, response);
		}else if(method.equals("toUpdate")){
			toUpdate(request, response);}
		
	}
	private void toUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Cus_users cus_users=new Cus_users();
		cus_users.setUser_id(((Integer)request.getSession().getAttribute("userid")));
		String username=request.getParameter("user_name");
		request.getSession().setAttribute("username", username);
		cus_users.setUser_name(username);
		cus_users.setPassword(request.getParameter("password"));
		cus_users.setSex(request.getParameter("sex"));
		cus_users.setAge(Integer.parseInt(request.getParameter("age")));
		cus_users.setPhone_number(request.getParameter("phone_number"));
		cus_users.setComments(request.getParameter("comments"));
		cus_users.setLast_update_date(new Date());
		cus.updateUser(cus_users);
		userInfo(request,response);
		
	}


	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) {
		String username=(String)request.getSession().getAttribute("username");
		Cus_users cus_user=cus.findCus_users(username);
		request.setAttribute("cus_users",cus_user);
		try {
			request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void userInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String username=(String)request.getSession().getAttribute("username");
		Cus_users cus_users=cus.findCus_users(username);
		request.setAttribute("cus_users",cus_users);
		try {
			request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		//System.out.println("YONGHUM "+username);
		int userid=cus.findCus_users(username).getUser_id();
		request.getSession().setAttribute("userid",userid);
		request.getSession().setAttribute("username",username);
		try {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addItem(HttpServletRequest request,
			HttpServletResponse response) {

		String todo_item_title = request.getParameter("todo_item_title");
		System.out.println(todo_item_title);
		String todo_item_content = request.getParameter("todo_item_content");
		String priotity = request.getParameter("priotity");
		String comments = request.getParameter("comments");
		Cux_items cux_items=new Cux_items();
		cux_items.setTodo_item_title(todo_item_title);
		cux_items.setTodo_item_content(todo_item_content);
		cux_items.setPriotity(priotity);
		cux_items.setCreation_date(new Date());
		cux_items.setComments(comments);
		int user_id=(Integer)request.getSession().getAttribute("userid");
		cux_items.setUser_id(user_id);
		cux.addItem(cux_items);
		List<Cux_items> list =cux.findItems(user_id);
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteItem(HttpServletRequest request,
			HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		cux.deleteItem(id);
		int userid= (Integer)request.getSession().getAttribute("userid");
		List<Cux_items> list =cux.findItems(userid);
		request.setAttribute("list",list);
		
	}

	private void updateToItem(HttpServletRequest request,
			HttpServletResponse response) {
		String todo_item_id = request.getParameter("todo_item_id");
		System.out.println("id"+todo_item_id);
		String user_id = request.getParameter("user_id");
		String todo_item_title = request.getParameter("todo_item_title");
		String todo_item_content = request.getParameter("todo_item_content");
		String priotity = request.getParameter("priotity");
		String comments = request.getParameter("comments");
		Cux_items cux_items=new Cux_items();
		cux_items.setTodo_item_id(Integer.parseInt(todo_item_id));
		cux_items.setTodo_item_title(todo_item_title);
		cux_items.setTodo_item_content(todo_item_content);
		cux_items.setPriotity(priotity);
		cux_items.setLast_update_date(new Date());
		cux_items.setComments(comments);
		cux.updateItem(cux_items);
		List<Cux_items> list =cux.findItems(Integer.parseInt(user_id));
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateItem(HttpServletRequest request,
			HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		Cux_items cux_items=cux.findTtemsById(id);
		request.setAttribute("cux_items",cux_items);
		try {
			request.getRequestDispatcher("/updateItem.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void itemsInfo(HttpServletRequest request,
			HttpServletResponse response) {
		int userid=(Integer)request.getSession().getAttribute("userid");
		List<Cux_items> list =cux.findItems(userid);
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doGet(request,response);
	
	}

}
