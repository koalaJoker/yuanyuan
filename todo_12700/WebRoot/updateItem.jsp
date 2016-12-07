<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>

<script type="text/javascript">
function check(){
	var title=$("#title").val();
	if(title==""){
		$("#span").text("请输入标题：");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<form action="/todo_12700/IndexServlet?method=updateToItem" method="post" onsubmit="return check();">
	<input name="user_id" value="${cux_items.user_id}" type="hidden">

	<input name="todo_item_id" value="${cux_items.todo_item_id}" type="hidden"><br>
	  <h2 align="center">修改事项</h2>
		<table align="center" border="1px" style="margin-top: 40px"
			width="300">		
			<tr align="center">
				<td>标题</td>
				<td><input id="title" type="text" name="todo_item_title"
					value="${cux_items.todo_item_title}" /></td>
			</tr>
			<tr align="center">
				<td>内容</td>
				<td><input type="text" name="todo_item_content"
					value="${cux_items.todo_item_content}" /></td>
			</tr>
			<tr align="center">
				<td>优先级</td>
				<td>
				<c:if test="${cux_items.priotity=='LOW'}">
				<input type="radio" name="priotity" checked="checked" value="LOW"/>低
					<input type="radio" name="priotity"
					value="MEDIUM"/>中
					<input type="radio" name="priotity"
					value="HIGH"/>高
					</c:if>
					<c:if test="${cux_items.priotity=='MEDIUM'}">
				<input type="radio" name="priotity"  value="LOW"/>低
					<input type="radio" name="priotity" checked="checked" value="MEDIUM"/>中
					<input type="radio" name="priotity" value="HIGH"/>高
					</c:if>
					<c:if test="${cux_items.priotity=='HIGH'}">
				<input type="radio" name="priotity"  value="LOW"/>低
					<input type="radio" name="priotity"
					value="MEDIUM"/>中
					<input type="radio" name="priotity" value="HIGH" checked="checked"/>高
					</c:if>
					</td>
			</tr>
			<tr align="center">
				<td>备注</td>
				<td><input type="text" name="comments"
					value="${cux_items.comments}" /></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />&nbsp;&nbsp;
			<input type="button" value="取消" onclick="history.go(-1)"><br>
		<span id="span" style="color: red;"></span>
		</div>
	</form>
</body>
</html>