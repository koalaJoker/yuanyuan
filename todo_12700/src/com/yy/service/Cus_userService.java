package com.yy.service;

import com.yy.dao.Cus_usersDao;
import com.yy.dao.impl.Cus_usersDaoImpl;
import com.yy.entity.Cus_users;

public interface Cus_userService {
	
	
	
	public Cus_users findCus_users(String username);
	
	//修改用户信息
		public void  updateUser(Cus_users cus_users);
}
