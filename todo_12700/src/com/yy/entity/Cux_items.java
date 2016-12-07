package com.yy.entity;

import java.util.Date;

public class Cux_items {

private int todo_item_id;
//属主用户id
private int user_id;
//标题
private String todo_item_title;
//内容
private String todo_item_content;
//优先级                  
private String  priotity;
//创建时间
private Date creation_date;
//更新时间
private Date last_update_date;
//备注
private String comments;
public Cux_items() {
	super();
	// TODO Auto-generated constructor stub
}
public Cux_items(int todo_item_id, int user_id, String todo_item_title,
		String todo_item_content, String priotity, Date creation_date,
		Date last_update_date, String comments) {
	super();
	this.todo_item_id = todo_item_id;
	this.user_id = user_id;
	this.todo_item_title = todo_item_title;
	this.todo_item_content = todo_item_content;
	this.priotity = priotity;
	this.creation_date = creation_date;
	this.last_update_date = last_update_date;
	this.comments = comments;
}
public int getTodo_item_id() {
	return todo_item_id;
}
public void setTodo_item_id(int todo_item_id) {
	this.todo_item_id = todo_item_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getTodo_item_title() {
	return todo_item_title;
}
public void setTodo_item_title(String todo_item_title) {
	this.todo_item_title = todo_item_title;
}
public String getTodo_item_content() {
	return todo_item_content;
}
public void setTodo_item_content(String todo_item_content) {
	this.todo_item_content = todo_item_content;
}

public String getPriotity() {
	return priotity;
}
public void setPriotity(String priotity) {
	this.priotity = priotity;
}
public Date getCreation_date() {
	return creation_date;
}
public void setCreation_date(Date creation_date) {
	this.creation_date = creation_date;
}
public Date getLast_update_date() {
	return last_update_date;
}
public void setLast_update_date(Date last_update_date) {
	this.last_update_date = last_update_date;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}

}
