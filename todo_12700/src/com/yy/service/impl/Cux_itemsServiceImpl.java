package com.yy.service.impl;

import java.util.List;

import com.yy.dao.Cux_itemsDao;
import com.yy.dao.impl.Cux_itemsDaoImpl;
import com.yy.entity.Cux_items;
import com.yy.service.Cux_itemsService;

public class Cux_itemsServiceImpl implements Cux_itemsService{

	Cux_itemsDao dao=new Cux_itemsDaoImpl();
	
	@Override
	public List<Cux_items> findItems(int userid) {
		
		return dao.findItems(userid);
	}

	@Override
	public Cux_items findTtemsById(int id) {
		
		return dao.findTtemsById(id);
	}

	@Override
	public void updateItem(Cux_items cux_items) {
		dao.updateItem(cux_items);
		
	}

	@Override
	public void deleteItem(int id) {
		dao.deleteItem(id);
		
	}

	@Override
	public void addItem(Cux_items cux_items) {
		dao.addItem(cux_items);
	}

}
