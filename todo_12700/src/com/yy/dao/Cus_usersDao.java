package com.yy.dao;

import com.yy.entity.Cus_users;



public interface Cus_usersDao {
//通过用户名查找用户
	public Cus_users findCus_users(String username);
	//修改用户信息
	public void  updateUser(Cus_users cus_users);
}
