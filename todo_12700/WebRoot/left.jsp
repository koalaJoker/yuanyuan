<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
<h3 align="center">菜单</h3><br>

<ul id="Menu">
	    <li >
            <ul>
            	<li>
                    <a target="right" href="${pageContext.request.contextPath}/IndexServlet?method=itemsInfo">代办事项列表</a>
				</li><br>
                <li>
                	<a target="right" href="${pageContext.request.contextPath}/IndexServlet?method=userInfo">个人信息维护</a>
				</li>
                
            </ul>
        </li>
        </ul>
</body>
</html>