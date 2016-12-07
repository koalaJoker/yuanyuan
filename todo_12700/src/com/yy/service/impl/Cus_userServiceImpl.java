package com.yy.service.impl;

import com.yy.dao.Cus_usersDao;
import com.yy.dao.impl.Cus_usersDaoImpl;
import com.yy.entity.Cus_users;
import com.yy.service.Cus_userService;

public class Cus_userServiceImpl implements Cus_userService{

	
	Cus_usersDao cu=new Cus_usersDaoImpl();
	@Override
	public Cus_users findCus_users(String username) {
		
		return cu.findCus_users(username);
	}
	@Override
	public void updateUser(Cus_users cus_users) {
	 
		cu.updateUser(cus_users);
		
	}

}
