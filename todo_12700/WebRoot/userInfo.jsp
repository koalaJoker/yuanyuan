<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息维护</title>
</head>
<body>
<br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/todo_12700/IndexServlet?method=updateUser">修改</a>
<br>

<center>


<table style='margin-top: 20px' width='400'>
基本信息<br>
<hr width="60%">
<tr>
<th>用户名：&nbsp;&nbsp;${cus_users.user_name}</th>
<th>密码：&nbsp;&nbsp;${cus_users.password}</th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>性别：&nbsp;&nbsp;
<c:if test="${cus_users.sex=='F'}">女</c:if>
<c:if test="${cus_users.sex=='M'}">男</c:if>
</th>
<th>年龄：&nbsp;&nbsp;${cus_users.age}</th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>电话号码：&nbsp;&nbsp;${cus_users.phone_number}</th>
</tr>
</table>
<br><br><br>
<table style='margin-top: 20px' width='400'>
其他信息<br>
<hr width="60%">
<tr>
<th>创建时间：</th>
<th>${cus_users.creation_date}</th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>修改时间：</th>
<th>${cus_users.last_update_date}</th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>备注：</th>
<th>${cus_users.comments}</th>
</tr>
</table>
</center>
</body>
</html>