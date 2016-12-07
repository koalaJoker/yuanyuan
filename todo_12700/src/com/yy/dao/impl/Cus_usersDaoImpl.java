package com.yy.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yy.dao.Cus_usersDao;
import com.yy.entity.Cus_users;
import com.yy.utils.ComPoolUtils;

public class Cus_usersDaoImpl implements Cus_usersDao{

	@Override
	public Cus_users findCus_users(String username){
		Cus_users users=null;
			try {
				users = ComPoolUtils.getQueryRunner().query("select * from Cus_users where user_name=?",new BeanHandler<Cus_users>(Cus_users.class),username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return users;

}

	@Override
	public void updateUser(Cus_users cus_users) {
		
		try {
		ComPoolUtils.getQueryRunner().update("update  cus_users set user_name=?,password=?,sex=?,age=?,phone_number=?,last_update_date=?,comments=? where user_id=?", 
				cus_users.getUser_name(),cus_users.getPassword(),cus_users.getSex(),cus_users.getAge(),cus_users.getPhone_number(),cus_users.getLast_update_date(),cus_users.getComments(),cus_users.getUser_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}