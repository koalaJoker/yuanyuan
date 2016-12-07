<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	function login(){
		var userVal=$("#user").val();
		var pswVal=$("#psw").val();
		if(userVal==""){
			$("#show").text("用户名不能为空！");
			return false;
		}
		
		if(pswVal==""){
			$("#show").text("密码不能为空！");
		return false;
		}
		else{
			  //NO1)创建AJAX异步对象
		       var ajax = createAJAX();
		       //NO2)准备发送请求
		       var method = "GET";
		       var url = "${pageContext.request.contextPath}/Cus_usersServlet?method=login&username="+userVal+"&password="+pswVal+"&time=" + new Date().getTime();
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
		                	   $("#show").text("密码错误！");
		                
		                   }
		                   if(tip==1){
		                	   $("#show").text("用户名不存在！");
		                	
		                   }
		                   if(tip==2){
		                	   location.href="/todo_12700/IndexServlet?method=index&username="+userVal;
		     			  
		                   }
		                 }
		           
		           }
		       } 
		       return true; 
			 
		  }
}
	</script>
  </head>
  
  <body>
  <h1 align="center">个人代办事项管理系统</h1></br>
<form  method="post" >
<div align="center">用户名：<input id="user" name="username" type="text"></div></br></br>
<div align="center">密码：<input id="psw" name="password" type="password"></div></br></br>
<div align="center">
     <input type="button" onclick="login()" value="登陆" >&nbsp;
     <input type="reset" value="重置">
</div>
</br>
<div align="center"><span  id="show" style="color: red"></span></div>
</form>
  </body>
</html>
