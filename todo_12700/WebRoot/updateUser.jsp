<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
    //创建AJAX异步对象
    function createAJAX(){
        var ajax = null;
        try{
            //如果IE5=IE12的话
            ajax = new ActiveXObject("microsoft.xmlhttp");
        }catch(e1){
            try{
                //如果是非IE的话
                ajax = new XMLHttpRequest();
            }catch(e2){
                alert("你的浏览器中不支持异步对象，请换浏览器");
            }
        }
        return ajax;
    }
</script>
	<script type="text/javascript">
	function check(){
	var username=$("#user_name").val();
	var password=$("#password").val();
	if(username==""){
		$("#span").text("用户名不能为空");
		return false;
	}
	if(password==""){
		$("#span").text("密码不能为空");
		return false;
	}
	else{
		 //NO1)创建AJAX异步对象
	       var ajax = createAJAX();
	       //NO2)准备发送请求
	       var method = "GET";
	       var url = "${pageContext.request.contextPath}/Cus_usersServlet?method=update&username="+username+"&time=" + new Date().getTime();
	       ajax.open(method,url);
	       //NO3)真正发送请求体的数据到服务器，如果请求体中无数据的话，就用null表示
	       ajax.send(null);
	       //-------------------------------------------------------------等待
	       ajax.onreadystatechange = function(){
	       	
	           if(ajax.readyState == 4){
	          	
	               if(ajax.status == 200){
	                   //NO5)
	                
	                   var tip = ajax.responseText;
	                  
	                   //alert(tip);
	                   if(tip==0){
	                	return true;
	                
	                   }
	                   if(tip==1){
	                	   $("#span").text("用户名已存在！");
	                	return false;
	                   }
	                  
	                 }
	           
	           }
		 

}
	}
	}
	</script>
</head>
<body>
	<br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br>
<form action="/todo_12700/IndexServlet?method=toUpdate" method="post" onsubmit="return check()">
<center>
<table style='margin-top: 20px' width='400'>
基本信息<br>
<hr width="60%">
<tr>
<th>用户名：&nbsp;&nbsp;<input type="text" id="user_name"  name="user_name" value="${cus_users.user_name}" /></th>
<th>密码：&nbsp;&nbsp;<input type="text"  id="password" name="password" value="${cus_users.password}"/></th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>性别：&nbsp;&nbsp;
<c:if test="${cus_users.sex=='F'}">
				<input type="radio" name="sex" checked="checked" value="F"/>女
					<input type="radio" name="sex" value="M"/>男
					</c:if>
					<c:if test="${cus_users.sex=='M'}">
				<input type="radio" name="sex"  value="F"/>女
					<input type="radio" name="sex" checked="checked" value="M"/>男
					</c:if></th>
<th>年龄：&nbsp;&nbsp;<input type="text" name="age" value="${cus_users.age}"/></th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>电话号码：&nbsp;&nbsp;<input type="text" name="phone_number" value="${cus_users.phone_number}"/></th>
</tr>
</table>
<br><br><br>
<table style='margin-top: 20px' width='400'>
其他信息<br>
<hr width="60%">
<tr>
<th>创建时间：</th>
<th><input type="text" disabled="disabled" name="creation_date" value="${cus_users.creation_date}"/></th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>修改时间：</th>
<th><input type="text"  disabled="disabled" name="last_update_date" value="${cus_users.last_update_date}"/></th>
</tr>
<tr><th></th><th></th></tr>
<tr><th></th><th></th></tr>
<tr>
<th>备注：</th>
<th><input type="text" name="comments" value="${cus_users.comments}"/></th>
</tr>
</table>
</center>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />&nbsp;&nbsp;
			<input type="button" value="取消" onclick="history.go(-1)">
		</div>
		<div>
		<center><span style="color: red" id="span"></span></center>
		</div>
	</form>
</body>
</html>