<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='/todo_12700/addItem.jsp'>新增</a>
	<table align='center' border='1px' style='margin-top: 20px' width='700' height='250'>
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>内容</th>
			<th>优先级</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
         <c:forEach items="${list}" var="contact" varStatus="c">
			<tr>
				<td>${c.count}</td>
				<td>${contact.todo_item_title}</td>
				<td>${contact.todo_item_content}</td>
				<td>
				<c:if test="${contact.priotity=='LOW'}">低</c:if>
				<c:if test="${contact.priotity=='MEDIUM'}">中</c:if>
				<c:if test="${contact.priotity=='HIGH'}">高</c:if>
				</td>
				<td>${contact.creation_date}</td>
				<td>${contact.last_update_date}</td>
				<td>${contact.comments}</td>
				<td><a href='/todo_12700/IndexServlet?method=updateItem&id=${contact.todo_item_id}'>修改</a>&nbsp;<a
					href='/todo_12700/IndexServlet?method=deleteItem&id=${contact.todo_item_id}'  onClick="return confirm('确定要删除?')">删除</a></td>
			</tr>
		</c:forEach>
	<tr>
		<!--<td colspan="8" align="center">
		   <a href="/Contact4.0/IndexServlet?current=${1}">首页</a>
			 <c:if test="${PageBean.current>1}">
				<a href="/Contact4.0/IndexServlet?current=${PageBean.current-1}">上一页</a>
			</c:if>
			 <c:if test="${PageBean.current<PageBean.total}">
				<a href="/Contact4.0/IndexServlet?current=${PageBean.current+1}">下一页</a>
			</c:if> 
			<a href="/Contact4.0/IndexServlet?current=${PageBean.total}">尾页</a>
		</td>-->
	</tr>
	</table>
</body>
</html>