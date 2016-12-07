package com.yy.service;

import java.util.List;

import com.yy.entity.Cux_items;

public interface Cux_itemsService {
	//通过userid查找到所有事项
		public List<Cux_items> findItems(int userid);
		//通过id拿到数据
		public Cux_items findTtemsById(int id);
		//修改
		public void updateItem(Cux_items cux_items);
		//删除
		public void deleteItem(int id);
		//增加
		public void addItem(Cux_items cux_items);
}
