<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加事项</title>
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
<form action="/todo_12700/IndexServlet" method="post" onsubmit="return check()">
	<input name="method" value="addItem" type="hidden" ><br>
	<h2 align="center">新增事项</h2>
		<table align="center" border="0px" style="margin-top: 20px"
			width="300">		
			<tr align="center">
				<td>标题</td>
				<td><input id="title" type="text" name="todo_item_title"/></td>
			</tr>
			<tr align="center">
				<td>内容</td>
				<td><input type="text" name="todo_item_content"/></td>
			</tr>
			<tr align="center">
				<td>优先级</td>
			<td>
				<input type="radio" name="priotity" checked="checked" value="LOW"/>低
				<input type="radio" name="priotity" value="MEDIUM"/>中
				<input type="radio" name="priotity" value="HIGH"/>高
			</td>
			</tr>
			<tr align="center">
				<td>备注</td>
				<td><input type="text" name="comments" /></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />
			<input type="button" value="取消" onclick="history.go(-1)"><br>
			<span id="span" style="color: red;"></span>
		</div>
	</form>
</body>
</html>