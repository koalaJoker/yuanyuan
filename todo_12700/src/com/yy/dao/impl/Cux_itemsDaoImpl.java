package com.yy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yy.dao.Cux_itemsDao;
import com.yy.entity.Cux_items;
import com.yy.utils.ComPoolUtils;

public class Cux_itemsDaoImpl implements Cux_itemsDao{

	@Override
	public List<Cux_items> findItems(int userid) {
		List<Cux_items> list=null;
		try {
			list=ComPoolUtils.getQueryRunner().query("select * from cux_todo_items where user_id=?", 
					new BeanListHandler<Cux_items>(Cux_items.class),userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cux_items findTtemsById(int id) {
		Cux_items cux_items=null;
		try {
			cux_items=ComPoolUtils.getQueryRunner().query("select * from cux_todo_items where todo_item_id=?",
					new BeanHandler<Cux_items>(Cux_items.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cux_items;
	}

	@Override
	public void updateItem(Cux_items cux_items) {
		try {
			
			int i=ComPoolUtils.getQueryRunner().update("update cux_todo_items set todo_item_title=?,todo_item_content=?,priotity=?,last_update_date=?,comments=? where todo_item_id=?", 
					cux_items.getTodo_item_title(),cux_items.getTodo_item_content(),cux_items.getPriotity(),cux_items.getLast_update_date(),cux_items.getComments(),cux_items.getTodo_item_id());
			System.out.println("影响"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteItem(int id) {
		try {
			ComPoolUtils.getQueryRunner().update("delete from cux_todo_items where todo_item_id=?",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addItem(Cux_items cux_items) {
		
		try {
			ComPoolUtils.getQueryRunner().update("insert into cux_todo_items(user_id,todo_item_title,todo_item_content,priotity,creation_date,comments) values(?,?,?,?,?,?)",
					
					cux_items.getUser_id(),cux_items.getTodo_item_title(),cux_items.getTodo_item_content(),cux_items.getPriotity(),cux_items.getCreation_date(),cux_items.getComments());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
