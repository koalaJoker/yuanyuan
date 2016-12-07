package com.yy.entity;

import java.util.Date;

public class Cus_users {
//用户id
private int user_id;
//用户名称
private String user_name;
//用户密码
private String password;
//性别
private String sex;
//年龄
private int age;
//电话
private String  phone_number;
//创建时间
private Date creation_date;
//更新时间
private Date last_update_date;
//备注
private String comments;

public Cus_users() {
	super();
	// TODO Auto-generated constructor stub
}
public Cus_users(int user_id, String user_name, String password, String sex, int age, String phone_number,
		Date creation_date, Date last_update_date, String comments) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	this.sex = sex;
	this.age = age;
	this.phone_number = phone_number;
	this.creation_date = creation_date;
	this.last_update_date = last_update_date;
	this.comments = comments;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
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
